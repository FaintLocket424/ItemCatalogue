package org.example.faintlocket.itemCatalogue.tree.nodes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class CategoryNode implements TreeNode {

    private final Material icon;
    private final String id;
    private final String title;
    private final String description;
    @Nullable
    private TreeNode parent = null;
    private final List<TreeNode> children = new ArrayList<>();

    public CategoryNode(Material icon, String id, String title, String description) {
        this.icon = icon;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public List<TreeNode> getChildren() {
        return children;
    }

    @Override
    @Nullable
    public TreeNode getParent() {
        return this.parent;
    }

    @Override
    public TreeNode setParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public String getAdvancementKey() {
        return this.id;
    }

    public NamespacedKey getIconKey() {
        return this.icon.getKey();
    }

    public JsonArray getTitleObject() {
        JsonArray titleObj = new JsonArray();
        titleObj.add(this.title);

        return titleObj;
    }

    @Override
    public JsonObject getCriteriaObject() {
        JsonObject criteria = new JsonObject();

        /*
        {
            tick: {
                "trigger": "minecraft:tick"
            }
        }
         */

        JsonObject criterion = new JsonObject();

        criterion.addProperty("trigger", "minecraft:tick");

        criteria.add("tick", criterion);

        return criteria;
    }

    @Override
    public JsonObject getDisplayObject() {
        // The root object of the display section.
        JsonObject display = new JsonObject();

        // Set the id of the icon of the advancement.
        JsonObject icon = new JsonObject();
        icon.addProperty("id", getIconKey().toString());
        display.add("icon", icon);

        // Set the title of the advancement.
        display.add("title", getTitleObject());

        // Set the description of the advancement.
        display.addProperty("description", this.description);

        display.addProperty("show_toast", false);
        display.addProperty("announce_to_chat", false);
        display.addProperty("hidden", false);

//        if (Objects.equals(this.id, "root")) {
//            display.addProperty("frame", "challenge");
//            display.addProperty("background", "minecraft:textures/block/black_concrete.png");
//        }

        if (this.id.equals("root")) {
            display.addProperty("frame", "challenge");
            display.addProperty("background", "minecraft:textures/block/black_concrete.png");
        } else if (this.id.startsWith("category_")) {
            display.addProperty("frame", "goal");
        } else {
            display.addProperty("frame", "task");
        }

        return display;
    }
}
