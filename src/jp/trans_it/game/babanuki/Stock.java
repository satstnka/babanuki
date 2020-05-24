package jp.trans_it.game.babanuki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stock {
	private ArrayList<Card> cards;

	public Stock() {
		initialize();
	}

	public void initialize() {
		Card[] array = Card.getAllCards();
		List<Card> list = Arrays.asList(array);
		Collections.shuffle(list);
		this.cards = new ArrayList<Card>(list);
	}

	public int getNumberOfCards() {
		return this.cards.size();
	}

	public Card pickCard() {
		Card card = this.cards.get(0);
		this.cards.remove(0);
		return card;
	}
}
