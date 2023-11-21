package slay.nukolussy.modussy.block.entity.ent;

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

    public static final RegistryObject<BlockEntityType<SpecialYassificationDetectorEntity>> SPECIAL_YASSIFICATION_DETECTOR =
            BLOCK_ENTITIES.register("special_yassification_detector",
                    () -> BlockEntityType.Builder.of(SpecialYassificationDetectorEntity::new,
                            ModBlocks.SPECIAL_YASSIFICATION_DETECTOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<MariahCareyIceBlockEntity>> MARIAH_CAREY_ICE_BLOCK =
            BLOCK_ENTITIES.register("mariah_carey_ice_block",
                    () -> BlockEntityType.Builder.of(MariahCareyIceBlockEntity::new,
                            ModBlocks.MARIAH_CAREY_ICE_BLOCK.get()).build(null));

    public static final RegistryObject<BlockEntityType<YassificationDetectorEntity>> YASSIFICATION_DETECTOR =
            BLOCK_ENTITIES.register("yassification_detector",
                    () -> BlockEntityType.Builder.of(YassificationDetectorEntity::new,
                            ModBlocks.YASSIFICATION_DETECTOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
