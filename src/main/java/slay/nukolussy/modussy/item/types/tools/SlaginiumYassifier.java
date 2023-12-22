package slay.nukolussy.modussy.item.types.tools;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.util.ToolMethods;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SlaginiumYassifier extends TieredItem {
    private final int lvl;
    public SlaginiumYassifier(Tier tier,int dura, int lvl, Rarity rarity) {
        super(tier, new Properties().durability(dura).fireResistant().rarity(rarity));
        this.lvl = lvl;
    }


    @Override
    public float getDestroySpeed(@NotNull ItemStack itemStack, BlockState blockState) {
        blockState.getBlock();
        return 1;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean retval = super.mineBlock(stack, world, state, pos, entity);
        ToolMethods.slayBreak(world, state, pos, entity);
        return retval;
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        itemStack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        ToolMethods.slayAttack(itemStack, sourceentity, entity, this.lvl);
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        ItemStack itemStack = entity.getMainHandItem();
        AtomicInteger itemDura = new AtomicInteger(104);
        int amp = (lvl + 1) / 2;
        entity.playSound(aestheticSounds(lvl + 5));
        if (!entity.level().isClientSide()) {
            entity.displayClientMessage(Component.translatable("subtitle.aesthetic_warning").withStyle(ChatFormatting.LIGHT_PURPLE), true);
            if (lvl > 2) {
                entity.getAbilities().mayfly = (true);
                entity.onUpdateAbilities();
            }
        }
        entity.getCooldowns().addCooldown(itemStack.getItem(), 100 * lvl);
        EntityMethods.flopEffects(entity, lvl, amp);
        if (world.isClientSide()) Minecraft.getInstance().gameRenderer
                .displayItemActivation(switch (entity.getRandom().nextInt(lvl)) {
                    case 1 -> new ItemStack(ModItems.SHENSEIUM.get());
                    case 2 -> new ItemStack(ModItems.JIAFEI_PRODUCT.get());
                    default -> new ItemStack(ModItems.CUPCAKE.get());
        });
        ToolMethods.yassifySurronding(world, entity, 28 * (2 * lvl), lvl, amp);
        if (world instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.SMOKE, x, y, z, 60 / lvl,5,5, 5, 1.0);
            if (lvl > 2) {
                server.setDayTime(getGameDayTick(server) + 6000);
                if (lvl > 3) {
                    server.setWeatherParameters(69000,69,false,false);
                }
            }
        }
        itemStack.setDamageValue(itemStack.getDamageValue() + itemDura.get());

        return ar;
    }

    @Override
    public int getEnchantmentValue() {
        return 2;
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
            builder.put(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 3f * Math.pow(2, lvl), AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED,
                    new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.0f / lvl, AttributeModifier.Operation.ADDITION));
            return builder.build();

        }
        return super.getDefaultAttributeModifiers(equipmentSlot);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
        ItemStack retval = new ItemStack(this);
        retval.setDamageValue(itemstack.getDamageValue() + 1);
        if (retval.getDamageValue() >= retval.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return retval;
    }

    @Override
    public boolean isRepairable(@NotNull ItemStack itemstack) {
        return false;
    }
    private static SoundEvent aestheticSounds(int up) {
        if (up > 8) up = 8;
        return switch (new Random().nextInt( 1, up-1)) {
            case 1 -> ModSounds.AESTHETIC_1.get();
            case 2 -> ModSounds.AESTHETIC_2.get();
            case 3 -> ModSounds.AESTHETIC_3.get();
            case 4 -> ModSounds.AESTHETIC_4.get();
            case 5 -> ModSounds.AESTHETIC_5.get();
            case 6 -> ModSounds.AESTHETIC_SHENSEEA.get();
            default -> ModSounds.AESTHETIC_JIAFEI.get();
        };
    }

    private static ItemStack randItem(int up) {
        if (up > 3) up = 3;
        return switch (new Random().nextInt(up)) {
            case 1 -> new ItemStack(ModItems.SHENSEIUM.get());
            case 2 -> new ItemStack(ModItems.JIAFEI_PRODUCT.get());
            default -> new ItemStack(ModItems.CUPCAKE.get());
        };
    }

    private static long getGameDayTick(ServerLevel level) {
        long time = level.getGameTime() / 24000L;
        if (level.getDayTime() > 6000) {
            time++;
        }
        return time * 24000L;
    }
}
