/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.util.ArrayList;
/**
 *
 * @author Andy
 */
public class Players extends Deck {
    
    private String playername;
    private ArrayList<Card> hand;
    private int id;
    private int setcount;

    public Players(int id, String playername) {
        this.playername = playername;
        this.id = id;
        this.setcount = 0;
        this.hand = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getPlayername() {
        return playername;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void removecardfromhand(int i){
        hand.remove(i);
    }
    public Card getcardforhand(int i){
        return hand.get(i);
    }
    public boolean legalguess(int guess){
        for(Card card: hand){
            if(card.getRanks().getRankvalue() == guess){
                return true;
            }
        }
        return false;
    }
    public void sorthand(){
        for(int i = 0; i < hand.size() - 1; i++){
            int j = i;
            for(int k = i + 1; k < hand.size(); k++){
                if(hand.get(k).getRanks().getRankvalue() < hand.get(j).getRanks().getRankvalue()){
                    j=k;
                }
            }
            Card temp = hand.get(j);
            hand.set(j, hand.get(i));
            hand.set(i, temp);
        }
    }
    public void addcard(Card addcard){
        hand.add(addcard);
    }
    public int handsize(){
        return hand.size();
    }
    public boolean isdeckempty(){
        if(handsize() == 0)
            return true;
        return false;
    }
    public void startdeal(Deck startcards){
        int numbercards = 5;
        for (int i = 0; i < numbercards; i++){
            hand.add(startcards.GetCard(0));
            startcards.RemoveCard(0);
        }
    }
    public void dealone(Deck onecard){
        hand.add(onecard.GetCard(0));
        onecard.RemoveCard(0);
    }
    public int getSetcount() {
        return setcount;
    }
    public void incrementsetcount(){
        setcount++;
    }
    public int valueOfNewestCard(){ return getcardforhand(indexOfNewestCard()).getRanks().getRankvalue();}

    public int indexOfNewestCard() { return this.handsize()-1; }

    public boolean hasCard(int askedValue) {
        for (int i = 0; i < this.handsize(); i++) {
            if (this.getcardforhand(i).getRanks().getRankvalue() == askedValue) {
                return true;
            }
        }
        return false;
    }
    public boolean hasSet(int askedValue){
        int cardmatch = 0;
        for (int i = 0; i < this.handsize(); i++) {
            if (this.getcardforhand(i).getRanks().getRankvalue() == askedValue) {
                cardmatch++;
            }
            if (cardmatch >= 4){
                for (int index = 0; index < this.handsize(); index++){
                    if(this.getcardforhand(index).getRanks().getRankvalue() == askedValue){
                        this.removecardfromhand(index);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
