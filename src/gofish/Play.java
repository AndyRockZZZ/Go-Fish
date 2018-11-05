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
 * @author Andy
 */
public class Play {
    
    private JFrame Background = new JFrame("Go Fish");
    private JLabel Title, Description;
    private JButton player2mode, player3mode, player4mode, MenuButton;
    
    public Play() {
        
        Title = new JLabel("Let's Play");
        Title.setFont(new Font("Arial Black", 0, 80));
        Title.setForeground(new Color(0, 0, 0));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBackground(new Color(146, 208, 80));
        Title.setOpaque(true);
        Title.setBounds(50, 20, 1500, 115);
        
        Description = new JLabel("Please choose a game mode below:");
        Description.setFont(new Font("Arial Black", 0, 24));
        Description.setForeground(new Color(0, 0, 0));
        Description.setHorizontalAlignment(SwingConstants.CENTER);
        Description.setBackground(new Color(146, 208, 80));
        Description.setOpaque(true);
        Description.setBounds(550, 170, 480, 70);
        
        player2mode = new JButton("2 Players");
        player2mode.setFont(new Font("Arial Black", 0, 24));
        player2mode.setForeground(new Color(0, 0, 0));
        player2mode.setBackground(new Color(0, 204, 255));
        player2mode.setOpaque(true);
        player2mode.setBounds(200, 400, 160, 160);
        player2mode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                player2ButtonActionPerformed(evt);
            }
        });
        
        player3mode = new JButton("3 Players");
        player3mode.setFont(new Font("Arial Black", 0, 24));
        player3mode.setForeground(new Color(0, 0, 0));
        player3mode.setBackground(new Color(255, 255, 51));
        player3mode.setOpaque(true);
        player3mode.setBounds(675, 400, 160, 160);
        player3mode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                player3ButtonActionPerformed(evt);
            }
        });
        
        player4mode = new JButton("4 Players");
        player4mode.setFont(new Font("Arial Black", 0, 24));
        player4mode.setForeground(new Color(0, 0, 0));
        player4mode.setBackground(new Color(255, 0, 0));
        player4mode.setOpaque(true);
        player4mode.setBounds(1150, 400, 160, 160);
        player4mode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                player4ButtonActionPerformed(evt);
            }
        });
        
        MenuButton = new JButton("Menu");
        MenuButton.setFont(new Font("Arial Black", 0, 24));
        MenuButton.setForeground(new Color(0, 0, 0));
        MenuButton.setBackground(new Color(0, 204, 255));
        MenuButton.setOpaque(true);
        MenuButton.setBounds(630, 780, 250, 60);
        MenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
    }
    public void player2ButtonActionPerformed(ActionEvent evt){
        Players2Mode play2 = new Players2Mode();
        play2.DisplayForm();
        Background.setVisible(false);
    }
    public void player3ButtonActionPerformed(ActionEvent evt){
        Players3Mode play3 = new Players3Mode();
        play3.DisplayForm();
        Background.setVisible(false);
    }
    public void player4ButtonActionPerformed(ActionEvent evt){
        Players4Mode play4 = new Players4Mode();
        play4.DisplayForm();
        Background.setVisible(false);
    }
    public void MenuButtonActionPerformed(ActionEvent evt){
        WelcomePage welcome = new WelcomePage();
        welcome.DisplayTable();
        Background.setVisible(false);
    }
    public void DisplayForm(){
        
        Background.setLayout(null);
        Background.setBounds(0,0,1600,900);
        Background.setResizable(false);
        Background.setPreferredSize(new Dimension(1600, 900));
        Background.getContentPane().setBackground(new Color(24, 106, 34));
        Background.add(Title);
        Background.add(MenuButton);
        Background.add(player2mode);
        Background.add(player3mode);
        Background.add(player4mode);
        Background.add(Description);
        
        
        Background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Background.setVisible(true);
    } 
}
