package JuegoVida;

public class Pruebas {
    public static void main(String[] args) {
        String rutaArchivo = "juegovida.csv";
        int generacionesTotales = 10;

        JuegoVida juego = new JuegoVida(rutaArchivo, 10, 10);
        juego.ImprimirTablero(0);

        for (int g = 1; g <= generacionesTotales; g++) {
            juego.calcularSiguienteGeneracion();
            juego.ImprimirTablero(g);
        }
    }
}
