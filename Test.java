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
    // binding driver to webdriver
    System.setProperty("webdriver.edge.driver", ".\\msedgedriver.exe");

    // options/settings for webdriver
    // trying to minimize chances of website figuring out it's a bot
    EdgeOptions options = new EdgeOptions();
    options.addArguments("-inprivate");
    options.addArguments("--disable-blinkfeatures=AutomationControlled");
    options.setExperimentalOption("useAutomationExtension", false);
    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

    // instantiating web driver
    WebDriver driver = new EdgeDriver(options);
    driver.manage().window().maximize();

    // navigate to minesweeper.online
    driver.get("https://minesweeper.online/");

    // locate anchor element for regular easy game
    // WebDriverWait lets the webpage load until element is clickable
    new WebDriverWait(driver, Duration.ofSeconds(3))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/start/1']")));
    driver.findElement(By.xpath("//a[@href='/start/1']")).click();

    // locate all the cells and store in list
    new WebDriverWait(driver, Duration.ofSeconds(3))
        .until(ExpectedConditions.elementToBeClickable(By.id("A43")));
    List<WebElement> cells = driver.findElement(By.id("A43")).findElements(By.tagName("div"));

    // looping through all cells and printing the class
    for (WebElement cell : cells) {
      System.out.println(cell.getAttribute("class"));
    }

    // quit closes browser and any hidden processes
    // sleeping to see have chance to see web page
    Thread.sleep(5000);
    driver.quit();
  }
}