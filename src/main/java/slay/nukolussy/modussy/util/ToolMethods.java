package slay.nukolussy.modussy.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.block.plants.JiafeiCrop;
import slay.nukolussy.modussy.effect.ModEffects;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.flops.IFlopEntity;
import slay.nukolussy.modussy.entities.flops.figures.CupcakKe;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.entities.twink.AbstractTwink;
import slay.nukolussy.modussy.entities.twink.Twink;
import slay.nukolussy.modussy.entities.twink.TwinkAI;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.*;

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
        if (entity instanceof Player player) {
            player.playSound(ModSounds.YUH.get());
        }
        {
            final Vec3 center = new Vec3(x, y, z);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(32 / 2d), e -> true).stream().toList();
            for (LivingEntity ent : entities) {
                ent.addEffect(new MobEffectInstance(ModEffects.YUH.get(), 1000, 0));
            }
        }
        if (world instanceof ServerLevel level) {
            level.sendParticles(ParticleTypes.CLOUD, x, y, z, 100,5,5, 5, 1.0);
        }
        itemStack.shrink(1);
    }

    public static void makeupUse(Entity entity, ItemStack item, int lvl) {
        if (entity instanceof LivingEntity living) {
            EntityMethods.addEffects(living, lvl, lvl / 2);
            item.setDamageValue(item.getDamageValue() + 1);
        }
    }

    public static void jiafeiPerfumeSpray(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack) {
        {
            final Vec3 center = new Vec3(x, y, z);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(2 / 2d), e -> true).stream().toList();
            for (LivingEntity ent : entities) {
                if (entity instanceof Player player) {
                    yassification(ent, world, player);
                    if (EntityMethods.isMonster(ent)) {
                        EntityMethods.monsterEffects(ent);
                    }
                    if (ent instanceof Cat cat && Math.random() < 0.16) {
                        cat.spawnAtLocation(ModItems.POSEI.get());
                    }
                    if (EntityMethods.isFlop(ent)) {
                        EntityMethods.flopEffects(ent);
                        if (ent instanceof AbstractFlopFigures || (ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                            PlayerMethods.addPlayerYassification(player, 7);
                        } else if (ent instanceof IFlopEntity || ent instanceof Player) {
                            PlayerMethods.addPlayerYassification(player, 1);
                        }
                    }
                }
            }
        }
        if (world instanceof ServerLevel level) {
            level.sendParticles(ParticleTypes.DRIPPING_WATER, x, y, z, 15,1,1, 1, 1.0);
        }
        (itemStack).setDamageValue(itemStack.getDamageValue() + 1);

        if (entity instanceof Player player) {
            EntityMethods.flopEffects(player);
            player.giveExperiencePoints(5);
            player.playSound(ModSounds.SPRAY.get());
        }
    }

    public static void yassifierRightClick(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemStack, int lvl) {
        int itemDura = 104;
        int amp = (lvl + 1) / 2;
        if (entity == null) return;
        if (entity instanceof Player player) {
            (player).playSound(AestheticSounds(lvl + 5));
            if (!player.level().isClientSide()) {
                player.displayClientMessage(Component.translatable("subtitle.aesthetic_warning").withStyle(ChatFormatting.LIGHT_PURPLE), true);
                if (lvl > 2) {
                    player.getAbilities().mayfly = (true);
                    player.onUpdateAbilities();
                }
            }
            player.getCooldowns().addCooldown(itemStack.getItem(), 100 * lvl);
            EntityMethods.flopEffects(player, lvl, amp);
        }
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(randItem(lvl));
        {
            final Vec3 center = new Vec3(x, y, z);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(28 + (4 * lvl) / 2d), e -> true).stream().toList();
            for (LivingEntity ent : entities) {
                if (entity instanceof Player player) {
                    if (ent instanceof Spider spider) {
                        spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                        spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        PlayerMethods.addPlayerYassification(player, 1);
                        spider.kill();
                    }
                    if (ent instanceof Slime slime) {
                        ItemStack cvmItem = new ItemStack(ModItems.CVM.get());
                        if (slime instanceof MagmaCube) {
                            cvmItem = new ItemStack(ModItems.CVMIUM.get());
                        }
                        slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
                        slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                        PlayerMethods.addPlayerYassification(player, 1);
                        slime.kill();
                    }
                    yassification(ent, world, player);
                    if (ent instanceof Villager || ent instanceof Witch) itemDura += 10;
                    if (ent instanceof Cat cat && Math.random() < 0.16) {
                        cat.spawnAtLocation(ModItems.POSEI.get());
                        PlayerMethods.addPlayerYassification(player, 1);
                    }
                    EntityMethods.addEffects(ent, lvl, amp);
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
                if (target instanceof Spider spider) {
                    spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                    spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                    if (source instanceof Player player) PlayerMethods.addPlayerYassification(player, lvl);
                }
                living.addEffect(new MobEffectInstance(MobEffects.WITHER, 1380 * lvl, amp));
                living.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1380 * lvl, amp));
                if (lvl > 2) ((Mob) target).addEffect(new MobEffectInstance(MobEffects.LEVITATION, 600, 0));
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8400 * lvl, amp));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 8400 * lvl, amp));
                itemDura += 120;
            }

            if (living instanceof IFlopEntity && source instanceof Player player &&
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

    // type 0 - cvm, 1 - cvmium, 2 - blood
    public static void deeldoShoot(LevelAccessor world, double x, double y, double z, LivingEntity entity,
                                   ItemStack deeldo, int type, float chargedTime) {
        int power = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, deeldo);
        boolean flame = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, deeldo) > 0;
        int amp = type + 1;
        {
            final Vec3 center = new Vec3(x, y, z);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(2 * chargedTime / 2d), e -> true).stream().toList();
            for (LivingEntity ent : entities) {
                if (EntityMethods.isMonster(ent)) {
                    EntityMethods.monsterEffects(ent, amp * ((int)chargedTime),amp - 1);
                    ent.hurt(ent.level().damageSources().mobAttack(entity), power * 10 * (int)chargedTime);
                    ent.setSecondsOnFire(flame ? switch (type) {
                        case 0 -> 100;
                        case 1 -> 420;
                        case 2 -> 690;
                        default -> 0;
                    } : 0);
                }
                if (entity instanceof Player player) {
                    yassification(ent, world, player);
                    if (ent instanceof Cat cat && player.getRandom().nextInt(0, 25) < 4) {
                        cat.spawnAtLocation(ModItems.POSEI.get());
                        PlayerMethods.addPlayerYassification(player, 1);
                    }
                    if (EntityMethods.isFlop(ent) || (ent instanceof AbstractTwink && type < 2)) {
                        EntityMethods.flopEffects(ent, amp,amp - 1);
                        if (player.getRandom().nextInt(0, 12) == 1) {
                            if (ent instanceof Twink && !PlayerMethods.isNewgen(player)) {
                                ent.spawnAtLocation(TwinkAI.randItem());
                                PlayerMethods.addPlayerYassification(player, 1);
                            }
                            if (ent instanceof AbstractFlopFigures || (ent instanceof Player surround && PlayerMethods.isFlopIcon(surround))) {
                                if (ent instanceof CupcakKe cupcakke) {
                                    CupcakKe.cupcakkeDuplication(ModItems.CVM.get(), cupcakke);
                                }
                                PlayerMethods.addPlayerYassification(player, 7 * ((int)chargedTime / 2));
                            }
                        }
                    } else if (type > 1) {
                        EntityMethods.monsterEffects(ent);
                    }
                }
                if (type < 2) {
                    ent.addEffect(new MobEffectInstance(ModEffects.CVMMED.get(), 1000, amp));
                }
            }
        }
        if (world instanceof ServerLevel level) {
            level.sendParticles(switch (type) {
                        case 0 -> ParticleTypes.END_ROD;
                        case 1 -> ParticleTypes.LAVA;
                        case 2 -> ParticleTypes.DAMAGE_INDICATOR;
                        default -> ParticleTypes.POOF;
                    },
                    x, y, z, ((int) chargedTime * 15),1,1, 1, (chargedTime * 0.16));
        }
    }


    public static void mariahCvmreyShoot(LevelAccessor world, double x, double y, double z, float velocity) {
        {
            final Vec3 center = new Vec3(x, y, z);
            List<LivingEntity> entities = world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(2 * velocity / 2d), e -> true).stream().toList();
            for (LivingEntity ent : entities) {
                EntityMethods.addEffects(ent, (int)velocity * 20, (int)velocity);
            }
        }
        if (world instanceof ServerLevel level) {
            level.sendParticles(ParticleTypes.COMPOSTER,
                    x, y, z, ((int) velocity * 15),1,1, 1, (velocity * 0.16));
            level.sendParticles(ParticleTypes.CRIMSON_SPORE,
                    x, y, z, ((int) velocity * 15),1,1, 1, (velocity * 0.16));
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
    public static void makeGirlYessBook(BlockPos pPos, Level pLevel) {
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        Player player = null;
        {
            final Vec3 center = new Vec3(x, y, z);
            List<Entity> entities = pLevel.getEntitiesOfClass(Entity.class, new AABB(center, center).inflate(8 / 2d), e -> true).stream()
                    .sorted(Comparator.comparingDouble(entity -> entity.distanceToSqr(center))).toList();
            for (Entity ent : entities) {
                if (ent instanceof Player otherPlayer) {
                    player = otherPlayer;
                    break;
                }
            }
            for (Entity entity : entities) {
                if (entity instanceof LivingEntity living) {
                    ToolMethods.yassification(living, pLevel, player);
                    if (EntityMethods.isMonster(living)) {
                        EntityMethods.monsterEffects(living);
                    }
                    if (EntityMethods.isFlop(living)) {
                        EntityMethods.flopEffects(living);
                    }
                }
            }
        }

        pLevel.destroyBlock(pPos, false);
        pLevel.playSound(player, pPos, ModSounds.SQUIRT.get(), SoundSource.BLOCKS);
        pLevel.playSound(player, pPos, SoundEvents.GENERIC_EXPLODE, SoundSource.BLOCKS);
        ItemStack book = new ItemStack(Items.WRITTEN_BOOK);
        CompoundTag tag = book.getOrCreateTag();
        int value = new Random().nextInt(8) + 1; // this will increase as more girl yess comments are made
        ListTag pages = new ListTag();
        pages.addTag(0, StringTag.valueOf("\"" + ModUtil. getGirlYessComment(value).getString() + "\""));
        tag.putString("author", ModUtil.getGirlYessCommentAuthor(value).getString());
        tag.putString("title", Component.translatable("subtitle.girl_yas_book_title")
                .append(" #" + value).getString());
        tag.put("pages", pages);
        book.setTag(tag);
        pLevel.explode(null, pPos.getX(), pPos.getY(), pPos.getZ(), 2, Level.ExplosionInteraction.BLOCK);
        pLevel.addFreshEntity(new ItemEntity(pLevel, x, y, z, book));
    }
}
