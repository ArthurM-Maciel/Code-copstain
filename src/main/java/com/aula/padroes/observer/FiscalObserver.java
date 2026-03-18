package com.aula.padroes.observer;

import org.springframework.stereotype.Component;

@Component
public class FiscalObserver implements PedidoObserver {
    @Override
    public void onPedidoPago(String pedidoId, double valor) {
        // TODO: emitir nota fiscal
        System.out.println("[FISCAL] Nota fiscal emitida para pedido " + pedidoId + " - R$" + valor);
    }
}
