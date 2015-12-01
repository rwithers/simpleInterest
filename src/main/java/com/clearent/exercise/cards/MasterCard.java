package com.clearent.exercise.cards;

import java.math.BigDecimal;

import com.clearent.exercise.CardTypeEnum;

public class MasterCard extends AbstractCard {

	private BigDecimal interestRate = null;

	public MasterCard(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	@Override
	public CardTypeEnum getCardType() {
		return CardTypeEnum.MC;
	}

}
