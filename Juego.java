import java.util.Arrays;
import java.util.Scanner;

public class Juego {

	// -----  varibles globales  -----------
	
	private char[] palabra;
	private char[] palabraJugador;
	
	// ---------- CONSTRUCTOR  ----------
	
	public Juego(char[] palabraElegida) {
		
		this.palabra = palabraElegida;
		this.palabraJugador = new char[palabra.length];
		
		for (int i=0; i<palabraJugador.length; i++) {   // Rellenamos el vector de apoyo con el caracter'_', 
			palabraJugador[i] = '_';                      // que mostraremos en la posición de los caracter aun no acertados
		}
		
		empezar();
	}
	
	// ---------- MÉTODOS  ----------
	
	public void empezar() {
		
		System.out.println();
		System.out.println("/*-*-*-*-*-*-*-*-*---*-*-*-*-*-*-*-*\\");
		System.out.println("|        BIENVENIDOS AL AHORCADO     |");
		System.out.println("\\___________________________________/");
		System.out.println();
		System.out.println("Comencemos a jugar: ");
		System.out.println();
		
		jugar();     // A jugar se ha dicho
	}
	
	public void jugar() {
		
		Scanner sc = new Scanner(System.in);
		char caracterElegido;
		
		int contadorIntentos = 0;
		String letrasIntroducidas = "Letras ya introducidas";   // cadena para informar al jugador de las letras con las que ya ha probado, se iran concatenando
		boolean acerto = false;  // booleano que nos indicara si acerto para que no acumule intento en esta vuelta
		boolean gano = false;      // booleano que nos dira si ya termino de adivinar la palabra para dejar de pedirle letras y terminar el juego
		
		do {
			do {
				acerto = false;
				System.out.print("Palabra a acertar: ");
				
				for (int i=0; i<palabraJugador.length; i++) {      // mostramos lo que lleva acertado el jugador
					System.out.print(palabraJugador[i] +" ");  
				}
				System.out.println();
				System.out.println(letrasIntroducidas);
				System.out.println();
				System.out.print("Introduzca una letra (Error: "+ (contadorIntentos) +"/6): ");  // mostramos los errores que lleva de los 6 posibles
				System.out.println();
				
				caracterElegido = Character.toLowerCase(sc.nextLine().charAt(0));             // capturamos el caracter elegido por el jugador convirtiendolo en minuscula, en caso que sea mayuscula para despues comparar
				letrasIntroducidas += ", "+ caracterElegido; 
				
				for (int i=0; i<palabra.length; i++) {          // corazon del juego, compara si el caracter introducido por el jugador
					if (palabra[i] == caracterElegido) {        // es igual que alguno del vector que compone la palabra, si es asi,
						palabraJugador[i] = caracterElegido;    // se guarda en el vector palabraJugador en la misma posicion donde se encontraba en el otro vector
						acerto = true;         // tambien indicamos al chivato que se acerto en esta letra
					}
				}
				
				if (Arrays.equals(palabraJugador, palabra)) {     // si los dos vectores ya son iguales es que termino de acertar la palabra y por lo tanto he juego ha terminado
					gano = true;
				}
				
				if (acerto) {
					System.out.println();
					System.out.println("BIEN!!");
					System.out.println();
					System.out.println(this.imagenJuego()[contadorIntentos]);   // aunque acertara, mostramos en que estado se encuentra el dibujo
				} else {
					System.out.println();
					System.out.println("Mala suerte!!");
					System.out.println();
					if (contadorIntentos < 5) {        //
						System.out.println(this.imagenJuego()[contadorIntentos+1]);  // mostramos un poco mas de dibujo
					}
				}
			} while(acerto == true && gano == false);   // si no acierta con una letra y no gano, incrementamos el contador de intentos/errores        
			
			contadorIntentos++;  

		} while(contadorIntentos<6 && gano == false);   // mientras no tenga 6 errores y no haya ganado el juego continua
		
		if (gano) {
			System.out.println("Salvaste tu pellejo forastero!! \n    La palabra era: "+ palabraElegida());   // si gano, mostramos mensaje de enorabuena
		} else {                    // si no gano mostramos la animación ahorcadonse
			mostrarAnimacion();
		}
	}
	
	public String palabraElegida() {      // metodo para montar y devolver en String la palabra elegida por el ordenador
		
		String cadena = "";
		
		for (int i=0; i<palabra.length; i++) {
			cadena += palabra[i];
		}
		
		return cadena;
	}
	
