package slay.nukolussy.modussy.entities.flops;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.network.PlayMessages;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Collection;

public class CupcakKe extends AbstractFlopFigures {
    public ItemLike item = ModItems.CVMTITPLASM.get();

    public CupcakKe(EntityType<CupcakKe> type, Level world) {
        super(type, world);
    }

    public CupcakKe(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(spawnEntity.getEntity().getType(), level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2d, FOOD_ITEMS, false));
        super.registerGoals();
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getAmbientSound() {
        int randNum = (int) (Math.random() * 10);
        return switch (randNum) {
            case 1 -> ModSounds.CUPCAkKE_1.get();
            case 2 -> ModSounds.CUPCAkKE_2.get();
            case 3 -> ModSounds.CUPCAkKE_3.get();
            case 4 -> ModSounds.CUPCAkKE_4.get();
            case 5 -> ModSounds.CUPCAkKE_5.get();
            case 6 -> ModSounds.CUPCAkKE_6.get();
            case 7 -> ModSounds.CUPCAkKE_7.get();
            case 8 -> ModSounds.CUPCAkKE_8.get();
            case 9 -> ModSounds.CUPCAkKE_9.get();
            default -> ModSounds.CUPCAkKE_10.get();
        };
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        int hurtNum = (int) (Math.random() * 4);
        return switch (hurtNum) {
            case 1 -> ModSounds.CUPCAkKE_HURT1.get();
            case 2 -> ModSounds.CUPCAkKE_HURT2.get();
            case 3 -> ModSounds.CUPCAkKE_HURT3.get();
            default -> ModSounds.CUPCAkKE_HURT4.get();
        };
    }

    @Override
    public SoundEvent getDeathSound() {
        return ModSounds.CUPCAkKE_DEATH.get();
    }

    @Override
    public void baseTick() {
        super.baseTick();
        Level world = this.level();
        int dropChance = (int) (Math.random() * 8400) + 1;
        if (dropChance == 1) {
            if (world.isClientSide()) {
                ItemEntity entityToSpawn = new ItemEntity(world, this.getX(), this.getY(), this.getZ(), new ItemStack(ModItems.CUPCAKE.get()));
                entityToSpawn.setPickUpDelay(10);
                world.addFreshEntity(entityToSpawn);
            }
        }
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
            boolean flag = itemStack.is(ModItems.CVM.get()) || itemStack.is(ModItems.CVMIUM.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItems.CVM.get()) || item.equals(ModItems.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                cupcakkeDuplication(item, this);

                this.playSound(ModSounds.CUPCAkKE_SLURP.get());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    public static Item cupcakkeDrops() {
        int rand = (int) (Math.random() * 69);
        Item cupcakkeDrops;
        if (rand < 1) {
            int discRand = (int) (Math.random() * 26);
            cupcakkeDrops = switch(discRand) {
                case 1 -> ModItems.DISC_C1.get();
                case 2 -> ModItems.DISC_C2.get();
                case 3 -> ModItems.DISC_C3.get();
                case 4 -> ModItems.DISC_C4.get();
                case 5 -> ModItems.DISC_C5.get();
                case 6 -> ModItems.DISC_C6.get();
                case 7 -> ModItems.DISC_C7.get();
                case 8 -> ModItems.DISC_C8.get();
                case 9 -> ModItems.DISC_C9.get();
                case 10 -> ModItems.DISC_C10.get();
                case 11 -> ModItems.DISC_C11.get();
                case 12 -> ModItems.DISC_C12.get();
                case 13 -> ModItems.DISC_C13.get();
                case 14 -> ModItems.DISC_C14.get();
                case 15 -> ModItems.DISC_C15.get();
                case 16 -> ModItems.DISC_C16.get();
                case 17 -> ModItems.DISC_C17.get();
                case 18 -> ModItems.DISC_C18.get();
                case 19 -> ModItems.DISC_C19.get();
                case 20 -> ModItems.DISC_C20.get();
                case 21 -> ModItems.DISC_C21.get();
                case 22 -> ModItems.DISC_C22.get();
                case 23 -> ModItems.DISC_C23.get();
                case 24 -> ModItems.DISC_C24.get();
                case 25 -> ModItems.DISC_C25.get();
                default -> ModItems.DISC_C26.get();
            };
        } else {
            cupcakkeDrops = switch (rand) {
                case 1 -> ModItems.DISC_CUPCAKKE1.get();
                case 2 -> ModItems.DISC_CUPCAKKE2.get();
                case 3 -> ModItems.DISC_CUPCAKKE3.get();
                case 4 -> ModItems.DISC_CUPCAKKE4.get();
                default -> ModItems.CVMTITPLASM.get();
            };
        }
        return cupcakkeDrops;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypeTags.IS_DROWNING)) {
            return false;
        }
        return super.hurt(source, amount);
    }

    public void aiStep() {
        super.aiStep();

        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Level world = this.level();
        for (int i = 0; i < 4; i++) {
            double x0 = x + random.nextFloat();
            double y0 = y + random.nextFloat();
            double z0 = z + random.nextFloat();
            double dx = (random.nextFloat() - 0.5) * 0.5;
            double dy = (random.nextFloat() - 0.5) * 0.5;
            double dz = (random.nextFloat() - 0.5) * 0.5;

            world.addParticle(ParticleTypes.DRAGON_BREATH, x0, y0, z0, dx, dy, dz);
        }
    }

    public static void init() {
    }

    public static boolean canSpawn(EntityType<CupcakKe> entityType, ServerLevelAccessor level, MobSpawnType spawnType,
                                   BlockPos pos, RandomSource randomSource) {
        return Mob.checkMobSpawnRules(entityType, level, spawnType, pos, randomSource);
    }

    public static void cupcakkeDuplication(Item item, CupcakKe cupcakKe) {
        if (cupcakKe.getMaxHealth() == cupcakKe.getHealth()) {
            Collection<MobEffectInstance> inst = cupcakKe.getActiveEffects();
            CupcakKe newMob = new CupcakKe(ModEntities.CUPCAKKE.get(), cupcakKe.level());
            newMob.moveTo(cupcakKe.getX(), cupcakKe.getY(), cupcakKe.getZ());
            newMob.setXRot(cupcakKe.getXRot());
            newMob.setYRot(cupcakKe.getYRot());
            if (item.equals(ModItems.CVM.get())) {
                cupcakKe.hurt(cupcakKe.level().damageSources().freeze(), 10);
            }
            if (cupcakKe.tamedBy != null) {
                newMob.setTamed(cupcakKe.tamedBy);
            }
            for (MobEffectInstance effect : inst) {
                newMob.addEffect(effect);
            }
            cupcakKe.level().addFreshEntity(newMob);
            cupcakKe.spawnAtLocation(cupcakkeDrops());
        }

    }
}
