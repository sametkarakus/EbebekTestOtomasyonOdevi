package pages;

import framework.ConfigReader;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testscenarios.Main;

import static org.junit.Assert.assertEquals;

public class SearchPage {

    //WebDriver setups
    WebDriver driver;
    WebDriverWait wait;
    Helper elementHelper;

    //elements in login page
    By firstProduct = By.xpath("(//*[@class='row product-list']//eb-product-list-item)[1]");
    By addToCart = By.xpath("(//button[@id='addToCartBtn'])[1]");
    By showCard = By.xpath("(//a[@id='btnShowCart'])[1]");

    By beforeProductName = By.xpath("(//*[@id='txtProductTitle'])[2]");
    By afterProductName = By.xpath("//*[@class='basket-content']//h2");

    String beforeName;
    String afterName;
    //login page constructor
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,10);
        this.elementHelper=new Helper(driver);
    }

    //login page functions
    public void checkSepeteEkle()
    {

        String homePageUrl= ConfigReader.initialize_Properties().getProperty("url");
        String currentUrl= driver.getCurrentUrl();
        assertEquals(currentUrl,homePageUrl);
    }


    public void sepeteEkle()
    {
        elementHelper.click(firstProduct);
        beforeName = elementHelper.getText(beforeProductName);
        elementHelper.click(addToCart);
        elementHelper.click(showCard);
        afterName = elementHelper.getText(afterProductName);
        assertEquals(beforeName, afterName);

    }



}