import ru.yandex.praktikum.NewOrder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.jvm.hotspot.utilities.soql.JSJavaScriptEngine;



public class NewOrderTest {
    @Test
    public void testFirstWayOrderScooterInChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        NewOrder newOrder = new NewOrder(driver);

        newOrder.checkOrderScooterFirstWay(
                "Алена",
                "Петрова",
                "москва ул минская дом 34",
                899988777,
                "28.04.2023",
                "не звонить в домофон"
        );
    }

    @After
    public void teardown(){
        driver.quit();
    }



    @Test
    public void testFirstWayOrderScooterInFirefox(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        NewOrder newOrder = new NewOrder(driver);

        newOrder.checkOrderScooterFirstWay(
                "Марья",
                "Васильева",
                "деревня Петушки дом первый от въезда",
                892990545,
                "30.05.2023",
                "ты меня сразу узнаешь"
        );
    }

    @After
    public void teardown(){
        driver.quit();
    }


    public void testSecondWayOrderScooterInChrome(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        NewOrder newOrder = new NewOrder(driver);

        newOrder.checkOrderScooterSecondWay(
                "Алена",
                "Петрова",
                "москва ул минская дом 34",
                899988777,
                "28.04.2023",
                "не звонить в домофон"
        );

        driver.quit();
    }

    @Test
    public void testSecondWayOrderScooterInFirefox(){
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        NewOrder newOrder = new NewOrder(driver);

        newOrder.checkOrderScooterSecondWay(
                "Марья",
                "Васильева",
                "деревня Петушки дом первый от въезда",
                892990545,
                "30.05.2023",
                "ты меня сразу узнаешь"
        );
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
