import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import javax.imageio.ImageIO;
import java.math.*;
import java.awt.Polygon;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.OOPGraphics;

public class TurtleGraphics extends OOPGraphics {
	public boolean saveCommands = true;
	public void about() {
		super.about();
		reset();
		setStroke(10);
		penDown();
		turnRight(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnRight(90);
		forward(80);
		turnRight(90);
		forward(100);
		turnLeft(180);
		penUp();
		forward(100);
		penDown();
		turnLeft(60);
		forward(200);
		turnRight(125);
		forward(190);
		turnLeft(180);
		forward(90);
		turnLeft(65);
		forward(94);
		turnRight(180);
		forward(94);
		penUp();
		turnLeft(90);
		forward(90);
		turnRight(90);
		forward(150);
		turnRight(90);
		penDown();
		turnRight(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnLeft(90);
		forward(100);
		turnRight(90);
		forward(80);
		turnRight(90);
		forward(100);
		turnLeft(180);

	}

	public void processCommand(String command) {


		String[] commandArray = command.split(" ");
		saveCommands(command);
		if (Objects.equals(commandArray[0], "loadcommand")) {
			saveCommands = false;
			loadCommand(command);
			return;
		}

		if (Objects.equals(command, "pen down")) {
				penDown();
			}
			if (Objects.equals(commandArray[0], "forward")) {
				String amount = commandArray[1];
				Integer amount1 = Integer.valueOf(amount);
				forward(amount1);
			}
			if (Objects.equals(commandArray[0], "backward")) {
				String amount = commandArray[1];
				Integer amount1 = Integer.valueOf(amount);
				forward(-amount1);
			}
			if (Objects.equals(commandArray[0], "turnleft")) {
				String amount = commandArray[1];
				Integer amount1 = Integer.valueOf(amount);
				turnLeft(amount1);
			}
			if (Objects.equals(commandArray[0], "turnright")) {
				String amount = commandArray[1];
				Integer amount1 = Integer.valueOf(amount);
				turnRight(amount1);
			}
			if (Objects.equals(commandArray[0], "clear")) {
				clear();
			}
			if (Objects.equals(command, "pen up")) {
				penUp();
			}
			if (Objects.equals(commandArray[0], "black")) {
				setPenColour(Color.black);
			}
			if (Objects.equals(commandArray[0], "white")) {
				setPenColour(Color.white);
			}
			if (Objects.equals(commandArray[0], "green")) {
				setPenColour(Color.green);
			}
			if (Objects.equals(commandArray[0], "red")) {
				setPenColour(Color.red);
			}
			if (Objects.equals(commandArray[0], "reset")) {
				reset();
				penDown();
			}
			if (Objects.equals(command, "about")) {
				about();
			}
			if (Objects.equals(commandArray[0], "square")) {
				String length = commandArray[1];
				Integer length1 = Integer.valueOf(length);
				forward(length1);
				turnRight(90);
				forward(length1);
				turnRight(90);
				forward(length1);
				turnRight(90);
				forward(length1);
			}
			if (Objects.equals(commandArray[0], "equilateraltriangle")) {
				String length = commandArray[1];
				Integer length1 = Integer.valueOf(length);
				setStroke(5);
				forward(length1);
				turnRight(120);
				forward(length1);
				turnRight(120);
				forward(length1);
			}
			if (Objects.equals(commandArray[0], "triangle")) {
				String sidea = commandArray[1];
				String sideb = commandArray[2];
				String sidec = commandArray[3];
				Integer sideaa = Integer.valueOf(sidea);
				Integer sidebb = Integer.valueOf(sideb);
				Integer sidecc = Integer.valueOf(sidec);
				int[] yPoints = new int[1];
				yPoints[0] = 300;
				int[] xPoints = new int[1];
				xPoints[0] = 300;
				forward(sideaa);
				turnRight(135);

				forward(sidebb);
				turnRight(135);
				forward(sidecc + 2);
				turnRight(90);
				forward((int) Math.sqrt(Math.pow(sideaa, 2) + Math.pow(sidebb, 2)));
				drawLine(Color.black, xPoints[0], yPoints[0], xPoints[0], yPoints[0]);

				turnRight(135);
			}
			if (Objects.equals(commandArray[0], "width")) {
				String amount = commandArray[1];
				Integer amount1 = Integer.valueOf(amount);
				setStroke(amount1);
			}
			if (Objects.equals(commandArray[0], "save")) {

				BufferedImage buff = getBufferedImage();
				File outputFile = new File("image.jpeg");
				try {
					ImageIO.write(buff, "jpeg", outputFile);
					System.out.println("Image saved to: " + outputFile.getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (Objects.equals(commandArray[0], "load")) {
				String path = "image.jpeg";
				File outputFile = new File("image.jpeg");
				try {
					BufferedImage image = ImageIO.read(new File(path));
					setBufferedImage(image);
					System.out.println("Image loaded from: " + outputFile.getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

	}
	public void saveCommands(String command) {
		File outputFile1 = new File("command.txt");
		try (BufferedWriter commands = new BufferedWriter(new FileWriter(outputFile1, true))) {
			commands.append(command);
			commands.newLine();
			System.out.println("Command saved to: " + outputFile1.getAbsolutePath());
			saveCommands = false;
		} catch (IOException e) {
			throw new RuntimeException("Error saving command: " + e.getMessage());
		}
	}
	public void loadCommand(String command) {
		saveCommands = false;
		File inputFile1 = new File("command.txt");
		try (BufferedReader commands = new BufferedReader(new FileReader(inputFile1))) {
			String loadedCommand;
			while ((loadedCommand = commands.readLine()) != null) {
				processCommand(loadedCommand);
			}
			commands.close();
			System.out.println("Commands loaded and executed from: " + inputFile1.getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}





