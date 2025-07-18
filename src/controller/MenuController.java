package controller;


import model.*;
import view.MenuView;

public class MenuController {

    private Usuario usuarioLogado;
    private final MenuView menuView;

    public MenuController() {
        this.menuView = new MenuView();

        this.usuarioLogado = new Usuario("João Silva", PerfilUsuario.ALUNO);
    }

    // metodo para iniciar o menu
    public void iniciar() {
        menuView.exibirBoasVindas(usuarioLogado.getNome(), usuarioLogado.getPerfil());
        int opcao;
        do {
            exibirMenuPorPerfil();
            opcao = menuView.lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0 && opcao != 5);

        menuView.fecharScanner();
        menuView.exibirMensagem("Saindo do sistema. Obrigado!");
    }

    private void exibirMenuPorPerfil() {
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
                menuView.exibirMensagem("Perfil não reconhecido. Opções limitadas.");
                menuView.exibirMenuAluno();
                break;
        }
    }

    private void processarOpcao(int opcao) {
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
                visualizarPlanosEnsino();
                break;
            case 2:
                sairDaConta();
                break;
            case 3:
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }

    private void processarOpcaoProfessor(int opcao) {
        switch (opcao) {
            case 1:
                visualizarPlanosEnsino();
                break;
            case 2:
                criarEditarSubmeterPlanos();
                break;
            case 3:
                verFeedbackPlanosReprovados();
                break;
            case 4:
                sairDaConta();
                break;
            case 5:
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }

    private void processarOpcaoCoordenador(int opcao) {
        switch (opcao) {
            case 1:
                visualizarPlanosEnsino();
                break;
            case 2:
                sairDaConta();
                break;
            case 3:
                break;
            default:
                menuView.exibirOpcaoInvalida();
                break;
        }
    }

    // --- Métodos que simulam as funcionalidades ---
    private void visualizarPlanosEnsino() {
        menuView.exibirMensagem("Executando: Visualizar planos de ensino...");
        // Adicione a lógica real aqui (ex: buscar do banco de dados e imprimir)
    }

    private void criarEditarSubmeterPlanos() {
        menuView.exibirMensagem("Executando: Criar; submeter planos...");
        // Adicione a lógica real aqui
    }

    private void verFeedbackPlanosReprovados() {
        menuView.exibirMensagem("Executando: Ver feedback de planos reprovados...");
        // Adicione a lógica real aqui
    }

    private void aprovarReprovarPlanos() {
        menuView.exibirMensagem("Executando: Aprovar/reprovar planos submetidos...");
        // Adicione a lógica real aqui
    }

    private void acessarHistoricoPlanosCurso() {
        menuView.exibirMensagem("Executando: Acessar histórico de todos os planos do curso...");
        // Adicione a lógica real aqui
    }

    private void sairDaConta() {
        menuView.exibirMensagem("Saindo da conta atual...");


        this.usuarioLogado = null; // "Desloga" o usuário
    }
}