package net.nukollodda.flopcraft.block.entity.ent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.flopcraft.Flopcraft;
import net.nukollodda.flopcraft.block.ModBlocks;

public class FlopBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Flopcraft.MODID);

    public static final RegistryObject<BlockEntityType<CvmInfusionAlterEntity>> CVM_INFUSION_ALTER =
                BLOCK_ENTITIES.register("cvm_infusion_alter",
                        () -> BlockEntityType.Builder.of(CvmInfusionAlterEntity::new,
                                ModBlocks.CVM_INFUSION_ALTER.get()).build(null));

    public static final RegistryObject<BlockEntityType<BratBlockEntity>> BRAT_BLOCK =
            BLOCK_ENTITIES.register("brat_block",
                    () -> BlockEntityType.Builder.of(BratBlockEntity::new,
                            ModBlocks.BRAT_BLOCK.get()).build(null));

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

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign",
                    () -> BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.LOVELY_PEACH_SIGN.get(), ModBlocks.LOVELY_PEACH_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<FlopHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign",
                    () -> BlockEntityType.Builder.of(FlopHangingSignBlockEntity::new,
                            ModBlocks.LOVELY_PEACH_HANGING_SIGN.get(), ModBlocks.LOVELY_PEACH_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
