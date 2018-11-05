/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gofish;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.swing.*;
import sun.audio.*;
/**
 *
 * @author Andy
 */
public class Players2Mode {
    
    JFrame table = new JFrame("Go Fish");
    JTextField cardresponsetext;
    JButton deckbutton, gofishbutton, submitbutton, start, stopnplay;
    JLabel action, playerchoice, cardquestion, player1, player2, player2setcount, 
            deckcount, playingcards, totalsetcount, player1setcount, title;
    JPanel handpanel;
    int pilecount;
    int turn;
    private GamePlay game = new GamePlay();
    private Deck deck = new Deck();
    private Music music = new Music();
    private Random rand = new Random();
   
    public Players2Mode() {
        
        deck.FullDeck();
        deck.ShuffleDeck(); 
        game.player1.startdeal(deck);
        game.player1.sorthand();
        game.player2.startdeal(deck);
        game.player2.sorthand();
        pilecount = deck.Decksize();
        this.turn = RandomTurnStart();
        
        player1 = new JLabel();
        player1.setFont(new Font("Arial", 0, 18));
        player1.setForeground(new Color(255, 255, 255));
        player1.setBounds(734, 780, 75, 22);
        player1.setText(game.player1.getPlayername());
       
        player2 = new JLabel();
        player2.setFont(new java.awt.Font("Arial", 0, 18));
        player2.setForeground(new Color(255, 255, 255));
        player2.setBounds(734, 100, 101, 22);
        player2.setText(game.player2.getPlayername());
        
        title = new JLabel();
        title.setFont(new java.awt.Font("Arial", 0, 48)); 
        title.setForeground(new Color(255, 255, 51));
        title.setBounds(650, 10, 264, 56);
        title.setText("GO FISH !!!!");
        
        totalsetcount = new JLabel();
        totalsetcount.setBounds(0, 20, 130, 17);
        totalsetcount.setForeground(new Color(0, 255, 255));
        totalsetcount.setFont(new java.awt.Font("Arial", 0, 14)); 
        totalsetcount.setText("Total Set Count: " + game.getTotalsetcount());
          
        deckcount = new JLabel();
        deckcount.setFont(new java.awt.Font("Arial", 0, 12)); 
        deckcount.setBounds(850, 390, 89, 15);
        deckcount.setForeground(new Color(0, 255, 255));
        deckcount.setText("Deck Count: " + pilecount);
        
        player1setcount = new JLabel();
        player1setcount.setBackground(new Color(102, 255, 255));
        player1setcount.setFont(new java.awt.Font("Arial", 0, 14)); 
        player1setcount.setBounds(600, 780, 89, 17);
        player1setcount.setForeground(new Color(0, 255, 255));
        player1setcount.setText("Set Count: " + game.player1.getSetcount());
        
        player2setcount = new JLabel();
        player2setcount.setBackground(new Color(0, 255, 255));
        player2setcount.setFont(new java.awt.Font("Arial", 0, 14)); 
        player2setcount.setBounds(600, 100, 89, 17);;
        player2setcount.setForeground(new Color(0, 255, 255));
        player2setcount.setText("Set Count: " + game.player2.getSetcount());
       
        cardresponsetext = new JTextField();
        cardresponsetext.setBounds(940, 780, 50, 32);
        cardresponsetext.setFont(new java.awt.Font("Arial", 0, 12));
        
        cardquestion = new JLabel();
        cardquestion.setFont(new java.awt.Font("Arial", 0, 16)); 
        cardquestion.setForeground(new Color(255, 204, 204));
        cardquestion.setText("Enter a card value e.g Ace = 1, Jack = 11, Queen = 12, King = 13");
        cardquestion.setBounds(940, 759, 500, 20);
        
        action = new JLabel();
        action.setBackground(new Color(255, 204, 204));
        action.setFont(new java.awt.Font("Arial", 1, 20)); 
        action.setForeground(Color.BLACK);
        action.setOpaque(true);
        action.setHorizontalAlignment(SwingConstants.CENTER);
        action.setBounds(400, 550, 800, 60);
        action.setText("Welcome to Go Fish, the game will begin as soon as you press that start button.");
        
        start = new JButton("Start");
        start.setFont(new Font("Arial", 1, 16));
        start.setBounds(1000,20,110,46);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
  
        deckbutton = new JButton();
        deckbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("other/Deck.png"))); 
        deckbutton.setBounds(734, 350, 61, 88);
        deckbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                DeckButtonActionPerformed(evt);
            }
        });
        deckbutton.setEnabled(false);
        
        submitbutton = new JButton("Submit");
        submitbutton.setFont(new Font("Arial", 1, 18));
        submitbutton.setBounds(1000, 780, 100, 32);
        submitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });
        submitbutton.setEnabled(false);
       
        gofishbutton = new JButton("GO FISH");
        gofishbutton.setFont(new Font("Arial", 1, 16));
        gofishbutton.setBounds(715, 490, 100, 50);
        gofishbutton.setForeground(new Color(0, 0, 0));
        gofishbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GoFishButtonActionPerformed(evt);
            }
        });
        gofishbutton.setEnabled(false);
        
        stopnplay = new JButton("Stop Music");
        stopnplay.setFont(new Font("Arial", 1, 16));
        stopnplay.setBounds(1300, 20, 150, 50);
        stopnplay.setForeground(new Color(0, 0, 0));
        stopnplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                StopNPlayButtonActionPerformed(evt);
            }
        });
        stopnplay.setEnabled(true);
    }
    public void DisplayForm(){
        
        table.setLayout(null);
        table.setBounds(0,0,1600,900);
        table.setResizable(false);
        table.setPreferredSize(new Dimension(1600, 900));
        table.getContentPane().setBackground(new Color(24, 106, 34));
        table.add(action);
        table.add(cardquestion);
        table.add(cardresponsetext);
        table.add(player2setcount);
        table.add(player1setcount);
        table.add(deckcount);
        table.add(title);
        table.add(player2);
        table.add(player1);
        table.add(deckbutton);
        table.add(totalsetcount);
        table.add(start);
        table.add(submitbutton);
        table.add(gofishbutton);
        table.add(stopnplay);
        table.add(DisplayHand(game.player1));
        table.add(DisplayHand(game.player2));
        music.Start();
        table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table.setVisible(true);
    }
    public int RandomTurnStart(){
        boolean match = false;
        int randomplayer = 0;
        
        while (match == false){
            randomplayer = rand.nextInt(game.player2.getId() + 1);
            if (randomplayer == 0){
                match = false;
            }
            else {
                match = true;
            }
        }
        return randomplayer;
    }
    public void StopNPlayButtonActionPerformed(ActionEvent evt){
        if (stopnplay.getText().equals("Stop Music")){
            music.Stop();
            stopnplay.setText("Play Music");
        }
        else{
            music.Start();
            stopnplay.setText("Stop Music");
        }
    }
    public void Ding(){
        InputStream music;
        try{
            music = new FileInputStream(new File("C:\\Users\\Andy\\Documents\\Hertfordshire IT\\Hertfordshire\\Hertfordshire\\Year 3\\Project Planning\\Projects\\Final Year Project\\GoFishProject\\build\\classes\\gofish\\other\\ding.wav"));
            AudioStream audios=new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getLocalizedMessage());
        }        
    }
    
    public JPanel DisplayHand(Players p){
        
        handpanel = new JPanel(new BorderLayout());
        
        for(int i = 0; i < p.handsize(); i++) {
            if(p == game.player1){
                Card c = p.getcardforhand(i);
                ImageIcon cardImage;
                cardImage = c.getImage();
                playingcards = new JLabel(cardImage);
                playingcards.setPreferredSize(new Dimension(72, 96));
                playingcards.setBounds(i*30, 0, 72, 96);
                handpanel.add(playingcards);
                handpanel.setBounds(620, 620, 450, 96);
                handpanel.setBackground(new Color(24, 106, 34)); 
            }
            else if (p == game.player2){
                Card c = p.getcardforhand(i);
                ImageIcon cardImage;
                cardImage = c.getFaceDownImage();
                playingcards = new JLabel(cardImage);
                playingcards.setPreferredSize(new Dimension(72, 96));
                playingcards.setBounds(i*30, 0, 72, 96);
                handpanel.add(playingcards);
                handpanel.setBounds(620, 125, 450, 96);
                handpanel.setBackground(new Color(24, 106, 34));
            }
        }
        return handpanel;
    }
    public void setTurn(int turnNumber) {
        this.turn = turnNumber;
    }
    
    public void IncrementTurn(){
        if(turn + 1 > game.player2.getId()){
            setTurn(game.player1.getId());
        }
        else{
            turn++;
        }
    }
    public void GoFishButtonActionPerformed(ActionEvent evt) {  
        if (pilecount > 0){
            if(turn == game.player2.getId()){
                Timer res = new Timer(0, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        action.setText(game.player1.getPlayername() + " said Go Fish !!!, and " + game.player2.getPlayername() + " picks up a card.");
                    }
                });
                res.start();
                res.setRepeats(false);
                
                Timer sets = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        game.player2.dealone(deck);
                        CardsToSet(game.player2, game.player2.valueOfNewestCard());
                        HandEmpty(game.player2);
                        CardsToSet(game.player2, game.cardask);
                        HandEmpty(game.player2);
                        game.player2.sorthand();
                        table.add(DisplayHand(game.player2));
                        player2setcount.setText("Set Count: " + game.player2.getSetcount());
                        totalsetcount.setText("Total Set Count: " + game.getTotalsetcount());
                        table.add(player2setcount);
                        table.add(totalsetcount);
                        pilecount -= 1;
                        deckcount.setText("Deck Count: " + pilecount);
                    }
                });
                sets.start();
                sets.setRepeats(false);
            }    
        }
        else{
            action.setText("The deck is out of cards");
        } 
        gofishbutton.setEnabled(false);
        Timer end = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IncrementTurn(); 
                Play();
            }
        });
        end.start();
        end.setRepeats(false);
    }
    public void SubmitButtonActionPerformed(ActionEvent evt) {
        boolean match = false;
        String text = cardresponsetext.getText();
      
        if(match == false){
            if(cardresponsetext.getText().equals("")){
                action.setText("There's no card value in the text box \n Enter a card value.");
                match = false;
            }
            int userinput = Integer.parseInt(text);
            if(game.player1.legalguess(userinput) == true){
                game.setCardask(userinput);
                Timer asking = new Timer(0, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        action.setText(game.player1.getPlayername() + " asked " + game.player2.getPlayername() + " for any " + game.Asked() + "?");
                        MatchingCardsToPlayer(game.player1, game.player2, game.cardask);
                    }
                });
                asking.start();
                asking.setRepeats(false);
                match = true;
            }
            else if(userinput == 0 || userinput > 13){
                action.setText("That value doesn't exist. Enter again.");
                match = false;
            }
            else{
                action.setText("You don't have that card. \nEnter again.");
                match = false;
            }
        }
        if (match == true){
            cardresponsetext.setText("");
            cardresponsetext.setEnabled(false);
            submitbutton.setEnabled(false);
        }
    }  
    public void DeckButtonActionPerformed(ActionEvent evt) { 
        if (pilecount > 0){
            Timer result = new Timer(0, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    action.setText(game.player1.getPlayername() + " has picked up a card from the deck"); 
                }
            });
            result.start();
            result.setRepeats(false);
            Timer sets = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    game.player1.dealone(deck);
                    CardsToSet(game.player1, game.player1.valueOfNewestCard());
                    CardsToSet(game.player1, game.cardask);
                    HandEmpty(game.player1);
                    game.player1.sorthand();
                    player1setcount.setText("Set Count: " + game.player1.getSetcount());
                    totalsetcount.setText("Total Set Count: " + game.getTotalsetcount());
                    table.add(DisplayHand(game.player1));
                    table.add(player1setcount);
                    table.add(totalsetcount);
                    pilecount -= 1;
                    deckcount.setText("Deck Count: " + pilecount);
                    deckbutton.setEnabled(false);
                }
            });
            sets.start();
            sets.setRepeats(false);
        }
        else{
            action.setText("The deck is out of cards");
        }
        Timer end = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IncrementTurn(); 
                Play();
            }
        });
        end.start();
        end.setRepeats(false);
    }
    public void StartActionPerformed(ActionEvent evt){
       Play();
       start.hide();
    }
    
    public void MoveCardsFromPlayer(Players from, Players to, int fromIndex){
        to.getHand().add(from.getcardforhand(fromIndex));
        from.removecardfromhand(fromIndex);
    }
    
    public void MatchingCardsToPlayer(Players asking, Players askedto, int askedvalue){
        if (asking.getId() == game.player1.getId()) {
            if (askedto.hasCard(askedvalue)){
                for (int i = 0; i < askedto.handsize(); i++) {  
                    if (askedto.getcardforhand(i).getRanks().getRankvalue() == askedvalue) {
                        MoveCardsFromPlayer(askedto, asking, i);
                        i--;
                        asking.sorthand();
                        table.add(DisplayHand(asking));
                        table.add(DisplayHand(askedto));
                        deckbutton.setEnabled(false);
                        Timer result = new Timer(5000, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                action.setText(askedto.getPlayername() + " card/s have been moved to " + asking.getPlayername() + " hand.");
                            }
                        });
                        result.start();
                        result.setRepeats(false);
                    }
                    Timer sets = new Timer(6000, new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            CardsToSet(asking, asking.valueOfNewestCard());
                            HandEmpty(asking);
                            HandEmpty(askedto);
                            CardsToSet(asking, game.cardask);
                            HandEmpty(asking);
                            HandEmpty(askedto);
                            askedto.sorthand();
                            player1setcount.setText("Set Count: " + asking.getSetcount());
                            totalsetcount.setText("Total Set Count: " + game.getTotalsetcount());
                            table.add(DisplayHand(asking));
                            table.add(DisplayHand(askedto));
                            table.add(player1setcount);
                            table.add(totalsetcount);
                        }
                    });
                    sets.start();
                    sets.setRepeats(false);
                }
                Timer end = new Timer(8000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        IncrementTurn(); 
                        Play();
                    }
                });
                end.start();
                end.setRepeats(false);
            }
            else {
                Timer result = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        action.setText(askedto.getPlayername() + " said Go Fish !!!");
                    }
                });
                result.start();
                result.setRepeats(false);
                
                Timer pick = new Timer(4000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        action.setText("You have to pick up a card from the deck"); 
                        deckbutton.setEnabled(true);
                    }
                });
                pick.start();
                pick.setRepeats(false);
            }
        }
        else if(asking.getId() == game.player2.getId()){
            if(asking.legalguess(askedvalue) == true){
                if (askedto.hasCard(askedvalue)){
                    for (int i = 0; i < askedto.handsize(); i++) {  
                        if (askedto.getcardforhand(i).getRanks().getRankvalue() == askedvalue) {
                            MoveCardsFromPlayer(askedto, asking, i);
                            i--;
                            asking.sorthand();
                            table.add(DisplayHand(asking));
                            table.add(DisplayHand(askedto));
                            gofishbutton.setEnabled(false);
                            Timer result = new Timer(4000, new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                     action.setText(askedto.getPlayername() + " card/s have been moved to " + asking.getPlayername() + " hand.");
                                }
                            });
                            result.start();
                            result.setRepeats(false);
                        }
                        Timer set = new Timer(6000, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                CardsToSet(asking, asking.valueOfNewestCard());
                                HandEmpty(asking);
                                HandEmpty(askedto);
                                CardsToSet(asking, game.cardask);
                                HandEmpty(asking);
                                HandEmpty(askedto);
                                askedto.sorthand();
                                asking.sorthand();
                                player2setcount.setText("Set Count: " + game.player2.getSetcount());
                                totalsetcount.setText("Total Set Count: " + game.getTotalsetcount());
                                table.add(DisplayHand(asking));
                                table.add(DisplayHand(askedto));
                            }
                        });
                        set.start();
                        set.setRepeats(false);
                    }
                    Timer end = new Timer(8000, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            IncrementTurn(); 
                            Play();
                        }
                    });
                    end.start();
                    end.setRepeats(false);
                }
                else {
                    if(askedto == game.player1){
                        gofishbutton.setEnabled(true);
                    }
                }
            }
        }
    }
    public void CardsToSet(Players player, int cardvalue){
        if(player.hasSet(cardvalue)){
            for(int index = 0; index < player.handsize() ; index++){
                if(player.getcardforhand(index).getRanks().getRankvalue() == cardvalue){
                    player.removecardfromhand(index);
                }
            }
            for(int index = 0; index < player.handsize() ; index++){
                if(player.getcardforhand(index).getRanks().getRankvalue() == cardvalue){
                    player.removecardfromhand(index);
                }
            }
            Ding();
            game.totalsetcount = game.totalsetcount + 1;
            player.incrementsetcount();
            System.out.println("Well done " + player.getPlayername() + ", you got a set of " + cardvalue + " your set count has gone up by 1.");
            action.setText("Well done " + player.getPlayername() + ", you got a set of " + cardvalue);
        }
    }
    public void HandEmpty(Players player){
        if(player.isdeckempty() == true){
            if(pilecount >= 5){
                for(int card = 1; card <= 5; card++){
                    player.dealone(deck);
                    pilecount--;
                    deckcount.setText("Deck Count: " + pilecount);
                    table.add(deckcount);
                }
            }
            else if(pilecount > 0 || pilecount < 5){
                for(int card = 0; pilecount >= card; pilecount--){
                    player.dealone(deck);
                    deckcount.setText("Deck Count: " + pilecount);
                    table.add(deckcount);
                    
                }
            }
            else if(pilecount == 0){
                table.add(deckcount);
                action.setText(player.getPlayername() + "'s hand is empty");
            }
        }
    }
    public void Play(){
        if(turn == game.player1.getId()){
            if (game.getTotalsetcount() != 13){
                if(game.player1.isdeckempty() != true){
                    gofishbutton.setEnabled(false);
                    cardresponsetext.setEnabled(true);
                    submitbutton.setEnabled(true);
                    deckbutton.setEnabled(false);
                    player2.setBackground(new Color(24, 106, 34));
                    player1.setBackground(Color.red);
                    player1.setOpaque(true);
                    table.add(player1);
                    action.setText(game.yourturn + "please type a card value on the bottom right box.");
                }
                else{
                    IncrementTurn(); 
                    Play();
                }
            }
            else{
                Gameover();
            }
        }
        else if(turn == game.player2.getId()){
            if (game.getTotalsetcount() != 13){
                if(game.player2.isdeckempty() != true){
                    cardresponsetext.setEnabled(false);
                    submitbutton.setEnabled(false);
                    player1.setBackground(new Color(24, 106, 34));
                    player2.setBackground(Color.red);
                    player2.setOpaque(true);
                    table.add(player2);
                
                    game.RandomCardCPUAsked(game.player2);
                    Timer turn = new Timer(0, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            action.setText("Okay, it is now " + game.player2.getPlayername() + "'s turn.");
                        }
                    });
                    turn.start();
                    turn.setRepeats(false);
                    Timer asking = new Timer(2000, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            action.setText("Okay, " + game.player2.getPlayername() + " has picked " + game.player1.getPlayername() + " to ask for any " + game.Asked() + "?");
                            MatchingCardsToPlayer(game.player2, game.player1, game.cardask);
                        }
                    });
                    asking.start();
                    asking.setRepeats(false);
                    table.add(DisplayHand(game.player1));
                    table.add(DisplayHand(game.player2));
                    table.add(player2setcount);
                    table.add(totalsetcount);
                }
                else{
                    IncrementTurn(); 
                    Play();
                }
            }
            else{
                Gameover();
            }
        }
    } 
    public void Gameover(){
        String result;
        
        if (game.player1.getSetcount() > game.player2.getSetcount()){
            action.setText("Game Over !!!"); 
            result = "Congratulations " + game.player1.getPlayername() + " you are the winner.";
        }
        else if (game.player1.getSetcount() == game.player2.getSetcount()){
            action.setText("Game Over !!!"); 
            result = "Congratulations " + game.player1.getPlayername() + " & " + game.player2.getPlayername() + " you are the winners.";
        }
        else{
            action.setText("Game Over !!!");  
            result = "Congratulations " + game.player2.getPlayername() + " you are the winner.";
        }
        
        JOptionPane.showMessageDialog(null, result);
        int response = JOptionPane.showConfirmDialog(null,"Would you like to play again?", "Game Over",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response == JOptionPane.YES_OPTION){
            Play play = new Play();
            play.DisplayForm();
            table.setVisible(false);
            music.Stop();
        }
        else{
            System.exit(0);
        }
    }
}