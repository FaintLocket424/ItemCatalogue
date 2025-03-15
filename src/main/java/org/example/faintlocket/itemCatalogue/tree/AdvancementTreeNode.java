package org.example.faintlocket.itemCatalogue.tree;

import java.util.ArrayList;
import java.util.List;
import org.example.faintlocket.itemCatalogue.tree.nodes.AdvancementTreeData;

public class AdvancementTreeNode implements TreeNode<AdvancementTreeData> {

    private final AdvancementTreeData nodeData;
    private TreeNode<AdvancementTreeData> parent = null;
    private final List<TreeNode<AdvancementTreeData>> children = new ArrayList<>();

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

}
