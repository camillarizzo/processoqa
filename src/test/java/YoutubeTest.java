/**
 * Created by kaka on 17/07/17.
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

public class YoutubeTest {

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

    //Realizar o compartilhamento da mídia no Youtube

    @Test
    public void postMidiaOnYoutube () throws Exception {

        driver.get(baseUrl + "/auth/login");
        Helper.doLogin(driver, "avaliacao_qa_samba@sambatech.com.br","123456789");
        Thread.sleep(2000);
        driver.findElement(By.id("mn-content")).click();
        driver.findElement(By.className("edit-media-link")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"connectedAccount-16\"]/td[3]/span")));
        driver.findElement(By.xpath("//*[@id=\"connectedAccount-16\"]/td[3]/span")).click();
        new WebDriverWait(driver, 90).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"connectedAccount-16\"]/td[3]/span"), "Desativar"));

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
