package slay.nukolussy.modussy.entities.flops.special;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.flops.FlopEntities;

public class GaginaSpider extends Spider implements FlopEntities {
    private Player tamedBy;

    public GaginaSpider(EntityType<GaginaSpider> pEntityType, Level pLevel) {
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
