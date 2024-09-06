package webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SearchForInexistentProductTest {
    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/ ");
    }

    @Test
    public void searchForInexistentProduct() throws InterruptedException {
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[1]/div[2]/form/input"));

        assertTrue(searchBar.isEnabled(),"A barra de busca não está habilitada.");

        js.executeScript("arguments[0].click();", searchBar);
        Thread.sleep(3000);


        String textoEsperado = "Ventilador Mondial";
        searchBar.sendKeys(textoEsperado);


        assertEquals(textoEsperado, searchBar.getAttribute("value"), "O texto inserido na barra de busca não corresponde.");

        Thread.sleep(3000);

        searchBar.submit();
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
