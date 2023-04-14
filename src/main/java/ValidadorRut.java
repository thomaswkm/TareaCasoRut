import java.util.Scanner;

public class ValidadorRut {

    public static void main(String[] args){
        inicio();
    }

    public static void inicio(){
        try {
            System.out.println(devolverOperacionOcho(formatearRut(ingresarRut())));
        }catch (Exception e){
            System.out.println("El rut no es válido");
            inicio();
        }
    }

    public static String ingresarRut() throws Exception {
        Scanner sc = new Scanner(System.in);
        String rut = sc.nextLine();
        if (!rut.matches("[0-9]{7,8}[Kk0-9]{1}")) {
            throw new Exception("El formato del RUT no es válido");
        }
        return rut;
    }

    public static String formatearRut(String rut){
        return invertirRut(quitarDigitoVerificador(quitarGuion(quitarPuntos(rut))));
    }

    public static String quitarPuntos(String rut){
        return rut.replace(".", "");
    }
    public static String quitarGuion(String rut){
        return rut.replace("-","");
    }

    public static String invertirRut(String rut){
        return new StringBuilder(rut).reverse().toString();
    }

    public static String quitarDigitoVerificador(String rut){
        return rut.substring(0,rut.length()-1);
    }

    public static int[] convertirDigitosAArregloEnteros(String rut){
        int[] digitos = new int[rut.length()];
        for (int i = 0; i < rut.length(); i++) {
            digitos[i] = Integer.parseInt(Character.toString(rut.charAt(i)));
        }
        return digitos;
    }

    public static int[] devolverOperacionCuatro(String rut){
        int[] digitos = convertirDigitosAArregloEnteros(rut);
        int factor = 2;
        for (int i = 0; i < digitos.length; i++) {
            digitos[i] = digitos[i]*factor;
            factor++;
            if(factor>7){
                factor = 2;
            }
        }
        return digitos;
    }

    public static int sumaMultiplicaciones(String rut){
        int[] numeros = devolverOperacionCuatro(rut);
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }
        return suma;
    }

    public static double devolverOperacionCinco(String rut){
        int suma = sumaMultiplicaciones(rut);
        return (double)(suma)/11;
    }

    public static int devolverOperacionSeis(String rut){
        int n = (int)(devolverOperacionCinco(rut));
        return n*11;
    }

    public static int devolverOperacionSiete(String rut){
        return Math.abs(sumaMultiplicaciones(rut) - devolverOperacionSeis(rut));
    }

    public static String devolverOperacionOcho(String rut){
        if(11-devolverOperacionSiete(rut)>=0 && 11-devolverOperacionSiete(rut)<10){
            return "Digito Verificador: "+Integer.toString(11-devolverOperacionSiete(rut));
        }else if (11-devolverOperacionSiete(rut)==10){
            return "Digito Verificador: k";
        } else if (11-devolverOperacionSiete(rut)==11) {
            return "Digito Verificador: 0";
        }
        return "";
    }

}
