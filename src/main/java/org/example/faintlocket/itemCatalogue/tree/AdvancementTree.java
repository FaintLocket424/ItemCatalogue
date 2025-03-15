package org.example.faintlocket.itemCatalogue.tree;

import org.example.faintlocket.itemCatalogue.tree.nodes.AdvancementTreeData;
import org.example.faintlocket.itemCatalogue.tree.nodes.RootAdvancement;

public class AdvancementTree extends Tree<AdvancementTreeData> {
    private static int pageId = 1;

    private final String subfolder;

    public AdvancementTree() {
        this.subfolder = "page_%d".formatted(pageId);

        this.setRoot(new AdvancementTreeNode(new RootAdvancement(pageId)));

        pageId++;
    }

    public String getSubfolder() {
        return this.subfolder;
    }

}
