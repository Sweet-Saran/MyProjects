package pages;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.ExcelUtils;

public class HomePage extends Common { 
	public static By userName = By.xpath("//td[contains(text(),'Username')]/parent::tr//input");
	public static By passWord = By.xpath("//td[contains(text(),'Password')]/parent::tr//input");
	public static By logInBtn = By.xpath("//input[@class='login_button']");
	public static By logo = By.xpath("//img[@class='logo']");
	public static By checkIn = By.xpath("//td[contains(text(),'Check In Date')]/parent::tr//input[@class='date_pick']");
	public static By checkOut = By
			.xpath("//td[contains(text(),'Check Out Date')]/parent::tr//input[@class='date_pick']");
	public static By clickBtn = By.xpath("//input[@name='Submit']");
	public static By radioBtn = By.xpath("//input[@name='radiobutton_0']");
	public static By continueBtn = By.xpath("//input[@name='continue']");
	public static By bookNow = By.xpath("//input[@value='Book Now']");
	public static By orderNo = By.xpath("//td[contains(text(),'Order No.')]/parent::tr//input");

	public void pageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='Book Now']")
	WebElement bookNow1;
	
	public static void login() throws InterruptedException, IOException {
		Common.webElementOccurance(userName);
		WebElement element = driver.findElement(userName);
		element.sendKeys(Common.readProperty("Username"));

		Common.webElementOccurance(passWord);
		WebElement element1 = driver.findElement(passWord);
		element1.sendKeys(Common.readProperty("Password"));

		Common.webElementOccurance(logInBtn);
		WebElement element2 = driver.findElement(logInBtn);
		Common.webElementWait(element2);
		element2.click();
	}

	public static boolean verifyHomepageLogo() throws InterruptedException {
		Common.webElementOccurance(logo);
		WebElement element = driver.findElement(logo);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	static String[] xPath = { "Location", "Hotels", "Room Type", "Number of Rooms", "Check In Date", "Check Out Date",
			"Adults per Room", "Children per Room" };
	static String[] valueXpath = { "location", "hotels", "room_type", "room_nos", "Check In Date", "Check Out Date",
			"adult_room", "child_room" };

	static List<String> listofXpath = new ArrayList<String>(Arrays.asList(xPath));
	static List<String> listofXpathValues = new ArrayList<String>(Arrays.asList(valueXpath));

	public static void dropDownLocation() throws InterruptedException, IOException {
//		System.out.println(listofXpath);
		
		Common.quickWait();
		WebElement drpdwnvalue = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofXpath.get(0) + "')]/parent::tr//select"));
		Common.webElementWait(drpdwnvalue);
		drpdwnvalue.click();
		
		Common.quickWait();
		WebElement drpdwnvalues = driver.findElement(By.xpath("//select[@id='" + listofXpathValues.get(0) + "']"));
		Common.selectByVisibleText(drpdwnvalues, "Paris");
		System.out.println("selected location");
	}

	public static void dropDownHotel() throws InterruptedException, IOException {
		WebElement drpdwnvalue = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofXpath.get(1) + "')]/parent::tr//select"));
		Common.webElementWait(drpdwnvalue);
		drpdwnvalue.click();

		Common.quickWait();
		WebElement drpdwnvalues = driver.findElement(By.xpath("//select[@id='" + listofXpathValues.get(1) + "']"));
		Common.selectByVisibleText(drpdwnvalues, "Hotel Sunshine");
		System.out.println("selected hotel");
	}

	public static void dropDownRoomtype() throws InterruptedException, IOException {
		WebElement drpdwnvalue = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofXpath.get(2) + "')]/parent::tr//select"));
		Common.webElementWait(drpdwnvalue);
		drpdwnvalue.click();

		Common.quickWait();
		WebElement drpdwnvalues = driver.findElement(By.xpath("//select[@id='" + listofXpathValues.get(2) + "']"));
		Common.selectByVisibleText(drpdwnvalues, "Super Deluxe");
		System.out.println("selected RoomType");
	}

	public static void dropDownNoOfRms() throws InterruptedException, IOException {
		Common.quickWait();
		WebElement drpdwnvalue = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofXpath.get(3) + "')]/parent::tr//select"));
		Common.webElementWait(drpdwnvalue);
		drpdwnvalue.click();

		Common.quickWait();
		WebElement drpdwnvalues = driver.findElement(By.xpath("//select[@id='" + listofXpathValues.get(3) + "']"));
		Common.selectByVisibleText(drpdwnvalues, "2 - Two");
		System.out.println("selected no of rooms");
	}

	public static void dropDownAdultRoom() throws InterruptedException, IOException {
		Common.quickWait();
		WebElement drpdwnvalue = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofXpath.get(6) + "')]/parent::tr//select"));
		Common.webElementWait(drpdwnvalue);
		drpdwnvalue.click();

		Common.quickWait();
		WebElement drpdwnvalues = driver.findElement(By.xpath("//select[@id='" + listofXpathValues.get(6) + "']"));
		Common.selectByVisibleText(drpdwnvalues, "1 - One");
		System.out.println("selected adult room");
	}

	public static void dropDownChildRoom() throws InterruptedException, IOException {
		Common.quickWait();
		WebElement drpdwnvalue = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofXpath.get(7) + "')]/parent::tr//select"));
		Common.webElementWait(drpdwnvalue);
		drpdwnvalue.click();

		Common.quickWait();
		WebElement drpdwnvalues = driver.findElement(By.xpath("//select[@id='" + listofXpathValues.get(7) + "']"));
		Common.selectByVisibleText(drpdwnvalues, "3 - Three");
		System.out.println("selected child room");
	}

	public static void checkInDate() throws InterruptedException, IOException {
		Random random = new Random();
		int daysToAdd = random.nextInt(15) + 1; // 1–15 days
		LocalDate futureDate = LocalDate.now().plusDays(daysToAdd);
		String formattedDate = futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Common.webElementOccurance(checkIn);
		WebElement dateField = driver.findElement(checkIn);
		Common.webElementWait(dateField);
		dateField.clear();
		dateField.sendKeys(formattedDate);
		System.out.println("Random check in date entered: " + formattedDate);
	}

	public static void checkOutDate() throws InterruptedException, IOException {
		Random random = new Random();
		int daysToAdd = random.nextInt(16) + 15; // 0–15 + 15 → 15–30 days
		LocalDate futureDate = LocalDate.now().plusDays(daysToAdd);
		String formattedDate = futureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Common.webElementOccurance(checkOut);
		WebElement dateField = driver.findElement(checkOut);
		Common.webElementWait(dateField);
		dateField.clear();
		dateField.sendKeys(formattedDate);
		System.out.println("Random check out date entered: " + formattedDate);
	}

	public static void clickSubmit() {
		Common.webElementOccurance(clickBtn);
		WebElement element = driver.findElement(clickBtn);
		Common.webElementWait(element);
		Common.javaScriptExecutorClick(element);
		System.out.println("clicked seach button");
	}

	public static void radioButton() {
		Common.webElementOccurance(radioBtn);
		WebElement element = driver.findElement(radioBtn);
		Common.webElementWait(element);
		Common.javaScriptExecutorClick(element);
		System.out.println("clicked radio button");
	}

	public static void continueBtn() {
		Common.webElementOccurance(continueBtn);
		WebElement element = driver.findElement(continueBtn);
		Common.webElementWait(element);
		Common.javaScriptExecutorClick(element);
		System.out.println("clicked continue button");
	}

	static String[] hotelXpath = { "First Name", "Last Name", "Billing Address", "Credit Card No.", "CVV Number" };
	static String[] bookHotelValue = { "poornima", "allimuthu", "karukku123456789", "1234567891234567", "123" };
	static List<String> listofHtlXpath = new ArrayList<String>(Arrays.asList(hotelXpath));
	static List<String> listofHtlValue = new ArrayList<String>(Arrays.asList(bookHotelValue));

