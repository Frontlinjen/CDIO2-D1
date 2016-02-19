package interfaces;

import java.util.Scanner;
import data.OperatoerDTO;


public class ConsoleGUI implements IGUI{
	Scanner input = new Scanner(System.in);

	

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
	@Override
	public void showMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getUserSelection(String... strings) {
		System.out.println("Du har nu følgende valgmuligheder: ");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(String.format("%i.\t%s", i, strings[i]));
		}
		return input.nextInt();
	}
	@Override
	public String getString() {
		return input.next();
	}
}
