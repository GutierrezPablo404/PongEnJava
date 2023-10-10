/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class raquetea {
    private int x,y;
    private static final int ancho=40,alto=10;
    
    public raquetea (int x,int y){
    this.x=x;
    this.y=y;
                                 }

    public Rectangle2D getraqueta(){//dice donde y que alto y anchura tiene la pelota
        return new Rectangle2D.Double(x, y, ancho, alto);
    }
    
    public void mover(Rectangle Limites){//Sirve para el movimiento de las raquetas
        if(EventoTeclado.LEFT && x>Limites.getMinX() ){//si el teclado se presiona va hacia la izquierda si no se pasa de los limites minimos
            x--;
        }
        if(EventoTeclado.RIGHT && x<Limites.getMaxX()-ancho  ){//va hacia la derecha si no se pasan los limites de x
            x++;
        }
        /* System.out.println("Valor en X="+x); */
    }
    
}
