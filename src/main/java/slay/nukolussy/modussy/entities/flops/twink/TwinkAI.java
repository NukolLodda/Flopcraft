package slay.nukolussy.modussy.entities.flops.twink;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.item.ModItem;

import java.util.*;

public class TwinkAI {
    public static final Item CUM = ModItem.CVM.get();

    public static ItemStack randItem() {
        Random obj = new Random();
        int randNum = obj.nextInt(1,100);
        if (randNum > 35) {
            if (randNum < 45) return new ItemStack(ModItem.SCARUSSY.get());
            else if (randNum < 60) return new ItemStack(ModItem.CUPCAKE.get());
            else if (randNum < 70) return new ItemStack(ModItem.POSEI.get());
            else if (randNum < 75) return new ItemStack(ModItem.SLAGINIUM.get());
            else if (randNum < 80) return new ItemStack(ModItem.SHENSEIUM.get());
            else if (randNum < 85) return new ItemStack(ModItem.CVMTITPLASM.get());
            else if (randNum < 90) return new ItemStack(ModItem.METRO.get());
            else if (randNum < 95) return new ItemStack(ModItem.JIAFEI_SEED.get());
            else if (randNum < 98) return new ItemStack(ModItem.INFUSED_SLAGINIUM.get());
            else return new ItemStack(ModItem.JIAFEI_PRODUCT.get());
        }
        else return new ItemStack(ModItem.HAIRUSSY.get());
    }

    private static final ItemStack[] twinkTrade = {
            new ItemStack(ModItem.SCARUSSY.get()),
            new ItemStack(ModItem.CUPCAKE.get()),
            new ItemStack(ModItem.POSEI.get()),
            new ItemStack(ModItem.SLAGINIUM.get()),
            new ItemStack(ModItem.SHENSEIUM.get()),
            new ItemStack(ModItem.CVMTITPLASM.get()),
            new ItemStack(ModItem.METRO.get()),
            new ItemStack(ModItem.INFUSED_SLAGINIUM.get()),
            new ItemStack(ModItem.JIAFEI_PRODUCT.get()),
            new ItemStack(ModItem.HAIRUSSY.get())
    };

    private static boolean isBarterCurrency(ItemStack item) {
        return item.is(CUM);
    }

    private static boolean seesPlayerHoldingWantedItem(Twink twink) {
        return twink.getBrain().hasMemoryValue(MemoryModuleType.NEAREST_PLAYER_HOLDING_WANTED_ITEM);
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
        throwItemsToDirection(twink, randItem(), getRandomNearbyPos(twink));
    }

    private static boolean admire(Twink twink) {
        return twink.getBrain().hasMemoryValue(MemoryModuleType.ADMIRING_ITEM);
    }

    private static void throwItems(Twink twink, ItemStack itemList) {
        Optional<Player> option = twink.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_PLAYER);
        Vec3 pos = option.map(Entity::position).orElseGet(() -> getRandomNearbyPos(twink));
        throwItemsToDirection(twink, itemList, pos);
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

        if (itemStack.is(CUM)) {
            holdInOffHand(twink, itemStack);
        } else {
            twink.equipItemIfPossible(itemStack);
            putInInventory(twink, itemStack);

        }
    }

    protected static void stopHoldingOffHandItem(Twink twink, boolean bool) {
        ItemStack item = twink.getItemInHand(InteractionHand.OFF_HAND);
        twink.setItemInHand(InteractionHand.OFF_HAND, ItemStack.EMPTY);
        boolean isTradeItem = false;
        ItemStack listOf;
        for (ItemStack posItem : twinkTrade) {
            isTradeItem = isTradeItem || item.is(posItem.getItem());
            if (item.is(posItem.getItem())) {
                listOf = posItem;
            }
        }
        boolean flag = item.is(CUM) || isTradeItem;
        if (bool && flag) {
            throwItems(twink, item);
        } else if (!flag) {
            twink.equipItemIfPossible(item);
            putInInventory(twink, item);
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
