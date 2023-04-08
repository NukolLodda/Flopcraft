package slay.nukolussy.modussy.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.procedures.AranaGrandeRightclicked;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

public class AranaGrande extends Item {
    public AranaGrande() {
        super(new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = ar.getObject();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        AranaGrandeRightclicked.execute(world, x, y, z, entity, entity.getMainHandItem());
        return ar;
    }

}
