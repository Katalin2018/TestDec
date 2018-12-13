package ro.sapientia.epic.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMEpicAddStepDefinition {

	protected WebDriver driver;
	private int childrenSize;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the \"([^\"]*)\" view$")
	public void i_open_the_view(String path) throws Throwable {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/" + path);
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and I push the add button$")
	public void i_enter_in_the_title_textbox_and_I_push_the_add_button(String title) throws Throwable {

		WebElement titleField = driver.findElement(By.id("epic-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(title);
		
		WebElement addEpicButton = driver.findElement(By.id("add-epic-button"));
		addEpicButton.click();
	}

	@Then("^I should get result \"([^\"]*)\" in new epic view$")
	public void i_should_get_result_in_new_stories_view(String expectedResult) throws Throwable {
		WebElement titleText = driver.findElement(By.id("epic-title"));
		String result = titleText.getText();

		// Verify that result
		Assert.assertEquals(result, expectedResult);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
