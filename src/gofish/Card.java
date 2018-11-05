/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Andy
 */
public class Card {
    private Suit Suits;
    private Rank Ranks;
    private ImageIcon FrontImage;
    private ImageIcon faceDownImage;
    
    public Card() {
        this.Suits = null;
        this.Ranks = null;
        this.FrontImage = null;
        this.faceDownImage = new ImageIcon(getClass().getResource("other/BackFace.png"));
    }
    public Card(Suit suits, Rank ranks) {
        this.Suits = suits;
        this.Ranks = ranks;
        this.FrontImage = new ImageIcon(getClass().getResource("cardImages/" + toString() + ".png"));
        this.faceDownImage = new ImageIcon(getClass().getResource("other/BackFace.png"));
    }
    public Suit getSuits() {
        return Suits;
    }
    public Rank getRanks() {
        return Ranks;
    }
    public Rank getRankvalue(){
        return Ranks;
    }
    public void setSuits(Suit suits) {
        this.Suits = suits;
    }
    public void setRanks(Rank ranks) {
        this.Ranks = ranks;
    }
    public ImageIcon getImage() {
        return FrontImage;
    }
    public ImageIcon getFaceDownImage() {
        return faceDownImage;
    }
    @Override
    public String toString() {
        return Ranks + " of " + Suits; 
    }
}


