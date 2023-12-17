package slay.nukolussy.modussy.item.types.tools;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
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
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;
import slay.nukolussy.modussy.util.ToolMethods;

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
        entity.playSound(ToolMethods.aestheticSounds(lvl + 5));
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
        {
            final Vec3 center = new Vec3(x, y, z);
            world.getEntitiesOfClass(LivingEntity.class, new AABB(center, center)
                    .inflate(28 + (4 * lvl) / 2d), e -> true).stream().toList().forEach(ent -> {
                if (ent instanceof Spider spider) {
                    spider.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ARANA_GRANDE.get()));
                    spider.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                    PlayerMethods.addPlayerYassification(entity, 1);
                    spider.kill();
                }
                if (ent instanceof Slime slime) {
                    ItemStack cvmItem = new ItemStack(ModItems.CVM.get());
                    if (slime instanceof MagmaCube) {
                        cvmItem = new ItemStack(ModItems.CVMIUM.get());
                    }
                    slime.setItemSlot(EquipmentSlot.MAINHAND, cvmItem);
                    slime.setGuaranteedDrop(EquipmentSlot.MAINHAND);
                    PlayerMethods.addPlayerYassification(entity, 1);
                    slime.kill();
                }
                ToolMethods.yassification(ent, world, entity);
                if (ent instanceof Villager || ent instanceof Witch) itemDura.addAndGet(10);
                if (ent instanceof Cat cat && entity.getRandom().nextInt(25) < 4) {
                    cat.spawnAtLocation(ModItems.POSEI.get());
                    PlayerMethods.addPlayerYassification(entity, 1);
                }
                EntityMethods.addEffects(ent, lvl, amp);
            });
        }
        if (world instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.SMOKE, x, y, z, 60 / lvl,5,5, 5, 1.0);
            if (lvl > 2) {
                server.setDayTime(ToolMethods.getGameDayTick(server) + 6000);
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
}
