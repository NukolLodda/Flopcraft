package slay.nukolussy.modussy.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.entity.custom.Flops;
import slay.nukolussy.modussy.entity.custom.Jiafei;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSoundTypes;

import java.util.Collections;
import java.util.List;

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
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak()
                .sound(ModSoundTypes.JIAFEI_CROP));
    }

    protected ItemLike getBaseSeedId() {
        return ModItem.JIAFEI_SEED.get();
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
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(Blocks.DIAMOND_ORE));
    }

    @Override
    public void entityInside(BlockState state, Level lvl, BlockPos pos, Entity ent) {
        if ((ent instanceof Player || ent instanceof Flops) && this.isMaxAge(state)) {
            Mob newMob = new Jiafei(ModEntities.JIAFEI.get(), ent.level);
            newMob.moveTo(pos.getX(), pos.getY(), pos.getZ());
            ent.level.addFreshEntity(newMob);
            lvl.destroyBlock(pos, true, ent);
        }
    }
}
