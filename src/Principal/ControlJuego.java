package Principal;

import java.util.Random;

public class ControlJuego {
	private final static int lado = 4;
	private int tablero[][];
	private int puntuacion;
	int puntero;
	boolean [] movimiento;

	public ControlJuego() {
		tablero = new int[4][4];
		// Inicializamos una nueva partida
		inicializarPartida();
	}

	/**
	 * Metodo para generar un nuevo tablero de partida:
	 */
	public void inicializarPartida() {
		puntuacion = 0;
		movimiento = new boolean[4];
		for (int i = 0; i < movimiento.length; i++) {
			movimiento[i]=true;
		}
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = 0;
			}
		}
		

		// depurar();
	}

	/**
	 * Metodo que comprueba si el valor de la casilla a la izquierda
	 * si es igual a cero o al valor que se desplaza.
	 */
	public void moverIzquierda() {
		for (int columna = 0; columna < tablero.length; columna++) {
			puntero = 0;
			for (int fila = 0; fila < tablero.length; fila++) {

				if (tablero[fila][columna] != 0) {
					movimiento[0]=true;
					if (puntero <= fila) {
						CambioColumnas(fila, columna, false);
					}else {
					movimiento[0]=false;
				}
				}
			}
		}
	}
	/**
	 * Metodo que comprueba si el valor de la casilla a la derecha
	 * si es igual a cero o al valor que se desplaza.
	 */
	public void moverDerecha() {
		for (int columna = 0; columna < tablero.length; columna++) {
			puntero = tablero.length - 1;
			for (int fila = tablero.length - 1; fila >= 0; fila--) {

				if (tablero[fila][columna] != 0) {
					movimiento[1]=true;
					if (puntero >= fila) {
						CambioColumnas(fila, columna, true);
					}else {
					movimiento[0]=false;
				}
				}
			}
		}
	}
	/**
	 * Metodo que comprueba si el valor de la casilla arriba
	 * si es igual a cero o al valor que se desplaza.
	 */
	public void moverArriba() {
		for (int fila = 0; fila < tablero.length; fila++) {

			puntero = 0;
			for (int columna = 0; columna < tablero.length; columna++) {

				if (tablero[fila][columna] != 0) {
					movimiento[2]=true;
					if (puntero <= columna) {
						cambioFila(fila, columna, false);
					}else {
					movimiento[2]=false;
				}
				}
			}
		}

	}
	/**
	 * Metodo que comprueba si el valor de la casilla abajo
	 * si es igual a cero o al valor que se desplaza.
	 */
	public void moverAbajo() {
		for (int fila = 0; fila < tablero.length; fila++) {
			puntero = tablero.length - 1;
			for (int columna = tablero.length - 1; columna >= 0; columna--) {

				if (tablero[fila][columna] != 0) {
					movimiento[3]=true;
					if (puntero >= columna) {
						cambioFila(fila, columna, true);
					} else {
						movimiento[3] = false;
					}
				}
			}
		}

	}
	/**
	 * Metodo que mueve el valor de la casilla por las columnas
	 * (de arriba a abajo)
	 * 
	 */
	private void CambioColumnas(int fila, int columna, boolean direccion) {

		if (tablero[puntero][columna] == 0 || tablero[puntero][columna] == tablero[fila][columna]) {
			if (fila > puntero || (direccion && (puntero > fila))) {
				if (tablero[puntero][columna] == tablero[fila][columna]) {
					actualizarPuntuacion(tablero[puntero][columna] + tablero[fila][columna]);
				}

				tablero[puntero][columna] += tablero[fila][columna];
				tablero[fila][columna] = 0;
				if (tablero[puntero][columna] == tablero[fila][columna]) {
					actualizarPuntuacion(tablero[puntero][columna]);
				}
			}
		} else {
			if (direccion) {
				puntero--;
			} else {
				puntero++;
			}

			CambioColumnas(fila, columna, direccion);
		}
	}
	/**
	 * Metodo que mueve el valor de la casilla por las filas
	 * (de izquierda a derecha)
	 */
	private void cambioFila(int fila, int columna, boolean direccion) {

		if (tablero[fila][puntero] == 0 || tablero[fila][puntero] == tablero[fila][columna]) {
			if (columna > puntero || (direccion && (puntero > columna))) {
				if (tablero[fila][puntero] == tablero[fila][columna]) {
					actualizarPuntuacion(tablero[fila][puntero] + tablero[fila][columna]);
				}
				tablero[fila][puntero] += tablero[fila][columna];
				tablero[fila][columna] = 0;
				if (tablero[fila][puntero] == tablero[fila][columna]) {
					actualizarPuntuacion(tablero[fila][puntero]);
				}
			}
		} else {
			if (direccion) {
				puntero--;
			} else {
				puntero++;
			}

			cambioFila(fila, columna, direccion);
		}
	}

	public void actualizarPuntuacion(int suma) {
		puntuacion += suma;
	}
	/**
	 * metodo que crea un nuevo valor en una casilla del tablero
	 * devuelve la posicion del valor
	 * @return posicion
	 */
	public int[] nuevoCuadrado() {
		boolean colocado = false;
		int[] posicion = new int[2];
		do {
			Random rd = new Random();
			int i = rd.nextInt(lado);
			int j = rd.nextInt(lado);

			if (tablero[i][j] == 0) {
				tablero[i][j] = 2;
				posicion[0] = i;
				posicion[1] = j;
				colocado = true;
			}

		} while (colocado == false);
		return posicion;

	}

	public void depurar() {
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[j][i] + "\t");
			}
		}
		System.out.println(puntuacion);
	}


	public boolean posibleMovimiento() {
		

		return movimiento[0]&&movimiento[1]&&movimiento[2]&&movimiento[3];
	}

	/** GETTER AND SETTER **/
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	public boolean[] getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(boolean[] movimiento) {
		this.movimiento = movimiento;
	}

}
