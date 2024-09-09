package webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NavegarCategoriasTeste {

    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/ ");
    }

    @Test
    public void navigateThroughCategory() throws InterruptedException {
        //Maximiza tela
        driver.manage().window().maximize();

        //Procura por elemento Xbox para seleciona-lo e trocar de categoria, verifica se esá habilitado para em seguida clicá-lo.
        WebElement xboxElement = driver.findElement(By.xpath("//strong[contains(text(), 'Xbox')]"));
        assertTrue(xboxElement.isEnabled(), "Não foi possível selecionar o elemento Xbox.");
        xboxElement.click();
        Thread.sleep(500);

      //Procura por elemento console Xbox para seleciona-lo e trocar de categoria, verifica se esá habilitado para em seguida clicá-lo.
        WebElement xboxConsoleButton = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[1]/div[1]/ul/li/ul/li[1]/a"));
        assertTrue(xboxConsoleButton.isEnabled(), "Não foi possível selecionar o elemento console Xbox.");
        xboxConsoleButton.click();
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
