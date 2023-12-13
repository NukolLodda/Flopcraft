package slay.nukolussy.modussy.item.types;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.List;

public class KylieJennerLipstick extends Item implements Vanishable {
    public KylieJennerLipstick() {
        super(new Item.Properties().durability(40));
    }

    public void appendHoverText(ItemStack stack, Level lvl, List<Component> components, TooltipFlag tip) {
        components.add(this.getDisplayName().withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ToolMethods.makeupUse(entity, entity.getMainHandItem(), 2);
        if (entity.getRandom().nextInt(0, 69) == 0) {
            CupcakKe cupcakKe = new CupcakKe(ModEntities.CUPCAKKE.get(), world);
            cupcakKe.teleportTo(entity.getX(), entity.getY(), entity.getZ());
            world.addFreshEntity(cupcakKe);
        }
        if (entity.getMainHandItem().getDamageValue() >= entity.getMainHandItem().getMaxDamage()) {
            entity.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
        }
        entity.addEffect(new MobEffectInstance(ModEffects.YASSIFIED.get(), 1000, 1));
        return ar;
    }

    public MutableComponent getDisplayName() {
        return Component.translatable(this.getDescriptionId() + ".desc");
    }
}
