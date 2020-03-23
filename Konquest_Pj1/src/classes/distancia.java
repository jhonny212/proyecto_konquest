/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.DecimalFormat;
import planetas.galaxia;
import planetas.planeta;

/**
 *
 * @author jhonny
 */
public class distancia {
    private galaxia orige,destino;
    public distancia(galaxia origen,galaxia destino){
    this.orige=origen;
    this.destino=destino;
    }
    public Object[] turno(){
    Object t[]=new Object[2];    
    int x=(destino.getCoordx_()-orige.getCoordx_())*(destino.getCoordx_()-orige.getCoordx_());
    int y=(destino.getCoordy_()-orige.getCoordy_())*(destino.getCoordy_()-orige.getCoordy_());
    double n=(Math.sqrt((x+y)));
    DecimalFormat df = new DecimalFormat("#.0");
    double time=(n);
    df.format(time);
    double aux=time+0.5;
    t[0]=(int)aux;
    time=redondearDecimales(time,2);
    t[1]=time;
    return t;
    }
    public String getmsj(){
    Object[] t=turno();    
    String msj="La distancia desde el planeta "+orige.getPlaneta().getNombre()+" al planeta "+destino.getPlaneta().getNombre()+""
            + " es de "+t[1]+" años luz. \n"
            + "Una nave partiendo desde este punto tomara  "+t[0]+" turnos";
    return msj;}
    
        public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
}
