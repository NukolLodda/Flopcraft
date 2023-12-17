package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.entities.twink.AbstractTwink;
import slay.nukolussy.modussy.entities.twink.Twink;
import slay.nukolussy.modussy.entities.twink.TwinkAI;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.item.types.CvmItem;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractDeeldo extends BowItem {
    public AbstractDeeldo(int durability) {
        super(new Properties().fireResistant()
                .durability(durability).rarity(Rarity.RARE));
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
                    itemstack = new ItemStack(ModItems.CVM.get());
                }

                float powerTime = getPowerForTime(useDur);
                if (!((double)powerTime < 0.1D)) {
                    boolean inf = player.getAbilities().instabuild || (itemstack.getItem() instanceof CvmItem &&
                            ((CvmItem)itemstack.getItem()).isInfinite(itemstack, pStack, player));
                    if (!pLevel.isClientSide) {
                        int type = itemstack.is(ModItems.CVMIUM.get()) ? 1 : itemstack.is(ModItems.BLOOD_CLUMP.get()) ? 2 : 0;

                        double horRot = pEntityLiving.yHeadRotO * Math.PI / 180;
                        double verRot = pEntityLiving.xRotO * Math.PI / -180;
                        float radius = powerTime * 36 * multiplier();

                        double xEqu = Math.cos(verRot) * Math.sin(horRot);
                        double yEqu = Math.sin(verRot);
                        double zEqu = Math.cos(verRot) * Math.cos(horRot);

                        double x = pEntityLiving.getX();
                        double y = pEntityLiving.getY();
                        double z = pEntityLiving.getZ();

                        for (int i = 0; i < 6 * multiplier(); i++) {
                            deeldoShoot(pLevel, x - ((radius * i)/6 * xEqu), y + ((radius * i)/6 * yEqu), z + ((radius * i)/6 * zEqu),
                                    pEntityLiving, new ItemStack(this), type,
                                    (10 * i) / 6.0f);
                        }
                    }

                    pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), getSquirtSound(), SoundSource.PLAYERS,
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
    protected void deeldoShoot(LevelAccessor world, double x, double y, double z, LivingEntity entity,
                               ItemStack deeldo, int type, float chargedTime) {
        int power = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, deeldo);
        boolean flame = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, deeldo) > 0;
        int amp = type + 1;
        {
            final Vec3 center = new Vec3(x, y, z);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(2 * multiplier() * chargedTime / 2d), e -> true).stream().toList();
            for (LivingEntity ent : entities) {
                if (EntityMethods.isMonster(ent)) {
                    EntityMethods.monsterEffects(ent, amp * ((int)chargedTime),amp - 1);
                    ent.hurt(ent.level().damageSources().mobAttack(entity), power * 10 * (int)chargedTime * multiplier());
                    ent.setSecondsOnFire(secOnFire(type, flame));
                }
                if (entity instanceof Player player) {
                    ToolMethods.yassification(ent, world, player);
                    if (ent instanceof Cat cat && player.getRandom().nextInt(25) < 4) {
                        cat.spawnAtLocation(ModItems.POSEI.get());
                        PlayerMethods.addPlayerYassification(player, 2);
                    }
                    if (EntityMethods.isFlop(ent) || (ent instanceof AbstractTwink && type < 2)) {
                        EntityMethods.flopEffects(ent, amp,amp - 1);
                        if (player.getRandom().nextInt(12) == 1) {
                            if (ent instanceof Twink && !PlayerMethods.isNewgen(player)) {
                                ent.spawnAtLocation(TwinkAI.randItem());
                                PlayerMethods.addPlayerYassification(player, 1);
                            }
                            if (ent instanceof AbstractFlopFigures || (ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                                if (ent instanceof CupcakKe cupcakke) {
                                    CupcakKe.cupcakkeDuplication(ModItems.CVM.get(), cupcakke);
                                }
                                PlayerMethods.addPlayerYassification(player, 7 * ((int)chargedTime / 2));
                            }
                        }
                    } else if (type > 1) {
                        EntityMethods.monsterEffects(ent);
                    }
                }
                if (type < 2) {
                    ent.addEffect(new MobEffectInstance(ModEffects.CVMMED.get(), 1000 * multiplier(), amp));
                }
            }
        }
        if (world instanceof ServerLevel level) {
            level.sendParticles(switch (type) {
                        case 0 -> getCvmParticle();
                        case 1 -> getCvmiumParticle();
                        case 2 -> getBloodClumpParticle();
                        default -> getRegularParticle();
                    },
                    x, y, z, ((int) chargedTime * 15),1,1, 1, (chargedTime * 0.16));
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (item) -> item.is(ModItems.CVMIUM.get()) || item.is(ModItems.CVM.get()) || item.is(ModItems.BLOOD_CLUMP.get());
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15 * multiplier();
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 36000;
    }

    protected abstract SimpleParticleType getCvmParticle();
    protected abstract SimpleParticleType getCvmiumParticle();
    protected abstract SimpleParticleType getBloodClumpParticle();
    protected abstract SimpleParticleType getRegularParticle();
    protected abstract int secOnFire(int type, boolean flame);
    protected abstract SoundEvent getSquirtSound();
    protected abstract int multiplier();
}
