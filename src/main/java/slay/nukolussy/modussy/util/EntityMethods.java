package slay.nukolussy.modussy.util;

import net.minecraft.Util;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.flops.traders.NickiMinaj;
import slay.nukolussy.modussy.entities.flops.twink.Twink;

import java.util.List;

public class EntityMethods {
    public static boolean isFlop(Entity entity) {
        return entity instanceof AbstractFlops || (entity instanceof Player player && PlayerMethods.isFlop(player));
    }

    public static boolean isMonster(Entity ent) {
        return ent instanceof Monster || ((ent instanceof Hoglin || ent instanceof Ghast
                || ent instanceof Shulker || ent instanceof Phantom)) ||
                (ent instanceof Player player && PlayerMethods.isDaboyz(player));
    }

    public static void monsterEffects(LivingEntity entity, int lvl, int amp) {
        if (entity instanceof Mob) {
            ((Mob) entity).setGuaranteedDrop(EquipmentSlot.MAINHAND);
        }
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
        if (lvl == 1) {
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 0));
        } else {
            entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
            if (lvl > 2)  entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
        }
    }

    public static void monsterEffects(LivingEntity ent) {
        ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.WITHER, 6900, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1690, 0));
        ent.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1690, 1));
        ent.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1710, 0));

    }

    public static void flopEffects(LivingEntity entity, int lvl, int amp) {
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300 * lvl, amp));
        entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600 * lvl, 0));
        entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600 * lvl, amp));
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400 * lvl, amp));
        entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600 * lvl, 2 * amp));
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600 * lvl, 2 * amp));
        entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300 * lvl, 0));
        if (lvl > 1) {
            entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600 * lvl, amp));
            entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 600 * lvl, 2 * amp));
            entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 600 * lvl, amp));
            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600 * lvl, 0));
            if (lvl > 2) entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600 * lvl, amp));
        }
    }

    public static void flopEffects(LivingEntity ent) {
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

    public static boolean canEntityBecomeNickiMinaj(LevelAccessor world, double x, double y, double z) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center)
                    .inflate(256 / 2d), e -> true).stream().toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof NickiMinaj) {
                    return false;
                }
            }
        }

        return true;
    }

    static void villagerYassification(AbstractVillager entity, LevelAccessor world, Player player) {
        int randval = (int) (Math.random() * 6971);
        float xRot = entity.getXRot();
        float yRot = entity.getYRot();
        EntityType<? extends AbstractFlops> type = ModEntities.TWINK.get();
        // the villager should have a 50/50 chance of either becoming a female flop or a twink
        if (randval < 34)
            type = ModEntities.CUPCAKKE.get();
        else if (randval < 69)
            type = ModEntities.JIAFEI.get();
        else if (randval < 90 && canEntityBecomeNickiMinaj(world, entity.getX(), entity.getY(), entity.getZ())) {
            type = ModEntities.NICKI_MINAJ.get();
        }
        AbstractFlops flop = entity.convertTo(type, true);
        assert flop != null;
        if (flop instanceof Twink twink)
            twink.setVariant(Util.getRandom(Twink.Variant.values(), world.getRandom()));
        if (flop instanceof Jiafei jiafei)
            jiafei.setVariant(Util.getRandom(Jiafei.Variant.values(), world.getRandom()));
        if (flop instanceof NickiMinaj minaj)
            minaj.setVariant(Util.getRandom(NickiMinaj.Variant.values(), world.getRandom()));
        flop.setCanPickUpLoot(true);
        flop.setXRot(xRot);
        flop.setYRot(yRot);
        flop.setTamed(player);
        flop.addAdditionalSaveData(flop.getPersistentData());
    }

    static void witchYassification(Witch entity, LevelAccessor world, Player player) {
        int randval = (int) (Math.random() * 2);
        float xRot = entity.getXRot();
        float yRot = entity.getYRot();
        EntityType<? extends AbstractFlops> type;
        if (Math.random() < (1f / 3) && canEntityBecomeNickiMinaj(world, entity.getX(), entity.getY(), entity.getZ()))
            type = ModEntities.NICKI_MINAJ.get();
        else {
            type = randval == 1 ? ModEntities.CUPCAKKE.get() : ModEntities.JIAFEI.get();
        }
            // witches can only turn into female flops, and not into twinks, this will be implemented at a different time
        AbstractFlops flop = entity.convertTo(type, true);
        assert flop != null;
        if (flop instanceof Jiafei jiafei) {
            jiafei.setVariant(Util.getRandom(Jiafei.Variant.values(), world.getRandom()));
        } if (flop instanceof NickiMinaj minaj)
            minaj.setVariant(Util.getRandom(NickiMinaj.Variant.values(), world.getRandom()));
        flop.setCanPickUpLoot(true);
        flop.setXRot(xRot);
        flop.setYRot(yRot);
        flop.setTamed(player);
        flop.getBrain().eraseMemory(MemoryModuleType.ANGRY_AT);
        flop.addAdditionalSaveData(flop.getPersistentData());
    }

    public static void alertFlops(Level world, int x, int y, int z, Player player) {
        {
            final Vec3 center = new Vec3(x, y, z);
            List<AbstractFlops> flops = world.getEntitiesOfClass(AbstractFlops.class, new AABB(center, center)
                    .inflate(5 / 2d), e -> true).stream().toList();
            for (AbstractFlops flop : flops) {
                flop.alertFlops(player);
            }
        }
    }
}
