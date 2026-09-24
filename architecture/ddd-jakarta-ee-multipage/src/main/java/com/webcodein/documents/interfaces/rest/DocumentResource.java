package com.webcodein.documents.interfaces.rest;

import com.webcodein.documents.application.service.DocumentService;
import com.webcodein.documents.domain.model.Document;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Path("/documents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentResource {

    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @POST
    public Response createDocument(DocumentRequest request) {
        Document doc = documentService.createDocument(request.title());
        return Response.status(Response.Status.CREATED).entity(doc).build();
    }

    @POST
    @Path("/{id}/publish")
    public Response publishDocument(@PathParam("id") UUID id) {
        documentService.publishDocument(id);
        return Response.ok().build();
    }
}

record DocumentRequest(String title) {}
