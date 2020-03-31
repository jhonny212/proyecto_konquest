/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica_guardar;

import classes.guardar;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author jhonny
 */
public class LeerArchivoSave {
    
    public guardar getSave(String texto) {
        parser_save parser = null;
        lexico_save scan = null;
        try {
            scan = new lexico_save(new BufferedReader(new StringReader(texto)));
            parser.neutrales = new ArrayList();
            parser.planetas = new ArrayList();
            parser.jugadores = new ArrayList();
            parser.errores = new ArrayList();
            
            parser = new parser_save(scan);
            parser.parse();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        guardar guardar = new guardar(parser.planetas, parser.neutrales, parser.jugadores);
        guardar.setErroresSintatico(parser.errores);
        guardar.setErroresLexico(scan.ErrorLexico);
        
        return guardar;
    }
}
