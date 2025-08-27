package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Tutorial extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Tutorial() {
		setBackground(new Color(137, 108, 108));
		setLayout(null);
		JButton BotonVolverMenu = new JButton("<=Atras");
		BotonVolverMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Interfaz.volverAlMenu();;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				BotonVolverMenu.setBackground(new Color(245, 250, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BotonVolverMenu.setBackground(new Color(238, 230, 202));
			}
		});
		BotonVolverMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		BotonVolverMenu.setBounds(613, 511, 118, 38);
		BotonVolverMenu.setBackground(new Color(238, 230, 202));
		add(BotonVolverMenu);
		
	
		JLabel lblNewLabel = new JLabel("");
		ImageIcon ayuda = new ImageIcon(getClass().getResource("/media/ayuda.png"));
		lblNewLabel.setIcon(ayuda);
		lblNewLabel.setBounds(62, 448, 347, 135);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Idea  del juego ganado");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(62, 402, 208, 22);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("El Objetivo es encontrar y marcar todas las casillas negras");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(53, 353, 437, 19);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("– En las pistas, cada número indica una cadena de celdas negras consecutivas.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(48, 72, 511, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("- Entre dos cadenas de celdas negras debe existir al menos una celda libre, en el ejemplo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(53, 119, 576, 16);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("las marcadas con X.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(63, 147, 129, 16);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		ImageIcon ayuda2 = new ImageIcon(getClass().getResource("/media/ayuda2.png"));
		lblNewLabel_6.setIcon(ayuda2);
		lblNewLabel_6.setBounds(595, 68, 132, 20);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("-Al costado de cada fila en la grilla, aparecen los largos de las cadenas de casillas en");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(53, 187, 548, 16);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("negro para esa fila.");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(62, 214, 126, 16);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("– Sobre cada columna en la grilla, aparecen los largos de las cadenas de casillas en negro");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(53, 256, 579, 16);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("para esa columna.");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(62, 283, 118, 16);
		add(lblNewLabel_10);
	}

}