package br.com.alura.leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static final String URL_LOGIN = "http://localhost:8080/login";
    private final WebDriver BROWSER;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.BROWSER = new ChromeDriver();
        this.BROWSER.navigate().to(URL_LOGIN);
    }

    public void fechar() {
        this.BROWSER.quit();
    }

    public void preecherFormularioDeLogin(String username, String password) {
        this.BROWSER.findElement(By.id("username")).sendKeys(username);
        this.BROWSER.findElement(By.id("password")).sendKeys(password);
    }

    public void efetuaLogin() {
        this.BROWSER.findElement(By.id("login-form")).submit();
    }

    public boolean isPaginaDeLogin() {
        return this.BROWSER.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            return this.BROWSER.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void navegarParaPaginaDeLances() {
        this.BROWSER.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return this.BROWSER.getCurrentUrl().contains(texto);
    }

    public boolean isPaginaDeLoginComDadosInvalidos() {
        return this.BROWSER.getCurrentUrl().contains(URL_LOGIN);
    }
}
