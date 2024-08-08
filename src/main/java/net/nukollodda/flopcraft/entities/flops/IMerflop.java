package net.nukollodda.flopcraft.entities.flops;

import net.minecraft.world.damagesource.DamageSource;

public interface IMerflop {
    boolean hurt(DamageSource source, float amount);
}
