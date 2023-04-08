package slay.nukolussy.modussy.tabs;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.item.ModItem;

public class ModCreativeTabs {

    public static final CreativeModeTab PAPIBLOCKS = new CreativeModeTab("papiblocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.SHENSEIUM_ORE.get());
        }
    };

    public static final CreativeModeTab CVMSUMABLES = new CreativeModeTab("cvmsumables") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItem.CUPCAKE.get());
        }
    };

    public static final CreativeModeTab SLAY_TOOLS = new CreativeModeTab("slay_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItem.ARANA_GRANDE.get());
        }
    };

    public static final CreativeModeTab YASS_DISCS = new CreativeModeTab("yass_discs") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItem.SEE_TINH.get());
        }
    };

    public static final CreativeModeTab YASSIFYING_INGREDIENTS = new CreativeModeTab("yassifying_ingredients") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItem.CVMTITPLASM.get());
        }
    };
}
