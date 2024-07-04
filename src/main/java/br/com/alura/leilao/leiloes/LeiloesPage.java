package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class LeiloesPage {
    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private final WebDriver BROWSER;

    public LeiloesPage(WebDriver browser) {
        this.BROWSER = browser;
    }

    public void fechar() {
        this.BROWSER.quit();
    }

    public CadastroLeilaoPage carregarFormulario() {
        this.BROWSER.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(this.BROWSER);
    }
}
