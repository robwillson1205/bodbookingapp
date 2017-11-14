package testpack.tests;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testpack.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Tests1 {

    static WebDriver driver;


    @Before
    public void openBrowser(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rob.willson\\IdeaProjects\\bookingapp\\src\\test\\java\\testpack\\utils\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser()
    {
        driver.close();
    }

    @Given("^I hit booking app url$")
    public void I_hit_booking_app_url() throws Throwable {
        driver.get("http://hotel-test.equalexperts.io/");


    }

    @When("^i enter valid booking details and submit$")
    public void enter_valid_details() throws Throwable {
        HomePage home = new HomePage(driver);
        home.enterName("test123", "test456", "100.00");
        home.enterDeposit();
        home.selectDate();
        home.clickSaveBtn();

    }

    @Then("^the booking is successfully added$")
    public void booking_added() throws Throwable {
        HomePage home = new HomePage(driver);

        if (home.assertBookingAdded()) {
            System.out.println("Booking added correctly and all fields appear on form");  }
        else {
            System.out.println("Booking not added, debugging required to establish cause");
        }

    }
    @Given("^i hit the booking app url$")
    public void i_hit_the_booking_app_url() throws Throwable {
       driver.get("http://hotel-test.equalexperts.io/");

        }

    @When("^i delete my previous booking$")
    public void i_delete_my_previous_booking() throws Throwable {
        HomePage home = new HomePage(driver);
        home.deleteBooking();
        }

    @Then("^the booking is removed from the page$")
    public void the_booking_is_removed_from_the_page() throws Throwable {
       HomePage home = new HomePage(driver);
       if (home.assertBookingDeleted()) {
           System.out.println("Booking deleted correctly"); }
       else {
           System.out.println("Booking not deleted, debugging required to establish cause");
       }

      }




    }

