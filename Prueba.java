import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prueba {

	public static void main(String[] args) {
		PlanetaAcuatico planeta = new PlanetaAcuatico();
		ExecutorService ejecutor = Executors.newCachedThreadPool();

		ejecutor.execute(new GeneradorAnimales(planeta));

		ejecutor.shutdown();

	}

}
