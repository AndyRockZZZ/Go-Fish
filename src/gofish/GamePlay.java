/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.util.Random;
/**
 *
 * @author Andy
 */
public class GamePlay {
    private Rank cardrank;
    public Players player1;
    public Players player2;
    public Players player3;
    public Players player4;
    int totalsetcount;
    int setcount;
    int pilecount;
    int cardask;
    int playernumber;
    int turn = 1;
    String opponent;
    String info;
    String playerask;
    String chooseplayer2;
    String chooseplayer3;
    String chooseplayer4;
    String yourturn;
    String reasoncard;
    Random rand = new Random();
    
    public GamePlay() {
        this.player1 = new Players(1, "Player 1");
        this.player2 = new Players(2, "Player 2");
        this.player3 = new Players(3, "Player 3");
        this.player4 = new Players(4, "Player 4");
        this.cardrank = cardrank;
        this.info = "Hello " + player1.getPlayername() + ", you will be playing against some players";
        this.totalsetcount = totalsetcount;
        this.pilecount = pilecount;
        this.playerask = "What card are you asking for (Enter a card that is in your hand e.g. Ace = 1, Jack = 11, Queen = 12 & King = 13) \n";
        this.chooseplayer2 = "Which player are you going to ask? (" + player1.getPlayername() + " = 1, "
                + player2.getPlayername() + " = 2)";
        this.chooseplayer3 = "Which player are you going to ask? (" + player1.getPlayername() + " = 1, "
                + player2.getPlayername() + " = 2, " + player3.getPlayername() + " = 3)";
        this.chooseplayer4 = "Which player are you going to ask? (" + player1.getPlayername() + " = 1, "
                + player2.getPlayername() + " = 2, " + player3.getPlayername() + " = 3 & " + player4.getPlayername() + " = 4)";
        this.yourturn = "Ok, It is now "+ player1.getPlayername()+ "'s turn! \n ";
        this.reasoncard = "\n card/s have been moved to other player";
    }
    public int getTotalsetcount() {
        return totalsetcount;
    }
    public String Asked(){
        if(this.cardask == 1){
            return "Aces";
        }
        if (this.cardask == 11){
            return "Jacks";
        }
        if (this.cardask == 12){
            return "Queens";
        }
        if (this.cardask == 13){
            return "Kings";
        }
        else{
            return this.cardask + " 's";
        }
    }
    public Players PlayerNo(){
        if(this.playernumber == 1){
            return player1;
        }
        if(this.playernumber == 2){
            return player2;
        }
        if(this.playernumber == 3){
            return player3;
        }
        if(this.playernumber == 4){
            return player4;
        }
        else{
            return null;
        }
    }
    public void RandomCardCPUAsked(Players player){
        int randomcard = (int) (Math.random() * (player.handsize() - 1));
        this.cardask = player.getcardforhand(randomcard).getRanks().getRankvalue();
    }
    public int RandomPlayer(Players player){
        int randomplayer = rand.nextInt(4)+1;
        this.playernumber = randomplayer;
        return this.playernumber;
    }
    public void setCardask(int cardask) {
        this.cardask = cardask; 
    }
    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }
    public Rank PlayerUserAsk(int cardrank) {
        Rank result = Rank.ACE;
        switch (cardrank) {
        case 1:
            result = Rank.ACE;
            break;
        case 2:
            result = Rank.TWO;
            break;
        case 3:
            result = Rank.THREE;
            break;
        case 4:
            result = Rank.FOUR;
            break;
        case 5:
            result = Rank.FIVE;
            break;
        case 6:
            result = Rank.SIX;
            break;
        case 7:
            result = Rank.SEVEN;
            break;
        case 8:
            result = Rank.EIGHT;
            break;
        case 9:
            result = Rank.NINE;
            break;
        case 10:
            result = Rank.TEN;
            break;
        case 11:
            result = Rank.JACK;
            break;
        case 12:
            result = Rank.QUEEN;
            break;
        case 13:
            result = Rank.KING;
            break;
        default:
            System.out.println("Not a card");
        }
        return result;
    }
}
