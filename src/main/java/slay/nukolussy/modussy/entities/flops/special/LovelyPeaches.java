package slay.nukolussy.modussy.entities.flops.special;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.util.PlayerMethods;

public class LovelyPeaches extends AbstractSpecialFlops {
    public LovelyPeaches(EntityType type, Level world) {
        super(type, world);
    }

    public LovelyPeaches(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    @Override
    protected void onDie(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            if (pSource.getEntity() instanceof Player player) {
                if (PlayerMethods.isNewgen(player) ) {
                    alertFlops(player);
                } else {
                    PlayerMethods.setToFlop(player);
                    if (PlayerMethods.isFlop(player)) {
                        alertFlops(player);
                    }
                }
            }
        }
    }

    @Override
    protected void onHurt(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            if (pSource.getEntity() instanceof Player player) {
                if (PlayerMethods.isNewgen(player)) {
                    super.onHurt(pSource);
                } else if (!PlayerMethods.isFlop(player)) {
                    PlayerMethods.addPlayerYassification(player, 1);
                } else {
                    PlayerMethods.addPlayerYassification(player, -1);
                    alertFlops(player);
                }
            } else {
                super.onHurt(pSource);
            }
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return super.hurt(source, amount);
    }
}
