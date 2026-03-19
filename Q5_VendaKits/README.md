# Q5: Sistema de registro de vendas usando Composite

## Objetivo

Registrar a venda de produtos e emitir comprovante. Produtos podem ser agrupados em **kits**: cada kit é vendido como um item, com preço = soma dos preços dos itens com **10% de desconto**. Padrão **Composite** aplicado.

## Estrutura do Composite

- **Component:** `ItemVendavel` (interface) – contrato para tudo que pode ser vendido
- **Leaf:** `Produto` – produto unitário
- **Composite:** `Kit` – agrupa vários `ItemVendavel`; `getPreco()` retorna soma × 0,90

## Como executar

```bash
cd Q5_VendaKits
javac -d out src/*.java
java -cp out App
```

O exemplo em `App` vende 1 Caneta, 2 Borrachas e 1 Kit Escolar e imprime o comprovante.
