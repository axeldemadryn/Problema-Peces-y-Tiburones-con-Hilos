import java.util.Random;

public class Tiburon extends AnimalAcuatico {

	public Tiburon(String nombre, char sexo, PlanetaAcuatico planeta) {
		super(nombre, sexo, planeta);
	}

	public void reproducirse(AnimalAcuatico a) {
		Random prob = new Random();
		Random f = new Random();
		Random c = new Random();
		if (a instanceof Tiburon) {
			AnimalAcuatico t;
			System.out.println(this + " Y " + a + " SE REPRODUJERON");
			if (prob.nextInt(100) < 50) {
				t = new Tiburon("Tiburón hijo", 'M', a.getPlaneta());
				planeta.situarAnimal(t, f.nextInt(PlanetaAcuatico.getFilas()),
						c.nextInt(PlanetaAcuatico.getColumnas()));
				t.start();
			} else {
				t = new Tiburon("Tiburón hijo", 'H', a.getPlaneta());
				planeta.situarAnimal(t, f.nextInt(PlanetaAcuatico.getFilas()),
						c.nextInt(PlanetaAcuatico.getColumnas()));
				t.start();
			}
		}

	}

	@Override
	public String toString() {
		return "Tiburon [getNombre()=" + getNombre() + ", getSexo()=" + getSexo() + "]";
	}

}
