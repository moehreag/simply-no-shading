package com.github.startsmercury.simply.no.shading.config;

import com.github.startsmercury.simply.no.shading.impl.CloudRenderer;
import io.github.axolotlclient.AxolotlclientConfig.ConfigHolder;
import io.github.axolotlclient.AxolotlclientConfig.options.BooleanOption;
import io.github.axolotlclient.AxolotlclientConfig.options.OptionCategory;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The config class of SimplyNoShading on 1.8.9
 */

public class SimplyNoShadingConfig extends ConfigHolder {

    /**
     * A map storing a relation between an option and a shading rule.
     */
    public Map<BooleanOption, ShadingRule> rules = new HashMap<>();

    /**
     * whether a rebuilt has been considered smart.
     */
    private boolean smartlyRebuiltChunks;

    /**
     * The Category storing the options for the Rules
     */
    public final OptionCategory shadingRules = new OptionCategory("shadingRules");

    /**
     * The Category storing the options for rebuilding
     */
    public final OptionCategory advancedOptions = new OptionCategory("advanced");

    /**
     * Whether shading should be enabled on blocks
     */
    public final BooleanOption blocks = new BooleanOption("blocks", this::updateShadeBlocks, false);

    /**
     * Whether shading should be enabled on clouds
     */
    public final BooleanOption clouds = new BooleanOption("clouds", this::updateShadeClouds, true);

    /**
     * Whether shading should be enabled on liquids
     */
    public final BooleanOption liquids = new BooleanOption("liquids", this::updateShadeLiquids, false);

    /**
     * An option to toggle all other ones together at the same time
     */
    public final BooleanOption all = new BooleanOption("all", value -> {
        blocks.set(value);
        clouds.set(value);
        liquids.set(value);
        updateShadeAll(value);
    }, false);

    /**
     * Whether smart Reloading is enabled
     */
    public final BooleanOption smartReload = new BooleanOption("smartReload", true);

    /**
     * Whether a message should be sent to the player when a smart reload occurs
     */
    public final BooleanOption smartReloadMessage = new BooleanOption("smartReloadMessage", true);

    /**
     * The list storing the categories
     */
    List<OptionCategory> list = new ArrayList<>();

    /**
     * Constructs the config
     */
    public SimplyNoShadingConfig(){
        shadingRules.add(all, blocks, clouds, liquids);
        advancedOptions.add(smartReload, smartReloadMessage);
        list.add(shadingRules);
        list.add(advancedOptions);

        rules.put(all, new ShadingRule(false));
        rules.put(blocks, new ShadingRule(rules.get(all), false));
        rules.put(clouds, new ShadingRule(rules.get(all), true));
        rules.put(liquids, new ShadingRule(rules.get(all), false));
    }

    /**
     * Get a list of all categories for this config
     * @return the list of all categories
     */
    @Override
    public List<OptionCategory> getCategories() {
        return list;
    }

    private void updateShadeAll(boolean value){
        rules.get(all).setShade(value);
    }

    private void updateShadeBlocks(boolean value){
        rules.get(blocks).setShade(value);
        rebuildBlocks(MinecraftClient.getInstance(), smartReload.get());
    }

    private void updateShadeLiquids(boolean value){
        rules.get(liquids).setShade(value);
        rebuildChunks();
    }

    private void updateShadeClouds(boolean value){
        rules.get(clouds).setShade(value);
        rebuildClouds(MinecraftClient.getInstance(), smartReload.get());
    }

    private void rebuildChunks(){
        this.smartlyRebuiltChunks = !rebuildChunks(MinecraftClient.getInstance(), smartReload.get()) && smartReload.get();
    }

    private boolean rebuildChunks(final MinecraftClient client, final boolean smartReload) {
        return rebuildBlocks(client, smartReload) | rebuildClouds(client, smartReload);
    }

    /**
     * Rebuild clouds when necessary.
     *
     * @param client      the client
     * @param smartReload was smartReload active
     * @return whether a rebuild occurred
     */
    protected boolean rebuildClouds(final MinecraftClient client, final boolean smartReload) {
        if (!smartReload || shouldRebuild() && client.worldRenderer != null) {
            ((CloudRenderer) client.worldRenderer).generateClouds();

            return true;
        } else
            return false;
    }

    /**
     * Returns {@code true} if rebuilds are to be performed.
     *
     * @return {@code true} if rebuilds are to be performed
     */
    protected boolean shouldRebuild() {
        return true;
    }

    /**
     * Returns {@code true} if chunks were rebuilt smartly.
     *
     * @return {@code true} if chunks were rebuilt smartly
     * @since 5.0.0
     */
    public boolean smartlyRebuiltChunks() {
        return this.smartlyRebuiltChunks;
    }

    private boolean rebuildBlocks(final MinecraftClient client, final boolean smartReload) {
        if (!smartReload || shouldRebuild() && client.worldRenderer != null) {
            client.worldRenderer.reload();
            return true;
        } else {
            return false;
        }
    }
}
