package co.dtupai.qa.dtupaiscreenplay.exceptions;

public class ProductoNoEncontrado extends AssertionError{
	public static final String PRODUCTO_NO_ENCONTRADO ="El producto no corresponde a la buscqueda";
	
	public ProductoNoEncontrado(String mensaje, Throwable causa) {
		// TODO Auto-generated constructor stub
		super(mensaje, causa);
	}
}
