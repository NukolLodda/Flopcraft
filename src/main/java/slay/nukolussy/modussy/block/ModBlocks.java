package slay.nukolussy.modussy.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.entity.blocks.*;
import slay.nukolussy.modussy.block.fluids.ModFluids;
import slay.nukolussy.modussy.block.plants.JiafeiCrop;
import slay.nukolussy.modussy.block.types.*;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.worldgen.tree.LovelyPeachTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Modussy.MODID);

    public static final RegistryObject<Block> SHENSEIUM_ORE = registerBlock("shenseium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE).strength(5f)
                    .destroyTime(12).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK),
                    UniformInt.of(2,6)));

    public static final RegistryObject<Block> FLOPIUM_BLOCK = registerBlock("flopium_block",
            () -> new MaterialBlocks(Blocks.AMETHYST_BLOCK, SoundType.AMETHYST, 6.5f));

    public static final RegistryObject<Block> GAGASTONE_BLOCK = registerBlock("gagastone_block",
            () -> new MaterialBlocks(7f));

    public static final RegistryObject<Block> GAGINA_BLOCK = registerBlock("gagina_block",
            () -> new MaterialBlocks(7.5f));

    public static final RegistryObject<Block> INFUSED_SLAGINIUM_BLOCK = registerBlock("infused_slaginium_block",
            () -> new MaterialBlocks(Blocks.NETHERITE_BLOCK, SoundType.NETHERITE_BLOCK, 6.5f));

    public static final RegistryObject<Block> MYSTICAL_FLOPIUM_BLOCK = registerBlock("mystical_flopium_block",
            () -> new MaterialBlocks(Blocks.EMERALD_BLOCK, SoundType.STONE, 6f));

    public static final RegistryObject<Block> SHENSEIUM_BLOCK = registerBlock("shenseium_block",
            () -> new MaterialBlocks(Blocks.DIAMOND_BLOCK, SoundType.LODESTONE));

    public static final RegistryObject<Block> SLAGINIUM_BLOCK = registerBlock("slaginium_block", SlaginiumBlock::new);

    public static final RegistryObject<Block> GROWING_JIAFEI = BLOCKS.register("growing_jiafei", JiafeiCrop::new);

    public static final RegistryObject<Block> CVM_INFUSION_ALTER = registerBlock("cvm_infusion_alter", CvmInfusionAlter::new);

    public static final RegistryObject<Block> FLOP_AIRLINE_TICKET_SCANNER = registerBlock("flop_airline_ticket_scanner", FlopAirlineTicketScanner::new);
    public static final RegistryObject<Block> SPECIAL_YASSIFICATION_DETECTOR = registerBlock("special_yassification_detector", SpecialYassificationDetector::new);

    public static final RegistryObject<Block> YASSIFICATION_DETECTOR = registerBlock("yassification_detector", YassificationDetector::new);
    public static final RegistryObject<Block> FLOP_AIRLINE_BLOCK = registerBlock("flop_airline_block", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE).strength(0.8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BARBIE_LANTERN = registerBlock("barbie_lantern", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN).lightLevel(l -> 15).strength(0.3f)));

    public static final RegistryObject<Block> FLOPBUCKS_BLOCK = registerBlock("flopbucks_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> FLOPDONALDS_BLOCK = registerBlock("flopdonalds_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> JIAFEI_EXPRESS_BLOCK = registerBlock("jiafei_express_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> FLOPOTLE_BLOCK = registerBlock("flopotle_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> LANCVM_BLOCK = registerBlock("lancvm_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> RANPAPI_BLOCK = registerBlock("ranpapi_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> AESTHETIC_STORE_BLOCK = registerBlock("aesthetic_store_block", FlopBrandBlock::new);
    public static final RegistryObject<Block> HARDENED_PERIOD_CVM = registerBlock("hardened_period_cvm", HardenedPeriodCvm::new);

    public static final RegistryObject<Block> FLOP_AIRLINE_TELEPORTER = registerBlock("flop_airline_teleporter", FlopAirlineTeleporter::new);
    public static final RegistryObject<Block> PEACHES_STRENGTH = registerBlock("peaches_strength", () ->
            new LovelyPeachesBossBlocks(LovelyPeachesBossBlocks.Type.STRENGTH));

    public static final RegistryObject<Block> PEACHES_REMOVE = registerBlock("peaches_remove", () ->
            new LovelyPeachesBossBlocks(LovelyPeachesBossBlocks.Type.EFFECT_REMOVE));

    public static final RegistryObject<Block> PEACHES_HEALTH = registerBlock("peaches_health", () ->
            new LovelyPeachesBossBlocks(LovelyPeachesBossBlocks.Type.HEALTH));

    public static final RegistryObject<Block> LOVELY_PEACH_SAPLING = registerBlock("lovely_peach_sapling", () ->
            new SaplingBlock(new LovelyPeachTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LOVELY_PEACH_LOG = registerBlock("lovely_peach_log", () ->
        new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> LOVELY_PEACH_LEAVES = registerBlock("lovely_peach_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> LOVELY_PEACH_PLANKS = registerBlock("lovely_peach_planks", ModPlanks::new);

    public static final RegistryObject<Block> LOVELY_PEACH_STAIRS = registerBlock("lovely_peach_stairs", () ->
            new StairBlock(() -> ModBlocks.LOVELY_PEACH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CRIMSON_STAIRS)));

    public static final RegistryObject<Block> LOVELY_PEACH_SLABS = registerBlock("lovely_peach_slabs", () ->
            new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_SLAB)));

    public static final RegistryObject<Block> LOVELY_PEACH_FENCE = registerBlock("lovely_peach_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE)));

    public static final RegistryObject<Block> LOVELY_PEACH_FENCE_GATE = registerBlock("lovely_peach_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> LOVELY_PEACH_DOOR = registerBlock("lovely_peach_door", () ->
            new DoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_DOOR).noOcclusion(), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> LOVELY_PEACH_TRAPDOOR = registerBlock("lovely_peach_trapdoor", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_TRAPDOOR).noOcclusion(), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> LOVELY_PEACH_PRESSURE_PLATE = registerBlock("lovely_peach_pressure_plate", () ->
            new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.CRIMSON_PRESSURE_PLATE), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> LOVELY_PEACH_BUTTON = registerBlock("lovely_peach_button", () ->
            new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_BUTTON),
                    BlockSetType.CRIMSON, 10, true));

    /* Floptropican tree types and biomes
     * Cupcakkian Balsam - Cupcakkia
     * Jiafeian Fir - Jiafeia
     * Potaxie Avocado - Potaxiene
     * Lovely Peach - Contour Vast Minajland
     * Barbie Coconut - New Barbados
     * Floptropican Palm - Everywhere
     *
     * Minecraft wood stuffs:
     * doors, fences, fence gates, planks, logs, all sided logs, stripped logs, stripped all sided logs, stairs, slabs,
     * buttons, pressure plates
     */
    public static final RegistryObject<Block> GIRL_YESS_PUMPKIN = registerBlock("girl_yess_pumpkin", GirlYessPumpkin::new);
    public static final RegistryObject<Block> MARIAH_CAREY_ICE_BLOCK = registerBlock("mariah_carey_ice_block", MariahCareyIceBlock::new);


    public static final RegistryObject<LiquidBlock> CVM_FLUID = BLOCKS.register("cvm_fluid",
            () -> new LiquidBlock(ModFluids.SOURCE_CVM_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> POOSAY_JUICE = BLOCKS.register("poosay_juice",
            () -> new LiquidBlock(ModFluids.SOURCE_POOSAY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
