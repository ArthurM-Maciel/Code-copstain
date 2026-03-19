package com.aula.padroes.chain;

// ============================================================
// HANDLERS CONCRETOS — cada colega pode criar um
// ============================================================

class ValidacaoNaoVazio extends ValidacaoHandler {
    @Override
    protected String checar(String dados) {
        if (dados == null || dados.isBlank()) {
            return "Dados não podem ser vazios.";
        }
        return null; // passou
    }
}

class ValidacaoTamanhoMinimo extends ValidacaoHandler {
    @Override
    protected String checar(String dados) {
        if (dados.length() < 3) {
            return "Mínimo de 3 caracteres. Recebido: " + dados.length();
        }
        return null;
    }
}

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
