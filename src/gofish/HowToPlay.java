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
public class HowToPlay {
    JFrame Background = new JFrame("Go Fish");
    JLabel Title;
    JLabel Description;
    JButton MenuButton;
    
    public HowToPlay() {
        
        Title = new JLabel("How To Play");
        Title.setFont(new Font("Arial Black", 0, 80));
        Title.setForeground(new Color(0, 0, 0));
        Title.setHorizontalAlignment(SwingConstants.CENTER);
        Title.setBackground(new Color(146, 208, 80));
        Title.setOpaque(true);
        Title.setBounds(50, 20, 1500, 115);
        
        Description = new JLabel("<html>A standard 52 card pack is used.  The aim of the game to collect as many sets (a set is four cards of the same number or suit). <br><br>" +
                                "The dealer shuffles the cards (â€œthe packâ€). Five cards (â€œa handâ€) are dealt to each player. The remaining cards are placed in the middle of the players faced down.<br><br>" +
                                "The game begins, Player 1 asks an opponent for a card, he already will have in his hand, he is holding an  8,  So he will ask an opponent do they have any 8s. Should the opponent hold more than one, he must pass them all over to the Player 1.<br><br>" +
                                "If Player 1 has been successful he may continue and ask another opponent for another card.   However, if he was unsuccessful his opponent will tell him to â€œGo Fishâ€ and the Player must take a card from the pack.  "
                + "              If this card is the one he just asked for he may continue with his turn.  If not, the game moves to the next Player.<br><br>" +
                                "As a Player completes a set, he must place them face down in front of him. <br>" +
                                "When a player runs out of cards he must pick up five more from the pack.  If there arenâ€™t five he must pick up whatever is left. "
                + "             If however, a player has run out of cards and the pack is empty then its game over for them. <br><br>" +
                                "Lastly, the player ends with the most set is the winner. <html>");
        Description.setFont(new Font("Arial Black", 0, 20));
        Description.setForeground(new Color(0, 0, 0));
        Description.setBackground(new Color(146, 208, 80));
        Description.setOpaque(true);
        Description.setBounds(50, 150, 1500, 600);
        
        MenuButton = new JButton("Menu");
        MenuButton.setFont(new Font("Arial Black", 0, 24));
        MenuButton.setForeground(new Color(0, 0, 0));
        MenuButton.setBackground(new Color(0, 204, 255));
        MenuButton.setOpaque(true);
        MenuButton.setBounds(50, 780, 250, 60);
        MenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
    }
    public void MenuButtonActionPerformed(ActionEvent evt){
        WelcomePage welcome = new WelcomePage();
        welcome.DisplayTable();
        Background.setVisible(false);
    }
    public void DisplayTable(){
        
        Background.setLayout(null);
        Background.setBounds(0,0,1600,900);
        Background.setResizable(false);
        Background.setPreferredSize(new Dimension(1600, 900));
        Background.getContentPane().setBackground(new Color(24, 106, 34));
        Background.add(Title);
        Background.add(Description);
        Background.add(MenuButton);
        
        Background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Background.setVisible(true);
    }
}
