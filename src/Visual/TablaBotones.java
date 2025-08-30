package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TablaBotones {
	private enum estadoBoton{NEGRO,BLANCO,EQUIS}

	public static JPanel generarCasillas(JPanel panelCasillas, int tamanio) {
		JButton[][] casillas = new JButton[tamanio][tamanio];
		for(int i = 0; i<tamanio ; i++) {
			for(int j = 0; j<tamanio ; j++) {
				JButton casilla = new JButton();
				casilla.setBackground(Color.white);
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				
				accionesDeClicACasillas(casilla);
				
				casillas[i][j] = casilla;
				panelCasillas.add(casilla);
			}
		}
		return panelCasillas;
	};
	
	
	private static void accionesDeClicACasillas(JButton casilla) {
    	casilla.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) { //Click izquierdo
                    if (casilla.getBackground().equals(Color.white) && casilla.getText() != "X") {
                        casilla.setBackground(Color.black);
                        casilla.setText("");
                    } else if (casilla.getBackground().equals(Color.black)) {
                        casilla.setBackground(Color.white);
                        casilla.setText("");
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) { //Click derecho
                    if (casilla.getText().equals("X")) {
                        casilla.setText("");
                        casilla.setBackground(Color.white);
                    } else {
                        casilla.setText("X");
                        casilla.setForeground(Color.blue);
                        casilla.setBackground(Color.white);
                        casilla.setFont(new Font("Arial", Font.BOLD, 24));
                    }
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
}
