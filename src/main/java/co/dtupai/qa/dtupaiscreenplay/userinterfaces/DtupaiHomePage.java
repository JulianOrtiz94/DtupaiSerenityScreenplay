package co.dtupai.qa.dtupaiscreenplay.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.dtupai.co/")
public class DtupaiHomePage extends PageObject  {
	private static final String inputSearchXpath = "//input[@value='Buscar']";
	public static final Target INPUT_SEARCH = Target.the("Barra de busqueda")    		
            .locatedBy(inputSearchXpath);
}
