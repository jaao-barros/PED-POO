package model;

import view.Observer;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Coordenacao> coordenacoes;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private List<PlanoDeEnsino> planosDeEnsino;
    private List<Professor> professores;
    private List<UnidadeAcademica> unidadesAcademicas;
    private List<Observer> observers;
    private static Model instancia;

    private Model() {
        coordenacoes = new ArrayList<>();
        cursos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        planosDeEnsino = new ArrayList<>();
        professores = new ArrayList<>();
        unidadesAcademicas = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Model getInstancia() {
        if (instancia == null) {
            instancia = new Model();
        }

        return instancia;
    }
}