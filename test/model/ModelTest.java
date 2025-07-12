package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import view.Observer;

public class ModelTest {
    public static void main(String[] args) {
        List<String> erros = new ArrayList<>();
        Model model = Model.getInstancia();
        MockObserver observer1 = new MockObserver();
        MockObserver observer2 = new MockObserver();
        boolean resultado;

        Coordenacao coordenacao = new Coordenacao(1, 1, 1, LocalDateTime.now(), LocalDateTime.now());
        resultado = model.adicionarCoordenacao(coordenacao);
        if (!resultado) {
            erros.add("Model.adicionarCoordenacao(coordenacao) falhou em adicionar coordenação");
        }
        if (model.buscarCoordenacaoPorId(coordenacao.getIdCoordenacao()) == null) {
            erros.add("Model.buscarCoordenacao(coordenacao) falhou em buscar coordenação");
        }
        resultado = model.removerCoordenacao(coordenacao.getIdCoordenacao());
        if (!resultado) {
            erros.add("Model.removerCoordenacao(coordenacao) falhou em remover coordenação");
        }

        Curso curso = new Curso("", 1, "", 1, 1, "");
        resultado = model.adicionarCurso(curso);
        if (!resultado) {
            erros.add("Model.adicionarCurso(curso) falhou em adicionar curso");
        }
        if (model.buscarCursoPorId(curso.getCodigoCurso()) == null) {
            erros.add("Model.buscarCurso(curso) falhou em buscar curso");
        }
        resultado = model.removerCurso(curso.getCodigoCurso());
        if (!resultado) {
            erros.add("Model.removerCurso(curso) falhou em remover curso");
        }

        Disciplina disciplina = new Disciplina(3, "Disciplina Teste", "", 1, 1, 1, new ArrayList<>(), 1);
        resultado = model.adicionarDisciplina(disciplina);
        if (!resultado) {
            erros.add("Model.adicionarDisciplina(disciplina) falhou em adicionar disciplina");
        }
        if (model.buscarDisciplinaPorId(disciplina.getIdDisciplina()) == null) {
            erros.add("Model.buscarDisciplina(disciplina) falhou em buscar disciplina");
        }
        resultado = model.removerDisciplina(disciplina.getIdDisciplina());
        if (!resultado) {
            erros.add("Model.removerDisciplina(disciplina) falhou em remover disciplina");
        }

        PlanoDeEnsino plano = new PlanoDeEnsino(4, 2025, 1, "", "", "", "", "", new ArrayList<>(), new ArrayList<>());
        resultado = model.adicionarPlanoDeEnsino(plano);
        if (!resultado) {
            erros.add("Model.adicionarPlanoDeEnsino(plano) falhou em adicionar plano");
        }
        if (model.buscarPlanoDeEnsinoPorId(plano.getIdPlanoDeEnsino()) == null) {
            erros.add("Model.buscarPlanoDeEnsino(plano) falhou em buscar plano");
        }
        resultado = model.removerPlanoDeEnsino(plano.getIdPlanoDeEnsino());
        if (!resultado) {
            erros.add("Model.removerPlanoDeEnsino(plano) falhou em remover plano");
        }

        Professor professor = new Professor(1, "", "", 1);
        resultado = model.adicionarProfessor(professor);
        if (!resultado) {
            erros.add("Model.adicionarProfessor(professor) falhou em adicionar professor");
        }
        if (model.buscarProfessorPorId(professor.getIdProfessor()) == null) {
            erros.add("Model.buscarProfessor(professor) falhou em buscar professor");
        }
        resultado = model.removerProfessor(professor.getIdProfessor());
        if (!resultado) {
            erros.add("Model.removerProfessor(professor) falhou em remover professor");
        }

        UnidadeAcademica unidade = new UnidadeAcademica(1, "", "");
        resultado = model.adicionarUnidadeAcademica(unidade);
        if (!resultado) {
            erros.add("Model.adicionarUnidadeAcademica(unidade) falhou em adicionar unidade");
        }
        if (model.buscarUnidadeAcademicaPorId(unidade.getIdUnidadeAcademica()) == null) {
            erros.add("Model.buscarUnidadeAcademica(unidade) falhou em buscar unidade");
        }
        resultado = model.removerUnidadeAcademica(unidade.getIdUnidadeAcademica());
        if (!resultado) {
            erros.add("Model.removerUnidadeAcademica(unidade) falhou em remover unidade");
        }

        try {
            if (!model.adicionarObserver(observer1)) throw new Exception();
            if (!model.adicionarObserver(observer2)) throw new Exception();
        } catch (Exception ex) {
            erros.add("Model.adicionarObserver(observer) não adicionou observer");
        }

        try {
            model.adicionarObserver(null);
        } catch (Exception ex) {
            if (!(ex instanceof IllegalArgumentException)) {
                erros.add("Model.adicionarObserver(null) não lançou exceção");
            }
        }

        try {
            if (!model.removerObserver(observer1)) throw new Exception();
            if (!model.removerObserver(observer2)) throw new Exception();
        } catch (Exception ex) {
            erros.add("Model.removerObserver(observer) não removeu observer");
        }

        try {
            model.removerObserver(null);
        } catch (Exception ex) {
            if (!(ex instanceof IllegalArgumentException)) {
                erros.add("Model.removerObserver(null) não lançou exceção");
            }
        }

        model.notificarObservers();

        for (Observer o : model.getObservers()) {
            MockObserver observer = (MockObserver) o;
            if (!observer.getObserverAtualizado()) {
                erros.add("Model.notificarObservers() não notificou os observers cadastrados");
            }
        }

        if (erros.isEmpty()) {
            System.out.println("A classe Model passou em todos os testes");
        } else {
            System.out.println(erros.size() + " erro(s) encontrado(s):");
            for (String erro : erros) {
                System.out.println("- " + erro);
            }        }
    }
}

class MockObserver implements Observer {
    private boolean observerAtualizado = false;

    @Override
    public void update() {
        observerAtualizado = true;
    }

    public boolean getObserverAtualizado() {
        return observerAtualizado;
    }
}
