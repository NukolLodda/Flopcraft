package slay.nukolussy.modussy.item.types.jiafei;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public interface IJiafeiProducts {
    String getEnding();

    default MutableComponent getDisplayName() {
        return Component.literal("来自嘉菲的产品，" + getEnding());
    }
}
