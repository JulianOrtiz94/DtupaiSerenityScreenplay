package co.dtupai.qa.dtupaiscreenplay.questions;

import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResultadoBusqueda implements Question<String> {
	
	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return DtupaiResultPage.TEXT_SEARCH.resolveFor(actor).waitUntilVisible().getText();
	}
	
	public static ResultadoBusqueda busqueda() {
		return new ResultadoBusqueda();
	}

}
