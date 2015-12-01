package com.clearent.exercise;

import java.math.BigDecimal;

import org.junit.Assert;

import com.clearent.exercise.cards.CardInterface;
import com.clearent.exercise.cards.DiscoverCard;
import com.clearent.exercise.cards.MasterCard;
import com.clearent.exercise.cards.VisaCard;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SimpleInterestTestCases {

	private Person p1;
	private Wallet w1;
	private Wallet w2;
	private Person p2;

	public SimpleInterestTestCases() {
	}

	@Before
	public void scenarioInitialization() {
		p1 = null;
		w1 = null;
		w2 = null;
		p2 = null;
	}
	
	@Given("^One person has a wallet containing a Visa, MC and Discover$")
	public void onePersonHasAWalletContainingAVisaMCAndDiscover() throws Throwable {
		p1 = new Person();
		w1 = new Wallet();

		VisaCard visa = new VisaCard(new BigDecimal(0.1));
		w1.addCard(visa);
		
		MasterCard mc = new MasterCard(new BigDecimal(0.05));
		w1.addCard(mc);
		
		DiscoverCard discover = new DiscoverCard(new BigDecimal(0.01));
		w1.addCard(discover);
		
		p1.addWallet(w1);
	}
	
	@When("^each card has a balance of \\$(\\d+)$")
	public void eachCardHasABalanceOf$(int arg1) throws Throwable {
		if (w1 != null) {
			for (CardInterface c : w1.getCards()) {
				c.setBalance(new BigDecimal(100.0));
			}			
		}
		
		if (w2 != null) {
			for (CardInterface c : w2.getCards()) {
				c.setBalance(new BigDecimal(100.0));
			}			
		}
	}

	@Then("^the persons total interest should be \\$(\\d+)\\.(\\d+)$")
	public void thePersonsTotalInterestShouldBe$(int dollars, int cents) throws Throwable {
		BigDecimal totalInterest = p1.accumulateTotalInterest();
				
		Assert.assertEquals(dollars, totalInterest.intValue());
		Assert.assertEquals(cents, totalInterest.intValue() % dollars);
	}

	@Given("^One person has two wallets, One wallet containing one Visa and one Discover and the other a MC$")
	public void onePersonHasTwoWalletsOneWalletContainingOneVisaAndOneDiscoverAndTheOtherAMC() throws Throwable {
		p1 = new Person();
		w1 = new Wallet();
		w2 = new Wallet();

		VisaCard visa = new VisaCard(new BigDecimal(0.1));
		w1.addCard(visa);

		DiscoverCard discover = new DiscoverCard(new BigDecimal(0.01));
		w1.addCard(discover);
		
		MasterCard mc = new MasterCard(new BigDecimal(0.05));
		w2.addCard(mc);
		
		p1.addWallet(w1);
		p1.addWallet(w2);
	}

	@Then("^interest charged for Visa should be \\$(\\d+)\\.(\\d+), for MC should be \\$(\\d+)\\.(\\d+), and Discover should be \\$(\\d+)\\.(\\d+)$")
	public void interestChargedForVisaShouldBe$ForMCShouldBe$AndDiscoverShouldBe$(int visaDollars, int visaCents, int mcDollars, int mcCents, int discoverDollars, int discoverCents) throws Throwable {

		for (Wallet w : p1.getWallets()) {
			for (CardInterface c : w.getCards()) {
				switch(c.getCardType()) {
				case VISA :
					BigDecimal visaInterest = c.getCalculatedInterest();
					Assert.assertEquals(visaDollars, visaInterest.intValue());
					Assert.assertEquals(visaCents, visaInterest.intValue() % visaDollars);
					break;
				case MC : 
					BigDecimal mcInterest = c.getCalculatedInterest();
					Assert.assertEquals(mcDollars, mcInterest.intValue());
					Assert.assertEquals(mcCents, mcInterest.intValue() % mcDollars);
					break;
				case DISCOVER :
					BigDecimal discoverInterest = c.getCalculatedInterest();
					Assert.assertEquals(discoverDollars, discoverInterest.intValue());
					Assert.assertEquals(discoverCents, discoverInterest.intValue() % discoverDollars);
					break;
				}
			}
		}
		
	}

	@Given("^Person one with wallet one containing a MC and a Visa and Person two with wallet two containing a MC and a Visa$")
	public void personOneWithWalletOneContainingAMCAndAVisaAndPersonTwoWithWalletTwoContainingAMCAndAVisa() throws Throwable {
		p1 = new Person();
		p2 = new Person();
		w1 = new Wallet();
		w2 = new Wallet();

		VisaCard visa1 = new VisaCard(new BigDecimal(0.1));
		w1.addCard(visa1);
		
		MasterCard mc1 = new MasterCard(new BigDecimal(0.05));
		w1.addCard(mc1);
		p1.addWallet(w1);

		VisaCard visa2 = new VisaCard(new BigDecimal(0.1));
		w2.addCard(visa2);
		
		MasterCard mc2 = new MasterCard(new BigDecimal(0.05));
		w2.addCard(mc2);
		
		p2.addWallet(w2);
	}

	@Then("^interest for Person one should be \\$(\\d+)\\.(\\d+) and interest for Person two should be \\$(\\d+)\\.(\\d+)$")
	public void interestForPersonOneShouldBe$AndInterestForPersonTwoShouldBe$(int p1Dollars, int p1Cents, int p2Dollars, int p2Cents) throws Throwable {
		BigDecimal p1TotalInterest = p1.accumulateTotalInterest();
		Assert.assertEquals(p1Dollars, p1TotalInterest.intValue());
		Assert.assertEquals(p1Cents, p1TotalInterest.intValue() % p1Dollars);

		BigDecimal p2TotalInterest = p2.accumulateTotalInterest();
		Assert.assertEquals(p2Dollars, p2TotalInterest.intValue());
		Assert.assertEquals(p2Cents, p2TotalInterest.intValue() % p2Dollars);
	}

	@Then("^interest for wallet one should be \\$(\\d+)\\.(\\d+) and interest for wallet two should be \\$(\\d+)\\.(\\d+)$")
	public void interestForWalletOneShouldBe$AndInterestForWalletTwoShouldBe$(int w1Dollars, int w1Cents, int w2Dollars, int w2Cents) throws Throwable {
		BigDecimal w1TotalInterest = w1.accumulateTotalInterest();
		Assert.assertEquals(w1Dollars, w1TotalInterest.intValue());
		Assert.assertEquals(w1Cents, w1TotalInterest.intValue() % w1Dollars);
		
		BigDecimal w2TotalInterest = w2.accumulateTotalInterest();
		Assert.assertEquals(w2Dollars, w2TotalInterest.intValue());
		Assert.assertEquals(w2Cents, w2TotalInterest.intValue() % w2Dollars);		
	}

}
