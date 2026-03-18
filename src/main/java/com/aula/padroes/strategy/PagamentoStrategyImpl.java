package com.aula.padroes.strategy;

import org.springframework.stereotype.Component;

// ============================================================
// IMPLEMENTAÇÕES CONCRETAS — cada colega pode fazer uma
// ============================================================

@Component("pix")
class PagamentoPix implements PagamentoStrategy {
    @Override
    public String pagar(double valor) {
        // TODO: implementar lógica de pagamento via Pix
        return "Pix de R$ " + valor + " gerado! Cole o código no seu banco.";
    }
}

@Component("cartao")
class PagamentoCartao implements PagamentoStrategy {
    @Override
    public String pagar(double valor) {
        // TODO: implementar lógica de pagamento via Cartão
        return "Cartão cobrado: R$ " + valor + " em 1x.";
    }
}

@Component("boleto")
class PagamentoBoleto implements PagamentoStrategy {
    @Override
    public String pagar(double valor) {
        // TODO: implementar lógica de pagamento via Boleto
        return "Boleto de R$ " + valor + " gerado! Vence em 3 dias úteis.";
    }
}
