import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LitecartFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, 10L);
    }

    @Test
    public void myFirstTest() {
        this.driver.get("http://localhost/litecart/admin/");
        this.driver.findElement(By.name("username")).sendKeys(new CharSequence[]{"admin"});
        this.driver.findElement(By.name("password")).sendKeys(new CharSequence[]{"admin"});
        this.driver.findElement(By.name("remember_me")).click();
        this.driver.findElement(By.name("login")).click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost/litecart/admin/"));
    }

    @After
    public void stop() {
        this.driver.quit();
        this.driver = null;
    }

}
