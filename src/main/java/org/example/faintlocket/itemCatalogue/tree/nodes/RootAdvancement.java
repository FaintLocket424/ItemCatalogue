package org.example.faintlocket.itemCatalogue.tree.nodes;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class RootAdvancement extends CategoryAdvancement {

    public RootAdvancement(int pageId) {
        super(
            Material.WRITABLE_BOOK,
            "root",
            "Item Catalogue Page %d".formatted(pageId),
            "Your complete item catalogue for " + Bukkit.getServer().getMinecraftVersion()
        );
    }

    @Override
    protected String getFrameProperty() {
        return "challenge";
    }

    @Override
    protected boolean isRoot() {
        return true;
    }
}
