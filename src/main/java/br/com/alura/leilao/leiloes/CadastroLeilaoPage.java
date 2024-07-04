package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
    private final WebDriver BROWSER;

    public CadastroLeilaoPage(WebDriver browser) {
        this.BROWSER = browser;
    }

    public void fechar() {
        this.BROWSER.quit();
    }

}
