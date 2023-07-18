package slay.nukolussy.modussy.item.types;

import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ActivateMethods;
import slay.nukolussy.modussy.item.ModItem;
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
                        boolean isCvmium = itemstack.is(ModItem.CVMIUM.get());

                        double horRot = pEntityLiving.yHeadRotO * Math.PI / 180;
                        double verRot = pEntityLiving.xRotO * Math.PI / -180;
                        float radius = powerTime * 36;

                        double xEqu = Math.cos(verRot) * Math.sin(horRot);
                        double yEqu = Math.sin(verRot);
                        double zEqu = Math.cos(verRot) * Math.cos(horRot);

                        double x = pEntityLiving.getX();
                        double y = pEntityLiving.getY();
                        double z = pEntityLiving.getZ();

                        for (int i = 0; i < 6; i++) {
                            ActivateMethods.cvmShoot(pLevel, x - ((radius * i)/6 * xEqu), y + ((radius * i)/6 * yEqu), z + ((radius * i)/6 * zEqu),
                                    pEntityLiving, new ItemStack(this), isCvmium,
                                    (10 * i) / 6.0f);
                        }
                    }

                    pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.SQUIRT.get(), SoundSource.PLAYERS,
                            1.0f, 1.0f / (pLevel.getRandom().nextFloat() * 0.4f + 1.2f) + powerTime * 0.5f);

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
        return (item) -> item.is(ModItem.CVMIUM.get()) || item.is(ModItem.CVM.get());
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
