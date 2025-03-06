package org.example.faintlocket.blockTracking;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class CategoryNode implements TreeNode {
    @Nullable private TreeNode parent = null;
    private final List<TreeNode> children = new ArrayList<>();

    public CategoryNode() {

    }

    @Override
    public TreeNode addChild(TreeNode child) {
        return null;
    }

    @Override
    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    @Nullable
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public TreeNode setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }
}
