package businesscomponents;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googel.basepackage.UtilitiesClass;

import pages.Common;
import pages.JunitHomePage;

public class AdacitinJUnit extends JunitHomePage {
	@BeforeClass
	public static void browserInvoke() {
		JunitHomePage.invokeBrowser();
		System.out.println("Browser is getting Launch");
	}

	@Test
	public void googleSearch() {
		JunitHomePage junit = new JunitHomePage();
		junit.googleSearch();
		System.out.println("Google search");
	}
	
	@Test
	public void yahooSearch() {
		JunitHomePage junit = new JunitHomePage();
		junit.yahooSearch();
		System.out.println("Yahoo search");
	}

	@AfterClass
	public static void terminateBrowser() {
		Common.quitBrowser();
		System.out.println("Just close");
	}

	@After
	public void utility() {
		UtilitiesClass.printDateTime();
		System.out.println("DateTime");
	}

	@Before
	public  void waitTime() throws InterruptedException {
		Common.quickWait();
		System.out.println("Please wait");
	}
}
