package org.kumar.sonu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class ShoppingDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");
        String product = "adidas original";

        driver.findElement(By.id("userEmail")).sendKeys("sonik@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Donotuse@12");

        // When using classname locator we need to give only 1 class name from multiple classes.
        driver.findElement(By.className("btn")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> name= driver.findElements(By.cssSelector(".mb-3"));
        WebElement products = name.stream().filter(prod ->prod.findElement(By.cssSelector("b")).
                getText().equalsIgnoreCase(product)).findFirst().orElse(null);
        products.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        Thread.sleep(3);
        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

        List <WebElement> carts = driver.findElements(By.cssSelector(".cartSection h3"));
       Boolean val= carts.stream().allMatch(cart ->cart.getText().equalsIgnoreCase(product));
        Assert.assertTrue(val);
        driver.findElement(By.xpath("//ul[@style='list-style-type: none;']//button")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
        List <WebElement> country = driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
        WebElement actual = country.stream().filter( count->count.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
        actual.click();
        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        }

    }

