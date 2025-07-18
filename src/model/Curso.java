package model;

public class Curso {
    private String nome;
    private int idCurso;
    private String modalidade;
    private int cargaHorariaTotal;
    private int idUA;
    private String nomeUA;

    public Curso() {
        super();
    }

    public Curso(String nome, int idCurso, String modalidade, int cargaHorariaTotal, int idUA, String nomeUA) {
        this.nome = nome;
        this.idCurso = idCurso;
        this.modalidade = modalidade;
        this.cargaHorariaTotal = cargaHorariaTotal;
        this.idUA = idUA;
        this.nomeUA = nomeUA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }

    public String getNomeUA() {
        return nomeUA;
    }

    public void setNomeUA(String nomeUA) {
        this.nomeUA = nomeUA;
    }
}
