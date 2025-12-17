package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class JunitHomePage extends Common {

	public static By googleXpath = By.xpath("//textarea[@title='Search']");
	public static By yahooXpath = By.xpath("//input[contains(@placeholder,'Search the web')]");

	public static void invokeBrowser() {
		Common.browserLaunch("Chrome");
	}

	public void googleSearch() {
		Common.loadUrl("https://www.google.com/");

		Common.webElementXpathWait(googleXpath);
		WebElement GoogleSearch = driver.findElement(googleXpath);
		GoogleSearch.click();
		GoogleSearch.clear();
		GoogleSearch.sendKeys("hi" + Keys.ENTER);
	}
	public void yahooSearch() {
		Common.loadUrl("https://in.search.yahoo.com/?fr2=inr");

		Common.webElementXpathWait(yahooXpath);
		WebElement yahooSearch = driver.findElement(yahooXpath);
		yahooSearch.click();
		yahooSearch.clear();
		yahooSearch.sendKeys("hi" + Keys.ENTER);
	}
}
