package com.fidellesdev.email_send.controller;

import com.fidellesdev.email_send.dtos.EmailRequestDto;
import com.fidellesdev.email_send.model.Email;
import com.fidellesdev.email_send.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")

@Tag(name = "Envio de Email" , description = "API Rest para Envio de Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    @Operation(summary = "EndPoint para Envio de e-mail", description = "Enviar email")
    public ResponseEntity<Email> enviar(@RequestBody @Valid EmailRequestDto dto){
        Email enviarEmail = emailService.enviarEmail(dto);

        return  ResponseEntity.status(HttpStatus.CREATED).body(enviarEmail);
    }
}
