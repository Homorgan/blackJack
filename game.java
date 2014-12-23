package blackJack;

//import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class game {
	@SuppressWarnings("static-access")
	public static void main(String[] args){
	List<String> playerDeck = new ArrayList<String>();
	List<String> dealerDeck = new ArrayList<String>();
	cards playingCards = new cards(2);
//	int startCardcount = playingCards.cardsLeft();
//	for(int z=0; z<2; z++){
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
//	do{
	for(int i = 0; i < playerDeck.size(); i++){
		playerHand = playerHand + playingCards.cardValue(playerDeck.get(i));
		dealerHand = dealerHand + playingCards.cardValue(dealerDeck.get(i));
		// More code
	}
	System.out.println("You hand is worth: " + playerHand);
	System.out.println("The Dealer's up card is worth: " + playingCards.cardValue(dealerDeck.get(0)));
//	} while(true)
	if((playingCards.blackjackCheck(playerHand)) && (playingCards.blackjackCheck(dealerHand))){
		System.out.println("Both hands are 21 and neither wins...");
		break;
	}
	else if (playingCards.blackjackCheck(dealerHand) && (playerHand<21)){
		System.out.println("The Dealer has 21 and you do not...");
		break;
	}
	else if(playingCards.blackjackCheck(playerHand) && (dealerHand<21)){
		System.out.println("You have a 21 and the dealer does not...");
		break;
	}
	playerDeck.clear();
	dealerDeck.clear();
} while (playingCards.cardsLeft() > 30);
	playingCards.tossDeck();
	System.out.println("Time for a new Deck");
//	}
}	
}
