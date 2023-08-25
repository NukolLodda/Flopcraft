package slay.nukolussy.modussy.item.types;

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
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ToolMethods;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.network.period.PlayerMenstruationProvider;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.Comparator;
import java.util.List;

public class Tampon extends ArrowItem {
    public Tampon() {
        super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
    }
    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new Arrow(pLevel, pShooter) {
            @Override
            protected ItemStack getPickupItem() {
                return new ItemStack(ModItems.TAMPON.get());
            }
        };
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        entity.getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(period -> {
            if (world.getMoonPhase() == period.getPhase()) {
                double x = entity.getX();
                double y = entity.getY();
                double z = entity.getZ();
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream()
                            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (LivingEntity ent : _entfound) {
                        if (ent instanceof Spider spider) {
                            spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                            spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                            spider.kill();
                        }
                        if (ent instanceof Slime slime) {
                            ItemStack cvmItem = new ItemStack(ModItems.CVM.get());
                            if (slime instanceof MagmaCube) {
                                cvmItem = new ItemStack(ModItems.CVMIUM.get());
                            }
                            slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
                            slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                            slime.kill();
                        }
                        if (EntityMethods.isMonster(ent)) {
                            EntityMethods.monsterEffects(ent);
                        }
                        if (ent instanceof AbstractFlops ||
                                (ent instanceof Player surround && PlayerMethods.isFlop(surround))) {
                            EntityMethods.flopEffects(ent);
                        }
                        ToolMethods.yassification(ent, world, entity);
                    }
                }
                if (world instanceof ServerLevel level) {
                    level.sendParticles(ParticleTypes.ENTITY_EFFECT, x, y, z,
                            6, 1, 1, 1, 0.16f);
                }
            }
            entity.playSound(ModSounds.SQUIRT.get());
            ItemStack curItem = entity.getItemInHand(hand);
            curItem.setCount(curItem.getCount() - 1);

            entity.addItem(new ItemStack(ModItems.BLOODY_TAMPON.get()));
        });
        return ar;
    }
}
