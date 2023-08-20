package slay.nukolussy.modussy.network.yassification;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerYassificationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerYassification> PLAYER_YASSIFICATION =
            CapabilityManager.get(new CapabilityToken<>() {
            });

    private PlayerYassification yassification = null;
    private final LazyOptional<PlayerYassification> optional = LazyOptional.of(this::createPlayerYassification);

    private PlayerYassification createPlayerYassification() {
        if (this.yassification == null) {
            this.yassification = new PlayerYassification();
        }

        return this.yassification;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_YASSIFICATION) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerYassification().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerYassification().loadNBTData(nbt);
    }
}
