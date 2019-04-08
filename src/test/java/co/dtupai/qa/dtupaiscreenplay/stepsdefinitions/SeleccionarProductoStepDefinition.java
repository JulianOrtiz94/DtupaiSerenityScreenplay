package co.dtupai.qa.dtupaiscreenplay.stepsdefinitions;

import org.openqa.selenium.WebDriver;

import co.dtupai.qa.dtupaiscreenplay.exceptions.ProductoNoCoincide;
import co.dtupai.qa.dtupaiscreenplay.exceptions.ProductoNoEncontrado;
import co.dtupai.qa.dtupaiscreenplay.questions.ElementoSeleccionado;
import co.dtupai.qa.dtupaiscreenplay.task.SeleccionarProducto;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;
public class SeleccionarProductoStepDefinition {

	@Managed(driver = "chrome", uniqueSession=true)
	private WebDriver hisBrowser;
	private Actor daniel = Actor.named("Daniel");
	private DtupaiResultPage dtupaiResultPage ;
	
	@Before
	public void actorCanBrowseTheWeb() {
		daniel.can(BrowseTheWeb.with(hisBrowser));
	}
	
	@Given("^Daniel realizo la busqueda del producto$")
	public void danielRealizoLaBusquedaDelProducto() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		daniel.wasAbleTo(Open.browserOn(dtupaiResultPage));
	}


	@When("^Daniel seleccione el producto \"([^\"]*)\"$")
	public void danielSeleccioneElProducto(int posicion) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		daniel.attemptsTo(SeleccionarProducto.enLaPosicion(posicion));
	}

	@Then("^Daniel verifica que el podructo seleccionado \"([^\"]*)\" sea el correcto$")
	public void danielVerificaQueElPodructoSeleccionadoSeaElCorrecto(String resultadoEsperado) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    daniel.should(seeThat(ElementoSeleccionado.resultado(), is(resultadoEsperado)).orComplainWith(ProductoNoCoincide.class, ProductoNoCoincide.PRODUCTO_NO_COINCIDE));
	}
}