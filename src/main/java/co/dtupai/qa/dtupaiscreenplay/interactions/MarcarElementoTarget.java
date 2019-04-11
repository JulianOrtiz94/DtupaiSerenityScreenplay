package co.dtupai.qa.dtupaiscreenplay.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class MarcarElementoTarget implements Interaction{

	private Target target;
	public MarcarElementoTarget(Target target) {
		this.target = target;
	}
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver()).executeScript("arguments[0].style.border='3px solid red'", target.resolveFor(actor));
	}
	
	/**
	 * Retorna la clase MarcarElementoTarget para ser inicializada en el tiempo de ejecución
	 * El parametro unicamente puede ser de tipo Target
	 * @param target el elemento seleccionado al momento de ejecutar el metodo
	 * @return Retorna la inicialización de la clase MarcarElementoWebElement en tiempo de ejecución, enviandole el parametro target
	 */
	public static MarcarElementoTarget marcaElElementoTarget(Target target) {
		// TODO Auto-generated method stub
		return instrumented(MarcarElementoTarget.class, target);
	}
	
}
