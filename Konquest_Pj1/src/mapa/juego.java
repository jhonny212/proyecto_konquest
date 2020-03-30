/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import classes.ErrorLexico;
import classes.ErrorSintatico;
import java.util.ArrayList;
import jugadores.jugador;
import planetas.planeta_jugador;
import planetas_neutral.planeta_neutral;

/**
 *
 * @author jhonny
 */
public class juego {

    public ArrayList<ErrorLexico> getListaDeErroresLexicos() {
        return listaDeErroresLexicos;
    }

    public void setListaDeErroresLexicos(ArrayList<ErrorLexico> listaDeErroresLexicos) {
        this.listaDeErroresLexicos = listaDeErroresLexicos;
    }

    private mapa mapa;
    private ArrayList<jugador> array_jugadores;
    private ArrayList<planeta_neutral> array_neutrales;
    private ArrayList<planeta_jugador> planetas;
    private ArrayList<ErrorSintatico> listaDeErroresSintaticos;
    private ArrayList<ErrorLexico> listaDeErroresLexicos;
    

    private boolean validarJuego;
    private String msj;

    public juego(mapa mapa, ArrayList<jugador> array_jugadores, ArrayList<planeta_neutral> array_neutrales, ArrayList<planeta_jugador> planetas) {
        this.mapa = mapa;
        this.array_jugadores = array_jugadores;
        this.array_neutrales = array_neutrales;
        this.planetas = planetas;
        validarJuego = true;
        listaDeErroresSintaticos=new ArrayList();

    }

    public ArrayList<planeta_jugador> getPlanetas() {
        return planetas;
    }

    public ArrayList<ErrorSintatico> getListaDeErroresSintaticos() {
        return listaDeErroresSintaticos;
    }

    public void setListaDeErroresSintaticos(ArrayList<ErrorSintatico> listaDeErroresSintaticos) {
        this.listaDeErroresSintaticos = listaDeErroresSintaticos;
    }
    

    public void setiniciales() {
        for (int i = 0; i < array_neutrales.size(); i++) {
            array_neutrales.get(i).setInicial(array_neutrales.get(i).getNaves());

        }

        for (int i = 0; i < planetas.size(); i++) {
            planetas.get(i).setInicial(planetas.get(i).getNaves());

        }

    }

    public void setPlanetas(ArrayList<planeta_jugador> planetas) {
        this.planetas = planetas;
    }

    public mapa getMapa() {
        return mapa;
    }

    public void setMapa(mapa mapa) {
        this.mapa = mapa;
    }

    public ArrayList<jugador> getArray_jugadores() {
        return array_jugadores;
    }

    public void setArray_jugadores(ArrayList<jugador> array_jugadores) {
        this.array_jugadores = array_jugadores;
    }

    public ArrayList<planeta_neutral> getArray_neutrales() {
        return array_neutrales;
    }

    public void setArray_neutrales(ArrayList<planeta_neutral> array_neutrales) {
        this.array_neutrales = array_neutrales;
    }

    public void validarCantidades() {
        validarJuego = true;
        int x = mapa.getPlanetasNeutrales();
        int y = this.array_neutrales.size();
        if (x != y) {
            validarJuego = false;
            msj = "La declaracion de planetas neutrales son " + x + " mientras \n solo se tienen" + y + " declarados";
        }
    }

