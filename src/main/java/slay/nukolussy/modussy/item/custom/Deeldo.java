package slay.nukolussy.modussy.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.misc.AbstractCvm;
import slay.nukolussy.modussy.entities.misc.Cvm;
import slay.nukolussy.modussy.item.ActivateMethods;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSoundTypes;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.function.Predicate;

public class Deeldo extends BowItem {
    public Deeldo() {
        super(new Item.Properties().fireResistant()
            .durability(6971).rarity(Rarity.RARE));
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            boolean hasInf = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack itemstack = player.getProjectile(pStack);

            int useDur = this.getUseDuration(pStack) - pTimeLeft;
            useDur = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pStack, pLevel, player, useDur, !itemstack.isEmpty() || hasInf);
            if (useDur < 0) return;

            if (!itemstack.isEmpty() || hasInf) {
                if (itemstack.isEmpty()) {
                    itemstack = new ItemStack(ModItem.CVM.get());
                }

                float powerTime = getPowerForTime(useDur);
                if (!((double)powerTime < 0.1D)) {
                    boolean inf = player.getAbilities().instabuild || (itemstack.getItem() instanceof CvmItem &&
                            ((CvmItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));
                    if (!pLevel.isClientSide) {
                        CvmItem cvmitem = (CvmItem)(itemstack.getItem() instanceof CvmItem ? itemstack.getItem() : ModItem.CVM.get());
                        AbstractCvm cvm = cvmitem.createArrow(pLevel, itemstack, player);
                        cvm = (AbstractCvm) customArrow(cvm);
                        cvm.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, powerTime * 3.0F, 1.0F);

                        int power = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
                        int punch = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
                        boolean flame = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0;

                        if (power > 0) {
                            cvm.setBaseDamage(cvm.getBaseDamage() + (double)power * 0.5D + 0.5D);
                        }
                        if (punch > 0) {
                            cvm.setKnockback(punch);
                        }
                        cvm.setFireness(flame);

                        pStack.hurtAndBreak(1, player, (p) -> {
                            p.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        pLevel.addFreshEntity(cvm);
                    }

                    pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.SQUIRT.get(), SoundSource.PLAYERS,
                            1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + powerTime * 0.5F);
                    if (!inf && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (item) -> item.is(ModItem.CVM.get()) || item.is(ModItem.CVMIUM.get());
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 36000;
    }
}
