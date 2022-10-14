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

public class SimplyNoShadingConfig extends ConfigHolder {

    public Map<BooleanOption, ShadingRule> rules = new HashMap<>();
    private boolean smartlyRebuiltChunks;

    public final OptionCategory shadingRules = new OptionCategory("shadingRules");
    public final OptionCategory advancedOptions = new OptionCategory("advanced");


    public final BooleanOption blocks = new BooleanOption("blocks", this::updateShadeBlocks, false);
    public final BooleanOption clouds = new BooleanOption("clouds", this::updateShadeClouds, true);
    public final BooleanOption liquids = new BooleanOption("liquids", this::updateShadeLiquids, false);
    public final BooleanOption all = new BooleanOption("all", value -> {
        blocks.set(value);
        clouds.set(value);
        liquids.set(value);
        updateShadeAll(value);
    }, false);

    public final BooleanOption smartReload = new BooleanOption("smartReload", true);
    public final BooleanOption smartReloadMessage = new BooleanOption("smartReloadMessage", true);

    List<OptionCategory> list = new ArrayList<>();

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

    public ShadingRule getRule(BooleanOption option){
        return rules.get(option);
    }

    protected void rebuildChunks(){
        this.smartlyRebuiltChunks = !rebuildChunks(MinecraftClient.getInstance(), smartReload.get()) && smartReload.get();
    }

    protected boolean rebuildChunks(final MinecraftClient client, final boolean smartReload) {
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

    protected boolean rebuildBlocks(final MinecraftClient client, final boolean smartReload) {
        if (!smartReload || shouldRebuild() && client.worldRenderer != null) {
            client.worldRenderer.reload();
            return true;
        } else return false;
    }
}
