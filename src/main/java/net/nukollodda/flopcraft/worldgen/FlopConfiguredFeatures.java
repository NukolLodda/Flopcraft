package net.nukollodda.flopcraft.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.ModBlocks;

import java.util.List;

public class FlopConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHENSEIUM_ORE_KEY = registerKey("shenseium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRAT_ORE_KEY = registerKey("brat_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LOVELY_PEACH_KEY = registerKey("lovely_peach");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KAMALOCONUT_PALM_KEY = registerKey("kamaloconut_palm");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest netherReplaceable = new TagMatchTest(Tags.Blocks.NETHERRACK);
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> shenseiumOres = List.of(OreConfiguration.target(netherReplaceable,
                ModBlocks.SHENSEIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> bratOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.BRAT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_BRAT_ORE.get().defaultBlockState()));

        register(context, SHENSEIUM_ORE_KEY, Feature.ORE, new OreConfiguration(shenseiumOres, 16));
        register(context, BRAT_ORE_KEY, Feature.ORE, new OreConfiguration(bratOres, 5));
        register(context, LOVELY_PEACH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.LOVELY_PEACH_LOG.get()),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ModBlocks.LOVELY_PEACH_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, KAMALOCONUT_PALM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.KAMALOCONUT_PALM_LOG.get()),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(ModBlocks.KAMALOCONUT_PALM_LEAVES.get()),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ? >> key,
            F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
