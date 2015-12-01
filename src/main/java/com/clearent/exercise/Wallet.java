package com.clearent.exercise;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.clearent.exercise.cards.CardInterface;

public class Wallet implements InterestAccumulator {

	private ArrayList<CardInterface> cards = null;

	public Wallet() {
		cards = new ArrayList<CardInterface>();
	}
	
	public void addCard(CardInterface c) {
		cards.add(c);
	}
	
	public ArrayList<CardInterface> getCards() {
		return cards;
	}

	@Override
	public BigDecimal accumulateTotalInterest() {
		BigDecimal amount = new BigDecimal(0);
		for (CardInterface c : cards) {
			BigDecimal calculatedInterest = c.getCalculatedInterest();
			amount = amount.add(calculatedInterest);
		}
		return amount;
	}
}
