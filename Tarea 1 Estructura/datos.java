package RedesSociales;

import java.io.*;
import java.util.Scanner;

public class datos {
    public static void main(String[] args) {
        File archivocsv = new File("C:\\Users\\queza\\Downloads\\datos.csv");

        double twtEnerofoll = 0, twtJuniofoll = 0;
        double[] ytVistas = new double[6];
        double crecimientoTwt = 0, crecimientoFB = 0;
        double likesYT = 0, likesTWT = 0, likesFB = 0;

        try (BufferedReader leercsv = new BufferedReader(new InputStreamReader(new FileInputStream(archivocsv)))) {
            String linea;
            leercsv.readLine(); // Saltar la cabecera

            while ((linea = leercsv.readLine()) != null) {

                linea = linea.replace("\"65,41\"", "65410");
                linea = linea.replace("\"", "");

                String[] palabra = linea.split(",");
                String red = palabra[0].trim();
                String concepto = palabra[1].trim();

                // Diferencia de seguidores en TWT enero y junio
                if (red.equals("TWITTER") && concepto.contains("SEGUIDORES")) {
                    twtEnerofoll = Double.parseDouble(palabra[3].trim()); // Enero
                    twtJuniofoll = Double.parseDouble(palabra[8].trim()); // Junio
                }

                // Diferencia de Vistas YT
                if (red.equals("YOUTUBE") && concepto.contains("VISUALIZACIONES")) {
                    for (int i = 0; i < 6; i++) {
                        ytVistas[i] = Double.parseDouble(palabra[i + 3].trim());
                    }
                }

                //  Crecimiento de seguidores twt
                if (red.equals("TWITTER") && concepto.contains("CRECIMIENTO DE FOLLOWERS")) {
                    for (int i = 3; i <= 8; i++) {
                        crecimientoTwt += Double.parseDouble(palabra[i].trim());
                    }
                }

                // Crecimiento de seguidores Fb
                if (red.equals("FACEBOOK") && concepto.equals("CRECIMIENTO (seguidores)")) {
                    for (int i = 3; i <= 8; i++) {
                        crecimientoFB += Double.parseDouble(palabra[i].trim());
                    }
                }

                // Likes de los 3
                if (red.equals("YOUTUBE") && concepto.contains("ME GUSTA")) {
                    for (int i = 3; i <= 8; i++) {
                        likesYT += Double.parseDouble(palabra[i].trim());
                    }
                }
                if (red.equals("TWITTER") && concepto.equals("ME GUSTA")) {
                    for (int i = 3; i <= 8; i++) {
                        likesTWT += Double.parseDouble(palabra[i].trim());
                    }
                }
                if (red.equals("FACEBOOK") && concepto.contains("ME GUSTA")) {
                    for (int i = 3; i <= 8; i++) {
                        likesFB += Double.parseDouble(palabra[i].trim());
                    }
                }
            }

            System.out.println("1- Diferencia de followers en Twitter Enero y Junio");
            System.out.println("Diferencia es de : " + (twtJuniofoll - twtEnerofoll) + " seguidores\n");


            Scanner leervistas = new Scanner(System.in);
            System.out.println(" 2-Diferencia de vistas en Youtube ");
            System.out.println("1-Enero, 2-Febrero, 3-Marzo, 4-Abril, 5-Mayo, 6-Junio");
            System.out.print("Ingrese el número del primer mes: ");
            int mes1 = leervistas.nextInt() - 1;
            System.out.print("Ingrese el número del segundo mes: ");
            int mes2 = leervistas.nextInt() - 1;

            if (mes1 >= 0 && mes1 < 6 && mes2 >= 0 && mes2 < 6) {
                double difVistas = Math.abs(ytVistas[mes2] - ytVistas[mes1]);
                System.out.println("Diferencia de visualizaciones es de: " + difVistas + "\n");
            } else {
                System.out.println("Mes no válido.\n");
            }


            System.out.println("3- Promedio del crecimiento de seguidores Twitter y Facebook de Enero a Junio");
            System.out.println("Promedio de seguidores en Twitter: " + (crecimientoTwt / 6.0));
            System.out.println("Promedio de seguidores en Facebook: " + (crecimientoFB / 6.0) + "\n");

            // Punto D: Promedio de Me Gusta
            System.out.println("4- Promedio de likes en Youtube,Twitter y Facebook");
            System.out.println("Promedio de likes en YouTube: " + (likesYT / 6.0));
            System.out.println("Promedio de likes en Twitter: " + (likesTWT / 6.0));
            System.out.println("Promedio de likes en Facebook: " + (likesFB / 6.0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}