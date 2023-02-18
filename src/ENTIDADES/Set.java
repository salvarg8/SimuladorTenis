package ENTIDADES;

import java.util.ArrayList;

public class Set {

	private ArrayList<Game> games;
	
	private int gamesJugador1;
	private int gamesJugador2;
	

	public Set() {
		games = new ArrayList<Game>();
		gamesJugador1 = 0;
		gamesJugador2 = 0;
	}

	public int getGamesJugador1() {
		return gamesJugador1;
	}

	public void setGamesJugador1(int gamesJugador1) {
		this.gamesJugador1 = gamesJugador1;
	}

	public int getGamesJugador2() {
		return gamesJugador2;
	}

	public void setGamesJugador2(int gamesJugador2) {
		this.gamesJugador2 = gamesJugador2;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	public void addGame(Game game) {
		this.games.add(game);
	}

	public void incremetarContador2() {
		gamesJugador2 ++;		
	}
	public void incrementarContador1() {
		gamesJugador1 ++;
	}
}
