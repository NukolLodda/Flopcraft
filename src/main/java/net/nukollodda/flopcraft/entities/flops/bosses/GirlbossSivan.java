package net.nukollodda.flopcraft.entities.flops.bosses;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.entities.FlopEntities;
import net.nukollodda.flopcraft.entities.twink.Twink;
import net.nukollodda.flopcraft.entities.twink.TwinkSivan;

public class GirlbossSivan extends TwinkSivan {
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(),
            BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public GirlbossSivan(PlayMessages.SpawnEntity packet, Level world) {
        super(FlopEntities.GIRLBOSS_SIVAN.get(), world);
    }
    public GirlbossSivan(EntityType<GirlbossSivan> type, Level world) {
        super(type, world);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2f);
        builder = builder.add(Attributes.MAX_HEALTH, 100);
        builder = builder.add(Attributes.ARMOR, 3);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 15);
        builder = builder.add(Attributes.FOLLOW_RANGE, 20);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);

        return builder;
    }

    public void startSeenByPlayer(ServerPlayer pPlayer) {
        super.startSeenByPlayer(pPlayer);
        if (getTarget() != null && getTarget().equals(pPlayer)) {
            this.bossEvent.addPlayer(pPlayer);
        }
    }
    public void stopSeenByPlayer(ServerPlayer pPlayer) {
        super.stopSeenByPlayer(pPlayer);
        if (this.bossEvent.getPlayers().contains(pPlayer)) {
            this.bossEvent.removePlayer(pPlayer);
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (getRandom().nextInt(169) == 0) {
            Twink twink = FlopEntities.TWINK.get().create(this.level());
            if (twink != null) {
                if (getTarget() != null) {
                    twink.setTarget(getTarget());
                }
                twink.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0f);
                twink.setRandomVariant();
                this.level().addFreshEntity(twink);
            }
        }
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance instance, @NotNull MobSpawnType type, SpawnGroupData data, CompoundTag tag) {
        return super.superFinalize(level, instance, type, data, tag);
    }
}
