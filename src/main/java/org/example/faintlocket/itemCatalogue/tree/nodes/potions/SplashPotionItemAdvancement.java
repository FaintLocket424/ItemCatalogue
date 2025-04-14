package org.example.faintlocket.itemCatalogue.tree.nodes.potions;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.potion.PotionType;

public class SplashPotionItemAdvancement extends PotionItemAdvancement {

    public SplashPotionItemAdvancement(PotionType type) {
        this(type, false);
    }

    public SplashPotionItemAdvancement(PotionType type, boolean allowDuplicates) {
        super(Material.SPLASH_POTION, type, allowDuplicates);
    }

    @Override
    protected NamespacedKey getTranslationKey() {
        String translationKey = super.getTranslationKey().getKey();

        String newKey = translationKey.replaceFirst(".potion.", ".splash_potion.");

        return NamespacedKey.minecraft(newKey);
    }
}
