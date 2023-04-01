import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;


public class TestClass {
    public WebDriver driver;

    @Before
    public void setUp() {
        // WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\ST_HW3.1_Yuri_Mkrtumyan\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }



    @Test
    public void testLogin() {
        driver.get("https://elearning.aua.am/");

        WebElement spanElement = driver.findElement(By.className("login"));
        WebElement aElement = spanElement.findElement(By.xpath(".//a"));
        aElement.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("yuri_mkrtumyan");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        WebElement logBTN = driver.findElement(By.id("loginbtn"));
        logBTN.click();


        String pageTitle = driver.getTitle();
        String expectedTitle = "E-learning @ AUA: Log in to the site";

        String errorMessage = driver.findElement(By.id("loginerrormessage")).getText();


        assertEquals(expectedTitle, pageTitle);
        assertTrue(errorMessage.contains("Invalid login, please try again"));


    }

    // I was confused to test login with correct password and username so I checked with my data it worked
    // if you wanna check below test just put your valid username and password and UNCOMMENT @TEST

    //@Test
    public void testLogin2() {
        String yourValidPassword = "";
        String yourValidUserName = "";

        driver.get("https://elearning.aua.am/");

        WebElement spanElement = driver.findElement(By.className("login"));
        WebElement aElement = spanElement.findElement(By.xpath(".//a"));
        aElement.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(yourValidUserName);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(yourValidPassword);

        WebElement logBTN = driver.findElement(By.id("loginbtn"));
        logBTN.click();


        String pageTitle = driver.getTitle();
        String expectedTitle = "Dashboard";


        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://elearning.aua.am/my/";

        assertEquals(expectedTitle, pageTitle);
        assertTrue(currentUrl.contains(expectedUrl));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
