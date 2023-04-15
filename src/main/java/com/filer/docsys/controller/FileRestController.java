package com.filer.docsys.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileRestController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World! Here I am";
    }

    @PostMapping(value = "/pdfToByteArray", consumes = MediaType.APPLICATION_PDF_VALUE)
    public byte[] pdfToBytes(@RequestBody byte[] fileBytes) throws IOException {
        // Process the PDF bytes here
        return fileBytes;
    }

    @PostMapping(value = "/pdfToByteArrayFile", consumes = MediaType.APPLICATION_PDF_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> pdfToBytesFile(@RequestBody byte[] fileBytes) throws IOException {
        // Process the byte array file here
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "file.bin");
        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/byteArrayToPdf", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> byteArrayToPdf(@RequestBody byte[] bytes) {
        // Process the byte array here
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "file.pdf");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

}
