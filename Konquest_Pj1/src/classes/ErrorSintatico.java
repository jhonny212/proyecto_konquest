/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java_cup.runtime.Symbol;

/**
 *
 * @author jhonny
 */
public class ErrorSintatico extends ErrorDatas {

    private final String solucion;
    private final Symbol s;
    private final boolean isRecuperable;
    private String token;

    public ErrorSintatico(String letterId, int fil, int col, String solucion, boolean isRecuperable) {
        super(letterId, fil, col);
        this.solucion = solucion;
        this.isRecuperable = isRecuperable;
        s = null;
        token = "";
    }

    public ErrorSintatico(Symbol s, String solucion, boolean isRecuperable) {
        this.s = s;
        this.solucion = solucion;
        this.isRecuperable = isRecuperable;
        token = (String) s.value;
        this.fil=s.left;
        this.col=s.right;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

  

    public String getSolucion() {
        return solucion;
    }

  

    public Symbol getS() {
        return s;
    }

    public boolean isSymbolEmpty() {
        if (this.s == null) {
            return true;
        } else {
            return false;
        }
    }

}
