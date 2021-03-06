package co.dtupai.qa.dtupaiscreenplay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)   
@CucumberOptions( features= { 
		"src/test/resources/features/AñadirProductoAlCarrito.feature"
		},
        glue = { "co.dtupai.qa.dtupaiscreenplay.stepsdefinitions" },
        snippets =  SnippetType.CAMELCASE
        
        )  

public class BuscarProductoRunner {
}
