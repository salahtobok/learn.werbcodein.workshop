package com.webcodein.documents.domain.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    private UUID id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "title", nullable = false))
    private DocumentTitle title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status;

    protected Document() {}

    public Document(UUID id, DocumentTitle title) {
        this.id = id;
        this.title = title;
        this.status = DocumentStatus.DRAFT;
    }

    public void publish() {
        if (this.status == DocumentStatus.ARCHIVED) {
            throw new IllegalStateException("Cannot publish an archived document");
        }
        this.status = DocumentStatus.PUBLISHED;
    }

    public UUID getId() { return id; }
    public DocumentTitle getTitle() { return title; }
    public DocumentStatus getStatus() { return status; }
}
