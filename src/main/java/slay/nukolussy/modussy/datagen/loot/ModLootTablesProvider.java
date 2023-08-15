package slay.nukolussy.modussy.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.item.ModItems;

import java.util.Set;

public class ModLootTablesProvider extends BlockLootSubProvider {
    public ModLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FLOPIUM_BLOCK.get());
        this.dropSelf(ModBlocks.GAGASTONE_BLOCK.get());
        this.dropSelf(ModBlocks.GAGINA_BLOCK.get());
        this.dropSelf(ModBlocks.INFUSED_SLAGINIUM_BLOCK.get());
        this.dropSelf(ModBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
        this.dropSelf(ModBlocks.SHENSEIUM_BLOCK.get());
        this.dropSelf(ModBlocks.SLAGINIUM_BLOCK.get());
        this.dropSelf(ModBlocks.CVM_INFUSION_ALTER.get());

        this.add(ModBlocks.SHENSEIUM_ORE.get(), block -> createOreDrops(ModBlocks.SHENSEIUM_ORE.get(), ModItems.SHENSEIUM.get(), 1, 3));
        this.dropOther(ModBlocks.GROWING_JIAFEI.get(), ModItems.JIAFEI_PRODUCT.get().asItem());
    }

    protected LootTable.Builder createOreDrops(Block pBlock, Item pItem, int max, int min) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
