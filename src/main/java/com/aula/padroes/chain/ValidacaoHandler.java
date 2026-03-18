package com.aula.padroes.chain;

/**
 * PADRÃO: Chain of Responsibility (Comportamental)
 *
 * PROPÓSITO: Passa uma requisição por uma cadeia de handlers.
 *            Cada handler decide processar ou passar para o próximo.
 *
 * EXEMPLO DE USO: Validação de formulário em etapas sequenciais.
 *                 Se uma validação falha, a cadeia para. Se passa, vai para a próxima.
 *
 * COMO USAR:
 *   1. Crie handlers concretos estendendo ValidacaoHandler
 *   2. Monte a cadeia: handler1.setProximo(handler2).setProximo(handler3)
 *   3. Chame handler1.validar(dados) — percorre a cadeia automaticamente
 */
public abstract class ValidacaoHandler {

    private ValidacaoHandler proximo;

    public ValidacaoHandler setProximo(ValidacaoHandler proximo) {
        this.proximo = proximo;
        return proximo; // retorna o próximo para encadeamento fluente
    }

    public final String validar(String dados) {
        String resultado = checar(dados);

        if (resultado != null) {
            return "FALHOU em " + getClass().getSimpleName() + ": " + resultado;
        }

        if (proximo != null) {
            return proximo.validar(dados);
        }

        return "OK — todas as validações passaram!";
    }

    // Subclasse implementa a regra de validação.
    // Retorna null se passou, ou mensagem de erro se falhou.
    protected abstract String checar(String dados);
}
