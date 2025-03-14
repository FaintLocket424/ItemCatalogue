package org.example.faintlocket.itemCatalogue.tree.nodes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

public class PotionNode extends MaterialNode {

    private final PotionType potionType;

    public PotionNode(Material targetMaterial, PotionType potionType) {
        super(targetMaterial, true);

        this.potionType = potionType;
    }

    private @NotNull NamespacedKey getTranslationKey() {
        String key = "item.minecraft.potion.effect." + potionType.getKey().getKey();

        return NamespacedKey.minecraft(key);
    }

    private JsonArray getTitleObject() {
        JsonArray titleObj = new JsonArray();
        JsonObject translationObject = new JsonObject();
        translationObject.addProperty("translate", getTranslationKey().getKey());
        titleObj.add(translationObject);

        return titleObj;
    }

    private JsonArray getDescriptionArray() {
        JsonArray description = new JsonArray();
        description.add("Obtain ");
        JsonObject translatedDescriptionPart = new JsonObject();
        translatedDescriptionPart.addProperty("translate", getTranslationKey().getKey());
        description.add(translatedDescriptionPart);

        return description;
    }

    @Override
    public JsonObject getDisplayObject() {
        // The root object of the display section.
        JsonObject display = new JsonObject();

        // Set the id of the icon of the advancement.
        JsonObject icon = new JsonObject();
        icon.addProperty("id", getIconKey().toString());

        JsonObject components = new JsonObject();
        JsonObject potionContents = new JsonObject();
        potionContents.addProperty("potion", potionType.key().value());
        components.add("minecraft:potion_contents", potionContents);
        icon.add("components", components);

        display.add("icon", icon);

        // Set the title of the advancement.
        display.add("title", getTitleObject());

        // Set the description of the advancement.
        display.add("description", getDescriptionArray());

        display.addProperty("frame", "task");
        display.addProperty("show_toast", false);
        display.addProperty("announce_to_chat", false);
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

        JsonObject components = new JsonObject();
        JsonObject potionContents = new JsonObject();
        potionContents.addProperty("potion", potionType.key().value());
        components.add("minecraft:potion_contents", potionContents);
        itemObject.add("components", components);

        itemObject.addProperty("items", getMaterialKey().toString());
        itemsArray.add(itemObject);
        conditions.add("items", itemsArray);

        criterion.add("conditions", conditions);

        criteria.add("get_item", criterion);

        return criteria;
    }
}
