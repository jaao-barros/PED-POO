package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PlanoDeEnsino {
    private int idPlanoDeEnsino;
    private int ano;
    private int semestre;
    private String justificativa;
    private String justificativaReprovacao;
    private String ementa;
    private String objetivoGeral;
    private String objetivoEspecifico;
    private String metodologia;
    private String avaliacao;
    private ArrayList<String> bibliografiaBasica;
    private ArrayList<String> bibliografiaComplementar;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataUltimaModificacao;
    private StatusPlano status;
    private boolean isObrigatoria;
    private int codigoCurso;
    private int idDisciplina;
    private int idProfessor;
    private int idUnidadeAcademica;

    public PlanoDeEnsino() {
        super();
    }

    public PlanoDeEnsino(int idPlanoDeEnsino, int ano, int semestre, String ementa, String objetivoGeral, String objetivoEspecifico, String metodologia, String avaliacao, ArrayList<String> bibliografiaBasica, ArrayList<String> bibliografiaComplementar){
        setId(idPlanoDeEnsino);
        setAno(ano);
        setSemestre(semestre);
        setEmenta(ementa);
        setObjetivoGeral(objetivoGeral);
        setObjetivoEspecifico(objetivoEspecifico);
        setMetodologia(metodologia);
        setAvaliacao(avaliacao);
        setBibliografiaBasica(bibliografiaBasica);
        setBibliografiaComplementar(bibliografiaComplementar);
        setDataCriacao(dataCriacao);
        setDataUltimaModificacao(dataUltimaModificacao);
    }

    public int getId(){
        return idPlanoDeEnsino;
    }

    public void setId(int idPlanoDeEnsino){
        this.idPlanoDeEnsino =idPlanoDeEnsino;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao){
        dataCriacao = LocalDateTime.now();//verificar se é a primeira vez/ja existe
        this.dataCriacao = dataCriacao;//verificar se é a primeira vez/ja existe
    }

    public LocalDateTime getDataUltimaModificacao(){
        return dataUltimaModificacao;
    }

    public void setDataUltimaModificacao(LocalDateTime dataUltimaModificacao){
        dataUltimaModificacao = LocalDateTime.now();
        this.dataUltimaModificacao =dataUltimaModificacao;
    }

    public int getIdPlanoDeEnsino() {
        return idPlanoDeEnsino;
    }

    public void setIdPlanoDeEnsino(int idPlanoDeEnsino) {
        this.idPlanoDeEnsino = idPlanoDeEnsino;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getJustificativaReprovacao() {
        return justificativaReprovacao;
    }

    public void setJustificativaReprovacao(String justificativaReprovacao) {
        if (status.equals(StatusPlano.REPROVADO)) {
            this.justificativaReprovacao = justificativaReprovacao;
        }
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivoGeral() {
        return objetivoGeral;
    }

    public void setObjetivoGeral(String objetivoGeral) {
        this.objetivoGeral = objetivoGeral;
    }

    public String getObjetivoEspecifico() {
        return objetivoEspecifico;
    }

    public void setObjetivoEspecifico(String objetivoEspecifico) {
        this.objetivoEspecifico = objetivoEspecifico;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public ArrayList<String> getBibliografiaBasica() {
        return bibliografiaBasica;
    }

    public void setBibliografiaBasica(ArrayList<String> bibliografiaBasica) {
        this.bibliografiaBasica = bibliografiaBasica;
    }

    public ArrayList<String> getBibliografiaComplementar() {
        return bibliografiaComplementar;
    }

    public void setBibliografiaComplementar(ArrayList<String> bibliografiaComplementar) {
        this.bibliografiaComplementar = bibliografiaComplementar;
    }

    public StatusPlano getStatus() {
        return status;
    }

    public void setStatus(StatusPlano status) {
        this.status = status;
    }

    public boolean getIsObrigatoria() {
        return isObrigatoria;
    }

    public void setIsObrigatoria(boolean isObrigatoria) {
        this.isObrigatoria = isObrigatoria;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdUnidadeAcademica() {
        return idUnidadeAcademica;
    }

    public void setIdUnidadeAcademica(int idUnidadeAcademica) {
        this.idUnidadeAcademica = idUnidadeAcademica;
    }
}