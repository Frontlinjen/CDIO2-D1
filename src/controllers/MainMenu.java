package controllers;

import data.IOperatoerDTO;
import data.OperatoerDTO;
import functionality.IOperatoerDAO;
import functionality.OperatoerDAOMemory;
import interfaces.ConsoleGUI;
import interfaces.IGUI;
import functionality.IOperatoerDAO.DALException;

public class MainMenu {
	private IGUI gui;
	private IOperatoerDAO func;
	private IOperatoerDTO user;
	public static void main(String[] args) {
		OperatoerDAOMemory func = new OperatoerDAOMemory();
		try {
			func.createOperatoer(new OperatoerDTO(10, "Admin", "SU", 666, "admin"));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MainMenu start = new MainMenu(new ConsoleGUI(), func);
		start.execute();
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
		if(user==null || !user.getPassword().equals(passwd))
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
					{
						promptLogin();
					}
					else
					{
					
						int selection = -1;
						if(user.getID()==10)
						{
							selection = gui.getUserSelection("Ændre password", "Start vægt programmet", "Logud", "Opret ny bruger");
						}
						else
						{
							selection = gui.getUserSelection("Ændre password", "Start vægt programmet", "Logud");
							
						}
						switch(selection)
						{
							case 0:
							{
								ChangePassword passMenu = new ChangePassword(gui, func, user);
								passMenu.execute();
								break;
							}
							case 1:
							{
								WeightMenu wMenu = new WeightMenu(gui);
								wMenu.execute();
								break;
							}
							case 2:
							{
								user = null;
								break;
							}
							case 3:
							{
								CreateNewUser menu = new CreateNewUser(gui, func, user);
								menu.execute();
								break;
							}
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("An error accoured: " + e.getMessage());
					e.printStackTrace();
				}	
			}
		
	}
	
}