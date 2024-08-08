package net.nukollodda.flopcraft.item.types.tools;

import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.nukollodda.flopcraft.item.FlopItems;
import net.nukollodda.flopcraft.util.ToolMethods;

import java.util.List;

public class RanpapiTablet extends Item {
    public RanpapiTablet() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        CompoundTag tag = pStack.getOrCreateTag();
        int val = tag.getInt("disc");
        String name = switch (val) {
            case 1 -> "c1";
            case 2 -> "c4";
            case 3 -> "c5";
            case 4 -> "c6";
            case 5 -> "c7";
            case 6 -> "c9";
            case 7 -> "c10";
            case 8 -> "c11";
            case 9 -> "c14";
            case 10 -> "c17";
            case 11 -> "c18";
            case 12 -> "c23";
            case 13 -> "c24";
            case 14 -> "c28";
            case 15 -> "cj1";
            case 16 -> "cpm1";
            case 17 -> "j2";
            case 18 -> "j3";
            case 19 -> "j5";
            case 20 -> "j6";
            case 21 -> "pm1";
            default -> "ranvision";
        };
        ChatFormatting format = ChatFormatting.GOLD;
        if (name.startsWith("cpm")) {
            format = ChatFormatting.DARK_PURPLE;
        } else if (name.startsWith("pm")) {
            format = ChatFormatting.BLUE;
        } else if (name.charAt(0) == 'c') {
            format = ChatFormatting.LIGHT_PURPLE;
        } else if (name.charAt(0) == 'j') {
            format = ChatFormatting.DARK_RED;
        }
        pTooltipComponents.add(Component.translatable("subtitle.play_sound").append(":").withStyle(ChatFormatting.GRAY));
        pTooltipComponents.add(Component.translatable("item.flopcraft.music_disc_" + name + ".desc").withStyle(format));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        CompoundTag tag = item.getOrCreateTag();
        int val = tag.getInt("disc");
        RecordItem discItem = (RecordItem) switch (val) {
            case 1 -> FlopItems.DISC_C1.get();
            case 2 -> FlopItems.DISC_C4.get();
            case 3 -> FlopItems.DISC_C5.get();
            case 4 -> FlopItems.DISC_C6.get();
            case 5 -> FlopItems.DISC_C7.get();
            case 6 -> FlopItems.DISC_C9.get();
            case 7 -> FlopItems.DISC_C10.get();
            case 8 -> FlopItems.DISC_C11.get();
            case 9 -> FlopItems.DISC_C14.get();
            case 10 -> FlopItems.DISC_C17.get();
            case 11 -> FlopItems.DISC_C18.get();
            case 12 -> FlopItems.DISC_C23.get();
            case 13 -> FlopItems.DISC_C24.get();
            case 14 -> FlopItems.DISC_C28.get();
            case 15 -> FlopItems.DISC_CJ1.get();
            case 16 -> FlopItems.DISC_CPM1.get();
            case 17 -> FlopItems.DISC_J2.get();
            case 18 -> FlopItems.DISC_J3.get();
            case 19 -> FlopItems.DISC_J5.get();
            case 20 -> FlopItems.DISC_J6.get();
            case 21 -> FlopItems.DISC_PM1.get();
            default -> FlopItems.DISC_RANVISION.get();
        };
        // temp solution, needs to make this a broadcasted event
        pLevel.playSound(pPlayer, pPlayer.blockPosition(), discItem.getSound(), SoundSource.MASTER);
        //
        pPlayer.displayClientMessage(Component.translatable("subtitle.currently_playing").append(": ")
                .append(discItem.getDisplayName()).withStyle(ChatFormatting.GOLD), true);
        pPlayer.getCooldowns().addCooldown(item.getItem(), discItem.getLengthInTicks());
        tag.putInt("disc", pPlayer.getRandom().nextInt(22));
        ToolMethods.yassifySurronding(pLevel, pPlayer, 15, 1, 1);
        pLevel.addParticle(ParticleTypes.DRIPPING_LAVA, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), 1d, 1d, 1d);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        ToolMethods.slayAttack(itemStack, sourceentity, entity, 1);
        return true;
    }
}
