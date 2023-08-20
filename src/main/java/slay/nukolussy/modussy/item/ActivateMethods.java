package slay.nukolussy.modussy.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.block.JiafeiCrop;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.flops.CupcakKe;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.flops.traders.NickiMinaj;
import slay.nukolussy.modussy.entities.flops.twink.Twink;
import slay.nukolussy.modussy.entities.flops.twink.TwinkAI;
import slay.nukolussy.modussy.network.yassification.PlayerYassification;
import slay.nukolussy.modussy.network.yassification.PlayerYassificationProvider;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActivateMethods {
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

    public static boolean notDaboyz(Player player) {
        AtomicBoolean isDaboyz = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isDaboyz.set(yassification.isDaboyz());
        });
        return !isDaboyz.get();
    }

    public static boolean notNewgen(Player player) {
        AtomicBoolean isNewgen = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isNewgen.set(yassification.isNewgen());
        });
        return !isNewgen.get();
    }

    public static boolean isFlop(Player player) {
        AtomicBoolean isFlop = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isFlop.set(yassification.isFlop());
        });
        return isFlop.get();
    }

    public static boolean canEntityBecomeNickiMinaj(LevelAccessor world, double x, double y, double z) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(256 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof NickiMinaj) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isMonster(LivingEntity ent) {
        return ent instanceof Monster || ((ent instanceof Hoglin || ent instanceof Ghast
                || ent instanceof Shulker || ent instanceof Phantom));
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

    private static void villagerYassification(AbstractVillager entity, LevelAccessor world, Player player) {
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
        // nicki minaj will only spawn in there's no other nicki minaj within 5 chunks
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

    private static void witchYassification(Witch entity, LevelAccessor world, Player player) {
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

    public static void aranaGrandeRightClick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        if (entity == null)
            return;
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(itemStack);
        if (entity instanceof Player _player) {
            _player.playSound(ModSounds.YUH.get());
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (LivingEntity entityiterator : _entfound) {
                if (entityiterator instanceof Monster monster) {
                    monster.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2400, 10, true, false));
                    monster.addEffect(new MobEffectInstance(MobEffects.WITHER, 690, 1));
                    monster.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2400, 10));
                }
                if (!(entityiterator instanceof Player)) {
                    entityiterator.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 690, 5, true, false));
                    entityiterator.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 690, 5, true, false));
                }
                if (entity instanceof Player player) {
                    if (entityiterator instanceof AbstractFlopFigures) {
                        addPlayerYassification(player, -5);
                    } else if (entityiterator instanceof AbstractFlops) {
                        addPlayerYassification(player, -1);
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 100,5,5, 5, 1.0);
        }
        itemStack.shrink(1);
    }

    public static void jiafeiPerfumeSpray(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (LivingEntity _ent : _entfound) {
                if (entity instanceof Player player) {
                    yassification(_ent, world, player);
                    if (isMonster(_ent)) {
                        monsterEffects(_ent);
                    }
                    if (_ent instanceof Cat _cat && Math.random() < 0.16) {
                        _cat.spawnAtLocation(ModItems.POSEI.get());
                    }
                    if (_ent instanceof TamableAnimal _tamIsTamedBy && _tamIsTamedBy.isOwnedBy(player)
                            || _ent instanceof AbstractFlops) {
                        flopEffects(_ent);
                        if (_ent instanceof AbstractFlopFigures) {
                            addPlayerYassification(player, 7);
                        } else if (_ent instanceof AbstractFlops) {
                            addPlayerYassification(player, 1);
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
            flopEffects(_ent);
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
            flopEffects(_player, lvl, amp);
        }
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(randItem(lvl));
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(28 + (4 * lvl) / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (LivingEntity _ent : _entfound) {
                if (entity instanceof Player player) {
                    if (_ent instanceof Spider _spider) {
                        _spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                        _spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        _spider.kill();
                        addPlayerYassification(player, lvl);
                    }
                    if (_ent instanceof Slime slime) {
                        ItemStack cvmItem = new ItemStack(ModItems.CVM.get());
                        if (slime instanceof MagmaCube) {
                            cvmItem = new ItemStack(ModItems.CVMIUM.get());
                        }
                        slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
                        slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        slime.kill();
                    }
                    yassification(_ent, world, player);
                    if (_ent instanceof Villager || _ent instanceof Witch) itemDura += 10;
                    if (isMonster(_ent) && lvl > 1) {
                        monsterEffects(_ent, lvl, amp);
                        itemDura += 80;
                    }
                    if (_ent instanceof Cat _cat && Math.random() < 0.16) {
                        _cat.spawnAtLocation(ModItems.POSEI.get());
                        addPlayerYassification(player, 1);
                    }
                    if (_ent instanceof TamableAnimal _tamIsTamedBy && _tamIsTamedBy.isOwnedBy(player)
                            || _ent instanceof AbstractFlops) {
                        flopEffects(_ent, lvl, amp);
                        itemDura += 120;
                        if (_ent instanceof AbstractFlopFigures) {
                            addPlayerYassification(player, 3 * lvl);
                        } else if (_ent instanceof AbstractFlops) {
                            addPlayerYassification(player, lvl);
                        }
                    }
                }
            }
        }
        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.SMOKE, x, y, z, 60 / lvl,5,5, 5, 1.0);
            if (lvl > 2) {
                _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
                        4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "time set 1000");
                if (lvl > 3) {
                    _level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
                            4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "weather clear");
                }
            }
        }
        itemStack.setDamageValue(itemStack.getDamageValue() + itemDura);
    }

    public static void slayAttack(ItemStack item, Entity source, Entity target, int lvl) {
        int amp = (lvl + 1) / 2, itemDura = 0;
        if (source instanceof Player || source instanceof AbstractFlops) {
            ((LivingEntity) source).heal(3.0f);
        }

        if (target instanceof LivingEntity living) {
            if (lvl == 1) living.addEffect(new MobEffectInstance(MobEffects.POISON, 1380 * lvl, 0));
            if (isMonster(living) && lvl > 1) {
                if (target instanceof Spider _spider) {
                    _spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                    _spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                    if (source instanceof Player player) addPlayerYassification(player, lvl);
                }
                living.addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                if (lvl > 2) ((Mob) target).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
                itemDura += 120;
            }

            if (living instanceof AbstractFlops && source instanceof Player player) {
                int subNum = living instanceof AbstractFlopFigures ? -7 : -1;
                addPlayerYassification(player, subNum * lvl);
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
        (item).setDamageValue(item.getDamageValue() + itemDura);
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
            List<LivingEntity> _entfound = world.getEntitiesOfClass(LivingEntity.class, new AABB(_center, _center).inflate(2 * chargedTime / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (LivingEntity _ent : _entfound) {
                if (entity instanceof Player player) {
                    yassification(_ent, world, player);
                    if (isMonster(_ent)) {
                        monsterEffects(_ent, amp * ((int)chargedTime),amp - 1);
                        _ent.hurt(_ent.level().damageSources().playerAttack(player), power * 10 * (int)chargedTime);
                        _ent.setSecondsOnFire(flame ? isCvmium ? 420 : 100 : 0);
                    }
                    if (_ent instanceof Cat _cat && Math.random() < 0.16) {
                        _cat.spawnAtLocation(ModItems.POSEI.get());
                        addPlayerYassification(player, 1);
                    }
                    if (_ent instanceof TamableAnimal _tamIsTamedBy && _tamIsTamedBy.isOwnedBy(player)
                            || _ent instanceof AbstractFlops) {
                        flopEffects(_ent, amp,amp - 1);
                        if (Math.random() < 0.08333) {
                            if (_ent instanceof Twink && notNewgen(player)) {
                                _ent.spawnAtLocation(TwinkAI.randItem());
                                addPlayerYassification(player, 1);
                            }
                            if (_ent instanceof AbstractFlopFigures) {
                                if (_ent instanceof CupcakKe _cupcakke) {
                                    CupcakKe.cupcakkeDuplication(ModItems.CVM.get(), _cupcakke);
                                }
                                addPlayerYassification(player, 7 * ((int)chargedTime / 2));
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
            villagerYassification(villager, world, player);
            addPlayerYassification(player, 10);
        }
        if (ent instanceof Witch witch) {
            witchYassification(witch, world, player);
            addPlayerYassification(player, 71);
        }
    }

    public static void addPlayerYassification(Player player, int added) {
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            if (added > 0) {
                yassification.addYassification(added);
            } else {
                yassification.subYassification(Math.abs(added));
            }

            if (yassification.isDaboyz()) {
                if (!yassification.wasDaboyz(added)) {
                    player.displayClientMessage(Component.translatable("subtitle.is_daboyz")
                            .withStyle(ChatFormatting.DARK_RED), true);
                    player.playSound(SoundEvents.VILLAGER_HURT);
                }
            }
            if (yassification.isNewgen()) {
                if (!yassification.wasNewgen(added)) {
                    player.displayClientMessage(Component.translatable("subtitle.is_newgen")
                            .withStyle(ChatFormatting.RED), true);
                    player.playSound(SoundEvents.VILLAGER_NO);
                }
            }
            if (yassification.isFlop()) {
                if (!yassification.wasFlop(added)) {
                    player.displayClientMessage(Component.translatable("subtitle.is_flop")
                            .withStyle(ChatFormatting.AQUA), true);
                    player.playSound(ModSounds.AESTHETIC_3.get());
                }
            }
            if (yassification.isMagicFlop()) {
                if (!yassification.wasMagicFlop(added)) {
                    player.displayClientMessage(Component.translatable("subtitle.is_magic_flop")
                                    .withStyle(ChatFormatting.DARK_PURPLE), true);
                    player.playSound(ModSounds.AESTHETIC_1.get());
                }
            }
            if (yassification.isFlopIcon()) {
                if (!yassification.wasFlopIcon(added)) {
                    player.displayClientMessage(Component.translatable("subtitle.is_flop_leader")
                                    .withStyle(ChatFormatting.LIGHT_PURPLE), true);
                    player.playSound(ModSounds.AESTHETIC_JIAFEI.get());
                }
            }
        });
    }
}
