package net.nukollodda.flopcraft.item.types.tools;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.nukollodda.flopcraft.item.tiers.FlopTiers;

import java.util.Random;

public class Bratificationer extends SwordItem {
    public Bratificationer() {
        super(FlopTiers.SLAGINIUM, 3, -2.4f, new Properties());
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        Level level = entity.level();
        Vec3 loc = entity.position();
        RandomSource random = entity.getRandom();
        for (int i = 0; i < 4; i++) {
            double x = loc.x + random.nextFloat() - 0.5;
            double y = loc.y + random.nextFloat() - 0.5;
            double z = loc.z + random.nextFloat() - 0.5;

            double dx = (random.nextFloat() - 0.5) * 0.5;
            double dy = (random.nextFloat() - 0.5) * 0.5;
            double dz = (random.nextFloat() - 0.5) * 0.5;
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, dx, dy, dz);
        }

        return super.onEntitySwing(stack, entity);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        Level level = entity.level();
        Vec3 loc = entity.position();
        RandomSource random = player.getRandom();
        for (int i = 0; i < 4; i++) {
            double x = loc.x + random.nextFloat() - 0.5;
            double y = loc.y + random.nextFloat() - 0.5;
            double z = loc.z + random.nextFloat() - 0.5;

            double dx = (random.nextFloat() - 0.5) * 0.5;
            double dy = (random.nextFloat() - 0.5) * 0.5;
            double dz = (random.nextFloat() - 0.5) * 0.5;
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, dx, dy, dz);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
        Level level = player.level();
        Vec3 cent = pos.getCenter();
        if (level.isClientSide) {
            Random random = new Random();
            for (int i = 0; i < 4; i++) {
                double x = cent.x + random.nextFloat() - 0.5;
                double y = cent.y + random.nextFloat() - 0.5;
                double z = cent.z + random.nextFloat() - 0.5;

                double dx = random.nextFloat(-5, 5) * 0.5;
                double dy = random.nextFloat(-5, 5) * 0.5;
                double dz = random.nextFloat(-5, 5) * 0.5;
                level.addParticle(ParticleTypes.HEART, x, y, z, dx, dy, dz);
            }
        }
        return super.onBlockStartBreak(itemstack, pos, player);
    }
}
