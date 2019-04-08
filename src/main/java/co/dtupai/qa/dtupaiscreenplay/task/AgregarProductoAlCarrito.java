package co.dtupai.qa.dtupaiscreenplay.task;

import co.dtupai.qa.dtupaiscreenplay.models.Productos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.listSizes;
import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.listColors;
import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.INPUT_QUANTITY;
import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.ADD_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

public class AgregarProductoAlCarrito implements Task {

	public int posicionTalla;
	public int posicionColor;
	public String cantidad;

	public AgregarProductoAlCarrito(Productos productos) {
		super();
		this.posicionTalla = productos.getPosicionTalla();
		this.posicionColor = productos.getPosicionColor();
		this.cantidad = Integer.toString(productos.getCantidad());
	}

	@Step("{0} selecciona las caracteristicas del producto ")
	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(
				Click.on(listSizes.get(posicionTalla)),
				Click.on(listColors.get(posicionColor)),
				Enter.theValue(cantidad).into(INPUT_QUANTITY).thenHit(Keys.ENTER),
				Click.on(ADD_BUTTON)
			);
	}

	public static AgregarProductoAlCarrito conLasCaracteristicas(Productos productos) {
		// TODO Auto-generated method stub
		return instrumented(AgregarProductoAlCarrito.class, productos);
	}

}
