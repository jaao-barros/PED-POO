package controller;

import model.Model;
import model.Professor;
import model.Usuario;
import view.CadastrarUsuarioView;
import view.MenuInicialView;
import view.TelaLoginView;


public class MenuInicialController {

    private Usuario usuarioLogado;
    private Professor professorLogado;
    private final MenuInicialView menuView;
    private final Model model;


    public MenuInicialController() {
        this.menuView = new MenuInicialView();
        this.model = Model.getInstancia();
        this.usuarioLogado = model.getUsuarioLogado();
    }

    public void iniciar() {
        int opcao;

        do {
            menuView.exibirMenu();
            opcao = menuView.lerOpcao();
        } while (processarOpcao(opcao));

        menuView.exibirMensagem("Saindo do sistema. Obrigado!");
    }

    private boolean processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                TelaLoginController loginController = new TelaLoginController(model);
                TelaLoginView loginView = new TelaLoginView(loginController);
                loginView.exibirTelaLogin();
                return true;
            case 2:
                CadastrarUsuarioController cadastroController = new CadastrarUsuarioController(model);
                CadastrarUsuarioView cadastroView = new CadastrarUsuarioView(cadastroController);
                cadastroView.exibirTelaCadastro();
                return true;
            case 3:
                return false;
            default:
                menuView.exibirOpcaoInvalida();
                return true;
        }
    }
}