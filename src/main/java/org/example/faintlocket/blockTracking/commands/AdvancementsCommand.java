package org.example.faintlocket.blockTracking.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.command.CommandSender;
import org.example.faintlocket.blockTracking.BlockTracking;
import org.example.faintlocket.blockTracking.DatapackGenerator;

@SuppressWarnings("ALL")
public class AdvancementsCommand {

    public static void RegisterCommand(BlockTracking plugin) {
        plugin.getLifecycleManager()
            .registerEventHandler(LifecycleEvents.COMMANDS, commands -> {

                LiteralCommandNode<CommandSourceStack> blockTrackingCommand =
                    Commands.literal("it")
                            .executes(ctx -> HandleGenerateCommand(ctx, plugin))
                        .build();

                commands.registrar().register(blockTrackingCommand);
            });
    }

    private static int HandleGenerateCommand(CommandContext<CommandSourceStack> ctx, BlockTracking plugin) {

        CommandSender sender = ctx.getSource().getSender();

        DatapackGenerator.GenerateJSON(sender, plugin);

        return Command.SINGLE_SUCCESS;
    }



//    public static Set<Material> findMissingMaterials(TreeNode root) {
//        Set<Material> allMaterials = new HashSet<>(
//            Arrays.asList(Material.values())); // All Materials
//        Set<Material> presentMaterials = new HashSet<>(); // Materials in the tree
//
//        // Traverse the tree and add all present materials to the set
//        root.traverse(node -> presentMaterials.add(node.getData()));
//
//        // Find the difference (missing materials)
//        allMaterials.removeAll(presentMaterials);
//        allMaterials.removeAll(MaterialTree.UNOBTAINIUM);
//
//        allMaterials = allMaterials.stream()
//            .filter(m -> !m.isLegacy())
//            .filter(Material::isItem)
//            .collect(Collectors.toSet());
//
//        return allMaterials;
//    }
//
//    private record AdvancementOptions(
//        // The Material for the icon
//        Material icon,
//        // The advancement name
//        String nameTranslationKey,
//        // The advancement description
//        String description,
//        // Its parent advancement key
//        NamespacedKey parentKey
//        // Its requirements
//    ) {};
//
//    private static void WriteMaterialJSON(
////        TreeNode node,
//        AdvancementOptions options,
//        File advancementFolder,
//        CommandSender sender
//    ) {
//        try {
//            String key = material.getKey().toString();
//            String key_name = material.getKey().getKey();
//
//            String translation_key = material.isRecord()
//                ? "jukebox_song.minecraft." + material.name().substring("MUSIC_DISC_".length())
//                .toLowerCase() :
//                material.isItem()
//                    ? material.getItemTranslationKey()
//                    : material.getBlockTranslationKey();
//
//            String parent_key_name = parent == Material.AIR ? "root" : parent.getKey().getKey();
//
//            JsonObject achObj = getAchievementObject(key, translation_key, parent_key_name);
//
//            String fileName = "%s.json".formatted(key_name);
//
//            WriteJSONFile(achObj, advancementFolder, fileName);
//        } catch (IOException e) {
//            sender.sendMessage(
//                "Error generating advancement for " + material.getKey() + ": "
//                    + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    private static void WriteRootAdvancement(File advancementFolder, CommandSender sender) {
//        JsonObject rootAdv = new JsonObject();
//
//        JsonObject display = new JsonObject();
//        display.addProperty("announce_to_chat", false);
//        display.addProperty("background", "minecraft:textures/block/black_concrete.png");
//        display.addProperty("description", "");
//
//        JsonObject icon = new JsonObject();
//        icon.addProperty("count", 1);
//        icon.addProperty("id", "minecraft:writable_book");
//        display.add("icon", icon);
//
//        display.addProperty("show_toast", false);
//        display.addProperty("title", "Item Catalogue");
//
//        rootAdv.add("display", display);
//
//        JsonObject criteria = new JsonObject();

//        JsonObject tick = new JsonObject();
//        tick.addProperty("trigger", "minecraft:tick");
//        criteria.add("tick", tick);
//
//        rootAdv.add("criteria", criteria);
//
//        try {
//            WriteJSONFile(rootAdv, advancementFolder, "root.json");
//        } catch (IOException e) {
//            sender.sendMessage(
//                "Error generating pack.mcmeta: "
//                    + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//
//    private static JsonObject getAchievementObject(
//        String key,
//        String translation_key,
//        String parent_key_name
//    ) {
//        JsonObject root = new JsonObject();
//        root.addProperty("parent", "%s:%s".formatted(itemTracking, parent_key_name));
//
//        JsonObject display = getDisplayObject(key, translation_key);
//        JsonObject criteria = getCriteriaObject(key, translation_key);
//
//        root.add("display", display);
//        root.add("criteria", criteria);
//        return root;
//    }
//
//    private static JsonObject getCriteriaObject(String key, String key_name) {
//        JsonObject criteria = new JsonObject();
//        JsonObject gotOakPlanks = new JsonObject();
//        gotOakPlanks.addProperty("trigger", "minecraft:inventory_changed");
//
//        JsonObject conditions = new JsonObject();
//        JsonArray itemsArray = new JsonArray();
//        JsonObject itemObject = new JsonObject();
//        JsonArray itemIds = new JsonArray();
//        itemIds.add(key);
//        itemObject.add("items", itemIds);
//        itemsArray.add(itemObject);
//        conditions.add("items", itemsArray);
//
//        gotOakPlanks.add("conditions", conditions);
//        criteria.add("got_%s".formatted(key_name), gotOakPlanks);
//        return criteria;
//    }
//
//    private static JsonObject getDisplayObject(String key, String translation_key) {
//        JsonObject display = new JsonObject();
//
//        JsonObject icon = new JsonObject();
//
//        icon.addProperty("id", key);
//        display.add("icon", icon);
//
//        JsonObject title = new JsonObject();
//        title.addProperty("translate", translation_key);
//        display.add("title", title);
//
//        JsonArray description = new JsonArray();
//        description.add("Obtain ");
//        JsonObject translatedDescriptionPart = new JsonObject();
//        translatedDescriptionPart.addProperty("translate",
//            translation_key);
//        description.add(translatedDescriptionPart);
//
//        display.add("description", description);
//
//        display.addProperty("frame", "task");
//        display.addProperty("show_toast", true);
//        display.addProperty("announce_to_chat", true);
//        display.addProperty("hidden", false);
//        return display;
//    }

}
