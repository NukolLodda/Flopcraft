package slay.nukolussy.modussy.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.misc.AbstractCvm;
import slay.nukolussy.modussy.entities.misc.Cvm;
import slay.nukolussy.modussy.entities.misc.Cvmium;
import slay.nukolussy.modussy.item.ModItem;

public class CvmItem extends ArrowItem {
    public CvmItem() {
        super(new Item.Properties());
    }

    public AbstractCvm createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return pStack.is(ModItem.CVMIUM.get()) ? new Cvmium(pShooter, pLevel) : new Cvm(pShooter, pLevel);
    }
}
