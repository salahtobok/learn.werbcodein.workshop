package com.webcodein.nativedemo;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

class MyHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        // Register a class for reflection
        hints.reflection()
             .registerType(MyDynamicClass.class,
                 MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS,
                 MemberCategory.INVOKE_PUBLIC_METHODS);

        // Register a resource file
        hints.resources()
             .registerPattern("config/*.json");
    }
}
