package net.nukollodda.flopcraft.block.entity.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.nukollodda.flopcraft.block.entity.ent.FlopSignBlockEntity;

public class FlopStandingSignBlock extends StandingSignBlock {
    public FlopStandingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FlopSignBlockEntity(pPos, pState);
    }
}
