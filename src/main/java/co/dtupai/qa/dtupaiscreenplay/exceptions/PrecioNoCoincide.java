package co.dtupai.qa.dtupaiscreenplay.exceptions;

public class PrecioNoCoincide extends AssertionError{
	public static final String PRECIO_NO_COINCIDE ="El precio del producto no coincide con el valor esperado";
	
	public PrecioNoCoincide(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
