/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java_cup.runtime.Symbol;

/**
 *
 * @author jhonny
 */
public class ErrorDatas {

    private ArrayList<ErrorLexico> listaErrores;

    public ArrayList<ErrorLexico> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(ArrayList<ErrorLexico> listaErrores) {
        this.listaErrores = listaErrores;
    }

    public String getLetterId() {
        return letterId;
    }

    public int getFil() {
        return fil;
    }

    public int getCol() {
        return col;
    }

    protected final String letterId;
    protected  int fil, col;
    private ArrayList<ErrorSintatico> listaDeErrores;

    public ErrorDatas(String letterId, int fil, int col) {
        this.letterId = letterId;
        this.fil = fil;
        this.col = col;
    }

    public ErrorDatas() {
        this.letterId = "";
        this.fil = 0;
        this.col = 0;

    }

    public ErrorDatas(ArrayList<ErrorSintatico> listaDeErrores) {
        this.listaDeErrores = listaDeErrores;
        this.letterId = "";
        this.fil = 0;
        this.col = 0;
    }

    public ArrayList<ErrorSintatico> getListaDeErrores() {
        return listaDeErrores;
    }



    public void arreglarErroresSintaticos() {
        for (int i = 0; i < this.listaDeErrores.size(); i++) {
            ErrorSintatico er =  this.listaDeErrores.get(i);
            if (er.isSymbolEmpty()) {
                for (int j = 0; j < this.listaDeErrores.size(); j++) {
                    ErrorSintatico er2 =  this.listaDeErrores.get(j);
                    if (!er2.isSymbolEmpty()) {
                        if(er2.getS().left==er.getFil()){
                        er.setToken((String) er2.getS().value);
                        this.listaDeErrores.set(i, er);
                        this.listaDeErrores.remove(j);
                        break;
                        }
                    }
                }
            }
        }
    }

}
