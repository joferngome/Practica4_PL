package org.example;

import java.util.Map;

public class Token {

    //En realidad l estamos llamando token a la pareja (token, lexema)
    private String idToken;
//Para el lexema se puede usar un vector de enteros, List de entero,….
    private Map<Integer,String> lexema;
    public Token(String id, Map<Integer, String> lexema) {}
    public String getId() {
        return this.idToken;
    }
    public Map<Integer,String> getLexema() {
        return this.lexema;

    }

}
