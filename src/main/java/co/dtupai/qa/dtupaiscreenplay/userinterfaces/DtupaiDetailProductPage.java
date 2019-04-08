package co.dtupai.qa.dtupaiscreenplay.userinterfaces;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;


public class DtupaiDetailProductPage extends PageObject{
	@FindBy( xpath = "//div[@id='sxDiv']//div[1]//div[2]//input")
	public static List<WebElementFacade> listSizes; 
	
	@FindBy( xpath = "//form[@name='cart_quantity']//div[3]//div[2]//input")
	public static List<WebElementFacade> listColors; 
	
	private static final String inputQuantity = "//span[@class='qty']//input[@value='1']";
	private static final String addButton = "//input[contains(@title,'A�adir al carro')]";
	
	public static final Target INPUT_QUANTITY = Target.the("Cantidad del producto") 		
            .located(By.id(inputQuantity));
	
	public static final Target ADD_BUTTON = Target.the("Bot�n agregar producto al carrito ") 		
            .locatedBy(addButton);
	
}