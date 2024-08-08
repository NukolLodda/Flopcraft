package net.nukollodda.flopcraft.block.entity.ent;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FlopSignBlockEntity extends SignBlockEntity {
    public FlopSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(FlopBlockEntities.MOD_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FlopBlockEntities.MOD_SIGN.get();
    }
}
