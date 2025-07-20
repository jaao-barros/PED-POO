package view;

import java.util.Scanner;

import controller.TelaLoginController;
import model.PerfilUsuario;
import model.Usuario;

public class TelaLoginView {
    private final TelaLoginController controller;
    private Scanner scanner = new Scanner(System.in);

    public TelaLoginView(TelaLoginController controller) {
        this.controller = controller;
    }

    public void exibirTelaLogin() {
        System.out.println("=-=-= TELA DE LOGIN =-=-=");

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        try {
            Usuario usuario = controller.autenticarUsuario(matricula, senha);
            if (usuario != null) {
                String perfil = (usuario.getPerfil() == PerfilUsuario.ALUNO) ? "Aluno" : "Professor";
                System.out.println("Login bem-sucedido! Seja bem-vindo, " + usuario.getNome() + " (" + perfil + ")");
                controller.exibirMenu();
            } else {
                throw new IllegalArgumentException("Matrícula ou senha inválidos!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no login: " + e.getMessage());
        }
    }
}