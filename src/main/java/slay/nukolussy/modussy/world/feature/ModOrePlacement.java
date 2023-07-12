package slay.nukolussy.modussy.world.feature;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier2) {
        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int placeCnt, PlacementModifier modifier) {
        return orePlacement(CountPlacement.of(placeCnt), modifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int placeCnt, PlacementModifier modifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(placeCnt), modifier);
    }
}
