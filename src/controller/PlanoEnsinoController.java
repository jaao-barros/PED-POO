package controller;
import jdk.jshell.Snippet;
import model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PlanoEnsinoController {
    private final Model model;

    public PlanoEnsinoController(Model model) {
        this.model = Model.getInstancia();
    }

    // colocar os metodos q a view vai chamar, dps de ter a entrada de dados do usuario (se formos usar terminal ou swing, nun sei)

   public boolean criarPlanoEnsino(int id, int ano, int semestre, String ementa, String objGeral,
                                   String objEspecifico, String metodologia, String avaliacao,
                                   ArrayList<String> biblioBasica, ArrayList<String> biblioComplementar,
                                   int idDisciplina, int idProfessor){
        PlanoDeEnsino novoPlano = new PlanoDeEnsino();
        novoPlano.setId(id);
        novoPlano.setAno(ano);
        novoPlano.setSemestre(semestre);
        novoPlano.setEmenta(ementa);
        novoPlano.setObjetivoGeral(objGeral);
        novoPlano.setObjetivoEspecifico(objEspecifico);
        novoPlano.setAvaliacao(avaliacao);
        novoPlano.setBibliografiaBasica(biblioBasica);
        novoPlano.setBibliografiaComplementar(biblioComplementar);
        novoPlano.setIdDisciplina(idDisciplina);
        novoPlano.setIdProfessor(idProfessor);

       novoPlano.setStatus(StatusPlano.PENDENTE);
       novoPlano.setDataCriacao(LocalDateTime.now());
       novoPlano.setDataUltimaModificacao(LocalDateTime.now(LocalDateTime.now()));

       return model.adicionarPlanoDeEnsino(novoPlano);

   }
}
