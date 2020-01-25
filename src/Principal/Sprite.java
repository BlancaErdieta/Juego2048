package Principal;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Blanca Erdieta
 */

public class Sprite {

	int posX;
	int posY;
	int lado;
	int velX;
	int velY;
	int valor;
	String ruta;
	BufferedImage buffer;

	/**
	 * Constructor para los sprites que tengan un valor mayor que cero
	 * 
	 * @param posX
	 * @param posY
	 * @param ancho
	 * @param alto
	 * @param velX
	 * @param velY
	 * @param valor
	 * @param buffer
	 */

	public Sprite(int posX, int posY, int lado, int velX, int velY, int valor) {

		this.posX = posX;
		this.posY = posY;
		this.lado = lado;
		this.velX = velX;
		this.velY = velY;
		this.valor = valor;
		pintarBuffer(valor);
	}
	/**
	 * constructor para los sprites que tienen valor cero
	 */
	public Sprite() {
	
	}

	/**
	 * Estampa en el buffer la imagen dependiendo del valor del sprite.
	 * 
	 * @param ruta
	 */
	private void pintarBuffer(int valor) {
		buffer = new BufferedImage(lado, lado, BufferedImage.TYPE_INT_ARGB);
		Graphics g = buffer.getGraphics();
		// Cargar la imagen, redimensionarla y estamparla:
		try {
			switch (valor) {
			case 2:{
				ruta = "imagenes/2.jpg";
				break;
			}
			case 4:{
				ruta = "imagenes/4.jpg";
				break;
			}
			case 8:{
				ruta = "imagenes/8.jpg";
				break;
			}
			case 16:{
				ruta = "imagenes/16.jpg";
				break;
			}
			case 32:{
				ruta = "imagenes/32.jpg";
				break;
			}
			case 64:{
				ruta = "imagenes/64.jpg";
				break;
			}
			case 128:{
				ruta = "imagenes/128.png";
				break;
			}
			case 256:{
				ruta = "imagenes/256.jpg";
				break;
			}
			case 512:{
				ruta = "imagenes/512.png";
				break;
			}
			case 1024:{
				ruta = "imagenes/1024.png";
				break;
			}
			case 2048:{
				ruta = "imagenes/2048.jpg";
				break;
			}
			default:{
				break;
			}
			}
			BufferedImage img = ImageIO.read(new File(ruta));
			g.drawImage(img.getScaledInstance(lado, lado, Image.SCALE_SMOOTH), 0, 0, null);

		} catch (IOException e) {
			
		}
		g.dispose();
	}

	/**
	 * Estampa el {@link Sprite#buffer} del {@link Sprite} en el grafico de
	 * entrada.
	 * 
	 * @param g
	 */
	public void pintarEnMundo(Graphics g) {
		g.drawImage(buffer, posX, posY, null);
	}
	
	/** GETTERS && SETTERS **/
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void setBuffer(BufferedImage buffer) {
		this.buffer = buffer;
	}

	
	

}
