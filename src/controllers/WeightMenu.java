package controllers;

import interfaces.IGUI;

public class WeightMenu {
	private IGUI gui;
	
	public WeightMenu(IGUI gui){
		this.gui = gui;
	}
	
	public void execute(){
		boolean exit = false;
		while(!exit){
			int selection;
			selection = gui.getUserSelection("Start vægt", "exit");
			switch(selection){
				case 0: {
					double i = gui.getUserDouble("Indtast tara-vægten i kg:");
					double j = gui.getUserDouble("Indtast brutto-vægten i kg:");
					gui.showMessage("Netto-vægten er: " + (j-i) + " kg");
					break;
				}
				case 1: {
					exit = true;
					break;
				}
			}
		}
	}
}
