package slay.nukolussy.modussy.entities.goal;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.custom.Flops;
import slay.nukolussy.modussy.entities.custom.Jiafei;
import slay.nukolussy.modussy.entities.custom.twink.Twink;
import slay.nukolussy.modussy.item.ModItem;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class FlopBreedingGoal extends Goal {
    private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
    protected final Flops flops;
    private final Class<? extends Flops> partnerClass;
    protected final Level level;
    @Nullable
    protected Flops partner;
    private int loveTime;
    private final double speedModifier;
    private int itemSpawned;
    
    
    public FlopBreedingGoal(Flops flops, double speed) {
        this(flops, speed, flops.getClass());
    }

    public FlopBreedingGoal(Flops flops, double speed, Class<? extends Flops> aClass) {
        this.flops = flops;
        this.level = flops.level();
        this.partnerClass = aClass;
        this.speedModifier = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        if (!this.flops.isInLove()) {
            return false;
        } else {
            this.partner = this.getFreePartner();
            return this.partner != null;
        }
    }

    public boolean canContinueToUse() {
        if (this.partner != null)
            return this.partner.isAlive() && this.partner.isInLove() && this.loveTime < 60;
        return false;
    }

    public void stop() {
        this.partner = null;
        this.loveTime = 0;
        this.itemSpawned = 0;
    }

    public void tick() {
        if (this.partner != null) {
            this.flops.getLookControl().setLookAt(this.partner, 10.0f, (float) this.flops.getMaxHeadXRot());
            this.flops.getNavigation().moveTo(this.partner, this.speedModifier);
            ++this.loveTime;
            if (this.itemSpawned > 2) {
                this.stop();
            }
            if (this.loveTime >= this.adjustedTickDelay(60) && this.flops.distanceToSqr(this.partner) < 9.0) {
                this.breed();
            }
        }
    }

    @Nullable
    private Flops getFreePartner() {
        this.itemSpawned = 0;
        List<? extends Flops> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.flops, this.flops.getBoundingBox().inflate(8.0d));
        double max = Double.MAX_VALUE;
        Flops flops = null;

        for(Flops flop : list) {
            if (this.flops.canMate(flop) && this.flops.distanceToSqr(flop) < max) {
                flops = flop;
                max = this.flops.distanceToSqr(flop);
            }
        }

        return flops;
    }

    protected void breed() {
        Flops flop = this.flops;
        RandomSource random = RandomSource.create();
        double x = flop.getX();
        double y = flop.getY();
        double z = flop.getZ();
        for (int i = 0; i < 4; i++) {
            double x0 = x + random.nextFloat();
            double y0 = y + random.nextFloat();
            double z0 = z + random.nextFloat();
            double dx = (random.nextFloat() - 0.5) * 0.5;
            double dy = (random.nextFloat() - 0.5) * 0.5;
            double dz = (random.nextFloat() - 0.5) * 0.5;

            this.level.addParticle(ParticleTypes.HEART, x0, y0, z0, dx, dy, dz);
        }
        if (flop instanceof Twink) {
            flop.spawnAtLocation(ModItem.TWINK_EGG.get());
        } else if (flop instanceof Jiafei) {
            flop.spawnAtLocation(ModItem.JIAFEI_SEED.get());
        }
        this.itemSpawned++;
    }
}
