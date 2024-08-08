package net.nukollodda.flopcraft.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.flopcraft.Flopcraft;

public class FlopBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_SHENSEIUM_ORE = registerKey("add_shenseium_ore");
    public static final ResourceKey<BiomeModifier> ADD_BRAT_ORE = registerKey("add_brat_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_SHENSEIUM_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(FlopPlacedFeatures.SHENSEIUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_BRAT_ORE, new ForgeBiomeModifiers
                .AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(FlopPlacedFeatures.BRAT_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, name));
    }
}
