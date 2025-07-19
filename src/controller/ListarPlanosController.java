package controller;
import java.util.List;
import model.*;

public class ListarPlanosController {
    private final Model model;
    private final Usuario usuarioLogado;

    public ListarPlanosController(Model model, Usuario usuarioLogado) {
        this.model = model;
        this.usuarioLogado = usuarioLogado;
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

    public void visualizarPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");
        if (plano.getStatus() != StatusPlano.APROVADO) {
            throw new IllegalArgumentException("Apenas planos aprovados podem ser visualizados.");
        }
    }

    public void editarPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");
        if (plano.getStatus() != StatusPlano.APROVADO) {
            throw new IllegalArgumentException("Apenas planos aprovados podem ser editados.");
        }
        model.atualizarPlano(plano);
    }

    public void submeterPlano(PlanoDeEnsino plano) {
        if (plano == null) throw new IllegalArgumentException("Plano não encontrado.");
        //caso possa ser submetido entra em pendicia
        if (plano.getStatus() != StatusPlano.PENDENTE) {
            throw new IllegalArgumentException("Apenas planos pendentes podem ser submetidos.");
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
        // Assumindo que só planos EM_REVISAO podem ser reprovados
        if (plano.getStatus() != StatusPlano.EM_REVISAO) {
            throw new IllegalArgumentException("Apenas planos em revisão podem ser reprovados.");
        }
        model.reprovarPlano(plano, justificativa);
    }
    public void sair() {
        System.exit(0);
    }
}