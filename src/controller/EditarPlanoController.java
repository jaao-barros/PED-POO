package controller;

import model.*;

import java.util.ArrayList;

public class EditarPlanoController {
    private final Model model;
    private int idPlanoDeEnsino;

    public EditarPlanoController(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public int getIdPlanoDeEnsino() {
        return idPlanoDeEnsino;
    }

    public void setIdPlanoDeEnsino(int idPlanoDeEnsino) {
        this.idPlanoDeEnsino = idPlanoDeEnsino;
    }

    public PlanoDeEnsino buscarPlanoDeEnsinoPorId(int idPlanoDeEnsino) {
        return model.buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);
    }

    public ArrayList<String> getBibliografias(String tipoBibliografia) {
        if (tipoBibliografia == null) {
            throw new IllegalArgumentException("Tipo de bibliografia não pode ser nulo");
        }

        if (tipoBibliografia.equals("basica")) {
            return buscarPlanoDeEnsinoPorId(idPlanoDeEnsino).getBibliografiaBasica();
        }

        if (tipoBibliografia.equals("complementar")) {
            return buscarPlanoDeEnsinoPorId(idPlanoDeEnsino).getBibliografiaComplementar();
        }

        return null;
    }

    public void editarCampo(String idSecao, String idSubsecao, String valor) {
        PlanoDeEnsino planoDeEnsino = buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);

        switch (idSecao) {
            case "1":
                Disciplina disciplina = model.buscarDisciplinaPorCodigo(valor);

                if (disciplina == null) {
                    throw new IllegalArgumentException("Código da disciplina não é válido");
                }

                planoDeEnsino.setIdDisciplina(disciplina.getIdDisciplina());
                break;
            case "2":
                planoDeEnsino.setJustificativa(valor);
                break;
            case "3":
                planoDeEnsino.setEmenta(valor);
                break;
            case "4":
                if (idSubsecao.equals("1")) {
                    planoDeEnsino.setObjetivoGeral(valor);
                } else if (idSubsecao.equals("2")) {
                    planoDeEnsino.setObjetivoEspecifico(valor);
                }
                break;
            case "5":
                planoDeEnsino.setMetodologia(valor);
                break;
            case "6":
                planoDeEnsino.setAvaliacao(valor);
                break;
        }
    }

    public void adicionarBibliografia(String tipoBibliografia, String valor) {
        PlanoDeEnsino planoDeEnsino = model.buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);

        if (tipoBibliografia.equals("basica")) {
            planoDeEnsino.getBibliografiaBasica().add(valor);
        } else if  (tipoBibliografia.equals("complementar")) {
            planoDeEnsino.getBibliografiaComplementar().add(valor);
        }
    }

    public void removerBibliografia(String tipoBibliografia, String id) {
        PlanoDeEnsino planoDeEnsino = model.buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);

        int index = Integer.parseInt(id) - 1;

        if (tipoBibliografia.equals("basica")) {
            planoDeEnsino.getBibliografiaBasica().remove(index);
        } else if  (tipoBibliografia.equals("complementar")) {
            planoDeEnsino.getBibliografiaComplementar().remove(index);
        }
    }

    public void editarBibliografia(String tipoBibliografia, String id, String valor) {
        PlanoDeEnsino planoDeEnsino = model.buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);

        int index = Integer.parseInt(id) - 1;

        if (tipoBibliografia.equals("basica")) {
            planoDeEnsino.getBibliografiaBasica().set(index, valor);
        } else if  (tipoBibliografia.equals("complementar")) {
            planoDeEnsino.getBibliografiaComplementar().set(index, valor);
        }
    }

    public StatusPlano getStatusPlano() {
        return buscarPlanoDeEnsinoPorId(idPlanoDeEnsino).getStatus();
    }

    public PerfilUsuario getPerfilUsuarioLogado() {
        return model.getUsuarioLogado().getPerfil();
    }
}
