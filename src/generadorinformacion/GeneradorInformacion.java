package generadorinformacion;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class GeneradorInformacion {

    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\Cayalav\\Desktop\\prueba.txt";
        BufferedWriter out = null;
        long numerosGenerados;
        int numeroDigitos;
        int numeroCaracteres;
        BigInteger base = new BigInteger("10");
        BigInteger resultadoMaximo = new BigInteger("0");
        BigInteger resultadoMinimo = new BigInteger("0");
        String maximo;
        String minimo;

        Scanner sc = new Scanner(System.in);

        //Se encarga de limpiar el txt cada vez que se ejecuta
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();

        System.out.println("Bienvenido al Generador de numeros");
        System.out.println("¿Cuantos numeros desea generar?");
        numerosGenerados = sc.nextInt();
        System.out.println("¿Cuantos digitos desea generar por numero?");
        numeroDigitos = sc.nextInt();
        System.out.println("¿Cuantos caracteres desea que contenga cada palabra?");
        numeroCaracteres = sc.nextInt();

        //Control de exepciones
        while (numerosGenerados <= 0 || numeroDigitos <= 0) {
            System.out.println("Los numeros deben ser mayor a 0, intente nuevamente");
            System.out.println("¿Cuantos numeros desea generar?");
            numerosGenerados = sc.nextInt();
            System.out.println("¿Cuantos digitos desea generar por numero?");
            numeroDigitos = sc.nextInt();
            System.out.println("¿Cuantos caracteres desea que contenga el String?");
            numeroCaracteres = sc.nextInt();
        }

        resultadoMaximo = base.pow(numeroDigitos);
        resultadoMinimo = base.pow(numeroDigitos - 1);

        //control de excepcion en caso base
        if (numeroCaracteres == 1) {
            maximo = "10";
            minimo = "1";
        } else {
            maximo = "" + resultadoMaximo;
            minimo = "" + resultadoMinimo;
        }

        //System.out.println("Estos son los " + numerosGenerados + " numeros generados:");
        BigInteger bigInteger = new BigInteger(maximo);// Maximo limite
        BigInteger min = new BigInteger(minimo);// Minimo limite

        BigInteger bigInteger1 = bigInteger.subtract(min);
        Random rnd = new Random();
        int maxNumBitLength = bigInteger.bitLength();

        BigInteger aRandomBigInt;

        String salida;

        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "k", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String word = "";

        for (int i = 0; i < numerosGenerados; i++) {
            word = "";
            aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
            if (aRandomBigInt.compareTo(min) < 0) {
                aRandomBigInt = aRandomBigInt.add(min);
            }
            if (aRandomBigInt.compareTo(bigInteger) >= 0) {
                aRandomBigInt = aRandomBigInt.mod(bigInteger1).add(min);
            }

            //Escritura de datos
            salida = "" + aRandomBigInt;
            try {
                out = new BufferedWriter(new FileWriter(file, true));
                out.write(salida);
                //out.newLine();
            } catch (IOException e) {
                System.out.println("Hubo un error: " + e.getMessage());
                // error processing code   
            } finally {
                if (out != null) {
                    out.close();
                }
            }

            //Generador de letras
            int numRandon = 1;
            for (int j = 0; j < numeroCaracteres; j++) {
                numRandon = (int) Math.round(Math.random() * 51);
                word = abecedario[numRandon] + word;
            }

            try {
                out = new BufferedWriter(new FileWriter(file, true));
                out.write(";" + word);
                out.write(";" + numRandon);
                out.newLine();
            } catch (IOException e) {
                System.out.println("Hubo un error: " + e.getMessage());
                // error processing code   
            } finally {
                if (out != null) {
                    out.close();
                }
            }

        }
    }

}