package slay.nukolussy.modussy.client.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.block.entity.ent.CvmInfusionAlterEntity;

public class CvmInfusionAlterMenu extends AbstractContainerMenu {
    public final CvmInfusionAlterEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public CvmInfusionAlterMenu(int id, Inventory inv, FriendlyByteBuf xtraData) {
        this(id, inv, inv.player.level().getBlockEntity(xtraData.readBlockPos()), new SimpleContainerData(9));
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
            this.addSlot(new SlotItemHandler(handler, 0, 66, 53));
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    this.addSlot(new SlotItemHandler(handler, (i * 3) + j + 1, 30 + (j * 18), 17 + (i * 18)));
                }
            }
            this.addSlot(new SlotItemHandler(handler, 7, 48, 53));
            this.addSlot(new SlotItemHandler(handler, 8, 124, 35));
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

    public int getCvmAmount() {
        int cvmAmt = this.data.get(2);
        int maxCvm = this.data.get(3);
        int cvmTube = 18;

        return maxCvm != 0 && cvmAmt != 0 ? cvmAmt * cvmTube / maxCvm : 0;
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots and the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 8;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {

            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {

            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
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
                this.addSlot(new Slot(playerInv, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }
    private void addPlayerHotbar(Inventory playerInv) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 142));
        }
    }
}
