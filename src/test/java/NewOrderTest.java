import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class NewOrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final int metroStationIdx;
    private final String phoneNumber;
    private final int orderDateIdx;
    private final int rentalPeriodIdx;
    private final int orderButtonIdx;
    private final int colorOfTheScooterIdx;
    private final String comment;
    private final boolean expected;
    private WebDriver driver;

    public NewOrderTest(String name, String surname, String address, int metroStation, String phoneNumber, int orderDateIdx, int rentalPeriodIdx, int orderButtonIdx, int colorOfTheScooterIdx, String comment, boolean expected ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationIdx = metroStation;
        this.phoneNumber = phoneNumber;
        this.orderDateIdx = orderDateIdx;
        this.rentalPeriodIdx = rentalPeriodIdx;
        this.colorOfTheScooterIdx = colorOfTheScooterIdx;
        this.orderButtonIdx = orderButtonIdx;
        this.comment = comment;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][]{
                {"Алена", "Петрова", "москва ул минская дом 34", 3, "8777898098", 1, 1, 1, 0, "не звонить в домофон", true },
                {"Иван-да-Марья", "Петровы", "Москва хзамоскворечная ул д 15", 0, "89093453699", 0, 1, 1, 1, "добро пожаловать", true},
        };
    }

    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        ChromeOptions options = new ChromeOptions();
        //FireFoxOptions options = new FireFoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        // WebDriver driver = new FireFoxDriver(options)

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void makingAnOrder(){
        NewOrder page = new NewOrder(driver);
        page.openAWebsiteToOrderAScooter();
        page.clickOrderButton(orderButtonIdx);
        page.fillInTheNameField(name);
        page.fillInTheLastNameField(surname);
        page.fillInTheAddressField(address);
        page.chooseAMetroStation(metroStationIdx);
        page.fillInThePhoneNumberField(phoneNumber);
        page.clickOnTheNextButton();
        page.selectTheOrderDate(orderDateIdx);
        page.selectTheRentalPeriod(rentalPeriodIdx);
        page.chooseTheColorOfTheScooter(colorOfTheScooterIdx);
        page.leaveACommentToTheCourier(comment);
        page.clickTheOrderButtonOnTheOrderPage();
        page.confirmTheOrder();
        boolean actual = page.isSuccessfulMessageAppeared();
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    }



