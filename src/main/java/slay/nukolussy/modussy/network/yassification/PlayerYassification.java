package slay.nukolussy.modussy.network.yassification;

import net.minecraft.nbt.CompoundTag;

public class PlayerYassification {
    private int yassification;
    private final int MAX_YASSIFICATION = 6900;
    private final int FLOP_ICON = 4371; // makes it so flops will gravitate towards you to protect you for your gracious actions
    private final int MAGIC_FLOP = 1710; // makes it so flops give you effects when near you and vise versa
    private final int OFFICIAL_FLOP = 690; // makes it so flops will always be passive towards you
    private final int NEWGEN = -420; // makes it so Jiafei and Nicki Minaj won't trade with you
    private final int DABOYZ = -3142; // makes it so all flops will be automatically aggressive towards you
    private final int MIN_YASSIFICATION = -4200;

    public int getYassification() {
        return yassification;
    }

    public void addYassification(int add) {
        this.yassification = Math.min(this.yassification + Math.abs(add), MAX_YASSIFICATION);
    }

    public void subYassification(int sub) {
        this.yassification = Math.max(this.yassification - Math.abs(sub), MIN_YASSIFICATION);
    }

    public void setToFlop() {
        yassification = OFFICIAL_FLOP;
    }

    public void setToDaboyz() {
        yassification = DABOYZ;
    }

    public boolean wasDaboyz(int added) {
        return yassification - added < DABOYZ;
    }
    public boolean wasNewgen(int added) {
        return yassification - added < NEWGEN;
    }
    public boolean wasFlop(int added) {
        return yassification - added > OFFICIAL_FLOP;
    }
    public boolean wasMagicFlop(int added) {
        return yassification - added > MAGIC_FLOP;
    }
    public boolean wasFlopIcon(int added) {
        return yassification - added > FLOP_ICON;
    }

    public void copyFrom(PlayerYassification source) {
        this.yassification = source.yassification;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("yassification", this.yassification);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.yassification = nbt.getInt("yassification");
    }

    public boolean isFlopIcon() {
        return this.yassification > FLOP_ICON;
    }

    public boolean isMagicFlop() {
        return this.yassification > MAGIC_FLOP;
    }

    public boolean isFlop() {
        return this.yassification > OFFICIAL_FLOP;
    }

    public boolean isNewgen() {
        return this.yassification < NEWGEN;
    }

    public boolean isDaboyz() {
        return this.yassification < DABOYZ;
    }
}
