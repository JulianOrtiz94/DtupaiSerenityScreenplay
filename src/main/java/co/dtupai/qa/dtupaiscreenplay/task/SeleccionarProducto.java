package co.dtupai.qa.dtupaiscreenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage.listResults;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProducto implements Task{
	
	public int posicion;

	public SeleccionarProducto(int posicion) {
		this.posicion = posicion;
	}
	
	@Step("{0} selecciona el producto de la posicion #posicion")
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(
					Click.on(listResults.get(posicion))
				);
		
	}

	public static SeleccionarProducto enLaPosicion(int posicion) {
		return instrumented(SeleccionarProducto.class, posicion);
	}

}
