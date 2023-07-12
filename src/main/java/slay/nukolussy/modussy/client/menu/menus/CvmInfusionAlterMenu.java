package slay.nukolussy.modussy.client.menu.menus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.block.entity.CvmInfusionAlterEntity;
import slay.nukolussy.modussy.client.menu.ModMenuTypes;

public class CvmInfusionAlterMenu extends AbstractContainerMenu {
    public final CvmInfusionAlterEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public CvmInfusionAlterMenu(int id, Inventory inv, FriendlyByteBuf xtraData) {
        this(id, inv, inv.player.level().getBlockEntity(xtraData.readBlockPos()), new SimpleContainerData(2));
        // SimpleContainerData's val must match with getCount() in CvmInfusionAlterEntity
    }

    public CvmInfusionAlterMenu(int id, Inventory inv, BlockEntity ent, ContainerData data) {
        super(ModMenuTypes.CVM_INFUSION_ALTER_MENU.get(), id);
        checkContainerSize(inv,9); // the second val is the inv size
        this.blockEntity = (CvmInfusionAlterEntity) ent;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
            this.addSlot(new SlotItemHandler(handler, 0, 15, 15));
            this.addSlot(new SlotItemHandler(handler, 1, 35, 15));
            this.addSlot(new SlotItemHandler(handler, 2, 55, 15));
            this.addSlot(new SlotItemHandler(handler, 3, 15, 33));
            this.addSlot(new SlotItemHandler(handler, 4, 35, 33));
            this.addSlot(new SlotItemHandler(handler, 5, 55, 33));
            this.addSlot(new SlotItemHandler(handler, 6, 35, 51));
            this.addSlot(new SlotItemHandler(handler, 7, 55, 51));
            this.addSlot(new SlotItemHandler(handler, 8, 135, 33));
        });

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    // shows arrow and progress
    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 26; // height in pixels of arrow

        return maxProgress != 0 && progress !=0 ? progress * progressArrowSize / maxProgress : 0;
    }

    /*
       thanks to diesieben07 or my life'd be a pain
       must assign a slot num to each of slots used by GUI
       for this container, both the tile inventory's slots and the player's inventory slots and the hotbar are visible.
       Each time we add a slot to the container, it auto increases slot Index meaning:
       0 - 9 hotbar slots (map to the InventoryPlayer slots num 0 - 8)
       9 - 35 player inventory slots (map to InventoryPlayer slot numbers 9 - 35)
       36 - 44 TileInventory slots maps to TileEntity slots numbers 0 - 8
     */

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INV_ROW_COUNT = 3;
    private static final int PLAYER_INV_COLUMN_COUNT = 9;
    private static final int PLAYER_INV_SLOT_COUNT = PLAYER_INV_COLUMN_COUNT * PLAYER_INV_ROW_COUNT; // equals 27
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INV_SLOT_COUNT; // equals 36
    private static final int VANILLA_FIRST_SLOT = 9;
    private static final int TE_INV_FIRST_SLOT = VANILLA_FIRST_SLOT + VANILLA_SLOT_COUNT; // equals 45


    // MUST BE DEFINED
    private static final int TE_INV_SLOT_COUNT = 8; // MUST BE NUMBER OF SLOTS YOU HAVE

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int ind) {
        Slot source = slots.get(ind);
        if (!source.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = source.getItem();
        ItemStack copyStack = sourceStack.copy();

        // check if the slot clicked is one of the vanilla container slots
        if (ind == 0) {
            // this is a vanilla container slot so merge the stack into the tile inventory
            if (!this.moveItemStackTo(copyStack, 10, 45, true)) {
                return ItemStack.EMPTY;
            }
        } else if (ind >= 10 && ind <= 45) {
            if (!this.moveItemStackTo(copyStack, 1, 9, false)) {
                if (ind < 37) {
                    if (!this.moveItemStackTo(copyStack, 37, 44, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(copyStack, 10, 37, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(copyStack, 10, 45, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex: " + ind);
            return ItemStack.EMPTY;
        }

        // if stack size is 0, set slot contents to null

        if (copyStack.isEmpty()) {
            source.set(ItemStack.EMPTY);
        } else {
            source.setChanged();
        }

        if (copyStack.getCount() == sourceStack.getCount()) {
            return ItemStack.EMPTY;
        }

        source.onTake(player, copyStack);
        if (ind == 0) {
            player.drop(copyStack, false);
        }
        return ItemStack.EMPTY;
        // placeholder code
    }

    @Override // checks if the block cna be opened
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.CVM_INFUSION_ALTER.get());
    }

    // the private methods below adds slots to players inventory
    // the for loops help with positioning

    private void addPlayerInventory(Inventory playerInv) {
        for (int i = 0; i < 3; i++) {
            for (int l = 0; l < 9; l++) {
                this.addSlot(new Slot(playerInv, l + i * 9 + 9, 8 + l * 18, 86 + i * 18));
            }
        }
    }
    private void addPlayerHotbar(Inventory playerInv) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 144));
        }
    }
}
