package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class EditProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;
    private String baseUrl;

    @BeforeEach
    void setupTest(){
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void editProduct_Success(ChromeDriver driver) throws Exception{

        // create product terlebih dahulu
        driver.get(baseUrl + "/product/create");
        driver.findElement(By.id("nameInput")).sendKeys("sabun nivea");
        driver.findElement(By.id("quantityInput")).sendKeys("20");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/product/list"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/product/list"));

        String pageContent = driver.findElement(By.tagName("body")).getText();
        assertTrue(pageContent.contains("sabun nivea"));

        // klik tombol edit
        driver.findElement(By.xpath("//a[contains(@href, '/product/edit')]")).click();

        wait.until(ExpectedConditions.urlContains("/product/edit/"));

        // edit process
        WebElement productName = driver.findElement(By.id("nameInput"));
        productName.clear();
        productName.sendKeys("sampo biore");

        WebElement productQuantity = driver.findElement(By.id("quantityInput"));
        productQuantity.clear();
        productQuantity.sendKeys("3");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // back to list

        wait.until(ExpectedConditions.urlContains("/product/list"));

        String updatedPageContent = driver.findElement(By.tagName("body")).getText();
        assertTrue(updatedPageContent.contains("sampo biore"));
        assertTrue(updatedPageContent.contains("3"));


    }

}
