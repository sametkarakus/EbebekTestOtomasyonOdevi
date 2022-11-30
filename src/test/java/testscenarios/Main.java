package testscenarios;


import framework.ConfigReader;
import framework.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchPage;

import java.util.*;

public class Main {

    static WebDriver driver;
    static Properties properties;
    HomePage homePage;

    SearchPage searchPage;
    Assertion assertion;

    String keyword = "ada";

    @BeforeClass
    public void setup(){
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver("chrome");
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        assertion = new SoftAssert();

    }


    @Test()
    public void search() {
        try {
            homePage.searchForBiberon("biberon");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        searchPage.checkSepeteEkle();
        searchPage.sepeteEkle();
    }

}