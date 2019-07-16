package work;

import main.Listener;
import main.Man;

public class Jobs extends Listener {
	public static void menu () {
		boolean exit = false;
		while(!exit) {
			if (Man.employed == false) {
				System.out.printf("Welcome to the labour market hope your CV is intact\n"
						+ "Where would you like to work\n"
						+ "1: Banking\n"
						+ "2: Library\n"
						+ "3: exit\n");
				int response = getResponse(0);
				switch (response) {
					case 1:
						Banking.home();
						break;
					case 2:
						Library.home();
						break;
					case 3:
						exit = true;
						break;
					default:
						System.out.println("Invalid Option");
				}
			}
		}
	}
	

}
