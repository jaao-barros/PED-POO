package model;

public class Usuario {
    private final int id;
    private String nome;
    private String email;
    private String matricula;
    private String senha;
    private PerfilUsuario perfil;

    public Usuario(String nome, String email, String matricula, String senha, PerfilUsuario perfil) {
        this.id = Model.getInstancia().getUsuarios().size() + 1;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.senha = senha;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }
}
