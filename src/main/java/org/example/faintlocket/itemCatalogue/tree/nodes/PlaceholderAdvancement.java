package org.example.faintlocket.itemCatalogue.tree.nodes;

import static org.bukkit.Material.ORANGE_STAINED_GLASS_PANE;

import org.bukkit.Material;

public class PlaceholderAdvancement extends CategoryAdvancement {

    private static int counter = 0;
    private static final Material PLACEHOLDER_MATERIAL = ORANGE_STAINED_GLASS_PANE;

    public PlaceholderAdvancement() {
        super(PLACEHOLDER_MATERIAL, "placeholder_" + counter++, "", "");
    }

    @Override
    protected String getFrameProperty() {
        return "task";
    }
}
