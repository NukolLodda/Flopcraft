package slay.nukolussy.modussy.menu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.world.inventory.JiafeiTrade;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Modussy.MODID);
    public static final RegistryObject<MenuType<JiafeiTrade>> JIAFEI_TRADE = REGISTER.register("jiafei_trade", () -> IForgeMenuType.create(JiafeiTrade::new));
}
