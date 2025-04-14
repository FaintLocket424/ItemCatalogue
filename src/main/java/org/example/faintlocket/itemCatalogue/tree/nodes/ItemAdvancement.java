package org.example.faintlocket.itemCatalogue.tree.nodes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class ItemAdvancement extends AdvancementTreeData {

    private final Material targetMaterial;

    private static final Map<Material, Integer> MATERIAL_MAP = new HashMap<>();
    private final int id;
    private final boolean allowDuplicates;

    public ItemAdvancement(Material targetMaterial, boolean allowDuplicates) {
        this.targetMaterial = targetMaterial;
        this.id = MATERIAL_MAP.getOrDefault(targetMaterial, 0) + 1;

        this.allowDuplicates = allowDuplicates;

        MATERIAL_MAP.put(targetMaterial, this.id);
    }

    public ItemAdvancement(Material targetMaterial) {
        this(targetMaterial, false);
    }

    public Material getTargetMaterial() {
        return this.targetMaterial;
    }

    public boolean duplicatesAllowed() {
        return allowDuplicates;
    }

    protected NamespacedKey getTranslationKey() {
        String key = targetMaterial.isRecord()
            ? "jukebox_song.minecraft." + targetMaterial.name().substring("MUSIC_DISC_".length())
            .toLowerCase() :
            targetMaterial.isItem()
                ? targetMaterial.getItemTranslationKey()
                : targetMaterial.getBlockTranslationKey();

        return NamespacedKey.minecraft(key == null ? "KEY_NOT_FOUND" : key);
    }

    @Override
    protected JsonElement getDescription() {
        JsonArray description = new JsonArray();
        description.add("Obtain ");
        JsonObject translatedDescriptionPart = new JsonObject();
        translatedDescriptionPart.addProperty("translate", getTranslationKey().getKey());
        description.add(translatedDescriptionPart);

        return description;
    }

    @Override
    protected JsonElement getTitle() {
        JsonArray titleArray = new JsonArray();
        JsonObject translationObject = new JsonObject();
        translationObject.addProperty("translate", getTranslationKey().getKey());
        titleArray.add(translationObject);

        return titleArray;
    }

    @Override
    protected String getIconKey() {
        return targetMaterial.getKey().toString();
    }

    @Override
    protected String getAdvancementKey() {
        return targetMaterial.getKey().getKey() + (id > 1 ? "_" + id : "");
    }

    @Override
    protected String getFrameProperty() {
        return "task";
    }

    @Override
    protected JsonObject getCriterionObject() {
        // Adding the criterion like "obtained_oak_planks"
        JsonObject criterion = new JsonObject();

        // Adding the trigger for the criterion check, like "minecraft:inventory_changed"
        criterion.addProperty("trigger", "minecraft:inventory_changed");

        // The conditions which must be met in order to get the advancement.
        JsonObject conditions = new JsonObject();

        JsonArray itemsArray = new JsonArray();
        JsonObject itemObject = new JsonObject();
        JsonArray itemIds = new JsonArray();

        itemIds.add(this.targetMaterial.getKey().toString());
        itemObject.add("items", itemIds);
        itemsArray.add(itemObject);
        conditions.add("items", itemsArray);

        criterion.add("conditions", conditions);

        return criterion;
    }
}
