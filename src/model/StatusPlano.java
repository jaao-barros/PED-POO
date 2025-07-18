package model;

public enum StatusPlano {
<<<<<<< HEAD
    EM_REVISAO,
    APROVADO,
    PENDENTE,
    REPROVADO
=======
    EM_REVISAO("Em revisão"),
    APROVADO("Aprovado"),
    PENDENTE("Pendente"),
    REPROVADO("Reprovado");

    private final String nome;

    StatusPlano(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
>>>>>>> b464222d75cc28af23baa6daeac88e2180176cf5
}
