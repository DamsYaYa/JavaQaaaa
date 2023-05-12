package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImportantQuestions {
    private final WebDriver driver;
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public ImportantQuestions(WebDriver driver) {
        this.driver = driver;
    }

    // Открыть стр сайта
    public void openAWebsiteToOrderAScooter() {
        driver.get(PAGE_URL);
    }

    // Получить текст ответа на вопрос
    public String GetTexFromDropdownList(int id){
        WebElement element = driver.findElement(By.id("accordion__heading-"+id));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return driver.findElement(By.id("accordion__panel-"+id)).getText();
    }
}