package slay.nukolussy.modussy.item.types;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.projectiles.BloodyTampons;
import slay.nukolussy.modussy.entities.projectiles.Tampons;
import slay.nukolussy.modussy.util.ToolMethods;
import slay.nukolussy.modussy.item.ModItems;

public class BloodyTampon extends ArrowItem {
    public BloodyTampon() {
        super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        ToolMethods.slayAttack(itemStack, sourceentity, entity, 1);
        return true;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        return new BloodyTampons(pShooter, pLevel);
    }
}
