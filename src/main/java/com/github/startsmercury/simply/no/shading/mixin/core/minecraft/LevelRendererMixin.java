package com.github.startsmercury.simply.no.shading.mixin.core.minecraft;

import com.github.startsmercury.simply.no.shading.impl.CloudRenderer;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * {@code LevelRenderer} mixin class.
 *
 * @since 5.0.0
 */
@Mixin(WorldRenderer.class)
public abstract class LevelRendererMixin implements CloudRenderer {
	@Shadow private boolean needsTerrainUpdate;

	/**
	 * Sets {@link #generateClouds} to {@code true}.
	 * <p>
	 * {@inheritDoc}
	 */
	@Override
	public void generateClouds() {
		needsTerrainUpdate = true;
	}
}
