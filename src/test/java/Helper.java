import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by kaka on 17/07/17.
 */
public class Helper {

    static void doLogin(WebDriver driver, String login, String pass) {

        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputEmail")).sendKeys(login);
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputPassword")).sendKeys(pass);
        driver.findElement(By.id("login")).click();
    }



}
