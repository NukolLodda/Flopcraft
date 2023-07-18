package slay.nukolussy.modussy.entities.flops;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.item.ActivateMethods;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Collection;

public class CupcakKe extends AbstractFlopFigures {
    public ItemLike item = ModItem.CVMTITPLASM.get();

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
        int hurtNum = (int) (Math.random() * 10 + 1);
        String hurtSound = "modussy:cupcakke_" + hurtNum;

        return ForgeRegistries.SOUND_EVENTS.getValue((new ResourceLocation(hurtSound)));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        int hurtNum = (int) (Math.random() * 4 + 1);
        String hurtSound = "modussy:cupcakke_hurt" + hurtNum;
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(hurtSound));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("modussy:cupcakke_death"));
    }

    @Override
    public void baseTick() {
        super.baseTick();
        ActivateMethods.cupcakkeDrops(this.level(), this.getX(), this.getY(), this.getZ());
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level().isClientSide);

        super.mobInteract(player, hand);
        Item item = itemStack.getItem();

        if (this.level().isClientSide) {
            boolean flag = itemStack.is(ModItem.CVM.get()) || itemStack.is(ModItem.CVMIUM.get());
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (item.equals(ModItem.CVM.get()) || item.equals(ModItem.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                if (this.getMaxHealth() == this.getHealth()) {
                    Collection<MobEffectInstance> inst = this.getActiveEffects();
                    Mob newMob = new CupcakKe(ModEntities.CUPCAKKE.get(), this.level());
                    newMob.moveTo(this.getX(), this.getY(), this.getZ());
                    newMob.setXRot(this.getXRot());
                    newMob.setYRot(this.getYRot());
                    if (item == ModItem.CVM.get()) {
                        this.hurt(this.level().damageSources().freeze(), 10);
                    }
                    for (MobEffectInstance effect : inst) {
                        newMob.addEffect(effect);
                    }
                    this.level().addFreshEntity(newMob);
                    this.spawnAtLocation(cupcakkeDrops());
                }

                this.playSound(ModSounds.CUPCAkKE_SLURP.get());
                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    public static Item cupcakkeDrops() {
        int rand = (int) (Math.random() * 69);
        Item cupcakkeDrops = ModItem.CVMTITPLASM.get();
        if (rand < 1) {
            int discRand = (int) (Math.random() * 25);
            cupcakkeDrops = switch(discRand) {
                case 1 -> ModItem.DISC_C1.get();
                case 2 -> ModItem.DISC_C2.get();
                case 3 -> ModItem.DISC_C3.get();
                case 4 -> ModItem.DISC_C4.get();
                case 5 -> ModItem.DISC_C5.get();
                case 6 -> ModItem.DISC_C6.get();
                case 7 -> ModItem.DISC_C7.get();
                case 8 -> ModItem.DISC_C8.get();
                case 9 -> ModItem.DISC_C9.get();
                case 10 -> ModItem.DISC_C10.get();
                case 11 -> ModItem.DISC_C11.get();
                case 12 -> ModItem.DISC_C12.get();
                case 13 -> ModItem.DISC_C13.get();
                case 14 -> ModItem.DISC_C14.get();
                case 15 -> ModItem.DISC_C15.get();
                case 17 -> ModItem.DISC_C17.get();
                case 18 -> ModItem.DISC_C18.get();
                case 19 -> ModItem.DISC_C19.get();
                case 20 -> ModItem.DISC_C20.get();
                case 21 -> ModItem.DISC_C21.get();
                case 22 -> ModItem.DISC_C22.get();
                case 23 -> ModItem.DISC_C23.get();
                case 24 -> ModItem.DISC_C24.get();
                default -> ModItem.DISC_C25.get();
            };
        } else if (rand < 2) {
            cupcakkeDrops = ModItem.DISC_CUPCAKKE1.get();
        } else if (rand < 3) {
            cupcakkeDrops = ModItem.DISC_CUPCAKKE2.get();
        } else if (rand < 7) {
            cupcakkeDrops = ModItem.DISC_CUPCAKKE3.get();
        }
        return cupcakkeDrops;

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
}
