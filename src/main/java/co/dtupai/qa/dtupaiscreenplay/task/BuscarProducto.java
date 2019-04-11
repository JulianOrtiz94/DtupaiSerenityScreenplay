package co.dtupai.qa.dtupaiscreenplay.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

import co.dtupai.qa.dtupaiscreenplay.interactions.MarcarElementoTarget;
import co.dtupai.qa.dtupaiscreenplay.utils.ConexionInternet;

import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiHomePage.INPUT_SEARCH;

import net.serenitybdd.screenplay.Actor;

public class BuscarProducto implements Task{
	
	public String producto;
	
	public BuscarProducto(String producto) {
		this.producto = producto;
	}
	
	@Step("{0} ingresa #producto en la barra de busqueda")
	@Override
	public <T extends Actor> void performAs(T actor) {
		ConexionInternet.internetConnection();
		actor.attemptsTo(
					MarcarElementoTarget.marcaElElementoTarget(INPUT_SEARCH),
					Enter.theValue(producto).into(INPUT_SEARCH).thenHit(Keys.ENTER)
				);
	}
	
	/**
	 * Retorna la clase BuscarProducto para ser inicializada en el tiempo de ejecución
	 * El parametro unicamente puede ser de tipo String
	 * @param producto el producto seleccionado al momento de ejecutar el metodo
	 * @return Retorna la inicialización de la clase BuscarProducto en tiempo de ejecución, enviandole el parametro producto
	 */
	public static BuscarProducto conElNombre(String producto) {
		return instrumented(BuscarProducto.class, producto);
	}
}
