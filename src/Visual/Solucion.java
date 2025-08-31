package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Solucion extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Boolean[][] matriz;
	private int tamanio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Boolean[][] matriz = new Boolean[5][5];
			Solucion dialog = new Solucion(matriz, 5);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Solucion(Boolean[][] matriz, int tamanio) {
		this.tamanio = tamanio;
		this.matriz = matriz;
		setBounds(600, 400, 550, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBackground(new Color(137, 108, 108));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			add(panel, BorderLayout.CENTER);
			panel.setBackground(new Color(137, 108, 108));
			panel.setLayout(null);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(137, 108, 108));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("OK");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("OK");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void generarCasillas(JPanel panel) {
		JPanel[][] casillas = new JPanel[tamanio][tamanio];
		for(int fila = 0; fila<tamanio ; fila++) {
			for(int columna = 0; columna<tamanio ; columna++) {
				JPanel casilla = new JPanel();
				casilla.setBorder(BorderFactory.createLineBorder(Color.gray));
				if(this.matriz[fila][columna]) {
					casilla.setBackground(Color.black);
				} else {
					casilla.setBackground(Color.white);
				}
				
				casillas[fila][columna] = casilla;
				panel.add(casilla);
			}
		}
	};

}
