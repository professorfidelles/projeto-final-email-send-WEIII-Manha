package com.fidellesdev.email_send.service;

import com.fidellesdev.email_send.dtos.EmailRequestDto;
import com.fidellesdev.email_send.enums.StatusEnvio;
import com.fidellesdev.email_send.model.Email;
import com.fidellesdev.email_send.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private  EmailRepository emailRepository;
    @Autowired
    private  JavaMailSender mailSender;

    public Email enviarEmail(EmailRequestDto dto){
        Email email = new Email();
        email.setAssunto(dto.assunto());
        email.setDestinatario(dto.destinatario());
        email.setMensagem(dto.mensagem());
        email.setDataEnvio(LocalDateTime.now());

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject(dto.assunto());
            mailMessage.setTo(dto.destinatario());
            mailMessage.setText(dto.mensagem());
            mailSender.send(mailMessage);
            email.setStatusEnvio(StatusEnvio.ENVIADO);
        } catch (MailException e){
            email.setStatusEnvio(StatusEnvio.ERRO);
            throw new RuntimeException(e);
        }
        return emailRepository.save(email);
    }

}
