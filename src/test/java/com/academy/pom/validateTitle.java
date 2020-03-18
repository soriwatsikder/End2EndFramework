package com.academy.pom;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectModel.LandingPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.io.IOException;

import resources.baseClass;

public class validateTitle extends baseClass{
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized For Validating Home Page");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page to Validate");
	}
	
	@Test
	public void ValidateAppTitle() throws IOException {
		
		//to access there two ways 1. inheritance 2. create object of the class and invoke 
		
		LandingPage lp = new LandingPage(driver);
		
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated the Tilte");
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation Bar Successfully Displayed");
			
		}
	@AfterTest
	public void terdown() {
		driver.close();
		driver=null;
		log.info("Validation is Done and Closed Browser");
	}

}
