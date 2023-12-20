package slay.nukolussy.modussy.entities.flops.figures;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class LovelyPeaches extends AbstractFlopFigures {
    public LovelyPeaches(EntityType type, Level world) {
        super(type, world);
    }

    public LovelyPeaches(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public static void init() {
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    @Override
    protected void onDie(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            if (pSource.getEntity() instanceof Player player) {
                if (PlayerMethods.isNewgen(player)) {
                    alertFlops(player);
                } else {
                    int exRand = this.random.nextInt(12);
                    if (exRand == 1) {
                        int rand = this.random.nextInt(3);
                        Block block = switch (rand) {
                            case 1 -> ModBlocks.PEACHES_HEALTH.get();
                            case 2 -> ModBlocks.PEACHES_STRENGTH.get();
                            default -> ModBlocks.PEACHES_REMOVE.get();
                        };
                        this.level().setBlock(new BlockPos((int)this.getX(), (int)this.getY(), (int)this.getZ()),
                                block.defaultBlockState(), 3);
                    }
                }
            } else if (!(pSource.getEntity() instanceof LovelyPeaches)) {
                alertFlops(pSource.getEntity());
            }
        }
    }

    @Override
    protected void onHurt(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            if (pSource.getEntity() instanceof Player player) {
                if (!PlayerMethods.isFlop(player) && !PlayerMethods.isNewgen(player)) {
                    alertLovelyPeaches(player);
                } else {
                    super.onHurt(pSource);
                }
            } else if (!(pSource.getEntity() instanceof LovelyPeaches)){
                super.onHurt(pSource);
            }
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 1.2f);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 15);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0);

        return builder;
    }

    protected void alertLovelyPeaches(LivingEntity attacker) {
        List<LovelyPeaches> list = ModUtil.getEntityListOfDist(this.level(), LovelyPeaches.class, this.position(), 10);
        for (LovelyPeaches peaches : list) {
            if (attacker instanceof Player player && player.isCreative()) attacker = null;
            if (attacker != null) peaches.setTarget(attacker);

        }
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.random.nextBoolean() ? ModSounds.LOVELY_PEACHES_HURT1.get() : ModSounds.LOVELY_PEACHES_HURT2.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return this.random.nextBoolean() ? ModSounds.LOVELY_PEACHES_HURT1.get() : ModSounds.LOVELY_PEACHES_HURT2.get();
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        int rand = this.random.nextInt(7);
        return switch (rand) {
            case 1 -> ModSounds.LOVELY_PEACHES_1.get();
            case 2 -> ModSounds.LOVELY_PEACHES_2.get();
            case 3 -> ModSounds.LOVELY_PEACHES_3.get();
            case 4 -> ModSounds.LOVELY_PEACHES_4.get();
            case 5 -> ModSounds.LOVELY_PEACHES_5.get();
            case 6 -> ModSounds.LOVELY_PEACHES_6.get();
            default -> ModSounds.LOVELY_PEACHES_7.get();
        };
    }
}
