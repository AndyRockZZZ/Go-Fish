/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Andy
 */
public class Deck {
    public ArrayList<Card> cards;
   
    public Deck() {
        this.cards = new ArrayList<>();
    } 
    public void FullDeck(){
        for(Suit cardsuit : Suit.values()){
            for(Rank cardrank: Rank.values()){
                cards.add(new Card(cardsuit, cardrank));
            }
        }
    } 
    public String DisplayDeck(){
        String deckString = "";
        for(Card card: cards)
        {
            deckString += ("(" + card.toString() + ") \n\r");
        }
        return deckString;
    }
    public void ShuffleDeck(){
        ArrayList<Card> tmpdeck = new ArrayList<Card>();
        
        Random random = new Random();
        int randomcardindex = 0;
        int originalsize = cards.size();
        for(int i = 0; i < originalsize; i++){
            randomcardindex = random.nextInt((cards.size()-1)+1);
            tmpdeck.add(cards.get(randomcardindex));
            cards.remove(randomcardindex);
        }
        cards = tmpdeck;
    }
    public void RemoveCard(int i){
        cards.remove(i);
    }
    public Card GetCard(int i){
        return cards.get(i);
    }
    public void AddCard(Card addcard){
        cards.add(addcard);
    }
    public int Decksize(){
        return cards.size();
    }
    public boolean isdeckempty(){
        if(Decksize() == 0)
            return true;
        return false;
    }
}
