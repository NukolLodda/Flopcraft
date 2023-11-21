package slay.nukolussy.modussy.block.entity.ent;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import slay.nukolussy.modussy.block.entity.blocks.MariahCareyIceBlock;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.figures.MariahCarey;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.ModUtil;

import java.time.Month;

public class MariahCareyIceBlockEntity extends BlockEntity {
    public MariahCareyIceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MARIAH_CAREY_ICE_BLOCK.get(), pPos, pBlockState);
    }

    public static void tick(Level lvl, BlockPos pos, BlockState state, MariahCareyIceBlockEntity ent) {
        // if it's December, she will defrost
        if (ModUtil.getMonth().equals(Month.DECEMBER)) {
            MariahCarey mariah = new MariahCarey(ModEntities.MARIAH_CAREY.get(), lvl);
            int rot = switch (state.getValue(MariahCareyIceBlock.FACING)) {
                case EAST -> 90;
                case SOUTH -> 180;
                case WEST -> 270;
                default -> 0;
            };
            mariah.setYRot(rot);
            mariah.setPos(pos.getX(), pos.getY(), pos.getZ());
            mariah.spawnAtLocation(ModItems.DISC_C27.get());
            lvl.playSound(null, pos, ModSounds.MARIAH_CAREY_DEFROSTING.get(), SoundSource.BLOCKS);
            lvl.addFreshEntity(mariah);
            lvl.removeBlock(pos, false);
        }
    }
}
