package co.dtupai.qa.dtupaiscreenplay.stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.dtupai.qa.dtupaiscreenplay.exceptions.PrecioNoCoincide;
import co.dtupai.qa.dtupaiscreenplay.models.Productos;
import co.dtupai.qa.dtupaiscreenplay.questions.ProductoEnElCarrito;
import co.dtupai.qa.dtupaiscreenplay.task.AgregarProductoAlCarrito;
import co.dtupai.qa.dtupaiscreenplay.task.SeleccionarProducto;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiDetailProductPage;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiShoppingCartPage;
import co.dtupai.qa.dtupaiscreenplay.utils.Highlight;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.containsString;

public class AñadirAlCarritoStepsDefinitions {
	
	@Managed(driver = "chrome", uniqueSession=true)
	private WebDriver hisBrowser;
	private Actor daniel = Actor.named("Daniel");
	private DtupaiResultPage dtupaiResultPage ;
	private DtupaiDetailProductPage dtupaiDetailProductPage; 
	private DtupaiShoppingCartPage dtupaiShoppingCartPage;
	private Highlight hl ;
	@Before
	public void actorCanBrowseTheWeb() {
		daniel.can(BrowseTheWeb.with(hisBrowser));
		hl = new Highlight(hisBrowser);
	}
	
	@Given("^Daniel selecciono el producto con la posicion \"([^\"]*)\" que desea comprar$")
	public void danielSeleccionoElProductoConLaPosicionQueDeseaComprar(int posicionProducto) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		daniel.wasAbleTo(Open.browserOn(dtupaiResultPage),
				
					SeleccionarProducto.enLaPosicion(posicionProducto)
				);
	}

	@When("^el agrega el producto al carrito con las caracteristicas$")
	public void danielAgregaElProductoAlCarritoConLasCaracteristicas(List<Productos> productos) throws Exception {
		hl.highlightTarget(DtupaiDetailProductPage.INPUT_QUANTITY);
		hl.highlightTarget(DtupaiDetailProductPage.ADD_BUTTON);
		daniel.attemptsTo(AgregarProductoAlCarrito.conLasCaracteristicas(productos.get(0)));
		hl.highlightTarget(DtupaiShoppingCartPage.TEXT_PRICE);
	}

	@Then("^el verifica que el precio \"([^\"]*)\" corresponde al del carrito de compras$")
	public void danielVerificaQueElPrecioCorrespondeAlDelCarritoDeCompras(String precio) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		daniel.should(seeThat(ProductoEnElCarrito.conPrecio(), containsString(precio)).orComplainWith(PrecioNoCoincide.class, PrecioNoCoincide.PRECIO_NO_COINCIDE));
	}
}
