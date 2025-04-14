package org.example.faintlocket.itemCatalogue.tree.nodes.potions;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionType;

public class LingeringPotionItemAdvancement extends PotionItemAdvancement {

    public LingeringPotionItemAdvancement(PotionType type) {
        this(type, false);
    }

    public LingeringPotionItemAdvancement(PotionType type, boolean allowDuplicates) {
        super(Material.LINGERING_POTION, type, allowDuplicates);
    }

    @Override
    protected NamespacedKey getTranslationKey() {
        String translationKey = super.getTranslationKey().getKey();

        String newKey = translationKey.replaceFirst(".potion.", ".lingering_potion.");

        return NamespacedKey.minecraft(newKey);
    }
}
