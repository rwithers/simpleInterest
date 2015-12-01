package com.clearent.exercise.cards;

import java.math.BigDecimal;

import com.clearent.exercise.CardTypeEnum;

public class VisaCard extends AbstractCard {

	private BigDecimal interestRate = new BigDecimal(0.1);
	
	public VisaCard(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public BigDecimal getInterestRate() {
		return interestRate;
	}

	@Override
	public CardTypeEnum getCardType() {
		return CardTypeEnum.VISA;
	}

}
