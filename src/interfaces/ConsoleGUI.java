package interfaces;

import java.util.Scanner;


public class ConsoleGUI implements IGUI{
	Scanner input = new Scanner(System.in);


	@Override
	public String getPassword() {
		System.out.println("Indtast password: ");
		return input.next();
	}
	@Override
	public int getUID() {
		return getUserInt("Indtast brugerID: ");
	}
	@Override
	public String getName() {
		System.out.println("Indtast navn: ");
		input.nextLine();
		if(input.hasNextLine())
			return input.nextLine();
		else
			return null; //Never reached as hasNextLine waits for input
		
	}
	@Override
	public String getIni() {
		System.out.println("Indtast initialer: ");
		return input.next();
	}
	@Override
	public int getCpr() {
		return getUserInt("Indtast CPR: ");
	}
	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}
	@Override
	public int getUserSelection(String... strings) {
		System.out.println("Du har nu følgende muligheder:");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(String.format("%d.\t%s", i, strings[i]));
		}
		return getUserInt("");
	}
	@Override
	public String getUserString(String message) {
		System.out.println(message);
		return input.next();
	}
	@Override
	public double getUserDouble(String message) {
		System.out.println(message);
		try{
			return input.nextDouble();
		} 
		catch(Exception e){
			System.out.println("Indtast et tal");
			input.next();
			return getUserDouble(message);
		}
	}
	
	public int getUserInt(String message) {
		System.out.println(message);
		try{
			return input.nextInt();
		}
		catch(Exception e){
			System.out.println("Indtast et tal");
			input.next();
			return getUserInt(message);
		}
	}
}