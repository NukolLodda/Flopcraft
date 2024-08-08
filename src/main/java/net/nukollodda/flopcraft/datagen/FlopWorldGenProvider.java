package net.nukollodda.flopcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.worldgen.FlopBiomeModifiers;
import net.nukollodda.flopcraft.worldgen.FlopConfiguredFeatures;
import net.nukollodda.flopcraft.worldgen.FlopPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class FlopWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, FlopConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, FlopPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, FlopBiomeModifiers::bootstrap);
    public FlopWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Flopcraft.MODID));
    }
}
