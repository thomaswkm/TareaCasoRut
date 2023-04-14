import java.util.Scanner;

public class ValidadorRutGPT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un RUT sin dígito verificador (ejemplo: 12345678): ");
        String rutString = scanner.nextLine();
        scanner.close();

        try {
            int rut = Integer.parseInt(rutString);
            int verifierDigit = calculateVerifierDigit(rut);
            System.out.println("El dígito verificador es: " + verifierDigit);
        } catch (NumberFormatException e) {
            System.out.println("El RUT ingresado no es válido.");
        }
    }

    public static int calculateVerifierDigit(int rut) {
        // Convertir el RUT a una cadena y revertirla
        String rutStr = new StringBuilder(String.valueOf(rut)).reverse().toString();

        // Multiplicar cada dígito por la secuencia 2, 3, 4, 5, 6, 7, 2, 3, 4...
        int sum = 0;
        for (int i = 0, j = 2; i < rutStr.length(); i++, j++) {
            if (j == 8) {
                j = 2;
            }
            int digit = Character.getNumericValue(rutStr.charAt(i));
            sum += digit * j;
        }

        // Calcular el dígito verificador
        int remainder = sum % 11;
        int verifierDigit = 11 - remainder;
        if (verifierDigit == 10) {
            verifierDigit = 'K'; // K es el dígito verificador para 10
        } else if (verifierDigit == 11) {
            verifierDigit = 0; // 0 es el dígito verificador para 11
        }
        return verifierDigit;
    }
}
