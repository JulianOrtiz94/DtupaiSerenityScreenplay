package co.dtupai.qa.dtupaiscreenplay.stepsdefinitions;

import org.openqa.selenium.WebDriver;

import co.dtupai.qa.dtupaiscreenplay.exceptions.ProductoNoCoincide;
import co.dtupai.qa.dtupaiscreenplay.questions.ElementoSeleccionado;
import co.dtupai.qa.dtupaiscreenplay.task.SeleccionarProducto;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiHomePage;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage;
import co.dtupai.qa.dtupaiscreenplay.utils.Highlight;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;
public class SeleccionarProductoStepDefinition {

	@Managed(uniqueSession = true , driver = "chrome")
	private WebDriver hisBrowser;
	private Actor daniel = Actor.named("Daniel");
	private DtupaiResultPage dtupaiResultPage ;
	private Highlight hl ;
	@Before
	public void actorCanBrowseTheWeb() {
		daniel.can(BrowseTheWeb.with(hisBrowser));
		hl = new Highlight(hisBrowser);
	}
	
	@Given("^Daniel realizo la busqueda del producto$")
	public void danielRealizoLaBusquedaDelProducto() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		daniel.wasAbleTo(Open.browserOn(dtupaiResultPage));
	}


	@When("^el seleccione el producto \"([^\"]*)\"$")
	public void danielSeleccioneElProducto(int posicion) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		hl.highlightElement((WebElementFacade) DtupaiResultPage.listResults.get(posicion));
		//hl.highlightTarget(DtupaiResultPage.PRODUCT_NAME);
		daniel.attemptsTo(SeleccionarProducto.enLaPosicion(posicion));
		hl.highlightTarget(DtupaiResultPage.PRODUCT_NAME);
	}

	@Then("^el verifica que el podructo seleccionado \"([^\"]*)\" sea el correcto$")
	public void danielVerificaQueElPodructoSeleccionadoSeaElCorrecto(String resultadoEsperado) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    daniel.should(seeThat(ElementoSeleccionado.resultado(), is(resultadoEsperado)).orComplainWith(ProductoNoCoincide.class, ProductoNoCoincide.PRODUCTO_NO_COINCIDE));
	}
}
