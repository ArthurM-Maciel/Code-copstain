package com.aula.padroes.decorator;

import org.springframework.stereotype.Component;

/**
 * PADRÃO: Decorator (Estrutural)
 *
 * PROPÓSITO: Adicionar responsabilidades a um objeto dinamicamente,
 *            sem alterar sua classe original.
 *
 * EXEMPLO DE USO: Um serviço de texto pode ser decorado com Log, depois com
 *                 Cache, depois com Criptografia — cada um envolve o anterior.
 *
 * COMO USAR:
 *   1. TextoServiceBase é a implementação simples
 *   2. LogDecorator envolve qualquer TextoService e adiciona log
 *   3. Você pode empilhar decorators: new LogDecorator(new CacheDecorator(new TextoServiceBase()))
 */
public interface TextoService {
    String processar(String texto);
}

// ============================================================
// COMPONENTE BASE
// ============================================================

@Component
class TextoServiceBase implements TextoService {
    @Override
    public String processar(String texto) {
        return texto.trim().toUpperCase();
    }
}

// ============================================================
// DECORATORS — cada colega pode criar um
// ============================================================

class LogDecorator implements TextoService {
    private final TextoService wrapped;

    public LogDecorator(TextoService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String processar(String texto) {
        System.out.println("[LOG] Processando texto: " + texto);
        String resultado = wrapped.processar(texto);
        System.out.println("[LOG] Resultado: " + resultado);
        return resultado;
    }
}

class CacheDecorator implements TextoService {
    private final TextoService wrapped;
    // TODO: adicionar um Map<String, String> como cache simples

    public CacheDecorator(TextoService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String processar(String texto) {
        // TODO: verificar cache antes de chamar wrapped.processar()
        System.out.println("[CACHE] Verificando cache para: " + texto);
        return wrapped.processar(texto);
    }
}
