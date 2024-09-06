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

public class ComparePricesByFilterTest {

    private final WebDriver driver = new EdgeDriver();

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Sansb\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        this.driver.get("https://www.lojanovaera.com/ ");
    }

    @Test
    public void comparePricesByFilter() throws InterruptedException {
        driver.manage().window().maximize();
        WebElement xboxElement = driver.findElement(By.xpath("//strong[contains(text(), 'Xbox')]"));
        xboxElement.click();
        Thread.sleep(500);



        WebElement filterCompare0 = driver.findElement(By.id("botaoOrdenar"));
        assertTrue(filterCompare0.isEnabled(), "Não foi possível selecionar o filtro.");
        Thread.sleep(2500);
        filterCompare0.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2500);

        WebElement filterBiggerPrice = driver.findElement(By.cssSelector("#corpo > div > div.secao-principal.row-fluid.sem-coluna > div.conteudo.span9 > div.ordenar-listagem.topo.borda-alpha > div > div.span6.clearfix > div > div > div > ul > li:nth-child(5) > a"));
        assertTrue(filterBiggerPrice.isEnabled(), "Não foi possível selecionar o filtro.");
        filterBiggerPrice.click();
        Thread.sleep(2500);
        js.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(2500);
        js.executeScript("window.scrollBy(0,-1000);");

        WebElement filterCompare1 = driver.findElement(By.id("botaoOrdenar"));
        assertTrue(filterCompare1.isEnabled(), "Não foi possível selecionar o filtro.");
        filterCompare1.click();
        Thread.sleep(2500);

        WebElement filterLowestPrice = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/ul/li[4]/a"));
        assertTrue(filterLowestPrice.isEnabled(), "Não foi possível selecionar o filtro.");
        filterLowestPrice.click();
        js.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000);");

        WebElement filterCompare2 = driver.findElement(By.id("botaoOrdenar"));
        assertTrue(filterCompare2.isEnabled(), "Não foi possível selecionar o filtro.");
        filterCompare2.click();
        Thread.sleep(2500);

        WebElement filterBiggerDescount = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div/ul/li[6]/a"));
        assertTrue(filterBiggerDescount.isEnabled(), "Não foi possível selecionar o filtro.");
        filterBiggerDescount.click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 1000);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1000);");
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(3L));

        WebElement alertLoginField1;
        try {
            alertLoginField1 = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField1.click();
            assert (alertLoginField1.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }finally {
            WebElement filterR$25ToR$49 = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[1]/div[3]/div/div/ul/li[1]"));
            assertTrue(filterR$25ToR$49.isEnabled(), "Não foi possível selecionar o filtro de preço R$25 a R$49.");
            filterR$25ToR$49.click();
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(3000);
        }

        WebElement alertLoginField2;
        try {
            alertLoginField2 = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField2.click();
            assert (alertLoginField2.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }finally {
            WebElement removeFilterButton = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/div/div/div/a"));
            removeFilterButton.click();
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(1000);

            WebElement filterR$50ToR$69 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/ul/li[2]/a"));
            assertTrue(filterR$50ToR$69.isEnabled(), "Não foi possível selecionar o filtro de preço R$50 a R$69.");
            filterR$50ToR$69.click();
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(1000);
        }

        WebElement alertLoginField3;
        try {
            alertLoginField3 = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField3.click();
            assert (alertLoginField3.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }finally {
            WebElement removeFilterButton1 = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/div/div/div/a"));
            removeFilterButton1.click();
            js.executeScript("window.scrollBy(0,100)");
            WebElement filterR$70ToR$99 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/ul/li[3]/a"));
            assertTrue(filterR$70ToR$99.isEnabled(), "Não foi possível selecionar o filtro de preço R$50 a R$69.");
            filterR$70ToR$99.click();
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(1000);
        }

        WebElement alertLoginField4;
        try {
            alertLoginField4 = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField4.click();
            assert (alertLoginField4.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }finally {
            WebElement removeFilterButton2 = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/div/div/div/a"));
            removeFilterButton2.click();
            js.executeScript("window.scrollBy(0,100)");
            WebElement filterR$100ToR$199 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/ul/li[4]/a"));
            assertTrue(filterR$100ToR$199.isEnabled(), "Não foi possível selecionar o filtro de preço R$50 a R$69.");
            filterR$100ToR$199.click();
            js.executeScript("window.scrollBy(0,100)");
            Thread.sleep(3000);
        }

        WebElement alertLoginField5;
        try {
            alertLoginField5 = (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
            alertLoginField5.click();
            assert (alertLoginField5.isSelected());
        } catch (Exception var6) {
            System.out.println("Consentimento de Login não encontrado ou já fechado.");
        }finally {
            WebElement removeFilterButton3 = driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/div/div/div/a"));
            removeFilterButton3.click();
            Thread.sleep(3000);
            js.executeScript("window.scrollBy(0,100)");
            WebElement filterR$200ToR$399 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div[3]/div/div/ul/li[5]/a"));
            assertTrue(filterR$200ToR$399.isEnabled(), "Não foi possível selecionar o filtro de preço R$50 a R$69.");
            filterR$200ToR$399.click();
            js.executeScript("window.scrollBy(0,100)");
        }
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
