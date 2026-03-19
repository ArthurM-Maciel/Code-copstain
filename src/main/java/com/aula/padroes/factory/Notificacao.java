package com.aula.padroes.factory;

/**
 * PADRÃO: Factory Method (Criação)
 *
 * PROPÓSITO: Delega a criação de objetos para subclasses/métodos fábrica.
 *            O cliente não precisa saber qual classe concreta está sendo criada.
 *
 * EXEMPLO DE USO: Criar diferentes tipos de notificação (SMS, Email, Push).
 *
 * COMO USAR:
 *   1. Implemente esta interface em classes concretas
 *   2. Use NotificacaoFactory.criar(tipo) para obter a instância certa
 *   3. Chame notificacao.enviar(mensagem) sem saber o tipo concreto
 */
public interface Notificacao {
    String enviar(String mensagem);
}

// ============================================================
// IMPLEMENTAÇÕES CONCRETAS — cada colega pode fazer uma
// ============================================================

class NotificacaoSms implements Notificacao {
    @Override
    public String enviar(String mensagem) {
        // TODO: implementar envio de SMS
        return "[SMS] Mensagem enviada: " + mensagem;
    }
}

class NotificacaoEmail implements Notificacao {
    @Override
    public String enviar(String mensagem) {
        // TODO: implementar envio de Email
        return "[EMAIL] Mensagem enviada: " + mensagem;
    }
}

class NotificacaoPush implements Notificacao {
    @Override
    public String enviar(String mensagem) {
        // TODO: implementar envio de Push Notification
        return "[PUSH] Mensagem enviada: " + mensagem;
    }
}
