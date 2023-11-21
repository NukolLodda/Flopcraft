package slay.nukolussy.modussy.entities.projectiles;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.twink.Twink;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

public class ThrownTwinkEgg extends AbstractArrow implements ItemSupplier {
    public ThrownTwinkEgg(EntityType<ThrownTwinkEgg> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownTwinkEgg(double pX, double pY, double pZ, Level pLevel) {
        super(ModEntities.TWINK_EGG.get(), pX, pY, pZ, pLevel);
    }
    public ThrownTwinkEgg(LivingEntity pShooter, Level pLevel) {
        super(ModEntities.TWINK_EGG.get(), pShooter, pLevel);
    }

    public ThrownTwinkEgg(PlayMessages.SpawnEntity packet, Level world) {
        super(ModEntities.TWINK_EGG.get(), world);
    }

    @Override
    protected void onHit(HitResult pResult) {
        // this segment is copied directly from Minecraft source code
        HitResult.Type hitresult$type = pResult.getType();
        if (hitresult$type == HitResult.Type.ENTITY) {
            this.onHitEntity((EntityHitResult)pResult);
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, pResult.getLocation(), GameEvent.Context.of(this, (BlockState)null));
        } else if (hitresult$type == HitResult.Type.BLOCK) {
            BlockHitResult blockhitresult = (BlockHitResult)pResult;
            this.onHitBlock(blockhitresult);
            BlockPos blockpos = blockhitresult.getBlockPos();
            this.level().gameEvent(GameEvent.PROJECTILE_LAND, blockpos, GameEvent.Context.of(this, this.level().getBlockState(blockpos)));
        }


        if (!this.level().isClientSide()) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; j++) {
                    Twink twink = ModEntities.TWINK.get().create(this.level());
                    if (twink != null) {
                        twink.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0f);
                        twink.setRandomVariant();
                        this.level().addFreshEntity(twink);
                    }
                }
            }
            if (this.random.nextInt( 6) == 0) {
                this.spawnAtLocation(ModItems.TWINK_EGG_SHELLS.get());
            }
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity() instanceof LivingEntity living) {
            EntityMethods.addEffects(living);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.CVM.get());
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItems.TWINK_EGG.get());
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return null;
    }
}
