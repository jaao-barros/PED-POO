package controller;
import java.util.List;
import model.*;
import view.EditarPlanoView;
import view.VisualizarPlanoView;

public class ListarPlanosController {
    private final Model model;
    private final Usuario usuarioLogado;
    private PerfilUsuario perfilUsuarioLogado;
    private boolean logoutSolicitado = false;

    public ListarPlanosController(Model model) {
        this.model = model;
        this.usuarioLogado = model.getUsuarioLogado();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public PerfilUsuario getPerfilUsuarioLogado() {
        return usuarioLogado.getPerfil();
    }

    public void logout() {
        this.logoutSolicitado = true;
    }

    public List<PlanoDeEnsino> getPlanosPorPerfil() {
        String tipoPerfil = usuarioLogado.getPerfil().name();
        if ("PROFESSOR".equals(tipoPerfil)) {
            return model.buscarPlanosPorProfessor(usuarioLogado.getId());
        } else if ("ALUNO".equals(tipoPerfil)) {
            return model.buscarPlanosAprovadosPorAluno(usuarioLogado.getId());
        } else if ("COORDENADOR".equals(tipoPerfil)) {
            return model.buscarTodosPlanosSubmetidos();
        }
        return List.of();
    }

    public PlanoDeEnsino getPlanoPorId(int idPlano) {
        return model.buscarPlanoDeEnsinoPorId(idPlano);
    }

    public Disciplina getDisciplinaPorPlano(int idPlano) {
        return model.buscarDisciplinaPorId(model.buscarPlanoDeEnsinoPorId(idPlano).getIdDisciplina());
    }

    public boolean isLogoutSolicitado() {
        return logoutSolicitado;
    }

    public void setLogoutSolicitado(boolean logoutSolicitado) {
        this.logoutSolicitado = logoutSolicitado;
    }

    public void visualizarPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");

        System.out.println();

        VisualizarPlanoController visualizarPlanoController = new VisualizarPlanoController(model);
        VisualizarPlanoView visualizarPlanoView = new VisualizarPlanoView(visualizarPlanoController);
        visualizarPlanoView.visualizarPlano(plano.getIdPlanoDeEnsino());
    }

    public void editarPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");

        EditarPlanoController editarPlanoController = new EditarPlanoController(model);
        EditarPlanoView editarPlanoView = new EditarPlanoView(editarPlanoController);
        editarPlanoView.editarPlano(plano.getIdPlanoDeEnsino());

        model.atualizarPlano(plano);
    }

    public void submeterPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");
        //caso possa ser submetido entra em pendicia
        if (plano.getStatus() != StatusPlano.PENDENTE && plano.getStatus() != StatusPlano.REPROVADO) {
            throw new IllegalArgumentException("Apenas planos pendentes ou reprovados podem ser submetidos.");
        }
        model.submeterParaAprovacao(plano);
    }

    public void aprovarPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");
        //so pode ser aprovado se tiver em revisao
        if (plano.getStatus() != StatusPlano.EM_REVISAO) {
            throw new IllegalArgumentException("Apenas planos em revisão podem ser aprovados.");
        }
        model.aprovarPlano(plano);
    }

    public void reprovarPlano(PlanoDeEnsino plano, String justificativa) {
        if (plano == null) throw new IllegalArgumentException("Plano não foi encontrado!");
        if (justificativa == null || justificativa.isEmpty()) {
            throw new IllegalArgumentException("A Justificativa é obrigatória para a reprovação.");
        }
        // que só planos EM_REVISAO podem ser reprovados
        if (plano.getStatus() != StatusPlano.EM_REVISAO) {
            throw new IllegalArgumentException("Apenas planos em revisão podem ser reprovados.");
        }
        model.reprovarPlano(plano, justificativa);
    }
    public void sair() {
        System.exit(0);
    }

}