package co.dtupai.qa.dtupaiscreenplay.userinterfaces;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;


public class DtupaiDetailProductPage extends PageObject{
	@FindBy( xpath = "//div[@id='sxDiv']//div[1]//div[2]//input")
	public static List<WebElementFacade> listSizes; 
	
	@FindBy( xpath = "//form[@name='cart_quantity']//div[3]//div[2]//input")
	public static List<WebElementFacade> listColors; 
	
	private static final String inputQuantity = "//span[@class='qty']//input";
	private static final String addButton = "//input[contains(@title,'Añadir al carro')]";
	
	public static final Target INPUT_QUANTITY = Target.the("Cantidad del producto") 		
            .locatedBy(inputQuantity);
	
	public static final Target ADD_BUTTON = Target.the("Botón agregar producto al carrito ") 		
            .locatedBy(addButton);
	
}
