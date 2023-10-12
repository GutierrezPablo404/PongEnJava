/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alumno
 */

public class FondoPanel extends JPanel {
    private Image imagen;
            
    @Override
    public void paint (Graphics g){
    imagen = new ImageIcon(getClass().getResource("C:\\Users\\Jorge Nitales\\Documents\\5ta 2da\\Lpoo\\Pong solitario\\Pong\\src\\main\\java\\recursos\\You look lonely 2.jpg")).getImage();
    g.drawImage(imagen,0, 0,getWidth(), getHeight(),this);
    setOpaque(false);
    super.paint(g);
    }

}
