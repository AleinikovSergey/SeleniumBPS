import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BPS {

    public static void main(String[] arg) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Laptop\\Desktop\\sel (1)\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bps-sberbank.by");
        secondTest(driver);
        driver.quit();
    }

    public static void firsTest(WebDriver driver) {
        MainMenu mainMenu = new MainMenu(driver.findElement(By.id("app")), driver);
        DropDownMenu depositMenu = mainMenu.selectDeposite();
        depositMenu.clickToHeader("В ИНОСТРАННОЙ ВАЛЮТЕ");
        DepositePage depositePage = new DepositePage(driver.findElement(By.id("app")), driver);

        System.out.println("sdf");
    }

    public static void secondTest(WebDriver driver) {
        MainMenu mainMenu = new MainMenu(driver.findElement(By.id("app")), driver);
        DropDownMenu PayAndTrasferMenu = mainMenu.selectPayAndTrasfer();
        PayAndTrasferMenu.clickToSubHeader("Сбербанк Онлайн");
        PayAndTrasferPage OnlineBankPage = new PayAndTrasferPage(driver.findElement(By.id("app")), driver);
        OnlineBankPage.Wait("Войти в Банк", 3, driver).click();
        PayAndTrasferPage OnlineBankAut = new PayAndTrasferPage(driver.findElement(By.id("app")), driver);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Input_default")));
        int i = 0;
        do {
            String randomString = random();
            OnlineBankAut.findElement(By.className("Input_default")).clear();
            OnlineBankAut.findElement(By.className("Input_default")).sendKeys(randomString);
            OnlineBankAut.findElement(By.className("PassText")).clear();
            OnlineBankAut.findElement(By.className("PassText")).sendKeys(randomString);
            OnlineBankAut.findElement(By.id("ButtonDefault_15")).click();
            i++;
        }
        while (i < 3);
        OnlineBankAut.findElement(By.linkText("Не помню логин или пароль")).click();


    }

    public static String random() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        String randomString = new String(array, Charset.forName("UTF-8"));

        return randomString;
    }

}
