package net.nukollodda.flopcraft.item.types.tampons;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.nukollodda.flopcraft.entities.projectiles.ShotTampon;
import net.nukollodda.flopcraft.util.ToolMethods;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.network.period.PlayerMenstruationProvider;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.entities.FlopEntities;

import java.util.Random;

public class Tampon extends ArrowItem {
    public Tampon() {
        super(new Properties().fireResistant().rarity(Rarity.RARE));
    }
    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new ShotTampon(FlopEntities.TAMPONS.get(), pShooter, pLevel);
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
                entity.playSound(FlopSounds.SQUIRT.get());
                ItemStack curItem = entity.getItemInHand(hand);
                curItem.setCount(curItem.getCount() - 1);
                Item tampon = FlopItems.BLOODY_TAMPON.get();
                if (new Random().nextInt(69) == 0) {
                    tampon = FlopItems.EXTRA_BLOODY_TAMPON.get();
                }
                entity.addItem(new ItemStack(tampon));
            }
        });
        return ar;
    }
}
