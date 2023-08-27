package slay.nukolussy.modussy.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.block.plants.JiafeiCrop;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.flops.FlopEntities;
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.flops.figures.LovelyPeaches;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.flops.twink.Twink;
import slay.nukolussy.modussy.entities.flops.twink.TwinkAI;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.List;

public class ToolMethods {
    private static long getGameDayTick(ServerLevel level) {
        long time = level.getGameTime() / 24000L;
        if (level.getDayTime() > 6000) {
            time++;
        }
        return time * 24000L;
    }
    private static SoundEvent AestheticSounds(int up) {
        if (up > 8) up = 8;
        int randomNum = (int) (Math.random() * (up - 1)) + 1;

        return switch (randomNum) {
            case 1 -> ModSounds.AESTHETIC_1.get();
            case 2 -> ModSounds.AESTHETIC_2.get();
            case 3 -> ModSounds.AESTHETIC_3.get();
            case 4 -> ModSounds.AESTHETIC_4.get();
            case 5 -> ModSounds.AESTHETIC_5.get();
            case 6 -> ModSounds.AESTHETIC_SHENSEEA.get();
            default -> ModSounds.AESTHETIC_JIAFEI.get();
        };
    }

    private static ItemStack randItem(int up) {
        if (up > 3) up = 3;
        int randomNum = (int) (Math.random() * up);
        return switch (randomNum) {
            case 1 -> new ItemStack(ModItems.SHENSEIUM.get());
            case 2 -> new ItemStack(ModItems.JIAFEI_PRODUCT.get());
            default -> new ItemStack(ModItems.CUPCAKE.get());
        };
    }

