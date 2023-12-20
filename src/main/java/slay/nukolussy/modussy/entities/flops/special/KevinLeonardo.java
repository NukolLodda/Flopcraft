package slay.nukolussy.modussy.entities.flops.special;

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
import slay.nukolussy.modussy.entities.AbstractModEntity;
import slay.nukolussy.modussy.entities.flops.IFlopEntity;
import slay.nukolussy.modussy.entities.twink.AbstractTwink;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

public class KevinLeonardo extends AbstractTwink implements IFlopEntity {
    public KevinLeonardo(EntityType type, Level world) {
        super(type, world);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return switch (this.random.nextInt(6)) {
            case 1 -> ModSounds.KEVIN_LEONARDO_1.get();
            case 2 -> ModSounds.KEVIN_LEONARDO_2.get();
            case 3 -> ModSounds.KEVIN_LEONARDO_3.get();
            case 4 -> ModSounds.KEVIN_LEONARDO_4.get();
            case 5 -> ModSounds.KEVIN_LEONARDO_5.get();
            default -> ModSounds.KEVIN_LEONARDO_6.get();
        };
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.KEVIN_LEONARDO_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return this.random.nextBoolean() ? ModSounds.KEVIN_LEONARDO_HURT1.get() : ModSounds.KEVIN_LEONARDO_HURT2.get();
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
            boolean flag = itemStack.is(ModItems.CVM.get()) || itemStack.is(ModItems.CVMIUM.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItems.CVM.get()) || item.equals(ModItems.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                player.spawnAtLocation(ModItems.HAIRUSSY.get());

                this.playSound(ModSounds.CUPCAkKE_SLURP.get());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    @Override
    public void aiStep() {
        if (this.random.nextInt(690) == 0) {
            this.spawnAtLocation(ModItems.HAIRUSSY.get());
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
