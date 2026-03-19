# Padrões de Projeto — Exercício Aula

> Fundamentos de Desenvolvimento de Software · Prof. Bernardo Copstein

## Como rodar

Projeto **Java puro** (sem Spring Boot). Execute a classe principal:

```bash
mvn compile exec:java -Dexec.mainClass="com.aula.padroes.PadroesApplication"
```

Ou rode `PadroesApplication` pelo IDE (Run/Debug). A saída no console demonstra cada padrão.

---

## Estrutura do projeto

```
src/main/java/com/aula/padroes/
│
├── PadroesApplication.java   ← main(): demonstra todos os padrões no console
├── strategy/                 ← Strategy: PagamentoStrategy + implementações (StrategyRunner)
├── factory/                  ← Factory Method: NotificacaoFactory + Notificacao
├── observer/                 ← Observer: PedidoObserver (interface) + PedidoService
├── singleton/                ← Singleton: ConfiguracaoService (getInstance())
├── decorator/                ← Decorator: TextoService + LogDecorator + CacheDecorator (DecoratorRunner)
├── template/                 ← Template Method: RelatorioTemplate + implementações (TemplateRunner)
└── chain/                    ← Chain of Responsibility: ValidacaoHandler + handlers (ChainRunner)
```

---

## Como cada colega contribui

Cada padrão tem `// TODO` marcando exatamente onde adicionar lógica.

### Strategy — adicionar nova forma de pagamento
```java
// Em strategy/PagamentoStrategyImpl.java
class PagamentoDebito implements PagamentoStrategy {
    public String pagar(double valor) {
        return "Débito de R$" + valor + " processado.";
    }
}
// Em strategy/StrategyRunner.java: adicione "debito", new PagamentoDebito() no Map
```

### Observer — adicionar novo observer
```java
// Novo arquivo observer/WhatsappObserver.java (ou no mesmo pacote)
public class WhatsappObserver implements PedidoObserver {
    public void onPedidoPago(String pedidoId, double valor) {
        System.out.println("[WHATSAPP] Pedido " + pedidoId + " pago!");
    }
}
// Em PadroesApplication: pedidoService.addObserver(new WhatsappObserver());
```

### Template Method — adicionar novo relatório
```java
// Em template/RelatorioImpl.java
class RelatorioClientes extends RelatorioTemplate {
    protected String cabecalho() { return "=== RELATÓRIO DE CLIENTES ==="; }
    protected String corpo() { return "Cliente A, Cliente B, Cliente C"; }
}
// Em template/TemplateRunner.java: adicione "relatorioClientes", new RelatorioClientes() no Map
```

### Chain — adicionar nova validação
```java
// Em chain/ValidacaoHandlerImpl.java
class ValidacaoSoLetras extends ValidacaoHandler {
    protected String checar(String dados) {
        if (!dados.matches("[a-zA-Z]+")) return "Apenas letras permitidas.";
        return null;
    }
}
// Em chain/ChainRunner.java: adicione o novo handler na cadeia
```

---


