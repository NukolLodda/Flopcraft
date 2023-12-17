package slay.nukolussy.modussy.entities.goal;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.AbstractModEntity;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class ModussyBreedingGoal extends Goal {
    private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0).ignoreLineOfSight();
    protected final AbstractModEntity entity;
    private final Class<? extends AbstractModEntity> partnerClass;
    protected final Level level;
    @Nullable
    protected AbstractModEntity partner;
    private int loveTime;
    private final double speedModifier;

    public ModussyBreedingGoal(AbstractModEntity entity, double speed) {
        this(entity, speed, entity.getClass());
    }

    public ModussyBreedingGoal(AbstractModEntity entity, double speed, Class<? extends AbstractModEntity> pClass) {
        this.entity = entity;
        this.level = entity.level();
        this.partnerClass = pClass;
        this.speedModifier = speed;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public boolean canUse() {
        if (!this.entity.isInLove()) {
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
        this.entity.getNavigation().stop();
        this.loveTime = 0;
        this.partner = null;
    }

    public void tick() {
        if (this.partner != null) {
            this.entity.getLookControl().setLookAt(this.partner, 10.0f, (float)this.entity.getMaxHeadXRot());
            this.entity.getNavigation().moveTo(this.partner, this.speedModifier);
            this.loveTime++;
            if (this.loveTime >= this.adjustedTickDelay(60) && this.entity.distanceToSqr(this.partner) < 9.0) {
                this.breed();
            }
        }
    }

    @Nullable
    private AbstractModEntity getFreePartner() {
        List<? extends AbstractModEntity> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING,
                this.entity, this.entity.getBoundingBox().inflate(8.0d));
        double max = 69710d;
        AbstractModEntity flops = null;

        for(AbstractModEntity flop : list) {
            if (this.entity.canMate(flop) && this.entity.distanceToSqr(flop) < max) {
                flops = flop;
                max = this.entity.distanceToSqr(flop);
            }
        }

        return flops;
    }

    protected void breed() {
        this.entity.onBreeding(this.level);
        this.stop();
    }
}
