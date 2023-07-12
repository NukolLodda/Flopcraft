package slay.nukolussy.modussy.entities.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.item.ActivateMethods;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

public class Cvm extends AbstractCvm {
    public Cvm(EntityType<? extends AbstractCvm> type, Level world) {
        super(type, world);
    }

    @Override
    public void onHitBlock(BlockHitResult pResult) {
        Entity owner = this.getOwner();
        if (owner instanceof Player _player) {
            ActivateMethods.cvmShoot(this.level(), this.getX(), this.getY(), this.getZ(), _player, (int)this.getBaseDamage(), flame ? 100 : 0);
            owner.playSound(ModSounds.CVM.get());
        }
        this.kill();
        super.onHitBlock(pResult);
    }

    public void setFireness(boolean flame) {
        this.flame = flame;
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        Entity owner = this.getOwner();
        if (owner instanceof Player _player) {
            ActivateMethods.cvmShoot(this.level(), this.getX(), this.getY(), this.getZ(), _player, (int)this.getBaseDamage(), flame ? 100 : 0);
            owner.playSound(ModSounds.CVM.get());
        }
        this.kill();
        super.onHitEntity(pResult);
    }

    @Override
    public @NotNull ItemStack getItem() {
        return new ItemStack(ModItem.CVM.get());
    }
}
