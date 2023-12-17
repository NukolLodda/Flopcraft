package slay.nukolussy.modussy.block.types;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class HardenedPeriodCvm extends Block {

    public HardenedPeriodCvm() {
        super(Properties.copy(Blocks.OBSIDIAN).lightLevel(l -> 4));
    }
}
