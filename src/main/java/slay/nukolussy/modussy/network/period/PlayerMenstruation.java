package slay.nukolussy.modussy.network.period;

import net.minecraft.nbt.CompoundTag;

public class PlayerMenstruation {
    private int phase = (int)(Math.random() * 8);

    public int getPhase() {
        return phase;
    }

    public void copyFrom(PlayerMenstruation source) {
        this.phase = source.phase;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("phase", this.phase);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.phase = nbt.getInt("phase");
    }
}
