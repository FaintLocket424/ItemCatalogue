package org.example.faintlocket.itemCatalogue.tree.nodes.potions;

import org.bukkit.Material;
import org.bukkit.potion.PotionType;

public class RegularPotionItemAdvancement extends PotionItemAdvancement {

    public RegularPotionItemAdvancement(PotionType type) {
        this(type, false);
    }

    public RegularPotionItemAdvancement(PotionType type, boolean allowDuplicates) {
        super(Material.POTION, type, allowDuplicates);
    }
}
