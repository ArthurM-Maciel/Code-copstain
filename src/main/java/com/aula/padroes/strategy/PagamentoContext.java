package com.aula.padroes.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Contexto que usa a Strategy.
 * Recebe todas as implementações via injeção de dependência do Spring
 * e escolhe qual usar baseado no nome.
 */
@Service
public class PagamentoContext {

    // Spring injeta automaticamente todas as implementações de PagamentoStrategy
    // mapeadas pelo nome do @Component
    @Autowired
    private Map<String, PagamentoStrategy> estrategias;

    /**
     * Executa o pagamento usando a estratégia informada.
     * @param tipo  "pix", "cartao" ou "boleto"
     * @param valor valor a pagar
     */
    public String executarPagamento(String tipo, double valor) {
        PagamentoStrategy estrategia = estrategias.get(tipo);

        if (estrategia == null) {
            return "Forma de pagamento inválida: " + tipo
                    + ". Use: " + estrategias.keySet();
        }

        return estrategia.pagar(valor);
    }
}
