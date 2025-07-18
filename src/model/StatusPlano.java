package model;

public enum StatusPlano {
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
}
