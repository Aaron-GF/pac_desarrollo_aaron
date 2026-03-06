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

        int lives = 3;
        int keys = 0;

        while(lives > 0 && keys < 3) {
            String heart = lives == 3 ? "♥️ ♥️ ♥️" : lives == 2 ? "♥️ ♥️" : "♥️";
            String userOption; 
        while (true) {
            Typing.slow("\n[JIGSAW]: Debes tomar una decisión: \n", 20);
            Typing.slow("> PIEDRA [o]", 20);
            Typing.slow("> PAPEL  [-]", 20);
            Typing.slow("> TIJERA [x]", 20);
            System.out.println(AsciiArt.divider());
            Typing.slow("VIDAS RESTANTES: " + heart, 20);
            Typing.slow("\nLLAVES CONSEGUIDAS: " + keys + "/3" + " 🔑", 20);

            userOption = sc.nextLine().trim().toLowerCase();
            switch (userOption) {
                case "-":
                    userOption = "papel";
                    break;
                case "o":
                    userOption = "piedra";
                    break;
                case "x":
                    userOption = "tijera";
                    break;
            }

            // Solo deja continuar si el usuario introduce una opcion válida
            if (
                userOption.equals("piedra") || 
                userOption.equals("papel") || 
                userOption.equals("tijera")
            ) break; 

            Typing.slow("\n[JIGSAW]: \"Cada movimiento cuenta. No malgastes tu oportunidad con errores necios.\n", 30);
        }

        String[] choices = {"piedra", "papel", "tijera"};
        int randomIndex = (int) (Math.random() * 3);
        String jigsawOption = choices[randomIndex];

        // Muestra las elecciones de los jugadores
        System.out.println("\nHAS ELEGIDO:");
        System.out.println(AsciiArt.divider());
        printArt(userOption);
    
        System.out.println("\nJIGSAW HA ELEGIDO: ...");
        System.out.println(AsciiArt.divider());
        Thread.sleep(500); 
        printArt(jigsawOption);

        // Determina el destino del jugador
        if (userOption.equals(jigsawOption)) {
            Typing.slow("\n[JIGSAW]: Un empate... Las piezas siguen sin encajar.\n", 30);
        } 
        else if (
            (userOption.equals("piedra") && jigsawOption.equals("tijera")) ||
            (userOption.equals("papel") && jigsawOption.equals("piedra")) ||
            (userOption.equals("tijera") && jigsawOption.equals("papel")) 
        ) {
            keys++;
            Typing.slow("\n[JIGSAW]: Has tomado la decisión correcta...\n", 30);
        } 
        else {
            lives--;
            Typing.slow("\n[JIGSAW]: Una mala decisión tiene consecuencias...\n", 30);
        }
        }
        if(lives == 0) {
            Typing.slow("\n[JIGSAW]: Tu tiempo se ha agotado... Fin del juego!\n", 50);
        } else {
            Typing.slow("\n[JIGSAW]: Felicidades, " + name + ". Has demostrado que valoras tu vida... por ahora.\n", 50);
        }
        sc.close();
        
    }

    // Metodo auxiliar para imprimir código ASCII
    public static void printArt(String opcion) {
        if (opcion.contains("piedra")) {
            System.out.println(AsciiArt.stone());
        } else if (opcion.contains("papel")) {
            System.out.println(AsciiArt.paper());
        } else if (opcion.contains("tijera")) {
            System.out.println(AsciiArt.scissors());
        }
    }
}
