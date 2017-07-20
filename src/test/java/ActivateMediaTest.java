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
import org.openqa.selenium.Keys;

public class ActivateMediaTest {

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

    // Ativação de uma mídia com ID específico

    @Test
    public void activeSpecificMedia () throws Exception {

        driver.get(baseUrl + "/auth/login");
        Helper.doLogin(driver, "avaliacao_qa_samba@sambatech.com.br","123456789");
        Thread.sleep(2000);
        driver.findElement(By.id("mn-content")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.className("as-input")));
        driver.findElement(By.className("as-input")).clear();
        driver.findElement(By.className("as-input")).sendKeys("c3cf4b58cac50654f105dc63852261f9");
        driver.findElement(By.className("as-input")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
        driver.findElement(By.linkText("Tornar ativo")).click();
        Thread.sleep(2000);
        Assert.assertEquals("×\n" +
                "O conteúdo foi ativado com sucesso!",driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]")).getText());

    }

    // Inativação de uma mídia com ID específico

    @Test
    public void inactiveSpecificMedia () throws Exception {

        driver.get(baseUrl + "/auth/login");
        Helper.doLogin(driver, "avaliacao_qa_samba@sambatech.com.br","123456789");
        Thread.sleep(2000);
        driver.findElement(By.id("mn-content")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.className("as-input")));
        driver.findElement(By.className("as-input")).clear();
        driver.findElement(By.className("as-input")).sendKeys("c3cf4b58cac50654f105dc63852261f9");
        driver.findElement(By.className("as-input")).sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
        driver.findElement(By.linkText("Tornar inativo")).click();
        Thread.sleep(2000);
        Assert.assertEquals("×\n" +
                "O conteúdo foi desativado com sucesso!",driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]")).getText());

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

