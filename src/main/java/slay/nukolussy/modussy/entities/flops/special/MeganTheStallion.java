package slay.nukolussy.modussy.entities.flops.special;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PlayMessages;

public class MeganTheStallion extends AbstractSpecialFlops {
    public MeganTheStallion(EntityType<MeganTheStallion> type, Level world) {
        super(type, world);
    }

    public MeganTheStallion(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(pPlayer, pHand);
        if (!item.is(Items.SADDLE)) {
            pPlayer.startRiding(this);
        }

        return result;
    }

    public boolean isSaddled() {
        return false; // do it whenever I get to it
    }
}
