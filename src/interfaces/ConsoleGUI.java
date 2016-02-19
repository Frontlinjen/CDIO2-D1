package interfaces;

import java.util.Scanner;
import data.OperatoerDTO;
import functionality.IOperatoerDAO;
import functionality.IOperatoerDAO.DALException;

public class ConsoleGUI implements IGUI{
	Scanner input = new Scanner(System.in);
	
//	
//	public ConsoleGUI(IOperatoerDAO func)
//	{
//		this.func = func;
//	}
//	private void promptLogin() throws DALException
//	{
//		System.out.println("Login:\nID:");
//		int operId = input.nextInt();
//		user = func.getOperatoer(operId);
//		
//	}
//	public void startGUI()
//	{
//			while(true)
//			{			
//				try
//				{
//					if(user==null)
//						promptLogin();
//					
//				}
//				catch(Exception e)
//				{
//					System.out.println("An error accoured: " + e.getMessage());
//				}	
//			}
//		
//	
//		
//	}
//	public static void main(String[] args) {
//		ConsoleGUI gui = new ConsoleGUI(null);
//	}
	@Override
	public String getPassword() {
		System.out.println("Indtast password: ");
		return input.next();
	}
	@Override
	public int getUID() {
		System.out.println("Indtast brugerID: ");
		return input.nextInt();
	}
	@Override
	public String getName() {
		System.out.println("Indtast navn: ");
		return input.nextLine();
	}
	@Override
	public String getIni() {
		System.out.println("Indtast initialer: ");
		return input.next();
	}
	@Override
	public String getCpr() {
		System.out.println("Indtast CPR: ");
		return input.next();
	}
}
