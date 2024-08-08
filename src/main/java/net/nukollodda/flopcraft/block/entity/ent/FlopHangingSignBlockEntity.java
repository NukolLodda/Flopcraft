package net.nukollodda.flopcraft.block.entity.ent;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FlopHangingSignBlockEntity extends SignBlockEntity {
    public FlopHangingSignBlockEntity(BlockPos pPos, BlockState pState) {
        super(FlopBlockEntities.MOD_HANGING_SIGN.get(), pPos, pState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FlopBlockEntities.MOD_HANGING_SIGN.get();
    }
}
