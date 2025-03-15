package org.example.faintlocket.itemCatalogue.tree;

import java.util.function.Consumer;

public abstract class Tree<T> {
    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public void traverse(Consumer<TreeNode<T>> consumer) {
        traversePreOrder(this.root, consumer);
    }

    private void traversePreOrder(TreeNode<T> node, Consumer<TreeNode<T>> visitor) {
        if (node == null) {
            return;
        }

        visitor.accept(node);

        for (TreeNode<T> child : node.getChildren()) {
            traversePreOrder(child, visitor);
        }
    }
}
