package controller;

import model.*;

public class TelaLoginController {
    private final Model model;

    public TelaLoginController(Model model) {
        this.model = model;
    }

    public Usuario autenticarUsuario(String matricula, String senha) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("informe a matrícula pois é obrigatória!");
        }
        if (senha == null || senha.isEmpty()) {
            throw new IllegalArgumentException("informe a senha pois é obrigatória!");
        }

        for (Usuario usuario : model.getUsuarios().values()) {
            if (usuario.getMatricula() != null && usuario.getMatricula().equals(matricula) &&
                    usuario.getSenha() != null && usuario.getSenha().equals(senha)) {
                model.setUsuarioLogado(usuario);
                return usuario;
            }
        }
        return null;
    }

    public void exibirMenu() {
        MenuController menuController = new MenuController();
        menuController.iniciar();
    }
}