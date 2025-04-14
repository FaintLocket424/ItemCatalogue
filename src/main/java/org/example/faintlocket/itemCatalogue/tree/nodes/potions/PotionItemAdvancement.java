package org.example.faintlocket.itemCatalogue.tree.nodes.potions;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionType;
import org.example.faintlocket.itemCatalogue.tree.nodes.ItemAdvancement;
import org.jetbrains.annotations.NotNull;

public abstract class PotionItemAdvancement extends ItemAdvancement {

  private final PotionType potionType;

  public PotionItemAdvancement(Material material, PotionType type, boolean allowDuplicates) {
    super(material, allowDuplicates);
    this.potionType = type;
  }

  public PotionType getPotionType() {
    return potionType;
  }

  @Override
  protected JsonElement getTitle() {
    JsonArray titleArray = new JsonArray();

    String prefix = getPotionPrefix();

    titleArray.add(prefix);

    JsonObject translationObject = new JsonObject();
    translationObject.addProperty("translate", getTranslationKey().getKey());
    titleArray.add(translationObject);

    return titleArray;
  }

  @Override
  protected JsonElement getDescription() {
    JsonArray description = new JsonArray();
    description.add("Obtain ");

    String prefix = getPotionPrefix();

    description.add(prefix);

    JsonObject translatedDescriptionPart = new JsonObject();
    translatedDescriptionPart.addProperty("translate", getTranslationKey().getKey());
    description.add(translatedDescriptionPart);

    return description;
  }

  private @NotNull String getPotionPrefix() {
    return this.potionType.toString().startsWith("LONG_") ? "Long "
        : (this.potionType.toString().startsWith("STRONG_") ? "Strong "
        : "");
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
