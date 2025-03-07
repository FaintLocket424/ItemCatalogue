package org.example.faintlocket.blockTracking.tree;

import org.bukkit.Bukkit;

import static org.bukkit.Material.*;

import java.util.List;
import java.util.Set;
import org.bukkit.Material;
import org.example.faintlocket.blockTracking.tree.nodes.CategoryNode;
import org.example.faintlocket.blockTracking.tree.nodes.MaterialNode;
import org.example.faintlocket.blockTracking.tree.nodes.PlaceholderNode;
import org.example.faintlocket.blockTracking.tree.nodes.TreeNode;

@SuppressWarnings("DuplicatedCode")
public class MaterialTree {

    public static Set<Material> UNOBTAINIUM() {
        return Set.of(
            AIR,
            BEDROCK,
            REINFORCED_DEEPSLATE,
            BUDDING_AMETHYST,
            BARRIER,
            STRUCTURE_BLOCK,
            STRUCTURE_VOID,
            LIGHT,
            JIGSAW,
            CHORUS_PLANT,
            DIRT_PATH,
            END_PORTAL_FRAME,
            END_PORTAL,
            NETHER_PORTAL,
            FROGSPAWN,
            FARMLAND,
            INFESTED_CHISELED_STONE_BRICKS,
            INFESTED_CRACKED_STONE_BRICKS,
            INFESTED_COBBLESTONE,
            INFESTED_DEEPSLATE,
            INFESTED_MOSSY_STONE_BRICKS,
            INFESTED_STONE,
            INFESTED_STONE_BRICKS,
            SPAWNER,
            TRIAL_SPAWNER,
            VAULT,
            WATER,
            LAVA,
            COMMAND_BLOCK,
            CHAIN_COMMAND_BLOCK,
            REPEATING_COMMAND_BLOCK,
            COMMAND_BLOCK_MINECART,
            DEBUG_STICK,
            KNOWLEDGE_BOOK,
            PETRIFIED_OAK_SLAB,
            COCOA,
            FILLED_MAP,

            ALLAY_SPAWN_EGG,
            ARMADILLO_SPAWN_EGG,
            AXOLOTL_SPAWN_EGG,
            BAT_SPAWN_EGG,
            BEE_SPAWN_EGG,
            BLAZE_SPAWN_EGG,
            BOGGED_SPAWN_EGG,
            BREEZE_SPAWN_EGG,
            CAMEL_SPAWN_EGG,
            CAT_SPAWN_EGG,
            CAVE_SPIDER_SPAWN_EGG,
            CHICKEN_SPAWN_EGG,
            COD_SPAWN_EGG,
            COW_SPAWN_EGG,
            CREAKING_SPAWN_EGG,
            CREEPER_SPAWN_EGG,
            DOLPHIN_SPAWN_EGG,
            DONKEY_SPAWN_EGG,
            DROWNED_SPAWN_EGG,
            ELDER_GUARDIAN_SPAWN_EGG,
            ENDERMAN_SPAWN_EGG,
            ENDER_DRAGON_SPAWN_EGG,
            ENDERMITE_SPAWN_EGG,
            EVOKER_SPAWN_EGG,
            FOX_SPAWN_EGG,
            FROG_SPAWN_EGG,
            GHAST_SPAWN_EGG,
            GLOW_SQUID_SPAWN_EGG,
            GOAT_SPAWN_EGG,
            GUARDIAN_SPAWN_EGG,
            HOGLIN_SPAWN_EGG,
            HORSE_SPAWN_EGG,
            HUSK_SPAWN_EGG,
            IRON_GOLEM_SPAWN_EGG,
            LLAMA_SPAWN_EGG,
            MAGMA_CUBE_SPAWN_EGG,
            MOOSHROOM_SPAWN_EGG,
            MULE_SPAWN_EGG,
            OCELOT_SPAWN_EGG,
            PANDA_SPAWN_EGG,
            PARROT_SPAWN_EGG,
            PHANTOM_SPAWN_EGG,
            PIG_SPAWN_EGG,
            PIGLIN_SPAWN_EGG,
            PIGLIN_BRUTE_SPAWN_EGG,
            PILLAGER_SPAWN_EGG,
            POLAR_BEAR_SPAWN_EGG,
            PUFFERFISH_SPAWN_EGG,
            RABBIT_SPAWN_EGG,
            RAVAGER_SPAWN_EGG,
            SALMON_SPAWN_EGG,
            SHEEP_SPAWN_EGG,
            SHULKER_SPAWN_EGG,
            SILVERFISH_SPAWN_EGG,
            SKELETON_SPAWN_EGG,
            SKELETON_HORSE_SPAWN_EGG,
            SLIME_SPAWN_EGG,
            SNIFFER_SPAWN_EGG,
            SNOW_GOLEM_SPAWN_EGG,
            SPIDER_SPAWN_EGG,
            SQUID_SPAWN_EGG,
            STRAY_SPAWN_EGG,
            STRIDER_SPAWN_EGG,
            TADPOLE_SPAWN_EGG,
            TRADER_LLAMA_SPAWN_EGG,
            TROPICAL_FISH_SPAWN_EGG,
            TURTLE_SPAWN_EGG,
            VEX_SPAWN_EGG,
            VILLAGER_SPAWN_EGG,
            VINDICATOR_SPAWN_EGG,
            WANDERING_TRADER_SPAWN_EGG,
            WARDEN_SPAWN_EGG,
            WITCH_SPAWN_EGG,
            WITHER_SKELETON_SPAWN_EGG,
            WITHER_SPAWN_EGG,
            WOLF_SPAWN_EGG,
            ZOGLIN_SPAWN_EGG,
            ZOMBIE_SPAWN_EGG,
            ZOMBIE_HORSE_SPAWN_EGG,
            ZOMBIE_VILLAGER_SPAWN_EGG,
            ZOMBIFIED_PIGLIN_SPAWN_EGG,

            CARROTS,
            POTATOES,
            BEETROOTS,
            WRITTEN_BOOK,
            PLAYER_HEAD,
            DRAGON_WALL_HEAD
        );
    }

