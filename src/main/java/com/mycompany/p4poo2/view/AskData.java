package com.mycompany.p4poo2.view;

import java.util.InputMismatchException;
import java.util.Scanner;



/**
 *
 * @author arnau
 */
public class AskData {
    private Scanner scanner;
    
    public AskData() {
        scanner = new Scanner(System.in);
    }
    
    /*Método para pedir una cadena
     *Método que recibe un mensaje a mostrar al pedir el dato al usuario
     *devuelve un Strig con la respuesta*/

    public String askString(String msg) {
        scanner.nextLine();
        System.out.println(msg);
        String answer = "";
        answer = scanner.nextLine();
        while (answer.isEmpty()) {
            System.out.println("No puedes dejar la respuesta en blanco");
            answer = scanner.nextLine();
        }
        return answer;
    }
    
    
    
    // Método que recibe un mensaje a mostrar al pedir el dato al usuario
    // devuelve un número entero introducido por el usuario
    public int askInt(String msg) {
        int n = 0;
        boolean error = false;
        do {
            try {
                System.out.print(msg);
                n = scanner.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Tienes que poner un número entero");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        return n;
    }
    
    
    // Método para pedir un entero con un min
    // Recibe Mensaje para mostrar al usuario
    // recibe mensaje de error al mostrar si el número no cumple mínimo
    // recibe un int como valor mínimo
    // devuelve un entero mayor o igual que el mínimo

    public int askInt(String msg, String errorMsg, int min) {
        int n = askInt(msg);
        while (n < min) {
            System.out.println(errorMsg);
            n = askInt(msg);
        }
        return n;
    }
    
    
    // Método análogo al anterior pero con min y max

    public int askInt(String msg, String errorMsg, int min, int max) {
        int n = askInt(msg);
        while (n < min || n > max) {
            System.out.println(errorMsg);
            n = askInt(msg);
        }
        return n;
    }
    
    public double askDouble(String msg) {
        double n = 0;
        boolean error = false;
        do {
            try {
                System.out.print(msg);
                n = scanner.nextDouble();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Tienes que poner un número entero");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        return n;
    }
    
    public double askDouble(String msg, String errorMsg, double min) {
        double n = askDouble(msg);
        while (n < min) {
            System.out.println(errorMsg);
            n = askDouble(msg);
        }
        return n;
    }
    
    public double askDouble(String msg, String errorMsg, double min, double max) {
        double n = askDouble(msg);
        while (n < min || n > max) {
            System.out.println(errorMsg);
            n = askDouble(msg);
        }
        return n;
    }
    
}
