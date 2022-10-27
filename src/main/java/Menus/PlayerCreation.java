package Menus;

import Models.Entities.Player;
import Util.UtilMenu;

import java.util.Scanner;

public class PlayerCreation extends UtilMenu {
	
	// FIXME : Prévenir de la condition (35 char max)
	public static Player player_creation_menu () {
		Scanner sc = new Scanner(System.in);
		String  input;
		do {
			ask("What is your name ?");
			input = sc.nextLine().strip();
			if (input.length() >= 35) {
				warning("Name must be less than 36 characters long");
			}
			else if (input.equals("")) {
				warning("Name cannot be empty");
			}
		} while (input.length() > 15 || input.equals(""));
		return new Player(input);
	}
}
