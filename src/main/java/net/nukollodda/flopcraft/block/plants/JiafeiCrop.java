package net.nukollodda.flopcraft.block.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import net.nukollodda.flopcraft.entities.FlopEntities;
import net.nukollodda.flopcraft.entities.flops.AbstractIcons;
import net.nukollodda.flopcraft.entities.flops.traders.Jiafei;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.sound.FlopSoundTypes;

public class JiafeiCrop extends CropBlock {

    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);
    private static final VoxelShape[] SHAPE_BY_AGE =
            new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
                    Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public JiafeiCrop() {
        super(Properties.ofFullCopy(Blocks.BEETROOTS).noCollission().randomTicks().instabreak()
                .sound(FlopSoundTypes.JIAFEI_CROP));
    }

    protected ItemLike getBaseSeedId() {
        return FlopItems.JIAFEI_SEED.get();
    }

    public int getAge(@NotNull BlockState state) {
        return super.getAge(state);
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 4;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public void entityInside(BlockState state, Level lvl, BlockPos pos, Entity ent) {
        if ((ent instanceof Player || ent instanceof AbstractIcons) && this.isMaxAge(state)) {
            Mob newMob = new Jiafei(FlopEntities.JIAFEI.get(), ent.level());
            newMob.moveTo(pos.getX(), pos.getY(), pos.getZ());
            ent.level().addFreshEntity(newMob);
            lvl.destroyBlock(pos, true, ent);
        }
    }
}
