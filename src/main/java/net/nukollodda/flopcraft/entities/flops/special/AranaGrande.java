package net.nukollodda.flopcraft.entities.flops.special;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.nukollodda.flopcraft.entities.flops.IFlopEntity;

public class AranaGrande extends Spider implements IFlopEntity {
    private Player tamedBy;

    public AranaGrande(EntityType<AranaGrande> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void setTamed(Player player) {
        this.tamedBy = player;
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
