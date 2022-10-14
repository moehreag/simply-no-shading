package com.github.startsmercury.simply.no.shading.entrypoint;

import com.github.startsmercury.simply.no.shading.config.ShadingRule;
import com.github.startsmercury.simply.no.shading.config.SimplyNoShadingConfig;
import com.github.startsmercury.simply.no.shading.util.SimplyNoShadingKeyManager;
import io.github.axolotlclient.AxolotlclientConfig.AxolotlClientConfigManager;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.text.Text;

import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.github.startsmercury.simply.no.shading.util.SimplyNoShadingConstants.LOGGER;
import static net.fabricmc.api.EnvType.CLIENT;

/**
 * The base mod class of Simply No Shading.
 *
 * @param <K> The key manager type
 * @since 5.0.0
 */
@Environment(CLIENT)
public abstract class SimplyNoShadingClientMod<K extends SimplyNoShadingKeyManager> {
	/**
	 * The instance of this class.
	 */
	private static SimplyNoShadingClientMod<?> instance;

	/**
	 * This mod's modid. Used for config management
	 */
	public static final String modid = "simply-no-shading";

	/**
	 * The KeyManager, managing KeyBinds.
	 */
	protected SimplyNoShadingKeyManager keyManager;

	/**
	 * The config of this mod.
	 */
	public SimplyNoShadingConfig config;

	/**
	 * The message shown in-game to the player when a smart reload was performed.
	 *
	 * @since 5.0.0
	 */
	public static Text SMART_RELOAD_COMPONENT;

	/**
	 * Returns the instance of this class if there is one initialized, throws an
	 * {@link IllegalStateException} otherwise.
	 *
	 * @return the instance of this class if there is one initialized, throws an
	 *         {@link IllegalStateException} otherwise
	 * @throws IllegalStateException if there is no initialized instance of this
	 *                               class
	 * @since 5.0.0
	 * @see #isInitialized()
	 */
	public static SimplyNoShadingClientMod<?> getInstance() {
		if (isInitialized())
			throw new IllegalStateException("Accessed too early!");

		return instance;
	}

	/**
	 * Returns {@code true} if an instance of this class is initialized where
	 * accesses to {@link #getInstance()} are valid.
	 *
	 * @return {@code true} if an instance of this class is initialized where
	 *         accesses to {@link #getInstance()} are valid
	 * @since 5.0.0
	 */
	public static boolean isInitialized() { return instance == null; }

	/**
	 * Returns {@code true} if the given shading rule was toggled for the given key
	 * mapping being pressed.
	 *
	 * @param keyMapping  the key mapping
	 * @param shadingRule the shading rule
	 * @return {@code true} if the given shading rule was toggled for the given key
	 *         mapping being pressed
	 */
	protected static boolean toggleShade(final KeyBinding keyMapping, final ShadingRule shadingRule) {
		if (keyMapping.isPressed()) {
			shadingRule.toggleShade();

			return true;
		} else
			return false;
	}

	/**
	 * Executes an action when an instance of this class {@link #isInitialized() was
	 * initialized}.
	 *
	 * @param whenInitialized the action ran when initialized
	 * @since 5.0.0
	 */
	public static void whenInitialized(final Consumer<? super SimplyNoShadingClientMod<?>> whenInitialized) {
		Objects.requireNonNull(whenInitialized);

		if (isInitialized()) { whenInitialized.accept(instance); }
	}

	/**
	 * Executes an action when an instance of this class {@link #isInitialized() was
	 * initialized}, a fallback action is executed otherwise.
	 *
	 * @param <T>               the result type
	 * @param whenInitialized   the action ran when initialized
	 * @param whenUninitialized the fallback action
	 * @return the result of one of the given actions
	 * @since 5.0.0
	 */
	public static <T> T whenInitialized(final Function<? super SimplyNoShadingClientMod<?>, ? extends T> whenInitialized,
	                                    final Supplier<? extends T> whenUninitialized) {
		Objects.requireNonNull(whenInitialized);
		Objects.requireNonNull(whenUninitialized);

		return isInitialized() ? whenInitialized.apply(instance) : whenUninitialized.get();
	}

	/**
	 * Creates a new instance of SimplyNoShadingClientMod.
	 * @param config an instance of the config
	 */
	protected SimplyNoShadingClientMod(SimplyNoShadingConfig config) {

		//loadConfig();
		this.config = config;

		instance = this;
		this.keyManager = new SimplyNoShadingKeyManager(config);

		//SMART_RELOAD_COMPONENT = new LiteralText(I18n.translate("simply-no-shading.option.shadingRules.smartReload"));
	}

	/**
	 * Creates the settings screen given the client.
	 *
	 * @param client the client
	 * @return the settings screen
	 * @see #createSettingsScreen(Screen)
	 */
	private Screen createSettingsScreen(final MinecraftClient client) {
		LOGGER.debug("Creating settings screen...");

		final Screen settingsScreen = createSettingsScreen(client.currentScreen);

		LOGGER.info("Created settings screen");
		return settingsScreen;
	}

	/**
	 * Creates the settings screen given the parent screen.
	 *
	 * @param parent the parent screen
	 * @return the settings screen
	 */
	public Screen createSettingsScreen(final Screen parent) {
		return null;
	}

	/**
	 * Opens the settings screen.
	 *
	 * @param client the client
	 * @see #createSettingsScreen(Screen)
	 */
	public void openSettingsScreen(final MinecraftClient client) {
		LOGGER.debug("Opening settings screen...");

		AxolotlClientConfigManager.openConfigScreen(modid);
	}
}
