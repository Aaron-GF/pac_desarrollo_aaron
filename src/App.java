import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Typing.slow(AsciiArt.title(), 1);
        System.out.println(AsciiArt.divider());

        Scanner sc = new Scanner(System.in);

        Typing.slow("Introduce tu nombre: ", 40);
        String name = sc.nextLine();

        Typing.slow("\n[JIGSAW]: Las reglas son sencillas " + name + ", tu victoria depende de tus decisiones. ¿Continuar? (y/n)\n", 40);
        String option;

        while (true) {
            option = sc.nextLine().trim().toLowerCase();
            if (option.equals("y") || option.equals("n")) break;
        }

        if (option.equals("n")) {
            Typing.slow("\nHas decidido no jugar... el juego termina aquí.\n", 40);
            sc.close();
            return; 
        }

        try {
            Thread.sleep(1000);  
            System.out.println("\n...3");
            Thread.sleep(1000);  
            System.out.println("...2");
            Thread.sleep(1000);
            System.out.println("...1\n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }

        Typing.slow(AsciiArt.startGame(), 1);

        String userOption; 
        while (true) {
            Typing.slow("\n[JIGSAW]: Debes tomar una decisión: \n", 40);
            Typing.slow("> PIEDRA [o]", 30);
            Typing.slow("> PAPEL  [-]", 30);
            Typing.slow("> TIJERA [x]", 30);

            userOption = sc.nextLine().trim().toLowerCase();

            if (
                userOption.equals("o") || 
                userOption.equals("-") || 
                userOption.equals("x")
            ) break; 

            // Si llega aquí, es que la entrada NO fue válida
            Typing.slow("\n[JIGSAW]: \"Cada movimiento cuenta. No malgastes tu oportunidad con errores necios.\n", 40);
        }

        String[] choices = {"piedra", "papel", "tijeras"};
        int randomIndex = (int) (Math.random() * 3);
        String jigsawOption = choices[randomIndex];

        // Muestra las elecciones de los jugadores
        System.out.println("\nHAS ELEGIDO:");
        System.out.println(AsciiArt.divider());
        printArt(userOption);
    
        Typing.slow("\nJIGSAW HA ELEGIDO: ...", 60);
        System.out.println(AsciiArt.divider());
        Thread.sleep(500); 
        printArt(jigsawOption);

        // Determina el destino del jugador
        if (userOption.equals(jigsawOption)) {
            Typing.slow("\n[JIGSAW]: Un empate... Las piezas siguen sin encajar. Nadie gana esta vez.\n", 40);
        } 
        else if (
            (userOption.equals("o") && jigsawOption.equals("tijeras")) ||
            (userOption.equals("-") && jigsawOption.equals("piedra")) ||
            (userOption.equals("x") && jigsawOption.equals("papel")) 
        ) {
            Typing.slow("\n[JIGSAW]: Felicidades, " + name + ". Has demostrado que valoras tu vida... por ahora.\n", 40);
        } 
        else {
            Typing.slow("\n[JIGSAW]: Tu tiempo se ha agotado. Fin del juego...\n", 60);
        }

        sc.close();
    }

    // Metodo auxiliar para imprimir código ASCII
    public static void printArt(String opcion) {
        if (opcion.equals("o") || opcion.contains("piedra")) {
            System.out.println(AsciiArt.stone());
        } else if (opcion.equals("-") || opcion.contains("papel")) {
            System.out.println(AsciiArt.paper());
        } else if (opcion.equals("x") || opcion.contains("tijera")) {
            System.out.println(AsciiArt.scissors());
        }
    }
}
