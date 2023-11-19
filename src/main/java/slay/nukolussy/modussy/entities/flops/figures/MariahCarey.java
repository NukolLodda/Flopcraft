package slay.nukolussy.modussy.entities.flops.figures;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;

public class MariahCarey extends AbstractFlopFigures {
    public MariahCarey(EntityType<MariahCarey> type, Level world) {
        super(type, world);
    }

    public MariahCarey(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public static void init() {
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return null; // wip
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return null; // wip
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return null; // wip
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        // will randomly drop jiafei product presents on Christmas Eve and on Christmas Day.
        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    public void tick() {
        // should freeze into an ice cube if it's not december
        super.tick();
    }
}
