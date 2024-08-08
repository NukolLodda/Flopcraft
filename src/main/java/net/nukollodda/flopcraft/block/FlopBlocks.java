package net.nukollodda.flopcraft.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.entity.blocks.*;
import net.nukollodda.flopcraft.block.plants.JiafeiCrop;
import net.nukollodda.flopcraft.block.types.*;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.worldgen.tree.KamaloconutPalmTreeGrower;
import net.nukollodda.flopcraft.worldgen.tree.LovelyPeachTreeGrower;

import java.util.function.Supplier;

public class FlopBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Flopcraft.MODID);

    public static final RegistryObject<Block> SHENSEIUM_ORE = registerBlock("shenseium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,6), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE).strength(5f)
                    .destroyTime(12).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)
            ));

    public static final RegistryObject<Block> BRAT_ORE = registerBlock("brat_ore",
            () -> new DropExperienceBlock(UniformInt.of(1,3), 
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).strength(3f)
                    .destroyTime(8).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_BRAT_ORE = registerBlock("deepslate_brat_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE).strength(5f)
                    .destroyTime(12).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> BRAT_BLOCK = registerBlock("brat_block", BratBlock::new);

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
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE).strength(0.8f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BARBIE_LANTERN = registerBlock("barbie_lantern", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SEA_LANTERN).lightLevel(l -> 15).strength(0.3f)));

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
            new SaplingBlock(new LovelyPeachTreeGrower(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LOVELY_PEACH_LOG = registerBlock("lovely_peach_log", () ->
        new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> LOVELY_PEACH_LEAVES = registerBlock("lovely_peach_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                protected boolean decaying(BlockState pState) {
                    return false;
                }
    });

    public static final RegistryObject<Block> LOVELY_PEACH_PLANKS = registerBlock("lovely_peach_planks", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));

    public static final RegistryObject<Block> LOVELY_PEACH_STAIRS = registerBlock("lovely_peach_stairs", () ->
            new StairBlock(() -> FlopBlocks.LOVELY_PEACH_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)));

    public static final RegistryObject<Block> LOVELY_PEACH_SLABS = registerBlock("lovely_peach_slabs", () ->
            new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)));

    public static final RegistryObject<Block> LOVELY_PEACH_FENCE = registerBlock("lovely_peach_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)));

    public static final RegistryObject<Block> LOVELY_PEACH_FENCE_GATE = registerBlock("lovely_peach_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> LOVELY_PEACH_DOOR = registerBlock("lovely_peach_door", () ->
            new DoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR).noOcclusion(), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> LOVELY_PEACH_TRAPDOOR = registerBlock("lovely_peach_trapdoor", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_TRAPDOOR).noOcclusion(), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> LOVELY_PEACH_PRESSURE_PLATE = registerBlock("lovely_peach_pressure_plate", () ->
            new FlopPlates(Blocks.CRIMSON_PRESSURE_PLATE, BlockSetType.CRIMSON));

    public static final RegistryObject<Block> LOVELY_PEACH_BUTTON = registerBlock("lovely_peach_button", () ->
            new ButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_BUTTON),
                    BlockSetType.CRIMSON, 10, true));

    public static final RegistryObject<Block> LOVELY_PEACH_SIGN = BLOCKS.register("lovely_peach_sign", () ->
            new FlopStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN), ModWoodTypes.LOVELY_PEACH));

    public static final RegistryObject<Block> LOVELY_PEACH_WALL_SIGN = BLOCKS.register("lovely_peach_wall_sign", () ->
            new FlopWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN), FlopWoodTypes.LOVELY_PEACH));

    public static final RegistryObject<Block> LOVELY_PEACH_HANGING_SIGN = BLOCKS.register("lovely_peach_hanging_sign", () ->
            new FlopHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN), FlopWoodTypes.LOVELY_PEACH));

    public static final RegistryObject<Block> LOVELY_PEACH_WALL_HANGING_SIGN = BLOCKS.register("lovely_peach_wall_hanging_sign", () ->
            new FlopWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN), FlopWoodTypes.LOVELY_PEACH));


    public static final RegistryObject<Block> KAMALOCONUT_PALM_SAPLING = registerBlock("kamaloconut_palm_sapling", () ->
            new SaplingBlock(new KamaloconutPalmTreeGrower(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_LOG = registerBlock("kamaloconut_palm_log", () ->
            new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> KAMALOCONUT_PALM_LEAVES = registerBlock("kamaloconut_palm_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                protected boolean decaying(BlockState pState) {
                    return false;
                }
            });

    public static final RegistryObject<Block> KAMALOCONUT_PALM_PLANKS = registerBlock("kamaloconut_palm_planks", () ->
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_STAIRS = registerBlock("kamaloconut_palm_stairs", () ->
            new StairBlock(() -> FlopBlocks.KAMALOCONUT_PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_STAIRS)));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_SLABS = registerBlock("kamaloconut_palm_slabs", () ->
            new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SLAB)));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_FENCE = registerBlock("kamaloconut_palm_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE)));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_FENCE_GATE = registerBlock("kamaloconut_palm_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_DOOR = registerBlock("kamaloconut_palm_door", () ->
            new DoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR).noOcclusion(), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_TRAPDOOR = registerBlock("kamaloconut_palm_trapdoor", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_TRAPDOOR).noOcclusion(), BlockSetType.CRIMSON));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_PRESSURE_PLATE = registerBlock("kamaloconut_palm_pressure_plate", () ->
            new FlopPlates(Blocks.CRIMSON_PRESSURE_PLATE, BlockSetType.CRIMSON));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_BUTTON = registerBlock("kamaloconut_palm_button", () ->
            new ButtonBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_BUTTON),
                    BlockSetType.CRIMSON, 10, true));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_SIGN = BLOCKS.register("kamaloconut_palm_sign", () ->
            new FlopStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_SIGN), FlopWoodTypes.KAMALOCONUT_PALM));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_WALL_SIGN = BLOCKS.register("kamaloconut_palm_wall_sign", () ->
            new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_SIGN), ModWoodTypes.KAMALOCONUT_PALM));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_HANGING_SIGN = BLOCKS.register("kamaloconut_palm_hanging_sign", () ->
            new FlopHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HANGING_SIGN), ModWoodTypes.KAMALOCONUT_PALM));

    public static final RegistryObject<Block> KAMALOCONUT_PALM_WALL_HANGING_SIGN = BLOCKS.register("kamaloconut_palm_wall_hanging_sign", () ->
            new FlopWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_WALL_HANGING_SIGN), ModWoodTypes.KAMALOCONUT_PALM));
    /* Floptropican tree types and biomes
     * Cupcakkian Balsam
     * Jiafeian Fir
     * Potaxie Avocado
     * Lovely Peach
     * Kamaloconut Palm
     *
     * Minecraft wood stuffs:
     * doors, fences, fence gates, planks, logs, all sided logs, stripped logs, stripped all sided logs, stairs, slabs,
     * buttons, pressure plates
     */
    public static final RegistryObject<Block> GIRL_YESS_PUMPKIN = registerBlock("girl_yess_pumpkin", GirlYessPumpkin::new);
    public static final RegistryObject<Block> MARIAH_CAREY_ICE_BLOCK = registerBlock("mariah_carey_ice_block", MariahCareyIceBlock::new);


    public static final RegistryObject<LiquidBlock> CVM_FLUID = BLOCKS.register("cvm_fluid",
            () -> new LiquidBlock(ModFluids.SOURCE_CVM_FLUID, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> POOSAY_JUICE = BLOCKS.register("poosay_juice",
            () -> new LiquidBlock(ModFluids.SOURCE_POOSAY_JUICE, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

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
