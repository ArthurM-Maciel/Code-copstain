package com.aula.padroes.observer;

import org.springframework.stereotype.Component;

@Component
public class EstoqueObserver implements PedidoObserver {
    @Override
    public void onPedidoPago(String pedidoId, double valor) {
        // TODO: baixar estoque do produto do pedido
        System.out.println("[ESTOQUE] Baixando estoque para o pedido " + pedidoId);
    }
}
