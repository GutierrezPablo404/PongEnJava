/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Jorge Nitales
 */
public class Audio {
    
    public Clip clip;
    
    public void CargarSonido(String ruta){
     try{   
     File ArchivoSonido = new File(ruta);
     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ArchivoSonido);
     clip = AudioSystem.getClip();
     clip.open(audioInputStream);
     clip.setFramePosition(0);
     clip.start();
        }
     catch(Exception e){
     e.printStackTrace();
     System.out.append("Print stract trace activado");
     }
        }   
    public void Reproducir(){
        if(clip!=null && clip.isRunning()==false){
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public void Detener(){
        if(clip!=null && clip.isRunning()){
        clip.stop();
        }
    }
    
    }
