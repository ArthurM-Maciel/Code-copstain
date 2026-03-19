package com.aula.padroes.strategy;

import java.util.Map;

/**
 * Contexto que usa a Strategy.
 * Recebe as implementações no construtor e escolhe qual usar baseado no nome.
 */
public class PagamentoContext {

    private final Map<String, PagamentoStrategy> estrategias;

    public PagamentoContext(Map<String, PagamentoStrategy> estrategias) {
        this.estrategias = estrategias;
    }

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
