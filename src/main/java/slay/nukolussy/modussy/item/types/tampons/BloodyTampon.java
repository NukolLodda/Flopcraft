package slay.nukolussy.modussy.item.types.tampons;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.projectiles.ShotBloodyTampon;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.network.period.PlayerMenstruationProvider;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class BloodyTampon extends ArrowItem {
    public BloodyTampon() {
        super(new Properties().fireResistant().rarity(Rarity.RARE));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        ToolMethods.slayAttack(itemStack, sourceentity, entity, 1);
        return true;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ShotBloodyTampon(pShooter, pLevel);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        InteractionResultHolder<ItemStack> ar = super.use(pLevel, pPlayer, pHand);
        pPlayer.getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(period -> {
            if (pLevel.getMoonPhase() == period.getPhase()) {
                double x = pPlayer.getX();
                double y = pPlayer.getY();
                double z = pPlayer.getZ();
                ToolMethods.yassifySurronding(pLevel, pPlayer, 4, 1, 2);
                pPlayer.hurt(pPlayer.level().damageSources().generic(), 3);
                if (pLevel instanceof ServerLevel level) {
                    level.sendParticles(ParticleTypes.ENTITY_EFFECT, x, y, z,
                            6, 1, 1, 1, 0.16f);
                }
                pPlayer.playSound(ModSounds.SQUIRT.get());
                ItemStack curItem = pPlayer.getItemInHand(pHand);
                curItem.setCount(curItem.getCount() - 1);
                Item tampon = ModItems.EXTRA_BLOODY_TAMPON.get();
                if (new Random().nextInt(69) == 0) {
                    tampon = ModItems.BLOOD_CLUMP.get();
                }
                pPlayer.addItem(new ItemStack(tampon));
            }
        });
        return ar;
    }
}
