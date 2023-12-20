package slay.nukolussy.modussy.util;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.block.plants.JiafeiCrop;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.flops.IFlopEntity;
import slay.nukolussy.modussy.entities.flops.traders.Jiafei;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.*;

public class ToolMethods {
    public static long getGameDayTick(ServerLevel level) {
        long time = level.getGameTime() / 24000L;
        if (level.getDayTime() > 6000) {
            time++;
        }
        return time * 24000L;
    }
    public static SoundEvent aestheticSounds(int up) {
        if (up > 8) up = 8;
        return switch (ModUtil.RANDOM.nextInt(1, up-1)) {
            case 1 -> ModSounds.AESTHETIC_1.get();
            case 2 -> ModSounds.AESTHETIC_2.get();
            case 3 -> ModSounds.AESTHETIC_3.get();
            case 4 -> ModSounds.AESTHETIC_4.get();
            case 5 -> ModSounds.AESTHETIC_5.get();
            case 6 -> ModSounds.AESTHETIC_SHENSEEA.get();
            default -> ModSounds.AESTHETIC_JIAFEI.get();
        };
    }

    public static ItemStack randItem(int up) {
        if (up > 3) up = 3;
        return switch (ModUtil.RANDOM.nextInt(up)) {
            case 1 -> new ItemStack(ModItems.SHENSEIUM.get());
            case 2 -> new ItemStack(ModItems.JIAFEI_PRODUCT.get());
            default -> new ItemStack(ModItems.CUPCAKE.get());
        };
    }

    public static void makeupUse(Entity entity, ItemStack item, int lvl) {
        if (entity instanceof LivingEntity living) {
            EntityMethods.addEffects(living, lvl, lvl / 2);
            item.setDamageValue(item.getDamageValue() + 1);
        }
    }

    public static void slayAttack(ItemStack item, Entity source, Entity target, int lvl) {
        int amp = (lvl + 1) / 2, itemDura = 0;
        if (EntityMethods.isFlop(source)) {
            ((LivingEntity) source).heal(3.0f);
        }
        if (source instanceof LivingEntity livingSource && target instanceof LivingEntity livingTarget) {
            yassifyEntity(source.level(), livingTarget, livingSource, lvl, amp);
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

    public static void yassifyIfPlayer(LivingEntity ent, LevelAccessor world, LivingEntity other) {
        if (other instanceof Player player) {
            yassification(ent, world, player);
        }
    }

    public static void makeGirlYessBook(BlockPos pPos, Level pLevel) {
        // don't move this method, will be used for the haunted house code.
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        Player player = null;

        final Vec3 center = new Vec3(x, y, z);
        List<LivingEntity> entities = ModUtil.getEntityListOfDist(pLevel, LivingEntity.class, pPos.getCenter(), 4);
        for (LivingEntity ent : entities) {
            if (ent instanceof Player otherPlayer) {
                player = otherPlayer;
                break;
            }
        }
        for (LivingEntity entity : entities) {
            ToolMethods.yassification(entity, pLevel, player);
            if (EntityMethods.isMonster(entity)) {
                EntityMethods.monsterEffects(entity);
            }
            if (EntityMethods.isFlop(entity)) {
                EntityMethods.flopEffects(entity);
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

    public static void yassifySurronding(Level pLevel, LivingEntity pSource, double pSize, int lvl, int amp) {
        ModUtil.getEntityListOfDist(pLevel, LivingEntity.class, pSource.position(), pSize)
                .forEach(ent -> yassifyEntity(pLevel, ent, pSource, lvl, amp));
    }

    public static void yassifyEntity(Level pLevel, LivingEntity pTarget, LivingEntity pSource, int lvl, int amp) {
        if (pTarget instanceof Spider spider) {
            spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
            spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
            PlayerMethods.addPlayerYassificationIfPossible(pSource, amp);
            spider.kill();
        }
        if (pTarget instanceof Slime slime) {
            ItemStack cvmItem = new ItemStack(slime instanceof MagmaCube ? ModItems.CVMIUM.get() : ModItems.CVM.get());
            slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
            slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
            PlayerMethods.addPlayerYassificationIfPossible(pSource, amp);
            slime.kill();
        }
        yassifyIfPlayer(pTarget, pLevel, pSource);
        if (pTarget instanceof Cat cat && cat.getRandom().nextInt(25) < 4) {
            cat.spawnAtLocation(ModItems.POSEI.get());
            PlayerMethods.addPlayerYassificationIfPossible(pSource, amp);
        }
        EntityMethods.addEffects(pTarget, lvl, amp);
    }
}
