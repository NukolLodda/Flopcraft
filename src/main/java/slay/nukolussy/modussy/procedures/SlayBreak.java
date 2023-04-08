package slay.nukolussy.modussy.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import slay.nukolussy.modussy.block.JiafeiCrop;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.entity.custom.Jiafei;
import slay.nukolussy.modussy.item.ModItem;

public class SlayBreak {
    public static void execute(Level lvl, int x, int y, int z, BlockState state, BlockPos pos, LivingEntity ent) {
        Block block = state.getBlock();
        if (block instanceof JiafeiCrop crop) {
            if (crop.getAge(state) == 4) {
                Mob newMob = new Jiafei(ModEntities.JIAFEI.get(), lvl);
                newMob.moveTo(pos.getX(), pos.getY(), pos.getZ());
                ent.level.addFreshEntity(newMob);
                ent.spawnAtLocation(ModItem.JIAFEI_PRODUCT.get());
            }
        }
    }
}
