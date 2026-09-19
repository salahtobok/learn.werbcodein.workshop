package com.webcodein.nativedemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.predicate.RuntimeHintsPredicates;

class MyHintsTest {

    @Test
    void shouldRegisterReflectionHints() {
        RuntimeHints hints = new RuntimeHints();
        new MyHints().registerHints(hints, getClass().getClassLoader());

        assertThat(RuntimeHintsPredicates.reflection()
                .onType(MyDynamicClass.class))
                .accepts(hints);
    }
}
