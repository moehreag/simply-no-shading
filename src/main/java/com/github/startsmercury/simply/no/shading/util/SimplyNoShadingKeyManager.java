package com.github.startsmercury.simply.no.shading.util;

import com.github.startsmercury.simply.no.shading.config.SimplyNoShadingConfig;
import com.github.startsmercury.simply.no.shading.entrypoint.SimplyNoShadingClientMod;
import com.github.startsmercury.simply.no.shading.entrypoint.SimplyNoShadingFabricClientMod;
import net.fabricmc.api.Environment;
import net.legacyfabric.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

import static net.fabricmc.api.EnvType.CLIENT;

/**
 * The {@code SimplyNoShadingKeyManager} class represents the key manager of the
 * mod Simply No Shading.
 *
 * @since 5.0.0
 */
@Environment(CLIENT)
public class SimplyNoShadingKeyManager {

	private final List<ActionKeyBinding> keyBindings = new ArrayList<>();

	/**
	 * Simply No Shading key category.
	 */
	public static final String CATEGORY = "simply-no-shading.key.categories.simply-no-shading";

	/**
	 * Open settings key mapping.
	 */
	public final ActionKeyBinding openSettings;

	/**
	 * toggle all shading key mapping.
	 */
	public final ActionKeyBinding toggleAllShading;

	/**
	 * toggle block shading key mapping.
	 */
	public final ActionKeyBinding toggleBlockShading;

	/**
	 * toggle cloud shading key mapping.
	 */
	public final ActionKeyBinding toggleCloudShading;

	/**
	 * toggle liquid shading key mapping.
	 */
	public final ActionKeyBinding toggleLiquidShading;

	/**
	 * Create a key manager from a given config.
	 *
	 * @param config the config
	 */
	public SimplyNoShadingKeyManager(final SimplyNoShadingConfig config) {
		this.openSettings = register("openSettings",
		                             new ActionKeyBinding("simply-no-shading.key.openSettings",
											 Keyboard.KEY_NONE,
		                                            CATEGORY,
											 ()-> SimplyNoShadingFabricClientMod.getInstance().openSettingsScreen(MinecraftClient.getInstance())));
		this.toggleAllShading = register("toggleAllShading",
		                                 new ActionKeyBinding("simply-no-shading.key.toggleAllShading",
												 Keyboard.KEY_F6,
		                                                      CATEGORY,
												 ()->SimplyNoShadingClientMod.getInstance().config.all.toggle()));
		this.toggleBlockShading = register("toggleBlockShading",
		                                   new ActionKeyBinding("simply-no-shading.key.toggleBlockShading",
												   Keyboard.KEY_NONE,
		                                                        CATEGORY,
												   ()->SimplyNoShadingClientMod.getInstance().config.blocks.toggle()));
		this.toggleCloudShading = register("toggleCloudShading",
		                                   new ActionKeyBinding("simply-no-shading.key.toggleCloudShading",
												   Keyboard.KEY_NONE,
		                                                        CATEGORY,
												   ()->SimplyNoShadingClientMod.getInstance().config.clouds.toggle()));
		this.toggleLiquidShading = register("toggleLiquidShading",
		                                    new ActionKeyBinding("simply-no-shading.key.toggleLiquidShading",
													Keyboard.KEY_NONE,
		                                                         CATEGORY,
													()->SimplyNoShadingClientMod.getInstance().config.liquids.toggle()));
	}

	/**
	 * Register all key mapping.
	 *
	 * @since 5.0.0
	 */
	public void register() {
		keyBindings.forEach(this::register);
	}

	private ActionKeyBinding register(String name, ActionKeyBinding keyBinding){
		keyBindings.add(keyBinding);
		return keyBinding;
	}

	/**
	 * Registers a key mapping.
	 *
	 * @param KeyBinding the key mapping
	 */
	protected void register(final KeyBinding KeyBinding) {
		KeyBindingHelper.registerKeyBinding(KeyBinding);
	}

	public void tick(){
		keyBindings.forEach(keyBinding -> {
			if (keyBinding.wasPressed()) {
				keyBinding.action.onPress();
			}
		});
	}
}
