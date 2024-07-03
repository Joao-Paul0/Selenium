package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;

public class LoginTest {
    private LoginPage paginaDeLogin;

    // roda uma única vez
    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    // roda depois dos método
    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        this.paginaDeLogin.preecherFormularioDeLogin("fulano","pass");
        this.paginaDeLogin.efetuaLogin();

        Assertions.assertFalse(this.paginaDeLogin.isPaginaDeLogin());
        Assertions.assertEquals("fulano",this.paginaDeLogin.getNomeUsuarioLogado());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        this.paginaDeLogin.preecherFormularioDeLogin("invalido","123");
        this.paginaDeLogin.efetuaLogin();

        Assertions.assertTrue(this.paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
        Assertions.assertNull(this.paginaDeLogin.getNomeUsuarioLogado());
        Assertions.assertFalse(this.paginaDeLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
        this.paginaDeLogin.navegarParaPaginaDeLances();

        Assertions.assertTrue(this.paginaDeLogin.isPaginaDeLogin());
        // não deve conter na página leilao este titulo
        Assertions.assertFalse(this.paginaDeLogin.contemTexto("Dados do Leilão"));
    }


}
