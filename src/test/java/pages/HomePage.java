package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testscenarios.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class HomePage {

    //WebDriver setups
    WebDriver driver;
    Helper elementHelper;
    By gdpr = By.cssSelector("#CookieAlert button");
    By fromSearchBtn = By.xpath("//input[@id='txtSearchBox']");
    By fromListForFlightSearch=By.xpath("//*/ul[@role='listbox']/li");
    //login page constructor
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper=new Helper(driver);
    }

    public void searchForBiberon(String biberon) throws InterruptedException {
        WebElement searchBtn =  this.elementHelper
                .findElement(fromSearchBtn);
        try{
                elementHelper.findElement(fromSearchBtn).isEnabled();
                elementHelper.findElement(fromSearchBtn).click();


        }catch (NoSuchElementException e){
            System.out.println("search is not visible");
        }


        this.elementHelper.typeForInput(biberon, searchBtn);
        driver.findElement(fromSearchBtn).sendKeys(Keys.ENTER);


    }

    public List<String> listForFlightTicketSearchByStream(){
      return  this
                .elementHelper
                .findElements(fromListForFlightSearch)
                .stream().map(e->e.getText()).collect(Collectors.toList());
    }
    public List<String> listForFlightTicketSearch(){

       List<String> webElementText = new ArrayList<>();
       List<WebElement> webElementList = this
               .elementHelper
               .findElements(fromListForFlightSearch);
       for(int i=0;i<webElementList.size();i++){
           webElementText.add(webElementList.get(i).getText());
       }
       return webElementText;

    }


}
