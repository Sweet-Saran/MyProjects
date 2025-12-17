package businesscomponents;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googel.basepackage.UtilitiesClass;

import framework.Status;
import org.junit.After;
import pages.Common;

public class SMJunitMainpg extends SMJUnitHomepg {
	@BeforeClass
	public static void invokeBrowser() {
		try {
			SMJUnitHomepg.browserLaunch("Chrome");
			System.out.println("Browser Launch");
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	@Before
	public void waitTime() throws InterruptedException {
		try {
			Common.quickWait();
			System.out.println("Waiting");
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	@Test
	public void youTube() {
		try {
			SMJUnitHomepg utub = new SMJUnitHomepg();
			utub.youTube();
			System.out.println("youTube");
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	@Test
	public void faceBookLogin() {
		try {
			SMJUnitHomepg fblogin = new SMJUnitHomepg();
			fblogin.faceBookLogin();
			System.out.println("FB login");
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	@After
	public void utility() {
		try {
			UtilitiesClass.printDateTime();
			System.out.println("Date and Time");
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	@AfterClass
	
	public static void closeBrowser() {
		try {
		Common.quitBrowser();
		Common.updateLog(Status.PASS);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}
}