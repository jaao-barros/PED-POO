package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Coordenacao {
    private int idCoordenacao;
    private int idCurso;
    private int idProfessorCoordenador;
    private LocalDateTime inicioGestao;
    private LocalDateTime fimGestao;

    public Coordenacao() {
        super();
    }

    public Coordenacao(int idCoordenacao, int idCurso, int idProfessorCoordenador, LocalDateTime inicioGestao, LocalDateTime fimGestao) {
        setIdCoordenacao(idCoordenacao);
        setIdCurso(idCurso);
        setIdProfessorCoordenador(idProfessorCoordenador);
        setInicioGestao(inicioGestao);
        setFimGestao(fimGestao);
    }

    public int getIdCoordenacao() {
        return idCoordenacao;
    }

    public void setIdCoordenacao(int idCoordenacao) {
        this.idCoordenacao = idCoordenacao;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfessorCoordenador() {
        return idProfessorCoordenador;
    }

    public void setIdProfessorCoordenador(int idProfessorCoordenador) {
        this.idProfessorCoordenador = idProfessorCoordenador;
    }

    public LocalDateTime getInicioGestao() {
        return inicioGestao;
    }

    public void setInicioGestao(LocalDateTime inicioGestao) {
        this.inicioGestao = inicioGestao;
    }

    public LocalDateTime getFimGestao() {
        return fimGestao;
    }

    public void setFimGestao(LocalDateTime fimGestao) {
        this.fimGestao = fimGestao;
    }

    public boolean aprovarPlanoDeEnsino(PlanoDeEnsino plano){
        return true;
    }

    public boolean rejeitarPlanoDeEnsino(PlanoDeEnsino plano){
        return true;
    }

    public boolean solicitarRevisaoPlanoDeEnsino(PlanoDeEnsino plano){
        return true;
    }

    public void vincularProfessorCoordenador(Professor professor){}

    public ArrayList<PlanoDeEnsino> getPlanosDeEnsinoPendentes(ArrayList<PlanoDeEnsino> listaplanopendente){return listaplanopendente;}
}