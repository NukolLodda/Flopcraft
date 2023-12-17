package slay.nukolussy.modussy.block.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MaterialBlocks extends Block {
    public MaterialBlocks(Block block, SoundType sound, float strength) {
        super(Properties.copy(block).strength(strength * 1.5f)
                .destroyTime(strength).requiresCorrectToolForDrops().sound(sound));
    }
    public MaterialBlocks(float strength) {
            this(Blocks.DEEPSLATE, SoundType.DEEPSLATE, strength);
    }

    public MaterialBlocks(Block block, SoundType sound) {
        this(block, sound, 5f);
    }
}
