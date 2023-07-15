package slay.nukolussy.modussy.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public final class EntityTypeTags {
    private static TagKey<EntityType<?>> create(String location) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(location));
    }
}
