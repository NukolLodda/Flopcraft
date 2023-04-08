package slay.nukolussy.modussy.procedures;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.item.ModItem;

import java.util.Random;

@Mod.EventBusSubscriber
public class TwinkDrops {
    private static ItemStack randItem() {
        Random obj = new Random();
        int randNum = obj.nextInt(1,100);
        if (randNum > 35) {
            if (randNum < 55) return new ItemStack(ModItem.SCARUSSY.get());
            else if (randNum < 65) return new ItemStack(ModItem.CUPCAKE.get());
            else if (randNum < 75) return new ItemStack(ModItem.POSEI.get());
            else if (randNum < 80) return new ItemStack(ModItem.SLAGINIUM.get());
            else if (randNum < 85) return new ItemStack(ModItem.SHENSEIUM.get());
            else if (randNum < 90) return new ItemStack(ModItem.CVMTITPLASM.get());
            else if (randNum < 95) return new ItemStack(ModItem.METRO.get());
            else if (randNum < 98) return new ItemStack(ModItem.INFUSED_SLAGINIUM.get());
            else return new ItemStack(ModItem.JIAFEI_PRODUCT.get());
        }
        else return new ItemStack(ModItem.HAIRUSSY.get());
    }
    public static void execute(LevelAccessor world, double x, double y, double z, ItemStack item) {
        if (item.equals(new ItemStack(ModItem.CVM.get()))) {
            if (world instanceof Level _level && !_level.isClientSide()) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, randItem());
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
            (item).shrink(1);
        }
    }
}
