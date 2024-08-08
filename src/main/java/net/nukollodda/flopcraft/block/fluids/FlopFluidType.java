package net.nukollodda.flopcraft.block.fluids;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.function.Consumer;

public class FlopFluidType extends FluidType {
    private final ResourceLocation stillTexture = ResourceLocation.withDefaultNamespace("block/water_still");
    private final ResourceLocation flowingTexture = ResourceLocation.withDefaultNamespace("block/water_flow");
    private final ResourceLocation overlayTexture = ResourceLocation.withDefaultNamespace("block/water_overlay");
    private final int tintColor;
    private final Vector3f fogColor;

    public FlopFluidType(final int tintColor, final Properties properties) {
        super(properties);
        this.tintColor = tintColor;
        this.fogColor = convertColor(tintColor);
    }

    private Vector3f convertColor(int pColor) {
        int blue = pColor / 0x10000;
        int green = (pColor % 0x10000) / 0x100;
        int red = pColor % 0x100;
        return new Vector3f(blue / 255f, green / 255f, red / 255f);
    }

    public int getTintColor() {
        return tintColor;
    }

    public Vector3f getFogColor() {
        return fogColor;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return stillTexture;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return flowingTexture;
            }

            @Override
            public ResourceLocation getOverlayTexture(FluidStack stack) {
                return overlayTexture;
            }

            @Override
            public int getTintColor() {
                return tintColor;
            }

            @Override
            public @NotNull Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance,
                                                    float darkenWorldAmount, Vector3f fluidFogColor) {
                return fogColor;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick,
                                        float nearDistance, float farDistance, FogShape shape) {
                RenderSystem.setShaderFogStart(1f);
                RenderSystem.setShaderFogEnd(4f);
            }
        });
    }
}
