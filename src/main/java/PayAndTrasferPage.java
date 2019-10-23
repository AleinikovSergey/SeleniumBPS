import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PayAndTrasferPage extends Element {

    List<PayAndTrasferResult> PayAndTrasferResults = new ArrayList<>();

    public PayAndTrasferPage(WebElement webElement, WebDriver driver) {
        super(webElement, driver);
        List<WebElement> ptr = webElement.findElements(By.className("PayAndTrasfersSelectionResult"));
        for (WebElement result : ptr) {
            PayAndTrasferResults.add(new PayAndTrasferResult(result, driver));
        }
    }

    public WebElement Wait (String wait, int time, WebDriver driver) {
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(wait)));
        return driver.findElement(By.linkText(wait));
    }
}