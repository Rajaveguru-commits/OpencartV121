package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test(groups= {"Regression","Master"})//Step8 groups added
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		//Reference by HomePage class
		try
		{
		HomePage hp=new HomePage(driver);
		
		logger.info("Clicked on MyAccount Link.. ");
		hp.clickMyAccount();
		
		logger.info("Clicked on Register Link.. ");
		hp.clickRegister();
		
		//Reference by AccountRegistrationPage class
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message..");
		
		String confmsg=regpage.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Confirmation message mismatch");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			
			Assert.assertTrue(true);
			logger.info("Test passed");
		}
		else {
			
			Assert.assertTrue(false);
			logger.error("Test failed:");
			logger.debug("debug mode");
		}
		
		}
		catch (Exception e)
		{
			
			Assert.fail();
		} 
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}

		
	}
	
	
	
	

}
