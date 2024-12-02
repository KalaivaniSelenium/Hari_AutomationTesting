package com.anhtester.projects.website.GeekLadder.stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.anhtester.keywords.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GL_Login {
	
	//Valid user logs in successfully
	String TextBeforeLogin;
	@Given("User navigates to the URL {string}")
	public void User_navigates_to_the_url(String url) {
	    WebUI.getURL(url);
	    WebUI.clickElement(By.xpath("//button[text()='Accept']"));
	    TextBeforeLogin = WebUI.getTextElement(By.xpath("//a[@class='btn-1 hasicon btnjoin']"));
	}

	@Given("Click on Login button on the top")
	public void click_on_Login_button_on_the_top() {
	    WebUI.clickElement(By.xpath("//span[contains(text(),'Log In')]"));
	    String Expected = "Welcome Back Geek!";
		String Actual = WebUI.getTextElement(By.xpath("//div[@id='pp-login']//div[@class='modal-body']")).substring(0, 18);
		Assert.assertEquals(Expected, Actual, "Failed to Navigates to the LoginPage");
	}

	@Given("User enter email address {string} and enter password {string}")
	public void user_enter_email_address_and_enter_password(String email, String pass) {
		WebUI.setText(By.xpath("//input[@id='loginform-email']"), email);
		WebUI.setText(By.xpath("//input[@id='enterpassword1']"), pass);
	}

	@When("User clicks the Login button")
	public void User_clicks_the_login_button() {
		WebUI.clickElement(By.xpath("//button[text()='Log In']"));
	}

	@Then("User should be redirected to the dashboard")
	public void User_should_be_redirected_to_the_dashboard() {
	    String Actual = WebUI.getTextElement(By.xpath("//a[@class='btn-1 hasicon']"));
	    Assert.assertNotEquals(TextBeforeLogin, Actual);
	    
	}
	//Invalid login attempt with incorrect password
	
	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String string) {
	   String Actual = WebUI.getTextElement(By.xpath("//div[contains(text(),'Invalid password.')]"));
	   Assert.assertEquals("Invalid password.", Actual);
	}
	
	//Invalid login attempt with incorrect password

	@Then("Error message {string} should be display")
	public void error_message_should_be_display(String string) {
	    String Actual = WebUI.getTextElement(By.xpath("//div[normalize-space()='Please enter a valid Email to Login.']"));
	    Assert.assertEquals(Actual, "Please enter a valid Email to Login.");
	}
	
	
	
}
