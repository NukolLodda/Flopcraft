package slay.nukolussy.modussy.item.types;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.armortrim.TrimPatterns;

public class ModTrims extends TrimPatterns {
    public static final ResourceKey<TrimPattern> JIAFEI = registryKey("jiafei");

    private static ResourceKey<TrimPattern> registryKey(String pKey) {
        return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation("modussy", pKey));
    }
}
