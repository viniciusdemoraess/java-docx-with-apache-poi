package com.simulator.examplejava.application.adapters;

import com.simulator.examplejava.domain.services.DocumentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class DocumentRestAdapter {

    private final DocumentService documentService;

    public DocumentRestAdapter(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/replaces")
    public String repacePlaceholders(@RequestBody Map<String, String> replacements,
                                     @RequestParam String docName) {

        String docPath = "C:\\Users\\06644513140\\Desktop\\fap-project\\";

        try{
            documentService.replacePlaceholders(docPath, docName, replacements);
            return "Document saved successfully as 'output.docx'.";
        } catch (IOException e) {
            return "Error while processing the document: "+ e.getMessage();
        }
    }
}
