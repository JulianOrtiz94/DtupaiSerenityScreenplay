package co.dtupai.qa.dtupaiscreenplay.task;

import co.dtupai.qa.dtupaiscreenplay.models.Productos;
import co.dtupai.qa.dtupaiscreenplay.utils.ConexionInternet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.listSizes;
import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.listColors;
import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.INPUT_QUANTITY;
import static co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage.ADD_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

public class AgregarProductoAlCarrito implements Task {

	public Productos productos;
	public int posicionTalla;
	public int posicionColor;
	public String cantidad;

	public AgregarProductoAlCarrito(Productos productos) {
		super();
		this.productos = productos;
		this.posicionTalla = productos.getPosicionTalla();
		this.posicionColor = productos.getPosicionColor();
		this.cantidad = Integer.toString(productos.getCantidad());
	}

	@Step("{0} selecciona las caracteristicas del producto ")
	@Override
	public <T extends Actor> void performAs(T actor) {
		ConexionInternet.internetConnection();
		actor.attemptsTo(
				Check.whether(listSizes.get(posicionTalla).waitUntilVisible().isVisible())
				.andIfSo(Click.on(listSizes.get(posicionTalla))),
				
				
				Check.whether(listColors.get(posicionColor).waitUntilVisible().isVisible())
				.andIfSo(Click.on(listColors.get(posicionColor))),
				
				Check.whether(INPUT_QUANTITY.resolveFor(actor).waitUntilVisible().isEnabled())
					.andIfSo(Clear.field(INPUT_QUANTITY)),
					
				Enter.theValue(cantidad).into(INPUT_QUANTITY),
				
				Check.whether(ADD_BUTTON.resolveFor(actor).waitUntilEnabled().isEnabled()).andIfSo(Click.on(ADD_BUTTON))

			);
	}

	/**
	 * Retorna la clase AgregarProductoAlCarrito para ser inicializada en el tiempo de ejecución
	 * El parametro unicamente puede ser de tipo Productos
	 * @param productos el producto seleccionado al momento de ejecutar el metodo
	 * @return Retorna la inicialización de la clase AgregarProductoAlCarrito en tiempo de ejecución, enviandole el parametro productos
	 */
	public static AgregarProductoAlCarrito conLasCaracteristicas(Productos productos) {
		// TODO Auto-generated method stub
		return instrumented(AgregarProductoAlCarrito.class, productos);
	}

}