    public static void aranaGrandeRightClick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        if (entity == null)
            return;
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(itemStack);
        if (entity instanceof Player _player) {
            _player.playSound(ModSounds.YUH.get());
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center)
                    .inflate(32 / 2d), e -> true).stream().toList();
            for (LivingEntity _ent : _entfound) {
                if (_ent instanceof Monster) {
                    _ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2400, 10, true, false));
                    _ent.addEffect(new MobEffectInstance(MobEffects.WITHER, 690, 1));
                    _ent.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2400, 10));
                }
                if (!(_ent instanceof Player)) {
                    _ent.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 690, 5, true, false));
                    _ent.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 690, 5, true, false));
                }
                if (entity instanceof Player player) {
                    if (_ent instanceof AbstractFlopFigures ||
                            (_ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                        PlayerMethods.addPlayerYassification(player, -3);
                    } else if (EntityMethods.isFlop(_ent)) {
                        PlayerMethods.addPlayerYassification(player, -1);
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 100,5,5, 5, 1.0);
        }
        itemStack.shrink(1);
    }

    public static void makeupUse(Entity entity, ItemStack item, int lvl) {
        if (entity instanceof LivingEntity living) {
            if (EntityMethods.isFlop(living)) {
                EntityMethods.flopEffects(living, lvl, lvl / 2);
            } else if (EntityMethods.isMonster(living)) {
                EntityMethods.monsterEffects(living);
            }
            item.setDamageValue(item.getDamageValue() + 1);
        }
    }

    public static void jiafeiPerfumeSpray(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center)
                    .inflate(2 / 2d), e -> true).stream().toList();
            for (LivingEntity _ent : _entfound) {
                if (entity instanceof Player player) {
                    yassification(_ent, world, player);
                    if (EntityMethods.isMonster(_ent)) {
                        EntityMethods.monsterEffects(_ent);
                    }
                    if (_ent instanceof Cat _cat && Math.random() < 0.16) {
                        _cat.spawnAtLocation(ModItems.POSEI.get());
                    }
                    if (EntityMethods.isFlop(_ent)) {
                        EntityMethods.flopEffects(_ent);
                        if (_ent instanceof AbstractFlopFigures || (_ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                            PlayerMethods.addPlayerYassification(player, 7);
                        } else if (_ent instanceof AbstractFlops || _ent instanceof Player) {
                            PlayerMethods.addPlayerYassification(player, 1);
                        }
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.DRIPPING_WATER, x, y, z, 15,1,1, 1, 1.0);
        }
        (itemStack).setDamageValue(itemStack.getDamageValue() + 1);

        if (entity instanceof Player _ent) {
            EntityMethods.flopEffects(_ent);
            _ent.giveExperiencePoints(5);
            _ent.playSound(ModSounds.SPRAY.get());
        }
    }

    public static void yassifierRightClick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack, int lvl) {
        int itemDura = 104;
        int amp = (lvl + 1) / 2;
        if (entity == null) return;
        if (entity instanceof Player _player) {
            (_player).playSound(AestheticSounds(lvl + 5));
            if (!_player.level().isClientSide()) {
                _player.displayClientMessage(Component.translatable("subtitle.aesthetic_warning").withStyle(ChatFormatting.LIGHT_PURPLE), true);
                if (lvl > 2) {
                    _player.getAbilities().mayfly = (true);
                    _player.onUpdateAbilities();
                }
            }
            _player.getCooldowns().addCooldown(itemStack.getItem(), 100 * lvl);
            EntityMethods.flopEffects(_player, lvl, amp);
        }
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(randItem(lvl));
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center)
                    .inflate(28 + (4 * lvl) / 2d), e -> true).stream().toList();
            for (LivingEntity _ent : _entfound) {
                if (entity instanceof Player player) {
                    if (_ent instanceof Spider _spider) {
                        _spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                        _spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        PlayerMethods.addPlayerYassification(player, 1);
                        _spider.kill();
                    }
                    if (_ent instanceof Slime slime) {
                        ItemStack cvmItem = new ItemStack(ModItems.CVM.get());
                        if (slime instanceof MagmaCube) {
                            cvmItem = new ItemStack(ModItems.CVMIUM.get());
                        }
                        slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
                        slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        PlayerMethods.addPlayerYassification(player, 1);
                        slime.kill();
                    }
                    yassification(_ent, world, player);
                    if (_ent instanceof Villager || _ent instanceof Witch) itemDura += 10;
                    if (EntityMethods.isMonster(_ent) && lvl > 1) {
                        EntityMethods.monsterEffects(_ent, lvl, amp);
                        itemDura += 80;
                    }
                    if (_ent instanceof Cat _cat && Math.random() < 0.16) {
                        _cat.spawnAtLocation(ModItems.POSEI.get());
                        PlayerMethods.addPlayerYassification(player, 1);
                    }
                    if (EntityMethods.isFlop(_ent)) {
                        EntityMethods.flopEffects(_ent, lvl, amp);
                        itemDura += 120;
                        if (_ent instanceof AbstractFlopFigures || (_ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                            PlayerMethods.addPlayerYassification(player, 3 * lvl);
                        } else if (_ent instanceof AbstractFlops || _ent instanceof Player) {
                            PlayerMethods.addPlayerYassification(player, lvl);
                        }
                    }
                }
            }
        }
        if (world instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.SMOKE, x, y, z, 60 / lvl,5,5, 5, 1.0);
            if (lvl > 2) {
                server.setDayTime(getGameDayTick(server) + 6000);
                if (lvl > 3) {
                    server.setWeatherParameters(69000,69,false,false);
                }
            }
        }
        itemStack.setDamageValue(itemStack.getDamageValue() + itemDura);
    }

    public static void slayAttack(ItemStack item, Entity source, Entity target, int lvl) {
        int amp = (lvl + 1) / 2, itemDura = 0;
        if (EntityMethods.isFlop(source)) {
            ((LivingEntity) source).heal(3.0f);
        }

        if (target instanceof LivingEntity living) {
            if (lvl == 1) living.addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 0));
            if (EntityMethods.isMonster(living) && lvl > 1) {
                if (target instanceof Spider _spider) {
                    _spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                    _spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                    if (source instanceof Player player) PlayerMethods.addPlayerYassification(player, lvl);
                }
                living.addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                if (lvl > 2) ((Mob) target).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
                itemDura += 120;
            }

            if (living instanceof FlopEntities && source instanceof Player player &&
                    !(PlayerMethods.isNeutralBossFight(player, living))) {
                int subNum = living instanceof AbstractFlopFigures ? -7 : -1;
                PlayerMethods.addPlayerYassification(player, subNum * lvl);
            }
            if (living instanceof Player player && PlayerMethods.isFlop(player)) {
                int subNum = PlayerMethods.isFlopIcon(player) ? -7 : PlayerMethods.isMagicFlop(player) ? -3 : 1;
                PlayerMethods.addPlayerYassification(player, subNum * lvl);
            }

            if (living instanceof Slime slime) {
                ItemStack cvmItem = new ItemStack(ModItems.CVM.get());
                if (slime instanceof MagmaCube) {
                    cvmItem = new ItemStack(ModItems.CVMIUM.get());
                }
                slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
                slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                slime.kill();
            }
        }
        item.setDamageValue(item.getDamageValue() + itemDura);
    }

    public static void slayBreak(Level lvl, BlockState state, BlockPos pos, LivingEntity ent) {
        Block block = state.getBlock();
        if (block instanceof JiafeiCrop crop) {
            if (crop.getAge(state) == 4) {
                Mob newMob = new Jiafei(ModEntities.JIAFEI.get(), lvl);
                newMob.moveTo(pos.getX(), pos.getY(), pos.getZ());
                ent.level().addFreshEntity(newMob);
                ent.spawnAtLocation(ModItems.JIAFEI_PRODUCT.get());
            }
        }
    }

    public static void cvmShoot(LevelAccessor world, double x, double y, double z, Entity entity,
                                ItemStack deeldo, boolean isCvmium, float chargedTime) {
        int power = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, deeldo);
        boolean flame = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, deeldo) > 0;
        int amp = isCvmium ? 2 : 1;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center)
                    .inflate(2 * chargedTime / 2d), e -> true).stream().toList();
            for (LivingEntity _ent : _entfound) {
                if (entity instanceof Player player) {
                    yassification(_ent, world, player);
                    if (EntityMethods.isMonster(_ent)) {
                        EntityMethods.monsterEffects(_ent, amp * ((int)chargedTime),amp - 1);
                        _ent.hurt(_ent.level().damageSources().playerAttack(player), power * 10 * (int)chargedTime);
                        _ent.setSecondsOnFire(flame ? isCvmium ? 420 : 100 : 0);
                    }
                    if (_ent instanceof Cat _cat && Math.random() < 0.16) {
                        _cat.spawnAtLocation(ModItems.POSEI.get());
                        PlayerMethods.addPlayerYassification(player, 1);
                    }
                    if (EntityMethods.isFlop(_ent)) {
                        EntityMethods.flopEffects(_ent, amp,amp - 1);
                        if (Math.random() < 0.08333) {
                            if (_ent instanceof Twink && PlayerMethods.notNewgen(player)) {
                                _ent.spawnAtLocation(TwinkAI.randItem());
                                PlayerMethods.addPlayerYassification(player, 1);
                            }
                            if (_ent instanceof AbstractFlopFigures || (_ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                                if (_ent instanceof CupcakKe _cupcakke) {
                                    CupcakKe.cupcakkeDuplication(ModItems.CVM.get(), _cupcakke);
                                }
                                PlayerMethods.addPlayerYassification(player, 7 * ((int)chargedTime / 2));
                            }
                        }
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(isCvmium ? ParticleTypes.LAVA :ParticleTypes.END_ROD,
                    x, y, z, ((int) chargedTime * 15),1,1, 1, (chargedTime * 0.16));
        }
    }

    public static void yassification(LivingEntity ent, LevelAccessor world, Player player) {
        if (ent instanceof AbstractVillager villager) {
            EntityMethods.villagerYassification(villager, world, player);
            PlayerMethods.addPlayerYassification(player, 10);
        }
        if (ent instanceof Witch witch) {
            EntityMethods.witchYassification(witch, world, player);
            PlayerMethods.addPlayerYassification(player, 71);
        }
    }
}
