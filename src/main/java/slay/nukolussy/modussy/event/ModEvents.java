package slay.nukolussy.modussy.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.item.ActivateMethods;
import slay.nukolussy.modussy.network.period.PlayerMenstruation;
import slay.nukolussy.modussy.network.period.PlayerMenstruationProvider;
import slay.nukolussy.modussy.network.yassification.PlayerYassification;
import slay.nukolussy.modussy.network.yassification.PlayerYassificationProvider;

import java.util.List;

@Mod.EventBusSubscriber(modid = Modussy.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            if (!event.getObject().getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).isPresent()) {
                event.addCapability(new ResourceLocation(Modussy.MODID, "yassificiation"),
                        new PlayerYassificationProvider());
            }
            if (!event.getObject().getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).isPresent()) {
                event.addCapability(new ResourceLocation(Modussy.MODID, "menstruation"),
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
            double x = event.player.getX();
            double y = event.player.getY();
            double z = event.player.getZ();
            Player player = event.player;
            player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
                final Vec3 _center = new Vec3(x, y, z);
                List<AbstractFlops> flops = player.level().getEntitiesOfClass(AbstractFlops.class, new AABB(_center, _center)
                        .inflate(32 / 2d), e -> true).stream().toList();
                for (AbstractFlops flop : flops) {
                    if (yassification.isDaboyz()) {
                        flop.alertFlops(player);
                    }
                    if (yassification.isNewgen()) {
                        flop.setTamed(null);
                    }
                    if (yassification.isMagicFlop()) {
                        ActivateMethods.flopEffects(flop);
                    }
                    if (yassification.isFlopIcon()) {
                        if (player.getLastDamageSource() != null &&
                                player.getLastDamageSource().getEntity() != null) {
                            flop.alertFlops(player.getLastDamageSource().getEntity());
                        }
                        // ensures flops will always be nice to you
                    }
                }
            });

            player.getCapability(PlayerMenstruationProvider.PLAYER_MENSTRUATION).ifPresent(phase -> {
                if (phase.getPhase() == player.level().getMoonPhase()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 0, true, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0, true, false, false));
                }
            });
        }
    }
}
