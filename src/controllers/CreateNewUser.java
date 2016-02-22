package controllers;

import data.IOperatoerDTO;
import data.OperatoerDTO;
import functionality.IOperatoerDAO;
import interfaces.IGUI;

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
	public void execute()
	{
		IOperatoerDTO newUser;
		String name = gui.getName();
		String ini = gui.getIni();
		int cpr = gui.getCpr();
		String password = "";
		String passrepeat;
		boolean notEqual = true;
		do
		{
			password = gui.getPassword();
			passrepeat = gui.getUserString("Gentag venligst password:");
			notEqual = !password.equals(passrepeat);
			if(notEqual)
			{
				gui.showMessage("De to password var ikke ens!");
			}
			
		}
		while(notEqual);
		
		newUser = new OperatoerDTO(-1, name, ini, cpr, password);
		try
		{
			func.createOperatoer(newUser);
		}
		catch(Exception e)
		{
			gui.showMessage("Der skete en fejl da brugeren blev forsøgt oprettet: " + e.getMessage());
		}
		
	}
}
