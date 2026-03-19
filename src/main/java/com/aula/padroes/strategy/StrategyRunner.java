package com.aula.padroes.strategy;

import java.util.Map;

/** Cria e retorna o contexto de pagamento com as estratégias configuradas (sem Spring). */
public final class StrategyRunner {

    private StrategyRunner() {}

    public static PagamentoContext criarContexto() {
        Map<String, PagamentoStrategy> estrategias = Map.of(
                "pix", new PagamentoPix(),
                "cartao", new PagamentoCartao(),
                "boleto", new PagamentoBoleto()
        );
        return new PagamentoContext(estrategias);
    }
}
