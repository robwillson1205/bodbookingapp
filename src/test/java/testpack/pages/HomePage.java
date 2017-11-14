package testpack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    WebDriver driver;

    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By priceField = By.id("totalprice");
    By depositField = By.id("depositpaid");
    By checkInField = By.id("checkin");
    By checkOutField = By.id("checkout");
    By saveBtn = By.cssSelector("input[value=' Save ']");
    By deleteBtn = By.xpath("//div[contains(., 'test123')]/following-sibling::*[6]");
    By bookingFirstName = By.xpath("//div[contains(., 'test123')]");
    By bookingLastName = By.xpath("//div[contains(., 'test456')]");
    By bookingPrice = By.xpath("//div[contains(., '100.00')]");
    By bookingDeposit = By.xpath("//div[contains(., 'false')]");
    By bookingCheckIn = By.xpath("//div[contains(., '2017-12-12')]");
    By bookingCheckOut = By.xpath("//div[contains(., '2017-12-13')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String firstName, String lastName, String price) {

        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).click();
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(priceField).click();
        driver.findElement(priceField).sendKeys(price);


    }

    public void enterDeposit() {

        WebElement depositField = driver.findElement(By.id("depositpaid"));
        Select clickThis = new Select(depositField);
        clickThis.selectByIndex(1);


    }

    public void selectDate() {
        driver.findElement(checkInField).click();

        WebElement checkInField = driver.findElement(By.id("checkin"));
        WebElement checkOutField = driver.findElement(By.id("checkout"));
        checkInField.clear();
        checkInField.sendKeys("2017-12-12");
        checkOutField.clear();
        checkOutField.sendKeys("2017-12-13");

    }

    public void clickSaveBtn() {
        driver.findElement(saveBtn).click();
    }

    public void deleteBooking() {
        driver.findElement(deleteBtn).click();

    }

    public boolean assertBookingAdded() {
        driver.findElement(bookingFirstName).isDisplayed();
        driver.findElement(bookingLastName).isDisplayed();
        driver.findElement(bookingDeposit).isDisplayed();
        driver.findElement(bookingCheckIn).isDisplayed();
        driver.findElement(bookingCheckOut).isDisplayed();
        driver.findElement(deleteBtn).isDisplayed();
        return true;

    }

    public boolean assertBookingDeleted() {

        try{
            driver.findElement(bookingFirstName).isDisplayed();
            driver.findElement(bookingLastName).isDisplayed();
            driver.findElement(bookingDeposit).isDisplayed();
            driver.findElement(bookingCheckIn).isDisplayed();
            driver.findElement(bookingCheckOut).isDisplayed();
            driver.findElement(deleteBtn).isDisplayed();
        return false;

        }

        catch(NoSuchElementException e){
                return true;
            }







    }


}