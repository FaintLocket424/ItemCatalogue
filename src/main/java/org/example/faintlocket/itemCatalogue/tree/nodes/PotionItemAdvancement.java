package org.example.faintlocket.itemCatalogue.tree.nodes;

import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionType;

public abstract class PotionItemAdvancement extends ItemAdvancement {

    private final PotionType potionType;

    public PotionItemAdvancement(Material material, PotionType type) {
        super(material, true);
        this.potionType = type;
    }

    @Override
    protected NamespacedKey getTranslationKey() {
        String effect_key = potionType.getKey().getKey()
            .replaceFirst("long_", "")
            .replaceFirst("strong_", "");

        String key = "item.minecraft.potion.effect." + effect_key;

        return NamespacedKey.minecraft(key);
    }

    @Override
    protected JsonObject getCriterionObject() {
        JsonObject criterionObject = super.getCriterionObject();

        JsonObject components = new JsonObject();
        JsonObject potionContents = new JsonObject();
        potionContents.addProperty("potion", this.potionType.key().value());
        components.add("minecraft:potion_contents", potionContents);

        criterionObject
            .getAsJsonObject("conditions")
            .getAsJsonArray("items")
            .get(0)
            .getAsJsonObject()
            .add("components", components);

        return criterionObject;
    }

    @Override
    protected JsonObject getIcon() {
        JsonObject icon = super.getIcon();

        JsonObject components = new JsonObject();
        JsonObject potionContents = new JsonObject();
        potionContents.addProperty("potion", this.potionType.key().value());
        components.add("minecraft:potion_contents", potionContents);
        icon.add("components", components);

        return icon;
    }
}
