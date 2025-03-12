package org.example.faintlocket.blockTracking.tree;

import static org.bukkit.Material.*;
import static org.example.faintlocket.blockTracking.BlockTracking.LOGGER;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.example.faintlocket.blockTracking.tree.nodes.CategoryNode;
import org.example.faintlocket.blockTracking.tree.nodes.MaterialNode;
import org.example.faintlocket.blockTracking.tree.nodes.PlaceholderNode;
import org.example.faintlocket.blockTracking.tree.nodes.TreeNode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

@SuppressWarnings("DuplicatedCode")
public class MaterialTree {

    private static final int MaxErrorListLength = 25;

    private static final int ErrorPrintWidth =
        7 + Arrays.stream(Material.values())
            .map(m -> m.name().length())
            .max(Integer::compare)
            .orElseThrow();

    private static final String HeaderCharacter = "=";

    @Contract(pure = true)
    public static @NotNull @Unmodifiable Set<Material> CREATE_UNOBTAINIUM() {
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

    public static TreeNode TOOLS_AND_WEAPONRY_CATEGORY() {
        return new CategoryNode(
            DIAMOND_SWORD,
            "category_tools_and_weaponry",
            "Weaponry",
            ""
        )
            .addChild(new CategoryNode(
                    FLINT_AND_STEEL,
                    "category_tools_and_weaponry_misc",
                    "Misc. Weaponry",
                    "Other weapons, tools and armour"
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(LEATHER_HORSE_ARMOR),
                        new MaterialNode(IRON_HORSE_ARMOR),
                        new MaterialNode(GOLDEN_HORSE_ARMOR),
                        new MaterialNode(DIAMOND_HORSE_ARMOR),
                        new MaterialNode(WOLF_ARMOR),
                        new MaterialNode(TURTLE_HELMET, true),
                        new MaterialNode(SHIELD),
                        new MaterialNode(SADDLE),
                        new MaterialNode(ARMOR_STAND)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(ARROW),
                        new MaterialNode(BOW),
                        new MaterialNode(CROSSBOW),
                        new MaterialNode(FISHING_ROD),
                        new MaterialNode(CARROT_ON_A_STICK),
                        new MaterialNode(WARPED_FUNGUS_ON_A_STICK),
                        new MaterialNode(SHEARS),
                        new MaterialNode(BRUSH, true),
                        new MaterialNode(FLINT_AND_STEEL),
                        new MaterialNode(FIRE_CHARGE),
                        new MaterialNode(TOTEM_OF_UNDYING),
                        new MaterialNode(SPYGLASS),
                        new MaterialNode(TRIDENT),
                        new MaterialNode(MACE)
                    ))
                    .addChildrenFromMaterials(List.of(
                        BUCKET,
                        WATER_BUCKET,
                        COD_BUCKET,
                        SALMON_BUCKET,
                        TROPICAL_FISH_BUCKET,
                        PUFFERFISH_BUCKET,
                        AXOLOTL_BUCKET,
                        TADPOLE_BUCKET,
                        LAVA_BUCKET,
                        POWDER_SNOW_BUCKET,
                        MILK_BUCKET
                    ))
                    .addChild(new CategoryNode(
                            TIPPED_ARROW,
                            "category_tools_and_weaponry_tipped_arrows",
                            "Tipped Arrows",
                            ""
                        )
                            .addChild(new MaterialNode(SPECTRAL_ARROW))
                            .addChild(new MaterialNode(TIPPED_ARROW))
                    )
            )
            .addChild(new CategoryNode(
                    DIAMOND_CHESTPLATE,
                    "category_tools_and_weaponry_tools_and_armour",
                    "Tools and Armour",
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
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(IRON_SHOVEL),
                        new MaterialNode(IRON_PICKAXE),
                        new MaterialNode(IRON_AXE),
                        new MaterialNode(IRON_HOE),
                        new MaterialNode(IRON_SWORD),
                        new MaterialNode(IRON_HELMET),
                        new MaterialNode(IRON_CHESTPLATE),
                        new MaterialNode(IRON_LEGGINGS),
                        new MaterialNode(IRON_BOOTS)
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
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(DIAMOND_SHOVEL),
                        new MaterialNode(DIAMOND_PICKAXE),
                        new MaterialNode(DIAMOND_AXE),
                        new MaterialNode(DIAMOND_HOE),
                        new MaterialNode(DIAMOND_SWORD),
                        new MaterialNode(DIAMOND_HELMET),
                        new MaterialNode(DIAMOND_CHESTPLATE),
                        new MaterialNode(DIAMOND_LEGGINGS),
                        new MaterialNode(DIAMOND_BOOTS)
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
                    ))
            );
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
            .addChildrenFromNodes(List.of(
                new PlaceholderNode(),
                new MaterialNode(WHITE_CARPET),
                new MaterialNode(LIGHT_GRAY_CARPET),
                new MaterialNode(GRAY_CARPET),
                new MaterialNode(BLACK_CARPET),
                new MaterialNode(BROWN_CARPET),
                new MaterialNode(RED_CARPET),
                new MaterialNode(ORANGE_CARPET),
                new MaterialNode(YELLOW_CARPET),
                new MaterialNode(LIME_CARPET),
                new MaterialNode(GREEN_CARPET),
                new MaterialNode(CYAN_CARPET),
                new MaterialNode(LIGHT_BLUE_CARPET),
                new MaterialNode(BLUE_CARPET),
                new MaterialNode(PURPLE_CARPET),
                new MaterialNode(MAGENTA_CARPET),
                new MaterialNode(PINK_CARPET)
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
                new PlaceholderNode(),
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
            .addChild(new CategoryNode(
                    DIAMOND,
                    "category_minerals_gems",
                    "Gems",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        COAL_ORE,
                        DEEPSLATE_COAL_ORE,
                        COAL,
                        COAL_BLOCK
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(REDSTONE_ORE),
                        new MaterialNode(DEEPSLATE_REDSTONE_ORE),
                        new MaterialNode(REDSTONE, true),
                        new MaterialNode(REDSTONE_BLOCK, true)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(EMERALD_ORE),
                        new MaterialNode(DEEPSLATE_EMERALD_ORE),
                        new MaterialNode(EMERALD),
                        new MaterialNode(EMERALD_BLOCK)
                    ))
                    .addChildrenFromMaterials(List.of(
                        LAPIS_ORE,
                        DEEPSLATE_LAPIS_ORE,
                        LAPIS_LAZULI,
                        LAPIS_BLOCK
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(DIAMOND_ORE),
                        new MaterialNode(DEEPSLATE_DIAMOND_ORE),
                        new MaterialNode(DIAMOND),
                        new MaterialNode(DIAMOND_BLOCK)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(ANCIENT_DEBRIS, true),
                        new MaterialNode(NETHERITE_SCRAP),
                        new MaterialNode(NETHERITE_INGOT),
                        new MaterialNode(NETHERITE_BLOCK)
                    ))
            )
            .addChild(new CategoryNode(
                    IRON_INGOT,
                    "category_minerals_metals",
                    "Metals",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(IRON_ORE),
                        new MaterialNode(DEEPSLATE_IRON_ORE),
                        new MaterialNode(IRON_INGOT),
                        new MaterialNode(IRON_BLOCK),
                        new MaterialNode(RAW_IRON),
                        new MaterialNode(RAW_IRON_BLOCK),
                        new MaterialNode(IRON_NUGGET),
                        new MaterialNode(IRON_DOOR),
                        new MaterialNode(IRON_TRAPDOOR),
                        new MaterialNode(CHAIN),
                        new MaterialNode(IRON_BARS)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(COPPER_ORE),
                        new MaterialNode(DEEPSLATE_COPPER_ORE),
                        new MaterialNode(COPPER_INGOT),
                        new MaterialNode(COPPER_BLOCK, true),
                        new MaterialNode(RAW_COPPER),
                        new MaterialNode(RAW_COPPER_BLOCK)
                    ))
                    .addChildrenFromMaterials(List.of(
                        GOLD_ORE,
                        DEEPSLATE_GOLD_ORE,
                        GOLD_INGOT,
                        GOLD_BLOCK,
                        RAW_GOLD,
                        RAW_GOLD_BLOCK,
                        GOLD_NUGGET
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(CREAKING_HEART),
                        new PlaceholderNode(),
                        new MaterialNode(RESIN_BRICK),
                        new MaterialNode(RESIN_BRICKS, true),
                        new MaterialNode(RESIN_CLUMP),
                        new MaterialNode(RESIN_BLOCK)
                    ))
            );
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
            .addChildrenFromNodes(List.of(
                new MaterialNode(MANGROVE_LOG),
                new MaterialNode(MANGROVE_WOOD),
                new MaterialNode(STRIPPED_MANGROVE_LOG),
                new MaterialNode(STRIPPED_MANGROVE_WOOD),
                new MaterialNode(MANGROVE_PLANKS),
                new MaterialNode(MANGROVE_STAIRS),
                new MaterialNode(MANGROVE_SLAB),
                new MaterialNode(MANGROVE_FENCE),
                new MaterialNode(MANGROVE_FENCE_GATE),
                new MaterialNode(MANGROVE_DOOR),
                new MaterialNode(MANGROVE_TRAPDOOR),
                new MaterialNode(MANGROVE_PRESSURE_PLATE),
                new MaterialNode(MANGROVE_BUTTON)
                    .addChildrenFromMaterials(List.of(
                        MANGROVE_ROOTS,
                        MUDDY_MANGROVE_ROOTS
                    )),
                new MaterialNode(MANGROVE_LEAVES),
                new MaterialNode(MANGROVE_PROPAGULE),
                new MaterialNode(MANGROVE_SIGN),
                new MaterialNode(MANGROVE_HANGING_SIGN),
                new MaterialNode(MANGROVE_BOAT),
                new MaterialNode(MANGROVE_CHEST_BOAT)
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
            STONE,
            "category_stones",
            "Stones",
            "Paper, Shears"
        )
            .addChild(new CategoryNode(
                    DEEPSLATE,
                    "category_stone_deepslate",
                    "Deepslate",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        COBBLED_DEEPSLATE,
                        COBBLED_DEEPSLATE_STAIRS,
                        COBBLED_DEEPSLATE_SLAB,
                        COBBLED_DEEPSLATE_WALL,
                        POLISHED_DEEPSLATE,
                        POLISHED_DEEPSLATE_STAIRS,
                        POLISHED_DEEPSLATE_SLAB,
                        POLISHED_DEEPSLATE_WALL,
                        DEEPSLATE,
                        CHISELED_DEEPSLATE
                    ))
                    .addChildrenFromMaterials(List.of(
                        DEEPSLATE_BRICKS,
                        DEEPSLATE_BRICK_STAIRS,
                        DEEPSLATE_BRICK_SLAB,
                        DEEPSLATE_BRICK_WALL,
                        DEEPSLATE_TILES,
                        DEEPSLATE_TILE_STAIRS,
                        DEEPSLATE_TILE_SLAB,
                        DEEPSLATE_TILE_WALL,
                        CRACKED_DEEPSLATE_BRICKS,
                        CRACKED_DEEPSLATE_TILES
                    ))
            )
            .addChild(new CategoryNode(
                    STONE,
                    "category_stone_stone",
                    "Stone",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(STONE, true),
                        new MaterialNode(STONE_STAIRS),
                        new MaterialNode(STONE_SLAB),
                        new PlaceholderNode(),
                        new MaterialNode(SMOOTH_STONE),
                        new PlaceholderNode(),
                        new MaterialNode(SMOOTH_STONE_SLAB),
                        new MaterialNode(STONE_BUTTON),
                        new MaterialNode(STONE_PRESSURE_PLATE)
                    ))
                    .addChildrenFromMaterials(List.of(
                        COBBLESTONE,
                        COBBLESTONE_STAIRS,
                        COBBLESTONE_SLAB,
                        COBBLESTONE_WALL,
                        MOSSY_COBBLESTONE,
                        MOSSY_COBBLESTONE_STAIRS,
                        MOSSY_COBBLESTONE_SLAB,
                        MOSSY_COBBLESTONE_WALL
                    ))
                    .addChildrenFromMaterials(List.of(
                        STONE_BRICKS,
                        STONE_BRICK_STAIRS,
                        STONE_BRICK_SLAB,
                        STONE_BRICK_WALL,
                        MOSSY_STONE_BRICKS,
                        MOSSY_STONE_BRICK_STAIRS,
                        MOSSY_STONE_BRICK_SLAB,
                        MOSSY_STONE_BRICK_WALL,
                        CRACKED_STONE_BRICKS,
                        CHISELED_STONE_BRICKS
                    ))
            )
            .addChild(new CategoryNode(
                    GRANITE,
                    "category_stone_igneous",
                    "Igneous Rocks",
                    ""
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
            )
            .addChild(new CategoryNode(
                    TUFF,
                    "category_stone_tuff",
                    "Tuff",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        POLISHED_TUFF,
                        POLISHED_TUFF_STAIRS,
                        POLISHED_TUFF_SLAB,
                        POLISHED_TUFF_WALL,
                        TUFF_BRICKS,
                        TUFF_BRICK_STAIRS,
                        TUFF_BRICK_SLAB,
                        TUFF_BRICK_WALL
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(TUFF, true),
                        new MaterialNode(TUFF_STAIRS),
                        new MaterialNode(TUFF_SLAB),
                        new MaterialNode(TUFF_WALL),
                        new MaterialNode(CHISELED_TUFF),
                        new MaterialNode(CHISELED_TUFF_BRICKS)
                    ))
            )
            .addChildrenFromMaterials(List.of(
                BRICKS,
                BRICK_STAIRS,
                BRICK_SLAB,
                BRICK_WALL,
                BRICK,
                MUD_BRICKS,
                MUD_BRICK_STAIRS,
                MUD_BRICK_SLAB,
                MUD_BRICK_WALL
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(RESIN_BRICKS, true),
                new MaterialNode(RESIN_BRICK_STAIRS),
                new MaterialNode(RESIN_BRICK_SLAB),
                new MaterialNode(RESIN_BRICK_WALL),
                new MaterialNode(CHISELED_RESIN_BRICKS)
            ))
            .addChild(new MaterialNode(CALCITE, true))
            ;
    }

    public static TreeNode FOOD_CATEGORY() {
        return new CategoryNode(
            APPLE,
            "category_food",
            "Food",
            "Yum"
        )
            .addChildrenFromMaterials(List.of(
                BEEF,
                COOKED_BEEF,
                PORKCHOP,
                COOKED_PORKCHOP,
                MUTTON,
                COOKED_MUTTON,
                CHICKEN,
                COOKED_CHICKEN,
                RABBIT,
                COOKED_RABBIT,
                COD,
                COOKED_COD,
                SALMON,
                COOKED_SALMON
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(APPLE),
                new MaterialNode(GOLDEN_APPLE),
                new MaterialNode(ENCHANTED_GOLDEN_APPLE),
                new MaterialNode(CAKE),
                new MaterialNode(BREAD),
                new MaterialNode(COOKIE),
                new MaterialNode(PUMPKIN_PIE),
                new MaterialNode(PUFFERFISH, true),
                new MaterialNode(TROPICAL_FISH),
                new MaterialNode(CARROT, true),
                new MaterialNode(GOLDEN_CARROT, true),
                new MaterialNode(POTATO, true),
                new MaterialNode(BAKED_POTATO),
                new MaterialNode(POISONOUS_POTATO)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(BEETROOT, true),
                new MaterialNode(MELON_SLICE),
                new MaterialNode(SWEET_BERRIES, true),
                new MaterialNode(GLOW_BERRIES, true),
                new MaterialNode(DRIED_KELP),
                new MaterialNode(CHORUS_FRUIT, true),
                new MaterialNode(SUSPICIOUS_STEW),
                new MaterialNode(MUSHROOM_STEW),
                new MaterialNode(BEETROOT_SOUP),
                new MaterialNode(RABBIT_STEW),
                new MaterialNode(HONEY_BOTTLE),
                new MaterialNode(ROTTEN_FLESH, true),
                new MaterialNode(SPIDER_EYE, true)
            ))
            ;
    }

    public static TreeNode COPPER_CATEGORY() {
        return new CategoryNode(
            COPPER_BLOCK,
            "category_copper",
            "Copper",
            ""
        )
            .addChild(new CategoryNode(
                    CHISELED_COPPER,
                    "category_copper_copper",
                    "Copper",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(COPPER_BLOCK, true),
                        new MaterialNode(CHISELED_COPPER),
                        new MaterialNode(COPPER_GRATE),
                        new MaterialNode(CUT_COPPER),
                        new MaterialNode(CUT_COPPER_STAIRS),
                        new MaterialNode(CUT_COPPER_SLAB),
                        new MaterialNode(COPPER_DOOR),
                        new MaterialNode(COPPER_TRAPDOOR),
                        new MaterialNode(COPPER_BULB)
                    ))
                    .addChildrenFromMaterials(List.of(
                        WAXED_COPPER_BLOCK,
                        WAXED_CHISELED_COPPER,
                        WAXED_COPPER_GRATE,
                        WAXED_CUT_COPPER,
                        WAXED_CUT_COPPER_STAIRS,
                        WAXED_CUT_COPPER_SLAB,
                        WAXED_COPPER_DOOR,
                        WAXED_COPPER_TRAPDOOR,
                        WAXED_COPPER_BULB
                    ))
            )
            .addChild(new CategoryNode(
                    EXPOSED_CHISELED_COPPER,
                    "category_copper_exposed",
                    "Exposed",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        EXPOSED_COPPER,
                        EXPOSED_CHISELED_COPPER,
                        EXPOSED_COPPER_GRATE,
                        EXPOSED_CUT_COPPER,
                        EXPOSED_CUT_COPPER_STAIRS,
                        EXPOSED_CUT_COPPER_SLAB,
                        EXPOSED_COPPER_DOOR,
                        EXPOSED_COPPER_TRAPDOOR,
                        EXPOSED_COPPER_BULB
                    ))
                    .addChildrenFromMaterials(List.of(
                        WAXED_EXPOSED_COPPER,
                        WAXED_EXPOSED_CHISELED_COPPER,
                        WAXED_EXPOSED_COPPER_GRATE,
                        WAXED_EXPOSED_CUT_COPPER,
                        WAXED_EXPOSED_CUT_COPPER_STAIRS,
                        WAXED_EXPOSED_CUT_COPPER_SLAB,
                        WAXED_EXPOSED_COPPER_DOOR,
                        WAXED_EXPOSED_COPPER_TRAPDOOR,
                        WAXED_EXPOSED_COPPER_BULB
                    ))
            )
            .addChild(new CategoryNode(
                    WEATHERED_CHISELED_COPPER,
                    "category_copper_weathered",
                    "Weathered",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        WEATHERED_COPPER,
                        WEATHERED_CHISELED_COPPER,
                        WEATHERED_COPPER_GRATE,
                        WEATHERED_CUT_COPPER,
                        WEATHERED_CUT_COPPER_STAIRS,
                        WEATHERED_CUT_COPPER_SLAB,
                        WEATHERED_COPPER_DOOR,
                        WEATHERED_COPPER_TRAPDOOR,
                        WEATHERED_COPPER_BULB
                    ))
                    .addChildrenFromMaterials(List.of(
                        WAXED_WEATHERED_COPPER,
                        WAXED_WEATHERED_CHISELED_COPPER,
                        WAXED_WEATHERED_COPPER_GRATE,
                        WAXED_WEATHERED_CUT_COPPER,
                        WAXED_WEATHERED_CUT_COPPER_STAIRS,
                        WAXED_WEATHERED_CUT_COPPER_SLAB,
                        WAXED_WEATHERED_COPPER_DOOR,
                        WAXED_WEATHERED_COPPER_TRAPDOOR,
                        WAXED_WEATHERED_COPPER_BULB
                    ))

            )
            .addChild(new CategoryNode(
                    WEATHERED_CHISELED_COPPER,
                    "category_copper_oxidised",
                    "Oxidised",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        OXIDIZED_COPPER,
                        OXIDIZED_CHISELED_COPPER,
                        OXIDIZED_COPPER_GRATE,
                        OXIDIZED_CUT_COPPER,
                        OXIDIZED_CUT_COPPER_STAIRS,
                        OXIDIZED_CUT_COPPER_SLAB,
                        OXIDIZED_COPPER_DOOR,
                        OXIDIZED_COPPER_TRAPDOOR,
                        OXIDIZED_COPPER_BULB
                    ))
                    .addChildrenFromMaterials(List.of(
                        WAXED_OXIDIZED_COPPER,
                        WAXED_OXIDIZED_CHISELED_COPPER,
                        WAXED_OXIDIZED_COPPER_GRATE,
                        WAXED_OXIDIZED_CUT_COPPER,
                        WAXED_OXIDIZED_CUT_COPPER_STAIRS,
                        WAXED_OXIDIZED_CUT_COPPER_SLAB,
                        WAXED_OXIDIZED_COPPER_DOOR,
                        WAXED_OXIDIZED_COPPER_TRAPDOOR,
                        WAXED_OXIDIZED_COPPER_BULB
                    ))

            );
    }

    public static TreeNode NATURAL_CATEGORY() {
        return new CategoryNode(
            GRASS_BLOCK,
            "category_natural",
            "Natural",
            ""
        )
            .addChild(FOOD_CATEGORY())
            .addChild(new CategoryNode(
                    WHEAT,
                    "category_natural_crops",
                    "Crops",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(WHEAT_SEEDS),
                        new MaterialNode(WHEAT),
                        new MaterialNode(BEETROOT_SEEDS),
                        new MaterialNode(BEETROOT, true),
                        new MaterialNode(CARROT, true),
                        new MaterialNode(POTATO, true),
                        new MaterialNode(MELON_SEEDS),
                        new MaterialNode(MELON),
                        new MaterialNode(PUMPKIN_SEEDS),
                        new MaterialNode(PUMPKIN),
                        new MaterialNode(CARVED_PUMPKIN),
                        new MaterialNode(JACK_O_LANTERN),
                        new MaterialNode(COCOA_BEANS),
                        new MaterialNode(SUGAR_CANE)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(TORCHFLOWER_SEEDS),
                        new MaterialNode(TORCHFLOWER, true),
                        new MaterialNode(PITCHER_POD),
                        new MaterialNode(PITCHER_PLANT, true),
                        new MaterialNode(SWEET_BERRIES, true),
                        new MaterialNode(CACTUS),
                        new MaterialNode(RED_MUSHROOM),
                        new MaterialNode(BROWN_MUSHROOM),
                        new MaterialNode(GLOW_BERRIES, true),
                        new MaterialNode(NETHER_WART, true)
                    ))
            )
            .addChildrenFromMaterials(List.of(
                SHORT_GRASS,
                FERN,
                DEAD_BUSH,
                VINE,
                TALL_GRASS,
                LARGE_FERN
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(GRASS_BLOCK),
                new MaterialNode(PODZOL),
                new MaterialNode(MYCELIUM),
                new MaterialNode(DIRT),
                new MaterialNode(COARSE_DIRT),
                new MaterialNode(ROOTED_DIRT),
                new MaterialNode(MUD),
                new MaterialNode(CLAY, true),
                new MaterialNode(PACKED_MUD),
                new MaterialNode(GRAVEL),
                new MaterialNode(SAND, true),
                new MaterialNode(RED_SAND, true),
                new MaterialNode(BROWN_MUSHROOM_BLOCK),
                new MaterialNode(RED_MUSHROOM_BLOCK),
                new MaterialNode(MUSHROOM_STEM),
                new MaterialNode(DRIED_KELP_BLOCK),
                new MaterialNode(HAY_BLOCK)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(ICE),
                new MaterialNode(PACKED_ICE),
                new MaterialNode(BLUE_ICE),
                new MaterialNode(SNOW_BLOCK),
                new MaterialNode(SNOW),
                new MaterialNode(MOSS_BLOCK, true),
                new MaterialNode(MOSS_CARPET, true),
                new MaterialNode(PALE_MOSS_BLOCK),
                new MaterialNode(PALE_MOSS_CARPET),
                new MaterialNode(PALE_HANGING_MOSS)
            ))
            .addChild(new CategoryNode(
                    OXEYE_DAISY,
                    "category_natural_flowers",
                    "Flowers",
                    ""
                )
                    .addChild(new MaterialNode(FLOWER_POT))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(DANDELION),
                        new MaterialNode(POPPY),
                        new MaterialNode(BLUE_ORCHID),
                        new MaterialNode(ALLIUM),
                        new MaterialNode(AZURE_BLUET),
                        new MaterialNode(RED_TULIP),
                        new MaterialNode(ORANGE_TULIP),
                        new MaterialNode(WHITE_TULIP),
                        new MaterialNode(PINK_TULIP),
                        new MaterialNode(OXEYE_DAISY),
                        new MaterialNode(CORNFLOWER),
                        new MaterialNode(LILY_OF_THE_VALLEY)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(TORCHFLOWER, true),
                        new MaterialNode(CLOSED_EYEBLOSSOM),
                        new MaterialNode(OPEN_EYEBLOSSOM),
                        new MaterialNode(WITHER_ROSE),
                        new MaterialNode(PINK_PETALS),
                        new MaterialNode(SPORE_BLOSSOM, true),
                        new MaterialNode(SUNFLOWER),
                        new MaterialNode(LILAC),
                        new MaterialNode(ROSE_BUSH),
                        new MaterialNode(PEONY),
                        new MaterialNode(PITCHER_PLANT, true)
                    ))
            )
            .addChild(new CategoryNode(
                    SAND,
                    "category_natural_sand",
                    "Sands of Time",
                    "Tick Tock"
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(SAND, true),
                        new MaterialNode(SANDSTONE),
                        new MaterialNode(SANDSTONE_STAIRS),
                        new MaterialNode(SANDSTONE_SLAB),
                        new MaterialNode(SANDSTONE_WALL),
                        new MaterialNode(CHISELED_SANDSTONE),
                        new MaterialNode(SMOOTH_SANDSTONE),
                        new MaterialNode(SMOOTH_SANDSTONE_STAIRS),
                        new MaterialNode(SMOOTH_SANDSTONE_SLAB),
                        new MaterialNode(CUT_SANDSTONE),
                        new MaterialNode(CUT_SANDSTONE_SLAB)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(RED_SAND, true),
                        new MaterialNode(RED_SANDSTONE),
                        new MaterialNode(RED_SANDSTONE_STAIRS),
                        new MaterialNode(RED_SANDSTONE_SLAB),
                        new MaterialNode(RED_SANDSTONE_WALL),
                        new MaterialNode(CHISELED_RED_SANDSTONE),
                        new MaterialNode(SMOOTH_RED_SANDSTONE),
                        new MaterialNode(SMOOTH_RED_SANDSTONE_STAIRS),
                        new MaterialNode(SMOOTH_RED_SANDSTONE_SLAB),
                        new MaterialNode(CUT_RED_SANDSTONE),
                        new MaterialNode(CUT_RED_SANDSTONE_SLAB)
                    ))
            )
            .addChild(new CategoryNode(
                    BRAIN_CORAL,
                    "category_natural_coral",
                    "Coral",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        TUBE_CORAL_BLOCK,
                        BRAIN_CORAL_BLOCK,
                        BUBBLE_CORAL_BLOCK,
                        FIRE_CORAL_BLOCK,
                        HORN_CORAL_BLOCK,
                        DEAD_TUBE_CORAL_BLOCK,
                        DEAD_BRAIN_CORAL_BLOCK,
                        DEAD_BUBBLE_CORAL_BLOCK,
                        DEAD_FIRE_CORAL_BLOCK,
                        DEAD_HORN_CORAL_BLOCK
                    ))
                    .addChildrenFromMaterials(List.of(
                        TUBE_CORAL,
                        BRAIN_CORAL,
                        BUBBLE_CORAL,
                        FIRE_CORAL,
                        HORN_CORAL,
                        DEAD_TUBE_CORAL,
                        DEAD_BRAIN_CORAL,
                        DEAD_BUBBLE_CORAL,
                        DEAD_FIRE_CORAL,
                        DEAD_HORN_CORAL
                    ))
                    .addChildrenFromMaterials(List.of(
                        TUBE_CORAL_FAN,
                        BRAIN_CORAL_FAN,
                        BUBBLE_CORAL_FAN,
                        FIRE_CORAL_FAN,
                        HORN_CORAL_FAN,
                        DEAD_TUBE_CORAL_FAN,
                        DEAD_BRAIN_CORAL_FAN,
                        DEAD_BUBBLE_CORAL_FAN,
                        DEAD_FIRE_CORAL_FAN,
                        DEAD_HORN_CORAL_FAN
                    ))
            )
            ;
    }

    public static TreeNode NETHER_CATEGORY() {
        return new CategoryNode(
            NETHERRACK,
            "category_nether",
            "Nether",
            ""
        )
            .addChild(new CategoryNode(
                    BLACKSTONE,
                    "category_nether_blackstone",
                    "Blackstone",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        BLACKSTONE,
                        BLACKSTONE_STAIRS,
                        BLACKSTONE_SLAB,
                        BLACKSTONE_WALL,
                        POLISHED_BLACKSTONE,
                        POLISHED_BLACKSTONE_STAIRS,
                        POLISHED_BLACKSTONE_SLAB,
                        POLISHED_BLACKSTONE_WALL
                    ))
                    .addChildrenFromMaterials(List.of(
                        POLISHED_BLACKSTONE_BRICKS,
                        POLISHED_BLACKSTONE_BRICK_STAIRS,
                        POLISHED_BLACKSTONE_BRICK_SLAB,
                        POLISHED_BLACKSTONE_BRICK_WALL,
                        GILDED_BLACKSTONE,
                        CHISELED_POLISHED_BLACKSTONE,
                        CRACKED_POLISHED_BLACKSTONE_BRICKS,
                        POLISHED_BLACKSTONE_PRESSURE_PLATE,
                        POLISHED_BLACKSTONE_BUTTON
                    ))
            )
            .addChildrenFromMaterials(List.of(
                QUARTZ,
                QUARTZ_BLOCK,
                QUARTZ_STAIRS,
                QUARTZ_SLAB,
                CHISELED_QUARTZ_BLOCK,
                QUARTZ_BRICKS,
                QUARTZ_PILLAR,
                SMOOTH_QUARTZ,
                SMOOTH_QUARTZ_STAIRS,
                SMOOTH_QUARTZ_SLAB,
                NETHER_QUARTZ_ORE
            ))
            .addChildrenFromMaterials(List.of(
                NETHER_BRICKS,
                NETHER_BRICK_STAIRS,
                NETHER_BRICK_SLAB,
                NETHER_BRICK_WALL,
                NETHER_BRICK,
                CRACKED_NETHER_BRICKS,
                CHISELED_NETHER_BRICKS,
                NETHER_BRICK_FENCE,
                RED_NETHER_BRICKS,
                RED_NETHER_BRICK_STAIRS,
                RED_NETHER_BRICK_SLAB,
                RED_NETHER_BRICK_WALL
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(NETHERRACK),
                new MaterialNode(CRIMSON_NYLIUM),
                new MaterialNode(CRIMSON_ROOTS),
                new MaterialNode(WEEPING_VINES),
                new MaterialNode(WARPED_NYLIUM),
                new MaterialNode(NETHER_SPROUTS),
                new MaterialNode(WARPED_ROOTS),
                new MaterialNode(TWISTING_VINES),
                new MaterialNode(NETHER_WART, true),
                new MaterialNode(SHROOMLIGHT)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(SOUL_SAND),
                new MaterialNode(SOUL_SOIL),
                new MaterialNode(BONE_BLOCK),
                new MaterialNode(GLOWSTONE),
                new MaterialNode(GLOWSTONE_DUST, true),
                new MaterialNode(CRYING_OBSIDIAN),
                new MaterialNode(MAGMA_CREAM, true),
                new MaterialNode(MAGMA_BLOCK),
                new MaterialNode(BASALT),
                new MaterialNode(POLISHED_BASALT),
                new MaterialNode(SMOOTH_BASALT),
                new MaterialNode(NETHER_GOLD_ORE),
                new MaterialNode(RESPAWN_ANCHOR),
                new MaterialNode(LODESTONE, true),
                new MaterialNode(ANCIENT_DEBRIS, true),
                new MaterialNode(MUSIC_DISC_PIGSTEP, true)
            ))
            ;
    }

    public static TreeNode ARCHEOLOGY_CATEGORY() {
        return new CategoryNode(
            BRUSH,
            "category_archeology",
            "Archeology",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(SUSPICIOUS_SAND),
                new MaterialNode(SUSPICIOUS_GRAVEL),
                new MaterialNode(BRUSH, true),
                new MaterialNode(DECORATED_POT)
            ))
            .addChild(new CategoryNode(
                    SUSPICIOUS_SAND,
                    "category_archeology_sherds",
                    "Sherds",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        ANGLER_POTTERY_SHERD,
                        ARCHER_POTTERY_SHERD,
                        ARMS_UP_POTTERY_SHERD,
                        BLADE_POTTERY_SHERD,
                        BREWER_POTTERY_SHERD,
                        BURN_POTTERY_SHERD,
                        DANGER_POTTERY_SHERD,
                        FLOW_POTTERY_SHERD,
                        EXPLORER_POTTERY_SHERD,
                        FRIEND_POTTERY_SHERD,
                        GUSTER_POTTERY_SHERD,
                        HEART_POTTERY_SHERD
                    ))
                    .addChildrenFromMaterials(List.of(
                        HEARTBREAK_POTTERY_SHERD,
                        HOWL_POTTERY_SHERD,
                        MINER_POTTERY_SHERD,
                        MOURNER_POTTERY_SHERD,
                        PLENTY_POTTERY_SHERD,
                        PRIZE_POTTERY_SHERD,
                        SCRAPE_POTTERY_SHERD,
                        SHEAF_POTTERY_SHERD,
                        SHELTER_POTTERY_SHERD,
                        SKULL_POTTERY_SHERD,
                        SNORT_POTTERY_SHERD
                    ))
            )
            ;
    }

    public static TreeNode CAVE_CATEGORY() {
        return new CategoryNode(
            FLOWERING_AZALEA_LEAVES,
            "category_cave",
            "Caves",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(CLAY, true),
                new MaterialNode(MOSS_BLOCK, true),
                new MaterialNode(MOSS_CARPET, true),
                new MaterialNode(AZALEA_LEAVES),
                new MaterialNode(FLOWERING_AZALEA_LEAVES),
                new MaterialNode(AZALEA),
                new MaterialNode(FLOWERING_AZALEA),
                new MaterialNode(SPORE_BLOSSOM, true),
                new MaterialNode(BIG_DRIPLEAF),
                new MaterialNode(SMALL_DRIPLEAF),
                new MaterialNode(GLOW_BERRIES, true),
                new MaterialNode(HANGING_ROOTS)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(AMETHYST_SHARD),
                new MaterialNode(AMETHYST_BLOCK),
                new MaterialNode(SMALL_AMETHYST_BUD),
                new MaterialNode(MEDIUM_AMETHYST_BUD),
                new MaterialNode(LARGE_AMETHYST_BUD),
                new MaterialNode(AMETHYST_CLUSTER),
                new MaterialNode(CALCITE, true),
                new MaterialNode(TUFF, true)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(DRIPSTONE_BLOCK),
                new MaterialNode(POINTED_DRIPSTONE),
                new MaterialNode(OBSIDIAN),
                new MaterialNode(GLOW_LICHEN),
                new MaterialNode(COBWEB, true)
            ))
            .addChild(new CategoryNode(
                    SCULK,
                    "category_cave_deep_dark",
                    "The Deep Dark",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(DISC_FRAGMENT_5),
                        new MaterialNode(MUSIC_DISC_5, true),
                        new MaterialNode(ECHO_SHARD),
                        new MaterialNode(WARD_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(RECOVERY_COMPASS)
                    ))
                    .addChildrenFromMaterials(List.of(
                        SCULK,
                        SCULK_VEIN,
                        SCULK_CATALYST,
                        SCULK_SHRIEKER,
                        SCULK_SENSOR
                    ))
            )
            .addChild(new CategoryNode(
                    VAULT,
                    "category_cave_trial_chamber",
                    "Trial Chambers",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(TRIAL_KEY),
                        new MaterialNode(OMINOUS_TRIAL_KEY),
                        new MaterialNode(BREEZE_ROD, true),
                        new MaterialNode(SLIME_BALL, true),
                        new MaterialNode(WIND_CHARGE, true),
                        new MaterialNode(HEAVY_CORE),
                        new MaterialNode(OMINOUS_BOTTLE),
                        new MaterialNode(FLOW_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(BOLT_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(MUSIC_DISC_PRECIPICE, true),
                        new MaterialNode(MUSIC_DISC_CREATOR, true),
                        new MaterialNode(GUSTER_BANNER_PATTERN, true),
                        new MaterialNode(FLOW_BANNER_PATTERN, true)
                    ))
            )
            ;
    }

    public static TreeNode MUSIC_DISC_CATEGORY() {
        return new CategoryNode(
            JUKEBOX,
            "category_music_disc",
            "Music Discs",
            ""
        )
            .addChild(new MaterialNode(JUKEBOX))
            .addChild(new CategoryNode(
                    MUSIC_DISC_OTHERSIDE,
                    "category_music_disc_record",
                    "Records",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        MUSIC_DISC_CAT,
                        MUSIC_DISC_BLOCKS,
                        MUSIC_DISC_CHIRP,
                        MUSIC_DISC_FAR,
                        MUSIC_DISC_MALL,
                        MUSIC_DISC_MELLOHI,
                        MUSIC_DISC_STAL,
                        MUSIC_DISC_STRAD,
                        MUSIC_DISC_WARD,
                        MUSIC_DISC_WAIT
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(MUSIC_DISC_11),
                        new MaterialNode(MUSIC_DISC_13),
                        new MaterialNode(MUSIC_DISC_CREATOR_MUSIC_BOX),
                        new MaterialNode(MUSIC_DISC_CREATOR, true),
                        new MaterialNode(MUSIC_DISC_PRECIPICE, true),
                        new MaterialNode(MUSIC_DISC_OTHERSIDE),
                        new MaterialNode(MUSIC_DISC_RELIC),
                        new MaterialNode(MUSIC_DISC_5, true),
                        new MaterialNode(MUSIC_DISC_PIGSTEP, true)
                    ))
            )
            ;
    }

    public static TreeNode SMITHING_CATEGORY() {
        return new CategoryNode(
            SMITHING_TABLE,
            "category_smithing",
            "Smithing",
            ""
        )
            .addChild(new CategoryNode(
                    SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
                    "category_armour_trims",
                    "Armour Trims",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(VEX_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(WILD_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(COAST_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(DUNE_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(RAISER_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(HOST_ARMOR_TRIM_SMITHING_TEMPLATE)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(WARD_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(TIDE_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(RIB_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(EYE_ARMOR_TRIM_SMITHING_TEMPLATE),
                        new MaterialNode(SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(FLOW_ARMOR_TRIM_SMITHING_TEMPLATE, true),
                        new MaterialNode(BOLT_ARMOR_TRIM_SMITHING_TEMPLATE, true)
                    ))
            )
            .addChildrenFromNodes(List.of(
                new MaterialNode(SMITHING_TABLE, true),
                new MaterialNode(NETHERITE_UPGRADE_SMITHING_TEMPLATE)
            ))
            ;
    }

    public static TreeNode END_CATEGORY() {
        return new CategoryNode(
            END_STONE,
            "category_end",
            "The End",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(END_STONE),
                new MaterialNode(END_STONE_BRICKS),
                new MaterialNode(END_STONE_BRICK_STAIRS),
                new MaterialNode(END_STONE_BRICK_SLAB),
                new MaterialNode(END_STONE_BRICK_WALL),
                new MaterialNode(PURPUR_BLOCK),
                new MaterialNode(PURPUR_PILLAR),
                new MaterialNode(PURPUR_STAIRS),
                new MaterialNode(PURPUR_SLAB),
                new MaterialNode(END_ROD),
                new MaterialNode(END_CRYSTAL),
                new MaterialNode(ENDER_CHEST)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(DRAGON_EGG),
                new MaterialNode(DRAGON_HEAD, true),
                new MaterialNode(ENDER_EYE),
                new MaterialNode(ELYTRA),
                new MaterialNode(ENDER_PEARL, true),
                new MaterialNode(CHORUS_FRUIT, true),
                new MaterialNode(POPPED_CHORUS_FRUIT),
                new MaterialNode(CHORUS_FLOWER),
                new MaterialNode(SHULKER_SHELL, true),
                new MaterialNode(DRAGON_BREATH, true),
                new MaterialNode(SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, true)
            ))
            ;
    }

    public static TreeNode UTILITY_CATEGORY() {
        return new CategoryNode(
            CRAFTING_TABLE,
            "category_utility",
            "Utility Blocks",
            ""
        )
            .addChild(new CategoryNode(
                    BLAST_FURNACE,
                    "category_utility_workstations",
                    "Workstations",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(CRAFTING_TABLE),
                        new MaterialNode(CRAFTER, true),
                        new MaterialNode(CHEST),
                        new MaterialNode(STONECUTTER),
                        new MaterialNode(LOOM),
                        new MaterialNode(CARTOGRAPHY_TABLE),
                        new MaterialNode(FURNACE),
                        new MaterialNode(BLAST_FURNACE),
                        new MaterialNode(SMOKER),
                        new MaterialNode(SMITHING_TABLE, true),
                        new MaterialNode(ANVIL)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(CHIPPED_ANVIL),
                        new MaterialNode(DAMAGED_ANVIL),
                        new MaterialNode(ENCHANTING_TABLE, true),
                        new MaterialNode(GRINDSTONE),
                        new MaterialNode(FLETCHING_TABLE),
                        new MaterialNode(BARREL),
                        new MaterialNode(LECTERN),
                        new MaterialNode(COMPOSTER),
                        new MaterialNode(CAULDRON),
                        new MaterialNode(BREWING_STAND, true)
                    ))
            )
            .addChild(new CategoryNode(
                    TORCH,
                    "category_utility_light",
                    "Light Sources",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        TORCH,
                        SOUL_TORCH,
                        LANTERN,
                        SOUL_LANTERN,
                        CAMPFIRE,
                        SOUL_CAMPFIRE
                    ))
            )
            .addChildrenFromNodes(List.of(
                new MaterialNode(SCAFFOLDING),
                new MaterialNode(LADDER),
                new MaterialNode(LODESTONE, true)
            ))
            ;
    }

    public static TreeNode OCEAN_CATEGORY() {
        return new CategoryNode(
            PRISMARINE,
            "category_ocean",
            "Ocean",
            ""
        )
            .addChildrenFromMaterials(List.of(
                PRISMARINE,
                PRISMARINE_STAIRS,
                PRISMARINE_SLAB,
                PRISMARINE_WALL,
                PRISMARINE_BRICKS,
                PRISMARINE_BRICK_STAIRS,
                PRISMARINE_BRICK_SLAB,
                DARK_PRISMARINE,
                DARK_PRISMARINE_STAIRS,
                DARK_PRISMARINE_SLAB,
                PRISMARINE_SHARD,
                PRISMARINE_CRYSTALS,
                SEA_LANTERN,
                KELP,
                LILY_PAD,
                SEA_PICKLE,
                SEAGRASS,
                HEART_OF_THE_SEA,
                CONDUIT,
                SPONGE,
                WET_SPONGE
            ))
            ;
    }

    public static TreeNode ENCHANTING_CATEGORY() {
        return new CategoryNode(
            ENCHANTING_TABLE,
            "category_enchanting",
            "Enchanting",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(ENCHANTING_TABLE, true),
                new MaterialNode(BOOKSHELF),
                new MaterialNode(CHISELED_BOOKSHELF),
                new MaterialNode(BOOK),
                new MaterialNode(EXPERIENCE_BOTTLE)
            ))
            .addChild(new CategoryNode(
                    ENCHANTED_BOOK,
                    "category_enchanting_books",
                    "Enchanted Books",
                    ""
                )
                    .addChild(new MaterialNode(ENCHANTED_BOOK))
            )
            ;
    }

    public static TreeNode REDSTONE_CATEGORY() {
        return new CategoryNode(
            REDSTONE,
            "category_redstone",
            "Redstone",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(REDSTONE, true),
                new MaterialNode(REDSTONE_TORCH),
                new MaterialNode(REDSTONE_BLOCK, true),
                new MaterialNode(REPEATER),
                new MaterialNode(COMPARATOR),
                new MaterialNode(TARGET),
                new MaterialNode(LEVER),
                new MaterialNode(LIGHT_WEIGHTED_PRESSURE_PLATE),
                new MaterialNode(HEAVY_WEIGHTED_PRESSURE_PLATE),
                new MaterialNode(CALIBRATED_SCULK_SENSOR),
                new MaterialNode(TRIPWIRE_HOOK),
                new MaterialNode(DAYLIGHT_DETECTOR),
                new MaterialNode(LIGHTNING_ROD)
            ))
            .addChildrenFromNodes(List.of(
                new MaterialNode(PISTON),
                new MaterialNode(STICKY_PISTON),
                new MaterialNode(SLIME_BLOCK, true),
                new MaterialNode(HONEY_BLOCK),
                new MaterialNode(DISPENSER),
                new MaterialNode(DROPPER),
                new MaterialNode(CRAFTER, true),
                new MaterialNode(HOPPER),
                new MaterialNode(TRAPPED_CHEST),
                new MaterialNode(OBSERVER),
                new MaterialNode(NOTE_BLOCK),
                new MaterialNode(REDSTONE_LAMP),
                new MaterialNode(TNT)
            ))
            .addChild(new CategoryNode(
                    MINECART,
                    "category_redstone_minecart",
                    "Minecarts",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        RAIL,
                        POWERED_RAIL,
                        DETECTOR_RAIL,
                        ACTIVATOR_RAIL,
                        MINECART,
                        HOPPER_MINECART,
                        CHEST_MINECART,
                        FURNACE_MINECART,
                        TNT_MINECART
                    ))
            )
            ;
    }

    public static TreeNode MOB_DROP_CATEGORY() {
        return new CategoryNode(
            CREEPER_HEAD,
            "category_mob_drop",
            "Mob Drops",
            ""
        )
            .addChild(new CategoryNode(
                    ROTTEN_FLESH,
                    "category_mob_drop_loot",
                    "Mob Loot",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(ROTTEN_FLESH, true),
                        new MaterialNode(BONE),
                        new MaterialNode(SPIDER_EYE, true),
                        new MaterialNode(STRING),
                        new MaterialNode(ENDER_PEARL, true),
                        new MaterialNode(GUNPOWDER, true),
                        new MaterialNode(SHULKER_SHELL, true),
                        new MaterialNode(WIND_CHARGE, true),
                        new MaterialNode(GHAST_TEAR, true),
                        new MaterialNode(MAGMA_CREAM, true),
                        new MaterialNode(PHANTOM_MEMBRANE, true),
                        new MaterialNode(NETHER_STAR),
                        new MaterialNode(BLAZE_ROD),
                        new MaterialNode(BREEZE_ROD, true),
                        new MaterialNode(NAUTILUS_SHELL),
                        new MaterialNode(SLIME_BALL, true),
                        new MaterialNode(TOTEM_OF_UNDYING, true)
                    ))
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(FEATHER),
                        new MaterialNode(EGG),
                        new MaterialNode(LEATHER),
                        new MaterialNode(RABBIT_HIDE),
                        new MaterialNode(RABBIT_FOOT, true),
                        new MaterialNode(INK_SAC),
                        new MaterialNode(GLOW_INK_SAC),
                        new MaterialNode(ARMADILLO_SCUTE),
                        new MaterialNode(TURTLE_SCUTE)
                    ))
            )
            .addChildrenFromMaterials(List.of(
                TURTLE_EGG,
                SNIFFER_EGG,
                BEE_NEST,
                BEEHIVE,
                OCHRE_FROGLIGHT,
                VERDANT_FROGLIGHT,
                PEARLESCENT_FROGLIGHT
            ))
            .addChild(new CategoryNode(
                    WITHER_SKELETON_SKULL,
                    "category_mob_drop_heads",
                    "Mob Heads",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(SKELETON_SKULL),
                        new MaterialNode(WITHER_SKELETON_SKULL),
                        new MaterialNode(ZOMBIE_HEAD),
                        new MaterialNode(CREEPER_HEAD),
                        new MaterialNode(PIGLIN_HEAD),
                        new MaterialNode(DRAGON_HEAD, true)
                    ))
            )
            ;
    }

    public static TreeNode BANNER_CATEGORY() {
        return new CategoryNode(
            CREEPER_HEAD,
            "category_banner_patterns",
            "Mob Drops",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(FIELD_MASONED_BANNER_PATTERN),
                new MaterialNode(BORDURE_INDENTED_BANNER_PATTERN),
                new MaterialNode(FLOWER_BANNER_PATTERN),
                new MaterialNode(CREEPER_BANNER_PATTERN),
                new MaterialNode(SKULL_BANNER_PATTERN),
                new MaterialNode(MOJANG_BANNER_PATTERN),
                new MaterialNode(GLOBE_BANNER_PATTERN),
                new MaterialNode(PIGLIN_BANNER_PATTERN),
                new MaterialNode(FLOW_BANNER_PATTERN, true),
                new MaterialNode(GUSTER_BANNER_PATTERN, true)
            ))
            ;
    }

    public static TreeNode BREWING_CATEGORY() {
        return new CategoryNode(
            BREWING_STAND,
            "category_brewing",
            "Brewing",
            ""
        )
            .addChildrenFromNodes(List.of(
                new MaterialNode(BREWING_STAND, true),
                new MaterialNode(GLASS_BOTTLE),
                new MaterialNode(NETHER_WART, true),
                new MaterialNode(REDSTONE, true),
                new MaterialNode(GLOWSTONE_DUST, true),
                new MaterialNode(GUNPOWDER, true),
                new MaterialNode(DRAGON_BREATH, true)
            ))
            .addChild(new CategoryNode(
                    FERMENTED_SPIDER_EYE,
                    "category_brewing_ingredients",
                    "Ingredients",
                    ""
                )
                    .addChildrenFromNodes(List.of(
                        new MaterialNode(FERMENTED_SPIDER_EYE),
                        new MaterialNode(SUGAR),
                        new MaterialNode(RABBIT_FOOT, true),
                        new MaterialNode(BLAZE_POWDER),
                        new MaterialNode(GLISTERING_MELON_SLICE),
                        new MaterialNode(SPIDER_EYE, true),
                        new MaterialNode(GHAST_TEAR, true),
                        new MaterialNode(MAGMA_CREAM, true),
                        new MaterialNode(PUFFERFISH, true),
                        new MaterialNode(GOLDEN_CARROT, true),
                        new MaterialNode(TURTLE_HELMET, true),
                        new MaterialNode(PHANTOM_MEMBRANE, true),
                        new MaterialNode(BREEZE_ROD, true),
                        new MaterialNode(COBWEB, true),
                        new MaterialNode(SLIME_BLOCK, true),
                        new MaterialNode(STONE, true)
                    ))
            )
            .addChild(new CategoryNode(
                    POTION,
                    "category_brewing_potions",
                    "Potions",
                    ""
                )
                    .addChildrenFromMaterials(List.of(
                        POTION,
                        SPLASH_POTION,
                        LINGERING_POTION
                    ))
            )
            ;
    }

    public static TreeNode MATERIALS_CATEGORY() {
        return new CategoryNode(
            FLINT,
            "category_materials",
            "Materials",
            ""
        )
            .addChildrenFromMaterials(List.of(
                STICK,
                FLINT,
                CHARCOAL,
                CLAY_BALL,
                BOWL
            ))
            ;
    }

    private final CategoryNode root;

    private static final Set<Material> UNOBTAINIUM = CREATE_UNOBTAINIUM();

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
            .addChild(TOOLS_AND_WEAPONRY_CATEGORY())
            .addChild(COLOURED_CATEGORY())
            .addChild(MINERALS_CATEGORY())
            .addChild(WOOD_CATEGORY())
            .addChild(STONE_CATEGORY())
            .addChild(COPPER_CATEGORY())
            .addChild(NATURAL_CATEGORY())
            .addChild(NETHER_CATEGORY())
            .addChild(ARCHEOLOGY_CATEGORY())
            .addChild(CAVE_CATEGORY())
            .addChild(MUSIC_DISC_CATEGORY())
            .addChild(SMITHING_CATEGORY())
            .addChild(END_CATEGORY())
            .addChild(UTILITY_CATEGORY())
            .addChild(OCEAN_CATEGORY())
            .addChild(ENCHANTING_CATEGORY())
            .addChild(REDSTONE_CATEGORY())
            .addChild(MOB_DROP_CATEGORY())
            .addChild(BANNER_CATEGORY())
            .addChild(BREWING_CATEGORY())
            .addChild(MATERIALS_CATEGORY())
        ;
    }

    public void verify() {

        boolean hasMissing = hasMissingMaterials();
        boolean hasUnobtainables = hasUnobtainableMaterials();
        boolean hasUnallowedDuplicates = hasUnallowedDuplicateMaterials();
        boolean hasUnusedDuplicates = hasUnusedDuplicateMaterials();

        boolean isBad =
            hasMissing ||
                hasUnobtainables ||
                hasUnallowedDuplicates ||
                hasUnusedDuplicates;

        if (isBad) {
            String header = "ADVANCEMENT TREE CONTAINS ERRORS";
            PrintHeader(header);
        }
    }

    private Set<Material> getObtainableItems() {
        return new HashSet<>(List.of(Material.values())).stream()
            .filter(m -> !m.isLegacy())
            .filter(m -> !UNOBTAINIUM.contains(m))
            .filter(Material::isItem)
            .collect(Collectors.toSet());
    }

    private static void PrintErrorList(Set<Material> materials, String header, String found) {
        PrintHeader(header);

        String s2 = "Found %d %s.".formatted(materials.size(), found);

        LOGGER.severe(
            "| %s%s |".formatted(s2, " ".repeat(ErrorPrintWidth - 4 - s2.length())));

        if (materials.size() > MaxErrorListLength) {
            String s3 = "Here are the first %d:".formatted(MaxErrorListLength);
            LOGGER.severe("| %s%s |".formatted(s3, " ".repeat(ErrorPrintWidth - 4 - s3.length())));
        }

        materials.stream()
            .sorted(Comparator.comparing(Enum::ordinal))
            .limit(MaxErrorListLength)
            .forEach(m -> LOGGER.severe(
                "|  - %s%s |".formatted(m.name(),
                    " ".repeat(ErrorPrintWidth - 7 - m.name().length()))));
    }

    private static void PrintHeader(String header) {
        LOGGER.severe(HeaderCharacter.repeat(ErrorPrintWidth));
        LOGGER.severe("%s %s %s".formatted(
            HeaderCharacter.repeat((ErrorPrintWidth - header.length() - 2) / 2),
            header,
            HeaderCharacter.repeat(
                (ErrorPrintWidth - header.length() - 2) - ((ErrorPrintWidth - header.length() - 2)
                    / 2))
        ));
        LOGGER.severe(HeaderCharacter.repeat(ErrorPrintWidth));
    }

    private boolean hasMissingMaterials() {
        Set<Material> missingMaterials = getObtainableItems();

        this.root.traverse(node -> {
            if (!(node instanceof MaterialNode materialNode)) {
                return;
            }

            missingMaterials.remove(materialNode.getTargetMaterial());
        });

        boolean hasMissingMaterials = !missingMaterials.isEmpty();

        if (hasMissingMaterials) {
            PrintErrorList(
                missingMaterials,
                "MISSING MATERIAL DETECTED",
                "missing materials"
            );
        }

        return hasMissingMaterials;
    }

    private boolean hasUnobtainableMaterials() {
        Set<Material> unobtainableMaterials = new HashSet<>();

        this.root.traverse(node -> {
            if (!(node instanceof MaterialNode materialNode)) {
                return;
            }

            Material targetMaterial = materialNode.getTargetMaterial();

            if (UNOBTAINIUM.contains(targetMaterial)) {
                unobtainableMaterials.add(targetMaterial);
            }
        });

        boolean isGood = unobtainableMaterials.isEmpty();

        if (!isGood) {
            PrintErrorList(
                unobtainableMaterials,
                "UNOBTAINABLE MATERIAL DETECTED",
                "unobtainable materials"
            );
        }

        return isGood;
    }

    private boolean hasUnallowedDuplicateMaterials() {
        Map<Material, Integer> materialCount = new HashMap<>();
        Map<Material, Boolean> duplicatesAllowed = new HashMap<>();

        this.root.traverse(node -> {
            if (!(node instanceof MaterialNode materialNode)) {
                return;
            }

            Material targetMaterial = materialNode.getTargetMaterial();

            int num = materialCount.getOrDefault(targetMaterial, 0);
            boolean duplicateAllowed = duplicatesAllowed.getOrDefault(targetMaterial, true);

            materialCount.put(targetMaterial, num + 1);
            duplicatesAllowed.put(targetMaterial,
                duplicateAllowed && materialNode.duplicatesAllowed());
        });

        Set<Material> unauthorisedDuplicates = materialCount.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .filter(entry -> !duplicatesAllowed.get(entry.getKey()))
            .map(Entry::getKey)
            .collect(Collectors.toSet());

        boolean isGood = unauthorisedDuplicates.isEmpty();

        if (!isGood) {
            PrintErrorList(
                unauthorisedDuplicates,
                "UNAUTHORISED DUPLICATES DETECTED",
                "unauthorised duplicates"
            );
        }

        return isGood;
    }

    private boolean hasUnusedDuplicateMaterials() {
        Map<Material, Integer> materialCount = new HashMap<>();
        Map<Material, Boolean> duplicatesAllowed = new HashMap<>();

        this.root.traverse(node -> {
            if (!(node instanceof MaterialNode materialNode)) {
                return;
            }

            Material targetMaterial = materialNode.getTargetMaterial();

            int num = materialCount.getOrDefault(targetMaterial, 0);
            boolean duplicateAllowed = duplicatesAllowed.getOrDefault(targetMaterial, true);

            materialCount.put(targetMaterial, num + 1);
            duplicatesAllowed.put(targetMaterial,
                duplicateAllowed && materialNode.duplicatesAllowed());
        });

        Set<Material> unusedDuplicates = materialCount.entrySet().stream()
            .filter(entry -> entry.getValue() <= 1)
            .filter(entry -> duplicatesAllowed.get(entry.getKey()))
            .map(Entry::getKey)
            .collect(Collectors.toSet());

        boolean isGood = unusedDuplicates.isEmpty();

        if (!isGood) {
            PrintErrorList(
                unusedDuplicates,
                "UNUSED DUPLICATES DETECTED",
                "unused duplicates"
            );
        }

        return isGood;
    }
}
