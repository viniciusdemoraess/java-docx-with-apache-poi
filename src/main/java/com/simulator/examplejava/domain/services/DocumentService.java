package com.simulator.examplejava.domain.services;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.*;

@Service
public class DocumentService {

    public void replacePlaceholders(String path, String docName, Map<String, String> replacements) throws IOException {
        String docPath = path + docName;
        try (FileInputStream fis = new FileInputStream(docPath)) {
            XWPFDocument doc = new XWPFDocument(fis);

            for (XWPFParagraph paragraph : doc.getParagraphs()) {
                replaceInParagraph(paragraph, replacements);
            }

            for (XWPFTable table : doc.getTables()) {
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph paragraph : cell.getParagraphs()) {
                            replaceInParagraph(paragraph, replacements);
                        }
                    }
                }
            }

            // Salva o documento modificado
            try (FileOutputStream fos = new FileOutputStream(path + "output.docx")) {
                doc.write(fos);
            }

            System.out.println("Document saved as 'output.docx'");
        }
    }

    private void replaceInParagraph(XWPFParagraph paragraph, Map<String, String> replacements) {
        for (XWPFRun run : paragraph.getRuns()) {
            String text = run.getText(0);
            if (text != null) {
                for (Map.Entry<String, String> entry : replacements.entrySet()) {
                    if (text.contains(entry.getKey())) {
                        text = text.replace(entry.getKey(), entry.getValue());
                        run.setText(text, 0);
                    }
                }
            }
        }
    }

}
