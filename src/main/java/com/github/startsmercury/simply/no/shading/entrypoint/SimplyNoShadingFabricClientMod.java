package com.github.startsmercury.simply.no.shading.entrypoint;

import com.github.startsmercury.simply.no.shading.config.SimplyNoShadingConfig;
import com.github.startsmercury.simply.no.shading.util.SimplyNoShadingKeyManager;
import io.github.axolotlclient.AxolotlclientConfig.AxolotlClientConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.legacyfabric.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.github.startsmercury.simply.no.shading.util.SimplyNoShadingConstants.LOGGER;
import static net.fabricmc.api.EnvType.CLIENT;

/**
 * Simply No Shading {@link ClientModInitializer fabric client mod initializer}.
 *
 * @since 5.0.0
 */
@Environment(CLIENT)
public class SimplyNoShadingFabricClientMod extends
        SimplyNoShadingClientMod<SimplyNoShadingKeyManager>
        implements ClientModInitializer {
	/**
	 * The instance of this class.
	 */
	private static SimplyNoShadingFabricClientMod instance;


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
	public static SimplyNoShadingFabricClientMod getInstance() {
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
	 * Creates a new instance of {@code SimplyNoShadingFabricClientMod}.
	 */
	public SimplyNoShadingFabricClientMod() {
		super(new SimplyNoShadingConfig());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Screen createSettingsScreen(final Screen parent) {
		AxolotlClientConfigManager.openConfigScreen(modid);
		return MinecraftClient.getInstance().currentScreen;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onInitializeClient() {
		LOGGER.debug("Initializing mod...");

		registerKeyMappings();
		registerLifecycleEventListeners();

		instance = this;
		AxolotlClientConfigManager.registerConfig(modid, config);
		AxolotlClientConfigManager.save(modid);

		LOGGER.info("Initialized mod");
	}

	/**
	 * Registers the key mappings to allow key presses to be consumed.
	 */
	protected void registerKeyMappings() {
		LOGGER.debug("Registering key mappings...");

		this.keyManager.register();

		LOGGER.info("Registered key mappings");
	}

	/**
	 * Register lifecycle event listeners to allow key mapping usage to take affect.
	 */
	protected void registerLifecycleEventListeners() {
		LOGGER.debug("Registering life cycle event listeners...");

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			keyManager.tick();
		});

		LOGGER.info("Registered life cycle event listeners");
	}
}
