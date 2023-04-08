package slay.nukolussy.modussy;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;
import slay.nukolussy.modussy.block.ModBlocks;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.particles.ModParticleTypes;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.world.feature.ModConfiguredFeatures;
import slay.nukolussy.modussy.world.feature.ModPlacedFeatures;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod(Modussy.MODID)
public class Modussy {
    public static final String MODID = "modussy";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Modussy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItem.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);
        ModParticleTypes.REGISTER.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID = 0;
    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
                                             BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();

    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry<>(action,tick));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GROWING_JIAFEI.get(), RenderType.cutout());
        }
    }
}
