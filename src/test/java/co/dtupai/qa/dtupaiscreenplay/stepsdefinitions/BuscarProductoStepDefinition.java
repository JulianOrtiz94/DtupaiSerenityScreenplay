package co.dtupai.qa.dtupaiscreenplay.stepsdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.dtupai.qa.dtupaiscreenplay.exceptions.ProductoNoEncontrado;
import co.dtupai.qa.dtupaiscreenplay.models.Productos;
import co.dtupai.qa.dtupaiscreenplay.questions.ResultadoBusqueda;
import co.dtupai.qa.dtupaiscreenplay.task.BuscarProducto;
import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;

public class BuscarProductoStepDefinition {

	@Managed(driver = "chrome", uniqueSession=true)

	private WebDriver hisBrowser;
	private Actor daniel = Actor.named("Daniel");
	private DtupaiHomePage dtupaiHomePage;

	@Before
	public void actorCanBrowseTheWeb() {
		daniel.can(BrowseTheWeb.with(hisBrowser));
	}

	@Given("^Daniel esta en la pagina principal de Dtupai$")
	public void danielEstaEnLaPaginaPrincipalDeDtupai() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		daniel.wasAbleTo(Open.browserOn(dtupaiHomePage));
	}
	
	@When("^el busca un producto \"([^\"]*)\"$")
	public void danielBuscaUnProducto(String producto) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		daniel.attemptsTo(BuscarProducto.conElNombre(producto));
	}


	@Then("^el verifica que el podructo \"([^\"]*)\" este en los resultados$")
	public void danielVerificaQueElPodructoEsteEnLosResultados(String resultadoEsperado) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		daniel.should(seeThat(ResultadoBusqueda.busqueda(), is(resultadoEsperado)).orComplainWith(ProductoNoEncontrado.class, ProductoNoEncontrado.PRODUCTO_NO_ENCONTRADO));
	}

}
