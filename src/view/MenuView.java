package view;

import model.PerfilUsuario;
import java.util.Scanner;

public class MenuView implements Observer {
    public MenuView() {
        super();
    }

    public void exibirBoasVindas(String nomeUsuario, PerfilUsuario perfil) {
        System.out.println("------------------------------------------");
        System.out.println(" Bem-vindo(a), " + nomeUsuario + "!");
        System.out.println(" Perfil: " + perfil.name());
        System.out.println("------------------------------------------");
    }

    public void exibirMenuAluno() {
        System.out.println("\n--- Menu do Aluno ---");
        System.out.println("1. Visualizar planos de ensino");
        System.out.println("2. Sair da conta");
        System.out.println("3. Sair do sistema");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirMenuProfessor() {
        System.out.println("\n--- Menu do Professor ---");
        System.out.println("1. Listar planos de ensino");
        System.out.println("2. Criar novos planos de ensino");
        System.out.println("3. Sair da conta");
        System.out.println("4. Sair do sistema");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirMenuCoordenador() {
        System.out.println("\n--- Menu do Coordenador ---");
        System.out.println("1. Visualizar planos de ensino");
        System.out.println("2. Sair da conta");
        System.out.println("3. Sair do sistema");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    public void exibirOpcaoInvalida() {
        System.out.println("\nOpção inválida. Por favor, tente novamente.");
    }

    public int lerOpcao() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public void update() {

    }
}