package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {
    public static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private final WebDriver BROWSER;

    public LeiloesPage(WebDriver browser) {
        this.BROWSER = browser;
    }

    public void fechar() {
        this.BROWSER.quit();
    }

    // Clica no botão Novo Leilão.
    public CadastroLeilaoPage carregarFormulario() {
        this.BROWSER.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(this.BROWSER);
    }
    // Valida os dados na tabela leilões, na última coluna.
    public boolean isLeilaoCadastrado(String nome, String valor, String data) {
        WebElement linhaDaTabela = this.BROWSER.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));
        return colunaNome.getText().equals(nome) && colunaDataAbertura.getText().equals(data) && colunaValorInicial.getText().equals(valor);
    }
}
