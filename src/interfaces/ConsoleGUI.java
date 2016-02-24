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
		return getUserInt();
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
	public int getCpr() {
		System.out.println("Indtast CPR: ");
		return input.nextInt();
	}
	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}
	@Override
	public int getUserSelection(String... strings) {
		System.out.println("Du har nu f�lgende valgmuligheder: ");
		for (int i = 0; i < strings.length; i++) {
			System.out.println(String.format("%d.\t%s", i, strings[i]));
		}
		return input.nextInt();
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
			return getUserDouble(message);
		}
	}
	
	public double getUserInt(String message) {
		System.out.println(message);
		try{
			return input.nextInt();
		} 
		catch(Exception e){
			System.out.println("Indtast et tal");
			return getUserInt(message);
		}
}
