package businesscomponents;

import java.io.IOException;

import com.googel.basepackage.UtilitiesClass;

import framework.Status;
import pages.Common;
import pages.HomePage;

public class Adactin extends HomePage { 

	public static void invokeApp() throws IOException {
		try {
			Common.browserLaunch("Chrome");
			Common.loadUrl(Common.readProperty("Url"));
			System.out.println("Browser is getting Launch");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void loginADC() throws IOException, InterruptedException {
		try {
			HomePage.login();
			System.out.println("Website Launch = Adacin");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void verifyHomepage() throws InterruptedException {
		try {
			boolean verifyHomepageLogo = HomePage.verifyHomepageLogo();
			System.out.println("LogoDisplayed = Adacin:: " + verifyHomepageLogo);
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void dropDown() throws InterruptedException, IOException {
		try {
			HomePage.dropDownLocation();
			HomePage.dropDownHotel();
			HomePage.dropDownRoomtype();
			HomePage.dropDownNoOfRms();
			HomePage.dropDownAdultRoom();
			HomePage.dropDownChildRoom();
			System.out.println("selected dropdown values");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void checkInDate() throws InterruptedException, IOException {
		try {
			HomePage.checkInDate();
			System.out.println("selected check in date");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void checkOutDate() throws InterruptedException, IOException {
		try {
			HomePage.checkOutDate();
			System.out.println("selected check out date");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void clickSubmit() {
		try {
			HomePage.clickSubmit();
			System.out.println("search clicked");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void radioButton() {
		try {
			HomePage.radioButton();
			System.out.println("search clicked");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void continueButton() {
		try {
			HomePage.continueBtn();
			System.out.println("search clicked");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void bookHotel() {
		try {
			HomePage.bookFirstName();
			HomePage.bookLastName();
			HomePage.bookBillingAddress();
			HomePage.creditCardNo();
			HomePage.cvvNo();
			System.out.println("Booking details added");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void creditCard() throws InterruptedException {
		try {
			HomePage.creditCardType();
			HomePage.creditExpiryMonth();
			HomePage.creditExpiryYear();
			System.out.println("Credit Card Details");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}

	public static void bookNow() throws InterruptedException {
		try {
			HomePage.bookNow();
			System.out.println("Booked Successfully");
			UtilitiesClass.printDateTime();
			Common.updateLog(Status.PASS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Common.updateLog(Status.FAIL);
		}
	}
}
