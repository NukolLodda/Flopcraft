package slay.nukolussy.modussy.entities.flops.traders;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import slay.nukolussy.modussy.entities.goal.FlopBreedingGoal;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Random;

public class Jiafei extends AbstractFlopTraders {
    private static final Ingredient FOOD_ITEMS = Ingredient.of(
            ModItem.JIAFEI_PRODUCT.get(), ModItem.SLAGINIUM.get(), ModItem.INFUSED_SLAGINIUM.get(), ModItem.FLOPIUM.get(), ModItem.MYSTICAL_FLOPIUM.get());

    public Jiafei(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    public Jiafei(EntityType<Jiafei> type, Level world) {
        super(type, world);
    }

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
        int hurtNum = (int) (Math.random() * 3 + 1);
        String sound = "modussy:jiafei_" + hurtNum;
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(sound));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:jiafei_hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        int dedNum = (int) (Math.random() * 2 + 1);
        String deathSound = "modussy:jiafei_death_" + dedNum;
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(deathSound));
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
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
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        MerchantOffers offers = this.getOffers();
        tag.put("Offers", offers.createTag());

        this.writeInventoryToTag(tag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.offers = new MerchantOffers(tag.getCompound("Offers"));

        this.readInventoryFromTag(tag);
    }

    public void aiStep() {
        super.aiStep();
    }

    public static void init() {
        // mob should spawn under certain circumstance
    }

    @Override
    public SimpleContainer getInventory() {
        return super.getInventory();
    }

    @Override
    public MerchantOffers getOffers() {
        return offers;
    }

    @Override
    public void overrideOffers(MerchantOffers pOffers) {

    }

    @Override
    public void notifyTrade(MerchantOffer pOffer) {

    }

    @Override
    public void notifyTradeUpdated(ItemStack pStack) {

    }

    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int pXp) {

    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return null;
    }

    @Override
    public boolean isClientSide() {
        return false;
    }
}