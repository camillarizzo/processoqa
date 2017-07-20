/**
 * Created by kaka on 15/07/17.
 */
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;




public class LoginSVTest {
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


    public void doLogin(String login, String pass) {

       Helper.doLogin(driver, login, pass);

    }


    @Test
    public void validLogin() throws Exception {

        driver.get(baseUrl + "/auth/login");
        doLogin("avaliacao_qa_samba@sambatech.com.br","123456789" );
        Thread.sleep(1500);
        driver.findElement(By.className("sambaVideos-logo")).isDisplayed();
    }

    @Test
    public void invalidLogin() throws Exception {
        //invalid pass
        driver.get(baseUrl + "/auth/login");
        doLogin("avaliacao_qa_samba@sambatech.com.br","11111" );
        Assert.assertEquals(driver.findElement(By.id("password_incorrect")).getText(),"Email ou senha incorretos. Saiba Mais");
        Thread.sleep(1500);
        //login nonexistent
        driver.get(baseUrl + "/auth/login");
        doLogin("avaliacao_qa_samba@sambatech.com","123456789" );
        Assert.assertEquals(driver.findElement(By.id("password_incorrect")).getText(),"Email ou senha incorretos. Saiba Mais");
        Thread.sleep(1500);
        //invalid login
        driver.get(baseUrl + "/auth/login");
        doLogin("avaliacao_qa_samba@sambatech","123456789" );
        Assert.assertEquals(driver.findElement(By.id("password_incorrect")).getText(),"Email ou senha incorretos. Saiba Mais");
        Thread.sleep(1500);
        //pass emply
        driver.get(baseUrl + "/auth/login");
        doLogin("avaliacao_qa_samba@sambatech.com.br","" );
        Assert.assertEquals(driver.findElement(By.id("password_incorrect")).getText(),"Email ou senha incorretos. Saiba Mais");
        Thread.sleep(1500);
        //login emply
        driver.get(baseUrl + "/auth/login");
        doLogin("","123456789" );
        Assert.assertEquals(driver.findElement(By.id("password_incorrect")).getText(),"Email ou senha incorretos. Saiba Mais");
        Thread.sleep(1500);

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