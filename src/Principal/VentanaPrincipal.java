package Principal;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * VentanaPrincipal sirve como contenedor para el panel de juego.
 * @author Blanca Erdieta
 */

public class VentanaPrincipal {
	//Sigo teniendo la ventana
	JFrame ventana;
	PanelJuego panelJuego;
	
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 50, 550, 800);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Método que inicializa todos los componentes de la ventana
	 */
	public void inicializarComponentes(){	
		//Definimos el layout:
		ventana.setLayout(new GridLayout(1,1));
		//PANEL JUEGO
		panelJuego = new PanelJuego();
		
		ventana.add(panelJuego);
	}
	
	/**
	 * Método que inicializa todos los listeners del programa.
	 */
	public void inicializarListeners(){
		
	}
		
	/**
	 * Método que realiza todas las llamadas necesarias para inicializar la ventana correctamente.
	 */
	public void inicializar(){
		ventana.setVisible(true);
		inicializarComponentes();	
		inicializarListeners();		
	}
}
