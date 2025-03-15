package org.example.faintlocket.itemCatalogue.tree;

import java.util.List;
import org.example.faintlocket.itemCatalogue.tree.nodes.ItemAdvancement;

@SuppressWarnings("UnusedReturnValue")
public interface TreeNode<T> {
    public T getValue();
    public void setParent(TreeNode<T> parent);
    public TreeNode<T> getParent();
    public TreeNode<T> addChild(TreeNode<T> child);
    public List<TreeNode<T>> getChildren();
}
