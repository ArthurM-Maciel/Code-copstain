package com.aula.padroes.decorator;

/** Monta a cadeia de decorators (sem Spring). */
public final class DecoratorRunner {

    private DecoratorRunner() {}

    public static TextoService criar() {
        return new LogDecorator(new CacheDecorator(new TextoServiceBase()));
    }
}
