/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author ad15abk
 */
public class WelcomePage {
    JFrame Background = new JFrame("Go Fish");
    JButton PlayButton;
    JButton HowToPlayButton;
    JButton ExitButton;
    JLabel Title;
    JLabel Fish1;
    JLabel Fish2;
    JLabel Fish3;
    JLabel Octopus;
    JLabel picture;
    
    private Music music = new Music();
    
    public WelcomePage() {
        
        Title = new JLabel("Welcome To Go Fish !!!");
        Title.setFont(new Font("Impact", 0, 100)); 
        Title.setForeground(new Color(255, 207, 55));
        Title.setBounds(350, 10, 910, 90);
        
        Fish1 = new JLabel();
        Fish1.setIcon(new javax.swing.ImageIcon(getClass().getResource("other/fish1.png")));
        Fish1.setBounds(1000, 125, 413, 234);
        
        Fish2 = new JLabel();
        Fish2.setIcon(new javax.swing.ImageIcon(getClass().getResource("other/fish1.png")));
        Fish2.setBounds(600, 125, 413, 234);
        
        Fish3 = new JLabel();
        Fish3.setIcon(new javax.swing.ImageIcon(getClass().getResource("other/fish1.png")));
        Fish3.setBounds(200, 125, 413, 234);
        
        Octopus = new JLabel();
        Octopus.setIcon(new javax.swing.ImageIcon(getClass().getResource("other/octopus.png")));
        Octopus.setBounds(200, 600, 413, 234);
        
        picture = new JLabel();
        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("other/ocean.jpg")));
        picture.setBounds(0, 0, 1600, 900);
        
        PlayButton = new JButton("Play");
        PlayButton.setFont(new Font("Arial Black", 0, 50));
        PlayButton.setForeground(new Color(0, 0, 0));
        PlayButton.setBackground(new Color(146, 208, 80));
        PlayButton.setOpaque(true);
        PlayButton.setBounds(620, 366, 400, 65);
        PlayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });
        HowToPlayButton = new JButton("How To Play");
        HowToPlayButton.setFont(new Font("Arial Black", 0, 50));
        HowToPlayButton.setForeground(new Color(0, 0, 0));
        HowToPlayButton.setBackground(new Color(146, 208, 80));
        HowToPlayButton.setOpaque(true);
        HowToPlayButton.setBounds(620, 432, 400, 65);
        HowToPlayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HowToPlayButtonActionPerformed(evt);
            }
        });
        
        ExitButton = new JButton("Exit");
        ExitButton.setFont(new Font("Arial Black", 0, 50));
        ExitButton.setForeground(new Color(0, 0, 0));
        ExitButton.setBackground(new Color(146, 208, 80));
        ExitButton.setOpaque(true);
        ExitButton.setBounds(620, 498, 400, 65);
        ExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        
    }
    public void DisplayTable(){
        
        Background.setLayout(null);
        Background.setBounds(0,0,1600,900);
        Background.setResizable(false);
        Background.add(Title);
        Background.add(Fish1);
        Background.add(Fish2);
        Background.add(Fish3);
        Background.add(Octopus);
        Background.add(PlayButton);
        Background.add(HowToPlayButton);
        Background.add(ExitButton);
        Background.add(picture);
        Background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Background.setVisible(true);
    }
    
    public void PlayButtonActionPerformed(ActionEvent evt){
        Play play = new Play();
        play.DisplayForm();
        Background.setVisible(false);
    }
    public void HowToPlayButtonActionPerformed(ActionEvent evt){
        HowToPlay how = new HowToPlay();
        how.DisplayTable();
        Background.setVisible(false);  
    }
    public void ExitButtonActionPerformed(ActionEvent evt){
        System.exit(0);
    }
}
