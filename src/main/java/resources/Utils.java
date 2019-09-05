package resources;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utils {
	
	//A quick way to get input from the user. 
	public String AskForUserInput(String Message, String Title)
	{
		
		//Creates a frame so on windows you can see the Message
		JFrame frame = new JFrame(Title);
        frame.setUndecorated( true );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
		
        //Ask the user the question
		String UserValue = (String)JOptionPane.showInputDialog(
				frame, 
				Message,
				Title,
				JOptionPane.WARNING_MESSAGE,
				null, 
				null, 
				null);
		
		//Closes the Frame
		frame.dispose();
		return UserValue; 
		
	}

}
