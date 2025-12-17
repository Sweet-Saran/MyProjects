package businesscomponents;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.googel.basepackage.UtilitiesClass;

import pages.Common;
import pages.TestNgHome;

public class BingAdacitinTestNG {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Opening VPN connection");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Opening VDI connection");
	}

	@BeforeGroups(groups = "Regression")
	public void beforeGroups() {
		System.out.println("Running Regression");
	}

	@Parameters ({"Browser"}) 
	@BeforeClass
	public void browserInvoke(String browser) {
		Common.browserLaunch("firefox");
		System.out.println("Browser is getting Launch");
	}

	@BeforeMethod
	public void waitTime() throws InterruptedException {
		Common.quickWait();
		System.out.println("Please wait");
	}
	
	@Test(groups = "Regression")
	public void bingSearch() {
		TestNgHome.bingSearch();
		System.out.println("Bing search");
	}

	@AfterMethod
	public void utility() {
		UtilitiesClass.printDateTime();
		System.out.println("DateTime");
	}
	
	@AfterClass
	public void terminateBrowser() {
		Common.quitBrowser();
		System.out.println("Just close");
	}
	
	@AfterGroups(groups = "Regression")
	public void afterGroups() {
		System.out.println("Regression Report Generated");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Closing VDI connection");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After report, Closing VPN connection");
	}
}



