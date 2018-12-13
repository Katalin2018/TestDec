package ro.sapientia.mesteri2018.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMSprintUpdateStepDefinition {

	protected WebDriver driver;
	private int childrenSize;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^It is an element in the story list$")
	public void I_edit_the_scrum_list_s_first_story() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
		WebElement firstItem = driver.findElement(By.id("story-list"));
		WebElement children = firstItem.findElement(By.className("well"));
		//childrenSize = children.size();
		assertTrue("No element in the List",childrenSize > 0);
		//children.get(0).findElement(By.tagName("a")).clock();
		
	}

	@When("^I push the delete button$")
	public void I_enter_in_the_title_textbox_and_I_push_the_update_button() throws Throwable {
		WebElement deleteButton = driver.findElement(By.id("delete-story-link"));
		deleteButton.click();
		WebElement deleteStoryButton = driver.findElement(By.id("delete-story-button"));
		deleteStoryButton.click();
		
	}

	@Then("^The element should disapear from the list$")
	public void I_should_get_result_in_new_stories_list(String expectedResult) throws Throwable {
		WebElement firstItem = driver.findElement(By.id("story-list"));
		WebElement children =  firstItem.findElement(By.className("well"));
		//assertTrue("No element in the List",children.getSize() == childrenSize - 1);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
