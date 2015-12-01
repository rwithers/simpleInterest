package com.clearent.exercise.cards;

import java.math.BigDecimal;

import com.clearent.exercise.CardTypeEnum;

public interface CardInterface {

	public BigDecimal getBalance();
	
	public void setBalance(BigDecimal d);

	public BigDecimal getCalculatedInterest();
	
	public BigDecimal getInterestRate();

	public CardTypeEnum getCardType();
	
}
