package slay.nukolussy.modussy.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.item.ToolsTag;
import slay.nukolussy.modussy.procedures.SlayAttack;
import slay.nukolussy.modussy.procedures.SlayBreak;
import slay.nukolussy.modussy.tabs.ModCreativeTabs;

import java.util.Set;


public class Pickaxol extends DiggerItem {
    private final int lvl;
    public static final Set<ToolAction> DEFAULT_PICKAXOL_ACTIONS = Set.of(
        ToolActions.PICKAXE_DIG, ToolActions.AXE_DIG, ToolActions.SHOVEL_DIG,
        ToolActions.AXE_STRIP, ToolActions.AXE_SCRAPE, ToolActions.AXE_WAX_OFF, ToolActions.SHOVEL_FLATTEN
    );

    public Pickaxol(Tier tier, int atkbase, float speed, Rarity rare) {
        super((float) atkbase, speed, tier, ToolsTag.MINEABLE_WITH_PICKAXOL,
                new Item.Properties().tab(ModCreativeTabs.SLAY_TOOLS).fireResistant()
                        .durability(tier.getLevel() * 6900).rarity(rare));
        this.lvl = tier.getLevel() - 2;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(stack, world, state, pos, entity);
        SlayBreak.execute(world, pos.getX(), pos.getY(), pos.getZ(), state, pos, entity);
        return retval;
    }

    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        BlockState result = useAsAxe(state, context);
        if (result == null) {
            if (context.getClickedFace() == Direction.DOWN) {
                return InteractionResult.PASS;
            }
            BlockState found = state.getToolModifiedState(context, ToolActions.SHOVEL_FLATTEN, false);
            if (found != null && world.isEmptyBlock(pos.above())) {
                world.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0f, 1.0f);
                result = found;
            } else if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
                if (!world.isClientSide) {
                    world.levelEvent(null, LevelEvent.SOUND_EXTINGUISH_FIRE, pos, 0);
                }
                CampfireBlock.dowse(player, world, pos, state);
                result = state.setValue(CampfireBlock.LIT, false);
            }

            if (result == null) {
                return InteractionResult.PASS;
            }
        }

        if (!world.isClientSide) {
            ItemStack stack = context.getItemInHand();
            if (player instanceof ServerPlayer serverplyr) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverplyr, pos,stack);
            }
            world.setBlock(pos, result, Block.UPDATE_ALL_IMMEDIATE);
            if (player != null) {
                stack.hurtAndBreak(1, player, onBroken -> onBroken.broadcastBreakEvent(context.getHand()));
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }

    @Nullable
    private BlockState useAsAxe(BlockState state, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState result = state.getToolModifiedState(context, ToolActions.AXE_STRIP, false);
        if (result != null) {
            world.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            return result;
        }
        result = state.getToolModifiedState(context, ToolActions.AXE_STRIP, false);
        if (result != null) {
            world.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0f, 1.0f);
            world.levelEvent(player, LevelEvent.PARTICLES_SCRAPE, pos, 0);
            return result;
        }
        result = state.getToolModifiedState(context, ToolActions.AXE_WAX_OFF, false);
        if (result != null) {
            world.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0f, 1.0f);
            world.levelEvent(player, LevelEvent.PARTICLES_WAX_OFF, pos, 0);
            return result;
        }
        return null;
    }

    @org.jetbrains.annotations.Nullable
    public static BlockState getAxeStrippingState(BlockState orgState) {
        return AxeItem.getAxeStrippingState(orgState);
    }

    @org.jetbrains.annotations.Nullable
    public static BlockState getShovelPathingState(BlockState orgState) {
        return ShovelItem.getShovelPathingState(orgState);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        SlayAttack.execute(itemStack, sourceentity, entity, this.lvl);
        return true;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction action) {
        return Pickaxol.DEFAULT_PICKAXOL_ACTIONS.contains(action);
    }
}
