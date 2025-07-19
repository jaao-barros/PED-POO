package view;

import java.util.List;
import java.util.Scanner;

import controller.ListarPlanosController;
import model.PlanoDeEnsino;
import model.StatusPlano;
import model.PerfilUsuario;
import model.Usuario;

public class ListarPlanosView {
    private final ListarPlanosController controller;
    private Scanner scanner = new Scanner(System.in);

    public ListarPlanosView(ListarPlanosController controller) {
        this.controller = controller;
    }

    public void exibirTelaListagem() {
        List<PlanoDeEnsino> planos = controller.getPlanosPorPerfil();

        System.out.println("===== LISTA DE PLANOS =====");
        if (planos.isEmpty()) {
            System.out.println("Nenhum plano disponível.");
        } else {
            for (int i = 0; i < planos.size(); i++) {
                StatusPlano status = planos.get(i).getStatus();
                String statusTexto = (status != null) ? status.toString() : "DESCONHECIDO";
                System.out.println((i + 1) + ". " + planos.get(i).getNomeDisciplina() + " (Status: " + statusTexto + ")");
            }
        }

        System.out.println("\n===== OPÇÕES =====");
        PerfilUsuario perfil = controller.getPerfilUsuarioLogado(); // Usando o método fornecido
        if (perfil != null) {
            String tipoPerfil = perfil.toString();
            if ("ALUNO".equals(tipoPerfil)) {
                System.out.println("1. Visualizar plano");
                System.out.println("2. Sair da conta");
                System.out.println("3. Sair do sistema");
            } else if ("PROFESSOR".equals(tipoPerfil)) {
                System.out.println("1. Visualizar plano");
                System.out.println("2. Editar plano");
                System.out.println("3. Submeter plano para a coordenação do curso");
                System.out.println("4. Sair da conta");
                System.out.println("5. Sair do sistema");
            } else if ("COORDENADOR".equals(tipoPerfil)) {
                System.out.println("1. Visualizar plano");
                System.out.println("2. Aprovar plano");
                System.out.println("3. Reprovar plano");
                System.out.println("4. Sair da conta");
                System.out.println("5. Sair do sistema");
            } else {
                System.out.println("Perfil não reconhecido.");
                return;
            }
        } else {
            System.out.println("Perfil não identificado.");
            return;
        }

        System.out.print("\nEscolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        try {
            processarOpcao(opcao, planos);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void processarOpcao(int opcao, List<PlanoDeEnsino> planos) {
        PerfilUsuario perfil = controller.getPerfilUsuarioLogado();
        if (perfil == null) {
            System.out.println("Perfil não identificado.");
            return;
        }
        String tipoPerfil = perfil.toString();

        if ("ALUNO".equals(tipoPerfil)) {
            switch (opcao) {
                case 1:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para visualizar.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.APROVADO) {
                                controller.visualizarPlano(plano);
                                System.out.println("Visualizando plano: " + plano.getNomeDisciplina());
                            } else {
                                System.out.println("Apenas planos aprovados podem ser visualizados.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 2:
                    controller.logout();
                    System.out.println("Logout realizado. Até logo!");
                    break;
                case 3:
                    controller.sair();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else if ("PROFESSOR".equals(tipoPerfil)) {
            switch (opcao) {
                case 1:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para visualizar.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.APROVADO) {
                                controller.visualizarPlano(plano);
                                System.out.println("Visualizando plano: " + plano.getNomeDisciplina());
                            } else {
                                System.out.println("Apenas planos aprovados podem ser visualizados.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 2:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para editar.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.APROVADO) {
                                controller.editarPlano(plano);
                                System.out.println("Plano editado: " + plano.getNomeDisciplina());
                            } else {
                                System.out.println("Apenas planos aprovados podem ser editados.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 3:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para submeter.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.PENDENTE) {
                                controller.submeterPlano(plano);
                                System.out.println("Plano submetido: " + plano.getNomeDisciplina());
                            } else {
                                System.out.println("Apenas planos pendentes podem ser submetidos.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 4:
                    controller.logout();
                    System.out.println("Logout realizado. Até logo!");
                    break;
                case 5:
                    controller.sair();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else if ("COORDENADOR".equals(tipoPerfil)) {
            switch (opcao) {
                case 1:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para visualizar.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.APROVADO) {
                                controller.visualizarPlano(plano);
                                System.out.println("Visualizando plano: " + plano.getNomeDisciplina());
                            } else {
                                System.out.println("Apenas planos aprovados podem ser visualizados.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 2:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para aprovar.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.EM_REVISAO) {
                                controller.aprovarPlano(plano);
                                System.out.println("Plano aprovado: " + plano.getNomeDisciplina());
                            } else {
                                System.out.println("Apenas planos em revisão podem ser aprovados.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 3:
                    if (planos.isEmpty()) {
                        System.out.println("Nenhum plano para reprovar.");
                    } else {
                        System.out.print("Selecione o número do plano: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < planos.size()) {
                            PlanoDeEnsino plano = planos.get(indice);
                            if (plano.getStatus() == StatusPlano.EM_REVISAO) {
                                scanner.nextLine();
                                System.out.print("Justificativa para reprovação: ");
                                String justificativa = scanner.nextLine();
                                controller.reprovarPlano(plano, justificativa);
                                System.out.println("Plano reprovado: " + plano.getNomeDisciplina() + " (Justificativa: " + justificativa + ")");
                            } else {
                                System.out.println("Apenas planos em revisão podem ser reprovados.");
                            }
                        } else {
                            System.out.println("Número inválido.");
                        }
                    }
                    break;
                case 4:
                    controller.logout();
                    System.out.println("Logout realizado. Até logo!");
                    break;
                case 5:
                    controller.sair();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private Usuario getUsuarioLogado() {
        return controller.getUsuarioLogado();
    }
}