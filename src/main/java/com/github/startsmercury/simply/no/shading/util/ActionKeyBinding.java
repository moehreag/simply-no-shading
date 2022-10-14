package com.github.startsmercury.simply.no.shading.util;

import net.minecraft.client.options.KeyBinding;

import java.util.function.BooleanSupplier;

public class ActionKeyBinding extends KeyBinding {

    public Action action;

    public ActionKeyBinding(String string, int i, String string2, Action action) {
        super(string, i, string2);
        this.action = action;
    }

    public interface Action {
        void onPress();
    }
}
