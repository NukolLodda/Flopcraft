package net.nukollodda.flopcraft.block.entity.ent;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.effect.FlopEffects;
import net.nukollodda.flopcraft.entities.FlopEntities;
import net.nukollodda.flopcraft.entities.flops.figures.KamalaHarris;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.sound.FlopSounds;
import net.nukollodda.flopcraft.util.EntityMethods;
import net.nukollodda.flopcraft.util.FlopUtil;
import net.nukollodda.flopcraft.util.ToolMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BratBlockEntity extends BlockEntity {
    private long ticksOfActivation = 0;
    private boolean activated = false;
    private Player player;

    public BratBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(FlopBlockEntities.BRAT_BLOCK.get(), pPos, pBlockState);
    }

    public void activate(Level pLevel, Player pPlayer, BlockPos pPos) {
        activated = true;
        player = pPlayer;
        pLevel.setBlock(pPos.below(2), FlopBlocks.KAMALOCONUT_PALM_LOG.get().defaultBlockState(), 3);
        Entity summoned = FlopUtil.getEntityListOfDist(pLevel, KamalaHarris.class, pPos.getCenter(), 64).isEmpty() ?
                new KamalaHarris(FlopEntities.KAMALA_HARRIS.get(), pLevel) :
                new ItemEntity(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), new ItemStack(FlopItems.KAMALOCONUT.get()));
        summoned.moveTo(pPos.above().getCenter());
        List<LivingEntity> entities = FlopUtil.getEntityListOfDist(pLevel, LivingEntity.class, pPos.getCenter(), 4);
        for (LivingEntity entity : entities) {
            ToolMethods.yassification(entity, pLevel, player);
            EntityMethods.addEffects(entity);
        }
        if (summoned instanceof KamalaHarris harris) {
            player.displayClientMessage(Component.translatable("subtitle.summoning_kamala")
                    .withStyle(ChatFormatting.GREEN), true);
            player.addEffect(new MobEffectInstance(FlopEffects.YUH.get(), 360));
            harris.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 360, 3));
            harris.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 360, 127));
            harris.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 360, 5));
            if (player != null) {
                harris.setTamed(player);
            }
            harris.playSound(FlopSounds.KAMALA_HARRIS_SUMMON.get());
            harris.setSummoning();
        }
        pLevel.addFreshEntity(summoned);

    }

    public long getTicksOfActivation() {
        return ticksOfActivation;
    }

    public boolean isActivated() {
        return activated;
    }

    public void tick(Level pLevel, BlockPos pPos) {
        if (activated) {
            ticksOfActivation++;
            ClientLevel clientLevel = Minecraft.getInstance().level;
            ArrayList<BlockPos> positions = new ArrayList<>(List.of(pPos.north(), pPos.south(), pPos.east(), pPos.west()));
            Random random = new Random();
            if (ticksOfActivation >= 180) {
                double x = pPos.getX() + random.nextFloat();
                double y = pPos.getY() + random.nextFloat();
                double z = pPos.getZ() + random.nextFloat();
                ItemStack fireworkItem = ItemStack.EMPTY;
                if (random.nextInt(20) == 0) {
                    fireworkItem = new ItemStack(Items.FIREWORK_ROCKET);
                    CompoundTag tag = fireworkItem.getOrCreateTag();
                    CompoundTag fwTag = new CompoundTag();
                    ListTag fwList = new ListTag();
                    CompoundTag xplTag = new CompoundTag();

                    xplTag.putIntArray("Colors", new int[]{9030660, 0});
                    xplTag.putIntArray("FadeColors", new int[]{9030660});
                    xplTag.putByte("Flicker", (byte)1);
                    xplTag.putByte("Trail", (byte)1);
                    xplTag.putInt("Type", 2);

                    fwList.add(xplTag);

                    fwTag.put("Explosions", fwList);
                    fwTag.putInt("Flight", 2);
                    tag.put("Fireworks", fwTag);

                    fireworkItem.setTag(tag);
                }

                FireworkRocketEntity firework = new FireworkRocketEntity(pLevel, x, y + 2, z, fireworkItem);
                firework.setSilent(true);
                pLevel.addFreshEntity(firework);
            } else if (!positions.isEmpty()) {
                BlockPos pos = positions.get(random.nextInt(positions.size()));
                Vec3 cent = pos.getCenter();
                double x = cent.x + random.nextFloat() - 0.5;
                double y = cent.y + random.nextFloat() - 0.5;
                double z = cent.z + random.nextFloat() - 0.5;

                double dx = (random.nextFloat() - 0.5) * 0.5;
                double dy = (random.nextFloat() - 0.5) * 0.5;
                double dz = (random.nextFloat() - 0.5) * 0.5;
                pLevel.destroyBlock(pos, false, player);
                if (clientLevel != null) {
                    clientLevel.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, dx, dy, dz);
                }
            }

            if (ticksOfActivation >= 340) {
                if (clientLevel != null) {
                    Vec3 cent = pPos.below().getCenter();
                    double x = cent.x + random.nextFloat() - 0.5;
                    double y = cent.y + 2 * random.nextFloat();
                    double z = cent.z + random.nextFloat() - 0.5;

                    double dx = (random.nextFloat() - 0.5) * 0.5;
                    double dy = (random.nextFloat() - 0.5) * 0.5;
                    double dz = (random.nextFloat() - 0.5) * 0.5;
                    clientLevel.addParticle(ParticleTypes.POOF, x, y, z, dx, dy, dz);

                    cent = pPos.getCenter();
                    x = cent.x + random.nextFloat() - 0.5;
                    y = cent.y + random.nextFloat() - 0.5;
                    z = cent.z + random.nextFloat() - 0.5;
                    dx = (random.nextFloat() - 0.5) * 0.5;
                    dy = (random.nextFloat() - 0.5) * 0.5;
                    dz = (random.nextFloat() - 0.5) * 0.5;
                    clientLevel.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, dx, dy, dz);
                }
                pLevel.destroyBlock(pPos.below(2), false, player);
                pLevel.destroyBlock(pPos.below(1), false, player);
                pLevel.destroyBlock(pPos, false, player);
                activated = false;
                ticksOfActivation = 0;
            }
        }
    }
}
