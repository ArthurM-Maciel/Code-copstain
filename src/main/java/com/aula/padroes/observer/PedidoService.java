package com.aula.padroes.observer;

import java.util.ArrayList;
import java.util.List;

// ============================================================
// SUBJECT — quem dispara os eventos
// ============================================================

public class PedidoService {

    private final List<PedidoObserver> observers = new ArrayList<>();

    public void addObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public String confirmarPagamento(String pedidoId, double valor) {
        System.out.println("Pedido " + pedidoId + " confirmado. Notificando observers...");

        // Notifica todos os observers registrados
        for (PedidoObserver observer : observers) {
            observer.onPedidoPago(pedidoId, valor);
        }

        return "Pedido " + pedidoId + " pago. " + observers.size() + " observer(s) notificado(s).";
    }
}
