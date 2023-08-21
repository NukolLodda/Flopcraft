package slay.nukolussy.modussy.network.period;

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

public class PlayerMenstruationProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    // makes a random number between 0 and 8 that determines which moon phase the player's period will happen in
    public static Capability<PlayerMenstruation> PLAYER_MENSTRUATION =
            CapabilityManager.get(new CapabilityToken<>() {
            });

    private PlayerMenstruation period = null;
    private final LazyOptional<PlayerMenstruation> optional = LazyOptional.of(this::createPlayerMenstruation);

    private PlayerMenstruation createPlayerMenstruation() {
        if (this.period == null) {
            this.period = new PlayerMenstruation();
        }

        return this.period;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_MENSTRUATION) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerMenstruation().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerMenstruation().loadNBTData(nbt);
    }
}
