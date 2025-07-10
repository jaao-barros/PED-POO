package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import view.Observer;

public class Model {
    private List<Coordenacao> coordenacoes;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private List<PlanoDeEnsino> planosDeEnsino;
    private List<Professor> professores;
    private List<UnidadeAcademica> unidadesAcademicas;
    private Set<Observer> observers;
    private static Model instancia;

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

    public void notificarObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}