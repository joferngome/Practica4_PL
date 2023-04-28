package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalizadorLexico {
    private int[] cadena;
    private AutomataFinito A;
    private int posActual;
    private Map<Integer, String> tokens;
    private List<Token> historico;
    /*El constructor dará valor a los atributos mediante los parámetros e inicializará el análisis léxico de la cadena, es decir, no hay nada en el histórico y .posActual = 0 */
/*Método esencial para hacer avanzar el análisis; su función es generar el siguiente token. No hay que olvidar que debe ser el más largo posible.
Hay que ser muy cuidadoso para evitar errores por final de cadena, transición a error, etc.*/

    public AnalizadorLexico(int[] cadena,AutomataFinito A, int posActual, Map<Integer,String> tokens, List<Token> historico){
        this.cadena=cadena;
        this.A=A;
        this.posActual=posActual;
        this.tokens=tokens;
        this.historico=historico;

    }

    public Token nextToken() {

        int posi = this.posActual;
        int estado = 0;
        int estadoFinal = -1;
        int posFinal = -1;
        while (posi < this.cadena.length && estado != -1) {
            estado = A.transicion(estado, cadena[posi]);

            if (A.esEstadoFinal(estado)) {
                posFinal = posi;
                estadoFinal = estado;
            }
            posi++;
        }

        String id = tokens.get(estadoFinal);
        Map<Integer, String> lexemas = new HashMap<Integer, String>();
        int j=0;
        for(int i=posActual; i<=posFinal;i++){
            lexemas.put(j,tokens.get(j));
            j++;
        }
        Token token = new Token(id, lexemas);
        this.posActual = posFinal + 1;

        return token;
    }

    public boolean hasMoreTokens(){


        int posi = this.posActual;
        int estado = 0;
        while (posi < this.cadena.length && estado != -1) {
            estado = A.transicion(estado, cadena[posi]);

            if (A.esEstadoFinal(estado)) {
                return true;
            }
            posi++;
        }
        return false;

    }

    public List<Token> getHistorico(){
        return this.historico;

    }

    public void nuevaCadena(int[] cadena){
        this.cadena=cadena;

    }

    public void reset(){
        this.historico.clear();
        this.posActual=0;

    }

    public void finalizarAnalisis(){
        Token t=nextToken();
        while(t!=null){
            t=nextToken();

        }
    }
    /*
    Método que informa de si quedan tokens por extraer (hasMoreTokens)

Método que proporciona el histórico de tokens
Método que reinicia el análisis (reset)
Método que cambia la cadena a analizar, reiniciando el análisis actual (nuevaCadena)
Método que proporciona todos los tokens, en vez de ir uno a uno (finalizarAnalisis)
     */




}
