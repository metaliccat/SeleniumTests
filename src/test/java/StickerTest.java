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



    private int isStikerPresent(WebElement item, int i) {
        int numberOfStikers=0;
        try {
            List<WebElement> stikers=item.findElements(By.cssSelector("div.sticker"));
            numberOfStikers = stikers.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return numberOfStikers;
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

        List<WebElement> items=driver.findElements(By.cssSelector("div.content  a.link"));
        int numberOfListElements = items.size();

        System.out.println("There are " + numberOfListElements  + " items on the page");
        System.out.println();

        int[] ResultArray = new int[numberOfListElements];
        boolean moreStikers = false;

            for (int i = 0; i < numberOfListElements; i++) {
                ResultArray[i]=isStikerPresent(items.get(i), i);
                System.out.println("Item "+i+": Number of stickers is "+ResultArray[i]);
                }
        System.out.println();

        for (int i = 0; i < numberOfListElements; i++) {
            if (ResultArray[i]>1) {
                moreStikers=true;
                System.out.println("Item "+i+" has few stickers! - "+ResultArray[i]);
                System.out.println(items.get(i));
                System.out.println();
             }
            }

            if (moreStikers==true) {
            fail("Some Item has has FEW stickers!");
        }
        }








    @After
    public void stop() {
        this.driver.quit();
        this.driver = null;
    }

}
