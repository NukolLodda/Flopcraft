package slay.nukolussy.modussy.entities.flops;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slay.nukolussy.modussy.entities.flops.traders.Ranvision;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.ModUtil;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public abstract class AbstractFlopFigures extends AbstractFlops {
    private ArrayList<UUID> uuids;
    public AbstractFlopFigures(EntityType type, Level world) {
        super(type, world);

        Random random = new Random();
        int toolChance = random.nextInt(1, 6971);
        if (toolChance <= 420) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SLAGINIUM_YASSIFIER.get()));
        } else if (toolChance <= 500) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SLAGINIUM_YASSIFIER_PLUS.get()));
        } else if (toolChance <= 569) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SLAGINIUM_YASSIFIER_PREMIUM.get()));
        } else if (toolChance <= 571) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SLAGINIUM_YASSIFIER_DELUXE.get()));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 40);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 9);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 2);

        return builder;
    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);
        super.mobInteract(pPlayer, pHand);
        if (this.level().isClientSide) {
            return InteractionResult.PASS;
        } else {
            if (this.uuids == null) this.uuids = new ArrayList<>();
            if (ModUtil.isClitmas()) {
                for (UUID uuid : this.uuids) {
                    if (!uuid.equals(pPlayer.getUUID())) {
                        int max = 3;
                        if (PlayerMethods.isFlop(pPlayer)) {
                            max++;
                            if (PlayerMethods.isMagicFlop(pPlayer)) {
                                max++;
                                if (PlayerMethods.isFlopIcon(pPlayer)) {
                                    max++;
                                }
                            }
                        }
                        int rand = this.random.nextInt(max);
                        pPlayer.spawnAtLocation(new ItemStack(ModItems.CLITMAS_PRESENT.get(), rand));
                        if (this instanceof Ranvision) {
                            pPlayer.spawnAtLocation(new ItemStack(ModItems.REMIX_PRESENT.get(), rand));
                        }
                    }
                }
                this.uuids.add(pPlayer.getUUID());
            } else if (!this.uuids.isEmpty()) {
                uuids.clear();
            }
        }
        return result;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        onHurt(source);
        if (source.is(DamageTypeTags.IS_FIRE) || source.is(DamageTypeTags.IS_LIGHTNING) || source.is(DamageTypeTags.IS_FALL)
                || source.is(DamageTypeTags.IS_PROJECTILE) || source.is(DamageTypeTags.IS_EXPLOSION) || source.equals(this.damageSources().dragonBreath())
        || source.equals(this.damageSources().anvil(this))) {
            return false;
        }
        // they can't hit with a trident
        return super.hurt(source, amount);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class,
                0, false, false, ent -> ent.attackable() && (ent instanceof AbstractIllager)));
    }

    @Override
    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }

    public boolean canBeLeashed(Player pPlayer) {
        return false;
    }

    @Nullable
    @Override
    protected abstract SoundEvent getHurtSound(DamageSource pDamageSource);

    @Nullable
    @Override
    protected abstract SoundEvent getDeathSound();

    @Nullable
    @Override
    protected abstract SoundEvent getAmbientSound();
}