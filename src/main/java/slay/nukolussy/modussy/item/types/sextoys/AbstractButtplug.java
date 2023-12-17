package slay.nukolussy.modussy.item.types.sextoys;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;

import java.util.List;

public abstract class AbstractButtplug extends Item {
    public AbstractButtplug(int durability) {
        super(new Properties().fireResistant().durability(durability));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        int dura = 0;
        EntityMethods.addEffects(pPlayer);
        pPlayer.playSound(ModSounds.SQUIRT.get());
        {
            final Vec3 center = new Vec3(pPlayer.getX(), pPlayer.getY(), pPlayer.getZ());
            List<LivingEntity> entites = pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(8 / 2d), e -> true).stream().toList();
            for (LivingEntity entity : entites) {
                EntityMethods.addEffects(entity);
                dura++;
            }
        }
        item.setDamageValue(item.getDamageValue() + dura);
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
