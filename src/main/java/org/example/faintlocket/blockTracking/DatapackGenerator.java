package org.example.faintlocket.blockTracking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;

public class DatapackGenerator {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static final MaterialTree MATERIAL_TREE = new MaterialTree();

    private static final String dataPackName = "testpack";
    private static final String datapackDescription = "This is the description of your data pack";
    private static final String datapackNamespace = "item_tracking";
    private static final int packFormat = 61;
    private static Logger LOGGER;

    public static String GetDatapackNamespace() {
        return datapackNamespace;
    }

    public static void GenerateJSON(CommandSender sender, BlockTracking plugin) {
        sender.sendPlainMessage("Generating JSON");

        // Create the datapack folder and put it in the plugin folder.
        // Then delete any existing files there.
        DatapackGenerator.LOGGER = plugin.getLogger();
        File pluginDataPackFolder = new File(plugin.getDataFolder(), dataPackName);
        if (pluginDataPackFolder.exists()) {
            try {
                DeleteFolder(pluginDataPackFolder);
            } catch (IOException e) {
                String errMsg = "Failed to delete data pack folder: %s".formatted(e.getMessage());
                sender.sendMessage(errMsg);
                plugin.getLogger().severe(errMsg);
                return;
            }
        }

        // Creating the folders needed for a datapack.
        // {packName}/data/{namespace}/advancement
        File dataFolder = new File(pluginDataPackFolder.getAbsolutePath(), "data");
        File namespaceFolder = new File(dataFolder.getAbsolutePath(), datapackNamespace);
        File advancementFolder = new File(namespaceFolder.getAbsolutePath(), "advancement");

        // Write the metadata into the top level of the datapack.
        try {
            WritePackMCMeta(pluginDataPackFolder);
        } catch (IOException e) {
            String errMsg = "Error generating pack.mcmeta: %s".formatted(e.getMessage());
            sender.sendMessage(errMsg);
            plugin.getLogger().severe(errMsg);
            return;
        }

        AtomicInteger advancementsCreated = new AtomicInteger();
//        MATERIAL_TREE.getRoot().traverse(node -> {
////            Material material = node.getData();
////            TreeNode parent = node.getParent();
////
////            WriteMaterialJSON(material, parent.getData(), advancementFolder, sender);
//
//            var options = new AdvancementOptions();
//
//            WriteMaterialJSON(options, advancementFolder, sender);
//            advancementsCreated.getAndIncrement();
//        });
//
//        Set<Material> missing = findMissingMaterials(MATERIAL_TREE.getRoot());
//
//        if (!missing.isEmpty()) {
//            int maxSize = 10;
//
//            plugin.getLogger().info("Found %d missing materials.".formatted(missing.size()));
//            plugin.getLogger().info("Here are the first %d:".formatted(maxSize));
//
//            for (Material material : missing.stream().sorted(Comparator.comparing(Enum::ordinal))
//                .limit(maxSize).toList()) {
//                plugin.getLogger().info("\t- %s".formatted(material.name()));
//            }
//        }

        sender.sendMessage(
            "Generated %s advancements in %s".formatted(
                advancementsCreated,
                pluginDataPackFolder.getAbsolutePath()
            )
        );

        try {
            WriteDataPackToWorld(plugin.getServer(), pluginDataPackFolder);
            sender.sendPlainMessage("Datapack saved successfully.");
        } catch (IOException e) {
            String errMsg = "Error copying datapack to world folder";
            sender.sendMessage(errMsg);
            plugin.getLogger().severe(errMsg);
            return;
        }
    }

    private static void WriteDataPackToWorld(
        Server server,
        File pluginDataPackFolder
    ) throws IOException {
        String worldName = server.getWorlds().getFirst().getName();
        File worldFolder = new File(server.getWorldContainer(), worldName);
        File worldDataPacksFolder = new File(worldFolder, "datapacks");
        File dataPackFolder = new File(worldDataPacksFolder, pluginDataPackFolder.getName());

        if (dataPackFolder.exists()) {
            DeleteFolder(dataPackFolder);
        }

        CopyFolder(
            pluginDataPackFolder.toPath(),
            dataPackFolder.toPath()
        );

        server.dispatchCommand(server.getConsoleSender(), "minecraft:reload");
    }

    private static void CopyFolder(Path source, Path target) throws IOException {
        try (Stream<Path> paths = Files.walk(source)) {
            for (var sourcePath : paths.filter(Files::isRegularFile).toList()) {
                Path targetPath = target.resolve(source.relativize(sourcePath));

                LOGGER.info("Copying %s to %s".formatted(sourcePath.toString(), targetPath.toString()));

                Files.createDirectories(targetPath.getParent());
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    private static void DeleteFolder(File dataPackFolder) throws IOException {
        try (Stream<Path> paths = Files.walk(dataPackFolder.toPath())) {
            List<File> fileStream = paths.sorted(Comparator.reverseOrder())
                .map(Path::toFile).toList();

            for (File file : fileStream) {
                boolean success = file.delete();

                if (!success) {
                    throw new IOException("Failed to delete %s".formatted(file.getAbsolutePath()));
                }
            }
        }
    }

    /**
     * Writes the {@code pack.mcmeta} file to the {@code datapackFolder}.
     *
     * @param datapackFolder The folder where the pack.mcmeta will be written. This should be the
     *                       top level of the datapack.
     * @throws IOException Throws an IOException if it fails to write the file.
     */
    private static void WritePackMCMeta(File datapackFolder) throws IOException {
        // Should look something like:
        /*
        {
            "pack": {
                "description": ...,
                "pack_format": XX
            }
        }
         */
        JsonObject mcmeta = new JsonObject();
        JsonObject packInfo = new JsonObject();
        packInfo.addProperty("description", datapackDescription);
        packInfo.addProperty("pack_format", packFormat);
        mcmeta.add("pack", packInfo);

        WriteJSONFile(mcmeta, datapackFolder, "pack.mcmeta");
    }

    /**
     * Writes a JSON file containing {@code root} into {@code targetDir} with the name
     * {@code fileName}
     * <p>
     * Note that the file name must include the file extension as some json files have different
     * extensions, eg. {@code mcmeta}.
     *
     * @param root      A {@link JsonObject} containing the data to be written.
     * @param targetDir A {@link File}, where the file will be written.
     * @param fileName  A {@link String}, the file name to be used.
     * @throws IOException Throws an IO Exception if it fails to write the JSON file.
     */
    private static void WriteJSONFile(
        JsonObject root,
        File targetDir,
        String fileName
    ) throws IOException {
        String json = GSON.toJson(root);

        File file = new File(targetDir, fileName);
        if (!targetDir.exists()) {
            boolean success = targetDir.mkdirs();

            if (!success) {
                throw new IOException("Failed to create directory: " + targetDir.getAbsolutePath());
            }
        }

        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
