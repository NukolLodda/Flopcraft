package net.nukollodda.flopcraft.block;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.nukollodda.flopcraft.Flopcraft;

public class FlopWoodTypes {
    public static final WoodType LOVELY_PEACH = WoodType.register(new WoodType(Flopcraft.MODID + ":lovely_peach", BlockSetType.CRIMSON));
    public static final WoodType JIAFEIAN_FIR = WoodType.register(new WoodType(Flopcraft.MODID + ":jiafeian_fir", BlockSetType.WARPED));
    public static final WoodType KAMALOCONUT_PALM = WoodType.register(new WoodType(Flopcraft.MODID + ":kamaloconut_palm", BlockSetType.JUNGLE));
    // possibly some more wood types like cupcakkian mangrove or arbole de aguacate potaxie
}
