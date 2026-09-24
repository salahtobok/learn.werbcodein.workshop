package com.webcodein.documents.domain.repository;

import com.webcodein.documents.domain.model.Document;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<Document, UUID> {
}