	public void mostrarAnimacion() {
		
		// -----------------------                  Hacemos esto de abajo para poner una pequeña animacion
		String[] imagen = imagenJuegoPerdido();
		
		for (int i=0; i<imagen.length; i++) {     // hacemos este bucle para recorrer las imagenes para ser mostradas
			try{                             
				Thread.sleep(300);    // metemos pausas de 300 milisegundos para que el ojo humano perciba las diferentes imagenes que van a ser mostradas
				System.out.println(imagen[i]);
				}catch(InterruptedException e ) {
					System.out.println(e +"Thread Interrupted");
				}
		}
	}
	
	public String[] imagenJuego() {   //  vector de String´s que alamacena la imagen del ahorcado
		
		String[] cadenaImagen = new String[6];
		
		cadenaImagen[0] = "";	
		
		cadenaImagen[1] = "\n "				              
	+"	|-    \n"         
	+"	| \\   \n"         
	+"	| |   \n"            
	+"	| |   \n"           
	+"	| |   \n"        
	+"	| |   \n"       
	+"	| |   \n"                  
	+"	| |   \n"                    
	+"	| |   \n"              
	+"	| |   \n"         
	+"	| |   \n"         
	+"	| |   \n"          
	+"	| |   \n"         
	+"	| |   \n"        
	+"	| |   \n"     
	+"	| |   \n"    
	+"	|  \\    \n"
	+"	 \\  \\    \n"
	+"	  \\  \\   \n"
	+"	----------------------------------------- \n"
	+"	  ------------------------------------  \n"
	+"	     ------------------------------   \n"
+"\n";
		
	cadenaImagen[2] = "\n "				              
	+"       -----------------------| \n"
	+"        | |--------------------| \n"
	+"        | |                 | \n"
	+"        | |   \n"
	+"	| |   \n"         
	+"	| |   \n"         
	+"	| |   \n"            
	+"	| |   \n"           
	+"	| |   \n"        
	+"	| |   \n"       
	+"	| |   \n"                  
	+"	| |   \n"                    
	+"	| |   \n"              
	+"	| |   \n"         
	+"	| |   \n"         
	+"	| |   \n"          
	+"	| |   \n"         
	+"	| |   \n"        
	+"	| |   \n"     
	+"	| |   \n"    
	+"	|  \\    \n"
	+"	 \\  \\    \n"
	+"	  \\  \\   \n"
	+"	----------------------------------------- \n"
	+"	  ------------------------------------  \n"
	+"	     ------------------------------   \n"
+"\n";
	
	cadenaImagen[3] = "\n "				              
			+"       -----------------------| \n"
			+"        | |--------------------| \n"
			+"        | |                 | \n"
			+"        | |               .´`´.  \n"
			+"	| |              '/¬ ¬\\'  \n"         
			+"	| |              c| L |D   \n"         
			+"	| |               \\ u /  \n"            
			+"	| |   \n"           
			+"	| |   \n"        
			+"	| |   \n"       
			+"	| |   \n"                  
			+"	| |   \n"                    
			+"	| |   \n"              
			+"	| |   \n"         
			+"	| |   \n"         
			+"	| |   \n"          
			+"	| |   \n"         
			+"	| |   \n"        
			+"	| |   \n"     
			+"	| |   \n"    
			+"	|  \\    \n"
			+"	 \\  \\    \n"
			+"	  \\  \\   \n"
			+"	----------------------------------------- \n"
			+"	  ------------------------------------  \n"
			+"	     ------------------------------   \n"
		+"\n";
		
	cadenaImagen[4] = "\n "				              
			+"       -----------------------| \n"
			+"        | |--------------------| \n"
			+"        | |                 | \n"
			+"        | |               .´`´.  \n"
			+"	| |              '/¬ ¬\\'  \n"         
			+"	| |              c| L |D   \n"         
			+"	| |               \\ u /  \n"            
			+"	| |              __] [__  \n"           
			+"	| |             /        \\\n"        
			+"	| |            / _      _ \\   \n"       
			+"	| |   \n"                  
			+"	| |   \n"                    
			+"	| |   \n"              
			+"	| |   \n"         
			+"	| |   \n"         
			+"	| |   \n"          
			+"	| |   \n"         
			+"	| |   \n"        
			+"	| |   \n"     
			+"	| |   \n"    
			+"	|  \\    \n"
			+"	 \\  \\    \n"
			+"	  \\  \\   \n"
			+"	----------------------------------------- \n"
			+"	  ------------------------------------  \n"
			+"	     ------------------------------   \n"
		+"\n";
		
	cadenaImagen[5] = "\n "				              
			+"       -----------------------| \n"
			+"        | |--------------------| \n"
			+"        | |                 | \n"
			+"        | |               .´`´.  \n"
			+"	| |              '/¬ ¬\\'  \n"         
			+"	| |              c| L |D   \n"         
			+"	| |               \\ u /  \n"            
			+"	| |              __] [__  \n"           
			+"	| |             /        \\\n"        
			+"	| |            / _      _ \\   \n"       
			+"	| |           / / |    | \\ \\ \n"                  
			+"	| |          c D  |    |  c D \n"                    
			+"	| |           u   |    |   U \n"              
			+"	| |               ------  \n"         
			+"	| |              /      \\ \n"         
			+"	| |   \n"          
			+"	| |   \n"         
			+"	| |   \n"        
			+"	| |   \n"     
			+"	| |   \n"    
			+"	|  \\    \n"
			+"	 \\  \\    \n"
			+"	  \\  \\   \n"
			+"	----------------------------------------- \n"
			+"	  ------------------------------------  \n"
			+"	     ------------------------------   \n"
		+"\n";
		
		return cadenaImagen;
	}
	
public String[] imagenJuegoPerdido() {   //  vector de String´s que alamacena las imagenes que componen una especie de gif animado del ahorcado en caso de perder
		
		String[] cadenaImagen = new String[5];
		
		cadenaImagen[0] = "\n "				              
				+"       -----------------------| \n"
				+"        | |--------------------| \n"
				+"        | |                 | \n"
				+"        | |               .´`´.  \n"
				+"	| |              '/¬ ¬\\'  \n"         
				+"	| |              c| L |D   \n"         
				+"	| |               \\ u /  \n"            
				+"	| |              __] [__  \n"           
				+"	| |             /        \\     \n"        
				+"	| |            / _      _ \\        \n"       
				+"	| |           / / |    | \\ \\       \n"           
				+"	| |          c D  |    |  c D        \n"                    
				+"	| |           u   |    |   U            /¬ )\n"              
				+"	| |               ------               (   /  \n"         
				+"	| |              /      \\          |     ][ \n"         
				+"	| |             /   /\\   \\         |C____  \\ \n"          
				+"	| |            /   /  \\   \\        |    /   \\\n"         
				+"	| |           |   /    \\   |       |    /   |  \n"        
				+"	| |         /--   |     |   --\\    |    |   | \n"     
				+"	| |        C______>     <______D   |    |    J \n"    
				+"	|  \\     /------------------------/    / /\\ \\\n"
				+"	 \\  \\       |                  |      / /  \\ \\    \n"
				+"	  \\  \\   \n"
				+"	----------------------------------------- \n"
				+"	  ------------------------------------  \n"
				+"	     ------------------------------   \n"
			+"\n";	
		
		cadenaImagen[1] = "\n "				              
				+"       -----------------------| \n"
				+"        | |--------------------| \n"
				+"        | |                 | \n"
				+"        | |               .´`´.  \n"
				+"	| |              '/¬ ¬\\'  \n"         
				+"	| |              c| L |D   \n"         
				+"	| |               \\ u /  \n"            
				+"	| |              __] [__  \n"           
				+"	| |             /        \\     \n"        
				+"	| |            / _      _ \\        \n"       
				+"	| |           / / |    | \\ \\       \n"           
				+"	| |          c D  |    |  c D        \n"                    
				+"	| |           u   |    |   U                 /¬ )\n"              
				+"	| |               ------                    (   /  \n"         
				+"	| |              /      \\               |     ][ \n"         
				+"	| |             /   /\\   \\              |C____  \\ \n"          
				+"	| |            /   /  \\   \\             |    /   \\\n"         
				+"	| |           |   /    \\   |            |    /   |  \n"        
				+"	| |         /--   |     |   --\\         |    |   | \n"     
				+"	| |        C______>     <______D        |    |    J \n"    
				+"	|  \\          /------------------------/    / /\\ \\\n"
				+"	 \\  \\            |                  |      / /  \\ \\ \n"
				+"	  \\  \\           |                  |      | |   \\ \\\n"
				+"	----------------------------------------- \n"
				+"	  ------------------------------------  \n"
				+"	     ------------------------------   \n"
			+"\n";	
		
	cadenaImagen[2] = "\n "				              
			+"       -----------------------| \n"
			+"        | |--------------------| \n"
			+"        | |                 | \n"
			+"        | |               .´`´.  \n"
			+"	| |              '/¬ ¬\\'  \n"         
			+"	| |              c| L |D   \n"         
			+"	| |               \\ u /  \n"            
			+"	| |              __] [__  \n"           
			+"	| |             /        \\     \n"        
			+"	| |            / _      _ \\        \n"       
			+"	| |           / / |    | \\ \\       \n"           
			+"	| |          c D  |    |  c D        \n"                    
			+"	| |           u   |    |   U                      /¬ )\n"              
			+"	| |               ------                         (   /  \n"         
			+"	| |              /      \\                    |     ][ \n"         
			+"	| |             /   /\\   \\                   |C____  \\ \n"          
			+"	| |            |   /  \\   \\                  |    /   \\\n"         
			+"	| |            |  /    \\   |                 |    /   |  \n"        
			+"	| |            |  |    |   --\\               |    |   | \n"     
			+"	| |            /  /    <______D              |    |    J \n"    
			+"	|  \\           ww   /------------------------/    / /\\ \\  \n"
			+"	 \\  \\                  |                  |      / /  \\ \\ \n"
			+"	  \\  \\                 |                  |      | |   \\ \\\n"
			+"	----------------------------------------- \n"
			+"	  ------------------------------------  \n"
			+"	     ------------------------------   \n"
		+"\n";
	
	cadenaImagen[3] = "\n "				              
			+"       -----------------------| \n"
			+"        | |--------------------| \n"
			+"        | |                 | \n"
			+"        | |               .´`´.  \n"
			+"	| |              '/¬ ¬\\'  \n"         
			+"	| |              c| L |D   \n"         
			+"	| |               \\ u /  \n"            
			+"	| |              __] [__  \n"           
			+"	| |             /        \\     \n"        
			+"	| |            / _      _ \\        \n"       
			+"	| |           / / |    | \\ \\       \n"           
			+"	| |          c D  |    |  c D        \n"                    
			+"	| |           u   |    |   U                             /¬ )\n"              
			+"	| |               ------                                (   /  \n"         
			+"	| |              /      \\                           |     ][ \n"         
			+"	| |             /   /\\   \\                          |C____  \\ \n"          
			+"	| |            |   /  \\   \\                         |    /   \\\n"         
			+"	| |            |  /    \\   |                        |    /   |  \n"        
			+"	| |            |  |    |   --\\                      |    |   | \n"     
			+"	| |            /  /    <______D                     |    |    J \n"    
			+"	|  \\           ww          /------------------------/    / /\\ \\  \n"
			+"	 \\  \\                         |                  |      / /  \\ \\ \n"
			+"	  \\  \\                        |                  |      | |   \\ \\\n"
			+"	----------------------------------------- \n"
			+"	  ------------------------------------  \n"
			+"	     ------------------------------   \n"
		+"\n";
		
	cadenaImagen[4] = "\n "				              
			+"       -----------------------| \n"
			+"        | |--------------------| \n"
			+"        | |                 | \n"
			+"        | |               .´`´.  \n"
			+"	| |              '/x x\\'  \n"         
			+"	| |              c| L |D   \n"         
			+"	| |               \\ Ʋ /  \n"            
			+"	| |              __] [__  \n"           
			+"	| |             /        \\         Has perdido!! Tu alma vagara en\n"        
			+"	| |            / _      _ \\        el infierno por no acertar esta   \n"       
			+"	| |           / / |    | \\ \\             dichosa palabra: \n"                  
			+"	| |          c D  |    |  c D               "+ palabraElegida() +" \n"                 
			+"	| |           u   |    |   U                                    /¬ )\n"              
			+"	| |               ------                                       (   /  \n"         
			+"	| |              /      \\                                  |     ][ \n"         
			+"	| |             /   /\\   \\                                 |C____  \\ \n"          
			+"	| |            |   /  \\   \\                                |    /   \\\n"         
			+"	| |            |  /    |  |                                |    /   | \n"        
			+"	| |            |  |    |  |                                |    |   | \n"     
			+"	| |            /  /    \\ \\                                 |    |    J \n"    
			+"	|  \\           ww        ww       /------------------------/    / /\\ \\  \n"
			+"	 \\  \\                                |                  |      / /  \\ \\ \n"
			+"	  \\  \\                               |                  |      | |   \\ \\\n"
			+"	----------------------------------------- \n"
			+"	  ------------------------------------  \n"
			+"	     ------------------------------   \n"
		+"\n";

		return cadenaImagen;
	}
}
