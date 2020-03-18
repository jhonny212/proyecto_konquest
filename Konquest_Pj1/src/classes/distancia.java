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
    int turno=(int) (Math.sqrt((x+y)));
    double n=(Math.sqrt((x+y)));
    if((turno+0.5)>n){
   // turno+=1;
    }
    DecimalFormat df = new DecimalFormat("#.00");
    double time=(x+y)/2;
    df.format(time);
    t[0]=turno;
    t[1]=time;
    return t;
    }
    public String getmsj(){
    Object[] t=turno();    
    String msj="La distancia desde el planeta "+orige.getPlaneta().getNombre()+" al planeta "+destino.getPlaneta().getNombre()+""
            + " es de "+t[1]+" años luz. \n"
            + "Una nave partiendo desde este turno llegara en el turno "+t[0];
    return msj;}
}
