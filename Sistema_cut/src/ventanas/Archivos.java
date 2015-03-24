/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.File;

/**
 *
 * @author Christian
 */
public class Archivos {
    public static void carpeta(){
        File gestor = new File("c:\\Sistema");
        File BackUp = new File("c:\\Sistema\\BackUp");
       // File empleados = new File("c:\\Estetica\\Empleados");
        //File empleadosImagenes = new File("c:\\Estetica\\Empleados\\fotos");
       if(gestor.exists()){
        }if(!gestor.exists()){
            gestor.mkdir();
            BackUp.mkdir();
            //empleados.mkdir();
            //empleadosImagenes.mkdir();        
        }
    }
}
