package ENTIDADES;

public class Game {
	private int contadorPuntosJ1;
	private int contadorPuntosJ2;
	
	
	public Game() {
		contadorPuntosJ1 = 0;
		contadorPuntosJ2 = 0;
	}
	
	public int getContadorPuntosJ1() {
		return contadorPuntosJ1;
	}
	public void setContadorPuntosJ1(int contadorPuntosJ1) {
		this.contadorPuntosJ1 = contadorPuntosJ1;
	}
	public int getContadorPuntosJ2() {
		return contadorPuntosJ2;
	}
	public void setContadorPuntosJ2(int contadorPuntosJ2) {
		this.contadorPuntosJ2 = contadorPuntosJ2;
	}

	public void incrementarContadorPuntosJ1() {
		contadorPuntosJ1 ++;	
	}
	public void incrementarContadorPuntosJ2() {
		contadorPuntosJ2 ++;	
	}

	@Override
	public String toString() {
		return "Game [contadorPuntosJ1=" + contadorPuntosJ1 + ", contadorPuntosJ2=" + contadorPuntosJ2 + "]";
	}

	public boolean hayGanador() {
		if(contadorPuntosJ1 == 7 || contadorPuntosJ2 == 7)
			return true;
		return false;
	}
	
	
}
