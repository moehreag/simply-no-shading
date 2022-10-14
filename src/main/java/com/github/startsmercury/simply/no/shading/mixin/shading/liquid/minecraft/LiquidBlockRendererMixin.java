package com.github.startsmercury.simply.no.shading.mixin.shading.liquid.minecraft;

import com.github.startsmercury.simply.no.shading.entrypoint.SimplyNoShadingClientMod;
import net.minecraft.client.render.block.FluidRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * {@code LiquidBlockRenderer} mixin class.
 */
@Mixin(value = FluidRenderer.class, priority = 999)
public class LiquidBlockRendererMixin {
	/**
	 * Modifies the liquid shade.
	 *
	 * @param constant the original value
	 * @return the modified shade.
	 */
	@ModifyConstant(method = "render",
	           constant = { @Constant(floatValue = 0.5F, ordinal = 0),
					   @Constant(floatValue = 1.0F, ordinal = 0),
					   @Constant(floatValue = 0.8F, ordinal = 0),
					   @Constant(floatValue = 0.6F, ordinal = 0)
			   })
	private float changeShadeDown(float constant) {
		if(SimplyNoShadingClientMod.getInstance().config.rules.get(SimplyNoShadingClientMod.getInstance().config.liquids).wouldShade()){
			return constant;
		}
		return 1.0F;
	}
}
