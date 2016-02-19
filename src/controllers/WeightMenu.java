package controllers;

import java.util.Scanner;

import data.IOperatoerDTO;
import functionality.IOperatoerDAO;
import interfaces.IGUI;

public class WeightMenu {
	Scanner input = new Scanner(System.in);
	IGUI gui;
	IOperatoerDAO func;
	IOperatoerDTO user;
	
	public WeightMenu(IGUI gui, IOperatoerDAO func, IOperatoerDTO user){
		this.gui = gui;
		this.func = func;
		this.user = user;
	}
	
	public void execute(){
		while(true){
			int selection;
			selection = gui.getUserSelection("Start vægt", "exit");
			switch(selection){
				case 0: {
					System.out.println("Indtast tara-vægten i kg:");
					int i = input.nextInt();
					System.out.println("Indtast brutto-vægten i kg:");
					int j = input.nextInt();
					System.out.println("Netto-vægten er: " + (j-i) + " kg");
				}
				case 1: {
					
				}
			}
		}
	}
}
