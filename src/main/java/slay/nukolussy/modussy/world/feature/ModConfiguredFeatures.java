package slay.nukolussy.modussy.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
        DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Modussy.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SPAWNED_SHENSEIUM_ORE = Suppliers.memoize(() -> List.of(
        OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.SHENSEIUM_ORE.get().defaultBlockState())
    ))::get;

    public static final RegistryObject<ConfiguredFeature<?,?>> SHENSEIUM_ORE = CONFIGURED_FEATURES.register("shenseium_ore",
         () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SPAWNED_SHENSEIUM_ORE.get(), 6)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
