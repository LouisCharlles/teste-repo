package webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsingFiltersTest {
    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/ ");
    }

    @Test
    public void usingFiltersTest() throws InterruptedException {
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement playstationElement = driver.findElement(By.xpath("//strong[contains(text(), 'Playstation')]"));
        assertTrue(playstationElement.isDisplayed(), "Não foi possível selecionar o elemento Playstation.");
        Thread.sleep(1500);
        playstationElement.click();


        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(3L));

        WebElement alertLoginField;
        try {
            alertLoginField = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField.click();
            assert (alertLoginField.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }

        WebElement consolePlaystationFilter = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div[1]/ul/li/ul/li[1]/a"));
        assertTrue(consolePlaystationFilter.isEnabled(), "Não foi possível selecionar o elemento console Playstation.");
        consolePlaystationFilter.click();
        js.executeScript("window.scrollBy(0,150)");
        Thread.sleep(3000);

        WebElement gadjetsAndControllersFilter = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[1]/div[1]/ul/li/ul/li[2]/a"));
        assertTrue(gadjetsAndControllersFilter.isEnabled(), "Não foi possível selecionar o filtro de  controle e acessórios.");
        gadjetsAndControllersFilter.click();
        js.executeScript("window.scrollBy(0,150)");
        Thread.sleep(3000);

        WebElement playstationGamesFilter = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[1]/div[1]/ul/li/ul/li[3]/a"));
        assertTrue(playstationGamesFilter.isEnabled(), "Não foi possível selecionar o filtro de  jogos de playstation.");
        playstationGamesFilter.click();
        js.executeScript("window.scrollBy(0,150)");
        Thread.sleep(3000);

    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.quit();
    }
}
