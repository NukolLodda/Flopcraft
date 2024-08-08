package net.nukollodda.flopcraft.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nukollodda.flopcraft.Flopcraft;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Flopcraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();
        boolean includeServer = event.includeServer();

        FlopBlockTagProvider blockTagGenerator = generator.addProvider(includeServer,
                new FlopBlockTagProvider(output, lookup, fileHelper));

        generator.addProvider(includeServer,
                new FlopItemTagGenerator(output, lookup, blockTagGenerator.contentsGetter(), fileHelper));

        generator.addProvider(includeServer, new FlopRecipeProvider(output));

        generator.addProvider(includeServer, new FlopBlockStateProvider(output, fileHelper));
        generator.addProvider(includeServer, new FlopItemModelProvider(output, fileHelper));

        generator.addProvider(includeServer, new FlopWorldGenProvider(output, lookup));
        generator.addProvider(includeServer, new FlopGlobalLootModifiersProvider(output));

        // generator.addProvider(includeServer, ModLootTableProvider.create(output));
    }
}
