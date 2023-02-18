package ENTIDADES;

import java.util.ArrayList;

public class Partido {

	private Jugador jugador1;
	private Jugador jugador2;
	private ArrayList<Set> sets;
	private int contadorSetsJ1;
	private int contadorSetsJ2;

	public Partido() {
		sets = new ArrayList<Set>();
		contadorSetsJ1 = 0;
		contadorSetsJ2 = 0;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public ArrayList<Set> getSets() {
		return sets;
	}

	public void setSets(ArrayList<Set> sets) {
		this.sets = sets;
	}

	public void addSet(Set set) {
		this.sets.add(set);
	}

	public int getContadorSetsJ1() {
		return contadorSetsJ1;
	}

	public void setContadorSetsJ1(int contadorSetsJ1) {
		this.contadorSetsJ1 = contadorSetsJ1;
	}

	public int getContadorSetsJ2() {
		return contadorSetsJ2;
	}

	public void setContadorSetsJ2(int contadorSetsJ2) {
		this.contadorSetsJ2 = contadorSetsJ2;
	}

	public void incremetnarContadorSetsJ1() {
		contadorSetsJ1++;
	}

	public void incrementarContadorSetsJ2() {
		contadorSetsJ2++;
	}

	public void resetearContadores() {
		contadorSetsJ1 = 0;
		contadorSetsJ2 = 0;
	}

}
