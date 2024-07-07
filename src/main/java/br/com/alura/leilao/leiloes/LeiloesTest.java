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

    @AfterEach
    public void afterEach() {
        this.paginaDeLeiloes.fechar();
    }

    // Na página de leilões, quero poder cadastrar um leilão.
    @Test
    public void deveriaCadastrarLeilao() {
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preecherFormularioDeLogin("fulano","pass");
        // ao efetuar o login, vai para página de leilões.
        this.paginaDeLeiloes = paginaDeLogin.efetuaLogin();
        // vai para página do formulário de Novo Leilão.
        CadastroLeilaoPage paginaDeCadastro = this.paginaDeLeiloes.carregarFormulario();

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia" + hoje;
        String valor = "500.00";
        // reatribuindo
        this.paginaDeLeiloes = paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
        Assertions.assertTrue(this.paginaDeLeiloes.isLeilaoCadastrado(nome,valor,hoje));
    }


}
