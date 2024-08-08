package net.nukollodda.flopcraft.block.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class FlopBrandBlock extends Block {
    public FlopBrandBlock() {
        super(Properties.ofFullCopy(Blocks.PINK_CONCRETE).lightLevel(l -> 15).strength(0.8f));
    }
}
