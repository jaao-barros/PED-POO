package controller;
import model.*;
import view.VisualizarPlanoView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class CriarPlanoController {
    private final Model model;
    private  final VisualizarPlanoView view;
    public CriarPlanoController(Model model, VisualizarPlanoView view) {
        this.view = view;
        this.model = Model.getInstancia();
    }

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
       novoPlano.setDataUltimaModificacao(LocalDateTime.now(ZoneId.from(LocalDateTime.now())));

       return model.adicionarPlanoDeEnsino(novoPlano);

   }
}
