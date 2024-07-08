package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {
    private final WebDriver BROWSER;
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

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

    public boolean isPaginaAtual() {
        return this.BROWSER.getCurrentUrl().contains(URL_CADASTRO_LEILAO);
    }

    public boolean isMensagensDeValidacoesVisiveis() {
        String pageSource = this.BROWSER.getPageSource();
        return pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("não deve estar em branco")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
