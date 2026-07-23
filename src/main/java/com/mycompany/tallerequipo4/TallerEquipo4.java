/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tallerequipo4;

import java.util.Scanner;
import java.util.ArrayList;

public class TallerEquipo4 {

    static double hx = 35000;
    static double ds = 0.04;

    static ArrayList<String> nombres = new ArrayList<>();
    static ArrayList<String> cargos = new ArrayList<>();
    static ArrayList<Double> sueldos = new ArrayList<>();
    static ArrayList<Double> horas = new ArrayList<>();

    public static void main(String[] args) {
        inicio();
    }

    public static void inicio() {
        Scanner sc = new Scanner(System.in);
        char respuesta;

        do {
            System.out.println("Hola Nuevo empleado");

            System.out.println("Ingresa tu nombre:");
            nombres.add(sc.nextLine());

            System.out.println("Ingresa tu cargo:");
            cargos.add(sc.nextLine());

            System.out.println("Ingresa tu sueldo:");
            sueldos.add(sc.nextDouble());

            System.out.println("Ingresa tus horas extras trabajadas:");
            horas.add(sc.nextDouble());

            sc.nextLine();

            int i = nombres.size() - 1;

            proceso(sueldos.get(i), horas.get(i), i);

            System.out.println("¿Deseas ingresar otro empleado? s/n");
            respuesta = sc.nextLine().charAt(0);

        } while(respuesta == 's' || respuesta == 'S');

        sc.close();
    }

    public static void proceso(double sueldo, double horasTrabajadas, int indice) {

        double px = hx * horasTrabajadas;
        double porcentajeDescuento;

        if (sueldo >= 5000000) {
            porcentajeDescuento = 0.16;
        } else if (sueldo >= 3000000) {
            porcentajeDescuento = 0.10;
        } else {
            porcentajeDescuento = 0;
        }

        double valorDescuento = sueldo * porcentajeDescuento;

        double descuentoSeguridad = sueldo * ds;
        double descuentoTotal = valorDescuento + descuentoSeguridad;

        double salarioBruto = sueldo + px;
        double salarioNeto = salarioBruto - descuentoTotal;

        mostrarSueldos(indice, px, porcentajeDescuento, valorDescuento, descuentoTotal, salarioNeto);
    }

    public static void mostrarSueldos(int i, double px, double porDesc, double valDesc, double descuentot, double salarioneto) {

        System.out.println("\n--- RESULTADO EMPLEADO " + (i+1) + " ---");
        System.out.println("Empleado: " + nombres.get(i));
        System.out.println("Cargo: " + cargos.get(i));
        System.out.println("Sueldo base: " + sueldos.get(i));
        System.out.println("Pago horas extras: " + px);
        System.out.println("Descuento por sueldo: " + (porDesc * 100) + "% = " + valDesc);
        System.out.println("Descuento seguridad: " + ds);
        System.out.println("Descuento total: " + descuentot);
        System.out.println("Salario neto: " + salarioneto);
        System.out.println("--------------------------");
    }
}