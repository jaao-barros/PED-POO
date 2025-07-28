import controller.CadastrarUsuarioController;
import controller.MenuInicialController;
import controller.TelaLoginController;
import model.*;
import view.CadastrarUsuarioView;
import view.TelaLoginView;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Criar disciplinas
        Disciplina poo = new Disciplina(1, "Programação Orientada a Objetos", "RUS101", 32, 32, 3, new ArrayList<>(), 1);
        Disciplina intro = new Disciplina(2, "Introdução à Programação", "RUS100", 32, 32,1, new ArrayList<>(), 1);

        // Criar curso, unidade e professor
        Curso curso = new Curso("Engenharia de Software", 1, "", 1, 1, "");
        UnidadeAcademica unidade = new UnidadeAcademica(1, "UFC - Russas", "cidade universitaria");
        Professor professor = new Professor(1, "Marcos", "marcos@gmail.com", 1);
        Professor professor2 = new Professor(2, "Anderson", "anderson@gmail.com", 1);
        professor.setDisciplinasLecionadas(new ArrayList<>(List.of(1)));
        professor2.setDisciplinasLecionadas(new ArrayList<>(List.of(1, 2)));

        // Criar model e adicionar dados
        Model model = Model.getInstancia();
        model.adicionarDisciplina(poo);
        model.adicionarDisciplina(intro);
        model.adicionarCurso(curso);
        model.adicionarUnidadeAcademica(unidade);
        model.adicionarProfessor(professor);
        model.adicionarProfessor(professor2);
        Usuario usuario1 = new Usuario(professor.getNome(), professor.getEmail(), "123456", "123456", PerfilUsuario.PROFESSOR);
        model.adicionarUsuario(usuario1);
        Usuario usuario2 = new Usuario(professor2.getNome(), professor2.getEmail(), "123457", "123457", PerfilUsuario.COORDENADOR);
        model.adicionarUsuario(usuario2);

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
                StatusPlano.APROVADO,
                1,1,1
        );

        plano.setIdUnidadeAcademica(unidade.getIdUnidadeAcademica());
        plano.setIdCurso(curso.getIdCurso());
        plano.setJustificativa("justificativa teste");
        plano.setJustificativaReprovacao("justificativa de reprovação teste");

        plano.setIdDisciplina(1);
        plano.setIdProfessor(1);

        model.adicionarPlanoDeEnsino(plano);

        MenuInicialController controller = new MenuInicialController();
        controller.iniciar();
    }

}