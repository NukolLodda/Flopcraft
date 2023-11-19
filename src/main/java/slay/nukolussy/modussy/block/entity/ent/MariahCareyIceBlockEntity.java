package slay.nukolussy.modussy.block.entity.ent;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MariahCareyIceBlockEntity extends BlockEntity {
    public MariahCareyIceBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public static void tick(Level lvl, BlockPos pos, BlockState state, CvmInfusionAlterEntity ent) {
        // if it's December, she will defrost
    }
}
