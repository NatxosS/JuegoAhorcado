
public class IniciarJuego {

	public char[] elegirPalabra() {
		
		char[] cadenaPalabra;   // vector con los caracteres de la palabra a adivinar
		
		String[] palabras = {"perro", "everest", "aguadulce", "murcielago", "montaña", "ordenador", "monitor", "papelera", "extintor", "horario", "buitre", "bocadillo", "hambre", "tarjeta", "grafica", "hotel", "pizarra", "videojuego", "tomate", "pimiento"};
		int posicionPalabra = (int)(Math.random()*20);  // pedimos al ordenador un número aleatorio entre 0 y 19 que nos indique la posición al azar de la palabra que vamos a jugar

		cadenaPalabra = new char[palabras[posicionPalabra].length()]; // asignamos el tamaño igual a cantidad de letras de la palabra a adivinar al vector
		                                                                  
		for (int i=0; i<cadenaPalabra.length; i++) {
			cadenaPalabra[i] = palabras[posicionPalabra].charAt(i);     // recorremos el vector introduciendo cada letra de la palabra en su correspondiente posición
		}
		
		return cadenaPalabra;    // devolvemos la palabra en un vector de caracteres
	}
	public static void main(String[] args) {
		
		IniciarJuego iniciar = new IniciarJuego();
		char[] palabra = iniciar.elegirPalabra();
		Juego jug = new Juego(palabra);
	}

}
