package view;

import controller.CadastrarUsuarioController;
import controller.TelaLoginController;
import model.*;

import java.time.LocalDateTime;
import java.util.*;

public class CadastrarUsuarioViewTest {
    public static void main(String[] args) {
        // Criar disciplinas
        Disciplina poo = new Disciplina(1, "Programação Orientada a Objetos", "INF101", 60, 5, 30, new ArrayList<>(), 1);
        Disciplina intro = new Disciplina(2, "Introdução à Programação", "INF100", 60, 0,0, new ArrayList<>(), 0);

        // Criar curso, unidade e professor
        Curso curso = new Curso("Engenharia de Software", 1, "", 1, 1, "");
        UnidadeAcademica unidade = new UnidadeAcademica(1, "UFC - Russas", "cidade universitaria");
        Professor professor = new Professor(1, "Prof. João", "asdasd", 1);
        professor.setDisciplinasLecionadas(new ArrayList<>(List.of(1)));

        // Criar model e adicionar dados
        Model model = Model.getInstancia();
        Usuario user1 = new Usuario("Bernardo", "bernardo@ufc.br", "123456", "123456", PerfilUsuario.COORDENADOR);
        model.setUsuarioLogado(user1);
        model.adicionarDisciplina(poo);
        model.adicionarDisciplina(intro);
        model.adicionarCurso(curso);
        model.adicionarUnidadeAcademica(unidade);
        model.adicionarProfessor(professor);
        Map<Integer, Usuario> usuarios = new HashMap<>();
        usuarios.put(user1.getId(), user1);
        model.setUsuarios(usuarios);

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
                1,1,11
        );

        plano.setIdUnidadeAcademica(unidade.getIdUnidadeAcademica());
        plano.setIdCurso(curso.getIdCurso());
        plano.setJustificativa("justificativa teste");
        plano.setJustificativaReprovacao("justificativa de reprovação teste");

        plano.setIdDisciplina(1);
        plano.setIdProfessor(1);

        model.adicionarPlanoDeEnsino(plano);

        CadastrarUsuarioController controller = new CadastrarUsuarioController(model);
        CadastrarUsuarioView view = new CadastrarUsuarioView(controller);
        view.exibirTelaCadastro();

        System.out.println("View anterior");
    }
}
