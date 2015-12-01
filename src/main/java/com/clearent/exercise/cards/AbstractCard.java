package com.clearent.exercise.cards;

import java.math.BigDecimal;

public abstract class AbstractCard implements CardInterface {
	private BigDecimal balance = null;	
	
	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public BigDecimal getCalculatedInterest() {
		return getInterestRate().multiply(getBalance());
	}

}
