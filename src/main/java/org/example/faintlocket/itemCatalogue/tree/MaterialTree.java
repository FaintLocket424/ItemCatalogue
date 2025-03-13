package org.example.faintlocket.itemCatalogue.tree;

import static org.bukkit.Material.*;
import static org.example.faintlocket.itemCatalogue.DatapackGenerator.datapackNamespace;
import static org.example.faintlocket.itemCatalogue.ItemCatalogue.LOGGER;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.example.faintlocket.itemCatalogue.tree.nodes.CategoryNode;
import org.example.faintlocket.itemCatalogue.tree.nodes.MaterialNode;
import org.example.faintlocket.itemCatalogue.tree.nodes.PlaceholderNode;
import org.example.faintlocket.itemCatalogue.tree.nodes.TreeNode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

@SuppressWarnings("DuplicatedCode")
public class MaterialTree {
    private final String namespace;


    private final CategoryNode root;

    public CategoryNode getRoot() {
        return root;
    }

    public MaterialTree(int pageId) {
        this.namespace = "%s_page_%d".formatted(datapackNamespace, pageId);

        this.root = new CategoryNode(
            WRITABLE_BOOK,
            "root",
            "Item Catalogue Page %d".formatted(pageId),
            "Your complete item catalogue for " + Bukkit.getServer().getMinecraftVersion()
        );

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

    public String getNamespace() {
        return this.namespace;
    }
}
