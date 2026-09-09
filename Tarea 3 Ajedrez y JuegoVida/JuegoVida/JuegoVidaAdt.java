package JuegoVida;

import java.util.Arrays;

public class JuegoVidaAdt<T> {
    private Object[][] matriz;
    private int filas;
    private int columnas;

    public JuegoVidaAdt() {
    }

    // <-- ESTE ES EL CONSTRUCTOR QUE HACE QUE FUNCIONE TU LÍNEA -->
    public JuegoVidaAdt(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new Object[filas][columnas];
    }

    public JuegoVidaAdt(Object[][] matriz, int filas, int columnas) {
        this.matriz = matriz;
        this.filas = filas;
        this.columnas = columnas;
    }

    public Object[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Object[][] matriz) {
        this.matriz = matriz;
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
        return "JuegoVidaAdt{" +
                "matriz=" + Arrays.toString(matriz) +
                ", filas=" + filas +
                ", columnas=" + columnas +
                '}';
    }

    public void setItem(int fila, int columna, T valor) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            matriz[fila][columna] = valor;
        } else {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
    }


    public T getItem(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return (T) matriz[fila][columna];
        } else {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
    }
}