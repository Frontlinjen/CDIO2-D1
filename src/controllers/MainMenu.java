package controllers;

import data.IOperatoerDTO;
import data.OperatoerDTO;
import functionality.IOperatoerDAO;
import functionality.OperatoerDAOMemory;
import interfaces.ConsoleGUI;
import interfaces.IGUI;
import functionality.IOperatoerDAO;
import functionality.IOperatoerDAO.DALException;

public class MainMenu {
	private IGUI gui;
	private IOperatoerDAO func;
	private IOperatoerDTO user;
	public static void main(String[] args) {
		OperatoerDAOMemory func = new OperatoerDAOMemory();
		try {
			func.createOperatoer(new OperatoerDTO(22, "Test1", "TS1", 0022, "sesame"));
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
							selection = gui.getUserSelection("\u04D4" + "ndre password", "Start v" + "\u04D5" + "gt programmet", "Logud", "Opret ny bruger");
						}
						else
						{
							selection = gui.getUserSelection("\u04D4" + "ndre password", "Start v" + "\u04D5" + "gt programmet", "Logud");
							
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
								break;
							}
							case 1:
							{
								WeightMenu wMenu = new WeightMenu(gui, func, user);
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