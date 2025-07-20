package view;

import controller.CriarPlanoController;
import controller.VisualizarPlanoController;
import model.*;

import java.util.*;

public class CriarPlanoViewTest {
    public static void main(String[] args) {

        // Criar disciplinas
        Disciplina poo = new Disciplina(1, "Programação Orientada a Objetos", "INF101", 60, 5, 30, new ArrayList<>(), 1);
        Disciplina intro = new Disciplina(2, "Introdução à Programação", "INF100", 60, 0,0, new ArrayList<>(), 0);

        // Criar curso, unidade e professor
        Curso curso = new Curso("Engenharia de Software", 1, "", 1, 1, "asasf");
        UnidadeAcademica unidade = new UnidadeAcademica(1, "UFC - Russas", "cidade universitaria");
        Professor professor = new Professor(1, "Prof. João", "asdasd", 1);
        professor.setDisciplinasLecionadas(new ArrayList<>(List.of(1)));

        // Criar model e adicionar dados
        Model model = Model.getInstancia();
        Usuario user1 = new Usuario("Bernardo", "bernardo@ufc.br", "123456", "bernardo123", PerfilUsuario.PROFESSOR);
        model.setUsuarioLogado(user1);
        model.adicionarDisciplina(poo);
        model.adicionarDisciplina(intro);
        model.adicionarCurso(curso);
        model.adicionarUnidadeAcademica(unidade);
        model.adicionarProfessor(professor);
        Map<Integer, Usuario> usuarios = new HashMap<>();
        usuarios.put(user1.getId(), user1);
        model.setUsuarios(usuarios);

        CriarPlanoController controller = new CriarPlanoController(model);

        // Criar view e injetar plano
        CriarPlanoView view = new CriarPlanoView(controller);

        // Executar método
        view.exibirTelaCriacao();

        PlanoDeEnsino plano = model.getPlanosDeEnsino().get(1);

        new VisualizarPlanoView(new VisualizarPlanoController(model)).visualizarPlano(plano.getIdPlanoDeEnsino());

        System.out.println("View anterior");
    }
}