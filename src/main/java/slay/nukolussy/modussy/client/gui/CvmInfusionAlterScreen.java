package slay.nukolussy.modussy.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import slay.nukolussy.modussy.Modussy;
import slay.nukolussy.modussy.client.menu.CvmInfusionAlterMenu;

public class CvmInfusionAlterScreen extends AbstractContainerScreen<CvmInfusionAlterMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Modussy.MODID, "textures/screens/cvm_infusion_alter_gui.png");

    public CvmInfusionAlterScreen(CvmInfusionAlterMenu menu, Inventory inv, Component component) {
        super(menu, inv, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partTick, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);

        renderProgressArrow(graphics, x, y);
        renderCvmArrow(graphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics graphics, int x, int y) {
        if (this.menu.isCrafting()) {
            int progress = this.menu.getScaledProgress();
            graphics.blit(TEXTURE, x + 90, y + 36, 176, 0, progress, 14);
        }
    }

    private void renderCvmArrow(GuiGraphics graphics, int x, int y) {
        int progress = this.menu.getCvmAmount();
        graphics.blit(TEXTURE, x + 92, y + 58, 176, 14,  progress, 14);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, delta);
        renderTooltip(graphics, mouseX, mouseY);
    }
}
