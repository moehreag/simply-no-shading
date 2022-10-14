package com.github.startsmercury.simply.no.shading.mixin.shading.cloud.minecraft;

import com.github.startsmercury.simply.no.shading.entrypoint.SimplyNoShadingClientMod;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * {@code LevelRenderer} mixin class.
 *
 * @since 5.0.0
 */
@Mixin(WorldRenderer.class)
public class LevelRendererMixin {
	/**
	 * Changes the cloud shade applying.
	 *
	 * @param shade the original shade
	 * @return the modified shade
	 */
	@ModifyConstant(method = "renderFancyClouds",
	                constant = {
	                    @Constant(floatValue = 0.9F, ordinal = 0),
	                    @Constant(floatValue = 0.9F, ordinal = 1),
	                    @Constant(floatValue = 0.9F, ordinal = 2),
	                    @Constant(floatValue = 0.7F, ordinal = 0),
	                    @Constant(floatValue = 0.7F, ordinal = 1),
	                    @Constant(floatValue = 0.7F, ordinal = 2),
	                    @Constant(floatValue = 0.8F, ordinal = 0),
	                    @Constant(floatValue = 0.8F, ordinal = 1),
	                    @Constant(floatValue = 0.8F, ordinal = 2)
					})
	private float changeCloudShade(final float shade) {
		return SimplyNoShadingClientMod.getInstance().config.rules.get(SimplyNoShadingClientMod.getInstance().config.clouds).wouldShade() ? shade : 1.0F;
	}
}
