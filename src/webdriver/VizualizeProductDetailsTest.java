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

public class VizualizeProductDetailsTest {
    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/ ");


    }
    @Test
    public void viewProductDetails() throws InterruptedException {
        driver.manage().window().maximize();

        WebElement product = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[1]/div/div[2]/div[1]/div[2]/div/div/div[1]/div/article[2]/a[1]"));
        product.click();
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1175);");
        WebElement description = driver.findElement(By.xpath("//*[contains(text(), 'Apresentando o Xbox Series X. Jogue milhares de títulos de quatro gerações de consoles - todos os jogos têm a melhor aparência e jogam melhor no Xbox Series X. No coração da Série X está a Xbox Velocity Architecture, que emparelha um SSD personalizado com software integrado para maior velocidade jogabilidade com tempos de carregamento significativamente reduzidos. Mova-se perfeitamente entre vários jogos em um flash com o Quick Resume. Explore novos mundos ricos e desfrute da ação como nunca antes com os 12 teraflops incomparáveis de poder de processamento gráfico bruto. Desfrute de jogos em 4K a até 120 quadros por segundo, som espacial 3D avançado e muito mais.ESPECIFICAÇÕESFabricante: MicrosoftCPU: Zen 2 8x Cores 3.8 GHzGPU: Radeon RDNA 2 12.15 Tflops 1.8 GHzMemória RAM: 16 GB GDDR6Taxa de Frames: 30/60/120 frames p/sVoltagem: Bi-VoltResolução Máxima: 8K Cor: Preto')]"));
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0, 500);");
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0, -1400);");
        Thread.sleep(1000);
        assertTrue(description.isDisplayed(), "A descrição do Xbox não está visível na página.");
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
