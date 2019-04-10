package co.dtupai.qa.dtupaiscreenplay.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage.listResults;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.dtupai.qa.dtupaiscreenplay.utils.ConexionInternet;

public class SeleccionarProducto implements Task{
	
	public int posicion;

	public SeleccionarProducto(int posicion) {
		this.posicion = posicion;
	}
	
	@Step("{0} selecciona el producto de la posicion #posicion")
	@Override
	public <T extends Actor> void performAs(T actor) {
		ConexionInternet.internetConnection();
		actor.attemptsTo(
					Click.on(listResults.get(posicion))
				);
		
	}

	/**
	 * Retorna la clase SeleccionarProducto para ser inicializada en el tiempo de ejecución
	 * El parametro unicamente puede ser de tipo Integer
	 * @param posicion La posicion del producto en la lista de resultados
	 * @return Retorna la inicialización de la clase SeleccionarProducto en tiempo de ejecución, enviandole el parametro posicion
	 */
	public static SeleccionarProducto enLaPosicion(int posicion) {
		return instrumented(SeleccionarProducto.class, posicion);
	}

}
