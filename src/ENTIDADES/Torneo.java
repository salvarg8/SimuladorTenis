package ENTIDADES;

public class Torneo {
	private String nombre;
	private int cantidadSets;


	//constructores
	
	public Torneo(String nombre, int cantidadSets) {
		this.nombre = nombre;
		this.cantidadSets = cantidadSets;
	}
	
	public Torneo() {
		
	}
	
	//getters and setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		
	public int getCantidadSets() {
		return this.cantidadSets;
	}
	
	public void setCantidadSets(int cantidadSets) {
		this.cantidadSets = cantidadSets;
	}
	
	
	
}
