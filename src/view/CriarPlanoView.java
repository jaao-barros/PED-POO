package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.CriarPlanoController;
import model.Disciplina;
import model.PlanoDeEnsino;
import model.PeriodoLetivo;

public class CriarPlanoView {
    private final CriarPlanoController controller;
    private Scanner scanner = new Scanner(System.in);

    public CriarPlanoView(CriarPlanoController controller) {
        this.controller = controller;
    }

    public void exibirTelaCriacao() {
        System.out.println("=== CRIAÇÃO DE PLANO DE ENSINO ===");

        List<Disciplina> disciplinas = controller.getDisciplinasLecionadas();
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina disponível para este professor.");
            return;
        }

        System.out.println("Selecione a disciplina:");
        for (int i = 0; i < disciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + disciplinas.get(i).getNome() + " (Código: " + disciplinas.get(i).getCodigoDisciplina() + ")");
        }
        int escolhaDisciplina = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpar buffer
        if (escolhaDisciplina < 0 || escolhaDisciplina >= disciplinas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }
        Disciplina disciplinaSelecionada = disciplinas.get(escolhaDisciplina);

        System.out.println("Ementa:");
        String ementa = scanner.nextLine();

        System.out.println("Objetivos:");
        String objetivos = scanner.nextLine();

        System.out.println("Conteúdo Programático:");
        String conteudoProgramatico = scanner.nextLine();

        System.out.println("Metodologia:");
        String metodologia = scanner.nextLine();

        System.out.println("Avaliação:");
        String avaliacao = scanner.nextLine();

        System.out.println("Digite os itens da Bibliografia (digite 'fim' para encerrar):");
        List<String> bibliografia = new ArrayList<>();
        while (true) {
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("fim")) {
                break;
            }
            if (!item.isEmpty()) {
                bibliografia.add(item);
            }
        }
        System.out.println("Período Letivo (formato: AAAA.S):");
        String periodoLetivoStr = scanner.nextLine();
        PeriodoLetivo periodoLetivo = new PeriodoLetivo(periodoLetivoStr);

        PlanoDeEnsino plano = new PlanoDeEnsino();
        plano.setIdDisciplina(disciplinaSelecionada.getIdDisciplina());
        plano.setEmenta(ementa);
        plano.setObjetivos(objetivos);
        plano.setConteudoProgramatico(conteudoProgramatico);
        plano.setMetodologia(metodologia);
        plano.setAvaliacao(avaliacao);
        plano.setBibliografia(bibliografia.toArray(new String[0]));
        plano.setPeriodoLetivo(periodoLetivo);

        System.out.println("\nO que deseja fazer?");
        System.out.println("1. Salvar como rascunho");
        System.out.println("2. Submeter para aprovação");
        int opcao = scanner.nextInt();

        try {
            if (opcao == 1) {
                controller.salvarComoRascunho(plano);
                System.out.println("Plano salvo como rascunho com sucesso!");
            } else if (opcao == 2) {
                controller.submeterParaAprovacao(plano);
                System.out.println("Plano submetido para aprovação com sucesso!");
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}