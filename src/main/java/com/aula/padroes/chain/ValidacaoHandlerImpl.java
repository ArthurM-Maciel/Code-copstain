package com.aula.padroes.chain;

import org.springframework.stereotype.Component;

// ============================================================
// HANDLERS CONCRETOS — cada colega pode criar um
// ============================================================

@Component
class ValidacaoNaoVazio extends ValidacaoHandler {
    @Override
    protected String checar(String dados) {
        if (dados == null || dados.isBlank()) {
            return "Dados não podem ser vazios.";
        }
        return null; // passou
    }
}

@Component
class ValidacaoTamanhoMinimo extends ValidacaoHandler {
    @Override
    protected String checar(String dados) {
        if (dados.length() < 3) {
            return "Mínimo de 3 caracteres. Recebido: " + dados.length();
        }
        return null;
    }
}

@Component
class ValidacaoSemEspacos extends ValidacaoHandler {
    @Override
    protected String checar(String dados) {
        // TODO: adicionar sua própria regra de validação
        if (dados.contains(" ")) {
            return "Não são permitidos espaços.";
        }
        return null;
    }
}
