package slay.nukolussy.modussy.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.entity.CvmInfusionAlter;
import slay.nukolussy.modussy.block.types.MaterialBlocks;
import slay.nukolussy.modussy.block.types.SlaginiumBlock;
import slay.nukolussy.modussy.item.ModItem;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Modussy.MODID);

    public static final RegistryObject<DropExperienceBlock> SHENSEIUM_ORE = registerBlock("shenseium_ore",
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

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
