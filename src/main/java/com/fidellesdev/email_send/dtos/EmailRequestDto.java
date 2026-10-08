package com.fidellesdev.email_send.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmailRequestDto(
        @NotBlank(message = "Informe o assunto")
        String assunto,
        @Email(message = "Informe um email válido")
        @NotBlank(message = "Informe o seu email")
        String destinatario,
        @NotBlank(message = "Informe a mensagem")
        String mensagem
) {
}
