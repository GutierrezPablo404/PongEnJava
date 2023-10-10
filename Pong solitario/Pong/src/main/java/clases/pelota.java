/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.Hilo.speed;
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Jorge Nitales
 */
public class pelota {
   private int x ;
   private int y ;
   private int dx=1,dy=1;
   private final int ancho=15,largo=15;
   private final float amount=0.10f;
   
   private Integer puntaje=0; //puntaje del jugador
   public static boolean finJuego = false; //indica si se acaba el juego 
   
   public pelota(int x,int y){
       this.x=x;
       this.y=y;
   }
   
   public Rectangle2D getPelota(){
       return new Rectangle2D.Double(x,y,ancho,largo);
   }//devuelve la posicion de la pelota con ancho especifico
   
   public void mover( Rectangle limites,boolean colisionr1  ){//mueve la pelota en si
    x+=dx;
    y+=dy;
    //siempre se suma valor a su x e y para que se mueva
    
    if(colisionr1==true){//sirve para cuando colisiona con la raqueta,espawnea la pelota ligeramente arriba d ela paleta e invierte posicion
    dy=-dy;
    y=585;
    }
    
    if( x>limites.getMaxX() ){//si golepa con la pared derecha
        dx=-dx;
        puntaje++;
        speed = speed - amount;
    }
    if( y>limites.getMaxY() ){//si golpea con la pared de abajo
        dy=-dy;
        finJuego=true;
    }
    if(x<0){//si golepa con la pared izquierda
        dx=-dx;
        puntaje++;
        speed = speed - amount;
    }
    if(y<0){//si golepa con la pared de arriba
        dy=-dy;
        puntaje++;
        speed = speed - amount;
    }
    
   }
   public Integer getPuntaje(){
       return puntaje;
   }
   
}
