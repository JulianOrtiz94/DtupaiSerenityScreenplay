package co.dtupai.qa.dtupaiscreenplay.userinterfaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.dtupai.co/index.php?main_page=advanced_search_result&search_in_description=1&keyword=zapatillas&search=")
public class DtupaiResultPage extends PageObject{
	private static final String textSearchId = "advSearchResultsDefaultHeading";
	//private static final By listResults= By.xpath();
	private static final String productName = "//h1[@class='productGeneral']";
	
	
	public static final Target TEXT_SEARCH = Target.the("Resultado de la busqueda") 		
            .located(By.id(textSearchId));
	
	public static final Target PRODUCT_NAME = Target.the("Nombre del producto") 		
            .locatedBy(productName);
	
	@FindBy( xpath = "//body[@id='advancedsearchresultBody']/div[@class='main-container']/div[@class='mains']/table[@id='contentMainWrapper_gerg']/tbody/tr/td/div[@id='mainbody']/div[@id='cuerpo-contenido']/div[@id='advSearchResultsDefault']/div[@id='productListing']/div[@id='productListing']/div")
	public static List<WebElementFacade> listResults; 
}
