package GESTORES;

import ENTIDADES.Game;

public class GestorSimulacion {

	
	// método que dependidendo de la probabilidad me devuelve el numero del jugador que gana, si el resultado es == a la probabilidad vuelvo a llamar al método por si queda 50/50 
	public static int obtenerGanador(int probabilidad) {
		int resultado = (int) (Math.floor(Math.random() * 100));

		if (resultado < probabilidad) {
			return 1;
		} else if (resultado > probabilidad) {
			return 2;
		} else {
			return obtenerGanador(probabilidad);
		}

	}

	// obtengo el ganador del punto y dependiendo del estado es el estado que le asigno al contador de los jugadores
	// adjunto imagen de la máquina de estados
	public static void jugarPunto(int probabilidad, Game game) {
		int ganadorPunto = obtenerGanador(probabilidad);
		if (ganadorPunto == 1) {
			// va del estado 0 al 2
			if (game.getContadorPuntosJ1() < 3)
				game.incrementarContadorPuntosJ1();
			// a partir del estado 3
			else {
				// si jugador1 gana game
				if (game.getContadorPuntosJ1() == 5
						|| (game.getContadorPuntosJ1() == 3 && game.getContadorPuntosJ2() < 3))
					game.setContadorPuntosJ1(7);
				// jugador1 pasa a ventaja
				else if (game.getContadorPuntosJ1() == 4
						|| (game.getContadorPuntosJ1() == 3 && game.getContadorPuntosJ2() == 3)) {
					game.setContadorPuntosJ1(5);
					game.setContadorPuntosJ2(6);
				}
				// jugador1 pasa a Iguales
				else {
					game.setContadorPuntosJ1(4);
					game.setContadorPuntosJ2(4);
				}
			}
		} else {
			// va del estado 0 al 2
			if (game.getContadorPuntosJ2() < 3)
				game.incrementarContadorPuntosJ2();
			// a partir del estado 3
			else {
				// si jugador2 gana game
				if (game.getContadorPuntosJ2() == 5
						|| (game.getContadorPuntosJ2() == 3 && game.getContadorPuntosJ1() < 3))
					game.setContadorPuntosJ2(7);
				// jugador2 pasa a ventaja
				else if (game.getContadorPuntosJ2() == 4
						|| (game.getContadorPuntosJ2() == 3 && game.getContadorPuntosJ1() == 3)) {
					game.setContadorPuntosJ1(5);
					game.setContadorPuntosJ2(6);
				}
				// jugador2 pasa a Iguales
				else {
					game.setContadorPuntosJ2(4);
					game.setContadorPuntosJ1(4);
				}
			}
		}
	}

}
