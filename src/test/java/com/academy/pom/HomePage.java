package com.academy.pom;

import org.testng.annotations.Test;

import PageObjectModel.LandingPage;
import PageObjectModel.LoginPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import resources.baseClass;

public class HomePage extends baseClass{
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized For Validating LogIn");
	}
	
	@Test(dataProvider="getData")
	public void validateAppNav(String Username, String password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page to Validate Login");
		
		//to access there two ways 1. inheritance 2. create object of the class and invoke 
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();  //driver.findElement(By.xpath)
		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(Username);
		lg.getPassword().sendKeys(password);
		//System.out.println(text);
		log.info(text);
		lg.getLogin().click();
	}
		@DataProvider
		public Object[][] getData() {
			Object [][] data = new Object[2][3];
			
			data[0][0]="nonrestricteduser@gmail.com";
			data[0][1]="1234456778888";
			data[0][2]="Non_Restricted Users";
			log.info("Passed first Authentication For Login Validation");
			
			data[1][0]="restricteduser@gmail.com";
			data[1][1]="156778888";
			data[1][2]="Restricted Users";
			log.info("Passed second Authentication for Login Validation");
			
			return data;
			
		}
		@AfterTest
		public void terdown() {
			driver.close();
			driver=null;
			log.info("Browser clossed after Loging Page got validated");
		}
		

}
