package model;

import java.util.ArrayList;

public class Disciplina {
    private int idDisciplina;
    private String nome;
    private String codigoDisciplina;
    private int cargaHorariaTeorica;
    private int cargaHorariaPratica;
    private int periodoRecomendado;
    private ArrayList<Integer> preRequisitos;
    private int idCurso;

    public Disciplina() {
        super();
    }

    public Disciplina(int idDisciplina, String nome, String codigoDisciplina, int cargaHorariaTeorica, int cargaHorariaPratica, int periodoRecomendado, ArrayList<Integer> preRequisitos, int idCurso) {
        this.idDisciplina = idDisciplina;
        this.nome = nome;
        this.codigoDisciplina = codigoDisciplina;
        this.cargaHorariaTeorica = cargaHorariaTeorica;
        this.cargaHorariaPratica = cargaHorariaPratica;
        this.periodoRecomendado = periodoRecomendado;
        this.preRequisitos = preRequisitos;
        this.idCurso = idCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCargaHorariaTeorica() {
        return cargaHorariaTeorica;
    }

    public void setCargaHorariaTeorica(int cargaHorariaTeorica) {
        this.cargaHorariaTeorica = cargaHorariaTeorica;
    }

    public int getCargaHorariaPratica() {
        return cargaHorariaPratica;
    }

    public void setCargaHorariaPratica(int cargaHorariaPratica) {
        this.cargaHorariaPratica = cargaHorariaPratica;
    }

    public int getPeriodoRecomendado() {
        return periodoRecomendado;
    }

    public void setPeriodoRecomendado(int periodoRecomendado) {
        this.periodoRecomendado = periodoRecomendado;
    }

    public ArrayList<Integer> getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(ArrayList<Integer> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
