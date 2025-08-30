package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Menu extends JPanel {
	
	protected JButton ComoJugarButton;
	private JRadioButton cincoXcincoRadioButton;
	private JRadioButton diezXdiezRadioButton;
	private JRadioButton quinceXquinceRadioButton;
	private JRadioButton veinteXveinteRadioButton;
	private Color BotonBase;
	private Color BotonHover;
	private Color ColorRadioButton;
	private int tamanio;
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Menu() {
		setBackground(new Color(137, 108, 108));
		setLayout(null);
		BotonBase = new Color(238, 230, 202);
		BotonHover = new Color(245, 250, 225);
		ColorRadioButton = new Color(229, 190, 181);
		tamanio=5;
		
		JButton JugarButton = new JButton("Jugar!");
		JugarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JugarButton.setBackground(BotonHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				JugarButton.setBackground(BotonBase);
			}
		});
		
		JugarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Interfaz.abrirJuego(tamanio);
			}
		});
		
		JugarButton.setBackground(BotonBase);
		JugarButton.setBounds(501, 268, 150, 77);
		JugarButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(JugarButton);
		
		ComoJugarButton = new JButton("!!Como Jugar!!");
		ComoJugarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ComoJugarButton.setBackground(BotonHover);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ComoJugarButton.setBackground(BotonBase);
			}
		});
		
		ComoJugarButton.setBackground(BotonBase);
		ComoJugarButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		ComoJugarButton.setBounds(501, 388, 150, 77);
		add(ComoJugarButton);

		JLabel LogoLabel = new JLabel("");
		ImageIcon Logo = new ImageIcon(getClass().getResource("/media/nonograms-logo.png"));
		LogoLabel.setIcon(Logo);
		LogoLabel.setBounds(39, 85, 700, 116);
		add(LogoLabel);
		
		cincoXcincoRadioButton = new JRadioButton("5x5");
		cincoXcincoRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("el tamaño es 5");
				tamanio=5;
			}
		});
		recolorearBoton(cincoXcincoRadioButton);
		cincoXcincoRadioButton.setBounds(117, 261, 150, 37);
		add(cincoXcincoRadioButton);
		
		diezXdiezRadioButton = new JRadioButton("10x10");
		diezXdiezRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("el tamaño es 10");
				tamanio=10;
			}
		});
		recolorearBoton(diezXdiezRadioButton);
		diezXdiezRadioButton.setBounds(117, 318, 150, 37);
		add(diezXdiezRadioButton);
		
		quinceXquinceRadioButton = new JRadioButton("15x15");
		quinceXquinceRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("el tamaño es 15");
				tamanio=15;
			}
		});
		recolorearBoton(quinceXquinceRadioButton);
		quinceXquinceRadioButton.setBounds(117, 374, 150, 37);
		add(quinceXquinceRadioButton);
		
		veinteXveinteRadioButton = new JRadioButton("20x20");
		veinteXveinteRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("el tamaño es 20");
				tamanio=20
						;
			}
		});
		recolorearBoton(veinteXveinteRadioButton);
		veinteXveinteRadioButton.setBounds(117, 428, 150, 37);
		add(veinteXveinteRadioButton);
		
        // Crea el ButtonGroup
        ButtonGroup grupoOpciones = new ButtonGroup();

        // Agrega los JRadioButton al ButtonGroup
        grupoOpciones.add(cincoXcincoRadioButton);
        grupoOpciones.add(diezXdiezRadioButton);
        grupoOpciones.add(quinceXquinceRadioButton);
        grupoOpciones.add(veinteXveinteRadioButton);
        
        cincoXcincoRadioButton.setSelected(true);
        
        JLabel Info_extra = new JLabel("Para seleccionar el nivel correctamente darle doble click");
        Info_extra.setForeground(new Color(75, 35, 65));
        Info_extra.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
        Info_extra.setBounds(62, 506, 444, 48);
        add(Info_extra);
        
        
	}

	private void recolorearBoton(JRadioButton boton) {
		boton.setBackground(ColorRadioButton);
	}	
}
