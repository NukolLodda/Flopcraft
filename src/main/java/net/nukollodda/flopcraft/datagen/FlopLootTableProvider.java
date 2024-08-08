package net.nukollodda.flopcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.nukollodda.flopcraft.datagen.loot.FlopLootTablesProvider;

import java.util.List;
import java.util.Set;

public class FlopLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(FlopLootTablesProvider::new, LootContextParamSets.BLOCK)
        ));
    }
}
