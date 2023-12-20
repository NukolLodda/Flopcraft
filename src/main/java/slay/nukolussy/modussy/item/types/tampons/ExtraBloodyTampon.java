package slay.nukolussy.modussy.item.types.tampons;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entities.projectiles.ShotExtraBloodyTampon;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.network.period.PlayerMenstruationProvider;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.Comparator;
import java.util.List;

public class ExtraBloodyTampon extends ArrowItem {
    public ExtraBloodyTampon() {
        super(new Properties().fireResistant().rarity(Rarity.EPIC));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        ToolMethods.slayAttack(itemStack, sourceentity, entity, 1);
        if (EntityMethods.isMonster(entity)) {
            EntityMethods.monsterEffects(entity);
        }
        return true;
    }
    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ShotExtraBloodyTampon(pShooter, pLevel);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        InteractionResultHolder<ItemStack> ar = super.use(pLevel, pPlayer, pHand);
        pPlayer.getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(period -> {
            if (pLevel.getMoonPhase() == period.getPhase()) {
                double x = pPlayer.getX();
                double y = pPlayer.getY();
                double z = pPlayer.getZ();
                ToolMethods.yassifySurronding(pLevel, pPlayer, 5, 1, 3);
                EntityMethods.monsterEffects(pPlayer);
                pPlayer.hurt(pPlayer.level().damageSources().generic(), 3);
                if (pLevel instanceof ServerLevel level) {
                    level.sendParticles(ParticleTypes.ENTITY_EFFECT, x, y, z,
                            6, 1, 1, 1, 0.16f);
                }

                pPlayer.playSound(ModSounds.SQUIRT.get());
                ItemStack curItem = pPlayer.getItemInHand(pHand);
                curItem.setCount(curItem.getCount() - 1);
                pPlayer.addItem(new ItemStack(ModItems.BLOOD_CLUMP.get()));
            }
        });
        return ar;
    }

}
