package co.dtupai.qa.dtupaiscreenplay.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DtupaiShoppingCartPage extends PageObject{
	private static final String priceProduct = "//td[@class='cartUnitDisplay']";

	public static final Target TEXT_PRICE = Target.the("Precio del producto") 		
            .locatedBy(priceProduct);
}
