package co.dtupai.qa.dtupaiscreenplay.questions;

import co.dtupai.qa.dtupaiscreenplay.userinterfaces.DtupaiResultPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElementoSeleccionado implements Question<String> {
	
	@Override
	public String answeredBy(Actor actor) {
		return DtupaiResultPage.PRODUCT_NAME.resolveFor(actor).waitUntilVisible().getText().toString();
	}

	public static ElementoSeleccionado resultado() {
		return new ElementoSeleccionado();
	}


}
