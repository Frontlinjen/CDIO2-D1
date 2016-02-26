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
			selection = gui.getUserSelection("Start v" + "\u04D5" + "gt", "exit");
			switch(selection){
				case 0: {
					double i = gui.getUserDouble("Indtast tara-v" + "\u04D5" + "gten i kg:");
					double j = gui.getUserDouble("Indtast brutto-v" + "\u04D5" + "gten i kg:");
					gui.showMessage("Netto-v" + "\u04D5" + "gten er: " + (j-i) + " kg");
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
