/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import static clases.pelota.finJuego;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jorge Nitales
 */
public class TableroJuego extends JPanel {
    pelota pelota = new pelota(0,0);//objeto pelota instanciado de clase
    raquetea r1 = new raquetea(225,600);//objeto raquerta(r1) instanciado de clase
    /**
     *
     */
    public TableroJuego(){//propiedad del fondo en si
        setBackground(Color.black);
    }
    
    @Override
    public void paintComponent( Graphics g ){//sirve para los dibujos en la pantalla
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;//inicializacion de graficos
        g2.setColor(Color.white);//color de pelota e elementos tal como raqueta e pelota
        dibujar(g2);//
        actualizar();
        DibujarPuntaje(g2);
                                }
    public void dibujar( Graphics2D g ){
        g.fill(pelota.getPelota() ); //va a llenar una parte de la pantalla en base a la posicion e tamaño de la pelota
        g.fill(r1.getraqueta());//rellena en base a tamaño y posicion de la raqueta
        
    }
    public void actualizar(){
        pelota.mover( getBounds(),colision(r1.getraqueta()) );//le pasa los parametos de limites de la pantalla y si colisiona o no con raqueta(usa funcion colision con la pelota)
        r1.mover(getBounds());//deja mover las raquetas en base a la posicion de la pelota
    }
    
    public void iterarJuego(){//esto se encarga de repitnar el juego en si
        while(true){
            try {
                repaint();//vuelve a pintar
                Thread.sleep(4);//tiene una pausa de 4 milisegundos
            } catch (InterruptedException ex) {//toma errores
                Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }
    
    private boolean colision(Rectangle2D r){//toma un valor d euna figura
        return pelota.getPelota().intersects(r);//indica si esta figura golpeo la pelota
    }
    
    private void DibujarPuntaje(Graphics2D g){
    Graphics2D gj=g;
    
    Font puntaje = new Font ("Arial",Font.BOLD,30);
    g.setFont(puntaje);
    
    gj.drawString(Integer.toString(pelota.getPuntaje()), (float) getBounds().getCenterX(),40 ); 
    
    if( finJuego==true ){
    g.drawString("Fin Del Juego", (float) getBounds().getCenterX() - 100, (float) getBounds().getCenterY() - 100);
    }
    
            
    }
    
}
