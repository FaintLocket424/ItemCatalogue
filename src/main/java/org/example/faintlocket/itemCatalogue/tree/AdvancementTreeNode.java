package org.example.faintlocket.itemCatalogue.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.example.faintlocket.itemCatalogue.tree.nodes.AdvancementTreeData;
import org.example.faintlocket.itemCatalogue.tree.nodes.ItemAdvancement;
import org.example.faintlocket.itemCatalogue.tree.nodes.PlaceholderAdvancement;

public class AdvancementTreeNode implements TreeNode<AdvancementTreeData> {

    private final AdvancementTreeData nodeData;
    private TreeNode<AdvancementTreeData> parent = null;
    private List<TreeNode<AdvancementTreeData>> children = new ArrayList<>();

    public AdvancementTreeNode(AdvancementTreeData nodeData) {
        this.nodeData = nodeData;
    }

    @Override
    public AdvancementTreeData getValue() {
        return this.nodeData;
    }

    @Override
    public void setParent(TreeNode<AdvancementTreeData> parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode<AdvancementTreeData> getParent() {
        return this.parent;
    }

    @Override
    public TreeNode<AdvancementTreeData> addChild(TreeNode<AdvancementTreeData> child) {
        this.children.add(child);
        child.setParent(this);
        return this;
    }

    @Override
    public List<TreeNode<AdvancementTreeData>> getChildren() {
        return this.children;
    }

    public AdvancementTreeNode addChildrenFromData(List<ItemAdvancement> data) {
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


}
