import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * ID: TODO: b0444139
 * Name: TODO:邱顯致
 */
public class Hw2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N(deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on
		// your screen
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/*
	 * This method is used for checking your result, not a part of your HW2
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/*
 * Description: TODO:將輸入的副數以(花色,牌數)的方式排列，並存入card物件中，再存於cards，接著轉為陣列(ArrayList)。
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		// Card card=new Card(1,1);
		// xxxx1.副牌，2.花色 3.排1~13
		for (int n = 0; n < nDeck; n++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 13; k++) {
					Card card = new Card(j, k);
					cards.add(card);
				}
			}
		}
	}

	// TODO: Please implement the method to print all cards on screen
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// please implement and reuse printCard method in Card class
		for (int i = 0; i < getAllCards().size(); i++) {
			Card c = cards.get(i);
			c.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/*
 * Description: TODO: 將Card以(suit,rank)的形式傳回printcard()內。
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3,
						// Spades=4
	private int rank; // 1~13

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example:
		// print 1,1 as Clubs Ace
		System.out.println(getSuit() + "," + getRank());
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}