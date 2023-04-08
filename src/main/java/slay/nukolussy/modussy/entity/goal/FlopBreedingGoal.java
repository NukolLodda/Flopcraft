package slay.nukolussy.modussy.entity.goal;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entity.custom.Flops;
import slay.nukolussy.modussy.entity.custom.Jiafei;
import slay.nukolussy.modussy.entity.custom.twink.Twink;
import slay.nukolussy.modussy.item.ModItem;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class FlopBreedingGoal extends Goal {
    private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
    protected final Flops flops;
    private final Class<? extends Flops> partnerClass;
    protected final Level level;
    @Nullable
    protected Flops partner;
    private int loveTime;
    private final double speedModifier;
    
    
    public FlopBreedingGoal(Flops flops, double speed) {
        this(flops, speed, flops.getClass());
    }

    public FlopBreedingGoal(Flops flops, double speed, Class<? extends Flops> aClass) {
        this.flops = flops;
        this.level = flops.level;
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
        return this.partner.isAlive() && this.partner.isInLove() && this.loveTime < 60;
    }

    public void stop() {
        this.partner = null;
        this.loveTime = 0;
    }

    public void tick() {
        this.flops.getLookControl().setLookAt(this.partner, 10.0F, (float)this.flops.getMaxHeadXRot());
        this.flops.getNavigation().moveTo(this.partner, this.speedModifier);
        ++this.loveTime;
        if (this.loveTime >= this.adjustedTickDelay(60) && this.flops.distanceToSqr(this.partner) < 9.0D) {
            this.breed();
        }
    }

    @Nullable
    private Flops getFreePartner() {
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
        Random rand = new Random();
        int will = rand.nextInt(0, 66);
        if (will == 65) {
            if (flop instanceof Twink) {
                flop.spawnAtLocation(ModItem.TWINK_EGG.get());
            } else if (flop instanceof Jiafei) {
                flop.spawnAtLocation(ModItem.JIAFEI_SEED.get());
            }

        }
    }
}
