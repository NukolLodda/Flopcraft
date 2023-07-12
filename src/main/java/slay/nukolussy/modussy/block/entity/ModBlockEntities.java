package slay.nukolussy.modussy.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Modussy.MODID);

    public static final RegistryObject<BlockEntityType<CvmInfusionAlterEntity>> CVM_INFUSION_ALTER =
                BLOCK_ENTITIES.register("cvm_infusion_alter",
                        () -> BlockEntityType.Builder.of(CvmInfusionAlterEntity::new,
                                ModBlocks.CVM_INFUSION_ALTER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
