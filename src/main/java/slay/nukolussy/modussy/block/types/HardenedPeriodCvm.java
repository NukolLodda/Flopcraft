package slay.nukolussy.modussy.block.types;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class HardenedPeriodCvm extends Block {
    private static final Direction[] ALL_DIRECTIONS = Direction.values();

    public HardenedPeriodCvm() {
        super(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).lightLevel(l -> 4));
    }
}
