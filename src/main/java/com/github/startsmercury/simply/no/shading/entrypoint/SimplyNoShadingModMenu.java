package com.github.startsmercury.simply.no.shading.entrypoint;

import io.github.axolotlclient.AxolotlclientConfig.AxolotlClientConfigManager;
import io.github.axolotlclient.AxolotlclientConfig.options.OptionCategory;
import io.github.axolotlclient.AxolotlclientConfig.screen.OptionsScreenBuilder;
import io.github.prospector.modmenu.api.ModMenuApi;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

import java.util.function.Function;

/**
 * Provides support for {@link ModMenuApi modmenu}. In {@code fabric.mod.json},
 * the entrypoint is defined with the {@code modmenu} key.
 *
 * @since 5.0.0
 */
public class SimplyNoShadingModMenu implements ModMenuApi {
	/**
	 * Creates a new SimplyNoShadingModMenu.
	 */
	public SimplyNoShadingModMenu() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getModId() {
		return SimplyNoShadingClientMod.modid;
	}

	@Override
	public Function<Screen, ? extends Screen> getConfigScreenFactory() {
		return (parent) -> {
			SimplyNoShadingClientMod.getInstance().openSettingsScreen(MinecraftClient.getInstance());
			return MinecraftClient.getInstance().currentScreen;
		};
	}
}
