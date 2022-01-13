package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCoustmerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCoustmerTest_003 extends BaseClass {

	@Test
	public void addNewCoustmer() throws Exception {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clicksubmit();
		AddCoustmerPage addcust=new AddCoustmerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing customer details....");
		addcust.custName("Ankush");
		addcust.custgender("Male");
		addcust.custdob("10","29","1990");
		Thread.sleep(3000);
		addcust.custaddress("Camp");
		addcust.custcity("AMT");
		addcust.custstate("MH");
		addcust.custpinno("444601");
		addcust.custtelephoneno("8888999900");
	
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcd12");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		logger.info("Validation Started..");
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("Testcase is Passed...");
		}
		else {
			logger.info("Testcase is Failed...");
			captureScreen(driver, "addNewCoustmer");
			Assert.assertTrue(false);
			
		}
	}
	
}
