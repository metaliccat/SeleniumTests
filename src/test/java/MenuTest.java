import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MenuTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public void isH1Present() {

            WebElement header=driver.findElement(By.tagName("h1"));
            String actualTitle = driver.getTitle();
            System.out.println("Title is - "+actualTitle);
    }

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
        this.driver.findElement(By.name("login")).click();
        this.wait.until(ExpectedConditions.urlToBe("http://localhost/litecart/admin/"));


        List<WebElement> menu_links=driver.findElements(By.cssSelector("#box-apps-menu.list-vertical li#app- > [href^=http]"));
        int numberOfListElements = menu_links.size();

        for (int i = 0; i < numberOfListElements ; i++) {
            menu_links=driver.findElements(By.cssSelector("#box-apps-menu.list-vertical li#app- > [href^=http]"));
            menu_links.get(i).click();
            isH1Present();
            System.out.println();


            List<WebElement> sub_menu_links=driver.findElements(By.cssSelector("ul.docs >li a"));
            int numberOfListSubElements = sub_menu_links.size();

          for (int j = 0; j < numberOfListSubElements ; j++) {
                sub_menu_links = driver.findElements(By.cssSelector("ul.docs >li a"));
                sub_menu_links.get(j).click();
              isH1Present();
            }
            System.out.println();
            System.out.println();

        }

    }

    @After
    public void stop() {
        this.driver.quit();
        this.driver = null;
    }

}

