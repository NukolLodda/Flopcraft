package slay.nukolussy.modussy.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimPattern;
import slay.nukolussy.modussy.Modussy;

public class ModTrimPatterns {
    // note, a bootstrap of sorts needs to be made in order to register the entries in this class
    public static final ResourceKey<TrimPattern> JIAFEI = registryKey("jiafei");

    private static ResourceKey<TrimPattern> registryKey(String pKey) {
        return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation(Modussy.MODID, pKey));
    }
}
