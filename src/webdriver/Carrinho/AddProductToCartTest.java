package webdriver.Carrinho;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddProductToCartTest {
    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/");
    }

    @Test
    public void addItemToCart() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement product = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/article[2]/a[1]"));
        assertTrue(product.isEnabled(),"O produto  não está selecionável.");
        product.click();
        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(3L));

        WebElement alertLoginField;
        try {
            alertLoginField = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField.click();
            assert (alertLoginField.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }
        WebElement purchaseButton = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div/div[1]/div[2]/div/div[2]/div[3]/a"));
        assertTrue(purchaseButton.isEnabled(),"O botão de comprar não está habilitado.");
        purchaseButton.click();

        WebElement productInsideCart = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[2]/div/a"));
        assertTrue(productInsideCart.isDisplayed(),"O produto não foi adicionado ao carrinho.");
        Thread.sleep(1000);

        WebElement continueShoppingButton = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div/form/div/div[1]/a"));
        assertTrue(continueShoppingButton.isEnabled(),"O botão de voltar a comprar não está funcionando.");
        continueShoppingButton.click();
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        this.driver.quit();
    }
}
