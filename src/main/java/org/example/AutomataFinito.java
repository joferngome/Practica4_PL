package org.example;

public abstract class AutomataFinito {
private int numEstados;
private boolean[] finales;


private int tamAlfabeto;
private int estActual;

//Clase autómata finito
//Constructores: sin finales (luego se pueden marcar) y con finales
public AutomataFinito (int num, int alfabeto){
    this.numEstados=num;
    this.tamAlfabeto=alfabeto;

}
public AutomataFinito (int num, int alfabeto, boolean [] finales){
    this.numEstados=num;
    this.tamAlfabeto=alfabeto;
    this.finales=finales;

}
//Otros métodos

public void marcarFinal(int estado){

    this.finales[estado] = Boolean.TRUE;


}
public void setFinales(boolean[] estadosFinales){
    this.finales=estadosFinales;


}
public int getNumEstados(){
    return this.numEstados;

}
public boolean[] getFinales(){
    return this.finales;


}
//Método observador para determinar si un estado es final
public boolean esEstadoFinal (int estado){
    if(estado==-1) {
        return false;

    }

    return this.finales[estado]==Boolean.TRUE;
    //si -1 dev false

}
/*Método de transición. Se puede pensar como método que informa del estado que se alcanza partiendo de un estado y recibiendo una entrada*/
public abstract int transicion (int estado, int letra);
/*Otra versión, pensando que una transición produce una modificación del estado actual del autómata. Resulta mejor como orientación a objetos, pero complica un poco nuestro uso. */
//NO ME GUSTA public abstract void transicion (int letra);


//La extensión de la transición a cadenas. Posible versión void si transición modifica el estado ??cierreTransicion (int estado, int cadena [])
//Método que informa si una cadena pertenece al lenguaje definido por el autómata

public int cierreTransicion(int estado, int cadena[]){
    int transi = estado;
    for(int j=0;j<cadena.length && transi!=-1;j++){
        transi = transicion(transi, cadena[j]);
    }
    return transi;

}

public boolean perteneceLenguaje(int cadena[]){

    int cierre =cierreTransicion(0,cadena);
    boolean[] fins = getFinales();
    if(cierre!=-1) return fins[cierre];
    return false;
}




}
