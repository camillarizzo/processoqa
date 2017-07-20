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


public class EditMediaTest {
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
    public void editSpecificMedia () throws Exception {

        driver.get(baseUrl + "/auth/login");
        Helper.doLogin(driver, "avaliacao_qa_samba@sambatech.com.br","123456789");
        Thread.sleep(2000);
        driver.findElement(By.id("mn-content")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.className("as-input")));
        driver.findElement(By.className("edit-media-link")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"media-meta-form\"]/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"media-meta-form\"]/div[1]/input")).sendKeys("Teste vaga QA");
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.className("icon-14-italic")).click();
        driver.findElement(By.id("description")).sendKeys("Descrição de vídeo para código de automação do Selenium Web Driver");
        driver.findElement(By.xpath("//*[@id=\"media-meta-form\"]/div[8]/div[1]/button[2]")).click();
        Thread.sleep(3000);
        Assert.assertEquals("×\n" +
                "Teste vaga QA foi editado com sucesso!", driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[6]")).getText());

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