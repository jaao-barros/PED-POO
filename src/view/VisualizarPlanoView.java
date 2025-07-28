package view;

import java.util.List;
import java.util.Scanner;

import controller.VisualizarPlanoController;
import model.PerfilUsuario;
import model.PlanoDeEnsino;
import model.StatusPlano;

public class VisualizarPlanoView implements Observer {
    private final VisualizarPlanoController controller;
    private final PerfilUsuario perfil;

    public VisualizarPlanoView(VisualizarPlanoController controller) {
        this.controller = controller;
        perfil = controller.getPerfilUsuarioLogado();
    }

    public VisualizarPlanoController getController() {
        return controller;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void visualizarPlano(int idPlanoDeEnsino) {
        PlanoDeEnsino planoDeEnsino = controller.buscarPlanoDeEnsinoPorId(idPlanoDeEnsino);

        if (perfil.equals(PerfilUsuario.ALUNO) && !planoDeEnsino.getStatus().equals(StatusPlano.APROVADO)) {
            System.out.println("Você não tem permissão para acessar esta tela");
            return;
        }

        System.out.print("PLANO DE ENSINO DE DISCIPLINA\n");

        if (perfil.equals(PerfilUsuario.PROFESSOR) || perfil.equals(PerfilUsuario.COORDENADOR)) {
            System.out.println("\nStatus: " + planoDeEnsino.getStatus().getNome());

            if (planoDeEnsino.getStatus().equals(StatusPlano.REPROVADO)) {
                System.out.println("\nJustificativa da reprovação:");
                System.out.println("    " +  planoDeEnsino.getJustificativaReprovacao());
            }
        }

        System.out.printf("\nAno/Semestre: %d.%d\n\n", planoDeEnsino.getAno(), planoDeEnsino.getSemestre());

        System.out.println("1. Identificação");
        System.out.println("    1.1. Unidade: " + controller.getUnidade(planoDeEnsino).getNome());
        System.out.println("    1.2. Curso: " + controller.getCurso(planoDeEnsino).getNome());
        System.out.println("    1.3. Nome da Disciplina: " + controller.getDisciplina(planoDeEnsino).getNome());
        System.out.println("    1.4. Código da Disciplina: " + controller.getDisciplina(planoDeEnsino).getCodigoDisciplina());
        System.out.printf("    1.5. Caráter da Disciplina: %s\n", planoDeEnsino.getIsObrigatoria() ? "Obrigatória" : "Optativa");
        System.out.println("    1.6. Carga horária:");
        System.out.printf("        - Total: %dh\n", controller.getDisciplina(planoDeEnsino).getCargaHorariaTeorica() + controller.getDisciplina(planoDeEnsino).getCargaHorariaPratica());
        System.out.printf("        - Teórica: %dh\n", controller.getDisciplina(planoDeEnsino).getCargaHorariaTeorica());
        System.out.printf("        - Prática: %dh\n", controller.getDisciplina(planoDeEnsino).getCargaHorariaPratica());
        System.out.print("    1.7. Pré-requisitos: ");

        List<Integer> preRequisitos = controller.getDisciplina(planoDeEnsino).getPreRequisitos();

        if (preRequisitos.isEmpty()) {
            System.out.println("Nenhum");
        }

        for (int i = 0; i < preRequisitos.size(); i++) {
            int idPreRequisito = preRequisitos.get(i);
            System.out.print(controller.getDisciplina(idPreRequisito).getCodigoDisciplina() + " - ");
            System.out.print(controller.getDisciplina(idPreRequisito).getNome());

            if (i < preRequisitos.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }

        System.out.println("    1.8. Professor: " + controller.getProfessor(planoDeEnsino).getNome());

        System.out.println("\n2. Justificativa:");
        System.out.println("    " + planoDeEnsino.getJustificativa());

        System.out.println("\n3. Ementa:");
        System.out.println("    " + planoDeEnsino.getEmenta());

        System.out.println("\n4. Objetivos:");
        System.out.println("    4.1. Geral:");
        System.out.println("        " + planoDeEnsino.getObjetivoGeral());
        System.out.println("    4.2. Específicos:");
        System.out.println("        " + planoDeEnsino.getObjetivoEspecifico());

        System.out.println("\n5. Metodologia de ensino:");
        System.out.println("    " + planoDeEnsino.getMetodologia());

        System.out.println("\n6. Sistema de Avaliação:");
        System.out.println("    " + planoDeEnsino.getAvaliacao());

        System.out.println("\n7. Bibliografia:");

        System.out.println("    7.1. Bibliografia básica:");
        for (String material : planoDeEnsino.getBibliografiaBasica()){
            System.out.println("      - " + material);
        }

        System.out.println("\n    7.2. Bibliografia complementar:");
        for (String material : planoDeEnsino.getBibliografiaComplementar()){
            System.out.println("      - " + material);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPressione ENTER para voltar");
        scanner.nextLine();
    }

    @Override
    public void update() {

    }
}
