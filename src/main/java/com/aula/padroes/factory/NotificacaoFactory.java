package com.aula.padroes.factory;

import org.springframework.stereotype.Component;

/**
 * A fábrica — decide qual implementação criar baseado no tipo.
 */
@Component
public class NotificacaoFactory {

    public Notificacao criar(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "sms"   -> new NotificacaoSms();
            case "email" -> new NotificacaoEmail();
            case "push"  -> new NotificacaoPush();
            default -> throw new IllegalArgumentException(
                "Tipo de notificação inválido: " + tipo + ". Use: sms, email, push"
            );
        };
    }
}
