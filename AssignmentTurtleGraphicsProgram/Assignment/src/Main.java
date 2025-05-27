import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Objects;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.OOPGraphics;

public class Main extends TurtleGraphics {
	public static void main(String[] args) {
		new Main(); //create instance of class that extends OOPGraphics (could be separate class without main), gets out of static context
	}

	public Main() {
		JFrame MainFrame = new JFrame();                //create a frame to display the turtle panel on
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make sure the app exits when closed
		MainFrame.setLayout(new FlowLayout());  //not strictly necessary
		MainFrame.add(this);                                    //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
		MainFrame.pack();                                               //set the frame to a size we can see
		MainFrame.setVisible(true);
		penDown();
//now display it

		// about();
		// call the OOPGraphics about method to display version information.

		setPenColour(new Color(255,0, 255));

	}


	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	public void processCommand(String command)      //this method must be provided because OOPGraphics will call it when it's JTextField is used
	{
		super.processCommand(command);



	}
}