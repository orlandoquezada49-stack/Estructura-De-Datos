package JuegoVida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoVida<T> {
    private JuegoVidaAdt<T> tableroActual;
    private int filas;
    private int columnas;

    public JuegoVida() {
    }

    public JuegoVida(String rutaCsv, int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.tableroActual = new JuegoVidaAdt<T>(filas, columnas);
        leerCsv(rutaCsv);
    }


    public JuegoVidaAdt<T> getTableroActual() {
        return tableroActual;
    }

    public void setTableroActual(JuegoVidaAdt<T> tableroActual) {
        this.tableroActual = tableroActual;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String toString() {
        return "JuegoVida{" +
                "tableroActual=" + tableroActual +
                ", filas=" + filas +
                ", columnas=" + columnas +
                '}';
    }
    private void leerCsv(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null && fila < filas) {
                String[] valores = linea.split(",");
                for (int col = 0; col < valores.length && col < columnas; col++) {
                    T val = (T) (Integer) Integer.parseInt(valores[col].trim());
                    tableroActual.setItem(fila, col, val);
                }
                fila++;
            }
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo csv: " + e.getMessage());
        }
    }

    public void calcularSiguienteGeneracion() {

        JuegoVidaAdt<T> siguienteTablero = new JuegoVidaAdt<T>(filas, columnas);

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {

                int vecinos = contarVecinosVivos(i, j);
                int vivo = (tableroActual.getItem(i, j) != null && (Integer) tableroActual.getItem(i, j) == 1) ? 1 : 0;

                int nuevoEstado = 0;
                if (vivo == 1 && (vecinos == 2 || vecinos == 3)) {
                    nuevoEstado = 1;
                } else if (vivo == 0 && vecinos == 3) {
                    nuevoEstado = 1;
                }

                siguienteTablero.setItem(i, j, (T) (Integer) nuevoEstado);
            }
        }
        tableroActual = siguienteTablero;
    }

    private int contarVecinosVivos(int numFila, int numColumna) {
        int contador = 0;

        for (int i = -1; i <= 1; i++) {

            for (int j = -1; j <= 1; j++) {

                if (i == 0 && j == 0) continue;
                int fil = numFila + i;
                int columna = numColumna + j;

                if (fil >= 0 && fil < filas && columna >= 0 && columna < columnas) {
                    T val = tableroActual.getItem(fil, columna);
                    if (val != null && (Integer) val == 1) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public void ImprimirTablero(int gen) {

        System.out.println("Generación " + gen );

        for (int i = 0; i < filas; i++) {

            for (int j = 0; j < columnas; j++) {
                T val = tableroActual.getItem(i, j);
                int estado = (val != null) ? (Integer) val : 0;
                System.out.print((estado == 1 ? "1" : ".") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}