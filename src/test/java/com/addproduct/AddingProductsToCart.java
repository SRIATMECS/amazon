package com.addproduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Set;

public class AddingProductsToCart {
    WebDriver driver;
    @Test (priority = 1)
    void mobile() throws InterruptedException {
        driver.findElement(By.linkText("Mobiles")).click();
        driver.findElement(By.cssSelector(".a-spacing-micro:nth-child(5) .a-color-base > span")).click();
        driver.findElement(By.cssSelector(".a-row:nth-child(2) > .celwidget:nth-child(1) .octopus-pc-item:nth-child(2) .a-link-normal:nth-child(1) > .a-section:nth-child(1) > .a-section:nth-child(1)")).click();
    }
    @Test (priority = 2)
    void tab() throws InterruptedException {
        driver.findElement(By.linkText("Electronics")).click();
        driver.findElement(By.cssSelector(".a-spacing-micro:nth-child(12) > .a-list-item span")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div/div/span/a/div/img")).click();
        windowHandle();
    }
    @Test (priority = 3)
    void refrigirator() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("refrigirator");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/div[1]/div/div/span/a/div/img")).click();
        windowHandle();
    }
    @Test(priority = 4)
    void tv() throws InterruptedException {
        driver.findElement(By.linkText("Electronics")).click();
        driver.findElement(By.cssSelector(".a-spacing-micro:nth-child(9) .a-color-base > span")).click();
        driver.findElement(By.cssSelector(".a-spacing-micro:nth-child(11) > .a-list-item span")).click();
        driver.findElement(By.cssSelector("#sobe_d_aw_3_1 .a-dynamic-image")).click();
    }
    @Test(priority = 5)
    void ac() throws InterruptedException {
        driver.findElement(By.linkText("Home & Kitchen")).click();
        driver.findElement(By.linkText("Air conditioners")).click();
        driver.findElement(By.xpath("//*[@id=\"CardInstanceBWTEu33F8PsiD5VyjYrV_A\"]/div[2]/div[1]/div/div/span/a/div/img")).click();
        windowHandle();
    }
    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.amazon.in");
    }
    @AfterMethod
    void addTocart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(3000);
        driver.navigate().to("http://www.amazon.in");
    }
    void windowHandle() throws InterruptedException {
        Set<String> windows=driver.getWindowHandles();
        Object[] obj= windows.toArray();
        driver.close();
        driver.switchTo().window(obj[1].toString());
    }
    @AfterTest
    void closeBrowser() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
