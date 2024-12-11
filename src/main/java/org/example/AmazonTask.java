package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("t-shirt");
        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> elements= driver.findElements(By.className("s-product-image-container"));
        if(!elements.isEmpty()){
            elements.getFirst().click();

            driver.findElement(By.name("submit.add-to-cart")).click();
            driver.findElement(By.linkText("Today's Deals")).click();
            driver.findElement(By.partialLinkText("Customer Service")).click();
        }
        driver.quit();
    }
}
