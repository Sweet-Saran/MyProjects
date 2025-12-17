package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class TestNgHome extends Common{
	public static By googleXpath = By.xpath("//textarea[@title='Search']");
	public static By yahooXpath = By.xpath("//input[contains(@placeholder,'Search the web')]");
	public static By bingXpath = By.xpath("//div[@class='sb_form_ic']//textarea[@type='search']");

	public void googleSearch(String data) {
		Common.loadUrl("https://www.google.com/");
		Common.webElementXpathWait(googleXpath);
		WebElement GoogleSearch = driver.findElement(googleXpath);
		GoogleSearch.click();
		GoogleSearch.clear();
		GoogleSearch.sendKeys(data + Keys.ENTER);
	}

	public void yahooSearch() {
		Common.loadUrl("https://in.search.yahoo.com/?fr2=inr");

		Common.webElementXpathWait(yahooXpath);
		WebElement yahooSearch = driver.findElement(yahooXpath);
		yahooSearch.click();
		yahooSearch.clear();
		yahooSearch.sendKeys("hi" + Keys.ENTER);
	}
	
	public static void bingSearch() {
		Common.loadUrl("https://www.bing.com/");

		Common.webElementOccurance(bingXpath);
		WebElement bingSearch = driver.findElement(bingXpath);
		Common.javaScriptExecutorClick(bingSearch);
		bingSearch.clear();
		bingSearch.sendKeys("hi" + Keys.ENTER);
	}
	
}
