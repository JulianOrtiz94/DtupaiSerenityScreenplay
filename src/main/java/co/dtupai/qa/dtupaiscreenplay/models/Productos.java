package co.dtupai.qa.dtupaiscreenplay.models;

public class Productos {
	private int posicionTalla;
	private int posicionColor;
	private int cantidad;
	
	public Productos(int posicionTalla, int posicionColor, int cantidad) {
		super();
		this.posicionTalla = posicionTalla;
		this.posicionColor = posicionColor;
		this.cantidad = cantidad;
	}

	public int getPosicionTalla() {
		return posicionTalla;
	}

	public void setPosicionTalla(int posicionTalla) {
		this.posicionTalla = posicionTalla;
	}

	public int getPosicionColor() {
		return posicionColor;
	}

	public void setPosicionColor(int posicionColor) {
		this.posicionColor = posicionColor;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}
