package com.github.startsmercury.simplynoshading.mixin.minecraft;

import static net.fabricmc.api.EnvType.CLIENT;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.github.startsmercury.simplynoshading.client.SimplyNoShadingOptions;

import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;

/**
 * {@link Mixin mixin} for the class {@link BakedQuad}.
 */
@Environment(CLIENT)
@Mixin(BakedQuad.class)
public class BakedQuadMixin {
	/**
	 * Makes all block model faces require either
	 * {@link SimplyNoShadingOptions#isShadeAll()} or
	 * {@link SimplyNoShadingOptions#isShadeBlocks()} to return {@code true} to
	 * shade.
	 *
	 * @param callback the callback
	 * @implSpec {@code isShade() && (isShadeAll || isShadeBlocks())}
	 */
	@Inject(method = "Lnet/minecraft/client/renderer/block/model/BakedQuad;isShade()Z", at = @At("RETURN"),
			cancellable = true)
	private final void changeReturnedShade(final CallbackInfoReturnable<Boolean> callback) {
		@SuppressWarnings("resource")
		final SimplyNoShadingOptions options = (SimplyNoShadingOptions) Minecraft.getInstance().options;

		callback.setReturnValue(callback.getReturnValueZ() && (options.isShadeAll() || options.isShadeBlocks()));
	}
}