    public static TreeNode WEAPONRY_CATEGORY() {
        return new CategoryNode(
            DIAMOND_SWORD,
            "category_weaponry",
            "Weaponry",
            ""
        )
            .addChildrenFromMaterials(List.of(
                WOODEN_SHOVEL,
                WOODEN_PICKAXE,
                WOODEN_AXE,
                WOODEN_HOE,
                WOODEN_SWORD,
                LEATHER_HELMET,
                LEATHER_CHESTPLATE,
                LEATHER_LEGGINGS,
                LEATHER_BOOTS
            ))
            .addChildrenFromMaterials(List.of(
                STONE_SHOVEL,
                STONE_PICKAXE,
                STONE_AXE,
                STONE_HOE,
                STONE_SWORD,
                CHAINMAIL_HELMET,
                CHAINMAIL_CHESTPLATE,
                CHAINMAIL_LEGGINGS,
                CHAINMAIL_BOOTS
            ))
            .addChildrenFromMaterials(List.of(
                IRON_SHOVEL,
                IRON_PICKAXE,
                IRON_AXE,
                IRON_HOE,
                IRON_SWORD,
                IRON_HELMET,
                IRON_CHESTPLATE,
                IRON_LEGGINGS,
                IRON_BOOTS
            ))
            .addChildrenFromMaterials(List.of(
                GOLDEN_SHOVEL,
                GOLDEN_PICKAXE,
                GOLDEN_AXE,
                GOLDEN_HOE,
                GOLDEN_SWORD,
                GOLDEN_HELMET,
                GOLDEN_CHESTPLATE,
                GOLDEN_LEGGINGS,
                GOLDEN_BOOTS
            ))
            .addChildrenFromMaterials(List.of(
                DIAMOND_SHOVEL,
                DIAMOND_PICKAXE,
                DIAMOND_AXE,
                DIAMOND_HOE,
                DIAMOND_SWORD,
                DIAMOND_HELMET,
                DIAMOND_CHESTPLATE,
                DIAMOND_LEGGINGS,
                DIAMOND_BOOTS
            ))
            .addChildrenFromMaterials(List.of(
                NETHERITE_SHOVEL,
                NETHERITE_PICKAXE,
                NETHERITE_AXE,
                NETHERITE_HOE,
                NETHERITE_SWORD,
                NETHERITE_HELMET,
                NETHERITE_CHESTPLATE,
                NETHERITE_LEGGINGS,
                NETHERITE_BOOTS
            ));
    }

