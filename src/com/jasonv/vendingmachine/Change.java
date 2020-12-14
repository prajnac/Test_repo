package com.jasonv.vendingmachine;

import java.math.BigDecimal;

/**
 * Takes a pound amount and breaks it into coins.
 */
public class Change 
{
	Change(BigDecimal amount)
	{
		calculate(amount.multiply(new BigDecimal(100)).intValue());
	}
	void calculate(int amount)
	{
		int currentAmount = amount;
		while(currentAmount>=1)
		{
			penny++;
			currentAmount-=1;
		}
		while(currentAmount>=5)
		{
			nickel++;
			currentAmount-=5;
		}
		while(currentAmount>=10)
		{
			dime++;
			currentAmount-=10;
		}
		while(currentAmount>=25)
		{
			quarter++;
			currentAmount-=25;
		}
	}
	int penny = 0;
	int nickel = 0;
	int dime = 0;
	int quarter = 0;

	public String toString()
	{
		return String.format("[penny=%d, nickel=%d, dime=%d, quarter=%d]", penny,nickel,dime,quarter);
	}
	public int getPenny() {
		return penny;
	}
	public void setPenny(int penny) {
		this.penny = penny;
	}
	public int getNickel() {
		return nickel;
	}
	public void setNickel(int nickel) {
		this.nickel = nickel;
	}
	public int getDime() { return dime;}
	public void setDime(int dime) {
		this.dime = dime;
	}
	public int getQuarter() {return quarter;}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

}
