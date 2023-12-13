package slay.nukolussy.modussy.block.entity.ent;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import java.util.Random;

public class MariahCareyIceBlockEntity extends BlockEntity {
    // I - the author of this mod is also a top.
    private static final Random RANDOM = new Random();
    private int tickAfterSpawn = 0;
    public MariahCareyIceBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MARIAH_CAREY_ICE_BLOCK.get(), pPos, pBlockState);
    }

    public static void tick(Level lvl, BlockPos pos, BlockState state, MariahCareyIceBlockEntity ent) {
        // if it's December, she will defrost
        BlockState above = lvl.getBlockState(pos.above());
        if (!state.getValue(MariahCareyIceBlock.IS_TOP) && above.getBlock() instanceof MariahCareyIceBlock) {
            if (ModUtil.getMonth().equals(Month.DECEMBER) && above.getValue(MariahCareyIceBlock.IS_TOP)) {
                ent.tickAfterSpawn++;
                if (ent.tickAfterSpawn > 200) {
                    double x = pos.getX();
                    double y = pos.getY();
                    double z = pos.getZ();
                    for (int i = 0; i < 4; i++) {
                        double x0 = x + RANDOM.nextFloat();
                        double y0 = y + RANDOM.nextFloat();
                        double z0 = z + RANDOM.nextFloat();
                        double dx = (RANDOM.nextFloat() - 0.5) * 0.5;
                        double dy = (RANDOM.nextFloat() - 0.5) * 0.5;
                        double dz = (RANDOM.nextFloat() - 0.5) * 0.5;

                        lvl.addParticle(ParticleTypes.DRAGON_BREATH, x0, y0, z0, dx, dy, dz);
                    }
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
                    lvl.playSound(null, pos, SoundEvents.GLASS_BREAK, SoundSource.BLOCKS);
                    lvl.playSound(null, pos, ModSounds.MARIAH_CAREY_DEFROSTING.get(), SoundSource.BLOCKS);
                    lvl.addFreshEntity(mariah);
                    lvl.getBlockState(pos).getBlock().destroy(lvl, pos, state);
                    lvl.destroyBlock(pos, false);
                } else if (ent.tickAfterSpawn % lvl.random.nextInt(23, 28) == 0) {
                    lvl.playSound(null, pos, SoundEvents.POWDER_SNOW_BREAK, SoundSource.BLOCKS);
                }
            }
        }
    }
}
