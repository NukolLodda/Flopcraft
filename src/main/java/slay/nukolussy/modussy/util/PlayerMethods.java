package slay.nukolussy.modussy.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slay.nukolussy.modussy.entities.flops.figures.LovelyPeaches;
import slay.nukolussy.modussy.network.yassification.PlayerYassification;
import slay.nukolussy.modussy.network.yassification.PlayerYassificationProvider;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerMethods {
    public static void setToFlop(Player player) {
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(PlayerYassification::setToFlop);
    }
    public static boolean isDaboyz(Player player) {
        AtomicBoolean isDaboyz = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isDaboyz.set(yassification.isDaboyz());
        });
        return isDaboyz.get();
    }

    public static boolean isNewgen(Player player) {
        AtomicBoolean isNewgen = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isNewgen.set(yassification.isNewgen());
        });
        return isNewgen.get();
    }

    public static boolean isNeutralBossFight(Player player, LivingEntity flop) {
        return isNeutral(player) && (flop instanceof LovelyPeaches);
    }

    public static boolean isNeutral(Player player) {
        AtomicBoolean isNeutral = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isNeutral.set(!yassification.isNewgen() && !yassification.isFlop());
        });
        return isNeutral.get();
    }

    public static boolean isFlop(Player player) {
        AtomicBoolean isFlop = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isFlop.set(yassification.isFlop());
        });
        return isFlop.get();
    }

    public static boolean isMagicFlop(Player player) {
        AtomicBoolean isMagicFlop = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isMagicFlop.set(yassification.isMagicFlop());
        });
        return isMagicFlop.get();
    }

    public static boolean isFlopIcon(Player player) {
        AtomicBoolean isFlopIcon = new AtomicBoolean(false);
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            isFlopIcon.set(yassification.isFlopIcon());
        });
        return isFlopIcon.get();
    }

    public static void addPlayerYassification(Player player, int added) {
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            if (added > 0) {
                yassification.addYassification(added);
            } else {
                yassification.subYassification(Math.abs(added));
            }

            if (yassification.isDaboyz() && !yassification.wasDaboyz(added)) {
                player.displayClientMessage(Component.translatable("subtitle.is_daboyz")
                        .withStyle(ChatFormatting.DARK_RED), true);
                player.playSound(SoundEvents.VILLAGER_HURT);
            }
            if (yassification.isNewgen() && !yassification.wasNewgen(added)) {
                player.displayClientMessage(Component.translatable("subtitle.is_newgen")
                        .withStyle(ChatFormatting.RED), true);
                player.playSound(SoundEvents.VILLAGER_NO);
            }
            if (yassification.isFlop() && !yassification.wasFlop(added)) {
                player.displayClientMessage(Component.translatable("subtitle.is_flop")
                        .withStyle(ChatFormatting.AQUA), true);
                player.playSound(ModSounds.AESTHETIC_3.get());
            }
            if (yassification.isMagicFlop() && !yassification.wasMagicFlop(added)) {
                player.displayClientMessage(Component.translatable("subtitle.is_magic_flop")
                        .withStyle(ChatFormatting.DARK_PURPLE), true);
                player.playSound(ModSounds.AESTHETIC_1.get());
            }
            if (yassification.isFlopIcon() && !yassification.wasFlopIcon(added)) {
                player.displayClientMessage(Component.translatable("subtitle.is_flop_leader")
                        .withStyle(ChatFormatting.LIGHT_PURPLE), true);
                player.playSound(ModSounds.AESTHETIC_JIAFEI.get());
            }
        });
    }

    public static MutableComponent getYassificationLevel(Player player) {
        AtomicInteger yassLvl = new AtomicInteger();
        player.getCapability(PlayerYassificationProvider.PLAYER_YASSIFICATION).ifPresent(yassification -> {
            yassLvl.set(yassification.getYassification());
        });

        ChatFormatting format = ChatFormatting.GRAY;
        if (yassLvl.get() < -3142) {
            format = ChatFormatting.DARK_RED;
        } else if (yassLvl.get() < -420) {
            format = ChatFormatting.RED;
        } else if (yassLvl.get() > 690) {
            format = ChatFormatting.AQUA;
        } else if (yassLvl.get() > 1710) {
            format = ChatFormatting.DARK_PURPLE;
        } else if (yassLvl.get() > 4371) {
            format = ChatFormatting.LIGHT_PURPLE;
        }

        return Component.translatable("subtitle.yassification_level").append(": " + yassLvl).withStyle(format);
    }
}
