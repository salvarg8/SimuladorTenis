package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ENTIDADES.Game;
import ENTIDADES.Jugador;
import ENTIDADES.Partido;
import ENTIDADES.Set;
import ENTIDADES.Torneo;
import GESTORES.GestorSimulacion;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Simulacion extends JFrame {

	private JPanel contentPane;
	private Partido partido;
	private String[] puntos = new String[] { "0", "15", "30", "40", "Iguales", "Ad", "Des", "W" };
	private Thread hilo;
	private JTable table;
	private boolean sacaJ1;
	private JLabel lblGanador;
	private JButton btnRevancha;
	private JLabel lblJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulacion frame = new Simulacion(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * @param torneo
	 * @param jugador1
	 */

	@SuppressWarnings("serial")
	public Simulacion(Jugador jugador1, Jugador jugador2, Torneo torneo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreTorneo = new JLabel("New label");
		lblNombreTorneo.setBackground(Color.WHITE);
		lblNombreTorneo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreTorneo.setBounds(10, 11, 551, 20);
		contentPane.add(lblNombreTorneo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 55, 551, 60);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		if (torneo.getCantidadSets() == 5) {
			table.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null, null, null },
							{ null, null, null, null, null, null, null, null }, },
					new String[] { "JUGADOR", "1 SET", "2 SET", "3 SET", "4 SET", "5 SET", "PUNTOS", "SAQUE" }) {
				Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class,
						Object.class, Object.class, Object.class, ImageIcon.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(45);
			table.getColumnModel().getColumn(1).setMaxWidth(45);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(45);
			table.getColumnModel().getColumn(2).setMaxWidth(45);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setPreferredWidth(45);
			table.getColumnModel().getColumn(3).setMaxWidth(45);
			table.getColumnModel().getColumn(4).setResizable(false);
			table.getColumnModel().getColumn(4).setPreferredWidth(45);
			table.getColumnModel().getColumn(4).setMaxWidth(45);
			table.getColumnModel().getColumn(5).setResizable(false);
			table.getColumnModel().getColumn(5).setPreferredWidth(45);
			table.getColumnModel().getColumn(5).setMaxWidth(45);
			table.getColumnModel().getColumn(6).setResizable(false);
			table.getColumnModel().getColumn(6).setPreferredWidth(55);
			table.getColumnModel().getColumn(6).setMaxWidth(55);
			table.getColumnModel().getColumn(7).setResizable(false);
			table.getColumnModel().getColumn(7).setPreferredWidth(45);
			table.getColumnModel().getColumn(7).setMaxWidth(45);
		} else {
			table.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null },
							{ null, null, null, null, null, null, null, null }, },
					new String[] { "JUGADOR", "1 SET", "2 SET", "3 SET", "PUNTOS", "SAQUE" }) {
				Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class,
						Object.class, ImageIcon.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(45);
			table.getColumnModel().getColumn(1).setMaxWidth(45);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(45);
			table.getColumnModel().getColumn(2).setMaxWidth(45);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(3).setPreferredWidth(45);
			table.getColumnModel().getColumn(3).setMaxWidth(45);
			table.getColumnModel().getColumn(4).setResizable(false);
			table.getColumnModel().getColumn(4).setPreferredWidth(55);
			table.getColumnModel().getColumn(4).setMaxWidth(55);
			table.getColumnModel().getColumn(5).setResizable(false);
			table.getColumnModel().getColumn(5).setPreferredWidth(45);
			table.getColumnModel().getColumn(5).setMaxWidth(45);
		}

		scrollPane.setViewportView(table);

		lblGanador = new JLabel();
		lblGanador.setBackground(Color.WHITE);
		lblGanador.setVisible(false);
		lblGanador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanador.setBounds(10, 154, 551, 48);
		contentPane.add(lblGanador);

		btnRevancha = new JButton("Jugar Revancha");
		btnRevancha.setPreferredSize(new Dimension(111, 26));
		btnRevancha.setVisible(false);
		btnRevancha.setIcon(new ImageIcon("./src/IMAGENES/red.png"));
		btnRevancha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGanador.setVisible(false);
				lblJugador.setVisible(true);
				btnRevancha.setVisible(false);
				cargarSets(torneo);
				partido.resetearContadores();
				iniciar();
			}
		});
		btnRevancha.setBackground(Color.WHITE);
		btnRevancha.setBounds(182, 213, 206, 37);
		contentPane.add(btnRevancha);

		lblNombreTorneo.setText(torneo.getNombre());
		
		lblJugador = new JLabel("");
		lblJugador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJugador.setBounds(457, 154, 104, 96);
		lblJugador.setIcon(new ImageIcon("./src/IMAGENES/jugador2.png"));
		contentPane.add(lblJugador);
		partido = new Partido();
		partido.setJugador1(jugador1);
		partido.setJugador2(jugador2);
		
		// SORTEO DE QUE JUGADOR EMPIEZA SACANDO
		sacaJ1 = (GestorSimulacion.obtenerGanador(50) == 1);

		cargarSets(torneo);

		iniciar();

	}

	// lleno el arrayList de sets que se van a jugar en el partido
	private void cargarSets(Torneo torneo) {
		partido.getSets().clear();
		for (int i = 0; i < torneo.getCantidadSets(); i++) {
			Set set = new Set();
			partido.addSet(set);
		}
	}

	private void iniciar() {
		// utilizo un hilo para poder realizar una pausa en el ciclo y que no se
		// muestren todos los resultados instantaneamente
		hilo = new Thread(new Runnable() {
			public void run() {
				jugarPartido();
			}
		});
		hilo.start();
	}

	// mientras no haya un ganador se juega el partido
	protected void jugarPartido() {
		int numSet = 0;

		while (!hayGanador()) {

			jugarPunto(numSet);

			if (terminoSet(numSet)) {
				if (partido.getSets().get(numSet).getGamesJugador1() == 7
						|| (partido.getSets().get(numSet).getGamesJugador1() == 6
								&& partido.getSets().get(numSet).getGamesJugador2() != 6))
					partido.incremetnarContadorSetsJ1();
				else
					partido.incrementarContadorSetsJ2();
				numSet++;

			}
		}
		// cuando hay un ganador se muestra el ganador y se ofrece jugar una revancha
		if (((partido.getContadorSetsJ1() > (partido.getSets().size()) / 2)))
			lblGanador.setText("GANADOR: " + partido.getJugador1().getNombre());
		else
			lblGanador.setText("GANADOR: " + partido.getJugador2().getNombre());
		lblGanador.setVisible(true);
		lblJugador.setVisible(false);
		btnRevancha.setVisible(true);
	}

	// verificamos si se terminó el set jugador
	private boolean terminoSet(int numSet) {
		if ((partido.getSets().get(numSet).getGamesJugador1() == 7
				|| (partido.getSets().get(numSet).getGamesJugador1() == 6
						&& partido.getSets().get(numSet).getGamesJugador2() < 5)
				|| partido.getSets().get(numSet).getGamesJugador2() == 7
				|| (partido.getSets().get(numSet).getGamesJugador2() == 6
						&& partido.getSets().get(numSet).getGamesJugador1() < 5)))
			return true;
		return false;
	}

	// verificamos si se acabó el partido
	private boolean hayGanador() {
		if ((partido.getContadorSetsJ1() > (partido.getSets().size()) / 2)
				|| partido.getContadorSetsJ2() > (partido.getSets().size()) / 2)
			return true;
		return false;
	}

	// inicializamos el game
	private void jugarPunto(int numSet) {
		Game game = new Game();
		boolean ganador = false;
		while (!ganador) {
			try {
				// hacemos una pausa de 750 mls
				hilo.sleep(750);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// obtenemos el ganador del punto del game
			GestorSimulacion.jugarPunto(partido.getJugador1().getProbabilidad(), game);
			mostrarPuntaje(game);
			if (game.hayGanador()) {
				// cambiamos el jugador que saca
				sacaJ1 = !sacaJ1;
				ganador = true;
				// seteamos el ganador del game
				if (game.getContadorPuntosJ1() == 7)
					partido.getSets().get(numSet).incrementarContador1();
				else
					partido.getSets().get(numSet).incremetarContador2();
			}
			mostrarPuntaje(game);

		}
	}

	// metodo que carga los puntajes en la Jtable

	private void mostrarPuntaje(Game game) {

		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] fila1;
		Object[] fila2;

		if (model.getColumnCount() == 8) {
			fila1 = new Object[8];
			fila2 = new Object[8];
		} else {
			fila1 = new Object[6];
			fila2 = new Object[6];
		}

		fila1[0] = partido.getJugador1().getNombre();
		fila2[0] = partido.getJugador2().getNombre();

		for (int i = 0; i < partido.getSets().size(); i++) {
			fila1[i + 1] = partido.getSets().get(i).getGamesJugador1();
			fila2[i + 1] = partido.getSets().get(i).getGamesJugador2();
		}

		if (model.getColumnCount() == 8) {
			fila1[6] = puntos[game.getContadorPuntosJ1()];
			fila2[6] = puntos[game.getContadorPuntosJ2()];

			if (sacaJ1) {
				fila1[7] = new ImageIcon("./src/IMAGENES/tenis.png");
				fila2[7] = null;
			} else {
				fila1[7] = null;
				fila2[7] = new ImageIcon("./src/IMAGENES/tenis.png");
			}
		} else {
			fila1[4] = puntos[game.getContadorPuntosJ1()];
			fila2[4] = puntos[game.getContadorPuntosJ2()];

			if (sacaJ1) {
				fila1[5] = new ImageIcon("./src/IMAGENES/tenis.png");
				fila2[5] = null;
			} else {
				fila1[5] = null;
				fila2[5] = new ImageIcon("./src/IMAGENES/tenis.png");
			}

		}
		model.addRow(fila1);
		model.addRow(fila2);
	}
}
