/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.service;

import PAW.UAS.model.Order;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 *
 * @author M S I
 */
@Service
public class DatabasePDFService {

    public static ByteArrayInputStream OrderPDFReport(List<Order> Orders) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
// Add Content to PDF file ->
            Font fontHeader
                    = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Order Category", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(5);
// Add PDF Table Header ->
            Stream.of("ID", "Name", "Alamat", "Makanan", "Jumlah").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.cyan);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
// header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            }
            );
            for (Order order : Orders) {
                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(order.getId())));
                idCell.setPaddingLeft(6);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);
                
                PdfPCell nameCell = new PdfPCell(new Phrase(order.getName()));
                nameCell.setPaddingLeft(6);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(nameCell);
                
                PdfPCell totalQuestionCell = new PdfPCell(new Phrase(String.valueOf(order.getAlamat())));
                totalQuestionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                totalQuestionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                totalQuestionCell.setPaddingRight(6);
                table.addCell(totalQuestionCell);
                PdfPCell timeCell = new PdfPCell(new Phrase(String.valueOf(order.getMakanan())));
                timeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                timeCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                timeCell.setPaddingRight(6);
                table.addCell(timeCell);
                PdfPCell startCell = new PdfPCell(new Phrase(String.valueOf(order.getJumlah())));
                startCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                startCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                startCell.setPaddingRight(6);
                table.addCell(startCell);
            }
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
