package com.webcodein.ai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAiApplicationTests {

    @Test
    void contextLoads() {
        // Will fail if spring.ai.openai.api-key is not resolvable,
        // but we provided a fallback in application.properties
    }

}
