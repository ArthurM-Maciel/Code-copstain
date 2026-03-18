package com.aula.padroes.template;

import org.springframework.stereotype.Component;

// ============================================================
// IMPLEMENTAÇÕES CONCRETAS — cada colega pode fazer uma
// ============================================================

@Component("relatorioVendas")
class RelatorioVendas extends RelatorioTemplate {

    @Override
    protected String cabecalho() {
        return "=== RELATÓRIO DE VENDAS ===";
    }

    @Override
    protected String corpo() {
        // TODO: buscar dados reais de vendas
        return "Produto A: 150 unidades\nProduto B: 80 unidades\nTotal: R$ 12.500,00";
    }
}

@Component("relatorioEstoque")
class RelatorioEstoque extends RelatorioTemplate {

    @Override
    protected String cabecalho() {
        return "=== RELATÓRIO DE ESTOQUE ===";
    }

    @Override
    protected String corpo() {
        // TODO: buscar dados reais de estoque
        return "Produto A: 45 em estoque\nProduto B: 12 em estoque\nProduto C: ESGOTADO";
    }

    @Override
    protected String rodape() {
        return "Atualizado em: " + java.time.LocalDate.now() + "\n--- Fim ---";
    }
}
