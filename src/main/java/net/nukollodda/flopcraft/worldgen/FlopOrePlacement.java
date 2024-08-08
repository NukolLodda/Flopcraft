package net.nukollodda.flopcraft.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class FlopOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier pModifier, PlacementModifier pSecondaryModifier) {
        return List.of(pModifier, InSquarePlacement.spread(), pSecondaryModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
