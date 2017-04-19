package gym.view.frame;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gym.model.GymWatchModel;

public class Frame {
	private JFrame frame;
	private GymWatchModel model;
	private TabbedPaneMain tabbedPaneMain;
	
	
	public Frame(GymWatchModel model) throws HeadlessException, SQLException{
		this.model = model;
		
		login();
//		createPartControl();
		
	}
	private void login() throws HeadlessException, SQLException{

		JTextField username = new JTextField();
		JTextField password = new JPasswordField();
		Object[] message = {
				"Username:", username,
				"Password:", password
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
		
			if(model.WebInfoCheck((username.getText()), password.getText())){
				JOptionPane.showMessageDialog(frame, "Correct. User "+username.getText());
				createPartControl();
			}
			else {
				JOptionPane.showMessageDialog(frame,
						"WRONG",
						"Inane error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame,
					"Canceled",
					"Inane error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	private void createPartControl(){
		
		
		frame = new JFrame();
		tabbedPaneMain = new TabbedPaneMain(this, model);
		frame.setTitle("GYM WATCH v.3");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				exitProcedure();
			}
		});
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(tabbedPaneMain);
		
		
		
		
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		frame.add(mainPanel);
		frame.pack();
		frame.setBounds(getBounds());
		frame.setVisible(true);
		
		
		
	}
	
	
	
	public void exitProcedure(){
		frame.dispose();
		System.exit(0);
	}
	
	
	protected Rectangle getBounds() {
		Rectangle f = frame.getBounds();
		Rectangle w = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		f.x = (w.width - f.width) / 2;
		f.y = (w.height - f.height) / 2;
		return f;
	}
	public JFrame getFrame() {
		return frame;
	}
	public GymWatchModel getModel() {
		return model;
	}
	public TabbedPaneMain getTabbedPaneMain() {
		return tabbedPaneMain;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public void setModel(GymWatchModel model) {
		this.model = model;
	}
	public void setTabbedPaneMain(TabbedPaneMain tabbedPaneMain) {
		this.tabbedPaneMain = tabbedPaneMain;
	}
	
	
}
