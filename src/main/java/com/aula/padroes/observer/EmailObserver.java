package com.aula.padroes.observer;

import org.springframework.stereotype.Component;

@Component
public class EmailObserver implements PedidoObserver {
    @Override
    public void onPedidoPago(String pedidoId, double valor) {
        // TODO: enviar email de confirmação ao cliente
        System.out.println("[EMAIL] Confirmação enviada para pedido " + pedidoId);
    }
}
