package br.com.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {
    // pra poder acessar as classes filhas.
    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        // se o valor for nulo, abra uma nova janela do chrome.
        if(browser == null) {
            this.browser = new ChromeDriver();
            // senão, continua no browser.
        } else {
            this.browser = browser;
        }
        this.browser.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS) // tempo de espera quando o selenium for buscar algum elemento na página.
                .pageLoadTimeout(10, TimeUnit.SECONDS); // tempo de espera da página.

    }

    public void fechar() {
        this.browser.quit();
    }
}
