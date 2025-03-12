package org.example.faintlocket.blockTracking.tree.nodes;

import static org.bukkit.Material.ORANGE_STAINED_GLASS_PANE;

import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.example.faintlocket.blockTracking.DatapackGenerator;

@SuppressWarnings("UnusedReturnValue")
public interface TreeNode {
    Material END_CARD_MATERIAL = ORANGE_STAINED_GLASS_PANE;

    default TreeNode addChild(TreeNode child) {
        if (child == null) {
            return this;
        }

        getChildren().add(child);
        child.setParent(this);
        return this;
    }

    default TreeNode addChildrenFromMaterials(List<Material> materials) {
        return addChildrenFromNodes(
            materials.stream()
                .map(m -> (TreeNode) new MaterialNode(m))
                .toList()
        );
    }

    default TreeNode addChildrenFromNodes(List<TreeNode> nodes) {
        return addChild(createTreeFromNodes(nodes));
    }

    private static TreeNode createTreeFromNodes(List<TreeNode> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return new MaterialNode(Material.AIR);
        }

        TreeNode root = nodes.getFirst();
        TreeNode current = root;

        for (int i = 1; i < nodes.size(); i++) {
            TreeNode newNode = nodes.get(i);
            current.addChild(newNode);
            current = newNode; // Move to the newly added child
        }

        current.addChild(new PlaceholderNode(END_CARD_MATERIAL));

        return root;
    }

    List<TreeNode> getChildren();

    TreeNode getParent();

    TreeNode setParent(TreeNode parent);

    NamespacedKey getAdvancementKey();

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

    default void writeAdvancementJSON(File advancementFolder) throws IOException {
        // Create root object
        JsonObject root = new JsonObject();

        // Set the "parent" tag to the NamespaceKey of the parent advancement.
        TreeNode parent = getParent();
        if (parent != null) {
            root.addProperty("parent", parent.getAdvancementKey().toString());
        }

        JsonObject display = getDisplayObject();
        JsonObject criteria = getCriteriaObject();
        root.add("display", display);
        root.add("criteria", criteria);

        String fileName = "%s.json".formatted(getAdvancementKey().getKey());

        DatapackGenerator.WriteJSONFile(root, advancementFolder, fileName);
    }

    JsonObject getDisplayObject() ;

    JsonObject getCriteriaObject();
}
