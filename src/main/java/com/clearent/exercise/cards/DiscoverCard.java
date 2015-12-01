package com.clearent.exercise.cards;

import java.math.BigDecimal;

import com.clearent.exercise.CardTypeEnum;

public class DiscoverCard extends AbstractCard {
	private BigDecimal interestRate = null;
	
	public DiscoverCard(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public CardTypeEnum getCardType() {
		return CardTypeEnum.DISCOVER;
	}

	@Override
	public BigDecimal getInterestRate() {
		return interestRate;
	}

}
