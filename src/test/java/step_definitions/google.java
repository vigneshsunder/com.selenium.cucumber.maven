package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class google {
    WebDriver driver;

    @Before()
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("Google page is opened")
    public void google_page_is_opened(){
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String string){
        WebElement search = driver.findElement(By.cssSelector("input[name='q']"));
        search.sendKeys(string);
        search.sendKeys(Keys.RETURN);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed(){
        WebElement all = driver.findElement(By.cssSelector("div#hdtb-msb-vis"));
        assertEquals(true, all.isDisplayed())  ;
    }

    @After()
    public void after(){
        driver.quit();
    }
}
