package controllers;

import data.IOperatoerDTO;
import functionality.IOperatoerDAO;
import functionality.OperatoerDAOMemory;
import interfaces.IGUI;
import functionality.IOperatoerDAO;
import functionality.IOperatoerDAO.DALException;

public class MainMenu {
	IGUI gui;
	IOperatoerDAO func;
	IOperatoerDTO user;
	public static void main(String[] args) {
		//MainMenu start = new MainMenu(new ConsoleGUI))
	}
	
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
						selection = gui.getUserSelection("Ændre password", "Start vægt programmet");
					}
					else
					{
						selection = gui.getUserSelection("Ændre password", "Start vægt programmet", "Opret ny bruger");
					}
					switch(selection)
					{
						case 0:
						{
							String prevPass = gui.getUserString("Indtast forrige password:");
							if(prevPass.equals(user.getPassword()))
							{
								String newPass = gui.getUserString("Indtast det nye password:");
								if(newPass.equals(gui.getUserString("Indtast det nye password igen:")))
									{
										user.setPassword(newPass);
										func.updateOperatoer(user);
									}
								else
								{
									gui.showMessage("De nye passwords matchede ikke");
								}
							}
							else
									gui.showMessage("Forkert kode");
						}
						case 1:
						{
							WeightMenu wMenu = new WeightMenu(gui, func, user);
							wMenu.execute();
						}
						case 2:
						{
							CreateNewUser menu = new CreateNewUser(gui, func, user);
							menu.execute();
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
