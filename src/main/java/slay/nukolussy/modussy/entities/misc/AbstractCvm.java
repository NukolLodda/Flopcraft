package slay.nukolussy.modussy.entities.misc;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.item.ModItem;

public abstract class AbstractCvm extends AbstractArrow implements ItemSupplier {
    protected boolean flame;
    private static final EntityDataAccessor<Byte> ID_FLAGS = SynchedEntityData.defineId(AbstractCvm.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> PIERCE_LEVEL = SynchedEntityData.defineId(AbstractCvm.class, EntityDataSerializers.BYTE);

    protected AbstractCvm(EntityType<? extends AbstractCvm> type, Level world) {
        super(type, world);
    }

    protected AbstractCvm(EntityType<? extends AbstractCvm> type, LivingEntity pShooter, Level world) {
        super(type, pShooter, world);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(ID_FLAGS, (byte)0);
        this.entityData.define(PIERCE_LEVEL, (byte)0);
    }

    public abstract void setFireness(boolean flame);

    @Override
    public ItemStack getItem() {
        return new ItemStack(ModItem.CVM.get());
    }
}
