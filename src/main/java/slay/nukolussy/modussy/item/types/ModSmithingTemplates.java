package slay.nukolussy.modussy.item.types;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplates {
    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESC_FORMAT = ChatFormatting.BLUE;

    public static SmithingTemplateItem createJiafeiUpgradeTemplate() {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.applies_to"))).withStyle(DESC_FORMAT),
                Component.translatable("item.modussy.jiafei_upgrade_smithing_template.ingredients").withStyle(DESC_FORMAT),
                Component.translatable("item.modussy.jiafei_upgrade_smithing_template.desc").withStyle(TITLE_FORMAT),
                Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description"))),
                Component.translatable("item.modussy.jiafei_upgrade_smithing_template.upgrade_material"),
                createJiafeiUpgradeIconList(),
                createJiafeiUpgradeMaterialList());
    }

    private static List<ResourceLocation> createJiafeiUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_BOOTS, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_HELMET,
                new ResourceLocation("item/empty_slot_axe"),
                new ResourceLocation("item/empty_slot_hoe"),
                new ResourceLocation("item/empty_slot_shovel"),
                new ResourceLocation("item/empty_slot_sword"),
                new ResourceLocation("item/empty_slot_pickaxe"));
    }

    private static List<ResourceLocation> createJiafeiUpgradeIconList() {
        return List.of(new ResourceLocation("modussy","item/empty_slot_product"));
    }
}
