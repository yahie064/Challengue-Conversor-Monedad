import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        while (true) {
            System.out.println("**** Conversor de Monedas ****");
            System.out.println("1. USD a ARS");
            System.out.println("2. BRL a USD");
            System.out.println("3. EUR a MXN");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 4) {
                System.out.println("¡Hasta luego!");
                break;
            }

            System.out.print("Ingresa la cantidad: ");
            double cantidad = scanner.nextDouble();

            try {
                double resultado = 0;
                switch (opcion) {
                    case 1 -> resultado = conversor.convertir("USD", "ARS", cantidad);
                    case 2 -> resultado = conversor.convertir("BRL", "USD", cantidad);
                    case 3 -> resultado = conversor.convertir("EUR", "MXN", cantidad);
                    default -> System.out.println("Opción inválida");
                }
                System.out.printf("Resultado: %.2f%n", resultado);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}