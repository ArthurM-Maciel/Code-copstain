package com.aula.padroes.strategy;

/**
 * PADRÃO: Strategy (Comportamental)
 *
 * PROPÓSITO: Encapsular algoritmos/comportamentos intercambiáveis.
 *            O cliente escolhe qual estratégia usar em tempo de execução.
 *
 * EXEMPLO DE USO: Formas de pagamento (Pix, Cartão, Boleto).
 *                 Cada forma tem sua lógica, mas todas seguem a mesma interface.
 *
 * COMO USAR:
 *   1. Implemente esta interface em classes concretas (ex: PagamentoPix, PagamentoCartao)
 *   2. Injete a implementação desejada no PagamentoContext
 *   3. Chame contexto.executarPagamento(valor)
 */
public interface PagamentoStrategy {

    /**
     * Executa o pagamento com a estratégia concreta.
     * @param valor valor a ser pago
     * @return mensagem de confirmação
     */
    String pagar(double valor);
}
