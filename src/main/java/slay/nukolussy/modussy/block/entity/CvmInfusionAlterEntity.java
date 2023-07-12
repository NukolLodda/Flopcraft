package slay.nukolussy.modussy.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.client.menu.menus.CvmInfusionAlterMenu;
import slay.nukolussy.modussy.recipes.CvmInfusionAlterRecipe;

import java.util.Optional;

public class CvmInfusionAlterEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler handler = new ItemStackHandler(9) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data;
    /*
    needed for the 4 parts of blockentity, sent via this instance variable
    data is sent to the menu which is used for synchronizing data to the client
    needs to be places in the container data which gets automatically synchronized
    */

    private int progress = 0;
    private int maxProgress = 78;

    private int cvmAmt = 0;
    private int maxCvm = 690;

    public CvmInfusionAlterEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CVM_INFUSION_ALTER.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int ind) {
                return switch (ind) {
                    case 0 -> CvmInfusionAlterEntity.this.progress;
                    case 1 -> CvmInfusionAlterEntity.this.maxProgress;
                    case 2 -> CvmInfusionAlterEntity.this.cvmAmt;
                    case 3 -> CvmInfusionAlterEntity.this.maxCvm;
                    default -> 0;
                };
            }

            @Override
            public void set(int ind, int val) {
                switch (ind) {
                    case 0 -> CvmInfusionAlterEntity.this.progress = val;
                    case 1 -> CvmInfusionAlterEntity.this.maxProgress = val;
                    case 2 -> CvmInfusionAlterEntity.this.cvmAmt = val;
                    case 3 -> CvmInfusionAlterEntity.this.maxCvm = val;
                }

            }

            @Override
            public int getCount() {
                return 4;
            } // must match with the constructor
        };
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("block.modussy.cvm_infusion_alter");
    }

    @Nullable
    @Override // generates the menu
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CvmInfusionAlterMenu(id, inv,this, this.data);
    }

    //don't use any deprecated methods for Tekora

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> handler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", handler.serializeNBT());

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        handler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() { // applies for if a block gets destroyed
        SimpleContainer inv = new SimpleContainer(handler.getSlots());
        for (int i = 0; i < handler.getSlots(); i++) {
            inv.setItem(i, handler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    // called every tick
    public static void tick(Level lvl, BlockPos pos, BlockState state, CvmInfusionAlterEntity ent) {
        if (lvl.isClientSide()) {
            return;
        }

        if (hasRecipe(ent)) { // if the block has a crafting recipe in it
            ent.progress++;
            setChanged(lvl, pos, state); // things get reloaded if needed everytime progress is added

            if (ent.progress >= ent.maxProgress) {
                craftItem(ent);
            }
        } else {
            ent.resetProgress();
            setChanged(lvl, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(CvmInfusionAlterEntity ent) {
        Level lvl = ent.level;
        SimpleContainer inv = new SimpleContainer(ent.handler.getSlots());
        for (int i = 0; i < ent.handler.getSlots(); i++) {
            inv.setItem(i, ent.handler.getStackInSlot(i));
        }

        Optional<CvmInfusionAlterRecipe> recipe = lvl.getRecipeManager()
                .getRecipeFor(CvmInfusionAlterRecipe.Type.INSTANCE, inv, lvl);

        if (hasRecipe(ent)) {
            for (int j = 0; j < 6; j++)
                ent.handler.extractItem(j, 1, false);
            ent.handler.setStackInSlot(8, new ItemStack(recipe.get().getResultItem(lvl.registryAccess()).getItem(),
                    ent.handler.getStackInSlot(8).getCount() + 1));
            ent.resetProgress();
        }
    }

    private static boolean hasRecipe(CvmInfusionAlterEntity ent) {
        // creates an inventory of sorts
        Level lvl = ent.level;
        SimpleContainer inv = new SimpleContainer(ent.handler.getSlots());
        for (int i = 0; i < ent.handler.getSlots(); i++) {
            inv.setItem(i, ent.handler.getStackInSlot(i));
        }

        Optional<CvmInfusionAlterRecipe> recipe = lvl.getRecipeManager()
                .getRecipeFor(CvmInfusionAlterRecipe.Type.INSTANCE, inv, lvl);

        return recipe.isPresent() && canInsertAmtIntoOutput(inv) &&
                canInsertItemIntoOutput(inv, recipe.get().getResultItem(lvl.registryAccess()));
    }

    private static boolean canInsertItemIntoOutput(SimpleContainer inv, ItemStack stack) {
        return inv.getItem(8).getItem() == stack.getItem() || inv.getItem(8).isEmpty();
    }

    private static boolean canInsertAmtIntoOutput(SimpleContainer inv) {
        // checks whether the output has enough space
        return inv.getItem(8).getMaxStackSize() > inv.getItem(8).getCount();
        // ensures only 64 items can be inserted
    }

}
