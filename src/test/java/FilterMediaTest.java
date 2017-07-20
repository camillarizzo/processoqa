/**
 * Created by kaka on 19/07/17.
 */

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class FilterMediaTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://52.2.166.124:8091";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testFilterMedia () throws Exception {
        driver.get(baseUrl + "/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Helper.doLogin(driver, "avaliacao_qa_samba@sambatech.com.br","123456789");
        Thread.sleep(2000);
        driver.findElement(By.id("mn-content")).click();
        // Filtrar mídias ativas
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.className("trackFilterAtive")));
        driver.findElement(By.className("trackFilterAtive")).click();
        driver.findElement(By.id("remove-filter")).click();
        // Filtrar mídias inativas
        driver.findElement(By.className("trackFilterInactive")).click();
        driver.findElement(By.id("remove-filter")).click();
        // Filtrar mídias destacadas
        driver.findElement(By.className("trackFilterHighLighted")).click();
        driver.findElement(By.id("remove-filter")).click();
        // Filtrar mídias processando
        driver.findElement(By.className("trackFilterProcessing")).click();
        driver.findElement(By.id("remove-filter")).click();
        // Filtrar mídias com erro
        driver.findElement(By.className("trackFilterError")).click();
        driver.findElement(By.id("remove-filter")).click();

    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}