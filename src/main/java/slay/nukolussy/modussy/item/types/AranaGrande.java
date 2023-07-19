package slay.nukolussy.modussy.item.types;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ActivateMethods;

public class AranaGrande extends Item {
    public AranaGrande() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        ActivateMethods.aranaGrandeRightClick(world, x, y, z, entity, entity.getMainHandItem());
        return ar;
    }

}
