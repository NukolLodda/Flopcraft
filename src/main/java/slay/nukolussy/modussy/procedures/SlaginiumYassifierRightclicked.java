package slay.nukolussy.modussy.procedures;

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.particles.ModParticleTypes;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Comparator;
import java.util.List;
import java.util.Random;


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
    private static ItemStack randItem(int up) {
        Random random = new Random();
        int randomNum = random.nextInt(0,up);
        if (randomNum == 0) return new ItemStack(ModItem.CUPCAKE.get());
        else return new ItemStack(ModItem.SHENSEIUM.get());
    }
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack, int lvl) {
        int itemDura = 104;
        int amp = (lvl + 1) / 2;
        if (entity == null)
            return;
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(randItem(lvl));
        if (entity instanceof Player _player) {
            _player.giveExperiencePoints(5);
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
        }
        if (entity instanceof Player) {
            if (entity instanceof Player _player) {
                _player.getCooldowns().addCooldown(itemStack.getItem(), 100);
            }
            if (entity instanceof LivingEntity _entity) {
                _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300 * lvl, amp));
                _entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600 * lvl, amp));
                _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600 * lvl, amp));
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400 * lvl, amp));
                _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600 * lvl, 2 * amp));
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600 * lvl, 2 * amp));
                _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300 * lvl, amp));
                if (lvl > 1) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600 * lvl, amp));
                    _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 600 * lvl, 2 * amp));
                    _entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 600 * lvl, amp));;
                    _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600 * lvl, amp));
                    if (lvl > 2) _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600 * lvl, amp));
                }
            }
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof Monster) {
                    ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
                    ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
                    if (lvl == 1) ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 1));
                    else {
                        ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
                        ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                        if (lvl > 2) ((Monster) entityiterator).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 1));
                    }
                    entityiterator.hurt(new DamageSource("slayyyy").bypassArmor(), 2);
                    itemDura += 80;
                }
                if (entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof Player _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)) {
                    ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300 * lvl, amp));
                    ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 600 * lvl, amp));
                    ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600 * lvl, amp));
                    ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400 * lvl, amp));
                    if (lvl > 1) {
                        ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400 * lvl, amp));
                        ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.LUCK, 400 * lvl, amp));
                        ((TamableAnimal) entityiterator).addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                    }
                    itemDura += 120;
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(particleGen(), x, y, z, 60 / lvl,5,5, 5, 1.0);
            if (lvl > 2) {
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
                        4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "time set 1000");

            }
        }
        (itemStack).setDamageValue(itemDura);
    }
}
