package com.github.startsmercury.simply.no.shading.util;

import net.minecraft.client.options.KeyBinding;

import java.util.function.BooleanSupplier;

/**
 * A KeyBinding with a specific action attached
 */
public class ActionKeyBinding extends KeyBinding {

    /**
     * The action of this binding.
     */
    public Action action;

    /**
     * Creates a new KeyBinding
     * @param string its name
     * @param i its key Code
     * @param category The category of this Key
     * @param action the action of this binding
     */
    public ActionKeyBinding(String string, int i, String category, Action action) {
        super(string, i, category);
        this.action = action;
    }

    /**
     * An interface for storing Actions
     */
    public interface Action {

        /**
         * A method to be implemented by a lambda
         */
        void onPress();
    }
}
