package slay.nukolussy.modussy.entities.twink;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import slay.nukolussy.modussy.block.fluids.ModFluidTypes;
import slay.nukolussy.modussy.entities.AbstractModEntity;
import slay.nukolussy.modussy.entities.flops.IFlopEntity;
import slay.nukolussy.modussy.item.ModItems;
import slay.nukolussy.modussy.util.EntityMethods;
import slay.nukolussy.modussy.util.PlayerMethods;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractTwink extends AbstractModEntity implements Npc {
    protected static final Ingredient FOOD_ITEMS = Ingredient.of(ModItems.CVM.get(), ModItems.CVMIUM.get());
    protected final SimpleContainer inventory = new SimpleContainer(8);
    public AbstractTwink(EntityType type, Level world) {
        super(type, world);
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        InteractionResult result = super.mobInteract(player, hand);
        ItemStack stack = player.getItemInHand(hand);
        if (!result.consumesAction()) {
            if (stack.getItem().equals(ModItems.CVMIUM.get())) {
                if (this.getHealth() < this.getMaxHealth()) {
                    this.heal(3f);
                }
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                this.gameEvent(GameEvent.EAT, this);
                int x = (int)this.getX();
                int y = (int)this.getY();
                int z = (int)this.getZ();
                final Vec3 center = new Vec3(x, y, z);
                List<AbstractTwink> entities = this.level().getEntitiesOfClass(AbstractTwink.class, new AABB(center, center).inflate(2 / 2d), e -> true).stream()
                        .sorted(Comparator.comparingDouble(entity -> entity.distanceToSqr(center))).toList();
                if (this.random.nextInt(69) == 0 || entities.size() > 0) {
                    this.spawnAtLocation(ModItems.TWINK_EGG.get());
                }
                return InteractionResult.SUCCESS;
            }
        }
        return result;
    }

    @Override
    public void aiStep() {
        BlockPos pos = new BlockPos((int)this.getX(), (int)this.getY(), (int)this.getZ());
        Block block = this.level().getBlockState(pos).getBlock();
        if (block instanceof LiquidBlock liquid) {
            FluidType type = liquid.getFluid().getFluidType();
            if (type.equals(ModFluidTypes.CVM_FLUID.get())) {
                EntityMethods.flopEffects(this);
            } else if (type.equals(ModFluidTypes.POOSAY_JUICE.get()) && this.random.nextInt(3) == 0) {
                EntityMethods.monsterEffects(this);
            }
        }
        super.aiStep();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.getEntity() instanceof Player player && player == this.tamedBy) {
            this.setTamed(null);
        }
        if (pSource.getEntity() != null) {
            alertTwinks(pSource);
        }
        return super.hurt(pSource, pAmount);
    }

    protected void onDie(DamageSource pSource) {
        if (pSource.getEntity() != null) {
            alertTwinks(pSource.getEntity());
        }
    }

    protected void alertTwinks(DamageSource pDamageSource) {
        Entity attacker = pDamageSource.getEntity();
        alertTwinks(attacker);
    }

    public void alertTwinks(Entity attacker) {
        AABB aabb = AABB.unitCubeFromLowerCorner(this.position()).inflate(10d, 10.0d, 10d);
        List<AbstractTwink> list = this.level().getEntitiesOfClass(AbstractTwink.class, aabb, e -> true).stream()
                .sorted(Comparator.comparingDouble(_entcnd ->
                        _entcnd.distanceToSqr(this.getX(), this.getY(), this.getZ()))).toList();
        for (AbstractTwink twink : list) {
            if (attacker instanceof LivingEntity entity) {
                if (entity instanceof Player player) {
                    PlayerMethods.addPlayerYassification(player, -1);
                    if (player.isCreative()) entity = null;
                }
                if (entity != null) twink.setTarget(entity);
            }
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2d, FOOD_ITEMS, false));
        this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Monster.class, 10.0f, 1.2, 1.2));
    }
}
