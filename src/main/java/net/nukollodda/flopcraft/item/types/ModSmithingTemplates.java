package net.nukollodda.flopcraft.item.types;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import net.nukollodda.flopcraft.Flopcraft;

import java.util.List;

public class ModSmithingTemplates {
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESC_FORMAT = ChatFormatting.BLUE;

    public static @NotNull SmithingTemplateItem createJiafeiUpgradeTemplate() {
        return new SmithingTemplateItem(
                Component.translatable("item.flopcraft.jiafei_upgrade_smithing_template.applies_to").withStyle(DESC_FORMAT),
                Component.translatable("item.flopcraft.jiafei_upgrade_smithing_template.ingredients").withStyle(DESC_FORMAT),
                Component.translatable("item.flopcraft.jiafei_upgrade_smithing_template.desc").withStyle(TITLE_FORMAT),
                Component.translatable("item.flopcraft.jiafei_upgrade_smithing_template.base_desc"),
                Component.translatable("item.flopcraft.jiafei_upgrade_smithing_template.upgrade_material"),
                createUpgradeIconsList(),
                List.of(ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID,"item/empty_slot_product")));
    }

    private static List<ResourceLocation> createUpgradeIconsList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }
}
