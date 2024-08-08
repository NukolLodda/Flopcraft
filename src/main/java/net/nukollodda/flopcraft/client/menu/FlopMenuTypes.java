package net.nukollodda.flopcraft.client.menu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nukollodda.flopcraft.Flopcraft;

public class FlopMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, Flopcraft.MODID);

    public static final RegistryObject<MenuType<CvmInfusionAlterMenu>> CVM_INFUSION_ALTER_MENU =
            registerMenuType(CvmInfusionAlterMenu::new, "cvm_infusion_alter_menu");

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>>
    registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
