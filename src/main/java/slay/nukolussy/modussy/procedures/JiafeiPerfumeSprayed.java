package slay.nukolussy.modussy.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.entity.custom.Flops;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Comparator;
import java.util.List;

public class JiafeiPerfumeSprayed {
    private static void monsterEffects(LivingEntity ent) {
        ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.WITHER, 6900, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1690, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1690, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1710, 0));

    }

    private static void flopEffects(LivingEntity ent) {
        ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 6900, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1710, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1710, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6900, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1690, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1690, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1710, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1710, 0));
    }


    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        if (entity instanceof Player _ent) {
            flopEffects(_ent);
            _ent.giveExperiencePoints(5);
            (_ent).playSound(ModSounds.SPRAY.get());
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entIterator : _entfound) {
                if (entIterator instanceof LivingEntity _ent && entity instanceof LivingEntity player) {
                    if (entIterator instanceof AbstractVillager)
                        SlaginiumYassifierRightclicked.villagerYassification((AbstractVillager) entIterator, world);
                    if (entIterator instanceof Monster || entIterator instanceof Hoglin
                            || entIterator instanceof Shulker || entIterator instanceof Ghast || entIterator instanceof Phantom) {
                        monsterEffects((Mob) entIterator);
                    }
                    if (entIterator instanceof TamableAnimal _tamIsTamedBy && _tamIsTamedBy.isOwnedBy(player)
                            || entIterator instanceof Flops) {
                        flopEffects((Mob) entIterator);
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.DRIPPING_WATER, x, y, z, 15,1,1, 1, 1.0);
        }
        (itemStack).setDamageValue(itemStack.getDamageValue() + 1);
    }
}
