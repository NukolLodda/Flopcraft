package slay.nukolussy.modussy.network.period;

import net.minecraft.nbt.CompoundTag;

import java.util.Random;

public class PlayerMenstruation {
    private int phase = new Random().nextInt(8);

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
