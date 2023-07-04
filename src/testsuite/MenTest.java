package testsuite;

import browserfactory.Utility;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenTest extends Utility {
    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //* Mouse Hover on Men Menu
        WebElement menMenu = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));

        //* Mouse Hover on Bottoms
        WebElement bottoms = driver.findElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));


        //* Click on Pants
        WebElement pants = driver.findElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menMenu).moveToElement(bottoms).moveToElement(pants).click().build().perform();

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        WebElement cronusYogaPantSize = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));
        actions.moveToElement(cronusYogaPantSize).click().build().perform();

        //* Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour Black.
        WebElement cronusYogaPantColourBlack = driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));
        actions.moveToElement(cronusYogaPantColourBlack).click().build().perform();

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        WebElement addToCart = driver.findElement(By.cssSelector("body > div:nth-child(4) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(4) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > button:nth-child(4) > span:nth-child(1)"));
        actions.click(addToCart).click().build().perform();

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        verifyText("You added Cronus Yoga Pant to your shopping cart.",By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //* Verify the text ‘Shopping Cart.’
        verifyText("Shopping Cart",By.xpath("//span[@class='base']"));

        //* Verify the product name ‘Cronus Yoga Pant’
        verifyText("Cronus Yoga Pant",By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));

        //* Verify the product size ‘32’
        verifyText("32",By.xpath("//dd[contains(text(),'32')]"));

        //* Verify the product colour ‘Black’
        verifyText("Black",By.xpath("//dd[contains(text(),'Black')]"));
    }

}
