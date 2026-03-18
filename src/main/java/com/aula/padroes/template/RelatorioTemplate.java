package com.aula.padroes.template;

/**
 * PADRÃO: Template Method (Comportamental)
 *
 * PROPÓSITO: Define o esqueleto de um algoritmo na classe base,
 *            deixando as subclasses preencherem os passos específicos.
 *
 * EXEMPLO DE USO: Geração de relatório — a estrutura (cabeçalho → dados → rodapé)
 *                 é sempre a mesma, mas o conteúdo muda por tipo de relatório.
 *
 * COMO USAR:
 *   1. Estenda esta classe abstrata
 *   2. Implemente os métodos abstratos com a lógica específica
 *   3. Chame gerarRelatorio() — ele executa os passos na ordem certa
 */
public abstract class RelatorioTemplate {

    // Template Method — define a ordem dos passos (não pode ser sobrescrito)
    public final String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append(cabecalho()).append("\n");
        sb.append(corpo()).append("\n");
        sb.append(rodape());
        return sb.toString();
    }

    // Passos que as subclasses DEVEM implementar
    protected abstract String cabecalho();
    protected abstract String corpo();

    // Passo com implementação padrão (subclasse pode sobrescrever se quiser)
    protected String rodape() {
        return "--- Fim do Relatório ---";
    }
}
