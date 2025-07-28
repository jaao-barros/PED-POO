package view;

import java.util.Scanner;

public class MenuInicialView implements Observer {
    public MenuInicialView() {
        super();
    }

    public void exibirMenu() {
        System.out.println("MENU INICIAL\n");
        System.out.println("1. Fazer login");
        System.out.println("2. Cadastrar");
        System.out.println("3. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    public void exibirOpcaoInvalida() {
        System.out.println("Opção inválida. Por favor, tente novamente.\n");
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