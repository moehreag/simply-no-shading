package com.github.startsmercury.simply.no.shading.entrypoint;

import static com.github.startsmercury.simply.no.shading.util.Constants.GSON;
import static com.mojang.blaze3d.platform.InputConstants.UNKNOWN;
import static net.fabricmc.api.EnvType.CLIENT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.function.BooleanSupplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.startsmercury.simply.no.shading.config.SimplyNoShadingClientConfig;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.ToggleKeyMapping;

@Environment(CLIENT)
public final class SimplyNoShadingClientMod implements ClientModInitializer {
	public static final String CATEGORIES_SIMPLY_NO_SHADING = "simply-no-shading.key.categories.simply-no-shading";

	private static SimplyNoShadingClientMod instance;

	public static final Logger LOGGER = LoggerFactory.getLogger("simply-no-shading+client");

	protected static void consumeClick(final KeyMapping keyMapping, final Runnable action) {
		if (keyMapping.consumeClick()) {
			action.run();
		}
	}

	protected static boolean consumeClickZ(final KeyMapping keyMapping, final BooleanSupplier action) {
		if (keyMapping.consumeClick()) {
			return action.getAsBoolean();
		}

		return false;
	}

	public static SimplyNoShadingClientMod getInstance() {
		if (instance == null) {
			throw new IllegalStateException("simply-no-shading+client is not yet initialized");
		}

		return instance;
	}

	public final SimplyNoShadingClientConfig config;

	public final Path configPath;

	private final FabricLoader fabricLoader;

	public final KeyMapping openSettingsKey;

	public final ToggleKeyMapping toggleBlockShadingKey;

	public final ToggleKeyMapping toggleShadingKey;

	public SimplyNoShadingClientMod() {
		LOGGER.debug("Constructing client mod...");

		this.config = new SimplyNoShadingClientConfig();
		this.fabricLoader = FabricLoader.getInstance();
		this.openSettingsKey = new KeyMapping("simply-no-shading.key.openSettings", UNKNOWN.getValue(),
		    CATEGORIES_SIMPLY_NO_SHADING);

		this.configPath = this.fabricLoader.getConfigDir().resolve("simply-no-shading+client.json");
		this.toggleBlockShadingKey = new ToggleKeyMapping("simply-no-shading.key.toggleBlockShading",
		    UNKNOWN.getValue(), CATEGORIES_SIMPLY_NO_SHADING, this.config::shouldShadeBlocks);
		this.toggleShadingKey = new ToggleKeyMapping("simply-no-shading.key.toggleShading", UNKNOWN.getValue(),
		    CATEGORIES_SIMPLY_NO_SHADING, this.config::shouldShade);

		LOGGER.info("Constructed client mod...");
	}

	public void createConfig() {
		try (final var out = Files.newBufferedWriter(this.configPath)) {
			LOGGER.debug("Creating config...");

			GSON.toJson(this.config, out);

			LOGGER.info("Created config");
		} catch (final IOException ioe) {
			LOGGER.warn("Unable to create config", ioe);
		}
	}

	public void loadConfig() {
		try (final var in = Files.newBufferedReader(this.configPath)) {
			LOGGER.debug("Loading client config...");

			this.config.set(GSON.fromJson(in, SimplyNoShadingClientConfig.class));

			LOGGER.info("Loaded client config");
		} catch (final NoSuchFileException nsfe) {
			createConfig();
		} catch (final IOException ioe) {
			LOGGER.warn("Unable to load config", ioe);
		}
	}

	@Override
	public void onInitializeClient() {
		LOGGER.debug("Initializing client mod...");

		loadConfig();

		whenModLoaded("fabric-key-binding-api-v1", this::registerKeyMappings,
		    "Unable to register key mappings as the mod provided by 'fabric' (specifically 'fabric-key-binding-api-v1') is not present");
		whenModLoaded("fabric-lifecycle-events-v1", this::registerLifecycleEventListeners,
		    "Unable to register life cycle event listeners as the mod provided by 'fabric' (specifically 'fabric-lifecycle-events-v1') is not present");

		instance = this;

		LOGGER.info("Initialized client mod");
	}

	protected void registerKeyMappings() {
		LOGGER.debug("Registering key mappings...");

		KeyBindingHelper.registerKeyBinding(this.openSettingsKey);
		KeyBindingHelper.registerKeyBinding(this.toggleShadingKey);
		KeyBindingHelper.registerKeyBinding(this.toggleBlockShadingKey);

		LOGGER.info("Registered key mappings");
	}

	protected void registerLifecycleEventListeners() {
		LOGGER.debug("Registering life cycle event listeners...");

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			var allChanged = false;

			allChanged |= consumeClickZ(this.toggleBlockShadingKey, this::toggleBlockShading);
			allChanged |= consumeClickZ(this.toggleShadingKey, this::toggleShading);

			if (allChanged) {
				client.levelRenderer.allChanged();
			}
		});

		LOGGER.info("Registered life cycle event listeners");
	}

	public void saveConfig() {
		try (final var out = Files.newBufferedWriter(this.configPath)) {
			LOGGER.debug("Saving config...");

			GSON.toJson(this.config, out);

			LOGGER.info("Saved config");
		} catch (final IOException ioe) {
			LOGGER.warn("Unable to save config", ioe);
		}
	}

	public boolean toggleBlockShading() {
		final var wouldHaveShadeBlocks = this.config.wouldShadeBlocks();

		this.config.toggleBlockShading();

		LOGGER.debug("Toggled block shading, the new value is " + this.config.shouldShadeBlocks());

		return this.config.wouldShadeBlocks() != wouldHaveShadeBlocks;
	}

	public boolean toggleShading() {
		this.config.toggleShading();

		LOGGER.debug("Toggled shading, the new value is " + this.config.shouldShade());

		return true;
	}

	protected void whenModLoaded(final String id, final Runnable action, final String message) {
		if (this.fabricLoader.isModLoaded(id)) {
			action.run();
		} else {
			LOGGER.warn(message);
		}
	}
}
