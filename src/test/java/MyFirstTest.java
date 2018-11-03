import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyFirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public MyFirstTest() {
    }

    @Before
    public void start() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, 10L);
    }

    @Test
    public void myFirstTest() {
        this.driver.get("http://google.com");
        this.driver.findElement(By.name("q")).sendKeys(new CharSequence[]{"test request"});
        this.driver.findElement(By.name("btnK")).click();
        this.wait.until(ExpectedConditions.titleIs("test request - Поиск в Google"));
    }

    @After
    public void stop() {
        this.driver.quit();
        this.driver = null;
    }
}

