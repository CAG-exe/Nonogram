package Visual;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.ControladorPrincipal;

public class TablaBotones {
	private enum estadoBoton{NEGRO,BLANCO,EQUIS}
	private JPanel panelCasillas;
	public static JButton[][] casillas;
	private int tamanio;
	
	
	TablaBotones(JPanel panelCasillas, int tamanio){
		casillas = new JButton[tamanio][tamanio];
		this.panelCasillas = panelCasillas;
		this.tamanio = tamanio;
	}

	public JPanel generarCasillas() {
		for(int i = 0; i<this.tamanio ; i++) {
			for(int j = 0; j<this.tamanio ; j++) {
				JButton casilla = new JButton();
				casilla.setBackground(Color.white);
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				
				accionesDeClicACasillas(casilla, i ,j);
				
				this.casillas[i][j] = casilla;
				this.panelCasillas.add(casilla);
			}
		}
		return this.panelCasillas;
	}
	
	
	private static void accionesDeClicACasillas(JButton casilla,int i,int j) {
    	casilla.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                if (NonogramWindow.botonesGrillaHabilitados()) { 
	                	if(e.getButton() == MouseEvent.BUTTON1) {//Click izquierdo
		                    if (casilla.getBackground().equals(Color.white) && casilla.getText() != "X") {
		                        casilla.setBackground(Color.black);
		                        NonogramWindow.sendInfoMarcarCasilla(i,j);
		                        casilla.setText("");
		                    } else if (casilla.getBackground().equals(Color.black)) {
		                    	NonogramWindow.sendInfoDesmarcarCasilla(i,j);
		                        casilla.setBackground(Color.white);
		                        casilla.setText("");
		                    }
	                	} 
	                	 else if (e.getButton() == MouseEvent.BUTTON3) { //Click derecho
	 	                    if (casilla.getText().equals("X")) {
	 	                    	NonogramWindow.sendInfoDesmarcarCasilla(i,j);
	 	                        casilla.setText("");
	 	                        casilla.setBackground(Color.white);
	 	                    } else {
	 	                    	NonogramWindow.sendInfoDesmarcarCasilla(i,j);
	 	                        casilla.setText("X");
	 	                        casilla.setForeground(Color.blue);
	 	                        casilla.setBackground(Color.white);
	 	                        casilla.setFont(new Font("Arial", Font.BOLD, 24));
	 	                    }
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
	
	public void actualizarCasilla(JButton casilla, int estado) {
		
	}
	
	
	public static JButton[][] getCasillas() {
		
		return casillas;
	}
	
}
