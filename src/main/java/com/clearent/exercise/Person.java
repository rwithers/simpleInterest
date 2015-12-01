package com.clearent.exercise;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.clearent.exercise.cards.CardInterface;

public class Person implements InterestAccumulator {

	private ArrayList<Wallet> wallets;

	public Person() {
		wallets = new ArrayList<Wallet>();
	}

	public void addWallet(Wallet w) {
		wallets.add(w);
	}

	public ArrayList<Wallet> getWallets() {
		return wallets;
	}

	public BigDecimal accumulateTotalInterest() {
		BigDecimal amount = new BigDecimal(0);
		for (Wallet w : wallets) {
			ArrayList<CardInterface> cards = w.getCards();
			for (CardInterface c : cards) {
				BigDecimal calculatedInterest = c.getCalculatedInterest();
				amount = amount.add(calculatedInterest);
			}
		}
		return amount;
	}
}
