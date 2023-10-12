/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.Hilo.speed;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Jorge Nitales
 */
public class pelota {
   private int x ;
   private int y ;
   private int MedX=0;
   private int MedY=0;
   private int Lastx=0;
   private int Lasty=0;
   private int dx=1,dy=1;
   public float Top_speed=2f;
   private final int ancho=15,largo=15;
   private final float amount=0.15f;
   Audio Reproductor = new Audio();
   
   private Integer puntaje=0; //puntaje del jugador
   public static boolean finJuego = false; //indica si se acaba el juego 
   
   public pelota(int x,int y){
       this.x=x;
       this.y=y;
   }
   
   public Rectangle2D getPelota(){
       return new Rectangle2D.Double(x,y,ancho,largo);
   }//devuelve la posicion de la pelota con ancho especifico
   
  public void PaintTrace(Graphics g){
     // g.drawLine(x+5, y+5, Lastx , Lasty );
      g.drawArc(x, y, ancho, largo, 360, 360);
      g.fillArc(x, y, ancho, largo, 360, 360);
      g.setColor(Color.BLUE);
      g.drawArc(MedX, Lasty, ancho, largo, 360, 360);
      g.fillArc(MedX, Lasty, ancho, largo, 360, 360);
      g.setColor(Color.GREEN);
      g.drawArc(Lastx, Lasty, ancho, largo, 360, 360);
      g.fillArc(Lastx, Lasty, ancho, largo, 360, 360);   
  }
   
   public void mover( Rectangle limites,boolean colisionr1  ){//mueve la pelota en si
    x+=dx;
    y+=dy;
    if(x%20==0){
    Lastx=x;
    Lasty=y; 
    }
    if(x%10==0){
    MedX=x;
    MedY=y;
    }
    //siempre se suma valor a su x e y para que se mueva
    //System.out.println(" x="+x+" y="+y);
    if(colisionr1==true){//sirve para cuando colisiona con la raqueta,espawnea la pelota ligeramente arriba d ela paleta e invierte posicion
    dy=-dy;
    y=585;
    Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\Parry.wav");
    Reproductor.Reproducir();
    }
    
    if( x>limites.getMaxX()-ancho ){//si golepa con la pared derecha
        dx=-dx;
        puntaje++;
        if(speed>Top_speed){
        speed = speed - amount;
        }
        Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\RankUp2.wav");
        Reproductor.Reproducir();
    }
    if( y>limites.getMaxY() ){//si golpea con la pared de abajo
        dy=-dy;
        finJuego=true;
        Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\GameOver.wav");
        Reproductor.Reproducir();
    }
    if(x<0){//si golepa con la pared izquierda
        dx=-dx;
        puntaje++;
        if(speed>Top_speed){
        speed = speed - amount;
        }
        Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\RankUp2.wav");
        Reproductor.Reproducir();
    }
    if(y<0){//si golepa con la pared de arriba
        dy=-dy;
        puntaje++;
        if(speed>Top_speed){
        speed = speed - amount;
        }
        Reproductor.CargarSonido("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\RankUp2.wav");
        Reproductor.Reproducir();
    }
    
   }
   public Integer getPuntaje(){
       switch(puntaje){
           case 50:Top_speed=1.5f;
           break;
           case 75:Top_speed=1f;
           break;
           case 100:Top_speed=0.50f;
           break;
           case 150:Top_speed=0.01f;
           break;
       }
       return puntaje;
   }
   
}