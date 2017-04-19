package GYM_WATCH;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import gym.model.GymWatchModel;
import gym.view.frame.Frame;

public class GymWatch implements Runnable{
	@Override
	public void run() {
		try {
			new Frame(new GymWatchModel());
			
			
			
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new GymWatch());
	}
}
