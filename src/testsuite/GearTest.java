package testsuite;
/**
 * 2. Create the package ‘testsuite’ and create the following class GearTest
 */

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GearTest extends Utility {
    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * .Write down the following test into ‘GearTest’ class 1. userShouldAddProductSuccessFullyToShoppingCart()
     */

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        //* Mouse Hover on Gear Menu
        WebElement gearMenu = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
      // mouseHoverOnElement(By.xpath("//span[contains(text(),'Gear')]"));

       //* Click on Bags
        //mouseHoverOnElementAndClick(By.xpath("//span[normalize-space()='Bags']"));
        WebElement bags = driver.findElement(By.xpath("//span[normalize-space()='Bags']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gearMenu).moveToElement(bags).click().build().perform();

        //* Click on Product Name ‘Overnight Duffle’ * Verify the text ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyText("You added Overnight Duffle to your shopping cart.",By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //* Verify the product name ‘Overnight Duffle’
        verifyText("Overnight Duffle",By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));

        //* Verify the Qty is ‘3’
        Thread.sleep(5000);
       verifyText("3",By.xpath("//input[@id='cart-236433-qty']"));

        //* Verify the product price ‘$135.00’
        verifyText("$135.00",By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));

        // * Change Qty to ‘5’
        driver.findElement(By.id("cart-236190-qty")).clear();
        sendTextToElement(By.xpath("//input[@id='cart-236190-qty']"),"5");

        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //* Verify the product price ‘$225.00’
        verifyText("$225.00",By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"));
    }

    @After
    public void tearDown(){
        // closeBrowser();
    }
}
