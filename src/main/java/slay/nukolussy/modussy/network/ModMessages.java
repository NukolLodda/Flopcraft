package slay.nukolussy.modussy.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.network.packet.PeriodC2SPacket;
import slay.nukolussy.modussy.network.packet.YassificationC2SPacket;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder.named(
                new ResourceLocation(Modussy.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(YassificationC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(YassificationC2SPacket::new)
                .encoder(YassificationC2SPacket::toBytes)
                .consumerMainThread(YassificationC2SPacket::handle)
                .add();

        net.messageBuilder(PeriodC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PeriodC2SPacket::new)
                .encoder(PeriodC2SPacket::toBytes)
                .consumerMainThread(PeriodC2SPacket::handle)
                .add();
    }

    public static <MSG> void sentToServer(MSG msg) {
        INSTANCE.sendToServer(msg);
    }

    public static <MSG> void sentToPlayer(MSG msg, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }
}
