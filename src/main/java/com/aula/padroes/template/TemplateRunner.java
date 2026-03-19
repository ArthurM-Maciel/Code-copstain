package com.aula.padroes.template;

import java.util.Map;

/** Retorna o mapa de relatórios por tipo (sem Spring). */
public final class TemplateRunner {

    private TemplateRunner() {}

    public static Map<String, RelatorioTemplate> getRelatorios() {
        return Map.of(
                "relatorioVendas", new RelatorioVendas(),
                "relatorioEstoque", new RelatorioEstoque()
        );
    }
}
