package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import view.Observer;

public class Model {
    private static Model instancia;
    private List<Coordenacao> coordenacoes;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private List<PlanoDeEnsino> planosDeEnsino;
    private List<Professor> professores;
    private List<UnidadeAcademica> unidadesAcademicas;
    private Set<Observer> observers;

    private Model() {
        coordenacoes = new ArrayList<>();
        cursos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        planosDeEnsino = new ArrayList<>();
        professores = new ArrayList<>();
        unidadesAcademicas = new ArrayList<>();
        observers = new HashSet<>();
    }

    public static Model getInstancia() {
        if (instancia == null) {
            instancia = new Model();
        }

        return instancia;
    }

    public List<Coordenacao> getCoordenacoes() {
        return coordenacoes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<PlanoDeEnsino> getPlanosDeEnsino() {
        return planosDeEnsino;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public List<UnidadeAcademica> getUnidadesAcademicas() {
        return unidadesAcademicas;
    }

    public Set<Observer> getObservers() {
        return observers;
    }

    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public boolean adicionarObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer não pode ser nulo");
        }

        return observers.add(observer);
    }

    public boolean removerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer não pode ser nulo");
        }

        return observers.remove(observer);
    }
}