//	public static void bookFirstName() throws InterruptedException {
//		Common.quickWait();
//		WebElement element = driver
//				.findElement(By.xpath("//td[contains(text(),'" + listofHtlXpath.get(0) + "')]/parent::tr//input"));
//		Common.webElementWait(element);
//		element.clear();
//		element.click();
//		element.sendKeys(listofHtlValue.get(0));
//		System.out.println("Entered FirstName");
//	}
	
    public static void bookFirstName() throws InterruptedException, IOException {
        String filePath = "C:\\Users\\cutem\\Downloads\\SeptemberProject2025\\SeptemberProject2025\\src\\test\\resources\\DataType\\Adacitin.xlsx"; 
        Map<String, String> bookingData = ExcelUtils.readHotelData(filePath);

        for (Map.Entry<String, String> entry : bookingData.entrySet()) {
            String field = entry.getKey();
            String value = entry.getValue();

            WebElement element = driver.findElement(
                By.xpath("//td[contains(text(),'" + field + "')]/parent::tr//input")
            );

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(value);
            System.out.println("Entered " + field + ": " + value);
        }
        System.out.println("✅ All hotel booking fields entered successfully!");
    }

	public static void bookLastName() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofHtlXpath.get(1) + "')]/parent::tr//input"));
		Common.webElementWait(element);
		element.click();
		element.clear();
		element.sendKeys(listofHtlValue.get(1));
		System.out.println("Entered LastName");
	}

	public static void bookBillingAddress() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver
				.findElement(By.xpath("//td[contains(text(),'Billing Address')]/parent::tr//textarea"));
		Common.webElementWait(element);
		element.click();
		element.clear();
		element.sendKeys(listofHtlValue.get(2));
		System.out.println("Entered Billing Address");
	}

	public static void creditCardNo() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofHtlXpath.get(3) + "')]/parent::tr//input"));
		Common.webElementWait(element);
		element.click();
		element.clear();
		element.sendKeys(listofHtlValue.get(3));
		System.out.println("Entered Credit Card No.");
	}

	public static void cvvNo() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofHtlXpath.get(4) + "')]/parent::tr//input"));
		Common.webElementWait(element);
		element.click();
		element.clear();
		element.sendKeys(listofHtlValue.get(4));
		System.out.println("Entered Cvv No.");
	}

	static String[] ccXpath = { "Credit Card Type", "Expiry Date" };
	static String[] ccValue = { "cc_type", "cc_exp_month", "cc_exp_year" };
	static List<String> listofCcXpath = new ArrayList<String>(Arrays.asList(ccXpath));
	static List<String> listofCcValue = new ArrayList<String>(Arrays.asList(ccValue));

	public static void creditCardType() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver
				.findElement(By.xpath("//td[contains(text(),'" + listofCcXpath.get(0) + "')]/parent::tr//select"));
		Common.webElementWait(element);
		element.click();

		Common.quickWait();
		WebElement element1 = driver.findElement(By.xpath("//select[@id='" + listofCcValue.get(0) + "']"));
		Common.selectByVisibleText(element1, "American Express");
		System.out.println("Entered CC Type.");
	}

	public static void creditExpiryMonth() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver.findElement(By.xpath(
				"//td[contains(text(),'" + listofCcXpath.get(1) + "')]/parent::tr//select[@name='cc_exp_month']"));
		Common.webElementWait(element);
		element.click();

		Common.quickWait();
		WebElement element1 = driver.findElement(By.xpath("//select[@id='" + listofCcValue.get(1) + "']"));
		Common.selectByVisibleText(element1, "November");
		System.out.println("Entered CC Expiry Month.");
	}

	public static void creditExpiryYear() throws InterruptedException {
		Common.quickWait();
		WebElement element = driver.findElement(By.xpath(
				"//td[contains(text(),'" + listofCcXpath.get(1) + "')]/parent::tr//select[@name='cc_exp_year']"));
		Common.webElementWait(element);
		element.click();

		Common.quickWait();
		WebElement element1 = driver.findElement(By.xpath("//select[@id='" + listofCcValue.get(2) + "']"));
		Common.selectByVisibleText(element1, "2025");
		System.out.println("Entered CC Expiry year.");
	}

	public static void bookNow() throws InterruptedException {
		Common.webElementOccurance(bookNow);
		WebElement element = driver.findElement(bookNow);
		Common.webElementWait(element);
		Common.javaScriptExecutorClick(element);
//		Common.mediumWait();
		System.out.println("Clicked BookNow");

		Common.webElementOccurance(orderNo);
		WebElement element1 = driver.findElement(orderNo);
		@Nullable
		String attribute = element1.getAttribute("value");
		System.out.println("Retrived Order No::" + attribute);
		Common.quitBrowser();
	}
}