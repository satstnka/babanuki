package jp.trans_it.game.babanuki;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Computer extends Attender {
	/**
	 * コンストラクタ
	 * @param scanner スキャナ
	 */
	public Computer(Scanner scanner) {
		super(scanner);
	}

	@Override
	public void display() {
		System.out.print("コンピューター: ");
		for(int i = 0; i < this.cards.size(); i++) {
			System.out.print("(" + i + ")[###] ");
		}
		System.out.println("");
	}

	@Override
	public void select(Attender attender) {
		System.out.println("コンピューターの番です。Enter キーを押してください。");
		this.scanner.nextLine();

		int maxIndex = attender.getNumberOfCards() - 1;

		Random random = new Random();
		int index = random.nextInt(maxIndex + 1);

		Card card = attender.giveCard(index);
		System.out.println("引いたカード: " + card.toString());
		this.addCard(card);

		this.removeSameCards();


		Collections.shuffle(this.cards);
	}

}
