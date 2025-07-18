package controller;

import java.util.List;
import java.util.ArrayList;

import model.*;

public class VisualizarPlanoController {
    private final Model model;

    public VisualizarPlanoController(Model model) {
        this.model = model;
    }

    public PlanoDeEnsino buscarPlanoDeEnsinoPorId(int idPlanoDeEnsino) {
        return model.buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);
    }

    public Disciplina getDisciplina(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano de ensino não pode ser nulo.");
        return model.buscarDisciplinaPorId(plano.getIdDisciplina());
    }

    public Disciplina getDisciplina(int idDisciplina) {
        return model.buscarDisciplinaPorId(idDisciplina);
    }

    public Professor getProfessor(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano de ensino não pode ser nulo.");
        return model.buscarProfessorPorId(plano.getIdProfessor());
    }

    public Curso getCurso(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano de ensino não pode ser nulo.");
        return model.buscarCursoPorId(plano.getCodigoCurso());
    }

    public UnidadeAcademica getUnidade(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano de ensino não pode ser nulo.");
        return model.buscarUnidadeAcademicaPorId(plano.getIdUnidadeAcademica());
    }

    public List<Disciplina> getPreRequisitos(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano de ensino não pode ser nulo.");

        Disciplina disciplina = model.buscarDisciplinaPorId(plano.getIdDisciplina());
        List<Disciplina> pre = new ArrayList<>();

        for (Integer id : disciplina.getPreRequisitos()) {
            pre.add(model.buscarDisciplinaPorId(id));
        }

        return pre;
    }

    public PerfilUsuario getPerfilUsuarioLogado() {
        return model.getUsuarioLogado().getPerfil();
    }
}
