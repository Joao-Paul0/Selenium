package br.com.alura.leilao.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;
    // roda uma única vez
    @BeforeAll
    public static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }
    // roda antes dos método
    @BeforeEach
    public void beforeEach() {
        this.browser= new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }
    // roda depois dos método
    @AfterEach
    public void afterEach(){
        this.browser.quit();
    }
    @Test
    public void deveriaEfetuarLoginComDadosValidos() {
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assertions.assertNotEquals("http://localhost:8080/login", browser.getCurrentUrl());
        Assertions.assertEquals("fulano",browser.findElement(By.id("usuario-logado")).getText());
    }

    @Test
    public void naoDeveriaLogarComDadosInvalidos() {
        browser.findElement(By.id("username")).sendKeys("invalido");
        browser.findElement(By.id("password")).sendKeys("12332");
        browser.findElement(By.id("login-form")).submit();

        Assertions.assertTrue(browser.getCurrentUrl().contains("http://localhost:8080/login"));
        // getPageSource() devolve todoo código fonte da página
        Assertions.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assertions.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
    }

}
