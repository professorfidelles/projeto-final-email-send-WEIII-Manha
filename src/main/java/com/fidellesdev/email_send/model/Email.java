package com.fidellesdev.email_send.model;

import com.fidellesdev.email_send.enums.StatusEnvio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_emails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String assunto;
    private String destinatario;
    @Column(columnDefinition = "TEXT")
    private String mensagem;
    private StatusEnvio statusEnvio;
    private LocalDateTime dataEnvio;
}
