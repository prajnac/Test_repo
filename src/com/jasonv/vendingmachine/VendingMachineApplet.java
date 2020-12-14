package com.jasonv.vendingmachine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

/**
 * Applet GUI Code
 */
public class VendingMachineApplet extends Applet
{
	private static final long serialVersionUID = 1L;

	VendingMachine vm = new VendingMachine();
	JTextArea messageField = new JTextArea();
    JTextField[] productPurchasedFields = new JTextField[3];
    JTextField changeReceivedField = new JTextField();
    JTextField changeReceivedPennyField = new JTextField("0");
    JTextField changeReceivednickelPenceField = new JTextField("0");
	JTextField changeReceiveddimeField = new JTextField("0");
	JTextField changeReceivedquarterField = new JTextField("0");


	public void init()
	{
		initUI();
		updateFields();
	}
	
	public void updateFields()
	{
		// Display
		messageField.setText(vm.getMessage());
		
		// Products Purchased
		int index=0;
		for(JTextField productPurchasedField:productPurchasedFields)
		{
			productPurchasedField.setText("" + vm.getProduct(index).getCansPurchased());
			index++;
		}
		
		// Change Return
		Change change = vm.getChangeReturn();
		changeReceivedPennyField.setText("" + change.getPenny());
		changeReceivednickelPenceField.setText("" + change.getNickel());
		changeReceiveddimeField.setText("" + change.getDime());
		changeReceivedquarterField.setText("" + change.getQuarter());

		changeReceivedField.setText(vm.getChangeReturnString());
	}
	
	public void initUI() {

        setLayout(new GridLayout(1,2));
        setSize(700, 500);

        add(createEmployeeJPanel());
        add(createVendingMachineJPanel());
        add(createCustomerJPanel());
   }

	public JPanel createEmployeeJPanel()
	{
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(vm.getProducts().size()+9,1));
		jPanel.setBorder(new MatteBorder(5, 5, 5, 5,Color.magenta));
		jPanel.add(new JLabel("STORE",JLabel.CENTER));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel("Load"));
		int index = 0;
	    JButton[] loadProductButtons = new JButton[3];

        for(final Product product:vm.getProducts().toList())
        {
    		loadProductButtons[index] = new JButton(product.getName());
    		loadProductButtons[index].addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	vm.stock(product.getName(), 1);
                	updateFields();
                }
            });      
        	index++;
        }
		
		for(JButton loadProductButton:loadProductButtons)
		{
			jPanel.add(loadProductButton);
		}
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		return jPanel;
	}
	
	public JPanel createVendingMachineJPanel()
	{
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(vm.getProducts().size()+9,1));
		jPanel.setBorder(new MatteBorder(10, 10, 10, 10, Color.green));
		jPanel.add(new JLabel("VENDING MACHINE",JLabel.CENTER));
		messageField.setRows(2);
		messageField.setEditable(false);
		jPanel.add(messageField);
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel("Purchase"));

		int index = 0;
		
	    JButton[] productButtons = new JButton[3];
        for(final Product product:vm.getProducts().toList())
        {
    		productButtons[index] = new JButton(product.getName());
    		productButtons[index].addActionListener(new ActionListener() {
    			 
                public void actionPerformed(ActionEvent e)
                {
                	vm.purchase(product.getName());
                	updateFields();
                }
            }); 
        	index++;
        }
		
		for(JButton productButton:productButtons)
		{
			jPanel.add(productButton);
		}
		jPanel.add(new JLabel(""));
		jPanel.add(createCoinReturnButton());
		jPanel.add(new JLabel(""));
		return jPanel;
	}

	public JButton createCoinButton(final String amount)
	{
		JButton jButton = new JButton("$"+amount);
		jButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	vm.insertMoney(amount);
            	updateFields();
            }
		});
		return jButton;
	}
	
	public JButton createCoinReturnButton()
	{
		JButton jButton = new JButton("Cancel");
		jButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	vm.returnChange();
            	updateFields();
            }
		});
		return jButton;
	}
	
	public JPanel createCustomerJPanel()
	{
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(vm.getProducts().size()+9,1));
		jPanel.setBorder(new MatteBorder(5, 5, 5, 5,Color.CYAN));
		jPanel.add(new JLabel("CUSTOMER",JLabel.CENTER));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel(""));
		jPanel.add(new JLabel("Amount to Insert"));

		JPanel coinPanel = new JPanel(new GridLayout(1,3));
		coinPanel.add(createCoinButton("0.01"));
		coinPanel.add(createCoinButton("0.05"));
		coinPanel.add(createCoinButton("0.10"));
		coinPanel.add(createCoinButton("0.25"));

		jPanel.add(coinPanel);
		jPanel.add(new JLabel("Purchased"));
        for(int index=0; index<vm.getProducts().size();index++)
        {
    		productPurchasedFields[index] = new JTextField("0");
    		productPurchasedFields[index].setEditable(false);
        }
		
		for(JTextField productPurchasedField:productPurchasedFields)
		{
			jPanel.add(productPurchasedField);
		}
		jPanel.add(new JLabel("Change Returned"));
		jPanel.add(createChangeReturnedJPanel());
		return jPanel;
	}
	
	public JPanel createChangeReturnedJPanel()
	{
		JPanel p = new JPanel(new GridLayout(2,4));
		p.add(new JLabel("Penny"));
		p.add(new JLabel("Nickel"));
		p.add(new JLabel("Dime"));
		p.add(new JLabel("Quarter"));

		
		changeReceivedPennyField.setEditable(false);
		changeReceivednickelPenceField.setEditable(false);
		changeReceiveddimeField.setEditable(false);
		changeReceivedquarterField.setEditable(false);
		
		p.add(changeReceivedPennyField);
		p.add(changeReceivednickelPenceField);
		p.add(changeReceiveddimeField);
		p.add(changeReceivedquarterField);

		return p;
	}
}
