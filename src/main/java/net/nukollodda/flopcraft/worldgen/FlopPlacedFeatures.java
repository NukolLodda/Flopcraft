package net.nukollodda.flopcraft.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.nukollodda.flopcraft.Flopcraft;

import java.util.List;

public class FlopPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BRAT_ORE = registerKey("brat_ore_placed");
    public static final ResourceKey<PlacedFeature> SHENSEIUM_ORE = registerKey("shenseium_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, BRAT_ORE, configured.getOrThrow(FlopConfiguredFeatures.BRAT_ORE_KEY),
                FlopOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(50))));

        register(context, SHENSEIUM_ORE, configured.getOrThrow(FlopConfiguredFeatures.SHENSEIUM_ORE_KEY),
                FlopOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> holder, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(holder, List.copyOf(modifiers)));
    }
}

