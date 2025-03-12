package org.example.faintlocket.itemCatalogue.tree.nodes;

import static org.bukkit.Material.ORANGE_STAINED_GLASS_PANE;

import org.bukkit.Material;

public class PlaceholderNode extends CategoryNode {
    private static int counter = 0;
    private static final Material PLACEHOLDER_MATERIAL = ORANGE_STAINED_GLASS_PANE;

    public PlaceholderNode() {
        this(PLACEHOLDER_MATERIAL);
    }

    public PlaceholderNode(Material icon) {
        super(icon, "placeholder_" + counter++, "", "");
    }
}
