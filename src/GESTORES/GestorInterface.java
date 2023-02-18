package GESTORES;

import javax.swing.JOptionPane;

public class GestorInterface {

	public static void InformarError(String mensaje) {
		
		JOptionPane.showMessageDialog(null, mensaje, "Error",JOptionPane.WARNING_MESSAGE);
	}

}
