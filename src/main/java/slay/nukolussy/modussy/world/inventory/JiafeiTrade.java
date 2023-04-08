package slay.nukolussy.modussy.world.inventory;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.menu.ModMenus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class JiafeiTrade extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
    public final static HashMap<String, Object> guistate = new HashMap<>();
    public final Level world;
    public final Player entity;
    public int x, y, z;
    private IItemHandler internal;
    private final Map<Integer, Slot> customSlots = new HashMap<>();
    private boolean bound = false;

    public JiafeiTrade(int id, Inventory inv, FriendlyByteBuf xtrdata) {
        super(ModMenus.JIAFEI_TRADE.get(), id);
        this.entity = inv.player;
        this.world = inv.player.level;
        this.internal = new ItemStackHandler(0);
        BlockPos pos = null;
        if (xtrdata != null) {
            pos = xtrdata.readBlockPos();
            this.x = pos.getX();
            this.y = pos.getY();
            this.z = pos.getZ();
        }
    }

    @Override
    public Map<Integer, Slot> get() {
        return null;
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public boolean stillValid(Player p_38874_) {
        return false;
    }
}
