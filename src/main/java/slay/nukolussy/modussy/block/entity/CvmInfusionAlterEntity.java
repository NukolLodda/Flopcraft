package slay.nukolussy.modussy.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
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
import slay.nukolussy.modussy.client.menu.CvmInfusionAlterMenu;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.recipes.CvmInfusionAlterRecipe;
import slay.nukolussy.modussy.recipes.CvmInfusionAlterShapelessRecipe;
import slay.nukolussy.modussy.sound.ModSounds;

import javax.swing.text.html.Option;
import java.util.Optional;

public class CvmInfusionAlterEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler handler = new ItemStackHandler(9) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.is(ModItem.CVM.get()) || stack.is(ModItem.CVMIUM.get());
                case 8 -> false;
                default -> true;
            };
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
            }
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
        nbt.putInt("cvm_amt", this.cvmAmt);
        nbt.putInt("progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);

        handler.deserializeNBT(nbt.getCompound("inventory"));

        this.cvmAmt = nbt.getInt("cvm_amt");
        this.progress = nbt.getInt("progress");
    }

    public void drops() { // applies for if a block gets destroyed
        SimpleContainer inv = new SimpleContainer(handler.getSlots());
        for (int i = 0; i < handler.getSlots(); i++) {
            inv.setItem(i, handler.getStackInSlot(i));
        }

        if (this.level != null)
            Containers.dropContents(this.level, this.worldPosition, inv);
    }

    // called every tick
    public static void tick(Level lvl, BlockPos pos, BlockState state, CvmInfusionAlterEntity ent) {
        if (lvl.isClientSide()) {
            return;
        }

        ItemStack itemFuel = new ItemStack(ent.handler.getStackInSlot(0).getItem());

        if (itemFuel.is(ModItem.CVM.get()) || itemFuel.is(ModItem.CVMIUM.get())) {
            int addedAmt = itemFuel.is(ModItem.CVMIUM.get()) ? 69 : 30;
            if (addedAmt + ent.cvmAmt <= ent.maxCvm) {
                ent.cvmAmt += addedAmt;
                ent.handler.extractItem(0, 1,false);
            }
        }

        if (hasRecipe(ent) || hasShapelessRecipe(ent)) { // if the block has a crafting recipe in it
            if (ent.cvmAmt > 0) {
                ent.progress++;
                if (ent.progress % 6 == 0) ent.cvmAmt--;
            }
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
        for (int i = 1; i < ent.handler.getSlots(); i++) {
            inv.setItem(i, ent.handler.getStackInSlot(i));
        }

        Optional<CvmInfusionAlterRecipe> shapedRecipe = lvl.getRecipeManager()
                .getRecipeFor(CvmInfusionAlterRecipe.Type.INSTANCE, inv, lvl);

        Optional<CvmInfusionAlterShapelessRecipe> shapelessRecipe = lvl.getRecipeManager()
                .getRecipeFor(CvmInfusionAlterShapelessRecipe.Type.INSTANCE, inv, lvl);

        if (hasRecipe(ent)) {
            for (int j = 1; j < 8; j++) {
                if (!ent.handler.getStackInSlot(j).isEmpty()) ent.handler.extractItem(j, 1, false);
            }
            ent.handler.setStackInSlot(8,
                    new ItemStack(shapedRecipe.get().getResultItem(lvl.registryAccess()).getItem(),
                            ent.handler.getStackInSlot(8).getCount() + 1));
            ent.resetProgress();
        } else if (hasShapelessRecipe(ent)) {
            for (int j = 1; j < 8; j++) {
                if (!ent.handler.getStackInSlot(j).isEmpty()) ent.handler.extractItem(j, 1, false);
            }
            ent.handler.setStackInSlot(8,
                    new ItemStack(shapelessRecipe.get().getResultItem(lvl.registryAccess()).getItem(),
                            ent.handler.getStackInSlot(8).getCount() + 1));
            ent.resetProgress();
        }
    }

    private static boolean hasRecipe(CvmInfusionAlterEntity ent) {
        // creates an inventory of sorts
        Level lvl = ent.level;
        SimpleContainer inv = new SimpleContainer(ent.handler.getSlots());
        for (int i = 1; i < 8; i++) {
            inv.setItem(i, ent.handler.getStackInSlot(i));
        }

        Optional<CvmInfusionAlterRecipe> recipe = lvl.getRecipeManager()
                .getRecipeFor(CvmInfusionAlterRecipe.Type.INSTANCE, inv, lvl);

        return recipe.isPresent() && canInsertAmtIntoOutput(inv) &&
                canInsertItemIntoOutput(inv, recipe.get().getResultItem(lvl.registryAccess()));
    }

    private static boolean hasShapelessRecipe(CvmInfusionAlterEntity ent) {
        Level lvl = ent.level;
        SimpleContainer inv = new SimpleContainer(ent.handler.getSlots());
        for (int i = 1; i < 8; i++) {
            inv.setItem(i, ent.handler.getStackInSlot(i));
        }

        Optional<CvmInfusionAlterShapelessRecipe> recipe = lvl.getRecipeManager()
                .getRecipeFor(CvmInfusionAlterShapelessRecipe.Type.INSTANCE, inv, lvl);

        return recipe.isPresent() && canInsertAmtIntoOutput(inv) &&
                canInsertItemIntoOutput(inv, recipe.get().getResultItem(lvl.registryAccess()));
    }

    private static boolean canInsertItemIntoOutput(SimpleContainer inv, ItemStack stack) {
        return inv.getItem(8).isEmpty() || inv.getItem(8).getItem() == stack.getItem();
    }

    private static boolean canInsertAmtIntoOutput(SimpleContainer inv) {
        // checks whether the output has enough space
        return inv.getItem(8).isEmpty() || inv.getItem(8).getMaxStackSize() > inv.getItem(8).getCount();
        // ensures only 64 items can be inserted
    }

}
