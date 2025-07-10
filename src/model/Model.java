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

    public void setCoordenacoes(List<Coordenacao> coordenacoes) {
        if (coordenacoes == null) {
            throw new IllegalArgumentException("Lista de coordenações não pode ser nula");
        }

        this.coordenacoes = coordenacoes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        if (cursos == null) {
            throw new IllegalArgumentException("Lista de cursos não pode ser nula");
        }

        this.cursos = cursos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        if (disciplinas == null) {
            throw new IllegalArgumentException("Lista de disciplinas não pode ser nula");
        }

        this.disciplinas = disciplinas;
    }

    public List<PlanoDeEnsino> getPlanosDeEnsino() {
        return planosDeEnsino;
    }

    public void setPlanosDeEnsino(List<PlanoDeEnsino> planosDeEnsino) {
        if (planosDeEnsino == null) {
            throw new IllegalArgumentException("Lista de planos de ensino não pode ser nula");
        }

        this.planosDeEnsino = planosDeEnsino;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        if (professores == null) {
            throw new IllegalArgumentException("Lista de professores não pode ser nula");
        }

        this.professores = professores;
    }

    public List<UnidadeAcademica> getUnidadesAcademicas() {
        return unidadesAcademicas;
    }

    public void setUnidadesAcademicas(List<UnidadeAcademica> unidadesAcademicas) {
        if (unidadesAcademicas == null) {
            throw new IllegalArgumentException("Lista de unidades acadêmicas não pode ser nula");
        }

        this.unidadesAcademicas = unidadesAcademicas;
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
            throw new IllegalArgumentException("Observer não pode ser null");
        }

        return observers.add(observer);
    }

    public boolean removerObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer não pode ser null");
        }

        return observers.remove(observer);
    }
}