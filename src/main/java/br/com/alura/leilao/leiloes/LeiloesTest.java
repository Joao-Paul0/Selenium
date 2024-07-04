package br.com.alura.leilao.leiloes;

import  br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeiloesTest {
    private LeiloesPage paginaDeLeiloes;

    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }

    @Test
    public void deveriaCadastrarLeilao() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preecherFormularioDeLogin("fulano","pass");
        // ao efetuar o login, vai para página de leilões.
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        // vai para página do formulário de Novo Leilão.
        CadastroLeilaoPage paginaDeCadastro = this.paginaDeLeiloes.carregarFormulario();
    }


}
