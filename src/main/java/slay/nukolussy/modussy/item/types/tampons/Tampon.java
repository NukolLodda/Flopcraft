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
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.projectiles.ShotTampon;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ToolMethods;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.network.period.PlayerMenstruationProvider;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.entities.ModEntities;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Tampon extends ArrowItem {
    public Tampon() {
        super(new Properties().fireResistant().rarity(Rarity.RARE));
    }
    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ShotTampon(ModEntities.TAMPONS.get(), pShooter, pLevel);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        entity.getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(period -> {
            if (world.getMoonPhase() == period.getPhase()) {
                double x = entity.getX();
                double y = entity.getY();
                double z = entity.getZ();
                ToolMethods.yassifySurronding(world, entity, 3, 1, 1);
                if (world instanceof ServerLevel level) {
                    level.sendParticles(ParticleTypes.ENTITY_EFFECT, x, y, z,
                            6, 1, 1, 1, 0.16f);
                }
                entity.playSound(ModSounds.SQUIRT.get());
                ItemStack curItem = entity.getItemInHand(hand);
                curItem.setCount(curItem.getCount() - 1);
                Item tampon = ModItems.BLOODY_TAMPON.get();
                if (new Random().nextInt(69) == 0) {
                    tampon = ModItems.EXTRA_BLOODY_TAMPON.get();
                }
                entity.addItem(new ItemStack(tampon));
            }
        });
        return ar;
    }
}
