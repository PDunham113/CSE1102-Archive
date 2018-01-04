package stateMachine;
import java.util.Scanner;

/****************************************************************************
 * Interprets commands from the user to control the state machine.
 *
 ***************************************************************************/
public class CommandInterpreter {

	/************************************************************************
	 * Interprets the user commands
	 * @param mainPlayer The <code>Agent</code> being controlled.
	 * 
	 ************************************************************************/
	public static void run(Agent mainPlayer) {
		boolean contin = true;
		String input;

		@SuppressWarnings("resource")
		Scanner kbd = new Scanner(System.in);

		System.out.println(mainPlayer.getName() + " is in " + mainPlayer.getLocation());
		
		do {
			System.out.print("==> ");

			input = kbd.next();
			
			if(input.equals("go")) {
				mainPlayer.usePortal();
			}
			else if(input.equals("help")) {
				System.out.println("The possible commands are:\n"
									+ "-go \n"
									+ "-help \n"
									+ "-look \n"
									+ "-quit \n"
									+ "-where");
			}
			else if(input.equals("look")) {
				Space location = mainPlayer.getLocation();
				System.out.println(location.toStringLong());
			}
			else if(input.equals("quit")) {
				contin = false;
			}
			else if(input.equals("where")) {
				System.out.println(mainPlayer.getLocation());
			}
			else {
				System.out.println("Sorry, I don't understand '" + input + "'");
			}

		}
		while(contin);
	}
}