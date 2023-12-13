package slay.nukolussy.modussy.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraftforge.network.NetworkEvent;
import slay.nukolussy.modussy.effect.ModEffects;

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
            ServerPlayer player = context.getSender();
            if (player != null) {
                ServerLevel level = player.serverLevel().getLevel();
                player.addEffect(new MobEffectInstance(ModEffects.YASSIFIED.get(), 1));
            }
        });
        return true;
    }
}
