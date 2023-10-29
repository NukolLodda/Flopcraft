package slay.nukolussy.modussy.entities.flops.special;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.flops.IFlopEntity;

public class MeganTheStallion extends AbstractHorse implements IFlopEntity {
    private Player tamedBy;

    public MeganTheStallion(EntityType<MeganTheStallion> type, Level world) {
        super(type, world);
    }

    @Override
    public void setTamed(Player player) {
        this.tamedBy = player;
        super.setTamed(true);
        if (player == null) {
            super.setTamed(false);
        }
    }

    @Override
    public void setTarget(LivingEntity entity) {
        super.setTarget(entity);
    }

    @Override
    public Player getTamedBy() {
        return tamedBy;
    }
}
