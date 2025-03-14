package org.example.faintlocket.itemCatalogue.tree;

import static org.bukkit.Material.WRITABLE_BOOK;

import org.bukkit.Bukkit;
import org.example.faintlocket.itemCatalogue.tree.nodes.CategoryNode;

@SuppressWarnings("DuplicatedCode")
public class MaterialTree {
    private static int pageId = 1;

    private final String subfolder;

    private final CategoryNode root;

    public CategoryNode getRoot() {
        return root;
    }

    public MaterialTree() {
        this.subfolder = "page_%d".formatted(pageId);

        this.root = new CategoryNode(
            WRITABLE_BOOK,
            "root",
            "Item Catalogue Page %d".formatted(pageId),
            "Your complete item catalogue for " + Bukkit.getServer().getMinecraftVersion()
        );

        pageId++;

//        this.root
//            .addChild(TOOLS_AND_WEAPONRY_CATEGORY())
//            .addChild(COLOURED_CATEGORY())
//            .addChild(MINERALS_CATEGORY())
//            .addChild(WOOD_CATEGORY())
//            .addChild(STONE_CATEGORY())
//            .addChild(COPPER_CATEGORY())
//            .addChild(NATURAL_CATEGORY())
//            .addChild(NETHER_CATEGORY())
//            .addChild(ARCHEOLOGY_CATEGORY())
//            .addChild(CAVE_CATEGORY())
//            .addChild(MUSIC_DISC_CATEGORY())
//            .addChild(SMITHING_CATEGORY())
//            .addChild(END_CATEGORY())
//            .addChild(UTILITY_CATEGORY())
//            .addChild(OCEAN_CATEGORY())
//            .addChild(ENCHANTING_CATEGORY())
//            .addChild(REDSTONE_CATEGORY())
//            .addChild(MOB_DROP_CATEGORY())
//            .addChild(BANNER_CATEGORY())
//            .addChild(BREWING_CATEGORY())
//            .addChild(MATERIALS_CATEGORY())
//        ;
    }

    public String getSubfolder() {
        return this.subfolder;
    }
}
