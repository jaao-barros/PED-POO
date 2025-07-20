package controller;

import model.*;
import view.CriarPlanoView;
import view.ListarPlanosView;
import view.MenuView;


public class MenuController {

    private Usuario usuarioLogado;
    private Professor professorLogado;
    private final MenuView menuView;
    private final Model model;


    public MenuController() {
        this.menuView = new MenuView();
        this.model = Model.getInstancia();
        this.usuarioLogado = model.getUsuarioLogado();
    }

    //oi
    public void iniciar() {

        if (usuarioLogado == null) {
            menuView.exibirMensagem("Erro: Nao ha usuario logado. Retornando ao login.");
            return;
        }


        menuView.exibirBoasVindas(usuarioLogado.getNome(), usuarioLogado.getPerfil());
        int opcao;


        do {
            exibirMenuPorPerfil();
            opcao = menuView.lerOpcao();
            processarOpcao(opcao);


            if (usuarioLogado == null) {
                break;
            }


        } while (opcao != 0);


        menuView.fecharScanner();
        menuView.exibirMensagem("Saindo do sistema. Obrigado!");
        System.exit(0);
    }



    private void exibirMenuPorPerfil() {

        if (usuarioLogado == null) {
            menuView.exibirMensagem("Erro: Nenhum usuario logado para exibir o menu.");

            return;
        }

        switch (usuarioLogado.getPerfil()) {
            case ALUNO:
                menuView.exibirMenuAluno();
                break;
            case PROFESSOR:
                menuView.exibirMenuProfessor();
                break;
            case COORDENADOR:
                menuView.exibirMenuCoordenador();
                break;
            default:
                menuView.exibirMensagem("Perfil nao reconhecido. Opcoes limitadas.");
                menuView.exibirMenuAluno();
                break;
        }
    }

    private void processarOpcao(int opcao) {
        if (usuarioLogado == null) {
            menuView.exibirMensagem("Erro: Nenhuma sessao ativa para processar a opcao.");
            return;
        }

        switch (usuarioLogado.getPerfil()) {
            case ALUNO:
                processarOpcaoAluno(opcao);
                break;
            case PROFESSOR:
                processarOpcaoProfessor(opcao);
                break;
            case COORDENADOR:
                processarOpcaoCoordenador(opcao);
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }

    private void processarOpcaoAluno(int opcao) {
        switch (opcao) {
            case 1:
                ListarPlanosController listarPlanosController = new ListarPlanosController(this.model);
                ListarPlanosView listarPlanosView = new ListarPlanosView(listarPlanosController);
                listarPlanosView.exibirTelaListagem();
                break;
            case 2:
                sairDaConta();
                break;
            case 3:
                System.exit(0);
                break;
            case 0:
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }

    private void processarOpcaoProfessor(int opcao) {
        switch (opcao) {
            case 1:
                ListarPlanosController listarPlanosController = new ListarPlanosController(this.model);
                ListarPlanosView listarPlanosView = new ListarPlanosView(listarPlanosController);
                listarPlanosView.exibirTelaListagem();
                break;
            case 2:
                CriarPlanoController criarPlanoController = new CriarPlanoController(this.model);
                CriarPlanoView criarPlanoView = new CriarPlanoView(criarPlanoController);
                criarPlanoView.exibirTelaCriacao();
                break;
            case 3:
                sairDaConta();
                break;
            case 4:
                System.exit(0);
                break;
            case 0:
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }

    private void processarOpcaoCoordenador(int opcao) {
        switch (opcao) {
            case 1:
                ListarPlanosController listarPlanosController = new ListarPlanosController(this.model);
                ListarPlanosView listarPlanosView = new ListarPlanosView(listarPlanosController);
                listarPlanosView.exibirTelaListagem();
                break;
            case 2:
                sairDaConta();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }



    private void sairDaConta() {
        menuView.exibirMensagem("Saindo da conta atual...");
        this.usuarioLogado = null;
        model.setUsuarioLogado(null);

    }
}