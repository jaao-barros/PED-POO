package controller;

import model.*;

public class CadastrarUsuarioController {
    private final Model model;

    public CadastrarUsuarioController(Model model) {
        this.model = model;
    }

    public void cadastrarUsuario(String matricula, String nome, String email, String senha) {

        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula é obrigatória.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome completo é obrigatório.");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("E-mail é obrigatório.");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória.");
        }

        //valida a matricula
        if (!isMatriculaValida(matricula)) {
            throw new IllegalArgumentException("Matrícula inválida ou já existente.");
        }

        //cria o perfil
        Usuario novoUsuario = new Usuario(nome, email, matricula, senha, PerfilUsuario.ALUNO);

        if (!model.adicionarUsuario(novoUsuario)) {
            throw new IllegalArgumentException("Falha ao salvar o usuário.");
        }

        model.setUsuarioLogado(novoUsuario);
    }

    public void exibirMenu() {
        MenuController menuController = new MenuController();
        menuController.iniciar();
    }

    private boolean isMatriculaValida(String matricula) {
        if (matricula.length() != 6) {
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