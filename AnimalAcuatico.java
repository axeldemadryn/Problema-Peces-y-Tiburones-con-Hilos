import java.util.Random;

public abstract class AnimalAcuatico extends Thread {
	private String nombre;
	private char sexo;
	protected PlanetaAcuatico planeta;
	private boolean muerto;
	private static final int NORTE = 1;
	private static final int SUR = 2;
	private static final int OESTE = 3;
	private static final int ESTE = 4;
	private static long inicio;
	private static long fin;

	public AnimalAcuatico(String nombre, char sexo, PlanetaAcuatico planeta) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.planeta = planeta;
		muerto = false;
	}

	public void run() {
		Random r = new Random();
		inicio = System.currentTimeMillis();
		while (!muerto) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int dir = r.nextInt(4) + 1;
			int filaActual = planeta.getPlanetaFila(this);
			int colActual = planeta.getPlanetaColumna(this);
			if (planeta.filaValida(filaActual - 1) && planeta.columnaValida(colActual) && dir == NORTE) {
				moverse(filaActual - 1, colActual);
				System.out.println(this + " SE MOVIO HACIA EL NORTE");
			} else if (planeta.filaValida(filaActual + 1) && planeta.columnaValida(colActual) && dir == SUR) {
				moverse(filaActual + 1, colActual);
				System.out.println(this + " SE MOVIO HACIA EL SUR");
			} else if (planeta.columnaValida(colActual - 1) && planeta.filaValida(filaActual) && dir == OESTE) {
				moverse(filaActual, colActual - 1);
				System.out.println(this + " SE MOVIO HACIA EL OESTE");
			} else if (planeta.columnaValida(colActual + 1) && planeta.filaValida(filaActual) && dir == ESTE) {
				moverse(filaActual, colActual + 1);
				System.out.println(this + " SE MOVIO HACIA EL ESTE");
			}
		}
		fin = System.currentTimeMillis();
		double tiempo = (double) (fin - inicio);
		System.out.println(this + " MURIO Y DURO " + tiempo + " MILISEGUNDOS");
	}

	public void moverse(int fila, int col) {
		planeta.quitarAnimal(this);
		planeta.situarAnimal(this, fila, col);
	}

	public abstract void reproducirse(AnimalAcuatico a);

	public void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	public char getSexo() {
		return sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public PlanetaAcuatico getPlaneta() {
		return planeta;
	}

}
