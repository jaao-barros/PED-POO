package view;

import java.util.Scanner;

import controller.CadastrarUsuarioController;

public class CadastrarUsuarioView {
    private final CadastrarUsuarioController controller;
    private Scanner scanner = new Scanner(System.in);

    public CadastrarUsuarioView(CadastrarUsuarioController controller) {
        this.controller = controller;
    }

    public void exibirTelaCadastro() {
        System.out.println("===== CADASTRO DE USUÁRIO =====");

        System.out.print("Matrícula (insira 8 dígitos!): ");
        String matricula = scanner.nextLine();

        System.out.print("Nome completo: ");
        String nomeCompleto = scanner.nextLine();

        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        try {
            controller.cadastrarUsuario(matricula, nomeCompleto, email, senha);
            System.out.println("Usuário cadastrado com sucesso! Perfil: ALUNO");
            controller.exibirMenu();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }
}