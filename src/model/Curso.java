package model;

<<<<<<< HEAD
class Curso {
=======
public class Curso {
>>>>>>> b464222d75cc28af23baa6daeac88e2180176cf5
    private String nome;
    private int codigoCurso;
    private String modalidade;
    private int cargaHorariaTotal;
    private int idUA;
    private String nomeUA;

<<<<<<< HEAD

=======
    public Curso() {
        super();
    }

    public Curso(String nome, int codigoCurso, String modalidade, int cargaHorariaTotal, int idUA, String nomeUA) {
        this.nome = nome;
        this.codigoCurso = codigoCurso;
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

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
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
>>>>>>> b464222d75cc28af23baa6daeac88e2180176cf5
}
