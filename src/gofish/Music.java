/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Andy
 */
public class Music {
        private AudioStream as;
        private AudioStream audios;
        private InputStream music;
        
        public void Start(){
            try{
                music = new FileInputStream(new File("C:\\Users\\Andy\\Documents\\Hertfordshire IT\\Hertfordshire\\Hertfordshire\\Year 3\\Project Planning\\Projects\\Final Year Project\\GoFishProject\\build\\classes\\gofish\\other\\music.wav"));
                as = new AudioStream(music);
                AudioPlayer.player.start(as);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
            }  
        }
        public void Stop(){
            if (as != null){
                AudioPlayer.player.stop(as);
            }
        }
    
}
