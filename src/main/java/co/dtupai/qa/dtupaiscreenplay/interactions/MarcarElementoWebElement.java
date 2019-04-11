package co.dtupai.qa.dtupaiscreenplay.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class MarcarElementoWebElement implements Interaction {

	private WebElement target;
	public MarcarElementoWebElement(WebElementFacade target) {
		this.target = (WebElement) target;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver()).executeScript("arguments[0].style.border='3px solid red'", target);
	}
	
	/**
	 * Retorna la clase MarcarElementoWebElement para ser inicializada en el tiempo de ejecuci�n
	 * El parametro unicamente puede ser de tipo WebElementFacade
	 * @param target el elemento seleccionado al momento de ejecutar el metodo
	 * @return Retorna la inicializaci�n de la clase MarcarElementoWebElement en tiempo de ejecuci�n, enviandole el parametro target
	 */
	public static MarcarElementoWebElement marcaElElementoWebElement(WebElementFacade target) {
		// TODO Auto-generated method stub
		return instrumented(MarcarElementoWebElement.class, target);
	}
}
