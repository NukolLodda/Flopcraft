package slay.nukolussy.modussy.block.types;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import slay.nukolussy.modussy.entities.ModEntities;
import slay.nukolussy.modussy.entities.flops.AbstractFlops;
import slay.nukolussy.modussy.entities.flops.traders.NickiMinaj;
import slay.nukolussy.modussy.item.ActivateMethods;
import slay.nukolussy.modussy.item.ModItem;
import slay.nukolussy.modussy.sound.ModSounds;

import java.util.Comparator;
import java.util.List;

public class SlaginiumBlock extends MaterialBlocks {
    public SlaginiumBlock() {
        super(Blocks.GOLD_BLOCK, SoundType.METAL);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);
        double x = pPos.getX();
        double y = pPos.getY();
        double z = pPos.getZ();
        if (pEntity instanceof ItemEntity item && item.getItem().is(ModItem.SCARUSSY.get())
           && ActivateMethods.canEntityBecomeNickiMinaj(pLevel, x, y, z)) {
            Player player = null;
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = pLevel.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity iterator : _entfound) {
                    if (iterator instanceof Player _player) {
                        player = _player;
                        break;
                    }
                }
                for (Entity entity : _entfound) {
                    if (entity instanceof LivingEntity living) {
                        ActivateMethods.yassification(living, pLevel, player);
                        if (ActivateMethods.isMonster(living)) {
                            ActivateMethods.monsterEffects(living);
                        }
                        if (living instanceof AbstractFlops) {
                            ActivateMethods.flopEffects(living);
                        }
                    }
                }
            }
            pLevel.destroyBlock(pPos, false, item);

            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, pLevel);
            bolt.moveTo(x, y + 1, z);
            pLevel.addFreshEntity(bolt);

            NickiMinaj minaj = new NickiMinaj(ModEntities.NICKI_MINAJ.get(), pLevel);
            minaj.moveTo(x, y + 1, z);
            minaj.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 3));
            if (player != null) {
                minaj.setTamed(player);
            }
            minaj.playSound(ModSounds.NICKI_MINAJ_SUMMON.get());

            pLevel.addFreshEntity(minaj);
            item.setRemoved(Entity.RemovalReason.DISCARDED);
        }
    }
}
