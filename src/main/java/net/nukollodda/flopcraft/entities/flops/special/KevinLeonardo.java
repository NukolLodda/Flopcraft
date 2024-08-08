package net.nukollodda.flopcraft.entities.flops.special;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.entities.AbstractModEntity;
import net.nukollodda.flopcraft.entities.flops.IFlopEntity;
import net.nukollodda.flopcraft.entities.twink.AbstractTwink;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.sound.FlopSounds;

public class KevinLeonardo extends AbstractTwink implements IFlopEntity {
    public KevinLeonardo(EntityType type, Level world) {
        super(type, world);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return switch (this.random.nextInt(6)) {
            case 1 -> FlopSounds.KEVIN_LEONARDO_1.get();
            case 2 -> FlopSounds.KEVIN_LEONARDO_2.get();
            case 3 -> FlopSounds.KEVIN_LEONARDO_3.get();
            case 4 -> FlopSounds.KEVIN_LEONARDO_4.get();
            case 5 -> FlopSounds.KEVIN_LEONARDO_5.get();
            default -> FlopSounds.KEVIN_LEONARDO_6.get();
        };
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return FlopSounds.KEVIN_LEONARDO_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.random.nextBoolean() ? FlopSounds.KEVIN_LEONARDO_HURT1.get() : FlopSounds.KEVIN_LEONARDO_HURT2.get();
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
            boolean flag = itemStack.is(FlopItems.CVM.get()) || itemStack.is(FlopItems.CVMIUM.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(FlopItems.CVM.get()) || item.equals(FlopItems.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                player.spawnAtLocation(FlopItems.HAIRUSSY.get());

                this.playSound(FlopSounds.CUPCAkKE_SLURP.get());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    @Override
    public void aiStep() {
        if (this.random.nextInt(690) == 0) {
            this.spawnAtLocation(FlopItems.HAIRUSSY.get());
        }
        super.aiStep();
    }

    @Override
    public MobType getMobType() {
        return null;
    }

    @Override
    public boolean canMate(AbstractModEntity pEntity) {
        return false;
    }
}
