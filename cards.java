package blackJack;

import java.util.ArrayList;
import java.util.List;


public class cards {
	private static List<String> cardDeck = new ArrayList<String>();
	private int deckSize;
	String[] suit = {"Diamonds", "Spades", "Hearts", "Clubs"};
	
	cards(int numCards) {
		deckSize = numCards;
	}
	void shuffle() {
		
		for(int l = 0; l<deckSize; l++){
			for(int j = 0; j < 4; j++){
				for(int i = 1; i < 14; i++){
					cardDeck.add(faceValue(i) + " of " + suit[j]);
				}}}
	}
	static String faceValue (int i){
		String cardType = "";
		if(i == 1)
			cardType = "Ace";
		else if(i == 11)
			cardType = "Jack";
		else if(i == 12)
			cardType = "Queen";
		else if(i == 13)
			cardType = "King";
		else
			cardType = cardType + i;
		return cardType;
	}
	static String dealtCard() {
		int cardOne = (int)((Math.random()*cardDeck.size())+1);
		String dealtCard = cardDeck.get(cardOne);
		cardDeck.remove(cardOne);
		return dealtCard;
	}
	int cardsLeft(){
		return cardDeck.size();
	}
	void tossDeck(){
		cardDeck.clear();
	}
	int cardValue(String faceOfcard){
		int faceValue = 0;
		String workingValue;
		workingValue = faceOfcard.substring(0,2);
		if(workingValue.equals("Ki"))
			faceValue = 10;
		else if(workingValue.equals("Qu"))
			faceValue = 10;
		else if(workingValue.equals("Ja"))
			faceValue = 10;
		else if(workingValue.equals("Ac"))
			faceValue = 11;
		else if(workingValue.equals("10"))
			faceValue = 10;
		else if(workingValue.equals("9 "))
			faceValue = 9;
		else if(workingValue.equals("8 "))
			faceValue = 8;
		else if(workingValue.equals("7 "))
			faceValue = 7;
		else if(workingValue.equals("6 "))
			faceValue = 6;
		else if(workingValue.equals("5 "))
			faceValue = 5;
		else if(workingValue.equals("4 "))
			faceValue = 4;
		else if(workingValue.equals("3 "))
			faceValue = 3;
		else if(workingValue.equals("2 "))
			faceValue = 2;
		else
			faceValue = 1;
		return faceValue;
	}
	boolean blackjackCheck(int checkHand){
		if(checkHand == 21)
			return true;
		else
			return false;
	}
}
