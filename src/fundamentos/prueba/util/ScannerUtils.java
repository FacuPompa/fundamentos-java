package fundamentos.prueba.util;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static String capturarTexto(String mensaje) {
        System.out.println(mensaje +": ");
        return scanner.nextLine();
    }

    public static int capturarNumero(String mensaje) {
        System.out.println(mensaje + ": ");

        int dato = scanner.nextInt();
        scanner.nextLine(); //Descarta el Enter del usuario
        return dato;
    }

    public static double capturarDecimal(String mensaje) {
        System.out.println(mensaje + ": ");

        double dato = scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }
}
