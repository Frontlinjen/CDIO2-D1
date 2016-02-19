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
		
	}
	
	public void execute()
	{
		while(true)
			{			
				try
				{
					if(user==null)
						promptLogin();
					
				}
				catch(Exception e)
				{
					System.out.println("An error accoured: " + e.getMessage());
				}	
			}
		
	}
	
}
