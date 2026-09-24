package com.webcodein.documents.domain.model;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class DocumentTest {

    @Test
    void shouldCreateDraftDocument() {
        UUID id = UUID.randomUUID();
        DocumentTitle title = new DocumentTitle("Test Title");
        Document document = new Document(id, title);

        assertEquals(DocumentStatus.DRAFT, document.getStatus());
        assertEquals("Test Title", document.getTitle().getValue());
    }

    @Test
    void shouldPublishDocument() {
        UUID id = UUID.randomUUID();
        Document document = new Document(id, new DocumentTitle("Valid Title"));
        
        document.publish();
        
        assertEquals(DocumentStatus.PUBLISHED, document.getStatus());
    }

    @Test
    void titleMustBeAtLeast3Characters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DocumentTitle("ab");
        });
    }
}
