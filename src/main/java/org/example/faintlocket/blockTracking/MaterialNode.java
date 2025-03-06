package org.example.faintlocket.blockTracking;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.bukkit.Material;

public class MaterialNode implements TreeNode {

    private final Material material;
    @Nullable
    private TreeNode parent = null;
    private final List<TreeNode> children = new ArrayList<>();

    public MaterialNode(Material material) {
        this.material = material;
    }

    public TreeNode addChild(TreeNode child) {
        children.add(child);
        child.setParent(this);
        return this;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public Material getMaterial() {
        return material;
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

    public static MaterialNode createTreeFromList(List<Material> materials) {
        if (materials == null || materials.isEmpty()) {
            return null; // Handle empty list case
        }

        MaterialNode root = new MaterialNode(materials.getFirst());
        MaterialNode current = root;

        for (int i = 1; i < materials.size(); i++) {
            MaterialNode newNode = new MaterialNode(materials.get(i));
            current.addChild(newNode);
            current = newNode; // Move to the newly added child
        }

        return root;
    }
}
