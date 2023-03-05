package slay.nukolussy.modussy.procedures;


import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.item.ModItem;

import java.util.Random;


@Mod.EventBusSubscriber
public class CupcakKeDrops {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        Random random = new Random();
        int dropChance = random.nextInt(1,8400);
        if (dropChance == 1) {
            if (world instanceof Level _level && !_level.isClientSide()) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModItem.CUPCAKE.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }
    }
}
