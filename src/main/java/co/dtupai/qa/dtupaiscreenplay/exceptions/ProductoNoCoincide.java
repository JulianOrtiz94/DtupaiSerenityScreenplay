package co.dtupai.qa.dtupaiscreenplay.exceptions;

public class ProductoNoCoincide extends AssertionError{
	public static final String PRODUCTO_NO_COINCIDE ="El nombre del producto no coincide con el nombre esperado";
	
	public ProductoNoCoincide(String mensaje, Throwable causa) {
		// TODO Auto-generated constructor stub
		super(mensaje, causa);
	}
}
