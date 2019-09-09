import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StickerTest {
    private WebDriver driver;
    private WebDriverWait wait;



    private boolean isOneSticker(WebElement product) {
        try {
            List<WebElement> stikers=product.findElements(By.cssSelector("div.sticker"));
            int numberOfStikers = stikers.size();

            if (numberOfStikers==1) {return true;}
            else { return false;}

            }
                catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
                }

    }

    private String ProductName(WebElement product) {
       return (product.findElement(By.cssSelector("div.name")).getText());
    }





    @Before
    public void start() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, 10L);
    }

    @Test
    public void StickerTest() {

        this.driver.get("http://localhost/litecart/");
        this.wait.until(ExpectedConditions.urlToBe("http://localhost/litecart/en/"));

        List<WebElement> products=driver.findElements(By.cssSelector("div.content  li.product"));
        int numberOfListElements = products.size();

        boolean error=false;
        int n=0;
        String Name;


            for (int i = 0; i < numberOfListElements; i++) {
                Name=ProductName(products.get(i));

                if (isOneSticker(products.get(i)) == true)
                {
                    System.out.println("The product "+Name+" has 1 sticker!");
                    System.out.println();
                }

                else
                {
                    error=true;
                    n++;

                    System.out.println("The product "+Name+" has no/few stickers!");
                    System.out.println();

                }
            }

        System.out.println("There are " + numberOfListElements  + " products on the page");
            if (error==true) {
            fail(n+" products have no/few stickers!");
            }

        }

    @After
    public void stop() {
        this.driver.quit();
        this.driver = null;
    }

}
