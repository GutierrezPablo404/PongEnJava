/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Nitales
 */
public class Hilo extends Thread {
    TableroJuego lamina;
    public static float speed=5;
    public Hilo( TableroJuego lamina ){
        this.lamina = lamina;
    }
    @Override
    public void run(){
        while(!pelota.finJuego){
            lamina.repaint();
            try {
                Thread.sleep((long) speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        /* aca se debe de iniciar la pantalla de fin de juego */
        
    }
    
}
