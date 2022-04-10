import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.edge.driver", ".\\msedgedriver.exe");

    EdgeOptions options = new EdgeOptions();
    options.addArguments("-inprivate");
    options.addArguments("--disable-blinkfeatures=AutomationControlled");
    options.setExperimentalOption("useAutomationExtension", false);
    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

    WebDriver driver = new EdgeDriver(options);
    driver.manage().window().maximize();

    driver.get("https://minesweeper.online/");

    new WebDriverWait(driver, Duration.ofSeconds(3))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/start/1']")));
    driver.findElement(By.xpath("//a[@href='/start/1']")).click();

    new WebDriverWait(driver, Duration.ofSeconds(3))
        .until(ExpectedConditions.elementToBeClickable(By.id("A43")));
    List<WebElement> cells = driver.findElement(By.id("A43")).findElements(By.tagName("div"));

    for (WebElement cell : cells) {
      System.out.println(cell.getAttribute("class"));
    }

    Thread.sleep(5000);
    driver.quit();
  }
}