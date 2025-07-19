package controller;

import model.*;

public class CadastrarUsuarioController {
    private final Model model;

    public CadastrarUsuarioController(Model model) {
        this.model = model;
    }

    public void cadastrarUsuario(String matricula, String nomeCompleto, String email, String senha) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula é obrigatória!");
        }
        if (nomeCompleto == null || nomeCompleto.isEmpty()) {
            throw new IllegalArgumentException("Nome completo é obrigatório!");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("E-mail é obrigatório!");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória!");
        }

        if (!isMatriculaValida(matricula)) {
            throw new IllegalArgumentException("Matrícula inválida ou já existente!");
        }

        int novoId = model.gerarIdUnico();
        Usuario novoUsuario = new Usuario();
        novoUsuario.setId(novoId);
        novoUsuario.setMatricula(matricula);
        novoUsuario.setNomeCompleto(nomeCompleto);
        novoUsuario.setEmail(email);
        novoUsuario.setSenha(senha);
        novoUsuario.setPerfil(PerfilUsuario.ALUNO);

        if (!model.adicionarUsuario(novoUsuario)) {
            throw new IllegalArgumentException("Falha ao salvar o usuário.");
        }
    }

    private boolean isMatriculaValida(String matricula) {
        if (matricula.length() != 7) {
            return false;
        }

        for (int i = 0; i < matricula.length(); i++) {
            if (!Character.isDigit(matricula.charAt(i))) {
                return false;
            }
        }
        return !model.existeMatricula(matricula);
    }
}