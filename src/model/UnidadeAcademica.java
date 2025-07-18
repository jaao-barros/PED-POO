package model;

public class UnidadeAcademica implements Universidade {
<<<<<<< HEAD
    private int idUA;
    private String nome;
    private String endereco;
=======
    private int idUnidadeAcademica;
    private String nome;
    private String endereco;

    public UnidadeAcademica() {
        super();
    }

    public UnidadeAcademica(int idUnidadeAcademica, String nome, String endereco) {
        this.idUnidadeAcademica = idUnidadeAcademica;
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getIdUnidadeAcademica() {
        return idUnidadeAcademica;
    }

    public void setIdUnidadeAcademica(int idUnidadeAcademica) {
        this.idUnidadeAcademica = idUnidadeAcademica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
>>>>>>> b464222d75cc28af23baa6daeac88e2180176cf5
}
