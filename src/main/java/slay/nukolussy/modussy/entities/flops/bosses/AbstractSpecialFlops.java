package slay.nukolussy.modussy.entities.flops.bosses;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.level.Level;
import slay.nukolussy.modussy.entities.flops.AbstractFlopFigures;

public abstract class AbstractSpecialFlops extends AbstractFlopFigures {
    public AbstractSpecialFlops(EntityType type, Level world) {
        super(type, world);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    /* Special Flops have a special design to them that makes them different from other flop figures
     * Mobs under this category are:
     * LovelyPeaches
     * Megan The Stallion
     * Gagina Spider (An infusion of Lady Gaga and Ariana Grande in spider form)
     */
}