package net.nukollodda.flopcraft.block.entity.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.block.entity.ent.BratBlockEntity;
import net.nukollodda.flopcraft.entities.flops.traders.CharliXCX;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.item.types.tools.Bratificationer;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.util.ModUtil;

public class BratBlock extends BaseEntityBlock {
    public BratBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    private boolean structureAlike(Level pLevel, BlockPos pPos) {
        BlockState belowState = pLevel.getBlockState(pPos.below());
        BlockEntity blockTwoBelow = pLevel.getBlockEntity(pPos.below().below());
        if (belowState.is(ModBlocks.KAMALOCONUT_PALM_LOG.get())
                && belowState.getValue(BlockStateProperties.AXIS).equals(Direction.Axis.Y)
                && blockTwoBelow instanceof JukeboxBlockEntity jukebox
                && jukebox.getItem(0).is(ModTags.Items.KAMALA_REMIXES)) {
            Block north = pLevel.getBlockState(pPos.north()).getBlock();
            Block south = pLevel.getBlockState(pPos.south()).getBlock();
            Block east = pLevel.getBlockState(pPos.east()).getBlock();
            Block west = pLevel.getBlockState(pPos.west()).getBlock();
            return ModUtil.itemsEqualsEachother(ModBlocks.KAMALOCONUT_PALM_LEAVES.get(), north, south, east, west);
        }
        return false;
    }

    @Override
    public InteractionResult use(BlockState state, Level lvl, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity ent = lvl.getBlockEntity(pos);
        if (ent instanceof BratBlockEntity bratBlock && player.getItemInHand(hand).is(FlopItems.KAMALOCONUT.get())
                         && structureAlike(lvl, pos)) {
            player.getItemInHand(hand).setCount(player.getItemInHand(hand).getCount() - 1);
            bratBlock.activate(lvl, player, pos);
        } else {
            ItemStack itemInHand = player.getItemInHand(hand);
            if (itemInHand.getItem() instanceof Bratificationer bratificationer
                    && ModUtil.getEntityListOfDist(lvl, CharliXCX.class, pos.getCenter(), 64).isEmpty()) {
                Vec3 cent = pos.getCenter();
                double x = cent.x;
                double y = cent.y;
                double z = cent.z;
                lvl.destroyBlock(pos, false, player);
                ModUtil.getEntityListOfDist(lvl, Player.class, cent, 10).forEach(plyer -> {
                    plyer.addEffect(new MobEffectInstance(ModEffects.BRATIFIED.get(), 500));
                });
                CharliXCX charli = new CharliXCX(ModEntities.CHARLI_XCX.get(), lvl);
                charli.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 120, 3));
                charli.moveTo(x, y + 3, z);
                charli.playSound(FlopSounds.CHARLI_XCX_SUMMON.get());
                lvl.addFreshEntity(charli);
                lvl.destroyBlock(pos, false, player);
                bratificationer.setDamage(itemInHand, 10);
            }
        }
        return super.use(state, lvl, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BratBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pType) {
        return createTickerHelper(pType, ModBlockEntities.BRAT_BLOCK.get(),
                (lvl, pos, state, entity) -> entity.tick(lvl, pos));
    }
}
