package net.nukollodda.flopcraft.block.types;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class HardenedPeriodCvm extends Block {

    public HardenedPeriodCvm() {
        super(Properties.ofFullCopy(Blocks.OBSIDIAN).lightLevel(l -> 4));
    }
}
