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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculateShippingTest {
        private final WebDriver driver = new EdgeDriver();

        @BeforeEach
        public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/");
    }

    @Test
    public void calculateShipping() throws InterruptedException {
        //Maximiza a tela e cria um driver de espera;
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(3L));

        //Verifica se o alerta de login é selecionável para clicar e fecha-lo e finalmente adicionar o item ao carrinho
        WebElement alertLoginField;
        try {
            alertLoginField = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField.click();
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }finally {
            addItemToCart();
        }

        //Localiza o input de calculo de frete, cria uma String cep e envia uma chave com valor a ser validado como correto ou incorreto.
        WebElement inputCalculateShippingBar = driver.findElement(By.xpath("//*[@id=\"calcularFrete\"]"));
        assertTrue(inputCalculateShippingBar.isEnabled(),"O botão de calcular frete não está habilitado.");
        String cep = "65110-000";
        inputCalculateShippingBar.sendKeys("65110000");
        Thread.sleep(3000);
        assertEquals(cep, inputCalculateShippingBar.getAttribute("value"), "O valor do cep esperado não corresponde ao atual.");
        Thread.sleep(2000);
        inputCalculateShippingBar.submit();
        Thread.sleep(2000);

        //Localiza o alerta de variação de preço para clicá-lo.
        WebElement alertaVariacaoDePreco = driver.findElement(By.xpath("/html/body/div[14]/div/div/a"));
        alertaVariacaoDePreco.click();
        Thread.sleep(2000);

        //Localiza o preço do frete e verifica se o preço mudou de valor ao cálcular o frete.
        WebElement precoFrete = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr[2]/td[2]/div/ul/li[2]/label/span[1]"));
        assertTrue(precoFrete.isDisplayed(),"O valor do frete não foi encontrado.");
        Thread.sleep(2000);

    }

    public void addItemToCart() throws InterruptedException {

    WebElement product = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/article[2]/a[1]"));
    product.click();
    Thread.sleep(4000);

    WebElement purchaseButton = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div/div[1]/div[2]/div/div[2]/div[3]/a"));
    purchaseButton.click();
    Thread.sleep(4000);

}


    @AfterEach
    public void tearDown() throws InterruptedException {
    Thread.sleep(1000);
    this.driver.quit();
    }
}
