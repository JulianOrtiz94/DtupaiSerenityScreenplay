package co.dtupai.qa.dtupaiscreenplay.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

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
		// TODO Auto-generated method stub
		actor.attemptsTo(
					Enter.theValue(producto).into(INPUT_SEARCH).thenHit(Keys.ENTER)
				);
	}

	public static BuscarProducto conElNombre(String producto) {
		return instrumented(BuscarProducto.class, producto);
	}
}
