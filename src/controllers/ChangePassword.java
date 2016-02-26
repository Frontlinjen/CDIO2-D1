package controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import data.IOperatoerDTO;
import functionality.IOperatoerDAO;
import functionality.IOperatoerDAO.DALException;
import interfaces.IGUI;

public class ChangePassword {

	IGUI gui;
	IOperatoerDAO func;
	IOperatoerDTO user;
	public ChangePassword(IGUI gui, IOperatoerDAO func, IOperatoerDTO user)
	{
		this.gui = gui;
		this.func = func;
		this.user = user;
	}
	private boolean verifyPassword(String newPass)
	{
		if(newPass.length()<6)
		{
			return false;
		}
		//Contains all the allowed symbols
		Set<Character> allowedSymbols = new HashSet<Character>(Arrays.asList('.', '-', '_', '+', '!', '?', '='));
		//contains the count of each type of character in the string
		int uppercase = 0;
		int lowercase = 0;
		int symbols = 0;
		int numbers = 0;
		
		for (int i = 0; i < newPass.length(); i++) {
			char current = newPass.charAt(i);
			if(Character.isUpperCase(current))
			{
				uppercase = 1;
			}
			else if(Character.isLowerCase(current))
			{
				lowercase = 1;
			}
			else if(Character.isDefined(current))
			{
				numbers = 1;
			}
			else if(allowedSymbols.contains(current))
			{
				symbols = 1;
			}
		}
		if((uppercase+lowercase+numbers+symbols)>=3)
		{
			return true;
		}
		return false;
	}
	public void execute()
	{
		String prevPass = gui.getUserString("Indtast forrige password:");
		if(prevPass.equals(user.getPassword()))
		{
			String newPass = gui.getUserString("Indtast det nye password:");
			if(newPass.equals(gui.getUserString("Indtast det nye password igen:")))
				{
					if(verifyPassword(newPass))
					{
						user.setPassword(newPass);
						try {
							func.updateOperatoer(user);
						} catch (DALException e) {
							gui.showMessage("Der skete en fejl da passwordet var forsøgt opdateret: " + e.getMessage());	}
					}
					else
					{
						gui.showMessage("Passwordet overholder ikke reglerne for DTU's standarder");
					}
					
				}
			else
			{
				gui.showMessage("De nye passwords matchede ikke");
			}
		}
		else
				gui.showMessage("Forkert kode");
	}
	
}
