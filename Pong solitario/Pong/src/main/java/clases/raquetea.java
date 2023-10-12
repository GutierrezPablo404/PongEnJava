/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Alumno
 */
public class raquetea {
    private int x,y;
    private static final int ancho=60,alto=10;
    Audio Reproductor = new Audio();
   private int MedX=x;
   private int MedY=y;
   private int Lastx=x;
   private int Lasty=y;
    
    public raquetea (int x,int y){
    this.x=x;
    this.y=y;
                                 }

    public Rectangle2D getraqueta(){//dice donde y que alto y anchura tiene la pelota
        if(x%5==0){
        MedX=x;
        MedY=y;
        }
        if(x%10==0){
        Lastx=x;
        Lasty=y;
        }
        return new Rectangle2D.Double(x, y, ancho, alto);
    }
    
     public void PaintTrace(Graphics g){
     // g.drawLine(x+5, y+5, Lastx , Lasty );
      g.setColor(Color.BLUE);  
      g.drawRect(x, y,ancho, alto);
      g.fill3DRect(x, y,ancho, alto, true);
      g.setColor(Color.GREEN);  
      g.drawRect(MedX, MedY,ancho, alto);
      g.fill3DRect(MedX, MedY,ancho, alto, true);
      g.setColor(Color.RED);
      g.drawRect(Lastx, Lasty,ancho, alto);
      g.fill3DRect(Lastx, Lasty,ancho, alto, true);
  }
    
    public void mover(Rectangle Limites){//Sirve para el movimiento de las raquetas
        if(EventoTeclado.LEFT && x>Limites.getMinX() ){//si el teclado se presiona va hacia la izquierda si no se pasa de los limites minimos
            x--;
         /*
            Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\Movement.wav");
            Reproductor.Reproducir();
          */  
        }
        if(EventoTeclado.RIGHT && x<Limites.getMaxX()-ancho  ){//va hacia la derecha si no se pasan los limites de x
            x++;
         /*
            Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\Movement.wav");
            Reproductor.Reproducir();
          */     
        }
        /* System.out.println("Valor en X="+x); */
    }
    
}
