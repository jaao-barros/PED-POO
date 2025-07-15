package view;

import controller.VisualizarPlanoController;
import model.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class VisualizarPlanoViewTest {
    public static void main(String[] args) {
        // Redirecionar saída padrão
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        // Criar disciplinas
        Disciplina poo = new Disciplina(1, "Programação Orientada a Objetos", "INF101", 60, 5, 30, new ArrayList<>(), 1);
        Disciplina intro = new Disciplina(2, "Introdução à Programação", "INF100", 60, 0,0, new ArrayList<>(), 0);

        // Criar curso, unidade e professor
        Curso curso = new Curso("Engenharia de Software", 1, "", 1, 1, "");
        UnidadeAcademica unidade = new UnidadeAcademica(1, "UFC - Russas", "cidade universitaria");
        Professor professor = new Professor(1, "Prof. João", "asdasd", 1);

        // Criar plano de ensino
        PlanoDeEnsino plano = new PlanoDeEnsino(
                1, 2025, 1,
                "Ementa teste",
                "Objetivo geral teste",
                "Objetivos específicos teste",
                "Metodologia teste",
                "Avaliação teste",
                new ArrayList<>(Arrays.asList("livro 1", "livro 2", "livro 3")),
                new ArrayList<>(Arrays.asList("livro 4", "livro 5", "livro 6"))
        );

        plano.setIdUnidadeAcademica(unidade.getIdUnidadeAcademica());
        plano.setCodigoCurso(curso.getCodigoCurso());
        plano.setJustificativa("justificativa teste");

        plano.setIdDisciplina(1);
        plano.setIdProfessor(1);

        // Criar model e adicionar dados
        Model model = Model.getInstancia();
        model.adicionarDisciplina(poo);
        model.adicionarDisciplina(intro);
        model.adicionarCurso(curso);
        model.adicionarUnidadeAcademica(unidade);
        model.adicionarProfessor(professor);

        VisualizarPlanoController controller = new VisualizarPlanoController(model);

        // Criar view e injetar plano
        VisualizarPlanoView view = new VisualizarPlanoView(controller);
        view.setIdPlanoDeEnsino(plano.getIdPlanoDeEnsino());
        model.adicionarPlanoDeEnsino(plano);

        // Executar método
        view.visualizarPlano();

        // Restaurar System.out
        System.setOut(originalOut);

        // Verificar saída esperada
        String saida = output.toString();
        System.out.println("==== SAÍDA DO TESTE ====");
        System.out.println(saida);
        System.out.println("========================");

        // Verificação manual
        if (saida.contains("Programação Orientada a Objetos") &&
                saida.contains("INF101") &&
                saida.contains("Introdução à Programação") &&
                saida.contains("Justificativa teste")) {
            System.out.println("✅ Teste passou!");
        } else {
            System.out.println("❌ Teste falhou!");
        }
    }
}
