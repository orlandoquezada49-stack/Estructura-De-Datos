package NominaEmpleados;

import java.util.Arrays;

public class ArregloAdt<T> {
    private Object[] datos;
    private int tamaño;

    public ArregloAdt() {
    }

    public ArregloAdt(int tamaño) {
        this.tamaño = tamaño;
        this.datos = new Object[tamaño];
    }

    public ArregloAdt(Object[] datos, int tamaño) {
        this.datos = datos;
        this.tamaño = tamaño;
    }

    public Object[] getDatos() {
        return datos;
    }

    public void setDatos(Object[] datos) {
        this.datos = datos;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setItem(int indice, T valor) {
        if (indice >= 0 && indice < tamaño) {
            datos[indice] = valor;
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    public T getItem(int indice) {
        if (indice >= 0 && indice < tamaño) {
            return (T) datos[indice];
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    @Override
    public String toString() {
        return "ArregloAdt{" +
                "datos=" + Arrays.toString(datos) +
                ", tamaño=" + tamaño +
                '}';
    }
}