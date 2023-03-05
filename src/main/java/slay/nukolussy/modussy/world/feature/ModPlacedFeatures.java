package slay.nukolussy.modussy.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Modussy.MODID);

    public static final RegistryObject<PlacedFeature> SHENSEIUM_ORE_PLACED = PLACED_FEATURES.register("shenseium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SHENSEIUM_ORE.getHolder().get(),
                    commonOrePlacement(6,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(80), VerticalAnchor.aboveBottom(10)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(veinsPerChunk), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int veinsPerChunk, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(veinsPerChunk), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
