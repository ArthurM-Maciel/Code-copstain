package com.aula.padroes.chain;

/** Monta a cadeia de validação (sem Spring). */
public final class ChainRunner {

    private ChainRunner() {}

    public static ValidacaoHandler criarCadeia() {
        ValidacaoHandler h1 = new ValidacaoNaoVazio();
        ValidacaoHandler h2 = new ValidacaoTamanhoMinimo();
        ValidacaoHandler h3 = new ValidacaoSemEspacos();
        h1.setProximo(h2).setProximo(h3);
        return h1;
    }
}
