package slay.nukolussy.modussy.procedures;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.client.renderer.twink.Variant;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.entity.custom.Flops;
import slay.nukolussy.modussy.entity.custom.twink.Twink;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.particles.ModParticleTypes;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.*;


@Mod.EventBusSubscriber
public class SlaginiumYassifierRightclicked {
    private static SimpleParticleType particleGen() {
        Random random = new Random();
        int randomNum = random.nextInt(1,6);
        if (randomNum == 1) return ModParticleTypes.AESTHETIC_1.get();
        else if (randomNum == 2) return ModParticleTypes.AESTHETIC_2.get();
        else if (randomNum == 3) return ModParticleTypes.AESTHETIC_3.get();
        else if (randomNum == 4) return ModParticleTypes.AESTHETIC_4.get();
        else return ModParticleTypes.AESTHETIC_5.get();
    }
    private static SoundEvent AestheticSounds(int up) {
        if (up > 8) up = 8;
        Random random = new Random();
        int randomNum = random.nextInt(1,up);
        if (randomNum == 1) return ModSounds.AESTHETIC_1.get();
        else if (randomNum == 2) return ModSounds.AESTHETIC_2.get();
        else if (randomNum == 3) return ModSounds.AESTHETIC_3.get();
        else if (randomNum == 4) return ModSounds.AESTHETIC_4.get();
        else if (randomNum == 5) return ModSounds.AESTHETIC_5.get();
        else if (randomNum == 6) return ModSounds.AESTHETIC_SHENSEEA.get();
        else return ModSounds.AESTHETIC_JIAFEI.get();
    }

    private static void monsterEffects(LivingEntity entity, int lvl, int amp) {
        if (entity instanceof Mob) {
            ((Mob) entity).setGuaranteedDrop(EquipmentSlot.MAINHAND);
        }
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
        entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
        if (lvl == 1) {
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 0));
        }
        else {
            entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
            if (lvl > 2)  entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
        }
        entity.hurt(new DamageSource("slayyyy").bypassArmor(), 2 * lvl);
    }

    private static void flopEffects(LivingEntity entity, int lvl, int amp) {
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
    private static ItemStack randItem(int up) {
        if (up > 3) up = 3;
        Random random = new Random();
        int randomNum = random.nextInt(0,up);
        if (randomNum == 0) return new ItemStack(ModItem.CUPCAKE.get());
        else if (randomNum == 1) return new ItemStack(ModItem.SHENSEIUM.get());
        else return new ItemStack(ModItem.JIAFEI_PRODUCT.get());
    }

    public static void villagerYassification(AbstractVillager entity, LevelAccessor world) {
        if (entity instanceof Villager || entity instanceof WanderingTrader) {
            Random rand = new Random();
            int randval = rand.nextInt(0, 6971);
            EntityType<? extends Flops> type = ModEntities.TWINK.get();
            if (randval < 34)
                type = ModEntities.CUPCAKKE.get();
            else if (randval < 69)
                type = ModEntities.JIAFEI.get();
            Flops flop = entity.convertTo(type, true);
            assert flop != null;
            if (flop instanceof Twink twink)
                twink.setVariant(Util.getRandom(Variant.values(), world.getRandom()));
            flop.setCanPickUpLoot(true);
            flop.addAdditionalSaveData(flop.getPersistentData());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack, int lvl) {
        int itemDura = 104;
        int amp = (lvl + 1) / 2;
        if (entity == null)
            return;
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(randItem(lvl));
        if (entity instanceof Player _player) {
            (_player).playSound(AestheticSounds(lvl + 5));
            if (!_player.level.isClientSide()) {
                _player.displayClientMessage(Component.literal("§dAesthetic Warning"), (true));
                if (lvl > 2) {
                    _player.getAbilities().mayfly = (true);
                    _player.onUpdateAbilities();
                    Modussy.queueServerWork(42069, () -> {
                        _player.getAbilities().mayfly = (false);
                        _player.onUpdateAbilities();
                    });
                }
            }
            _player.getCooldowns().addCooldown(itemStack.getItem(), 100 * lvl);
            flopEffects(_player, lvl, amp);
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(28 + (4 * lvl) / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof LivingEntity) {
                    if (entityiterator instanceof Spider) {
                        entityiterator.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItem.ARANA_GRANDE.get()));
                        ((Spider) entityiterator).setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        entityiterator.kill();
                    }
                    if (entityiterator instanceof AbstractVillager) {
                        villagerYassification((AbstractVillager) entityiterator, world);
                        itemDura += 10;
                    }
                    if (entityiterator instanceof Monster || ((entityiterator instanceof Hoglin || entityiterator instanceof Ghast
                            || entityiterator instanceof Shulker || entityiterator instanceof Phantom) && lvl > 1)) {
                        monsterEffects((Mob) entityiterator, lvl, amp);
                        itemDura += 80;
                    }
                    if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof Player _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
                            || entityiterator instanceof Flops) {
                        flopEffects((Mob) entityiterator, lvl, amp);
                        itemDura += 120;
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(particleGen(), x, y, z, 60 / lvl,5,5, 5, 1.0);
            if (lvl > 2) {
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
                        4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "time set 1000");
                if (lvl > 3) {
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
                            4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "weather clear");
                }
            }
        }
        (itemStack).setDamageValue(itemStack.getDamageValue() + itemDura);
    }
}
