package slay.nukolussy.modussy.datagen;

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
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.loot.AddItemModifier;
import slay.nukolussy.modussy.loot.AddSuspiciousSandModifier;

import java.util.Objects;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Modussy.MODID);
    }

    @Override
    protected void start() {
        createFloptropicaAirportLoot(ModItems.JIAFEI_PRODUCT.get());
        createFloptropicaAirportLoot(ModItems.CVM.get());
        createFloptropicaAirportLoot(ModItems.CVM_PIE.get());
        createFloptropicaAirportLoot(ModItems.DEELDO.get());
        createFloptropicaAirportLoot(ModItems.CUPCAKE.get());
        createFloptropicaAirportLoot(ModItems.ROSETOY.get());
        createFloptropicaAirportLoot(ModItems.TAMPON.get());
        createFloptropicaAirportLoot(ModItems.BARBIE_CRYSTALS.get());
        createFloptropicaAirportLoot(ModItems.KYLIE_JENNER_LIPSTICK.get());
        createFloptropicaAirportLoot(ModItems.LANCVM_CREAM.get());
        createFloptropicaAirportLoot(ModItems.DISC_RANVISION.get());
        createFloptropicaAirportLoot(ModItems.DISC_DEJE_BULLYING.get());
        createFloptropicaAirportLoot(ModItems.SLAGINIUM_YASSIFIER.get());
        createFloptropicaAirportLoot(ModItems.SLAGINIUM.get());
        createFloptropicaAirportLoot(ModItems.INFUSED_SLAGINIUM.get());
        createFloptropicaAirportLoot(ModItems.BLOODY_TAMPON.get());
        createFloptropicaAirportLoot(ModItems.CVMIUM.get());
        createFloptropicaAirportLoot(ModItems.SHENSEIUM.get());
        createFloptropicaAirportLoot(ModItems.HAIRUSSY.get());
        createFloptropicaAirportLoot(ModItems.DISC_PONMI.get());
        createFloptropicaAirportLoot(ModItems.DISC_JIAFEI.get());
        createFloptropicaAirportLoot(ModItems.TWINK_EGG_SHELLS.get());
        createFloptropicaAirportLoot(ModItems.TWINK_EGG.get());
        createFloptropicaAirportLoot(ModItems.ARANA_GRANDE.get());
        createFloptropicaAirportLoot(ModItems.SCARUSSY.get());
        createFloptropicaAirportLoot(ModItems.CVMTITPLASM.get());
        createFloptropicaAirportLoot(ModItems.JIAFEI_UPGRADE_TEMPLATE.get());

        add("jiafei_template_from_suspicious_sand", new AddSuspiciousSandModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_cold")).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_warm")).build()
        }, ModItems.JIAFEI_UPGRADE_TEMPLATE.get()));
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
                        new LootTableIdCondition.Builder(new ResourceLocation(Modussy.MODID, "chests/floptropica_airport")).build(),
                        LootItemRandomChanceCondition.randomChance(chance).build()
                }, item));
    }
}
