package jp.trans_it.game.babanuki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 参加者 (プレイヤーとコンピューターのスーパークラス)
 */
public abstract class Attender {
	/** 持っているカード */
	protected List<Card> cards;

	protected Scanner scanner;

	/**
	 * コンストラクタ
	 */
	public Attender(Scanner scanner) {
		this.cards = new ArrayList<Card>();
		this.scanner = scanner;
	}

	/**
	 * カードを追加する
	 * @param card 追加カード
	 */
	public void addCard(Card card) {
		this.cards.add(card);
	}

	/**
	 * カードを渡す
	 * @param index カードのインデックス
	 * @return 対象カード
	 */
	public Card giveCard(int index) {
		Card card = this.cards.get(index);
		this.cards.remove(index);
		return card;
	}

	/**
	 * 残りカードの枚数を取得
	 * @return
	 */
	public int getNumberOfCards() {
		return this.cards.size();
	}

	/**
	 * 同じ番号のカードを捨てる
	 * @return 同じ番号が存在した場合は true
	 */
	public boolean removeSameCards() {
		boolean havingSameCards = false;
		boolean value = false;

		do {
			havingSameCards = false;

			for(int i = 0; i < this.cards.size() - 1&& !havingSameCards; i++) {
				Card card1 = this.cards.get(i);
				for(int j = i + 1; j < this.cards.size() && !havingSameCards; j++) {
					Card card2 = this.cards.get(j);
					if(card1.getNumber() == card2.getNumber()) {
						System.out.println("一致!!! " + card1.toString() + card2.toString());

						// 二つのカードを山札から削除
						// 削除するとそれ以降のインデックスがずれるので
						// 必ず j (数字の大きい方) から削除する
						this.cards.remove(j);
						this.cards.remove(i);
						havingSameCards = true;
						value = true;
					}
				}
			}
		} while(havingSameCards);

		return value;
	}

	public abstract void select(Attender attender);
	public abstract void display();
}
