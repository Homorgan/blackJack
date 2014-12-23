package blackJack;

//import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class game {
	@SuppressWarnings("static-access")
	public static void main(String[] args){
	List<String> playerDeck = new ArrayList<String>();
	List<String> dealerDeck = new ArrayList<String>();
	cards playingCards = new cards(4);
	boolean winner = true;
	String win = "";
		playingCards.shuffle();
	do {
	for(int i = 0; i<2;i++){
		playerDeck.add(playingCards.dealtCard());
		dealerDeck.add(playingCards.dealtCard());
	}
	System.out.println(playerDeck);
	System.out.println(dealerDeck.get(0));
//	System.out.println(playingCards.cardsLeft());
	int playerHand = 0;
	int dealerHand = 0;
	for(int i = 0; i < playerDeck.size(); i++){
		playerHand = playerHand + playingCards.cardValue(playerDeck.get(i));
		dealerHand = dealerHand + playingCards.cardValue(dealerDeck.get(i));
	}
	System.out.println("You hand is worth: " + playerHand);
	System.out.println("The Dealer's up card is worth: " + playingCards.cardValue(dealerDeck.get(0)));
//	} while(true)
	if((playingCards.blackjackCheck(playerHand)) && (playingCards.blackjackCheck(dealerHand))){
		System.out.println("Both hands are 21 and neither wins...");
		winner = false;
		win = "neither";
	}
	else if (playingCards.blackjackCheck(dealerHand) && (playerHand<21)){
		System.out.println("The Dealer has 21 and you do not...");
		winner = false;
		win = "dealer";
	}
	else if(playingCards.blackjackCheck(playerHand) && (dealerHand<21)){
		System.out.println("You have a 21 and the dealer does not...");
		winner = false;
		win = "player";
	}
	int dealerTop = playingCards.cardValue(dealerDeck.get(0));

	while (winner) {
		if ((dealerTop < 7) && (playerHand < 12)) {
			System.out.println("Player");
			playerDeck.add(playingCards.dealtCard());
			playerHand = 0;
			for (int i = 0; i < playerDeck.size(); i ++) {
				playerHand = playerHand + playingCards.cardValue(playerDeck.get(i)); }
			System.out.println(playerDeck);
					}
		if (((dealerTop+10) > playerHand) && ((dealerTop+10) > 16)) {
			System.out.println("Player");
			while ((playerHand<17) && (winner)){
				playerDeck.add(playingCards.dealtCard());
				playerHand = 0;
				for (int i = 0; i < playerDeck.size(); i ++) {
					playerHand = playerHand + playingCards.cardValue(playerDeck.get(i)); }
				System.out.println(playerDeck);
				if (playerHand > 21) {
					winner = false;
					win = "Dealer";
				}
			}
			}
		while((dealerHand<17) && (winner)) {
			System.out.println("Dealer turn");
			dealerDeck.add(playingCards.dealtCard());
			dealerHand = 0;
			for (int i = 0; i < dealerDeck.size(); i ++) {
			dealerHand = dealerHand + playingCards.cardValue(dealerDeck.get(i)); }
			System.out.println(dealerDeck);
			if (dealerHand > 21) {
				winner = false;
				win = "Player";
			}
		}
		if (winner){
		if (playerHand > dealerHand) {
			winner = false;
			win = "Player";
		}
		else if (dealerHand > playerHand){
			winner = false;
			win = "Dealer";
		}
		else {
			winner = false;
			win = "Neither";
		}
		}
	}
	System.out.println("Players hand is worth " + playerHand);
	System.out.println(playerDeck);
	System.out.println("Dealers hand is worth " + dealerHand);
	System.out.println(dealerDeck);
	System.out.println("The winner is " + win);
	System.out.println(" ");
	playerDeck.clear();
	dealerDeck.clear();
	winner = true;
	win = "";
} while (playingCards.cardsLeft() > 30);
	playingCards.tossDeck();
	System.out.println("Time for a new Deck");
//	}
}	
}
