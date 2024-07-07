package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
    private final WebDriver BROWSER;

    public CadastroLeilaoPage(WebDriver browser) {
        this.BROWSER = browser;
    }

    public void fechar() {
        this.BROWSER.quit();
    }


    // é LeloesPage porque vou navegar para página de leilões. Ou seja, vai voltar pois vai ser cadastrado o leilão,
    // e a página vai ser redirecionada para página de leilões, a lista dos leilões cadastrados.
    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAtual) {
        this.BROWSER.findElement(By.id("nome")).sendKeys(nome);
        this.BROWSER.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.BROWSER.findElement(By.id("dataAbertura")).sendKeys(dataAtual);
        this.BROWSER.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(this.BROWSER);
    }
}
