package slay.nukolussy.modussy.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Random;

public class ModUtil {
    protected static final Random RANDOM = new Random();
    private static final LocalDate DATE = LocalDate.now();
    public static Component getFullGirlYessComment() {
        int value = RANDOM.nextInt(1, 9); // this will increase as more girl yess comments are made
        return getFullGirlYessComment(value);
    }

    public static Component getFullGirlYessComment(int pVal) {
        return getGirlYessComment(pVal).append(" - ").append(getGirlYessCommentAuthor(pVal))
                .withStyle(getGirlYessCommentStyle(pVal));
    }

    public static boolean itemsEqualsEachother(Object obj, Object... objects) {
        for (Object val : objects) {
            if (!obj.equals(val)) {
                return false;
            }
        }
        return true;
    }

    public static MutableComponent getGirlYessComment(int pVal) {
        return switch (pVal) {
            case 1 -> Component.translatable("subtitle.girl_yas_1");
            case 2 -> Component.translatable("subtitle.girl_yas_2");
            case 3 -> Component.translatable("subtitle.girl_yas_3");
            case 4 -> Component.translatable("subtitle.girl_yas_4");
            case 5 -> Component.translatable("subtitle.girl_yas_5");
            case 6 -> Component.translatable("subtitle.girl_yas_6");
            case 7 -> Component.translatable("subtitle.girl_yas_7");
            case 8 -> Component.translatable("subtitle.girl_yas_8");
            case 9 -> Component.translatable("subtitle.girl_yas_9");
            case 10 -> Component.translatable("subtitle.girl_yas_10");
            case 11 -> Component.translatable("subtitle.girl_yas_11");
            case 12 -> Component.translatable("subtitle.girl_yas_12");
            case 13 -> Component.translatable("subtitle.girl_yas_13");
            case 14 -> Component.translatable("subtitle.girl_yas_14");
            case 15 -> Component.translatable("subtitle.girl_yas_15");
            case 16 -> Component.translatable("subtitle.girl_yas_16");
            case 17 -> Component.translatable("subtitle.girl_yas_17");
            case 18 -> Component.translatable("subtitle.girl_yas_18");
            case 19 -> Component.translatable("subtitle.girl_yas_19");
            case 20 -> Component.translatable("subtitle.girl_yas_20");
            default -> Component.literal("");
        };
    }

    public static Component getGirlYessCommentAuthor(int pVal) {
        return switch (pVal) {
            case 2 -> Component.literal("Raffeal Fortes");
            case 3 -> Component.literal("usedbuttplugforsale");
            case 4 -> Component.literal("Wayer");
            case 5 -> Component.literal("FloweyWave");
            case 6 -> Component.literal("Icy Peach");
            case 7 -> Component.literal("LoliukasUDris");
            case 8 -> Component.literal("jethroofthemonthl");
            default -> Component.translatable("subtitle.girl_yas_anonymous_author");
        };
    }

    public static ChatFormatting getGirlYessCommentStyle(int pVal) {
        return switch (pVal) {
            case 2 -> ChatFormatting.DARK_AQUA;
            case 3 -> ChatFormatting.GRAY;
            case 4 -> ChatFormatting.WHITE;
            case 5 -> ChatFormatting.RED;
            case 6 -> ChatFormatting.LIGHT_PURPLE;
            case 7 -> ChatFormatting.BLUE;
            case 8 -> ChatFormatting.DARK_RED;
            default -> ChatFormatting.GOLD;
        };
    }

    public static <T extends Entity> List<T> getEntityListOfDist(LevelAccessor pLevel, Class<T> pEntClass, Vec3 pLoc, double pSize) {
        return getEntityListOfDist(pLevel, pEntClass, pLoc, pLoc, pSize);
    }

    public static <T extends Entity> List<T> getEntityListOfDist(@NotNull LevelAccessor pLevel, Class<T> pEntClass, Vec3 pLoc, Vec3 pBound, double pSize) {
        return pLevel.getEntitiesOfClass(pEntClass, new AABB(pLoc, pBound)
                .inflate(pSize), e -> true).stream().toList();
    }

    public static boolean monthIs(Month pMonth) {
        return DATE.getMonth().equals(pMonth);
    }

    public static boolean dayIs(int pDay) {
        return DATE.getDayOfMonth() == pDay;
    }

    public static boolean dateIs(Month pMonth, int pDay) {
        return DATE.getMonth().equals(pMonth) && DATE.getDayOfMonth() == pDay;
    }

    public static boolean dateInRange(Month pMonth, int pFirst, int pFinal) {
        return DATE.getMonth().equals(pMonth) && DATE.getDayOfMonth() >= pFirst && DATE.getDayOfMonth() < pFinal;
    }

    public static boolean isHumploween() {
        return dateIs(Month.OCTOBER, 31);
    }

    public static boolean isClitmas() {
        return dateInRange(Month.DECEMBER, 24, 26);
    }

    public static boolean isNewYears() {
        return DATE.getDayOfYear() == 1;
    }
}
