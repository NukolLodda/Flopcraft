package net.nukollodda.flopcraft.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.nukollodda.flopcraft.block.plants.JiafeiCrop;
import net.nukollodda.flopcraft.block.FlopBlocks;
import net.nukollodda.flopcraft.item.FlopItems;

import java.util.Set;

public class FlopLootTablesProvider extends BlockLootSubProvider {
    public FlopLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(FlopBlocks.BRAT_BLOCK.get());
        this.dropSelf(FlopBlocks.FLOPIUM_BLOCK.get());
        this.dropSelf(FlopBlocks.GAGASTONE_BLOCK.get());
        this.dropSelf(FlopBlocks.GAGINA_BLOCK.get());
        this.dropSelf(FlopBlocks.INFUSED_SLAGINIUM_BLOCK.get());
        this.dropSelf(FlopBlocks.MYSTICAL_FLOPIUM_BLOCK.get());
        this.dropSelf(FlopBlocks.SHENSEIUM_BLOCK.get());
        this.dropSelf(FlopBlocks.SLAGINIUM_BLOCK.get());
        this.dropSelf(FlopBlocks.CVM_INFUSION_ALTER.get());
        this.dropSelf(FlopBlocks.GIRL_YESS_PUMPKIN.get());

        this.add(FlopBlocks.SHENSEIUM_ORE.get(), block -> createOreDrops(FlopBlocks.SHENSEIUM_ORE.get(), FlopItems.SHENSEIUM.get(), 1, 3));
        this.add(FlopBlocks.BRAT_ORE.get(), block -> createOreDrops(FlopBlocks.BRAT_ORE.get(), FlopItems.BRAT.get(), 1, 2));
        this.add(FlopBlocks.DEEPSLATE_BRAT_ORE.get(), block -> createOreDrops(FlopBlocks.DEEPSLATE_BRAT_ORE.get(), FlopItems.BRAT.get(), 1, 2));

        LootItemCondition.Builder jiafeiLootItemCondition = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(FlopBlocks.GROWING_JIAFEI.get())
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(JiafeiCrop.AGE, 3));
        this.add(FlopBlocks.GROWING_JIAFEI.get(), block -> createCropDrops(FlopBlocks.GROWING_JIAFEI.get(),
                FlopItems.JIAFEI_PRODUCT.get(), FlopItems.JIAFEI_SEED.get().asItem(),
                jiafeiLootItemCondition));
    }

    protected LootTable.Builder createOreDrops(Block pBlock, Item pItem, int max, int min) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(max, min)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
