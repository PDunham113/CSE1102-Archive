package stateMachine;
import java.io.File;

import jeff.imagewindow.ImageWindow;
import jeff.textconsole.TextConsole;

public class CommandInterpreter {

	public static void run(Agent mainPlayer, ImageWindow window, TextConsole console) {
		boolean contin = true;
		String input;

		console.println(mainPlayer.getName() + " is in " + mainPlayer.getLocation());
		
		_showImage(mainPlayer, window);
		
		do {
			console.print("==> ");

			input = console.readLine();
			
			if(input.equals("go")) {
				mainPlayer.usePortal(console);
				_showImage(mainPlayer, window);
			}
			else if(input.equals("help")) {
				console.println("The possible commands are:\n"
									+ "-go \n"
									+ "-help \n"
									+ "-look \n"
									+ "-quit \n"
									+ "-where");
			}
			else if(input.equals("look")) {
				Space location = mainPlayer.getLocation();
				console.println(location.toStringLong());
			}
			else if(input.equals("quit")) {
				contin = false;
			}
			else if(input.equals("where")) {
				console.println(mainPlayer.getLocation().toString());
			}
			else {
				console.println("Sorry, I don't understand '" + input + "'");
			}

		}
		while(contin);
		
		System.exit(0);
	}
	
	private static void _showImage(Agent agent, ImageWindow window) {
		String imageName = agent.getLocation().getImage();
		
		File imageDir  = new File("data", "images");
		File imageFile = new File(imageDir, imageName);
		window.loadImage(imageFile);
	}
	
}
