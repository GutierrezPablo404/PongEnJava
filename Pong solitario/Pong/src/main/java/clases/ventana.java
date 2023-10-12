/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Jorge Nitales
 */
public class ventana extends JFrame {
    private final int ancho=500 ,largo=700 ;
    private TableroJuego lamina;
    private Hilo hilo;
    private Image imagen;
    public ventana (){//define los valores iniciales d ela vetana no del jframe
        setTitle("King Pong");//nombre de la ppantalla
        setSize(ancho,largo);//tamaño de la pantalla
        setLocationRelativeTo(null);//ubicacion de la vetana dentro de panatlla
        setResizable(false);
        lamina = new TableroJuego();
        add(lamina);
        addKeyListener(new EventoTeclado());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hilo=new Hilo(lamina);
        hilo.start();        
    }
    
    @Override
    public void paint (Graphics g){
    imagen = new ImageIcon(getClass().getResource("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\You look lonely 2.jpg")).getImage();
    g.drawImage(imagen,0, 0,getWidth(), getHeight(),this);
  //  setOpaque(false);
    super.paint(g);
    }
}
