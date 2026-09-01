package NominaEmpleados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Sueldos {
    public static void main(String[] args) {
        int fechaActual = 2026;
        String archivo = "junio.dat";

        List<String> lineasArchivo = new ArrayList<>();

        try (BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean linea1 = true;

            while ((linea = leerArchivo.readLine()) != null) {
                if (linea1) {
                    linea1 = false;
                    continue;
                }
                lineasArchivo.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se puede leer los datos");
            return;
        }

        ArregloAdt<Empleado> nomina = new ArregloAdt<>(lineasArchivo.size());

        for (int i = 0; i < lineasArchivo.size(); i++) {
            String[] datos = lineasArchivo.get(i).split(",");

            int numTrabajador = Integer.parseInt(datos[0].trim());
            String nombres = datos[1].trim();
            String paterno = datos[2].trim();
            String materno = datos[3].trim();
            int horasExtra = Integer.parseInt(datos[4].trim());
            double sueldoBase = Double.parseDouble(datos[5].trim());
            int fechaIngreso = Integer.parseInt(datos[6].trim());
            nomina.setItem(i, new Empleado(numTrabajador, nombres, paterno, materno, horasExtra, sueldoBase, fechaIngreso));
        }

        if (nomina.getTamaño() > 0) {
            Empleado mayorAntiguedad = nomina.getItem(0);
            Empleado menorAntiguedad = nomina.getItem(0);

            System.out.println("Nomina");
            for (int i = 0; i < nomina.getTamaño(); i++) {
                Empleado actual = nomina.getItem(i);

                System.out.println(actual.toString());

                if (actual.getFechaIngreso() < mayorAntiguedad.getFechaIngreso()) {
                    mayorAntiguedad = actual;
                }
                if (actual.getFechaIngreso() > menorAntiguedad.getFechaIngreso()) {
                    menorAntiguedad = actual;
                }
            }

            System.out.println("\n Antiguedad");
            String nombreMayor = mayorAntiguedad.getNombres() + " " + mayorAntiguedad.getPaterno() + " " + mayorAntiguedad.getMaterno();
            String nombreMenor = menorAntiguedad.getNombres() + " " + menorAntiguedad.getPaterno() + " " + menorAntiguedad.getMaterno();

            System.out.println("El empleado con mas antigüedad es: " + nombreMayor + " con " + mayorAntiguedad.CalcularAntiguedad(fechaActual) + " años");
            System.out.println("El trabajador con menor antiguedad es: " + nombreMenor + " con " + menorAntiguedad.CalcularAntiguedad(fechaActual) + " años");
        }
    }
}