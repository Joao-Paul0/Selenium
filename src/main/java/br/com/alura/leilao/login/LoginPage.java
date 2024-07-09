package br.com.alura.leilao.login;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObject {
    public static final String URL_LOGIN = "http://localhost:8080/login";
    public static final String URL_LANCES = "http://localhost:8080/leiloes/2";

    public LoginPage() {
        // Por ser tela de login, quero que caia como nulo mesmo, porque vai abrir uma nova janela do google chrome.
        super(null);
        this.browser.navigate().to(URL_LOGIN);
    }

    public void preecherFormularioDeLogin(String username, String password) {
        this.browser.findElement(By.id("username")).sendKeys(username);
        this.browser.findElement(By.id("password")).sendKeys(password);
    }

    // estou na página de login, mas quero ir para página de leilões.
    // ao clicar no botão, troca para outra página, de leilões.
    public LeiloesPage efetuaLogin() {
        this.browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(this.browser);
    }

    public boolean isPaginaDeLogin() {
        return this.browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            return this.browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegarParaPaginaDeLances() {
        this.browser.navigate().to(URL_LANCES);
    }

    public boolean contemTexto(String texto) {
        return this.browser.getCurrentUrl().contains(texto);
    }

    public boolean isPaginaDeLoginComDadosInvalidos() {
        return this.browser.getCurrentUrl().contains(URL_LOGIN);
    }
}
