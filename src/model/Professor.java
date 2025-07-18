package model;

public class Professor {
    private int idProfessor;
    private String nome;
    private String email;
    private int idUA;

    public Professor() {
        super();
    }

    public Professor(int idProfessor, String nome, String email, int idUA) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
        this.idUA = idUA;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }
}
