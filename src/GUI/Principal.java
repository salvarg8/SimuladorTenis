package GUI;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ENTIDADES.Jugador;
import ENTIDADES.Torneo;
import GESTORES.GestorInterface;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Principal extends JDialog {


	public static void main(String[] args) {
		try {		
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private JTextField txtNombreJ1;
	private JTextField txtNombreJ2;
	private JTextField txtNombreTorneo;
	private JSlider slJugador2;
	private JSlider slJugador1;
	private Jugador jugador1;
	private Jugador jugador2;
	private Torneo torneo;
	private JRadioButton rdbtn3sets;
	private JRadioButton rdbtn5sets;
	
	
	public Principal() {

		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 539, 489);
		getContentPane().setBackground(Color.WHITE);
		
		
		JLabel lblNewLabel = new JLabel("Simulaci\u00F3n Partido de Tenis");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 503, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jugador 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(182, 161, 158, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jugador 2");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(182, 268, 158, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 193, 82, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("prob de ganar:");
		lblNewLabel_3.setBounds(10, 224, 161, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("prob de ganar:");
		lblNewLabel_3_1.setBounds(0, 327, 98, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nombre:");
		lblNewLabel_2_1.setBounds(0, 296, 82, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		txtNombreJ1 = new JTextField();
		txtNombreJ1.setBackground(Color.WHITE);
		txtNombreJ1.setBounds(101, 190, 321, 20);
		getContentPane().add(txtNombreJ1);
		txtNombreJ1.setColumns(10);
		
		txtNombreJ2 = new JTextField();
		txtNombreJ2.setBackground(Color.WHITE);
		txtNombreJ2.setColumns(10);
		txtNombreJ2.setBounds(101, 293, 321, 20);
		getContentPane().add(txtNombreJ2);
		
		JButton btnIniciar = new JButton("Iniciar Partido");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// si están los datos cargados genero los objetos e inicio la simulación
				if (estanDatosCargados()) {
					generarDatos();
					inicializarSimulacion();
				}
				else
					GestorInterface.InformarError("ERROR! Debe cargar todos los datos");
			}
		});
		btnIniciar.setIcon(new ImageIcon("./src/IMAGENES/hombre-jugar-al-tenis.png"));
		btnIniciar.setBackground(Color.WHITE);
		btnIniciar.setBounds(182, 364, 158, 75);
		getContentPane().add(btnIniciar);
		
		JLabel lblNewLabel_1_2 = new JLabel("Torneo");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(182, 42, 158, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nombre:");
		lblNewLabel_2_2.setBounds(10, 66, 82, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		txtNombreTorneo = new JTextField();
		txtNombreTorneo.setColumns(10);
		txtNombreTorneo.setBackground(Color.WHITE);
		txtNombreTorneo.setBounds(101, 63, 321, 20);
		getContentPane().add(txtNombreTorneo);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Cant Sets:");
		lblNewLabel_2_2_1.setBounds(10, 97, 82, 14);
		getContentPane().add(lblNewLabel_2_2_1);
		
		rdbtn3sets = new JRadioButton("3 Sets");
		rdbtn3sets.setSelected(true);
		rdbtn3sets.setBackground(Color.WHITE);
		rdbtn3sets.setBounds(102, 90, 153, 23);
		getContentPane().add(rdbtn3sets);
		
		rdbtn5sets = new JRadioButton("5 Sets");
		rdbtn5sets.setBackground(Color.WHITE);
		rdbtn5sets.setBounds(102, 116, 166, 23);
		getContentPane().add(rdbtn5sets);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 503, 106);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 146, 503, 95);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 252, 503, 95);
		getContentPane().add(separator_2);
		
		slJugador1 = new JSlider();
		slJugador1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slJugador2.setValue(100-slJugador1.getValue());

			}
		});
	
		slJugador1.setBackground(Color.WHITE);
		slJugador1.setBounds(101, 218, 321, 20);
		getContentPane().add(slJugador1);
		
		slJugador2 = new JSlider();
		slJugador2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slJugador1.setValue(100-slJugador2.getValue());
			}
		});
		slJugador2.setBackground(Color.WHITE);
		slJugador2.setForeground(Color.WHITE);
		slJugador2.setBounds(101, 321, 321, 20);
		getContentPane().add(slJugador2);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtn5sets);
		grupo.add(rdbtn3sets);
		

	}


	protected boolean estanDatosCargados() {
		if(txtNombreTorneo.getText().isEmpty())
			return false;
		if (txtNombreJ1.getText().isEmpty())
			return false;
		if (txtNombreJ2.getText().isEmpty())
			return false;
		return true;
	}


	protected void inicializarSimulacion() {
		
		Simulacion simulacion = new Simulacion(jugador1, jugador2, torneo);
		simulacion.show();
		
	}


	private void generarDatos() {
		// Creo Jugador 1 
		jugador1 = new Jugador();
		jugador1.setNombre(txtNombreJ1.getText());
		jugador1.setProbabilidad(slJugador1.getValue());
	
		// creo jugador 2
		jugador2 = new Jugador();
		jugador2.setNombre(txtNombreJ2.getText());
		jugador2.setProbabilidad(slJugador2.getValue());
		
		// Creo Torneo
		torneo = new Torneo();
		torneo.setNombre(txtNombreTorneo.getText());
		if(rdbtn3sets.isSelected())
			torneo.setCantidadSets(3);
		else
			torneo.setCantidadSets(5);
		
	}
}
