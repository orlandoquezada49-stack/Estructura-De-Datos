package Ajedrez;

public class TableroAjedrez {
    public static void main(String[] args) {
        AjedrezAdt<String> tablero = new AjedrezAdt<>(8, 8);

        String[] piezasSuperiores = {
                "\u265C", "\u265E", "\u265D", "\u265B", "\u265A", "\u265D", "\u265E", "\u265C"
        };
        String[] peonesNegros = {
                "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F", "\u265F"
        };
        String[] peonesBlancos = {
                "\u2659", "\u2659", "\u2659", "\u2659", "\u2659", "\u2659", "\u2659", "\u2659"
        };
        String[] piezasInferiores = {
                "\u2656", "\u2658", "\u2657", "\u2655", "\u2654", "\u2657", "\u2658", "\u2656"
        };

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {
                String pieza = " ";
                if (i == 0) pieza = piezasSuperiores[j];
                else if (i == 1) pieza = peonesNegros[j];
                else if (i == 6) pieza = peonesBlancos[j];
                else if (i == 7) pieza = piezasInferiores[j];

                tablero.setItem(i, j, pieza);
            }
        }

        int Numerofila = 8;
        for (int i = 0; i < tablero.getFilas(); i++) {

            System.out.print(Numerofila + "  ");

            for (int j = 0; j < tablero.getColumnas(); j++) {
                System.out.print(tablero.getItem(i, j) + "   ");
            }
            System.out.println();
            Numerofila--;
        }
    }
}