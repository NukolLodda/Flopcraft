package net.nukollodda.flopcraft.event;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.entities.AbstractModEntity;
import net.nukollodda.flopcraft.entities.flops.AbstractIcons;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.util.EntityMethods;
import net.nukollodda.flopcraft.network.period.PlayerMenstruation;
import net.nukollodda.flopcraft.network.period.PlayerMenstruationProvider;
import net.nukollodda.flopcraft.network.yassification.PlayerYassification;
import net.nukollodda.flopcraft.network.yassification.PlayerYassificationProvider;
import net.nukollodda.flopcraft.util.ModUtil;

@Mod.EventBusSubscriber(modid = Flopcraft.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "yassificiation"),
                        new PlayerYassificationProvider());
            }
            if (!event.getObject().getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "menstruation"),
                        new PlayerMenstruationProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });

            event.getOriginal().getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerYassification.class);
        event.register(PlayerMenstruation.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.side == LogicalSide.SERVER) {
            Player player = event.player;
            player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
                ModUtil.getEntityListOfDist(player.level(), AbstractIcons.class, player.position(), 16).forEach(flop -> {
                    if (yassification.isDaboyz()) {
                        flop.alertFlops(player);
                    }
                    if (yassification.isNewgen()) {
                        flop.setTamed(null);
                    }
                    if (yassification.isMagicFlop()) {
                        EntityMethods.flopEffects(flop);
                    }
                    if (yassification.isFlopIcon()) {
                        if (player.getLastDamageSource() != null &&
                                player.getLastDamageSource().getEntity() != null) {
                            flop.alertFlops(player.getLastDamageSource().getEntity());
                        }
                    }
                });
            });

            player.getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(phase -> {
                if (phase.getPhase() == player.level().getMoonPhase()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0, true, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0, true, false, false));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onWorldLoad(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Mob entity) {
            if (entity instanceof Zombie zombie && !(zombie instanceof ZombifiedPiglin)) {
                zombie.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(zombie, AbstractModEntity.class, true));
            }
            if (entity instanceof AbstractSkeleton skeleton) {
                skeleton.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(skeleton, AbstractModEntity.class, true));
            }
            if (entity instanceof AbstractIllager pillager) {
                pillager.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(pillager, AbstractModEntity.class, true));
            }
        }
        if (event.getEntity() instanceof Player player) {
            if (ModUtil.isHumploween()) {
                Component girlYess = ModUtil.getFullGirlYessComment();
                player.sendSystemMessage(girlYess);
                player.addItem(new ItemStack(FlopItems.LOVELY_PEACH.get()));
                player.addItem(new ItemStack(FlopItems.SCARUSSY.get()));
            } else if (ModUtil.isClitmas()) {
                player.sendSystemMessage(Component.translatable("subtitle.happy_clitmas")
                        .withStyle(ChatFormatting.RED));
            }
        }
    }
}
