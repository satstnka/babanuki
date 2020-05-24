package jp.trans_it.game.babanuki;

import java.util.Scanner;

public class Babanuki {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("ババ抜きをはじめます。Enter キーを押してください。");
		scanner.nextLine();

		Player player = new Player(scanner);
		Computer computer = new Computer(scanner);

		Attender attenders[] = { player, computer };

		prepareGame(attenders, scanner);

		int attenderIndex = 0;
		while(player.getNumberOfCards() > 0 && computer.getNumberOfCards() > 0) {
			int nextIndex = (attenderIndex + 1) % 2;

			Attender attender1 = attenders[attenderIndex];
			Attender attender2 = attenders[nextIndex];
			attender1.select(attender2);

			attenderIndex = nextIndex;
		}

		if(player.getNumberOfCards() == 0) {
			System.out.println("あなたの勝ちです。");
		}
		else {
			System.out.println("あなたの負けです。");
		}

		scanner.close();
	}

	private static void prepareGame(Attender[] attenders, Scanner scanner) {
		int attenderIndex = 0;

		Stock stock = new Stock();
		while(stock.getNumberOfCards() > 0) {
			Attender attender = attenders[attenderIndex];
			Card card = stock.pickCard();
			attender.addCard(card);

			// 0 と 1 を交互に繰り返す。
			attenderIndex = (attenderIndex + 1) % 2;
		}

		for(int i = attenders.length - 1; i >= 0; i--) {
			attenders[i].display();
		}

		System.out.println("同じカードを捨てます。Enter キーを押してください。");
		scanner.nextLine();
		for(int i = 0; i < attenders.length; i++) {
			attenders[i].removeSameCards();
		}
	}
}
