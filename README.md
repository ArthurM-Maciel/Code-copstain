# Padrões de Projeto — Exercício Aula

> Fundamentos de Desenvolvimento de Software · Prof. Bernardo Copstein

## Como rodar

```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

Acesse: http://localhost:8080

---

## Endpoints para testar (copie e cole no navegador ou Postman)

| Padrão | Endpoint | Exemplo |
|--------|----------|---------|
| Strategy | `/padroes/strategy/{tipo}?valor=100` | `/padroes/strategy/pix?valor=150` |
| Factory | `/padroes/factory/{tipo}?mensagem=Ola` | `/padroes/factory/email?mensagem=Pedido+confirmado` |
| Observer | `/padroes/observer/{pedidoId}?valor=99` | `/padroes/observer/PED-001?valor=250` |
| Singleton | `/padroes/singleton` | `/padroes/singleton` |
| Decorator | `/padroes/decorator?texto=hello` | `/padroes/decorator?texto=mundo` |
| Template Method | `/padroes/template/{tipo}` | `/padroes/template/relatorioVendas` |
| Chain | `/padroes/chain?dados=teste` | `/padroes/chain?dados=abc` |

---

## Estrutura do projeto

```
src/main/java/com/aula/padroes/
│
├── strategy/          ← Strategy: PagamentoStrategy (interface) + implementações
├── factory/           ← Factory Method: NotificacaoFactory + Notificacao (interface)
├── observer/          ← Observer: PedidoObserver (interface) + PedidoService
├── singleton/         ← Singleton: ConfiguracaoService (@Service = singleton no Spring)
├── decorator/         ← Decorator: TextoService (interface) + LogDecorator + CacheDecorator
├── template/          ← Template Method: RelatorioTemplate (abstract) + implementações
├── chain/             ← Chain of Responsibility: ValidacaoHandler (abstract) + handlers
└── controller/        ← PadroesController: expõe todos os padrões via REST
```

---

## Como cada colega contribui

Cada padrão tem `// TODO` marcando exatamente onde adicionar lógica.

### Strategy — adicionar nova forma de pagamento
```java
// Em strategy/PagamentoStrategyImpl.java
@Component("debito")
class PagamentoDebito implements PagamentoStrategy {
    public String pagar(double valor) {
        return "Débito de R$" + valor + " processado.";
    }
}
// Pronto — o Spring injeta automaticamente, sem alterar o controller
```

### Observer — adicionar novo observer
```java
// Em observer/PedidoServiceObserver.java
@Component
class WhatsappObserver implements PedidoObserver {
    public void onPedidoPago(String pedidoId, double valor) {
        System.out.println("[WHATSAPP] Pedido " + pedidoId + " pago!");
    }
}
```

### Template Method — adicionar novo relatório
```java
// Em template/RelatorioImpl.java
@Component("relatorioClientes")
class RelatorioClientes extends RelatorioTemplate {
    protected String cabecalho() { return "=== RELATÓRIO DE CLIENTES ==="; }
    protected String corpo() { return "Cliente A, Cliente B, Cliente C"; }
}
```

### Chain — adicionar nova validação
```java
// Em chain/ValidacaoHandlerImpl.java
@Component
class ValidacaoSoLetras extends ValidacaoHandler {
    protected String checar(String dados) {
        if (!dados.matches("[a-zA-Z]+")) return "Apenas letras permitidas.";
        return null;
    }
}
```

---


