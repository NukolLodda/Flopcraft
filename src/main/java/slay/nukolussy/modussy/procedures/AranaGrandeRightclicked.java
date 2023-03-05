package slay.nukolussy.modussy.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Comparator;
import java.util.List;

public class AranaGrandeRightclicked {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        if (entity == null)
            return;
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(itemStack);
        if (entity instanceof Player _player) {
            ((Player) _player).playSound(ModSounds.YUH.get());
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof Monster) {
                    ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2400, 10));
                    ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.WITHER, 690, 1));
                    ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2400, 10));
                    entityiterator.hurt(new DamageSource("yuh").bypassArmor(), 5);
                }
                if (entityiterator instanceof LivingEntity && !(entityiterator instanceof Player)) {
                    ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 690, 5));
                    ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 690, 5));
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 100,5,5, 5, 1.0);
        }
        (itemStack).shrink(1);
    }
}
