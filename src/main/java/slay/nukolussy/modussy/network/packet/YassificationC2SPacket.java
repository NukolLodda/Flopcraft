package slay.nukolussy.modussy.network.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import slay.nukolussy.modussy.network.yassification.PlayerYassificationProvider;

import java.util.function.Supplier;

public class YassificationC2SPacket {
    public YassificationC2SPacket() {

    }

    public YassificationC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf bug) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Everything in here happens in the server
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel().getLevel();

            // Checks what the player is doing


        });

        return true;
    }
}
