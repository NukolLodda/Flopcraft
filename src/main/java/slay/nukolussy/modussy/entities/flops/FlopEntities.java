package slay.nukolussy.modussy.entities.flops;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public interface FlopEntities {

    void setTamed(Player player);

    void setTarget(LivingEntity entity);

    Player getTamedBy();
    /*
     * this interface will allow Megan The Stallion and the Gagina Spider to be considered flops
     * without inheriting the flops class as doing so would make them unable to inherit their
     * respective classes
     */

}
