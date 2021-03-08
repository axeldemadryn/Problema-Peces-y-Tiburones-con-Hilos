# Problema-Peces-y-Tiburones-con-Hilos
Ejercicio Java:
Simular un planeta acuático reticulado de dimensión 20x20. Este planeta está habitado por peces y tiburones de ambos sexos. Escribir un programa que inicialmente sitúe en forma aleatoria 100 peces (50 machos y 50 hembras) y 10 tiburones (5 machos y 5 hembras) en el planeta de manera que:
•	Cada habitante del mundo (pez o tiburón) esté representado por un hilo concurrente.
•	Cada habitante del mundo nada desde la posición en que se encuentra una posición hacia el norte, sur, este u oeste (si no puede avanzar elige otra dirección).
•	Si habitantes del mundo se encuentran en la misma posición ocurre lo siguiente:
a) si son del mismo sexo y de la misma especie, uno aniquila al otro.
b) si son de especies diferentes, el tiburón siempre aniquila al pez.
c) si son de la misma especie y de distinto sexo, se reproducen, generando un nuevo individuo cuyo sexo será macho o hembra con igual probabilidad, y luego continúan su camino.

Lo tengo hecho, pero hay veces en las que cuando sitúo un animal en la clase PlanetaAcuatico me salta un error de que el tamaño (size) del arraylist en donde sitúo el animal es 1, y en el método situarAnimal maneja los dos primeros lugares de cada arraylist cuando éste llega a 2; no entiendo porque ocurre este error.
Hice que cada arraylist esté sincronizado para que se sitúe de a un animal en cada lugar del planeta acuático.

