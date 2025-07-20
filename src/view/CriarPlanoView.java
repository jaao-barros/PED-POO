package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.CriarPlanoController;
import model.Disciplina;
import model.PlanoDeEnsino;

public class CriarPlanoView {
    private final CriarPlanoController controller;
    private Scanner scanner = new Scanner(System.in);

    public CriarPlanoView(CriarPlanoController controller) {
        this.controller = controller;
    }

    public void exibirTelaCriacao() {
        System.out.println("=== CRIAÇÃO DE PLANO DE ENSINO ===");

        List<Integer> disciplinas = controller.getDisciplinasLecionadas();
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina disponível para este professor.");
            return;
        }

        System.out.println("Selecione a disciplina:");
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina disciplina = controller.buscarDisciplinaPorId(disciplinas.get(i));
            System.out.println((i + 1) + ". " + disciplina.getNome() + " (Código: " + disciplina.getCodigoDisciplina() + ")");
        }
        int escolhaDisciplina = scanner.nextInt() - 1;
        scanner.nextLine();
        if (escolhaDisciplina < 0 || escolhaDisciplina >= disciplinas.size()) {
            System.out.println("Escolha inválida.");
            return;
        }
        Disciplina disciplinaSelecionada = controller.buscarDisciplinaPorId(disciplinas.get(escolhaDisciplina));

        System.out.println("Justificativa:");
        String justificativa = scanner.nextLine();

        System.out.println("Justificativa:");
        String ementa = scanner.nextLine();

        System.out.println("Objetivos gerais:");
        String objetivosGerais = scanner.nextLine();

        System.out.println("Objetivos específicos:");
        String objetivosEspecificos = scanner.nextLine();

        System.out.println("Conteúdo Programático:");
        String conteudoProgramatico = scanner.nextLine();

        System.out.println("Metodologia:");
        String metodologia = scanner.nextLine();

        System.out.println("Avaliação:");
        String avaliacao = scanner.nextLine();

        System.out.println("É obrigatória? (sim ou não)");
        String isObrigatoriaStr = scanner.nextLine();
        boolean isObrigatoria;

        isObrigatoria = isObrigatoriaStr.equalsIgnoreCase("sim");

        System.out.println("Digite os itens da bibliografia básica (digite 'fim' para encerrar)\n");
        List<String> bibliografiaBasica = new ArrayList<>();

        while (true) {
            System.out.print("Item: ");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("fim")) {
                break;
            }
            if (!item.isEmpty()) {
                bibliografiaBasica.add(item);
            }
        }

        System.out.println("Digite os itens da bibliografia complementar (digite 'fim' para encerrar)\n");
        List<String> bibliografiaComplementar = new ArrayList<>();

        while (true) {
            System.out.print("Item: ");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("fim")) {
                break;
            }
            if (!item.isEmpty()) {
                bibliografiaComplementar.add(item);
            }
        }

        System.out.println("Ano:");
        int ano = scanner.nextInt();

        System.out.println("Semestre:");
        int semestre = scanner.nextInt();

        PlanoDeEnsino plano = new PlanoDeEnsino();
        int idDisciplina = disciplinaSelecionada.getIdDisciplina();

        controller.gerarPlano(ano, semestre, justificativa, ementa, objetivosGerais, objetivosEspecificos, metodologia, avaliacao, bibliografiaBasica, bibliografiaComplementar, idDisciplina);

        System.out.println("\nPlano criado com sucesso!");
    }
}