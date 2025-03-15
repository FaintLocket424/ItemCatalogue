package org.example.faintlocket.itemCatalogue.tree.nodes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.bukkit.Material;

public class CategoryAdvancement extends AdvancementTreeData {

    private final Material icon;
    private final String id;
    private final String title;
    private final String description;

    public CategoryAdvancement(Material icon, String id, String title, String description) {
        this.icon = icon;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    protected JsonElement getDescription() {
        return new JsonPrimitive(this.description);
    }

    @Override
    protected JsonElement getTitle() {
        return new JsonPrimitive(this.title);
    }

    @Override
    protected String getIconKey() {
        return this.icon.getKey().toString();
    }

    @Override
    protected String getAdvancementKey() {
        return this.id;
    }

    @Override
    protected String getFrameProperty() {
        return "goal";
    }

    @Override
    protected JsonObject getCriterionObject() {
        JsonObject criterion = new JsonObject();

        criterion.addProperty("trigger", "minecraft:tick");

        return criterion;
    }
}
