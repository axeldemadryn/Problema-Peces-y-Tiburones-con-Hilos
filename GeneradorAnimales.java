import java.util.Random;

public class GeneradorAnimales implements Runnable {
	private PlanetaAcuatico planeta;
	private static char macho = 'M';
	private static char hembra = 'H';
	private static Random fila;
	private static Random columna;
	private static final int MAX_PECES = 100;
	private static final int MAX_TIBURONES = 10;

	public GeneradorAnimales(PlanetaAcuatico planeta) {
		super();
		this.planeta = planeta;
		fila = new Random();
		columna = new Random();
	}

	public void run() {
		AnimalAcuatico p;
		for (int i = 0; i < MAX_PECES; i++) {
			if (i < MAX_PECES / 2) {
				p = new Pez("Pez " + i, macho, planeta);
				planeta.situarAnimal(p, fila.nextInt(PlanetaAcuatico.getFilas()),
						columna.nextInt(PlanetaAcuatico.getColumnas()));
				p.start();
			} else {
				p = new Pez("Pez " + i, hembra, planeta);
				planeta.situarAnimal(p, fila.nextInt(PlanetaAcuatico.getFilas()),
						columna.nextInt(PlanetaAcuatico.getColumnas()));
				p.start();
			}
		}

		AnimalAcuatico t;
		for (int i = 0; i < MAX_TIBURONES; i++) {
			if (i < MAX_TIBURONES / 2) {
				t = new Tiburon("Tiburón " + i, macho, planeta);
				planeta.situarAnimal(t, fila.nextInt(PlanetaAcuatico.getFilas()),
						columna.nextInt(PlanetaAcuatico.getColumnas()));
				t.start();
			} else {
				t = new Tiburon("Tiburón " + i, hembra, planeta);
				planeta.situarAnimal(t, fila.nextInt(PlanetaAcuatico.getFilas()),
						columna.nextInt(PlanetaAcuatico.getColumnas()));
				t.start();
			}
		}
	}

}
