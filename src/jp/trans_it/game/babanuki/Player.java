package jp.trans_it.game.babanuki;

import java.util.Scanner;

public class Player extends Attender {
	/**
	 * コンストラクタ
	 * @param scanner スキャナー
	 */
	public Player(Scanner scanner) {
		super(scanner);
	}

	@Override
	public void display() {
		System.out.print("プレイヤー: ");
		for(int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			System.out.print(card.toString());
		}
		System.out.println("");
	}

	@Override
	public void select(Attender attender) {
		int maxIndex = attender.getNumberOfCards() - 1;
		System.out.println("");
		attender.display();
		this.display();

		System.out.println("あなたの番です。");

		int index = -1;
		while(index < 0  || index > maxIndex) {
			System.out.println("引くカードを選んでください。1～" + maxIndex);
			try {
				String line = this.scanner.nextLine();
				index = Integer.parseInt(line);
			}
			catch(Exception e) {
				index = -1;
			}
		}

		Card card = attender.giveCard(index);
		System.out.println("引いたカード: " + card.toString());

		this.addCard(card);
		this.removeSameCards();
		this.display();
	}
}
