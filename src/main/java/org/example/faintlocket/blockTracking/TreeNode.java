package org.example.faintlocket.blockTracking;

import java.util.List;
import java.util.function.Consumer;

public interface TreeNode {

    TreeNode addChild(TreeNode child);

    List<TreeNode> getChildren();

    TreeNode getParent();
    TreeNode setParent(TreeNode parent);

    default void traverse(Consumer<TreeNode> visitor) {
        traversePreOrder(this, visitor);
    }

    default void traversePreOrder(TreeNode node, Consumer<TreeNode> visitor) {
        if (node == null) {
            return;
        }

        visitor.accept(node);

        for (TreeNode child : node.getChildren()) {
            traversePreOrder(child, visitor);
        }
    }

    default void traversePostOrder(TreeNode node, Consumer<TreeNode> visitor) {
        if (node == null) {
            return;
        }

        for (TreeNode child : node.getChildren()) {
            traversePostOrder(child, visitor);
        }

        visitor.accept(node);
    }
}
