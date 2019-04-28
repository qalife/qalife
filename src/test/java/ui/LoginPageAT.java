package ui;

import common.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;
import pages.LoginPage;
import web.driver.factory.DriverFactory;

import java.util.*;

public class LoginPageAT extends LoginPage {

//    public WebDriver driver;
//    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
//    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
//    public static final String ANSI_RESET = "\u001B[0m";

//    @BeforeSuite
//    public void BeforeSuite() {
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
//        DesiredCapabilities caps = DesiredCapabilities.firefox();
//        caps.setCapability("marionette", true);
//        caps.setCapability("networkConnectionEnabled", true);
//        caps.setCapability("browserConnectionEnabled", true);
//        caps.setCapability("disable-web-security", true);
//        caps.setJavascriptEnabled(true);
//        driver = new FirefoxDriver(caps);
//    }
//
//    @BeforeTest
//    public void setUp() {
//        driver.manage().window().maximize();
//    }
//
//    @AfterTest
//    public void quitDriver() {
//        driver.quit();
//    }


    @Test()
    @Parameters({"browser"})
    public void GoogleTest1(String browser) throws Exception{
        LoginPage log = new LoginPage();
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.xpath(log.googleBtnSearchLoc)).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).getText().contains("Selenium WebDriver"));
        System.out.print("Element: " + driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).getText() + " displayed\n");
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
    }

    @Test
    @Parameters({"browser"})
    public void GoogleTest2(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("monster jobs");
        driver.findElement(By.xpath("(//*[@type='submit'])[3]")).click();
        if(driver.findElement(By.xpath("//*[contains(text(), 'Searches related to monster jobs')]")).isDisplayed()){
            assert true;
            System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
        }
        else
            {assert false;}
    }
    @Test
    @Parameters({"browser"})
    public void GoogleTest3(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("stackoverflow");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).isDisplayed());
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);

    }

    //DD-2185Verify submit button in landing page
    @Test
    @Parameters({"browser"})
    public void VerifySubBtnInLandingPage(String browser) {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("stackoverflow");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='LC20lb'])[1]")).isDisplayed());
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
    }

    @Test
    @Parameters({"browser"})
    public void VerifyDropDownEbayHalf(String browser) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");	//enter url
        Select select = new Select(driver.findElement(By.id("state")));
        select.selectByVisibleText("California");
        System.out.print(ANSI_GREEN_BACKGROUND + "SUCCESS! " + ANSI_RESET);
    }


    @Test
    @Parameters({"browser"})
    public void verifyLogoDatafaction(String browser) throws Exception {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://www.datafaction.com");
        driver.findElement(By.xpath("//*[@id=\"cnb-navbar-collapse\"]/ul/li[3]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/blog.html"));
        Utility.clickJs(driver, "df-logo");
        Utility.waitForUrlContains(driver, "/index.html", 10);
        Assert.assertTrue(driver.getCurrentUrl().contains("/index.html"));
        Assert.assertTrue(!driver.getCurrentUrl().contains("/blog.html"));
        Assert.assertFalse(driver.getCurrentUrl().contains("/blog.html"));
    }

    @Test
    @Parameters({"browser"})
    public void verifyCnbBankPage(String browser) {
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("http://cnb.com");
        System.out.println("Navigating to: http://cnb.com");
        System.out.println("Waiting for page to load...");
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Personal"));
    }

    @Test(priority = 1)
    @Parameters({"browser"})
    public void verifyDatafactionPageAllLinks(String browser) throws Exception{
        WebDriver driver = DriverFactory.getDriver(browser);
        driver.get("https://datafaction.com");
        String[] links = null;
        int linksCount = 0;
        List<WebElement> linksize = driver.findElements(By.tagName("a"));//found all tags a - all links
        linksCount = linksize.size();
        System.out.println("Total no of links Available: " + linksCount);
        links = new String[linksCount];
// print all the links from webpage
        for (int i = 0; i < linksCount; i++) {
            List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));
            links[i] = linksize.get(i).getAttribute("href");
            System.out.println(all_links_webpage.get(i).getAttribute("href"));
        }
//        Set<String> set = new HashSet<>(links);
//        all_links_webpage.clear();
//        all_links_webpage.addAll(set);
// navigate to each Link on the webpage
        for (int i = 0; i < linksCount; i++) {
            driver.navigate().to(links[i]);//navigation
            String curl = driver.getCurrentUrl();
            System.out.println(curl);
            if (curl.contains(links[i])) {//https://www.datafaction.com/resources.html
                System.out.println("True");
                assert true;
            } else {
                System.out.println("False");
                assert false;
            }
        }
//        while (driver.findElement(By.name("blog")).isDisplayed()){
//           driver.findElement(By.tagName("a")).click();
//        }
    }

}

