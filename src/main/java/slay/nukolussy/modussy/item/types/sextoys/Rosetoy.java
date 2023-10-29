package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Rosetoy extends Item {
    public Rosetoy() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15000, 1, true, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 300, 0, true, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 15000, 1, true, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6900, 1, true, false, false));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 6900, 1, true, false, false));
        // there'll be a playsound
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
