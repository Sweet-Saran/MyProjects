package businesscomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.Common;

public class SMJUnitHomepg extends Common {
	
	public static By youtubSearch  = By.xpath("//input[@name='search_query']");
	public static By fbUserName  = By.xpath("//input[@name='email']");
	public static By fbPassword  = By.xpath("//input[@name='pass']");
	public static By fbloginBtn  = By.xpath("//button[@name='login']");

	
	public static void invokeBrowser() {
		Common.browserLaunch("Chrome");
	}

	public void youTube() {
		Common.loadUrl("https://www.youtube.com/");
		Common.webElementOccurance(youtubSearch);
		WebElement search = driver.findElement(youtubSearch);
		search.clear();
		search.click();
		search.sendKeys("selenium" + Keys.ENTER);		
	}
	public void faceBookLogin() {
		Common.loadUrl("https://www.facebook.com/");

		Common.webElementOccurance(fbUserName);
		WebElement userName = driver.findElement(fbUserName);
		userName.sendKeys("Poornima");

		Common.webElementOccurance(fbPassword);
		WebElement password = driver.findElement(fbPassword);
		password.sendKeys("Poornima@123");
		
		Common.webElementOccurance(fbloginBtn);
		WebElement loginBtn = driver.findElement(fbloginBtn);
		Common.webElementXpathWait(fbloginBtn);
		loginBtn.click();
	}
}
