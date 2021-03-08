import java.util.ArrayList;
import java.util.List;

public class PlanetaAcuatico {
	private static List<AnimalAcuatico>[][] planeta;
	private static final int FILAS = 20;
	private static final int COLUMNAS = 20;
	private static final int MAX = 2;

	public PlanetaAcuatico() {
		super();
		planeta = new ArrayList[FILAS][COLUMNAS];

		for (int i = 0; i < planeta.length; i++) {
			for (int j = 0; j < planeta[i].length; j++)
				planeta[i][j] = new ArrayList<AnimalAcuatico>(MAX);
		}

	}

	public void situarAnimal(AnimalAcuatico a, int fila, int columna) {
		synchronized (planeta[fila][columna]) {
			planeta[fila][columna].add(a);

			if (planeta[fila][columna].size() == MAX) {
				if (planeta[fila][columna].get(0).getClass().equals(planeta[fila][columna].get(1).getClass())
						&& planeta[fila][columna].get(0).getSexo() == planeta[fila][columna].get(1).getSexo()) {
					planeta[fila][columna].get(0).setMuerto(true);
					planeta[fila][columna].remove(0);
				} else if (!planeta[fila][columna].get(0).getClass().equals(planeta[fila][columna].get(1).getClass())) {
					if (planeta[fila][columna].get(0) instanceof Tiburon) {
						planeta[fila][columna].get(1).setMuerto(true);
						planeta[fila][columna].remove(1);
					} else {
						planeta[fila][columna].get(0).setMuerto(true);
						planeta[fila][columna].remove(0);
					}
				} else if (planeta[fila][columna].get(0).getClass().equals(planeta[fila][columna].get(1).getClass())
						&& planeta[fila][columna].get(0).getSexo() != planeta[fila][columna].get(1).getSexo()) {
					planeta[fila][columna].get(0).reproducirse(planeta[fila][columna].get(1));
				}
			}
		}

	}

	public void quitarAnimal(AnimalAcuatico a) {
		if (a != null) {
			for (int i = 0; i < planeta.length; i++) {
				for (int j = 0; j < planeta[i].length; j++) {
					if (planeta[i][j].contains(a))
						planeta[i][j].remove(a);
				}
			}
		}
	}

	public int getPlanetaFila(AnimalAcuatico a) {
		if (a != null) {
			for (int i = 0; i < planeta.length; i++) {
				for (int j = 0; j < planeta[i].length; j++) {
					if (planeta[i][j].contains(a))
						return i;
				}
			}
		}
		return -1;
	}

	public int getPlanetaColumna(AnimalAcuatico a) {
		if (a != null) {
			for (int i = 0; i < planeta.length; i++) {
				for (int j = 0; j < planeta[i].length; j++) {
					if (planeta[i][j].contains(a))
						return j;
				}
			}
		}
		return -1;
	}

	public boolean filaValida(int fila) {
		if (fila < 0 || fila >= FILAS)
			return false;
		return true;
	}

	public boolean columnaValida(int col) {
		if (col < 0 || col >= COLUMNAS)
			return false;
		return true;
	}

	public static int getFilas() {
		return FILAS;
	}

	public static int getColumnas() {
		return COLUMNAS;
	}

}
