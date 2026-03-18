package com.aula.padroes.singleton;

import org.springframework.stereotype.Service;

/**
 * PADRÃO: Singleton (Criação)
 *
 * PROPÓSITO: Garantir uma única instância de uma classe em toda a aplicação.
 *
 * NOTA: No Spring, todo @Service/@Component já é Singleton por padrão!
 *       Esta classe demonstra o conceito explicitamente.
 *
 * EXEMPLO DE USO: Configurações globais da aplicação.
 */
@Service
public class ConfiguracaoService {

    private String ambienteAtivo = "desenvolvimento";
    private int maxConexoes = 10;

    // Spring garante que só existe uma instância desta classe
    // Não é necessário implementar o padrão manualmente

    public String getAmbienteAtivo() { return ambienteAtivo; }
    public int getMaxConexoes() { return maxConexoes; }

    public String getStatus() {
        return "Ambiente: " + ambienteAtivo + " | Max conexões: " + maxConexoes
               + " | Instância: " + System.identityHashCode(this);
    }
}
