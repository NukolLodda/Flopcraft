package slay.nukolussy.modussy.entities.flops.special;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.flops.FlopEntities;

public class MeganTheStallion extends AbstractHorse implements FlopEntities {
    public MeganTheStallion(EntityType<MeganTheStallion> type, Level world) {
        super(type, world);
    }
}
