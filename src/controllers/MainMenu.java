package controllers;

import data.IOperatoerDTO;
import functionality.IOperatoerDAO;
import interfaces.IGUI;
import functionality.IOperatoerDAO;
import functionality.IOperatoerDAO.DALException;

public class MainMenu {
	IGUI gui;
	IOperatoerDAO func;
	IOperatoerDTO user;
	
	public MainMenu(IGUI gui, IOperatoerDAO func)
	{
		this.gui = gui;
		this.func = func;
	}
	
	private void promptLogin() throws DALException
	{
		int operId = gui.getUID();
		String passwd = gui.getPassword();
		user = func.getOperatoer(operId);
		if(user==null || user.getPassword().equals(passwd))
		{
			gui.showMessage("Forkert id eller password");
			user = null; //User should not be logged in if they entered the wrong password
		}
		
	}
	
	public void execute()
	{
		while(true)
			{			
				try
				{
					if(user==null)
						promptLogin();
					int selection = -1;
					if(user.getID()==10)
					{
						selection = gui.getUserSelection("Ændre password", "Tilgå applikation");
					}
					else
					{
						selection = gui.getUserSelection("Ændre password", "Tilgå applikation","Opret ny bruger");
					}
					switch(selection)
					{
						case 0:
						{
							
						}
						case 1:
						{
							
						}
						case 2:
						{
							
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("An error accoured: " + e.getMessage());
				}	
			}
		
	}
	
}
