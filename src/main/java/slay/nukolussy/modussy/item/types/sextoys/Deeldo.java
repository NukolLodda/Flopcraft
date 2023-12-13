package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import slay.nukolussy.modussy.sound.ModSounds;

public class Deeldo extends AbstractDeeldo {
    public Deeldo() {
        super(6971);
    }
    @Override
    protected SimpleParticleType getCvmParticle() {
        return ParticleTypes.END_ROD;
    }

    @Override
    protected SimpleParticleType getCvmiumParticle() {
        return ParticleTypes.LAVA;
    }

    @Override
    protected SimpleParticleType getBloodClumpParticle() {
        return ParticleTypes.DAMAGE_INDICATOR;
    }

    @Override
    protected SimpleParticleType getRegularParticle() {
        return ParticleTypes.POOF;
    }

    @Override
    protected int secOnFire(int type, boolean flame) {
        return flame ? switch (type) {
            case 0 -> 100;
            case 1 -> 420;
            case 2 -> 690;
            default -> 0;
        } : 0;
    }

    @Override
    protected SoundEvent getSquirtSound() {
        return ModSounds.SQUIRT.get();
    }

    @Override
    protected int multiplier() {
        return 1;
    }
}
