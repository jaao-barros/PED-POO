package view;

import controller.ListarPlanosController;
import controller.VisualizarPlanoController;
import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ListarPlanosViewTest {
    public static void main(String[] args) {
        // Criar disciplinas
        Disciplina poo = new Disciplina(1, "Programação Orientada a Objetos", "INF101", 60, 5, 30, new ArrayList<>(), 1);
        Disciplina intro = new Disciplina(2, "Introdução à Programação", "INF100", 60, 0,0, new ArrayList<>(), 0);

        // Criar curso, unidade e professor
        Curso curso = new Curso("Engenharia de Software", 1, "", 1, 1, "");
        UnidadeAcademica unidade = new UnidadeAcademica(1, "UFC - Russas", "cidade universitaria");
        Professor professor = new Professor(1, "Prof. João", "asdasd", 1);

        // Criar model e adicionar dados
        Model model = Model.getInstancia();
        model.setUsuarioLogado(new Usuario("Bernardo", "bernardo@ufc.br", "123456", "bernardo123", PerfilUsuario.COORDENADOR));
        model.adicionarDisciplina(poo);
        model.adicionarDisciplina(intro);
        model.adicionarCurso(curso);
        model.adicionarUnidadeAcademica(unidade);
        model.adicionarProfessor(professor);

        // Criar plano de ensino
        PlanoDeEnsino plano = new PlanoDeEnsino(
                1, 2025, 1,
                "Ementa teste",
                "Objetivo geral teste",
                "Objetivos específicos teste",
                "Metodologia teste",
                "Avaliação teste",
                "blablabla",
                new ArrayList<>(Arrays.asList("livro 1", "livro 2", "livro 3")),
                new ArrayList<>(Arrays.asList("livro 4", "livro 5", "livro 6")),
                LocalDateTime.now(),
                StatusPlano.REPROVADO,
                1,1,11
        );

        plano.setIdUnidadeAcademica(unidade.getIdUnidadeAcademica());
        plano.setIdCurso(curso.getIdCurso());
        plano.setJustificativa("justificativa teste");
        plano.setJustificativaReprovacao("justificativa de reprovação teste");

        plano.setIdDisciplina(1);
        plano.setIdProfessor(1);

        ListarPlanosController controller = new ListarPlanosController(model);

        // Criar view e injetar plano
        ListarPlanosView view = new ListarPlanosView(controller);
        model.adicionarPlanoDeEnsino(plano);

        // Executar método
        view.loopTela();

        System.out.println("View anterior");
    }
}
