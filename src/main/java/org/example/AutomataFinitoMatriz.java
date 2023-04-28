package org.example;

public class AutomataFinitoMatriz extends AutomataFinito {


    /* La transición se representa por una matriz. Las filas representan estados, las columnas letras. La entada (i, j) de la matriz será el estado alcanzado desde el estado ”i” si se recibe la letra “j”. Podemos poner un -1 para indicar error, esto es, no existe esa transición
     */
    private int [] [] matriz;
    //Constructores
// Implementación de la función de transición. Devuelve la correspondiente entrada de la matriz. Habrá que ser consecuente si se usa la “versión void”. */
    public int transicion (int estado, int letra){
        return this.matriz[estado][letra];

    }
    //Estos atributos son redundantes, puedo usar los .length de los atributos de las matrices
    public AutomataFinitoMatriz(int[][] matriz, int num, int alfabeto){
        super(num,alfabeto);
        this.matriz=matriz;

    }
}
