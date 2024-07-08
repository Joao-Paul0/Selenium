package br.com.alura.leilao.leiloes;

import  br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeiloesTest {
    private LeiloesPage paginaDeLeiloes;
    private CadastroLeilaoPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preecherFormularioDeLogin("fulano","pass");
        // ao efetuar o login, vai para página de leilões.
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        // vai para página do formulário de Novo Leilão.
        this.paginaDeCadastro = this.paginaDeLeiloes.carregarFormulario();
    }
    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }

    // Na página de leilões, quero poder cadastrar um leilão.
    @Test
    public void deveriaCadastrarLeilao() {
        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia" + hoje;
        String valor = "500.00";
        // reatribuindo
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
        Assertions.assertTrue(this.paginaDeLeiloes.isLeilaoCadastrado(nome,valor,hoje));
    }

    @Test
    public void deveriaValidarCadastroDeLeilao() {
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao("","","");

        // validar se permaneceu na página. Não pode estar na url de cadastro.
        Assertions.assertFalse(this.paginaDeCadastro.isPaginaAtual());
        // validar se está na página de leilões.
        Assertions.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
        // validar se as mensagens de validação de erro estão sendo exibidas.
        Assertions.assertTrue((this.paginaDeCadastro.isMensagensDeValidacoesVisiveis()));
    }

}
