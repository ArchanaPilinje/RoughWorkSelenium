package com.testngfile;

import org.testng.annotations.Test;

import com.ExcelKeyword.Keywords;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;


public class TestNGAssignment {

	WebDriver driver = new ChromeDriver();
	
	

	@Test (priority=1)
	public void login() {
		Keywords excelFile=new Keywords();
		 excelFile.setInputFile("E:/KeywordDrivenCheck.xls");
	     try {
			excelFile.read();
		} catch (IOException e) {
			System.out.println(e);
		}
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		if(username.isDisplayed()) {
		username.sendKeys(excelFile.id);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();}
		else {
		System.out.println("Not displayed username");
		}
		WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		if (password.isDisplayed()) {
			System.out.println("Pasword field is displayed");
			password.sendKeys(excelFile.pwd);
			driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		} else {
			System.out.println("Password field is not displayed");
		}
	}
	
	@Test (priority=2)
	public void signout() {
		System.out.println("Sign out begin");
		 Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		 actions.moveToElement(menuOption);
		 WebElement signOut=driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
		 actions.moveToElement(signOut);
		 actions.click().build().perform();
		 
		
		
	}
	

	@BeforeTest
	public void beforeTest() {
		System.out.println("Launching the Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		System.out.println("Navigating to Amazon website");
		String baseUrl = "http://www.amazon.in/";
		driver.navigate().to(baseUrl);
		
		
		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Successful Execution!");
	}

}
