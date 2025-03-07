package org.example.faintlocket.blockTracking.tree.nodes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.example.faintlocket.blockTracking.DatapackGenerator;
import org.jetbrains.annotations.NotNull;

public class MaterialNode implements TreeNode {

    private final Material targetMaterial;
    @Nullable
    private TreeNode parent = null;
    private final List<TreeNode> children = new ArrayList<>();

    private static final Map<Material, Integer> MATERIAL_MAP = new HashMap<>();
    private final int id;

    public MaterialNode(Material targetMaterial) {
        this.targetMaterial = targetMaterial;
        this.id = MATERIAL_MAP.getOrDefault(targetMaterial, 0) + 1;

        MATERIAL_MAP.put(targetMaterial, this.id);
    }

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

    @Override
    public NamespacedKey getAdvancementKey() {
        return new NamespacedKey(
            DatapackGenerator.GetDatapackNamespace(),
            targetMaterial.getKey().getKey() +
                (id > 1 ? "_"+id : "")
        );
    }

    public NamespacedKey getIconKey() {
        return targetMaterial.getKey();
    }

    public JsonArray getTitleObject() {
        JsonArray titleObj = new JsonArray();
        JsonObject translationObject = new JsonObject();
        translationObject.addProperty("translate", getTranslationKey().getKey());
        titleObj.add(translationObject);

        return titleObj;
    }

    private @NotNull NamespacedKey getTranslationKey() {
        String key = targetMaterial.isRecord()
            ? "jukebox_song.minecraft." + targetMaterial.name().substring("MUSIC_DISC_".length())
            .toLowerCase() :
            targetMaterial.isItem()
                ? targetMaterial.getItemTranslationKey()
                : targetMaterial.getBlockTranslationKey();

        return NamespacedKey.minecraft(key == null ? "KEY_NOT_FOUND" : key);
    }

    public JsonArray getDescriptionArray() {
        JsonArray description = new JsonArray();
        description.add("Obtain ");
        JsonObject translatedDescriptionPart = new JsonObject();
        translatedDescriptionPart.addProperty("translate", getTranslationKey().getKey());
        description.add(translatedDescriptionPart);

        return description;
    }

    public NamespacedKey getMaterialKey() {
        return this.targetMaterial.getKey();
    }

    public Material getTargetMaterial() {
        return this.targetMaterial;
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
        display.add("description", getDescriptionArray());

        display.addProperty("frame", "task");
        display.addProperty("show_toast", true);
        display.addProperty("announce_to_chat", true);
        display.addProperty("hidden", false);

        return display;
    }

    @Override
    public JsonObject getCriteriaObject() {
        JsonObject criteria = new JsonObject();

        /*
        {
            get_item: {
                "trigger": "minecraft:inventory_changed"
                "conditions": {
                    "items": [
                        {
                            "items": [
                                "minecraft:oak_planks"
                            ]
                        }
                    ]
                }
            }
        }
         */

        // Adding the criterion like "obtained_oak_planks"
        JsonObject criterion = new JsonObject();

        // Adding the trigger for the criterion check, like "minecraft:inventory_changed"
        criterion.addProperty("trigger", "minecraft:inventory_changed");

        // The conditions which must be met in order to get the advancement.
        JsonObject conditions = new JsonObject();

        JsonArray itemsArray = new JsonArray();
        JsonObject itemObject = new JsonObject();
        JsonArray itemIds = new JsonArray();

        itemIds.add(getMaterialKey().toString());
        itemObject.add("items", itemIds);
        itemsArray.add(itemObject);
        conditions.add("items", itemsArray);

        criterion.add("conditions", conditions);

        criteria.add("get_item", criterion);

        return criteria;
    }
}
