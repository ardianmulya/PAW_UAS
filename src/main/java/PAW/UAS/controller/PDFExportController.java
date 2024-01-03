/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PAW.UAS.controller;

import PAW.UAS.model.Order;
import PAW.UAS.repositories.OrderRepo;
import PAW.UAS.service.DatabasePDFService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author M S I
 */
@Controller
public class PDFExportController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping(value = "/openpdf/order", produces
            = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> OrderReport() throws
            IOException {
        List<Order> Orders = (List<Order>) orderRepo.findAll();
        ByteArrayInputStream bis= DatabasePDFService.OrderPDFReport(Orders);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline;filename = Order.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bis));
    }

}
