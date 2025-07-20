package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class CriarPlanoController {
    private final Model model;
    private Professor professorLogado;

    public CriarPlanoController(Model model) {
        this.model = model;
        this.professorLogado = model.buscarProfessorPorId(model.getUsuarioLogado().getId());
    }

    public void gerarPlano(int ano, int semestre, String justificativa, String ementa, String objetivosGerais, String objetivosEspecificos, String metodologia, String avaliacao, List<String> bibliografiaBasica, List<String> bibliografiaComplementar, int idDisciplina) {
        int idPlanoDeEnsino = model.getPlanosDeEnsino().size() + 1;
        int idProfessor = professorLogado.getIdProfessor();
        int idUnidadeAcademica = model.buscarCursoPorId(model.buscarDisciplinaPorId(idDisciplina).getIdCurso()).getIdUA();

        PlanoDeEnsino novoPlano = new PlanoDeEnsino(idPlanoDeEnsino, ano, semestre, justificativa, ementa, objetivosGerais, objetivosEspecificos, metodologia, avaliacao, new ArrayList<>(bibliografiaBasica), new ArrayList<>(bibliografiaComplementar), LocalDateTime.now(), StatusPlano.PENDENTE, idDisciplina, idProfessor, idUnidadeAcademica);

        model.adicionarPlanoDeEnsino(novoPlano);
    }

    public List<Integer> getDisciplinasLecionadas() {
        return professorLogado.getDisciplinasLecionadas();
    }

    public Disciplina buscarDisciplinaPorId(int idDisciplina) {
        return model.buscarDisciplinaPorId(idDisciplina);
    }

    public boolean validarProfessorDisciplina(Disciplina disciplina) {
        List<Integer> disciplinasLecionadas = professorLogado.getDisciplinasLecionadas();
        for (int idDisciplina : disciplinasLecionadas) {
            if (idDisciplina == disciplina.getIdDisciplina()) {
                return true;
            }
        }
        return false;
    }
}