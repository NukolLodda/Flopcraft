package net.nukollodda.flopcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.minecraftforge.registries.ForgeRegistries;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.loot.AddItemModifier;
import net.nukollodda.flopcraft.loot.AddSuspiciousSandModifier;

import java.util.Objects;

public class FlopGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public FlopGlobalLootModifiersProvider(PackOutput output) {
        super(output, Flopcraft.MODID);
    }

    @Override
    protected void start() {
        createFloptropicaAirportLoot(FlopItems.JIAFEI_PRODUCT.get());
        createFloptropicaAirportLoot(FlopItems.CVM.get());
        createFloptropicaAirportLoot(FlopItems.CVM_PIE.get());
        createFloptropicaAirportLoot(FlopItems.DEELDO.get());
        createFloptropicaAirportLoot(FlopItems.CUPCAKE.get());
        createFloptropicaAirportLoot(FlopItems.ROSETOY.get());
        createFloptropicaAirportLoot(FlopItems.TAMPON.get());
        createFloptropicaAirportLoot(FlopItems.BARBIE_CRYSTALS.get());
        createFloptropicaAirportLoot(FlopItems.KYLIE_JENNER_LIPSTICK.get());
        createFloptropicaAirportLoot(FlopItems.LANCVM_CREAM.get());
        createFloptropicaAirportLoot(FlopItems.DISC_RANVISION.get());
        createFloptropicaAirportLoot(FlopItems.DISC_DEJE_BULLYING.get());
        createFloptropicaAirportLoot(FlopItems.SLAGINIUM_YASSIFIER.get());
        createFloptropicaAirportLoot(FlopItems.SLAGINIUM.get());
        createFloptropicaAirportLoot(FlopItems.INFUSED_SLAGINIUM.get());
        createFloptropicaAirportLoot(FlopItems.BLOODY_TAMPON.get());
        createFloptropicaAirportLoot(FlopItems.CVMIUM.get());
        createFloptropicaAirportLoot(FlopItems.SHENSEIUM.get());
        createFloptropicaAirportLoot(FlopItems.HAIRUSSY.get());
        createFloptropicaAirportLoot(FlopItems.DISC_PONMI.get());
        createFloptropicaAirportLoot(FlopItems.DISC_JIAFEI.get());
        createFloptropicaAirportLoot(FlopItems.TWINK_EGG_SHELLS.get());
        createFloptropicaAirportLoot(FlopItems.TWINK_EGG.get());
        createFloptropicaAirportLoot(FlopItems.ARANA_GRANDE.get());
        createFloptropicaAirportLoot(FlopItems.SCARUSSY.get());
        createFloptropicaAirportLoot(FlopItems.CVMTITPLASM.get());
        createFloptropicaAirportLoot(FlopItems.JIAFEI_UPGRADE_TEMPLATE.get());

        add("jiafei_template_from_suspicious_sand", new AddSuspiciousSandModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("archaeology/ocean_ruin_cold")).build(),
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("archaeology/ocean_ruin_warm")).build()
        }, FlopItems.JIAFEI_UPGRADE_TEMPLATE.get()));
    }

    private void createFloptropicaAirportLoot(Item item) {
        Rarity rarity = item.getRarity(new ItemStack(item));
        float chance = switch (rarity) {
            case UNCOMMON -> 0.3f;
            case RARE -> 0.1f;
            case EPIC -> 0.07f;
            default -> 0.69f;
        };
        add(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem())).getPath() + "_from_chest",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath(Flopcraft.MODID, "chests/floptropica_airport")).build(),
                        LootItemRandomChanceCondition.randomChance(chance).build()
                }, item));
    }
}
