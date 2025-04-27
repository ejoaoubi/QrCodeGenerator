package com.jesteves.qr.controller;


import com.jesteves.qr.dto.QrGenerateRequest;
import com.jesteves.qr.dto.QrGenerateResponse;
import com.jesteves.qr.service.QrGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qr/")
public class QrController {

    private final QrGeneratorService qrGeneratorService;

    public QrController(QrGeneratorService qrGeneratorService) {
        this.qrGeneratorService = qrGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QrGenerateResponse> generate(@RequestBody QrGenerateRequest request){
        try{
            QrGenerateResponse response = this.qrGeneratorService.generateAndUplodaQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }


    }

}
