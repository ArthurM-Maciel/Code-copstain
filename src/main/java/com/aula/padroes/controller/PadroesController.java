package com.aula.padroes.controller;

import com.aula.padroes.chain.ValidacaoHandler;
import com.aula.padroes.chain.ValidacaoHandlerImpl;
import com.aula.padroes.decorator.TextoService;
import com.aula.padroes.factory.NotificacaoFactory;
import com.aula.padroes.observer.EmailObserver;
import com.aula.padroes.observer.EstoqueObserver;
import com.aula.padroes.observer.FiscalObserver;
import com.aula.padroes.observer.PedidoService;
import com.aula.padroes.singleton.ConfiguracaoService;
import com.aula.padroes.strategy.PagamentoContext;
import com.aula.padroes.template.RelatorioTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller principal — expõe todos os padrões via endpoints REST.
 *
 * Endpoints disponíveis:
 *   GET  /padroes/strategy/{tipo}?valor=100        → Strategy
 *   GET  /padroes/factory/{tipo}?mensagem=Ola       → Factory Method
 *   GET  /padroes/observer/{pedidoId}?valor=250     → Observer
 *   GET  /padroes/singleton                         → Singleton
 *   GET  /padroes/decorator?texto=hello             → Decorator
 *   GET  /padroes/template/{tipo}                   → Template Method
 *   GET  /padroes/chain?dados=teste                 → Chain of Responsibility
 */
@RestController
@RequestMapping("/padroes")
public class PadroesController {

    @Autowired private PagamentoContext pagamentoContext;
    @Autowired private NotificacaoFactory notificacaoFactory;
    @Autowired private PedidoService pedidoService;
    @Autowired private ConfiguracaoService configuracaoService;
    @Autowired private TextoService textoService;
    @Autowired private Map<String, RelatorioTemplate> relatorios;
    @Autowired private List<ValidacaoHandler> handlers;

    // --- STRATEGY ---
    @GetMapping("/strategy/{tipo}")
    public String strategy(@PathVariable String tipo,
                           @RequestParam(defaultValue = "100") double valor) {
        return pagamentoContext.executarPagamento(tipo, valor);
    }

    // --- FACTORY ---
    @GetMapping("/factory/{tipo}")
    public String factory(@PathVariable String tipo,
                          @RequestParam(defaultValue = "Olá!") String mensagem) {
        return notificacaoFactory.criar(tipo).enviar(mensagem);
    }

    // --- OBSERVER ---
    @GetMapping("/observer/{pedidoId}")
    public String observer(@PathVariable String pedidoId,
                           @RequestParam(defaultValue = "99.90") double valor) {
        // Registra os observers antes de disparar o evento
        pedidoService.addObserver(new EstoqueObserver());
        pedidoService.addObserver(new EmailObserver());
        pedidoService.addObserver(new FiscalObserver());
        return pedidoService.confirmarPagamento(pedidoId, valor);
    }

    // --- SINGLETON ---
    @GetMapping("/singleton")
    public String singleton() {
        return configuracaoService.getStatus();
    }

    // --- DECORATOR ---
    @GetMapping("/decorator")
    public String decorator(@RequestParam(defaultValue = "  hello world  ") String texto) {
        return textoService.processar(texto);
    }

    // --- TEMPLATE METHOD ---
    @GetMapping("/template/{tipo}")
    public String template(@PathVariable String tipo) {
        RelatorioTemplate relatorio = relatorios.get(tipo);
        if (relatorio == null) {
            return "Tipo inválido. Use: relatorioVendas, relatorioEstoque";
        }
        return relatorio.gerarRelatorio();
    }

    // --- CHAIN OF RESPONSIBILITY ---
    @GetMapping("/chain")
    public String chain(@RequestParam(defaultValue = "teste") String dados) {
        // Monta a cadeia de validação
        ValidacaoHandler handler1 = handlers.get(0);
        ValidacaoHandler handler2 = handlers.get(1);
        ValidacaoHandler handler3 = handlers.get(2);
        handler1.setProximo(handler2).setProximo(handler3);
        return handler1.validar(dados);
    }
}
