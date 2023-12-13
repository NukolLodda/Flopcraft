package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class EnderDragonDeeldo extends AbstractDeeldo {
    public EnderDragonDeeldo() {
        super(7169);
    }

    @Override
    protected SimpleParticleType getCvmParticle() {
        return ParticleTypes.DRAGON_BREATH;
    }

    @Override
    protected SimpleParticleType getCvmiumParticle() {
        return ParticleTypes.CHERRY_LEAVES;
    }

    @Override
    protected SimpleParticleType getRegularParticle() {
        return ParticleTypes.ENCHANTED_HIT;
    }

    @Override
    protected SimpleParticleType getBloodClumpParticle() {
        return ParticleTypes.CRIMSON_SPORE;
    }

    @Override
    protected int secOnFire(int type, boolean flame) {
        return Math.round(switch (type) {
            case 0 -> 100;
            case 1 -> 420;
            case 2 -> 690;
            default -> 0;
        } * 1.5f);
    }

    @Override
    protected SoundEvent getSquirtSound() {
        return SoundEvents.ENDER_DRAGON_GROWL;
    }

    @Override
    protected int multiplier() {
        return 2;
    }
}
