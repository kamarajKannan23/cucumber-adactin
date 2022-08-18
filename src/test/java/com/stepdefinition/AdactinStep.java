package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinStep {
	WebDriver driver;
	List orderIdList = new ArrayList();
	
	@Given("User is on the Adactin Hotel Page")
	public void adactin_hotel_page() {
			
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("http://adactinhotelapp.com/");
	  driver.manage().window().maximize();
	}
	
	
	@When("User should login {string} and {string}")
	public void user_should_login_and(String username, String password) {
		
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(username);

		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
	    
		driver.findElement(By.id("login")).click();
	}

	
	@Then("User should verify success msg")
	public void verify_success_msg() {
		String expectedMsg="Hello Kamal001!";
		String actualMsg = driver.findElement(By.id("username_show")).getAttribute("value");
	    Assert.assertEquals("verifying success msg",expectedMsg, actualMsg);
	}
	
	

	@When("User should search hotel {string}, {string} , {string} , {string} , {string} ,{string} ,{string} and {string}")
	public void user_should_search_hotel_and(String location, String hotels, String room_type, String room_nos, String inDate, String outDate, String adult_room, String child_room) {
		
		WebElement dDnLocation =driver.findElement(By.id("location"));
		Select select = new Select(dDnLocation);
		select.selectByVisibleText(location);
		
		WebElement dDnHotels = driver.findElement(By.id("hotels"));
		select = new Select(dDnHotels);
		select.selectByVisibleText(hotels);
	
		WebElement dDnRoom = driver.findElement(By.id("room_type"));
		select = new Select(dDnRoom);
		select.selectByVisibleText(room_type);
		
		WebElement dDnNoOfRooms = driver.findElement(By.id("room_nos"));
		select = new Select(dDnNoOfRooms);
		select.selectByValue(room_nos);
		
		
		WebElement txtInDatePick = driver.findElement(By.id("datepick_in"));
		txtInDatePick.clear();
		txtInDatePick.sendKeys(inDate);
		
		WebElement txtOutDatePick = driver.findElement(By.id("datepick_out"));
		txtOutDatePick.clear();
		txtOutDatePick.sendKeys(outDate);
		
		WebElement dDnAdult =  driver.findElement(By.id("adult_room"));
		select = new Select(dDnAdult);
		select.selectByVisibleText(adult_room);

		WebElement dDnChild = driver.findElement(By.id("child_room"));
		select = new Select(dDnChild);
		select.selectByVisibleText(child_room);
		
		WebElement btnSearch = driver.findElement(By.id("Submit"));
		btnSearch.click();
		
	}
	
	

	@When("User should select hotel")
	public void user_should_select_hotel() {
		
		WebElement btnRadio = driver.findElement(By.id("radiobutton_0"));
		btnRadio.click();
		
		WebElement btnContinue = driver.findElement(By.id("continue"));
		btnContinue.click();
	  
	}
	@When("User should book hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_book_hotel(String first_name, String last_name, String address, String cc_num, String cc_type, String cc_exp_month, String cc_exp_year, String cc_cvv) {
	   

		WebElement txtFirstName = driver.findElement(By.id("first_name"));
		txtFirstName.sendKeys(first_name);

		WebElement txtLastName = driver.findElement(By.id("last_name"));
		txtLastName.sendKeys(last_name);
		
		WebElement txtAddress = driver.findElement(By.id("address"));
		txtAddress.sendKeys(address);
		
		WebElement txtCreditCardNo = driver.findElement(By.id("cc_num"));
		txtCreditCardNo.sendKeys(cc_num);
		
		WebElement dDnCcType = driver.findElement(By.id("cc_type"));
		Select select = new Select(dDnCcType);
		select.selectByVisibleText(cc_type);
		
		WebElement dDnExpMonth = driver.findElement(By.id("cc_exp_month"));
		select = new Select(dDnExpMonth);
		select.selectByVisibleText(cc_exp_month);

		WebElement dDnExpYear = driver.findElement(By.id("cc_exp_year"));
		select = new Select(dDnExpYear);
		select.selectByVisibleText(cc_exp_year);
		
		WebElement txtCvv = driver.findElement(By.id("cc_cvv"));
		txtCvv.sendKeys(cc_cvv);
		
		WebElement btnBook = driver.findElement(By.id("book_now"));
		btnBook.click();
		
	}
	@Then("User should verify order id")
	public void user_should_verify_order_id() throws InterruptedException {
		Thread.sleep(5000);
		WebElement lblBookingConfirm = driver.findElement(By.xpath("//td[text()='Booking Confirmation ']"));
		String  lblBookingConfirmText = lblBookingConfirm.getText();	
		Assert.assertEquals("Verify BookingConfirm", "Booking Confirmation",lblBookingConfirmText );

		WebElement txtOrderNo =  driver.findElement(By.id("order_no"));
		String OrderNum = txtOrderNo.getAttribute("value");
		System.out.println("Hotel Booked, Order Number :"+OrderNum);	
	  
	}







}