    public void validarDimensiones() {
        int total = 0;
        try{
             total=(int) (mapa.getTamaño().getHeight() * mapa.getTamaño().getWidth());
        }catch( NullPointerException e){};
        validarJuego = true;
        if (total <= mapa.getPlanetasNeutrales() + planetas.size()) {
            msj = "La cantidad de planetas neutrales es demasiado \n"
                    + "Disponibilidad:" + total + " cantidad de neutrales:" + mapa.getPlanetasNeutrales() + "\n"
                    + "cantidad de planetas (Jugadores):" + planetas.size();
            validarJuego = false;
        } else {
            String names = "";
            ArrayList<String> list = new ArrayList();
            ArrayList<String> list2 = new ArrayList();
            System.out.println(array_jugadores.size() + " --------------->");

            for (int i = 0; i < array_jugadores.size(); i++) {

                ArrayList<planeta_jugador> planetas_ = array_jugadores.get(i).getPlanetas();
                for (int j = 0; j < planetas_.size(); j++) {
                    list2.add(planetas_.get(j).getNombre());
                }
                array_jugadores.get(i).validar();
                if (!array_jugadores.get(i).isValidarJuego()) {
                    msj += array_jugadores.get(i).getMsj();
                    break;
                }
                if (names.contains(array_jugadores.get(i).getJugador())) {
                    msj += " No se puede repetir un mismo jugador \n";
                    validarJuego = false;
                    break;
                } else {
                    names += array_jugadores.get(i).getJugador() + " ";
                }

            }

            //seccion donde se verifuca que  no se repita el nombre de un neutral
            ArrayList<String> list3 = new ArrayList();

            for (int i = 0; i < array_neutrales.size(); i++) {
                for (int j = 0; j < list3.size(); j++) {
                    if (array_neutrales.get(i).getNombre().equals(list3.get(j))) {
                        msj = " No se puede repetir un mismo planeta neutral";
                        validarJuego = false;
                        break;
                    } else {
                        list3.add(array_neutrales.get(i).getNombre());
                    }
                }
            }
            //termina seccion

            /*
       *seccion donde se verifica que no se repitan los planetas
             */
            for (int i = 0; i < planetas.size(); i++) {
                list.add(planetas.get(i).getNombre());
                for (int j = 0; j < list3.size(); j++) {
                    if (planetas.get(i).getNombre().equals(list3.get(j))) {
                        msj = " Tiene un planeta repetido verifique en planeta de jugadores o planetas neutrales " + planetas.get(i).getNombre();
                        validarJuego = false;
                        break;
                    } else {
                        list3.add(planetas.get(i).getNombre());
                    }
                }

            }

            if (validarJuego) {
                int count = 0;
                if (list.size() == list2.size()) {
                    System.out.println("entra");
                    for (int i = 0; i < list.size(); i++) {
                        for (int j = 0; j < list2.size(); j++) {
                            if (list.get(i).equals(list2.get(j))) {
                                count++;
                                break;
                            }

                        }

                    }
                    if (!(count == list.size())) {
                        msj = " Existen valores repetidos, Verifique la declaracion de planetas con cada asignacion de planetas "
                                + "\n destinados a los jugadores.";
                        validarJuego = false;
                    }
                } else {
                    System.out.println(count + " " + list.size() + " " + list2.size());
                    msj = "Verifique la declaracion de planetas con cada asignacion de planetas \n destinados a los jugadores. \n "
                            + "la cantidad no es la misma ";
                    validarJuego = false;
                }
            }

        }

    }

    public void voidValidarTodos() {
        validarDimensiones();
        if (validarJuego) {
            validarCantidades();
        }
    }

    public boolean isValidarJuego() {
        return validarJuego;
    }

    public String getMsj() {
        return msj;
    }

    public void validarDimensiones(String string) {
        //seccion donde se verifuca que  no se repita el nombre de un neutral
        validarJuego = true;

        ArrayList<String> list = new ArrayList();
        ArrayList<String> list3 = new ArrayList();

        for (int i = 0; i < array_neutrales.size(); i++) {
            for (int j = 0; j < list3.size(); j++) {
                if (array_neutrales.get(i).getNombre().equals(list3.get(j))) {
                    msj = " No se puede repetir un mismo planeta neutral";
                    validarJuego = false;
                    break;
                } else {
                    list3.add(array_neutrales.get(i).getNombre());
                }
            }
        }
        //termina seccion

        /*
       *seccion donde se verifica que no se repitan los planetas
         */
        for (int i = 0; i < planetas.size(); i++) {
            list.add(planetas.get(i).getNombre());
            for (int j = 0; j < list3.size(); j++) {
                if (planetas.get(i).getNombre().equals(list3.get(j))) {
                    msj = " Tiene un planeta repetido verifique en planeta de jugadores o planetas neutrales " + planetas.get(i).getNombre();
                    validarJuego = false;
                    break;
                } else {
                    list3.add(planetas.get(i).getNombre());
                }
            }

        }

    }

    public void configurarNeutrales() {
        for (int i = 0; i < this.getArray_neutrales().size(); i++) {
            if (this.getArray_neutrales().get(i).getProduccion() == mapa.getNeutral().getProduccion()) {
                this.getArray_neutrales().get(i).setProduc(true);

            }
        }
    }

    public void iniciarNeutrales() {
        if (this.getMapa().isAzar()) {
            ArrayList<planeta_neutral> list = new ArrayList();
            ArrayList<String> names = new ArrayList();
            planeta_neutral tmp = new planeta_neutral();
            boolean v = true;
            for (int i = 0; i < this.getMapa().getPlanetasNeutrales(); i++) {
                tmp = tmp.planetaAleatorio((int) ((mapa.getTamaño().getHeight()) * (mapa.getTamaño().getWidth())));
                v = true;
                for (int j = 0; j < names.size(); j++) {
                    if (tmp.getNombre().equals(names.get(j))) {
                        i = i - 1;
                        v = false;
                        break;
                    }
                }
                if (v) {
                    list.add(tmp);
                    names.add(tmp.getNombre());
                }
            }

            this.array_neutrales = list;
        }
    }

}
