package com.aula.padroes.singleton;

/**
 * PADRÃO: Singleton (Criação)
 *
 * PROPÓSITO: Garantir uma única instância de uma classe em toda a aplicação.
 *
 * EXEMPLO DE USO: Configurações globais da aplicação.
 */
public class ConfiguracaoService {

    private static final ConfiguracaoService INSTANCIA = new ConfiguracaoService();

    private String ambienteAtivo = "desenvolvimento";
    private int maxConexoes = 10;

    private ConfiguracaoService() {}

    public static ConfiguracaoService getInstance() {
        return INSTANCIA;
    }

    public String getAmbienteAtivo() { return ambienteAtivo; }
    public int getMaxConexoes() { return maxConexoes; }

    public String getStatus() {
        return "Ambiente: " + ambienteAtivo + " | Max conexões: " + maxConexoes
               + " | Instância: " + System.identityHashCode(this);
    }
}
