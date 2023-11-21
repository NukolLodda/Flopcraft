package slay.nukolussy.modussy.entities.flops.figures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.block.entity.blocks.MariahCareyIceBlock;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.ToolMethods;

import java.time.Month;

public class MariahCarey extends AbstractFlopFigures implements RangedAttackMob {
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
        if (!ModUtil.getMonth().equals(Month.DECEMBER)) {
            int x = this.getBlockX();
            int y = this.getBlockY();
            int z = this.getBlockZ();
            int rot = Math.round(this.getYRot() / 90);
            Direction facing = switch (rot) {
                case 1 -> Direction.EAST;
                case 2 -> Direction.SOUTH;
                case 3 -> Direction.WEST;
                default -> Direction.NORTH;
            };
            this.level().setBlock(new BlockPos(x, y, z),
                    ModBlocks.MARIAH_CAREY_ICE_BLOCK.get().defaultBlockState().setValue(MariahCareyIceBlock.FACING, facing), 3);
            this.remove(RemovalReason.DISCARDED);
        }
        // it should also do the snow golem thing
        super.tick();
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        double xDif = pTarget.getX() - this.getX();
        double yDif = pTarget.getY() - this.getY();
        double zDif = pTarget.getZ() - this.getZ();
        for (int i = 1; i <= 6; i++) {
            int inX = (int)((i * xDif / 6) + this.getX());
            int inY = (int)((i * yDif / 6) + this.getY());
            int inZ = (int)((i * zDif / 6) + this.getZ());
            ToolMethods.mariahCvmreyShoot(this.level(), inX, inY, inZ, pVelocity);
        }
    }
}
