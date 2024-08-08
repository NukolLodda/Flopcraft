package net.nukollodda.flopcraft.item.types;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.nukollodda.flopcraft.effect.FlopEffects;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.util.ModUtil;

public class AranaGrande extends Item {
    public AranaGrande() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        if (world.isClientSide()) Minecraft.getInstance().gameRenderer.displayItemActivation(entity.getMainHandItem());
        entity.playSound(FlopSounds.YUH.get());
        ModUtil.getEntityListOfDist(world, LivingEntity.class, entity.position(), 16).forEach(ent -> {
            if (!ent.equals(entity))
                ent.addEffect(new MobEffectInstance(FlopEffects.YUH.get(), 1000, 0));
        });
        if (world instanceof ServerLevel level) {
            level.sendParticles(ParticleTypes.CLOUD, x, y, z, 100,5,5, 5, 1.0);
        }
        entity.getMainHandItem().shrink(1);
        return ar;
    }

}
