package controllers;

import java.util.Random;

import data.IOperatoerDTO;
import data.OperatoerDTO;
import functionality.IOperatoerDAO;
import interfaces.IGUI;
import utilities.ShuffleBag;

public class CreateNewUser {
	IGUI gui;
	IOperatoerDAO func;
	IOperatoerDTO user;
	public CreateNewUser(IGUI gui, IOperatoerDAO func, IOperatoerDTO user)
	{
		this.gui = gui;
		this.func = func;
		this.user = user;
	}
	private String generatePassword()
	{
		//amount of rules possible to be applied
		final int RULECOUNT = 4;
		Random rng = new Random(System.currentTimeMillis());
		//Max length of 15 characters
		int length = rng.nextInt(10)+6;
		int count = ((length%RULECOUNT)+length);
		//Number of possibilities to fulfill the requirements
		
		Integer[] possibilities = new Integer[count];
		for (int i = 0; i < count/RULECOUNT; i++) {
			possibilities[i] = 0; //add lowercase char
			possibilities[i+(count/RULECOUNT)] = 1; //add uppercase char
			possibilities[i+(count/RULECOUNT)*2] = 2; //add number
			possibilities[i+(count/RULECOUNT)*3] = 3; //add symbol
		}
		ShuffleBag<Integer> possibilitySelector = new ShuffleBag<Integer>(possibilities);
		String password = "";
		char[] symbols =  {'.', '-', '_', '+', '!', '?', '='} ;
		System.out.println("Genererer kodeord af " + length + " symboler");
		while(--length>=0)
		{
			try {
				switch(possibilitySelector.getNext())
				{
				case 0:
					password+=(char)(rng.nextInt(122-97)+97);
					break;
				case 1:
					password+=(char)(rng.nextInt(90-65)+65);
					break;
				case 2:
					password += rng.nextInt(10);
					break;
				case 3:
					password+=symbols[rng.nextInt(symbols.length)];
					break;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return password;
		
	}
	public void execute()
	{
		IOperatoerDTO newUser;
		String name = gui.getName();
		String ini = gui.getIni();
		int cpr = gui.getCpr();
		String password = generatePassword();		
		newUser = new OperatoerDTO(-1, name, ini, cpr, password);
		try
		{
			func.createOperatoer(newUser);
			gui.showMessage("Ny account skabt med ID: " + newUser.getID() + " og adgangskode: " + password);
		}
		catch(Exception e)
		{
			gui.showMessage("Der skete en fejl da brugeren blev forsøgt oprettet: " + e.getMessage());
		}
		
	}
}
