package org.example.faintlocket.blockTracking;

import static org.bukkit.Material.*;

import java.util.List;
import java.util.Set;
import org.bukkit.Material;

@SuppressWarnings("DuplicatedCode")
public class MaterialTree {

    public static Set<Material> UNOBTAINIUM;

    static {
        UNOBTAINIUM = Set.of(
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

    private final TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public MaterialTree() {
        this.root = new MaterialNode(AIR)

//          ================================================================
//          ============================ WEAPONRY ==========================
//          ================================================================

            .addChild(new CategoryNode())
//            .addChild(GenLeatherWoodGearTree())
//            .addChild(GenChainStoneGearTree())
//            .addChild(GenIronGearTree())
//            .addChild(GenGoldGearTree())
            .addChild(GenDiamondGearTree())
            .addChild(GenNetheriteGearTree())
//            .addChild(GenMobItemsTree())
//            .addChild(GenMiscWeaponsTree())
//            .addChild(GenToolsTree())

//          ================================================================
//          =========================== ORGANICS ===========================
//          ================================================================

//            .addChild(GenMudTree())
//            .addChild(GenDirtTree())
//            .addChild(GenSandTree())
//            .addChild(GenRedSandTree())

//          ================================================================
//          ============================ COLOURS ===========================
//          ================================================================

//            .addChild(GenGlassTree())
//            .addChild(GenGlassPaneTree())
//            .addChild(GenConcreteTree())
//            .addChild(GenConcretePowderTree())
//            .addChild(GenTerracottaTree())
//            .addChild(GenGlazedTerracottaTree())
//            .addChild(GenWoolTree())
//            .addChild(GenCarpetTree())
//            .addChild(GenShulkerBoxTree())
//            .addChild(GenBedTree())
//            .addChild(GenCandleTree())
//            .addChild(GenBannerTree())
//            .addChild(GenBundleTree())
//            .addChild(GenDyeTree())

//          ================================================================
//          =========================== MINERALS ===========================
//          ================================================================

//            .addChild(GenAmethystTree())
//            .addChild(GenCopperTree())
//            .addChild(GenExposedCopperTree())
//            .addChild(GenWeatheredCopperTree())
//            .addChild(GenOxidisedCopperTree())
//            .addChild(GenQuartzTree())
//            .addChild(GenResinTree())
//            .addChild(GenCoalTree())

//          ================================================================
//          ============================ NATURE ============================
//          ================================================================

//            .addChild(GenFlowerTree())
//            .addChild(GenPlantTree())
//            .addChild(GenLushCaveTree())
//            .addChild(GenMushroomTree())
//            .addChild(GenMelonPumpkinTree())
//            .addChild(GenCropTree())
//            .addChild(GenFoodTree())
//            .addChild(GenMeatTree())
//            .addChild(GenFishTree())
//            .addChild(GenCoralBlockTree())
//            .addChild(GenCoralTree())
//            .addChild(GenCoralFanTree())
//            .addChild(GenMobDropTree())

//          ================================================================
//          ============================ NETHER ============================
//          ================================================================

//            .addChild(GenNetherTree())
//            .addChild(GenBlackstoneTree())
//            .addChild(GenNetherBrickTree())

//          ================================================================
//          ============================= STONE ============================
//          ================================================================

//            .addChild(GenStoneTree())
//            .addChild(GenStoneBrickTree())
//            .addChild(GenTuffTree())
//            .addChild(GenCobblestoneTree())
//            .addChild(GenGraniteTree())
//            .addChild(GenAndesiteTree())
//            .addChild(GenDioriteTree())
//            .addChild(GenDeepslateTree())
//            .addChild(GenDripstoneTree())
//            .addChild(GenPrismarineTree())
//            .addChild(GenBrickTree())

//          ================================================================
//          ============================= WOODS ============================
//          ================================================================

//            .addChild(GenOakTree())
//            .addChild(GenSpruceTree())
//            .addChild(GenBirchTree())
//            .addChild(GenJungleTree())
//            .addChild(GenAcaciaTree())
//            .addChild(GenCherryTree())
//            .addChild(GenDarkOakTree())
//            .addChild(GenPaleOakTree())
//            .addChild(GenMangroveTree())
//            .addChild(GenBambooTree())
//            .addChild(GenCrimsonStemTree())
//            .addChild(GenWarpedStemTree())

//          ================================================================
//          =========================== ARCHEOLOGY =========================
//          ================================================================

//            .addChild(GenArcheology1Tree())
//            .addChild(GenArcheology2Tree())
//            .addChild(GenSmithingTemplateTree())

//          ================================================================
//          ============================= MISC =============================
//          ================================================================

//            .addChild(GenTrialLootTree())
//            .addChild(GenSnowTree())
//            .addChild(GenAncientCityTree())
//            .addChild(GenEndTree())
//            .addChild(GenTradingTree())
//            .addChild(GenRedstoneTree())
//            .addChild(GenMinecartTree())
//            .addChild(GenBucketsTree())
//            .addChild(GenSkullTree())
//            .addChild(GenBrewingTree())
//            .addChild(GenEnchantingTree())
//            .addChild(GenMusicDiscTree())
//            .addChild(GenBannerPatternTree())
//            .addChild(GenMisc1Tree())
//            .addChild(GenMisc2Tree())

//          ================================================================
//          ======================== UNCATEGORISED =========================
//          ================================================================

//            .addChild(COBWEB)

//            .addChild(DRAGON_EGG)
//            .addChild(SNIFFER_EGG)
//            .addChild(TURTLE_EGG)

//            .addChild(ITEM_FRAME)
//            .addChild(GLOW_ITEM_FRAME)
//            .addChild(PAINTING)

//            .addChild(WRITABLE_BOOK)

//            .addChild(LEAD)

//            .addChild(BEACON)
//            .addChild(HEART_OF_THE_SEA)
//            .addChild(CONDUIT)



//          ================================================================
//          =================== REALLY NEEDS SORTING OUT ===================
//          ================================================================

//            .addChild(POTION)
//            .addChild(SPLASH_POTION)
//            .addChild(LINGERING_POTION)
//            .addChild(TIPPED_ARROW)
//            .addChild(ENCHANTED_BOOK)
//            .addChild(SUSPICIOUS_STEW)
//            .addChild(GOAT_HORN)

//          ================================================================
//          =================== REALLY NEEDS SORTING OUT ===================
//          ================================================================
        ;
    }

//  ================================================================
//  =========================== ORGANICS ===========================
//  ================================================================

    private static MaterialNode GenMudTree() {
        List<Material> materials = List.of(
            PACKED_MUD,
            MUD_BRICKS,
            MUD_BRICK_STAIRS,
            MUD_BRICK_SLAB,
            MUD_BRICK_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDirtTree() {
        List<Material> materials = List.of(
            DIRT,
            GRASS_BLOCK,
            COARSE_DIRT,
            PODZOL,
            ROOTED_DIRT,
            MUD,
            MYCELIUM
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenSandTree() {
        List<Material> materials = List.of(
            SAND,
            SANDSTONE,
            SANDSTONE_SLAB,
            SANDSTONE_STAIRS,
            SANDSTONE_WALL,
            CUT_SANDSTONE,
            CUT_SANDSTONE_SLAB,
            CHISELED_SANDSTONE,
            SMOOTH_SANDSTONE,
            SMOOTH_SANDSTONE_SLAB,
            SMOOTH_SANDSTONE_STAIRS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenRedSandTree() {
        List<Material> materials = List.of(
            RED_SAND,
            RED_SANDSTONE,
            RED_SANDSTONE_SLAB,
            RED_SANDSTONE_STAIRS,
            RED_SANDSTONE_WALL,
            CUT_RED_SANDSTONE,
            CUT_RED_SANDSTONE_SLAB,
            CHISELED_RED_SANDSTONE,
            SMOOTH_RED_SANDSTONE,
            SMOOTH_RED_SANDSTONE_SLAB,
            SMOOTH_RED_SANDSTONE_STAIRS
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================ COLOURS ===========================
//  ================================================================

    private static MaterialNode GenGlassTree() {
        List<Material> materials = List.of(
            GLASS,
            TINTED_GLASS,
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
            PINK_STAINED_GLASS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenGlassPaneTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenConcreteTree() {
        List<Material> materials = List.of(
            WHITE_CONCRETE,
            LIGHT_GRAY_CONCRETE,
            GRAY_CONCRETE,
            BLACK_CONCRETE,
            BROWN_CONCRETE,
            RED_CONCRETE,
            ORANGE_CONCRETE,
            YELLOW_CONCRETE,
            LIME_CONCRETE,
            GREEN_CONCRETE,
            CYAN_CONCRETE,
            LIGHT_BLUE_CONCRETE,
            BLUE_CONCRETE,
            PURPLE_CONCRETE,
            MAGENTA_CONCRETE,
            PINK_CONCRETE
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenConcretePowderTree() {
        List<Material> materials = List.of(
            WHITE_CONCRETE_POWDER,
            LIGHT_GRAY_CONCRETE_POWDER,
            GRAY_CONCRETE_POWDER,
            BLACK_CONCRETE_POWDER,
            BROWN_CONCRETE_POWDER,
            RED_CONCRETE_POWDER,
            ORANGE_CONCRETE_POWDER,
            YELLOW_CONCRETE_POWDER,
            LIME_CONCRETE_POWDER,
            GREEN_CONCRETE_POWDER,
            CYAN_CONCRETE_POWDER,
            LIGHT_BLUE_CONCRETE_POWDER,
            BLUE_CONCRETE_POWDER,
            PURPLE_CONCRETE_POWDER,
            MAGENTA_CONCRETE_POWDER,
            PINK_CONCRETE_POWDER
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenTerracottaTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenGlazedTerracottaTree() {
        List<Material> materials = List.of(
            WHITE_GLAZED_TERRACOTTA,
            LIGHT_GRAY_GLAZED_TERRACOTTA,
            GRAY_GLAZED_TERRACOTTA,
            BLACK_GLAZED_TERRACOTTA,
            BROWN_GLAZED_TERRACOTTA,
            RED_GLAZED_TERRACOTTA,
            ORANGE_GLAZED_TERRACOTTA,
            YELLOW_GLAZED_TERRACOTTA,
            LIME_GLAZED_TERRACOTTA,
            GREEN_GLAZED_TERRACOTTA,
            CYAN_GLAZED_TERRACOTTA,
            LIGHT_BLUE_GLAZED_TERRACOTTA,
            BLUE_GLAZED_TERRACOTTA,
            PURPLE_GLAZED_TERRACOTTA,
            MAGENTA_GLAZED_TERRACOTTA,
            PINK_GLAZED_TERRACOTTA
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenWoolTree() {
        List<Material> materials = List.of(
            WHITE_WOOL,
            LIGHT_GRAY_WOOL,
            GRAY_WOOL,
            BLACK_WOOL,
            BROWN_WOOL,
            RED_WOOL,
            ORANGE_WOOL,
            YELLOW_WOOL,
            LIME_WOOL,
            GREEN_WOOL,
            CYAN_WOOL,
            LIGHT_BLUE_WOOL,
            BLUE_WOOL,
            PURPLE_WOOL,
            MAGENTA_WOOL,
            PINK_WOOL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCarpetTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenShulkerBoxTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBedTree() {
        List<Material> materials = List.of(
            WHITE_BED,
            LIGHT_GRAY_BED,
            GRAY_BED,
            BLACK_BED,
            BROWN_BED,
            RED_BED,
            ORANGE_BED,
            YELLOW_BED,
            LIME_BED,
            GREEN_BED,
            CYAN_BED,
            LIGHT_BLUE_BED,
            BLUE_BED,
            PURPLE_BED,
            MAGENTA_BED,
            PINK_BED
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCandleTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBannerTree() {
        List<Material> materials = List.of(
            WHITE_BANNER,
            LIGHT_GRAY_BANNER,
            GRAY_BANNER,
            BLACK_BANNER,
            BROWN_BANNER,
            RED_BANNER,
            ORANGE_BANNER,
            YELLOW_BANNER,
            LIME_BANNER,
            GREEN_BANNER,
            CYAN_BANNER,
            LIGHT_BLUE_BANNER,
            BLUE_BANNER,
            PURPLE_BANNER,
            MAGENTA_BANNER,
            PINK_BANNER
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBundleTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDyeTree() {
        List<Material> materials = List.of(
            WHITE_DYE,
            LIGHT_GRAY_DYE,
            GRAY_DYE,
            BLACK_DYE,
            BROWN_DYE,
            RED_DYE,
            ORANGE_DYE,
            YELLOW_DYE,
            LIME_DYE,
            GREEN_DYE,
            CYAN_DYE,
            LIGHT_BLUE_DYE,
            BLUE_DYE,
            PURPLE_DYE,
            MAGENTA_DYE,
            PINK_DYE
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  =========================== MINERALS ===========================
//  ================================================================

    private static MaterialNode GenAmethystTree() {
        List<Material> materials = List.of(
            AMETHYST_BLOCK,
            SMALL_AMETHYST_BUD,
            MEDIUM_AMETHYST_BUD,
            LARGE_AMETHYST_BUD,
            AMETHYST_CLUSTER,
            AMETHYST_SHARD
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCopperTree() {
        List<Material> materials = List.of(
            COPPER_ORE,
            DEEPSLATE_COPPER_ORE,
            RAW_COPPER,
            RAW_COPPER_BLOCK,
            COPPER_INGOT,
            COPPER_BLOCK,
            CHISELED_COPPER,
            COPPER_GRATE,
            CUT_COPPER,
            CUT_COPPER_STAIRS,
            CUT_COPPER_SLAB,
            COPPER_DOOR,
            COPPER_TRAPDOOR,
            COPPER_BULB,
            WAXED_COPPER_BLOCK,
            WAXED_CHISELED_COPPER,
            WAXED_COPPER_GRATE,
            WAXED_CUT_COPPER,
            WAXED_CUT_COPPER_STAIRS,
            WAXED_CUT_COPPER_SLAB,
            WAXED_COPPER_DOOR,
            WAXED_COPPER_TRAPDOOR,
            WAXED_COPPER_BULB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenExposedCopperTree() {
        List<Material> materials = List.of(
            EXPOSED_COPPER,
            EXPOSED_CHISELED_COPPER,
            EXPOSED_COPPER_GRATE,
            EXPOSED_CUT_COPPER,
            EXPOSED_CUT_COPPER_STAIRS,
            EXPOSED_CUT_COPPER_SLAB,
            EXPOSED_COPPER_DOOR,
            EXPOSED_COPPER_TRAPDOOR,
            EXPOSED_COPPER_BULB,
            WAXED_EXPOSED_COPPER,
            WAXED_EXPOSED_CHISELED_COPPER,
            WAXED_EXPOSED_COPPER_GRATE,
            WAXED_EXPOSED_CUT_COPPER,
            WAXED_EXPOSED_CUT_COPPER_STAIRS,
            WAXED_EXPOSED_CUT_COPPER_SLAB,
            WAXED_EXPOSED_COPPER_DOOR,
            WAXED_EXPOSED_COPPER_TRAPDOOR,
            WAXED_EXPOSED_COPPER_BULB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenWeatheredCopperTree() {
        List<Material> materials = List.of(
            WEATHERED_COPPER,
            WEATHERED_CHISELED_COPPER,
            WEATHERED_COPPER_GRATE,
            WEATHERED_CUT_COPPER,
            WEATHERED_CUT_COPPER_STAIRS,
            WEATHERED_CUT_COPPER_SLAB,
            WEATHERED_COPPER_DOOR,
            WEATHERED_COPPER_TRAPDOOR,
            WEATHERED_COPPER_BULB,
            WAXED_WEATHERED_COPPER,
            WAXED_WEATHERED_CHISELED_COPPER,
            WAXED_WEATHERED_COPPER_GRATE,
            WAXED_WEATHERED_CUT_COPPER,
            WAXED_WEATHERED_CUT_COPPER_STAIRS,
            WAXED_WEATHERED_CUT_COPPER_SLAB,
            WAXED_WEATHERED_COPPER_DOOR,
            WAXED_WEATHERED_COPPER_TRAPDOOR,
            WAXED_WEATHERED_COPPER_BULB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenOxidisedCopperTree() {
        List<Material> materials = List.of(
            OXIDIZED_COPPER,
            OXIDIZED_CHISELED_COPPER,
            OXIDIZED_COPPER_GRATE,
            OXIDIZED_CUT_COPPER,
            OXIDIZED_CUT_COPPER_STAIRS,
            OXIDIZED_CUT_COPPER_SLAB,
            OXIDIZED_COPPER_DOOR,
            OXIDIZED_COPPER_TRAPDOOR,
            OXIDIZED_COPPER_BULB,
            WAXED_OXIDIZED_COPPER,
            WAXED_OXIDIZED_CHISELED_COPPER,
            WAXED_OXIDIZED_COPPER_GRATE,
            WAXED_OXIDIZED_CUT_COPPER,
            WAXED_OXIDIZED_CUT_COPPER_STAIRS,
            WAXED_OXIDIZED_CUT_COPPER_SLAB,
            WAXED_OXIDIZED_COPPER_DOOR,
            WAXED_OXIDIZED_COPPER_TRAPDOOR,
            WAXED_OXIDIZED_COPPER_BULB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenQuartzTree() {
        List<Material> materials = List.of(
            NETHER_QUARTZ_ORE,
            QUARTZ,
            QUARTZ_BLOCK,
            QUARTZ_STAIRS,
            QUARTZ_SLAB,
            CHISELED_QUARTZ_BLOCK,
            QUARTZ_BRICKS,
            QUARTZ_PILLAR,
            SMOOTH_QUARTZ,
            SMOOTH_QUARTZ_STAIRS,
            SMOOTH_QUARTZ_SLAB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenResinTree() {
        List<Material> materials = List.of(
            RESIN_BRICKS,
            RESIN_BRICK_STAIRS,
            RESIN_BRICK_SLAB,
            RESIN_BRICK_WALL,
            CHISELED_RESIN_BRICKS,
            RESIN_BLOCK,
            RESIN_CLUMP,
            RESIN_BRICK
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCoalTree() {
        List<Material> materials = List.of(
            COAL_ORE,
            DEEPSLATE_COAL_ORE,
            COAL,
            CHARCOAL,
            COAL_BLOCK
        );

        return MaterialNode.createTreeFromList(materials);
    }


//  ================================================================
//  ============================ NATURE ============================
//  ================================================================

    private static MaterialNode GenFlowerTree() {
        List<Material> materials = List.of(
            FLOWER_POT,
            DANDELION,
            POPPY,
            BLUE_ORCHID,
            ALLIUM,
            AZURE_BLUET,
            RED_TULIP,
            ORANGE_TULIP,
            WHITE_TULIP,
            PINK_TULIP,
            OXEYE_DAISY,
            CORNFLOWER,
            LILY_OF_THE_VALLEY,
            TORCHFLOWER,
            CLOSED_EYEBLOSSOM,
            OPEN_EYEBLOSSOM,
            WITHER_ROSE
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenPlantTree() {
        List<Material> materials = List.of(
            SHORT_GRASS,
            TALL_GRASS,
            FERN,
            LARGE_FERN,
            DEAD_BUSH,
            SUNFLOWER,
            LILAC,
            ROSE_BUSH,
            PEONY,
            PITCHER_PLANT,
            SEAGRASS,
            SEA_PICKLE,
            KELP,
            VINE,
            LILY_PAD,
            GLOW_LICHEN
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenLushCaveTree() {
        List<Material> materials = List.of(
            CLAY,
            CLAY_BALL,
            MOSS_BLOCK,
            MOSS_CARPET,
            AZALEA,
            FLOWERING_AZALEA,
            AZALEA_LEAVES,
            FLOWERING_AZALEA_LEAVES,
            SPORE_BLOSSOM,
            BIG_DRIPLEAF,
            SMALL_DRIPLEAF,
            HANGING_ROOTS,
            GLOW_BERRIES
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMushroomTree() {
        List<Material> materials = List.of(
            BOWL,
            RED_MUSHROOM,
            BROWN_MUSHROOM,
            RED_MUSHROOM_BLOCK,
            BROWN_MUSHROOM_BLOCK,
            MUSHROOM_STEM
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMelonPumpkinTree() {
        List<Material> materials = List.of(
            PUMPKIN,
            CARVED_PUMPKIN,
            JACK_O_LANTERN,
            PUMPKIN_SEEDS,
            MELON,
            MELON_SLICE,
            MELON_SEEDS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCropTree() {
        List<Material> materials = List.of(
            WHEAT_SEEDS,
            WHEAT,
            HAY_BLOCK,
            CARROT,
            POTATO,
            BEETROOT,
            BEETROOT_SEEDS,
            CACTUS,
            SUGAR_CANE,
            APPLE,
            SWEET_BERRIES,
            HONEY_BOTTLE,
            COCOA_BEANS,
            TORCHFLOWER_SEEDS,
            PITCHER_POD
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenFoodTree() {
        List<Material> materials = List.of(
            GOLDEN_APPLE,
            ENCHANTED_GOLDEN_APPLE,
            GOLDEN_CARROT,
            BAKED_POTATO,
            POISONOUS_POTATO,
            DRIED_KELP,
            DRIED_KELP_BLOCK,
            BREAD,
            COOKIE,
            MILK_BUCKET,
            CAKE,
            PUMPKIN_PIE,
            MUSHROOM_STEW,
            BEETROOT_SOUP,
            RABBIT_STEW
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMeatTree() {
        List<Material> materials = List.of(
            BEEF,
            COOKED_BEEF,
            PORKCHOP,
            COOKED_PORKCHOP,
            MUTTON,
            COOKED_MUTTON,
            CHICKEN,
            COOKED_CHICKEN,
            RABBIT,
            COOKED_RABBIT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenFishTree() {
        List<Material> materials = List.of(
            COD,
            COOKED_COD,
            SALMON,
            COOKED_SALMON,
            TROPICAL_FISH,
            PUFFERFISH
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCoralBlockTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCoralTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCoralFanTree() {
        List<Material> materials = List.of(
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMobDropTree() {
        List<Material> materials = List.of(
            TURTLE_SCUTE,
            ARMADILLO_SCUTE,
            EGG,
            FEATHER,
            INK_SAC,
            GLOW_INK_SAC,
            RABBIT_HIDE,
            LEATHER,
            BONE_MEAL,
            GUNPOWDER,
            BONE,
            ROTTEN_FLESH,
            STRING,
            SPIDER_EYE,
            PHANTOM_MEMBRANE,
            SLIME_BALL,
            BLAZE_ROD,
            ENDER_PEARL,
            GHAST_TEAR,
            NETHER_STAR,
            SHULKER_SHELL,
            HONEYCOMB,
            OCHRE_FROGLIGHT,
            VERDANT_FROGLIGHT,
            PEARLESCENT_FROGLIGHT,
            NAUTILUS_SHELL,
            SPONGE,
            WET_SPONGE
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================ NETHER ============================
//  ================================================================

    private static MaterialNode GenNetherTree() {
        List<Material> materials = List.of(
            NETHERRACK,
            CRIMSON_NYLIUM,
            WARPED_NYLIUM,
            SOUL_SAND,
            SOUL_SOIL,
            BASALT,
            POLISHED_BASALT,
            SMOOTH_BASALT,
            GLOWSTONE,
            GLOWSTONE_DUST,
            MAGMA_BLOCK,
            BONE_BLOCK,
            FIRE_CHARGE,
            SHROOMLIGHT,
            LODESTONE,
            RESPAWN_ANCHOR,
            CRYING_OBSIDIAN
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBlackstoneTree() {
        List<Material> materials = List.of(
            BLACKSTONE,
            GILDED_BLACKSTONE,
            BLACKSTONE_STAIRS,
            BLACKSTONE_SLAB,
            BLACKSTONE_WALL,
            CHISELED_POLISHED_BLACKSTONE,
            POLISHED_BLACKSTONE,
            POLISHED_BLACKSTONE_STAIRS,
            POLISHED_BLACKSTONE_SLAB,
            POLISHED_BLACKSTONE_WALL,
            POLISHED_BLACKSTONE_PRESSURE_PLATE,
            POLISHED_BLACKSTONE_BUTTON,
            POLISHED_BLACKSTONE_BRICKS,
            CRACKED_POLISHED_BLACKSTONE_BRICKS,
            POLISHED_BLACKSTONE_BRICK_STAIRS,
            POLISHED_BLACKSTONE_BRICK_SLAB,
            POLISHED_BLACKSTONE_BRICK_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenNetherBrickTree() {
        List<Material> materials = List.of(
            NETHER_BRICK,
            NETHER_BRICKS,
            CRACKED_NETHER_BRICKS,
            NETHER_BRICK_STAIRS,
            NETHER_BRICK_SLAB,
            NETHER_BRICK_WALL,
            NETHER_BRICK_FENCE,
            CHISELED_NETHER_BRICKS,
            RED_NETHER_BRICKS,
            RED_NETHER_BRICK_STAIRS,
            RED_NETHER_BRICK_SLAB,
            RED_NETHER_BRICK_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================= STONE ============================
//  ================================================================

    private static MaterialNode GenStoneTree() {
        List<Material> materials = List.of(
            STONE,
            STONE_STAIRS,
            STONE_SLAB,
            STONE_PRESSURE_PLATE,
            STONE_BUTTON,
            SMOOTH_STONE,
            SMOOTH_STONE_SLAB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenStoneBrickTree() {
        List<Material> materials = List.of(
            STONE_BRICKS,
            CRACKED_STONE_BRICKS,
            STONE_BRICK_STAIRS,
            STONE_BRICK_SLAB,
            STONE_BRICK_WALL,
            CHISELED_STONE_BRICKS,
            MOSSY_STONE_BRICKS,
            MOSSY_STONE_BRICK_STAIRS,
            MOSSY_STONE_BRICK_SLAB,
            MOSSY_STONE_BRICK_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenTuffTree() {
        List<Material> materials = List.of(
            TUFF,
            TUFF_SLAB,
            TUFF_STAIRS,
            TUFF_WALL,
            CHISELED_TUFF,
            CHISELED_TUFF_BRICKS,
            POLISHED_TUFF,
            POLISHED_TUFF_SLAB,
            POLISHED_TUFF_STAIRS,
            POLISHED_TUFF_WALL,
            TUFF_BRICKS,
            TUFF_BRICK_SLAB,
            TUFF_BRICK_STAIRS,
            TUFF_BRICK_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCobblestoneTree() {
        List<Material> materials = List.of(
            COBBLESTONE,
            COBBLESTONE_SLAB,
            COBBLESTONE_STAIRS,
            COBBLESTONE_WALL,
            MOSSY_COBBLESTONE,
            MOSSY_COBBLESTONE_SLAB,
            MOSSY_COBBLESTONE_STAIRS,
            MOSSY_COBBLESTONE_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenGraniteTree() {
        List<Material> materials = List.of(
            GRANITE,
            GRANITE_STAIRS,
            GRANITE_SLAB,
            GRANITE_WALL,
            POLISHED_GRANITE,
            POLISHED_GRANITE_STAIRS,
            POLISHED_GRANITE_SLAB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenAndesiteTree() {
        List<Material> materials = List.of(
            ANDESITE,
            ANDESITE_STAIRS,
            ANDESITE_SLAB,
            ANDESITE_WALL,
            POLISHED_ANDESITE,
            POLISHED_ANDESITE_STAIRS,
            POLISHED_ANDESITE_SLAB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDioriteTree() {
        List<Material> materials = List.of(
            DIORITE,
            DIORITE_STAIRS,
            DIORITE_SLAB,
            DIORITE_WALL,
            POLISHED_DIORITE,
            POLISHED_DIORITE_STAIRS,
            POLISHED_DIORITE_SLAB
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDeepslateTree() {
        List<Material> materials = List.of(
            DEEPSLATE,
            COBBLED_DEEPSLATE,
            COBBLED_DEEPSLATE_STAIRS,
            COBBLED_DEEPSLATE_SLAB,
            COBBLED_DEEPSLATE_WALL,
            CHISELED_DEEPSLATE,
            POLISHED_DEEPSLATE,
            POLISHED_DEEPSLATE_STAIRS,
            POLISHED_DEEPSLATE_SLAB,
            POLISHED_DEEPSLATE_WALL,
            DEEPSLATE_BRICKS,
            CRACKED_DEEPSLATE_BRICKS,
            DEEPSLATE_BRICK_STAIRS,
            DEEPSLATE_BRICK_SLAB,
            DEEPSLATE_BRICK_WALL,
            DEEPSLATE_TILES,
            CRACKED_DEEPSLATE_TILES,
            DEEPSLATE_TILE_STAIRS,
            DEEPSLATE_TILE_SLAB,
            DEEPSLATE_TILE_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDripstoneTree() {
        List<Material> materials = List.of(
            DRIPSTONE_BLOCK,
            POINTED_DRIPSTONE
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenPrismarineTree() {
        List<Material> materials = List.of(
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
            SEA_LANTERN
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBrickTree() {
        List<Material> materials = List.of(
            BRICK,
            BRICKS,
            BRICK_STAIRS,
            BRICK_SLAB,
            BRICK_WALL
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================= WOODS ============================
//  ================================================================

    private static MaterialNode GenOakTree() {
        List<Material> materials = List.of(
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
            OAK_CHEST_BOAT,
            OAK_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenSpruceTree() {
        List<Material> materials = List.of(
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
            SPRUCE_CHEST_BOAT,
            SPRUCE_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBirchTree() {
        List<Material> materials = List.of(
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
            BIRCH_CHEST_BOAT,
            BIRCH_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenJungleTree() {
        List<Material> materials = List.of(
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
            JUNGLE_CHEST_BOAT,
            JUNGLE_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenAcaciaTree() {
        List<Material> materials = List.of(
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
            ACACIA_CHEST_BOAT,
            ACACIA_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCherryTree() {
        List<Material> materials = List.of(
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
            CHERRY_CHEST_BOAT,
            CHERRY_BOAT,
            PINK_PETALS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDarkOakTree() {
        List<Material> materials = List.of(
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
            DARK_OAK_CHEST_BOAT,
            DARK_OAK_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenPaleOakTree() {
        List<Material> materials = List.of(
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
            PALE_OAK_CHEST_BOAT,
            PALE_OAK_BOAT,
            PALE_MOSS_BLOCK,
            PALE_MOSS_CARPET,
            PALE_HANGING_MOSS,
            CREAKING_HEART
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMangroveTree() {
        List<Material> materials = List.of(
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
            MANGROVE_ROOTS,
            MUDDY_MANGROVE_ROOTS,
            MANGROVE_LEAVES,
            MANGROVE_PROPAGULE,
            MANGROVE_SIGN,
            MANGROVE_HANGING_SIGN,
            MANGROVE_CHEST_BOAT,
            MANGROVE_BOAT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBambooTree() {
        List<Material> materials = List.of(
            BAMBOO_BLOCK,
            STRIPPED_BAMBOO_BLOCK,
            BAMBOO_PLANKS,
            BAMBOO_MOSAIC,
            BAMBOO_STAIRS,
            BAMBOO_MOSAIC_STAIRS,
            BAMBOO_SLAB,
            BAMBOO_MOSAIC_SLAB,
            BAMBOO_FENCE,
            BAMBOO_FENCE_GATE,
            BAMBOO_DOOR,
            BAMBOO_TRAPDOOR,
            BAMBOO_PRESSURE_PLATE,
            BAMBOO_BUTTON,
            BAMBOO,
            BAMBOO_SIGN,
            BAMBOO_HANGING_SIGN,
            BAMBOO_CHEST_RAFT,
            BAMBOO_RAFT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenCrimsonStemTree() {
        List<Material> materials = List.of(
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
            CRIMSON_SIGN,
            CRIMSON_HANGING_SIGN,
            CRIMSON_ROOTS,
            WEEPING_VINES,
            CRIMSON_FUNGUS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenWarpedStemTree() {
        List<Material> materials = List.of(
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
            WARPED_SIGN,
            WARPED_HANGING_SIGN,
            WARPED_ROOTS,
            NETHER_SPROUTS,
            TWISTING_VINES,
            WARPED_FUNGUS
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  =========================== ARCHEOLOGY =========================
//  ================================================================

    private static MaterialNode GenArcheology1Tree() {
        List<Material> materials = List.of(
            BRUSH,
            SUSPICIOUS_SAND,
            SUSPICIOUS_GRAVEL,
            DECORATED_POT,
            ANGLER_POTTERY_SHERD,
            ARCHER_POTTERY_SHERD,
            ARMS_UP_POTTERY_SHERD,
            BLADE_POTTERY_SHERD,
            BREWER_POTTERY_SHERD,
            BURN_POTTERY_SHERD,
            DANGER_POTTERY_SHERD,
            FLOW_POTTERY_SHERD,
            EXPLORER_POTTERY_SHERD,
            FRIEND_POTTERY_SHERD
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenArcheology2Tree() {
        List<Material> materials = List.of(
            GUSTER_POTTERY_SHERD,
            HEART_POTTERY_SHERD,
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
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenSmithingTemplateTree() {
        List<Material> materials = List.of(
            NETHERITE_UPGRADE_SMITHING_TEMPLATE,
            SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE,
            VEX_ARMOR_TRIM_SMITHING_TEMPLATE,
            WILD_ARMOR_TRIM_SMITHING_TEMPLATE,
            COAST_ARMOR_TRIM_SMITHING_TEMPLATE,
            DUNE_ARMOR_TRIM_SMITHING_TEMPLATE,
            WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE,
            RAISER_ARMOR_TRIM_SMITHING_TEMPLATE,
            SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE,
            HOST_ARMOR_TRIM_SMITHING_TEMPLATE,
            WARD_ARMOR_TRIM_SMITHING_TEMPLATE,
            SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE,
            TIDE_ARMOR_TRIM_SMITHING_TEMPLATE,
            SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE,
            RIB_ARMOR_TRIM_SMITHING_TEMPLATE,
            EYE_ARMOR_TRIM_SMITHING_TEMPLATE,
            SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE,
            FLOW_ARMOR_TRIM_SMITHING_TEMPLATE,
            BOLT_ARMOR_TRIM_SMITHING_TEMPLATE
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================ WEAPONRY ==========================
//  ================================================================

    private static MaterialNode GenLeatherWoodGearTree() {
        List<Material> materials = List.of(
            WOODEN_SHOVEL,
            WOODEN_PICKAXE,
            WOODEN_AXE,
            WOODEN_HOE,
            WOODEN_SWORD,
            LEATHER_HELMET,
            LEATHER_CHESTPLATE,
            LEATHER_LEGGINGS,
            LEATHER_BOOTS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenChainStoneGearTree() {
        List<Material> materials = List.of(
            STONE_SHOVEL,
            STONE_PICKAXE,
            STONE_AXE,
            STONE_HOE,
            STONE_SWORD,
            CHAINMAIL_HELMET,
            CHAINMAIL_CHESTPLATE,
            CHAINMAIL_LEGGINGS,
            CHAINMAIL_BOOTS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenIronGearTree() {
        List<Material> materials = List.of(
            IRON_ORE,
            DEEPSLATE_IRON_ORE,
            RAW_IRON,
            RAW_IRON_BLOCK,
            IRON_NUGGET,
            IRON_INGOT,
            IRON_BLOCK,
            IRON_SHOVEL,
            IRON_PICKAXE,
            IRON_AXE,
            IRON_HOE,
            IRON_SWORD,
            IRON_HELMET,
            IRON_CHESTPLATE,
            IRON_LEGGINGS,
            IRON_BOOTS,
            IRON_BARS,
            CHAIN,
            IRON_TRAPDOOR,
            IRON_DOOR
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenGoldGearTree() {
        List<Material> materials = List.of(
            GOLD_ORE,
            DEEPSLATE_GOLD_ORE,
            NETHER_GOLD_ORE,
            RAW_GOLD,
            RAW_GOLD_BLOCK,
            GOLD_NUGGET,
            GOLD_INGOT,
            GOLD_BLOCK,
            GOLDEN_SHOVEL,
            GOLDEN_PICKAXE,
            GOLDEN_AXE,
            GOLDEN_HOE,
            GOLDEN_SWORD,
            GOLDEN_HELMET,
            GOLDEN_CHESTPLATE,
            GOLDEN_LEGGINGS,
            GOLDEN_BOOTS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenDiamondGearTree() {
        List<Material> materials = List.of(
            DIAMOND_ORE,
            DEEPSLATE_DIAMOND_ORE,
            DIAMOND,
            DIAMOND_BLOCK,
            DIAMOND_SHOVEL,
            DIAMOND_PICKAXE,
            DIAMOND_AXE,
            DIAMOND_HOE,
            DIAMOND_SWORD,
            DIAMOND_HELMET,
            DIAMOND_CHESTPLATE,
            DIAMOND_LEGGINGS,
            DIAMOND_BOOTS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenNetheriteGearTree() {
        List<Material> materials = List.of(
            ANCIENT_DEBRIS,
            NETHERITE_SCRAP,
            NETHERITE_INGOT,
            NETHERITE_BLOCK,
            NETHERITE_SHOVEL,
            NETHERITE_PICKAXE,
            NETHERITE_AXE,
            NETHERITE_HOE,
            NETHERITE_SWORD,
            NETHERITE_HELMET,
            NETHERITE_CHESTPLATE,
            NETHERITE_LEGGINGS,
            NETHERITE_BOOTS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMobItemsTree() {
        List<Material> materials = List.of(
            NAME_TAG,
            SADDLE,
            WARPED_FUNGUS_ON_A_STICK,
            CARROT_ON_A_STICK,
            WOLF_ARMOR,
            LEATHER_HORSE_ARMOR,
            IRON_HORSE_ARMOR,
            GOLDEN_HORSE_ARMOR,
            DIAMOND_HORSE_ARMOR
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMiscWeaponsTree() {
        List<Material> materials = List.of(
            BOW,
            CROSSBOW,
            ARROW,
            SPECTRAL_ARROW,
            TRIDENT,
            SHIELD,
            MACE,
            ELYTRA,
            TURTLE_HELMET
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenToolsTree() {
        List<Material> materials = List.of(
            ARMOR_STAND,
            COMPASS,
            CLOCK,
            SPYGLASS,
            FISHING_ROD,
            FLINT_AND_STEEL,
            SHEARS,
            MAP,
            TOTEM_OF_UNDYING,
            FIREWORK_ROCKET,
            FIREWORK_STAR
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================= MISC =============================
//  ================================================================

    private static MaterialNode GenTrialLootTree() {
        List<Material> materials = List.of(
            OMINOUS_BOTTLE,
            BREEZE_ROD,
            WIND_CHARGE,
            TRIAL_KEY,
            OMINOUS_TRIAL_KEY,
            HEAVY_CORE
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenSnowTree() {
        List<Material> materials = List.of(
            SNOWBALL,
            SNOW,
            SNOW_BLOCK,
            ICE,
            PACKED_ICE,
            BLUE_ICE
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenAncientCityTree() {
        List<Material> materials = List.of(
            SCULK,
            SCULK_CATALYST,
            SCULK_VEIN,
            SCULK_SHRIEKER,
            SCULK_SENSOR,
            DISC_FRAGMENT_5,
            ECHO_SHARD,
            RECOVERY_COMPASS
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenEndTree() {
        List<Material> materials = List.of(
            ENDER_EYE,
            END_STONE,
            END_STONE_BRICKS,
            END_STONE_BRICK_STAIRS,
            END_STONE_BRICK_SLAB,
            END_STONE_BRICK_WALL,
            PURPUR_BLOCK,
            PURPUR_PILLAR,
            PURPUR_STAIRS,
            PURPUR_SLAB,
            END_ROD,
            CHORUS_FLOWER,
            CHORUS_FRUIT,
            POPPED_CHORUS_FRUIT,
            END_CRYSTAL
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenTradingTree() {
        List<Material> materials = List.of(
            EMERALD_ORE,
            DEEPSLATE_EMERALD_ORE,
            EMERALD,
            EMERALD_BLOCK,
            BELL,
            BLAST_FURNACE,
            SMOKER,
            CARTOGRAPHY_TABLE,
            BREWING_STAND,
            COMPOSTER,
            BARREL,
            FLETCHING_TABLE,
            CAULDRON,
            LECTERN,
            STONECUTTER,
            LOOM,
            SMITHING_TABLE,
            GRINDSTONE
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenRedstoneTree() {
        List<Material> materials = List.of(
            REDSTONE_ORE,
            DEEPSLATE_REDSTONE_ORE,
            REDSTONE,
            REDSTONE_BLOCK,
            REDSTONE_TORCH,
            REPEATER,
            COMPARATOR,
            TARGET,
            LEVER,
            LIGHT_WEIGHTED_PRESSURE_PLATE,
            HEAVY_WEIGHTED_PRESSURE_PLATE,
            CALIBRATED_SCULK_SENSOR,
            TRIPWIRE_HOOK,
            DAYLIGHT_DETECTOR,
            PISTON,
            STICKY_PISTON,
            SLIME_BLOCK,
            HONEY_BLOCK,
            DISPENSER,
            DROPPER,
            CRAFTER,
            HOPPER,
            TRAPPED_CHEST,
            OBSERVER,
            REDSTONE_LAMP,
            LIGHTNING_ROD,
            NOTE_BLOCK,
            TNT
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMinecartTree() {
        List<Material> materials = List.of(
            RAIL,
            POWERED_RAIL,
            DETECTOR_RAIL,
            ACTIVATOR_RAIL,
            MINECART,
            HOPPER_MINECART,
            CHEST_MINECART,
            FURNACE_MINECART,
            TNT_MINECART
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBucketsTree() {
        List<Material> materials = List.of(
            BUCKET,
            WATER_BUCKET,
            POWDER_SNOW_BUCKET,
            LAVA_BUCKET,
            COD_BUCKET,
            SALMON_BUCKET,
            TROPICAL_FISH_BUCKET,
            PUFFERFISH_BUCKET,
            AXOLOTL_BUCKET,
            TADPOLE_BUCKET
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenSkullTree() {
        List<Material> materials = List.of(
            SKELETON_SKULL,
            WITHER_SKELETON_SKULL,
            ZOMBIE_HEAD,
            CREEPER_HEAD,
            PIGLIN_HEAD,
            DRAGON_HEAD
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBrewingTree() {
        List<Material> materials = List.of(
            SUGAR,
            RABBIT_FOOT,
            GLISTERING_MELON_SLICE,
            FERMENTED_SPIDER_EYE,
            BLAZE_POWDER,
            NETHER_WART,
            GLASS_BOTTLE,
            EXPERIENCE_BOTTLE,
            DRAGON_BREATH,
            MAGMA_CREAM
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenEnchantingTree() {
        List<Material> materials = List.of(
            LAPIS_ORE,
            DEEPSLATE_LAPIS_ORE,
            LAPIS_LAZULI,
            LAPIS_BLOCK,
            ENCHANTING_TABLE,
            ANVIL,
            CHIPPED_ANVIL,
            DAMAGED_ANVIL,
            BOOK,
            BOOKSHELF,
            CHISELED_BOOKSHELF
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMusicDiscTree() {
        List<Material> materials = List.of(
            JUKEBOX,
            MUSIC_DISC_13,
            MUSIC_DISC_CAT,
            MUSIC_DISC_BLOCKS,
            MUSIC_DISC_CHIRP,
            MUSIC_DISC_FAR,
            MUSIC_DISC_MALL,
            MUSIC_DISC_MELLOHI,
            MUSIC_DISC_STAL,
            MUSIC_DISC_STRAD,
            MUSIC_DISC_WARD,
            MUSIC_DISC_11,
            MUSIC_DISC_CREATOR_MUSIC_BOX,
            MUSIC_DISC_WAIT,
            MUSIC_DISC_CREATOR,
            MUSIC_DISC_PRECIPICE,
            MUSIC_DISC_OTHERSIDE,
            MUSIC_DISC_RELIC,
            MUSIC_DISC_5,
            MUSIC_DISC_PIGSTEP
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenBannerPatternTree() {
        List<Material> materials = List.of(
            FIELD_MASONED_BANNER_PATTERN,
            BORDURE_INDENTED_BANNER_PATTERN,
            FLOWER_BANNER_PATTERN,
            CREEPER_BANNER_PATTERN,
            SKULL_BANNER_PATTERN,
            MOJANG_BANNER_PATTERN,
            GLOBE_BANNER_PATTERN,
            PIGLIN_BANNER_PATTERN,
            FLOW_BANNER_PATTERN,
            GUSTER_BANNER_PATTERN
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMisc1Tree() {
        List<Material> materials = List.of(
            TORCH,
            LANTERN,
            CAMPFIRE,
            SOUL_TORCH,
            SOUL_LANTERN,
            SOUL_CAMPFIRE,
            CRAFTING_TABLE,
            FURNACE,
            CHEST,
            ENDER_CHEST,
            SCAFFOLDING,
            LADDER
        );

        return MaterialNode.createTreeFromList(materials);
    }

    private static MaterialNode GenMisc2Tree() {
        List<Material> materials = List.of(
            CALCITE,
            GRAVEL,
            FLINT,
            STICK,
            PAPER,
            OBSIDIAN,
            BEE_NEST,
            BEEHIVE,
            HONEYCOMB_BLOCK
        );

        return MaterialNode.createTreeFromList(materials);
    }

//  ================================================================
//  ============================== END =============================
//  ================================================================


}
