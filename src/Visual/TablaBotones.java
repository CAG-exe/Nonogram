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
	private JPanel panelCasillas;
	public static JButton[][] casillas;
	private int tamanio;
	private static ControladorPrincipal controladorPrincipal;
	private static Color colorDeCasillaSelecionada = Color.black;
	private static Color colorDeCasilla = Color.white;
	private static Color colorDeCasillaTachada = Color.white;
	
	
	TablaBotones(JPanel panelCasillas, int tamanio, ControladorPrincipal controladorPrincipal){
		this.controladorPrincipal  = controladorPrincipal;
		casillas = new JButton[tamanio][tamanio];
		this.panelCasillas = panelCasillas;
		this.tamanio = tamanio;
	}

	public JPanel generarCasillas() {
		for(int fila = 0; fila<this.tamanio ; fila++) {
			for(int columna = 0; columna<this.tamanio ; columna++) {
				JButton casilla = new JButton();
				casilla.setBackground(Color.white);
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				
				accionesDeClicACasillas(casilla, fila ,columna);
				
				this.casillas[fila][columna] = casilla;
				this.panelCasillas.add(casilla);
			}
		}
		return this.panelCasillas;
	}
	
	
	private static void accionesDeClicACasillas(JButton casilla,int fila,int columna) {
    	casilla.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
	               controladorPrincipal.actualizarEstadoDeLaCasilla(e, fila, columna);
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
	
	public static void marcarLaCasillaVisual(int fila, int columna) {
		actualizarCasilla(fila, columna, Color.black, "");
	}
	
	public static void desmarcarLaCasillaVisual(int fila, int columna) {
		actualizarCasilla(fila, columna, Color.white, "");
	}
	
	public static void tacharLaCasillaVisual(int fila, int columna) {
		actualizarCasilla(fila, columna, Color.white, "X");
	}
	
	public static void actualizarCasilla(int i, int j, Color color, String text) {
		JButton casilla = casillas[i][j];
		casilla.setForeground(Color.blue);
		casilla.setFont(new Font("Arial", Font.BOLD, 24));
		casilla.setText(text);
		casilla.setBackground(color);
	}
	
	public static boolean esCasillaSeleccionada(int fila, int columna) {
		JButton casilla = casillas[fila][columna];
		return casilla.getBackground().equals(colorDeCasillaSelecionada);
	}
	
	
	public static boolean esCasillaTachada(int fila, int columna) {
		JButton casilla = casillas[fila][columna];
		return casilla.getText().equals("X");
	}
	
	public static JButton[][] getCasillas() {
		return casillas;
	}
	
}
