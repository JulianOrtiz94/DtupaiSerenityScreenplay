package co.dtupai.qa.dtupaiscreenplay.questions;

import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiShoppingCartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ProductoEnElCarrito implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return DtupaiShoppingCartPage.TEXT_PRICE.resolveFor(actor).waitUntilVisible().getText();
	}

	public static ProductoEnElCarrito conPrecio () {
		return new ProductoEnElCarrito();
	}
}
