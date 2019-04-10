package co.dtupai.qa.dtupaiscreenplay.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class Highlight {
	
	WebDriver driver;
	
	public Highlight(WebDriver driver) {
		super();
		this.driver = driver;
	}



	public void highlightTarget( Target inputSearch) {
		if(driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath(inputSearch.getCssOrXPathSelector())));
		}
	}
	
	public void highlightElement( WebElementFacade webElementFacade) {
		if(driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", webElementFacade);
		}
	}
}