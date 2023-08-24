package slay.nukolussy.modussy.block.entity.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.item.types.FloptropicaTicket;
import slay.nukolussy.modussy.util.PlayerMethods;

public class FlopAirlineTicketScanner extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public FlopAirlineTicketScanner() {
        super(Properties.copy(Blocks.QUARTZ_BLOCK));
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public @NotNull BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    /*for the block entity stuff*/
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
        // ensures the block is visible
    }

    private boolean hasPortalSide(Level pLevel, int x, int y, int z, Direction pDir) {
        switch (pDir) {
            case EAST -> x++;
            case WEST -> x--;
            case SOUTH -> z++;
            case NORTH -> z--;
        }
        for (int i = -1; i < 2; i++) {
            if (pLevel.getBlockState(new BlockPos(x, y+i, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get())) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPortalTop(Level pLevel, BlockPos pPos, Direction pDir) {
        int x = pPos.getX();
        int y = pPos.getY()+2;
        int z = pPos.getZ();

        if (pDir == Direction.EAST) {
            return pLevel.getBlockState(new BlockPos(x+1, y, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get()) &&
                    pLevel.getBlockState(new BlockPos(x+2, y, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get());
        } else if (pDir == Direction.WEST) {
            return pLevel.getBlockState(new BlockPos(x-1, y, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get()) &&
                    pLevel.getBlockState(new BlockPos(x-2, y, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get());
        } else if (pDir == Direction.SOUTH) {
            return pLevel.getBlockState(new BlockPos(x, y, z+1)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get()) &&
                    pLevel.getBlockState(new BlockPos(x, y, z+2)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get());
        } else if (pDir == Direction.NORTH) {
            return pLevel.getBlockState(new BlockPos(x, y, z-1)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get()) &&
                    pLevel.getBlockState(new BlockPos(x, y, z-2)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get());
        }
        return false;
    }

    private boolean hasPortalBottom(Level pLevel, BlockPos pPos, Direction pDir) {
        int x = pPos.getX();
        int y = pPos.getY()-2;
        int z = pPos.getZ();

        if (pDir == Direction.EAST) {
            return pLevel.getBlockState(new BlockPos(x+1, y, z)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get()) &&
                    pLevel.getBlockState(new BlockPos(x+2, y, z)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get());
        } else if (pDir == Direction.WEST) {
            return pLevel.getBlockState(new BlockPos(x-1, y, z)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get()) &&
                    pLevel.getBlockState(new BlockPos(x-2, y, z)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get());
        } else if (pDir == Direction.SOUTH) {
            return pLevel.getBlockState(new BlockPos(x, y, z+1)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get()) &&
                    pLevel.getBlockState(new BlockPos(x, y, z+2)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get());
        } else if (pDir == Direction.NORTH) {
            return pLevel.getBlockState(new BlockPos(x, y, z-1)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get()) &&
                    pLevel.getBlockState(new BlockPos(x, y, z-2)).getBlock().equals(ModBlocks.BARBIE_LANTERN.get());
        }
        return false;
    }

    private boolean hasPortalToDirection(Level pLevel, BlockPos pPos, Direction pDir) {
        return hasPortalTop(pLevel, pPos, pDir) && hasPortalSide(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), pDir) &&
                hasPortalBottom(pLevel, pPos, pDir);
    }

    private boolean hasPortalAroundScanner(Level pLevel, BlockPos pPos, BlockState pState) {
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        if (pLevel.getBlockState(new BlockPos(x, y-1, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get()) &&
                pLevel.getBlockState(new BlockPos(x, y+1, z)).getBlock().equals(ModBlocks.FLOP_AIRLINE_BLOCK.get())) {
            if (pLevel instanceof ServerLevel server) {
                if (this.getBedDirection(pState, server, pPos) == Direction.NORTH ||
                        this.getBedDirection(pState, server, pPos) == Direction.SOUTH) {
                    return hasPortalToDirection(pLevel, pPos, Direction.EAST) ||
                            hasPortalToDirection(pLevel, pPos, Direction.WEST);
                } else if (this.getBedDirection(pState, server, pPos) == Direction.EAST ||
                        this.getBedDirection(pState, server, pPos) == Direction.WEST) {
                    return hasPortalToDirection(pLevel, pPos, Direction.NORTH) ||
                            hasPortalToDirection(pLevel, pPos, Direction.SOUTH);
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        Item item = pPlayer.getItemInHand(pHand).getItem();
        if (item instanceof FloptropicaTicket) {
            pPlayer.sendSystemMessage(Component.translatable("subtitle.valid_ticket"));
        } else {
            pPlayer.sendSystemMessage(Component.translatable("subtitle.invalid_ticket"));
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
