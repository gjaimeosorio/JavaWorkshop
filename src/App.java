import java.io.IOException;
import java.util.Scanner;
import com.taller1.MainTaller1;
import com.taller2.MainTaller2;
import com.taller3.MainTaller3;
import com.taller4.MainTaller4;

public class App {

    private static boolean bandera = true;
    private static int opcion;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static Scanner input;

    public static void main(String[] args) throws Exception {
        System.out.println(ANSI_GREEN + "Bienvenido a los talleres de Java de Gabriel Jaime Osorio Hernández." + ANSI_RESET);
        do {
            try {
                menu();
                opcion = capturarOpcion();
                limpiarPantalla();
                bandera = evaluarOpcion(opcion, args);
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (bandera == true);
    }

    private static void menu() {
        System.out.println("Escoja el taller que desea ver");
        System.out.println("1. Taller #1");
        System.out.println("2. Taller #2");
        System.out.println("3. Taller #3");
        System.out.println("4. Taller #4");
        System.out.println("0. Salir del programa");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    private static boolean evaluarOpcion(int opcion, String[] args) throws IOException {
        switch (opcion) {
            case 1:
                MainTaller1.main(args);
                return true;
            case 2:
                MainTaller2.main(args);
                return true;
            case 3:
                MainTaller3.main(args);
                return true;
            case 4:
                MainTaller4.main(args);
                return true;
            case 0:
                return false;
            default:
                System.out.println(ANSI_RED + "Opción incorrecta, favor escoja el taller que desea ver!" + ANSI_RESET);
        }
        return true;
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