    public static TreeNode COLOURED_CATEGORY() {
        return new CategoryNode(
            LIME_CONCRETE_POWDER,
            "category_coloured",
            "Coloured",
            "Yes I'm british, get over it."
        )
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_WOOL),
                new MaterialNode(LIGHT_GRAY_WOOL),
                new MaterialNode(GRAY_WOOL),
                new MaterialNode(BLACK_WOOL),
                new MaterialNode(BROWN_WOOL),
                new MaterialNode(RED_WOOL),
                new MaterialNode(ORANGE_WOOL),
                new MaterialNode(YELLOW_WOOL),
                new MaterialNode(LIME_WOOL),
                new MaterialNode(GREEN_WOOL),
                new MaterialNode(CYAN_WOOL),
                new MaterialNode(LIGHT_BLUE_WOOL),
                new MaterialNode(BLUE_WOOL),
                new MaterialNode(PURPLE_WOOL),
                new MaterialNode(MAGENTA_WOOL),
                new MaterialNode(PINK_WOOL)
            ))
            .addChildrenFromMaterials(List.of(
                WHITE_CARPET,
                LIGHT_GRAY_CARPET,
                GRAY_CARPET,
                BLACK_CARPET,
                BROWN_CARPET,
                RED_CARPET,
                ORANGE_CARPET,
                YELLOW_CARPET,
                LIME_CARPET,
                GREEN_CARPET,
                CYAN_CARPET,
                LIGHT_BLUE_CARPET,
                BLUE_CARPET,
                PURPLE_CARPET,
                MAGENTA_CARPET,
                PINK_CARPET
            ))
            .addChildrenFromMaterials(List.of(
                TERRACOTTA,
                WHITE_TERRACOTTA,
                LIGHT_GRAY_TERRACOTTA,
                GRAY_TERRACOTTA,
                BLACK_TERRACOTTA,
                BROWN_TERRACOTTA,
                RED_TERRACOTTA,
                ORANGE_TERRACOTTA,
                YELLOW_TERRACOTTA,
                LIME_TERRACOTTA,
                GREEN_TERRACOTTA,
                CYAN_TERRACOTTA,
                LIGHT_BLUE_TERRACOTTA,
                BLUE_TERRACOTTA,
                PURPLE_TERRACOTTA,
                MAGENTA_TERRACOTTA,
                PINK_TERRACOTTA
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(WHITE_GLAZED_TERRACOTTA),
                new MaterialNode(LIGHT_GRAY_GLAZED_TERRACOTTA),
                new MaterialNode(GRAY_GLAZED_TERRACOTTA),
                new MaterialNode(BLACK_GLAZED_TERRACOTTA),
                new MaterialNode(BROWN_GLAZED_TERRACOTTA),
                new MaterialNode(RED_GLAZED_TERRACOTTA),
                new MaterialNode(ORANGE_GLAZED_TERRACOTTA),
                new MaterialNode(YELLOW_GLAZED_TERRACOTTA),
                new MaterialNode(LIME_GLAZED_TERRACOTTA),
                new MaterialNode(GREEN_GLAZED_TERRACOTTA),
                new MaterialNode(CYAN_GLAZED_TERRACOTTA),
                new MaterialNode(LIGHT_BLUE_GLAZED_TERRACOTTA),
                new MaterialNode(BLUE_GLAZED_TERRACOTTA),
                new MaterialNode(PURPLE_GLAZED_TERRACOTTA),
                new MaterialNode(MAGENTA_GLAZED_TERRACOTTA),
                new MaterialNode(PINK_GLAZED_TERRACOTTA)
            ))
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_CONCRETE_POWDER),
                new MaterialNode(LIGHT_GRAY_CONCRETE_POWDER),
                new MaterialNode(GRAY_CONCRETE_POWDER),
                new MaterialNode(BLACK_CONCRETE_POWDER),
                new MaterialNode(BROWN_CONCRETE_POWDER),
                new MaterialNode(RED_CONCRETE_POWDER),
                new MaterialNode(ORANGE_CONCRETE_POWDER),
                new MaterialNode(YELLOW_CONCRETE_POWDER),
                new MaterialNode(LIME_CONCRETE_POWDER),
                new MaterialNode(GREEN_CONCRETE_POWDER),
                new MaterialNode(CYAN_CONCRETE_POWDER),
                new MaterialNode(LIGHT_BLUE_CONCRETE_POWDER),
                new MaterialNode(BLUE_CONCRETE_POWDER),
                new MaterialNode(PURPLE_CONCRETE_POWDER),
                new MaterialNode(MAGENTA_CONCRETE_POWDER),
                new MaterialNode(PINK_CONCRETE_POWDER)
            ))
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_CONCRETE),
                new MaterialNode(LIGHT_GRAY_CONCRETE),
                new MaterialNode(GRAY_CONCRETE),
                new MaterialNode(BLACK_CONCRETE),
                new MaterialNode(BROWN_CONCRETE),
                new MaterialNode(RED_CONCRETE),
                new MaterialNode(ORANGE_CONCRETE),
                new MaterialNode(YELLOW_CONCRETE),
                new MaterialNode(LIME_CONCRETE),
                new MaterialNode(GREEN_CONCRETE),
                new MaterialNode(CYAN_CONCRETE),
                new MaterialNode(LIGHT_BLUE_CONCRETE),
                new MaterialNode(BLUE_CONCRETE),
                new MaterialNode(PURPLE_CONCRETE),
                new MaterialNode(MAGENTA_CONCRETE),
                new MaterialNode(PINK_CONCRETE)
            ))
            .addChildrenFromMaterials(List.of(
                GLASS,
                WHITE_STAINED_GLASS,
                LIGHT_GRAY_STAINED_GLASS,
                GRAY_STAINED_GLASS,
                BLACK_STAINED_GLASS,
                BROWN_STAINED_GLASS,
                RED_STAINED_GLASS,
                ORANGE_STAINED_GLASS,
                YELLOW_STAINED_GLASS,
                LIME_STAINED_GLASS,
                GREEN_STAINED_GLASS,
                CYAN_STAINED_GLASS,
                LIGHT_BLUE_STAINED_GLASS,
                BLUE_STAINED_GLASS,
                PURPLE_STAINED_GLASS,
                MAGENTA_STAINED_GLASS,
                PINK_STAINED_GLASS,
                TINTED_GLASS
            ))
            .addChildrenFromMaterials(List.of(
                GLASS_PANE,
                WHITE_STAINED_GLASS_PANE,
                LIGHT_GRAY_STAINED_GLASS_PANE,
                GRAY_STAINED_GLASS_PANE,
                BLACK_STAINED_GLASS_PANE,
                BROWN_STAINED_GLASS_PANE,
                RED_STAINED_GLASS_PANE,
                ORANGE_STAINED_GLASS_PANE,
                YELLOW_STAINED_GLASS_PANE,
                LIME_STAINED_GLASS_PANE,
                GREEN_STAINED_GLASS_PANE,
                CYAN_STAINED_GLASS_PANE,
                LIGHT_BLUE_STAINED_GLASS_PANE,
                BLUE_STAINED_GLASS_PANE,
                PURPLE_STAINED_GLASS_PANE,
                MAGENTA_STAINED_GLASS_PANE,
                PINK_STAINED_GLASS_PANE
            ))
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_BED),
                new MaterialNode(LIGHT_GRAY_BED),
                new MaterialNode(GRAY_BED),
                new MaterialNode(BLACK_BED),
                new MaterialNode(BROWN_BED),
                new MaterialNode(RED_BED),
                new MaterialNode(ORANGE_BED),
                new MaterialNode(YELLOW_BED),
                new MaterialNode(LIME_BED),
                new MaterialNode(GREEN_BED),
                new MaterialNode(CYAN_BED),
                new MaterialNode(LIGHT_BLUE_BED),
                new MaterialNode(BLUE_BED),
                new MaterialNode(PURPLE_BED),
                new MaterialNode(MAGENTA_BED),
                new MaterialNode(PINK_BED)
            ))
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_BANNER),
                new MaterialNode(LIGHT_GRAY_BANNER),
                new MaterialNode(GRAY_BANNER),
                new MaterialNode(BLACK_BANNER),
                new MaterialNode(BROWN_BANNER),
                new MaterialNode(RED_BANNER),
                new MaterialNode(ORANGE_BANNER),
                new MaterialNode(YELLOW_BANNER),
                new MaterialNode(LIME_BANNER),
                new MaterialNode(GREEN_BANNER),
                new MaterialNode(CYAN_BANNER),
                new MaterialNode(LIGHT_BLUE_BANNER),
                new MaterialNode(BLUE_BANNER),
                new MaterialNode(PURPLE_BANNER),
                new MaterialNode(MAGENTA_BANNER),
                new MaterialNode(PINK_BANNER)
            ))
            .addChildrenFromMaterials(List.of(
                CANDLE,
                WHITE_CANDLE,
                LIGHT_GRAY_CANDLE,
                GRAY_CANDLE,
                BLACK_CANDLE,
                BROWN_CANDLE,
                RED_CANDLE,
                ORANGE_CANDLE,
                YELLOW_CANDLE,
                LIME_CANDLE,
                GREEN_CANDLE,
                CYAN_CANDLE,
                LIGHT_BLUE_CANDLE,
                BLUE_CANDLE,
                PURPLE_CANDLE,
                MAGENTA_CANDLE,
                PINK_CANDLE
            ))
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_DYE),
                new MaterialNode(LIGHT_GRAY_DYE),
                new MaterialNode(GRAY_DYE),
                new MaterialNode(BLACK_DYE),
                new MaterialNode(BROWN_DYE),
                new MaterialNode(RED_DYE),
                new MaterialNode(ORANGE_DYE),
                new MaterialNode(YELLOW_DYE),
                new MaterialNode(LIME_DYE),
                new MaterialNode(GREEN_DYE),
                new MaterialNode(CYAN_DYE),
                new MaterialNode(LIGHT_BLUE_DYE),
                new MaterialNode(BLUE_DYE),
                new MaterialNode(PURPLE_DYE),
                new MaterialNode(MAGENTA_DYE),
                new MaterialNode(PINK_DYE)
            ))
            .addChildrenFromMaterials(List.of(
                BUNDLE,
                WHITE_BUNDLE,
                LIGHT_GRAY_BUNDLE,
                GRAY_BUNDLE,
                BLACK_BUNDLE,
                BROWN_BUNDLE,
                RED_BUNDLE,
                ORANGE_BUNDLE,
                YELLOW_BUNDLE,
                LIME_BUNDLE,
                GREEN_BUNDLE,
                CYAN_BUNDLE,
                LIGHT_BLUE_BUNDLE,
                BLUE_BUNDLE,
                PURPLE_BUNDLE,
                MAGENTA_BUNDLE,
                PINK_BUNDLE
            ))
            .addChildrenFromMaterials(List.of(
                SHULKER_BOX,
                WHITE_SHULKER_BOX,
                LIGHT_GRAY_SHULKER_BOX,
                GRAY_SHULKER_BOX,
                BLACK_SHULKER_BOX,
                BROWN_SHULKER_BOX,
                RED_SHULKER_BOX,
                ORANGE_SHULKER_BOX,
                YELLOW_SHULKER_BOX,
                LIME_SHULKER_BOX,
                GREEN_SHULKER_BOX,
                CYAN_SHULKER_BOX,
                LIGHT_BLUE_SHULKER_BOX,
                BLUE_SHULKER_BOX,
                PURPLE_SHULKER_BOX,
                MAGENTA_SHULKER_BOX,
                PINK_SHULKER_BOX
            ));
    }

    public static TreeNode MINERALS_CATEGORY() {
        return new CategoryNode(
            DIAMOND_ORE,
            "category_minerals",
            "Minerals",
            "Shiny rocks"
        )
            .addChildrenFromMaterials(List.of(
                COAL_ORE,
                DEEPSLATE_COAL_ORE,
                COAL,
                COAL_BLOCK
            ))
            .addChildrenFromMaterials(List.of(
                IRON_ORE,
                DEEPSLATE_IRON_ORE,
                IRON_INGOT,
                IRON_BLOCK,
                IRON_NUGGET,
                RAW_IRON,
                RAW_IRON_BLOCK
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(COPPER_ORE),
                new MaterialNode(DEEPSLATE_COPPER_ORE),
                new MaterialNode(COPPER_INGOT),
                new MaterialNode(COPPER_BLOCK),
                new PlaceholderNode(),
                new MaterialNode(RAW_COPPER),
                new MaterialNode(RAW_COPPER_BLOCK)
            ))
            .addChildrenFromMaterials(List.of(
                GOLD_ORE,
                DEEPSLATE_GOLD_ORE,
                GOLD_INGOT,
                GOLD_BLOCK,
                GOLD_NUGGET,
                RAW_GOLD,
                RAW_GOLD_BLOCK
            ))
            .addChildrenFromMaterials(List.of(
                REDSTONE_ORE,
                DEEPSLATE_REDSTONE_ORE,
                REDSTONE,
                REDSTONE_BLOCK
            ))
            .addChildrenFromMaterials(List.of(
                EMERALD_ORE,
                DEEPSLATE_EMERALD_ORE,
                EMERALD,
                EMERALD_BLOCK
            ))
            .addChildrenFromMaterials(List.of(
                LAPIS_ORE,
                DEEPSLATE_LAPIS_ORE,
                LAPIS_LAZULI,
                LAPIS_BLOCK
            ))
            .addChildrenFromMaterials(List.of(
                DIAMOND_ORE,
                DEEPSLATE_DIAMOND_ORE,
                DIAMOND,
                DIAMOND_BLOCK
            ))
            .addChildrenFromMaterials(List.of(
                ANCIENT_DEBRIS,
                NETHERITE_SCRAP,
                NETHERITE_INGOT,
                NETHERITE_BLOCK
            ));
    }

    public static TreeNode WOOD_CATEGORY() {
        return new CategoryNode(
            OAK_LOG,
            "category_wood",
            "Wood",
            "Log4J"
        )
            .addChildrenFromMaterials(List.of(
                OAK_LOG,
                OAK_WOOD,
                STRIPPED_OAK_LOG,
                STRIPPED_OAK_WOOD,
                OAK_PLANKS,
                OAK_STAIRS,
                OAK_SLAB,
                OAK_FENCE,
                OAK_FENCE_GATE,
                OAK_DOOR,
                OAK_TRAPDOOR,
                OAK_PRESSURE_PLATE,
                OAK_BUTTON,
                OAK_LEAVES,
                OAK_SAPLING,
                OAK_SIGN,
                OAK_HANGING_SIGN,
                OAK_BOAT,
                OAK_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                SPRUCE_LOG,
                SPRUCE_WOOD,
                STRIPPED_SPRUCE_LOG,
                STRIPPED_SPRUCE_WOOD,
                SPRUCE_PLANKS,
                SPRUCE_STAIRS,
                SPRUCE_SLAB,
                SPRUCE_FENCE,
                SPRUCE_FENCE_GATE,
                SPRUCE_DOOR,
                SPRUCE_TRAPDOOR,
                SPRUCE_PRESSURE_PLATE,
                SPRUCE_BUTTON,
                SPRUCE_LEAVES,
                SPRUCE_SAPLING,
                SPRUCE_SIGN,
                SPRUCE_HANGING_SIGN,
                SPRUCE_BOAT,
                SPRUCE_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                BIRCH_LOG,
                BIRCH_WOOD,
                STRIPPED_BIRCH_LOG,
                STRIPPED_BIRCH_WOOD,
                BIRCH_PLANKS,
                BIRCH_STAIRS,
                BIRCH_SLAB,
                BIRCH_FENCE,
                BIRCH_FENCE_GATE,
                BIRCH_DOOR,
                BIRCH_TRAPDOOR,
                BIRCH_PRESSURE_PLATE,
                BIRCH_BUTTON,
                BIRCH_LEAVES,
                BIRCH_SAPLING,
                BIRCH_SIGN,
                BIRCH_HANGING_SIGN,
                BIRCH_BOAT,
                BIRCH_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                JUNGLE_LOG,
                JUNGLE_WOOD,
                STRIPPED_JUNGLE_LOG,
                STRIPPED_JUNGLE_WOOD,
                JUNGLE_PLANKS,
                JUNGLE_STAIRS,
                JUNGLE_SLAB,
                JUNGLE_FENCE,
                JUNGLE_FENCE_GATE,
                JUNGLE_DOOR,
                JUNGLE_TRAPDOOR,
                JUNGLE_PRESSURE_PLATE,
                JUNGLE_BUTTON,
                JUNGLE_LEAVES,
                JUNGLE_SAPLING,
                JUNGLE_SIGN,
                JUNGLE_HANGING_SIGN,
                JUNGLE_BOAT,
                JUNGLE_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                ACACIA_LOG,
                ACACIA_WOOD,
                STRIPPED_ACACIA_LOG,
                STRIPPED_ACACIA_WOOD,
                ACACIA_PLANKS,
                ACACIA_STAIRS,
                ACACIA_SLAB,
                ACACIA_FENCE,
                ACACIA_FENCE_GATE,
                ACACIA_DOOR,
                ACACIA_TRAPDOOR,
                ACACIA_PRESSURE_PLATE,
                ACACIA_BUTTON,
                ACACIA_LEAVES,
                ACACIA_SAPLING,
                ACACIA_SIGN,
                ACACIA_HANGING_SIGN,
                ACACIA_BOAT,
                ACACIA_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                DARK_OAK_LOG,
                DARK_OAK_WOOD,
                STRIPPED_DARK_OAK_LOG,
                STRIPPED_DARK_OAK_WOOD,
                DARK_OAK_PLANKS,
                DARK_OAK_STAIRS,
                DARK_OAK_SLAB,
                DARK_OAK_FENCE,
                DARK_OAK_FENCE_GATE,
                DARK_OAK_DOOR,
                DARK_OAK_TRAPDOOR,
                DARK_OAK_PRESSURE_PLATE,
                DARK_OAK_BUTTON,
                DARK_OAK_LEAVES,
                DARK_OAK_SAPLING,
                DARK_OAK_SIGN,
                DARK_OAK_HANGING_SIGN,
                DARK_OAK_BOAT,
                DARK_OAK_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                MANGROVE_LOG,
                MANGROVE_WOOD,
                STRIPPED_MANGROVE_LOG,
                STRIPPED_MANGROVE_WOOD,
                MANGROVE_PLANKS,
                MANGROVE_STAIRS,
                MANGROVE_SLAB,
                MANGROVE_FENCE,
                MANGROVE_FENCE_GATE,
                MANGROVE_DOOR,
                MANGROVE_TRAPDOOR,
                MANGROVE_PRESSURE_PLATE,
                MANGROVE_BUTTON,
                MANGROVE_LEAVES,
                MANGROVE_PROPAGULE,
                MANGROVE_SIGN,
                MANGROVE_HANGING_SIGN,
                MANGROVE_BOAT,
                MANGROVE_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                CHERRY_LOG,
                CHERRY_WOOD,
                STRIPPED_CHERRY_LOG,
                STRIPPED_CHERRY_WOOD,
                CHERRY_PLANKS,
                CHERRY_STAIRS,
                CHERRY_SLAB,
                CHERRY_FENCE,
                CHERRY_FENCE_GATE,
                CHERRY_DOOR,
                CHERRY_TRAPDOOR,
                CHERRY_PRESSURE_PLATE,
                CHERRY_BUTTON,
                CHERRY_LEAVES,
                CHERRY_SAPLING,
                CHERRY_SIGN,
                CHERRY_HANGING_SIGN,
                CHERRY_BOAT,
                CHERRY_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                PALE_OAK_LOG,
                PALE_OAK_WOOD,
                STRIPPED_PALE_OAK_LOG,
                STRIPPED_PALE_OAK_WOOD,
                PALE_OAK_PLANKS,
                PALE_OAK_STAIRS,
                PALE_OAK_SLAB,
                PALE_OAK_FENCE,
                PALE_OAK_FENCE_GATE,
                PALE_OAK_DOOR,
                PALE_OAK_TRAPDOOR,
                PALE_OAK_PRESSURE_PLATE,
                PALE_OAK_BUTTON,
                PALE_OAK_LEAVES,
                PALE_OAK_SAPLING,
                PALE_OAK_SIGN,
                PALE_OAK_HANGING_SIGN,
                PALE_OAK_BOAT,
                PALE_OAK_CHEST_BOAT
            ))
            .addChildrenFromMaterials(List.of(
                CRIMSON_STEM,
                CRIMSON_HYPHAE,
                STRIPPED_CRIMSON_STEM,
                STRIPPED_CRIMSON_HYPHAE,
                CRIMSON_PLANKS,
                CRIMSON_STAIRS,
                CRIMSON_SLAB,
                CRIMSON_FENCE,
                CRIMSON_FENCE_GATE,
                CRIMSON_DOOR,
                CRIMSON_TRAPDOOR,
                CRIMSON_PRESSURE_PLATE,
                CRIMSON_BUTTON,
                NETHER_WART_BLOCK,
                CRIMSON_FUNGUS,
                CRIMSON_SIGN,
                CRIMSON_HANGING_SIGN
            ))
            .addChildrenFromMaterials(List.of(
                WARPED_STEM,
                WARPED_HYPHAE,
                STRIPPED_WARPED_STEM,
                STRIPPED_WARPED_HYPHAE,
                WARPED_PLANKS,
                WARPED_STAIRS,
                WARPED_SLAB,
                WARPED_FENCE,
                WARPED_FENCE_GATE,
                WARPED_DOOR,
                WARPED_TRAPDOOR,
                WARPED_PRESSURE_PLATE,
                WARPED_BUTTON,
                WARPED_WART_BLOCK,
                WARPED_FUNGUS,
                WARPED_SIGN,
                WARPED_HANGING_SIGN
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(BAMBOO_BLOCK),
                new PlaceholderNode(),
                new MaterialNode(STRIPPED_BAMBOO_BLOCK)
                    .addChildrenFromNodes(List.of(
                        new PlaceholderNode(),
                        new MaterialNode(BAMBOO_MOSAIC),
                        new MaterialNode(BAMBOO_MOSAIC_STAIRS),
                        new MaterialNode(BAMBOO_MOSAIC_SLAB)
                    )),
                new PlaceholderNode(),
                new MaterialNode(BAMBOO_PLANKS),
                new MaterialNode(BAMBOO_STAIRS),
                new MaterialNode(BAMBOO_SLAB),
                new MaterialNode(BAMBOO_FENCE),
                new MaterialNode(BAMBOO_FENCE_GATE),
                new MaterialNode(BAMBOO_DOOR),
                new MaterialNode(BAMBOO_TRAPDOOR),
                new MaterialNode(BAMBOO_PRESSURE_PLATE),
                new MaterialNode(BAMBOO_BUTTON),
                new PlaceholderNode(),
                new MaterialNode(BAMBOO),
                new MaterialNode(BAMBOO_SIGN),
                new MaterialNode(BAMBOO_HANGING_SIGN),
                new MaterialNode(BAMBOO_RAFT),
                new MaterialNode(BAMBOO_CHEST_RAFT)
            ));
    }

    public static TreeNode STONE_CATEGORY() {
        return new CategoryNode(
            DEEPSLATE,
            "category_stone",
            "Stone",
            "Paper, Shears"
        )
            .addChildrenFromMaterials(List.of(
                GRANITE,
                GRANITE_STAIRS,
                GRANITE_SLAB,
                GRANITE_WALL,
                POLISHED_GRANITE,
                POLISHED_GRANITE_STAIRS,
                POLISHED_GRANITE_SLAB
            ))
            .addChildrenFromMaterials(List.of(
                DIORITE,
                DIORITE_STAIRS,
                DIORITE_SLAB,
                DIORITE_WALL,
                POLISHED_DIORITE,
                POLISHED_DIORITE_STAIRS,
                POLISHED_DIORITE_SLAB
            ))
            .addChildrenFromMaterials(List.of(
                ANDESITE,
                ANDESITE_STAIRS,
                ANDESITE_SLAB,
                ANDESITE_WALL,
                POLISHED_ANDESITE,
                POLISHED_ANDESITE_STAIRS,
                POLISHED_ANDESITE_SLAB
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(STONE),
                new MaterialNode(STONE_STAIRS),
                new MaterialNode(STONE_SLAB),
                new PlaceholderNode(),
                new MaterialNode(SMOOTH_STONE),
                new PlaceholderNode(),
                new MaterialNode(SMOOTH_STONE_SLAB),
                new MaterialNode(ANDESITE)
            ))
            ;
    }

    private final CategoryNode root;


    public CategoryNode getRoot() {
        return root;
    }

    public MaterialTree() {
        this.root = new CategoryNode(
            WRITABLE_BOOK,
            "root",
            "Item Catalogue",
            "Your complete item catalogue for " + Bukkit.getServer().getMinecraftVersion()
        );

        this.root
            .addChild(WEAPONRY_CATEGORY())
            .addChild(COLOURED_CATEGORY())
            .addChild(MINERALS_CATEGORY())
            .addChild(WOOD_CATEGORY())
            .addChild(STONE_CATEGORY())
        ;
    }
}
