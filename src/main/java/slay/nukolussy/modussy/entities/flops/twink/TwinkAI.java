package slay.nukolussy.modussy.entities.flops.twink;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.item.ModItems;

import java.util.*;

public class TwinkAI {
    public static final Item CUM = ModItems.CVM.get();

    public static ItemStack randItem() {
        Random obj = new Random();
        int randNum = obj.nextInt(1,100);
        if (randNum > 35) {
            if (randNum < 45) return new ItemStack(ModItems.SCARUSSY.get());
            else if (randNum < 60) return new ItemStack(ModItems.CUPCAKE.get());
            else if (randNum < 70) return new ItemStack(ModItems.POSEI.get());
            else if (randNum < 75) return new ItemStack(ModItems.SLAGINIUM.get());
            else if (randNum < 80) return new ItemStack(ModItems.SHENSEIUM.get());
            else if (randNum < 85) return new ItemStack(ModItems.CVMTITPLASM.get());
            else if (randNum < 90) return new ItemStack(ModItems.DISC_RANVISION.get());
            else if (randNum < 95) return new ItemStack(ModItems.JIAFEI_SEED.get());
            else if (randNum < 98) return new ItemStack(ModItems.INFUSED_SLAGINIUM.get());
            else return new ItemStack(ModItems.JIAFEI_PRODUCT.get());
        }
        else return new ItemStack(ModItems.HAIRUSSY.get());
    }

    private static void stopWalking(Twink twink) {
        twink.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        twink.getNavigation().stop();
    }

    private static ItemStack removeOneItemFromItemEntity(ItemEntity item) {
        ItemStack itemStack = item.getItem();
        ItemStack splitItem = itemStack.split(1);
        if (itemStack.isEmpty()) item.discard();
        else item.setItem(itemStack);
        return splitItem;
    }

    private static void holdInOffHand(Twink twink, ItemStack item) {
        if (!twink.getOffhandItem().isEmpty()) {
            twink.spawnAtLocation(twink.getItemInHand(InteractionHand.OFF_HAND));
        }

        twink.holdInOffHand(item);
    }

    private static Vec3 getRandomNearbyPos(Twink twink) {
        Vec3 pos = LandRandomPos.getPos(twink, 4,2);
        return pos == null ? twink.position() : pos;
    }
    private static void putInInventory(Twink twink, ItemStack item) {
        twink.addToInventory(item);
    }

    private static boolean admire(Twink twink) {
        return twink.getBrain().hasMemoryValue(MemoryModuleType.ADMIRING_ITEM);
    }

    private static void throwItemsToDirection(Twink twink, ItemStack item, Vec3 pos) {
        if (!item.isEmpty()) {
            twink.swing(InteractionHand.OFF_HAND);
            BehaviorUtils.throwItem(twink, item, pos.add(0.0, 1.0, 0.0));
        }
    }

    private static boolean admireDisable(Twink twink) {
        return twink.getBrain().hasMemoryValue(MemoryModuleType.ADMIRING_DISABLED);
    }

    protected static void pickUpItem(Twink twink, ItemEntity item) {
        stopWalking(twink);
        ItemStack itemStack;
        if (item.getItem().is(CUM)) {
            twink.take(item, item.getItem().getCount());
            if (twink.getHealth() < twink.getMaxHealth()) {
                twink.heal(1.5f);
            }
            itemStack = randItem();
            item.discard();
        } else {
            twink.take(item, 1);
            itemStack = removeOneItemFromItemEntity(item);
        }

        boolean throwItems = true;
        if (item.getItem().is(CUM)) {
            throwItemsToDirection(twink, itemStack, getRandomNearbyPos(twink));
        } else {
            twink.equipItemIfPossible(itemStack);
            putInInventory(twink, itemStack);

        }
    }

    protected static boolean canAdmire(Twink twink, ItemStack item) {
        return !admireDisable(twink) && !admire(twink) && item.is(CUM);
    }

    public static InteractionResult mobInteract(Twink twink, Player player, InteractionHand hand) {
        ItemStack item = player.getItemInHand(hand);
        if (canAdmire(twink, item)) {
            ItemStack splitItem = item.split(1);
            holdInOffHand(twink, splitItem);
            admire(twink);
            stopWalking(twink);
            return InteractionResult.CONSUME;
        } else return InteractionResult.PASS;
    }
}
