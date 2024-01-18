package com.example.hlc_tarea;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.00;
        int opcion;
        double cantidad;
        String movimiento;
        List<String> movimientos = new ArrayList<>();

        try {
            File file = new File("movimientos.txt");
            if (file.exists()) {
                movimientos = Files.readAllLines(Paths.get("movimientos.txt"));
                for (String mov : movimientos) {
                    System.out.println(mov);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo 'movimientos.txt'.");
        }

        do {
            System.out.println("1- Retirar fondos");
            System.out.println("2- Ingresar fondos");
            System.out.println("3- Consulta de movimientos");
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
                        movimiento = "Retiro de " + cantidad + "€. Saldo actual: " + saldo + "€.";
                        movimientos.add(movimiento);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    cantidad = scanner.nextDouble();
                    saldo += cantidad;
                    System.out.println("Depósito exitoso. Su saldo actual es de " + saldo + "€.");
                    movimiento = "Depósito de " + cantidad + "€. Saldo actual: " + saldo + "€.";
                    movimientos.add(movimiento);
                    break;
                case 3:
                    System.out.println("Movimientos:");
                    for (String mov : movimientos) {
                        System.out.println(mov);
                    }
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestro cajero automático.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }

            try {
                FileWriter fileWriter = new FileWriter("movimientos.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                for (String mov : movimientos) {
                    printWriter.println(mov);
                }
                printWriter.close();
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo 'movimientos.txt'.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
