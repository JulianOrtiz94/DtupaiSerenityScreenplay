package co.dtupai.qa.dtupaiscreenplay.interactions;

import co.dtupai.qa.dtupaiscreenplay.models.Productos;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class AgregarAlCarrito implements Interaction{
	public int posicionTalla;
	public int posicionColor;
	public String cantidad;
	public WebElementFacade size;
	public WebElementFacade color;
	
	public AgregarAlCarrito(Productos productos) {
		super();
		this.posicionTalla = productos.getPosicionTalla();
		this.posicionColor = productos.getPosicionColor();
		this.cantidad = Integer.toString(productos.getCantidad());
		size = DtupaiDetailProductPage.listSizes.get(posicionTalla);
		color = DtupaiDetailProductPage.listColors.get(posicionColor);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		size.waitUntilClickable().click();
		color.waitUntilClickable().click();
		DtupaiDetailProductPage.INPUT_QUANTITY.resolveFor(actor).clear();
		DtupaiDetailProductPage.INPUT_QUANTITY.resolveFor(actor).sendKeys(cantidad);
		DtupaiDetailProductPage.INPUT_QUANTITY.resolveFor(actor).submit();
		//DtupaiDetailProductPage.ADD_BUTTON.resolveFor(actor).waitUntilEnabled().waitUntilClickable().click();
		
	}
	
	public static AgregarAlCarrito seleccionarCaracteristicasDelProducto(Productos productos) {
		return instrumented(AgregarAlCarrito.class, productos);
	}

}
