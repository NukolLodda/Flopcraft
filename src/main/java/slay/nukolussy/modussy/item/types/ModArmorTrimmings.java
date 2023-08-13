package slay.nukolussy.modussy.item.types;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;

public class ModArmorTrimmings extends TrimMaterials {
    public static final ResourceKey<TrimMaterial> JIAFEI = registerKey("jiafei");

    private static ResourceKey<TrimMaterial> registerKey(String loc) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, new ResourceLocation(loc));
    }
}
