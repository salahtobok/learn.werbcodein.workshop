package com.webcodein.documents.domain.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class DocumentTitle {
    private String value;

    protected DocumentTitle() {}

    public DocumentTitle(String value) {
        if (value == null || value.trim().length() < 3) {
            throw new IllegalArgumentException("Title must be at least 3 characters");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }
}
