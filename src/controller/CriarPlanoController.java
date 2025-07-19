package controller;
import model.Professor;
import java.util.List;
import model.*;

public class CriarPlanoController {
    private final Model model;
    private Professor professorLogado;

    public CriarPlanoController(Model model, Professor professorLogado) {
        this.model = model;
        this.professorLogado = professorLogado;
    }

    public List<Disciplina> getDisciplinasLecionadas() {
        return model.buscarDisciplinasPorProfessor(professorLogado.getIdProfessor());
    }

    public boolean validarProfessorDisciplina(Disciplina disciplina) {
        List<Disciplina> disciplinasLecionadas = getDisciplinasLecionadas();
        for (Disciplina d : disciplinasLecionadas) {
            if (d.getIdDisciplina() == disciplina.getIdDisciplina()) {
                return true;
            }
        }
        return false;
    }

    public void salvarComoRascunho(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("O plano de ensino não pode ser nulo.");
        if (!validarProfessorDisciplina(model.buscarDisciplinaPorId(plano.getIdDisciplina()))) {
            throw new IllegalArgumentException("O Professor não leciona essa disciplina!");
        }
        model.salvarRascunho(plano);
    }

    public void submeterParaAprovacao(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano de ensino não pode ser nulo.");
        if (!validarProfessorDisciplina(model.buscarDisciplinaPorId(plano.getIdDisciplina()))) {
            throw new IllegalArgumentException("O Professor não leciona essa disciplina!");
        }
        if (plano.getEmenta() == null || plano.getEmenta().trim().isEmpty() ||
                plano.getObjetivoGeral() == null || plano.getObjetivoGeral().trim().isEmpty() ||
                plano.getMetodologia() == null || plano.getMetodologia().trim().isEmpty() ||
                plano.getAvaliacao() == null || plano.getAvaliacao().trim().isEmpty() ||
                plano.getBibliografiaComplementar() == null || plano.getBibliografiaComplementar().isEmpty() ||
                plano.getBibliografiaBasica() == null || plano.getBibliografiaBasica().isEmpty() ||
                plano.getSemestre() == 0) {
            throw new IllegalArgumentException("Todos os campos obrigatórios devem ser preenchidos.");
        }
        model.submeterParaAprovacao(plano);
    }
}