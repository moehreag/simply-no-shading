package com.github.startsmercury.simply.no.shading.mixin.shading.block.minecraft;

import com.github.startsmercury.simply.no.shading.config.ShadingRule;
import com.github.startsmercury.simply.no.shading.entrypoint.SimplyNoShadingClientMod;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.block.BlockModelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Changes the light of blocks because there is no shading here.
 */

@Mixin(BlockModelRenderer.class)
public abstract class BlockModelRendererMixin {

    private final ShadingRule shadingRule = SimplyNoShadingClientMod.getInstance().config.rules.get(SimplyNoShadingClientMod.getInstance().config.blocks);
    int fullLight = 15728870; //15728880 is the max value

    @Redirect(method = "renderQuadsSmooth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/BufferBuilder;method_9735(IIII)V"))
    private void noShadeBlocks(BufferBuilder instance, int i, int j, int k, int l){
        if(shadingRule.wouldShade()){
            instance.method_9735(i, j, k, l);
        } else {
            instance.method_9735(fullLight, fullLight, fullLight, fullLight);
        }
    }
}
