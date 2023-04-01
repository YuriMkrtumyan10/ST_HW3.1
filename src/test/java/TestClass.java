import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
        String errorMessage = driver.findElement(By.id("loginerrormessage")).getText();
        assertTrue(errorMessage.contains("Invalid login, please try again"));


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
