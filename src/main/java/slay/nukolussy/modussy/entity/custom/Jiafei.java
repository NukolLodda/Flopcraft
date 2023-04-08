package slay.nukolussy.modussy.entity.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import slay.nukolussy.modussy.entity.ModEntities;
import slay.nukolussy.modussy.entity.goal.FlopBreedingGoal;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Random;

public class Jiafei extends FlopFigures {
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItem.JIAFEI_PRODUCT.get(), ModItem.SLAGINIUM.get(), ModItem.INFUSED_SLAGINIUM.get(), ModItem.FLOPIUM.get(), ModItem.MYSTICAL_FLOPIUM.get());
    private SoundEvent jiafeiEat() {
        Random rand = new Random();
        int randVal = rand.nextInt(0,3);
        if (randVal == 0) {
            return ModSounds.JIAFEI_EAT_1.get();
        } else if (randVal == 1) {
            return ModSounds.JIAFEI_EAT_2.get();
        }
        return ModSounds.JIAFEI_EAT_3.get();
    }
    public Jiafei(PlayMessages.SpawnEntity packet, Level world) {
        this(ModEntities.JIAFEI.get(), world);
        this.setCanPickUpLoot(true);
        this.applyOpenDoorsAbility();
    }

    public Jiafei(EntityType<Jiafei> type, Level world) {
        super(type, world);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(10, new FlopBreedingGoal(this, 1.0d));
        this.goalSelector.addGoal(11, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        Random random = new Random();
        int randNum = random.nextInt(1,4);
        String sound = "modussy:jiafei_3";
        if (randNum == 1) sound = "modussy:jiafei_1";
        if (randNum == 2) sound = "modussy:jiafei_2";
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(sound));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:jiafei_hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        Random random = new Random();
        int dedNum = random.nextInt(1,3);
        String deathSound = "modussy:jiafei_death_2";
        if (dedNum == 1) deathSound = "modussy:jiafei_death_1";
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(deathSound));
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level.isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level.isClientSide) {
            boolean flag = itemStack.is(ModItem.JIAFEI_PRODUCT.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItem.JIAFEI_PRODUCT.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                this.playSound(jiafeiEat());
                this.setInLove(player);
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof AbstractArrow || source == DamageSource.FALL || source == DamageSource.CACTUS ||
                source == DamageSource.LIGHTNING_BOLT || source.isExplosion() || source.getMsgId().equals("trident") ||
                source == DamageSource.ANVIL || source == DamageSource.DRAGON_BREATH || source.isFire())
            return false;
        return super.hurt(source, amount);
    }

    public void aiStep() {
        super.aiStep();
    }

    public static void init() {
        SpawnPlacements.register(ModEntities.JIAFEI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (entityType, world, reason, pos, random) ->
                        (world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8));
    }
}