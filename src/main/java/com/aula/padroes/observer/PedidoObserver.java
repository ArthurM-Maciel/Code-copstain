package com.aula.padroes.observer;

/**
 * PADRÃO: Observer (Comportamental)
 *
 * PROPÓSITO: Quando um objeto muda de estado, todos os seus dependentes
 *            são notificados automaticamente.
 *
 * EXEMPLO DE USO: Um pedido muda para "PAGO" → notifica estoque, email, fiscal.
 *
 * COMO USAR:
 *   1. Implemente esta interface (ex: EstoqueObserver, EmailObserver)
 *   2. Registre os observers no PedidoService com addObserver()
 *   3. Ao mudar status do pedido, todos são notificados automaticamente
 */
public interface PedidoObserver {
    void onPedidoPago(String pedidoId, double valor);
}
