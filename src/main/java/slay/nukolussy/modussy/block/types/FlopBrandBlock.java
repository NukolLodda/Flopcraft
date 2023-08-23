package slay.nukolussy.modussy.block.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class FlopBrandBlock extends Block {
    public FlopBrandBlock() {
        super(Properties.copy(Blocks.PINK_CONCRETE).lightLevel(l -> 15).strength(0.8f));
    }
}
