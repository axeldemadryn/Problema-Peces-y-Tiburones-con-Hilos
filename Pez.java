import java.util.Random;

public class Pez extends AnimalAcuatico {

	public Pez(String nombre, char sexo, PlanetaAcuatico planeta) {
		super(nombre, sexo, planeta);
	}

	public void reproducirse(AnimalAcuatico a) {
		Random r = new Random();
		Random f = new Random();
		Random c = new Random();
		if (a instanceof Pez) {
			AnimalAcuatico p;
			System.out.println(this + " Y " + a + " SE REPRODUJERON");
			if (r.nextInt(100) < 50) {
				p = new Pez("Pez hijo", 'M', a.getPlaneta());
				planeta.situarAnimal(p, f.nextInt(PlanetaAcuatico.getFilas()),
						c.nextInt(PlanetaAcuatico.getColumnas()));
				p.start();
			} else {
				p = new Pez("Pez Hijo", 'H', a.getPlaneta());
				planeta.situarAnimal(p, f.nextInt(PlanetaAcuatico.getFilas()),
						c.nextInt(PlanetaAcuatico.getColumnas()));
				p.start();
			}
		}

	}

	@Override
	public String toString() {
		return "Pez [getNombre()=" + getNombre() + ", getSexo()=" + getSexo() + "]";
	}

}
