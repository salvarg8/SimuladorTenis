package ENTIDADES;

public class Jugador {
	
	private String nombre;
	private int Probabilidad;
	
	
	// constructores
	
	public Jugador(String nombre, int probabilidad) {
		this.nombre = nombre;
		Probabilidad = probabilidad;
	}
	
	public Jugador() {
		
	}

	
	// getters and setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProbabilidad() {
		return Probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		Probabilidad = probabilidad;
	}

	// Otros Métodos
	
	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
	
	

}
