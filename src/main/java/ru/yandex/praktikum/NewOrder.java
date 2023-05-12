package ru.yandex.praktikum;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewOrder {
    private final WebDriver driver;

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private By firstOrderButton  =  By.xpath("//button[text()='Заказать']"); //first button for ordering
    private By secondOrderButton = By.className("Button_Button__ra12g");
    private By orderContent = By.className("Order_Content__bmtHS");
    private By clientName = By.xpath("//input[@placeholder='* Имя']");
    private By clientSecondName = By.xpath("//input[@placeholder='* Фамилия']");
    private By clientAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By clientMetroStation = By.xpath("//input[@placeholder='* Станция метро']");
    private By clientPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath("//button[text()='Далее']");
    private By rentContent = By.className("Order_Content__bmtHS");
    private By clientRentData = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private static final By datePicker = By.xpath(".//div[@class='react-datepicker__week]");
    private By clientRentPeriod = By.className("Dropdown-control");
    private By choosingRentalPeriod = By.xpath(".//div[@class='Dropdown-option']");
    private By scooterColor = By.xpath(".//div[@class='Order_Checkboxes__31WSI]");
    private By choosingScootersColor = By.xpath(".//input[@class='Checkbox_Input__14A2w']");
    private By CommentForCourier = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By modalHeader = By.className("Order_ModalHeader__3FDaJ");
    private By metroStationList = By.xpath(".//li[@class='select-search__row']");
    private static final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    private static final By orderConfirmation = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text() = 'Да']");
    private static final By successfulOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']");
    private static final By finalOrderButton = By.xpath(".//button[text() = 'Заказать']");

    public NewOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void openAWebsiteToOrderAScooter() {
        driver.get(URL);
    }
    public void fillInTheNameField(String name) {
        driver.findElement(clientName).clear();
        driver.findElement(clientName).sendKeys(name);
    }
    public void fillInTheLastNameField(String surname) {
        driver.findElement(clientSecondName).clear();
        driver.findElement(clientSecondName).sendKeys(surname);
    }
    public void fillInTheAddressField(String address) {
        driver.findElement(clientAddress).clear();
        driver.findElement(clientAddress).sendKeys(address);
    }
    public void chooseAMetroStation(int metroStationIdx) {
        driver.findElement(clientMetroStation).click();
        List<WebElement> list = driver.findElements(metroStationList);
        WebElement e = list.get(metroStationIdx);
        e.click();
    }
    public void fillInThePhoneNumberField(String phoneNumber) {
        driver.findElement(clientPhone).clear();
        driver.findElement(clientPhone).sendKeys(phoneNumber);
    }
    public void clickOnTheNextButton() {
        driver.findElement(orderButton).click();
    }
    public void selectTheOrderDate(int orderDateIdx) {
        driver.findElement(clientRentData).click();
        List<WebElement> list = driver.findElements(datePicker);
        WebElement a = list.get(orderDateIdx);
        a.click();
    }
    public void selectTheRentalPeriod(int rentalPeriodIdx) {
        driver.findElement(clientRentPeriod).click();
        List<WebElement> list = driver.findElements(choosingRentalPeriod);
        WebElement b = list.get(rentalPeriodIdx);
        b.click();
    }
    public void chooseTheColorOfTheScooter(int colorOfTheScooterIdx) {
        driver.findElement(scooterColor).click();
        List<WebElement> list = driver.findElements(choosingScootersColor);
        WebElement c = list.get(colorOfTheScooterIdx);
        c.click();
    }
    public void leaveACommentToTheCourier(String comment) {
        driver.findElement(CommentForCourier).clear();
        driver.findElement(CommentForCourier).sendKeys(comment);

    }
    public void clickTheOrderButtonOnTheOrderPage() {
        driver.findElement(orderButton).click();

    }
    public void confirmTheOrder() {
        driver.findElement(orderConfirmation).click();

    }
    public boolean isSuccessfulMessageAppeared() {
        return driver.findElement(successfulOrder).isDisplayed();
    }
    public void clickOrderButton(int orderButtonIdx) {
        List<WebElement> list = driver.findElements(finalOrderButton);
        WebElement button = list.get(orderButtonIdx);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }
}