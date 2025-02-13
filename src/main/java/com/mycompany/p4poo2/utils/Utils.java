package com.mycompany.p4poo2.utils;

/**
 *
 * @author arnau
 */
public class Utils {
    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    
    public static boolean nifIsValid(String nif) {
        if (nif == null || nif.length() != 9) {
            return false; // El NIF debe tener exactamente 9 caracteres
        }

        char letra = Character.toUpperCase(nif.charAt(8)); // Obtener la última letra en mayúscula
        String numeros = nif.substring(0, 8);

        // Validar si son 8 números (formato DNI)
        if (numeros.matches("\\d{8}")) {
            int numeroDNI = Integer.parseInt(numeros);
            char letraCorrecta = LETRAS_DNI.charAt(numeroDNI % 23); // Calcular la letra correcta
            return letra == letraCorrecta; // Comparar la letra calculada con la dada
        }

        return false; // Si no son 8 números, no es un NIF válido
    }
}
