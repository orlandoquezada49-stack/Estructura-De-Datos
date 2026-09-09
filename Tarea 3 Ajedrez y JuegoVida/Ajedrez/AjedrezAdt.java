package Ajedrez;

import java.util.Arrays;

public class AjedrezAdt<T>{
    private Object[][] piezas;
    private int filas;
    private int columnas;

    public AjedrezAdt(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.piezas = new Object[filas][columnas];
    }

    public Object[][] getPiezas() {
        return piezas;
    }

    public void setPiezas(Object[][] piezas) {
        this.piezas = piezas;
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
        return "TableroAjedrez{" +
                "piezas=" + Arrays.toString(piezas) +
                ", filas=" + filas +
                ", columnas=" + columnas +
                '}';
    }
    public void setItem(int fila, int columna, T valor) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            piezas[fila][columna] = valor;
        } else {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
    }
    public T getItem(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return (T) piezas[fila][columna];
        } else {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
    }
}
