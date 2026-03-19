package com.aula.padroes;

import com.aula.padroes.chain.ChainRunner;
import com.aula.padroes.chain.ValidacaoHandler;
import com.aula.padroes.decorator.DecoratorRunner;
import com.aula.padroes.decorator.TextoService;
import com.aula.padroes.factory.NotificacaoFactory;
import com.aula.padroes.observer.EmailObserver;
import com.aula.padroes.observer.EstoqueObserver;
import com.aula.padroes.observer.FiscalObserver;
import com.aula.padroes.observer.PedidoService;
import com.aula.padroes.singleton.ConfiguracaoService;
import com.aula.padroes.strategy.PagamentoContext;
import com.aula.padroes.strategy.StrategyRunner;
import com.aula.padroes.template.RelatorioTemplate;
import com.aula.padroes.template.TemplateRunner;

import java.util.Map;

/**
 * Aplicação Java pura (sem Spring Boot) — demonstra os padrões de projeto.
 */
public class PadroesApplication {

    public static void main(String[] args) {
        System.out.println("=== Design Patterns - Demo ===\n");

        // Strategy
        PagamentoContext pagamentoContext = StrategyRunner.criarContexto();
        System.out.println("--- Strategy ---");
        System.out.println(pagamentoContext.executarPagamento("pix", 150));
        System.out.println(pagamentoContext.executarPagamento("cartao", 99.90));

        // Factory
        NotificacaoFactory notificacaoFactory = new NotificacaoFactory();
        System.out.println("\n--- Factory ---");
        System.out.println(notificacaoFactory.criar("email").enviar("Pedido confirmado"));

        // Observer
        PedidoService pedidoService = new PedidoService();
        pedidoService.addObserver(new EstoqueObserver());
        pedidoService.addObserver(new EmailObserver());
        pedidoService.addObserver(new FiscalObserver());
        System.out.println("\n--- Observer ---");
        System.out.println(pedidoService.confirmarPagamento("PED-001", 250));

        // Singleton
        ConfiguracaoService config = ConfiguracaoService.getInstance();
        System.out.println("\n--- Singleton ---");
        System.out.println(config.getStatus());

        // Decorator
        TextoService textoService = DecoratorRunner.criar();
        System.out.println("\n--- Decorator ---");
        System.out.println(textoService.processar("  hello world  "));

        // Template Method
        Map<String, RelatorioTemplate> relatorios = TemplateRunner.getRelatorios();
        System.out.println("\n--- Template Method ---");
        System.out.println(relatorios.get("relatorioVendas").gerarRelatorio());

        // Chain of Responsibility
        ValidacaoHandler chain = ChainRunner.criarCadeia();
        System.out.println("\n--- Chain ---");
        System.out.println(chain.validar("abc"));
        System.out.println(chain.validar("ab"));  // falha tamanho
        System.out.println(chain.validar("a b")); // falha espaço

        System.out.println("\n=== Fim ===");
    }
}
