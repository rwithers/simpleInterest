Feature: Simple Interest
  Scenario: Calculate total interest for a person with 1 wallet
    Given One person has a wallet containing a Visa, MC and Discover
    When each card has a balance of $100 
    Then the persons total interest should be $16.0
    And interest charged for Visa should be $10.0, for MC should be $5.0, and Discover should be $1.0
    
  Scenario: Calculate total interest for a person with 2 wallets and 3 cards
    Given One person has two wallets, One wallet containing one Visa and one Discover and the other a MC
    When each card has a balance of $100 
    Then the persons total interest should be $16.0
    And interest charged for Visa should be $10.0, for MC should be $5.0, and Discover should be $1.0
    
  Scenario: Calculate total interest per person 
    Given Person one with wallet one containing a MC and a Visa and Person two with wallet two containing a MC and a Visa
    When each card has a balance of $100
    Then interest for Person one should be $15.0 and interest for Person two should be $15.0
    And interest for wallet one should be $15.0 and interest for wallet two should be $15.0
