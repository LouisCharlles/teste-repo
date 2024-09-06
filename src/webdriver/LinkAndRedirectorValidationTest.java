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

public class LinkAndRedirectorValidationTest {

    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/");
    }

    @Test
    public void linkAndRedirectionValidation() throws InterruptedException {
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 6900);");
        WebElement whoAreWeButton = driver.findElement(By.xpath("/html/body/div[3]/div[7]/div/div[1]/div[2]/div[4]/ul/li[2]/a"));
        assertTrue(whoAreWeButton.isEnabled(), "Não foi possível selecionar o botão de quem somos.");
//        Thread.sleep(2500);
        whoAreWeButton.click();

        js.executeScript("window.scrollBy(0, 300);");
        Thread.sleep(2000);
        WebElement descriçaoQuemSomos = driver.findElement(By.xpath("//*[contains(text(), 'A Nova Era Games é uma empresa Confiável, e por isso está há quase duas décadas no mercado, ao longo dos anos tivemos um excepcional crescimento, contamos hoje com uma excelente estrutura de atendimento em nossa empresa, nosso web site atualmente tem mais de 1 milhão de visualizações por mês, e nosso Canal no Youtube tem mais de 10 MILHÕES de visualizações.')]"));
        assertTrue(descriçaoQuemSomos.isDisplayed(), "A descrição não foi encontrada.");
//        Thread.sleep(250000);

        WebElement homePage0 = driver.findElement(By.xpath("//a[contains(text(), 'Página inicial')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage0);
        js.executeScript("arguments[0].click();", homePage0);

        js.executeScript("window.scrollBy(0, 7000);");
        WebElement privacyPoliciesButton = driver.findElement(By.xpath("//*[@id=\"menus\"]/div[4]/ul/li[3]/a"));
        assertTrue(privacyPoliciesButton.isEnabled(), "Não foi possível selecionar o botão de políticas de privacidade.");
        Thread.sleep(2000);
        privacyPoliciesButton.click();

        js.executeScript("window.scrollBy(0, 190);");
        Thread.sleep(2000);
        WebElement descriptionPolicies = driver.findElement(By.xpath("//h2[contains(text(), 'Política de privacidade e segurança')]"));
        assertTrue(descriptionPolicies.isDisplayed(), "A descrição não foi encontrada.");
        Thread.sleep(2000);

        WebElement homePage1 = driver.findElement(By.xpath("//a[contains(text(), 'Página inicial')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", homePage1);
        js.executeScript("arguments[0].click();", homePage1);
        Thread.sleep(2000);
    }


    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
