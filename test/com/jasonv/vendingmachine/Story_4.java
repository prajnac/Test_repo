package com.jasonv.vendingmachine;

import com.jasonv.vendingmachine.VendingMachine;

import junit.framework.TestCase;

/**
 * 4)
 * 
 * As a user of the vending machine I need to be able to collect my remaining
 * balance at any point. Done when pressing the "Coin Return" button returns the
 * minimal number of coins to the user, equal to the user balance, from an infinite
 * supply of Penny, nickle, dime and quarter.
 */
public class Story_4 extends TestCase {
	public void test_simple()
	{
		VendingMachine vm = new VendingMachine();
		vm.returnChange();
		assertEquals("[penny=0, nickel=0, dime=0, quarter=0]",vm.getChangeReturnString());
	}
	
	public void test_simple_2()
	{
		VendingMachine vm = new VendingMachine();
		vm.insertMoney("0.25");
		vm.returnChange();
		assertEquals("[penny=25, nickel=0, dime=0, quarter=0]",vm.getChangeReturnString());
	}
}
