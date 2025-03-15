package org.example.faintlocket.itemCatalogue.tree;

import java.util.List;
import org.example.faintlocket.itemCatalogue.tree.nodes.AdvancementTreeData;
import org.example.faintlocket.itemCatalogue.tree.nodes.PlaceholderAdvancement;
import org.example.faintlocket.itemCatalogue.tree.nodes.RootAdvancement;

public class AdvancementTree extends Tree<AdvancementTreeData> {

    private static int pageId = 1;

    private final String subfolder;

    public AdvancementTree() {
        this.subfolder = "page_%d".formatted(pageId);

        this.setRoot(new AdvancementTreeNode(new RootAdvancement(pageId)));

        pageId++;
    }

    public static TreeNode<AdvancementTreeData> createBranch(List<AdvancementTreeData> data) {
        var root = new AdvancementTreeNode(data.getFirst());
        var currentNode = root;
        for (int i = 1; i < data.size(); i++) {
            var node = new AdvancementTreeNode(data.get(i));
            currentNode.addChild(node);
            currentNode = node;
        }
        currentNode.addChild(new AdvancementTreeNode(new PlaceholderAdvancement()));
        return root;
    }

    public String getSubfolder() {
        return this.subfolder;
    }

}
