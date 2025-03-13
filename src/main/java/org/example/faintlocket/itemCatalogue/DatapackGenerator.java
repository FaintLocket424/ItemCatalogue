package org.example.faintlocket.itemCatalogue;

import static org.example.faintlocket.itemCatalogue.ItemCatalogue.LOGGER;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.example.faintlocket.itemCatalogue.tree.MaterialTreeManager;
import org.example.faintlocket.itemCatalogue.tree.nodes.MaterialNode;

public class DatapackGenerator {

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

//    private static final MaterialTree MATERIAL_TREE = new MaterialTree();

    private static final String dataPackName = "item_catalogue";
    private static final String datapackDescription =
        "A full item catalogue for " + Bukkit.getServer().getMinecraftVersion();
    private static final String datapackNamespace = "item_catalogue";
    private static final int packFormat = 61;

//    public static String GetDatapackNamespace() {
//        return datapackNamespace;
//    }

    public static void GenerateJSON(CommandSender sender, ItemCatalogue plugin) {
        sender.sendPlainMessage("Generating JSON");

        // Create the datapack folder and put it in the plugin folder.
        // Then delete any existing files there.
        File pluginDataPackFolder = new File(plugin.getDataFolder(), dataPackName);
        if (pluginDataPackFolder.exists()) {
            try {
                DeleteFolder(pluginDataPackFolder);
            } catch (IOException e) {
                String errMsg = "Failed to delete data pack folder: %s".formatted(e.getMessage());
                sender.sendMessage(errMsg);
                LOGGER.severe(errMsg);
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
            LOGGER.severe(errMsg);
            return;
        }

        AtomicInteger advancementsCreated = new AtomicInteger();
        Set<Material> uniqueMaterials = new HashSet<>();

        MaterialTreeManager treeManager = new MaterialTreeManager();

        treeManager.forEach(tree -> {
            tree.getRoot().traverse(node -> {
                try {
                    if (node instanceof MaterialNode mn) {
                        uniqueMaterials.add(mn.getTargetMaterial());
                    }

                    node.writeAdvancementJSON(advancementFolder);
                } catch (IOException e) {
                    String errMsg = "Error generating advancement";
                    sender.sendMessage(errMsg);
                    LOGGER.severe(errMsg);
                }

                advancementsCreated.getAndIncrement();
            });

            tree.verify();
        });

        sender.sendMessage(
            "Generated %d advancements for %d unique materials in %s".formatted(
                advancementsCreated.get(),
                uniqueMaterials.size(),
                pluginDataPackFolder.getAbsolutePath()
            )
        );

        try {
            Server server = plugin.getServer();
            String worldName = server.getWorlds().getFirst().getName();
            File worldFolder = new File(server.getWorldContainer(), worldName);
            WriteDataPackToWorld(pluginDataPackFolder, worldFolder);
            sender.sendPlainMessage("Datapack saved successfully. Reloading server resources.");
            server.dispatchCommand(
                server.getConsoleSender(),
                "minecraft:reload"
            );
        } catch (IOException e) {
            String errMsg = "Error copying datapack to world folder";
            sender.sendMessage(errMsg);
            LOGGER.severe(errMsg);
        }
    }

    /**
     * Copies the datapack into the world files to be loaded.
     *
     * @param oldDataPackFolder The folder that currently contains the datapack.
     * @param worldFolder       The folder which contains all the world files. Should contain a
     *                          "datapacks" folder.
     * @throws IOException Throws an IOException if any of the file copies fail.
     */
    private static void WriteDataPackToWorld(
        File oldDataPackFolder,
        File worldFolder
    ) throws IOException {
        File worldDataPacksFolder = new File(worldFolder, "datapacks");
        File dataPackFolder = new File(worldDataPacksFolder, oldDataPackFolder.getName());

        if (dataPackFolder.exists()) {
            DeleteFolder(dataPackFolder);
        }

        CopyFolder(
            oldDataPackFolder.toPath(),
            dataPackFolder.toPath()
        );
    }

    /**
     * Copies all the files recursively from one directory to another.
     *
     * @param source The source directory to copy from.
     * @param target The target directory to copy to.
     * @throws IOException Throws an IOException if it fails to copy a file, or if the source/target
     *                     directories don't exist.
     */
    private static void CopyFolder(Path source, Path target) throws IOException {
        try (Stream<Path> paths = Files.walk(source)) {
            for (var sourcePath : paths.filter(Files::isRegularFile).toList()) {
                Path targetPath = target.resolve(source.relativize(sourcePath));

                Files.createDirectories(targetPath.getParent());
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    /**
     * Deletes a directory, along with all the files within it.
     *
     * @param folder The folder which will be deleted.
     * @throws IOException Throws an exception if it fails to delete a file, of if the target
     *                     directory doesn't exist.
     */
    private static void DeleteFolder(File folder) throws IOException {
        try (Stream<Path> paths = Files.walk(folder.toPath())) {
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
    public static void WriteJSONFile(
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
