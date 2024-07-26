package slay.nukolussy.modussy.entities.flops.figures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.entities.projectiles.Kamaloconut;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Random;

public class KamalaHarris extends AbstractFlopFigures implements RangedAttackMob {
    private boolean summoned = false;

    public KamalaHarris(EntityType<KamalaHarris> type, Level world) {
        super(type, world);
    }

    public KamalaHarris(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 40);
        builder = builder.add(Attributes.ARMOR, 10);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
        builder = builder.add(Attributes.FOLLOW_RANGE, 10);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);

        return builder;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.0, 40, 20.0f));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 5.0f));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this,1));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new FloatGoal(this));
        this.goalSelector.addGoal(7, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(8, new OpenDoorGoal(this, true));
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        if (summoned) {
            return SoundEvents.EMPTY;
        }
        return switch (getRandom().nextInt(3)) {
            case 1 -> ModSounds.KAMALA_HARRIS_HURT1.get();
            case 2 -> ModSounds.KAMALA_HARRIS_HURT2.get();
            default -> ModSounds.KAMALA_HARRIS_HURT3.get();
        };
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.KAMALA_HARRIS_DEATH.get();
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        if (summoned) {
            return SoundEvents.EMPTY;
        }
        return switch (getRandom().nextInt(7)) {
            case 1 -> ModSounds.KAMALA_HARRIS_1.get();
            case 2 -> ModSounds.KAMALA_HARRIS_2.get();
            case 3 -> ModSounds.KAMALA_HARRIS_3.get();
            case 4 -> ModSounds.KAMALA_HARRIS_4.get();
            case 5 -> ModSounds.KAMALA_HARRIS_5.get();
            case 6 -> ModSounds.KAMALA_HARRIS_6.get();
            default -> ModSounds.KAMALA_HARRIS_7.get();
        };
    }

    public void setSummoning() {
        this.summoned = true;
        summonParticles();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    public static void init() {
    }

    private void summonParticles() {
        double x = getX();
        double y = getY();
        double z = getZ();
        Level world = Minecraft.getInstance().level;
        if (world != null) {
            int partCnt = tickCount >= 20 ? 18 : 36;
            for (int i = 0; i < partCnt; i++) {
                Random random = new Random();
                double x0 = x + 2 * (random.nextFloat() - 0.5);
                double y0 = y + 2 * random.nextFloat();
                double z0 = z + 2 * (random.nextFloat() - 0.5);
                double dx = (random.nextFloat() - 0.5) * 0.5;
                double dy = (random.nextFloat() - 0.5) * 0.5;
                double dz = (random.nextFloat() - 0.5) * 0.5;
                ParticleOptions option = tickCount >= 20 ? switch (random.nextInt(3)) {
                    case 1 -> ParticleTypes.HAPPY_VILLAGER;
                    case 2 -> ParticleTypes.POOF;
                    default -> ParticleTypes.LARGE_SMOKE;
                } : ParticleTypes.CLOUD;
                world.addParticle(option, x0, y0, z0, dx, dy, dz);
            }
        }
    }

    @Override
    public void aiStep() {
        if (this.summoned) {
            if (tickCount < 180) {
                summonParticles();
            }
            if (tickCount >= 340) {
                this.summoned = false;
            }
        }
        super.aiStep();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.performRangedAttack(pTarget.getX(), pTarget.getY() + (double)pTarget.getEyeHeight() * 0.5, pTarget.getZ());
    }

    private void performRangedAttack(double x, double y, double z) {
        if (!this.isSilent()) {
            this.level().levelEvent((Player)null, 1024, this.blockPosition(), 0);
        }
        double x0 = this.getX();
        double y0 = this.getY() + 1;
        double z0 = this.getZ();
        double x1 = x - x0;
        double y1 = y - y0;
        double z1 = z - z0;
        Kamaloconut kamaloconut = new Kamaloconut(this.level(), this, x1, y1, z1);
        kamaloconut.setOwner(this);
        kamaloconut.setPos(x0, y0, z0);
        this.level().addFreshEntity(kamaloconut);
    }
}
