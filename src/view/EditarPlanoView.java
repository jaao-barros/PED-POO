package view;

import java.util.Scanner;

import controller.EditarPlanoController;

public class EditarPlanoView {
    private final EditarPlanoController controller;

    public EditarPlanoView(EditarPlanoController controller) {
        this.controller = controller;
    }

    public void editarPlano(int idPlanoDeEnsino) {
        controller.setIdPlanoDeEnsino(idPlanoDeEnsino);

        System.out.printf("EDITAR PLANO DE ENSINO #%d\n\n", idPlanoDeEnsino);

        System.out.printf("Status: %s\n", controller.getStatusPlano().getNome());

        exibirOpcoes();

        System.out.printf("Edição do plano de ensino #%d finalizada\n", idPlanoDeEnsino);
    }

    private void exibirOpcoes() {
        Scanner scanner = new Scanner(System.in);
        String opcao1;
        String novoValor;

        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            System.out.print("\nQual seção deseja editar (0 para sair)? ");

            opcao1 = scanner.nextLine();

            switch (opcao1) {
                case "0":
                    continuar = false;
                    break;
                case "1":
                    novoValor = pedirNovoValor("Digite o código da nova disciplina: ");
                    try {
                        controller.editarCampo("1", null, novoValor);
                    } catch (Exception e) {
                        System.out.println("Digite um código válido");
                        break;
                    }
                    System.out.println("Campo editado com sucesso!");
                    break;
                case "2":
                    novoValor = pedirNovoValor("Digite a nova justificativa: ");
                    controller.editarCampo("2", null, novoValor);
                    System.out.println("Campo editado com sucesso!");
                    break;
                case "3":
                    novoValor = pedirNovoValor("Digite a nova ementa: ");
                    controller.editarCampo("3", null, novoValor);
                    System.out.println("Campo editado com sucesso!");
                    break;
                case "4":
                    exibirOpcoesObjetivos();
                    break;
                case "5":
                    novoValor = pedirNovoValor("Digite a nova metodologia de ensino: ");
                    controller.editarCampo("5", null, novoValor);
                    System.out.println("Campo editado com sucesso!");
                    break;
                case "6":
                    novoValor = pedirNovoValor("Digite o novo sistema de avaliação: ");
                    controller.editarCampo("6", null, novoValor);
                    System.out.println("Campo editado com sucesso!");
                    break;
                case "7":
                    exibirOpcoesBibliografia();
                    break;
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\nSeções do plano de ensino:\n");

        System.out.println("[1] - Disciplina");
        System.out.println("[2] - Justificativa");
        System.out.println("[3] - Ementa");
        System.out.println("[4] - Objetivos");
        System.out.println("[5] - Metodologia de ensino");
        System.out.println("[6] - Sistema de Avaliação");
        System.out.println("[7] - Bibliografia");
    }

    private void exibirOpcoesObjetivos() {
        Scanner scanner = new Scanner(System.in);
        String opcao2;
        String novoValor;

        System.out.println("\nAgora escolha a subseção de Objetivos:\n");

        System.out.println("[1] - Gerais");
        System.out.println("[2] - Específicos");

        boolean entradaInvalida = true;

        while (entradaInvalida) {
            System.out.print("\nQual subseção deseja editar (0 para voltar)? ");

            opcao2 = scanner.nextLine();

            switch (opcao2) {
                case "0":
                    entradaInvalida = false;
                    break;
                case "1", "2":
                    novoValor = pedirNovoValor("Digite o novo objetivo: ");
                    controller.editarCampo("4", opcao2, novoValor);
                    System.out.println("Campo editado com sucesso!");
                    entradaInvalida = false;
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;
            }
        }
    }

    private void exibirOpcoesBibliografia() {
        Scanner scanner = new Scanner(System.in);
        String opcao2;

        System.out.println("\nAgora escolha a subseção de Bibliografia:\n");

        System.out.println("[1] - Bibliografia básica");
        System.out.println("[2] - Bibliografia complementar");

        boolean continuar = true;

        while (continuar) {
            System.out.print("\nQual subseção deseja editar (0 para voltar)? ");

            opcao2 = scanner.nextLine();

            switch (opcao2) {
                case "0":
                    continuar = false;
                    break;
                case "1", "2":
                    String tipoBibliografia = opcao2.equals("1") ? "basica" : "complementar";
                    exibirOpcoesOperacaoBibliografia(tipoBibliografia);
                    continuar = false;
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;
            }
        }
    }

    private void exibirOpcoesOperacaoBibliografia(String tipoBibliografia) {
        Scanner scanner = new Scanner(System.in);
        String opcao2;
        String novoValor;

        System.out.println("\nAgora escolha a operação:\n");

        System.out.println("[1] - Adicionar");

        if (!controller.getBibliografias(tipoBibliografia).isEmpty()) {
            System.out.println("[2] - Remover");
            System.out.println("[3] - Editar");
        }

        boolean entradaInvalida = true;

        while (entradaInvalida) {
            System.out.print("\nQual operação deseja realizar (0 para voltar)? ");

            opcao2 = scanner.nextLine();

            switch (opcao2) {
                case "0":
                    entradaInvalida = false;
                    break;
                case "1":
                    novoValor = pedirNovoValor("Digite a nova bibliografia: ");
                    controller.adicionarBibliografia(tipoBibliografia, novoValor);
                    System.out.println("Bibliografia adicionada com sucesso!");
                    entradaInvalida = false;
                    break;
                case "2":
                    if (controller.getBibliografias(tipoBibliografia).isEmpty()) {
                        System.out.println("Entrada inválida");
                        break;
                    }

                    exibirListaBibliografia(tipoBibliografia, "remover");
                    System.out.println("Bibliografia removida com sucesso!");
                    entradaInvalida = false;
                    break;
                case "3":
                    if (controller.getBibliografias(tipoBibliografia).isEmpty()) {
                        System.out.println("Entrada inválida");
                        break;
                    }

                    exibirListaBibliografia(tipoBibliografia, "editar");
                    System.out.println("Bibliografia editada com sucesso!");
                    entradaInvalida = false;
                    break;
                default:
                    System.out.println("Entrada inválida");
                    break;
            }
        }
    }

    private void exibirListaBibliografia(String tipoBibliografia, String operacao) {
        Scanner scanner = new Scanner(System.in);
        String opcao2;
        String novoValor;

        System.out.println("\nAgora escolha a bibliografia:\n");

        int contador = 1;

        for (String bibliografia : controller.getBibliografias(tipoBibliografia)) {
            System.out.printf("[%d] - %s\n", contador, bibliografia);
            contador++;
        }

        while (true) {
            System.out.print("\nQual bibliografia quer escolher (0 para voltar)? ");

            opcao2 = scanner.nextLine();

            if (opcao2.isEmpty()) {
                System.out.println("Entrada inválida");
                continue;
            }

            if (opcao2.equals("0")) {
                break;
            }

            if (operacao.equals("remover")) {
                try {
                    controller.removerBibliografia(tipoBibliografia, opcao2);
                    break;
                } catch (Exception e) {
                    System.out.println("Opção invá4lida");
                }
            } else if (operacao.equals("editar")) {
                try {
                    novoValor = pedirNovoValor("Digite a nova bibliografia: ");
                    controller.editarBibliografia(tipoBibliografia, opcao2, novoValor);
                    break;
                } catch (Exception e) {
                    System.out.println("Opção inválida");
                }
            }
        }
    }

    public String pedirNovoValor(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        String novoValor;

        System.out.printf(mensagem);

        novoValor = scanner.nextLine();

        return novoValor;
    }
}
