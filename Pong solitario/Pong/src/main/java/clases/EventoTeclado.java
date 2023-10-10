/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.event.*;
/**
 *
 * @author Alumno
 */
public class EventoTeclado extends KeyAdapter {
    static boolean LEFT,RIGHT; 
    
    @Override
    public void keyPressed(KeyEvent e){
        int id= e.getKeyCode();
        
        if(id==KeyEvent.VK_RIGHT){
            RIGHT = true;
        }
        if(id==KeyEvent.VK_LEFT){
            LEFT = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
         int id=e.getKeyCode();
         
         if(id==KeyEvent.VK_RIGHT){
            RIGHT=false;    
         }
         if(id==KeyEvent.VK_LEFT){
            LEFT=false; 
         }
    }
}
