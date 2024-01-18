package com.example.hlc_tarea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.00;
        int opcion;
        double cantidad;

        do {
            System.out.println("1- Retirar fondos");
            System.out.println("2- Ingresar fondos");
            System.out.println("0- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    cantidad = scanner.nextDouble();
                    if (cantidad > saldo) {
                        System.out.println("No hay suficiente saldo. Su saldo actual es de " + saldo + "€.");
                    } else {
                        saldo -= cantidad;
                        System.out.println("Retiro exitoso. Su saldo actual es de " + saldo + "€.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    cantidad = scanner.nextDouble();
                    saldo += cantidad;
                    System.out.println("Depósito exitoso. Su saldo actual es de " + saldo + "€.");
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestro cajero automático.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
