package gym.view.frame;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import gym.model.GymWatchModel;

public class TabbedPaneMain extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	private Frame frame;
	private Check checking;
	private Registration registration;
	private Managment managment;
	private GymWatchModel model;
	private JTabbedPane holder;
	
	
	
	public TabbedPaneMain(Frame frame, GymWatchModel model){
		this.frame = frame;
		this.model = model;
		createPartControl();
	}
	
	
	private void createPartControl(){
		new JScrollPane();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		holder = new JTabbedPane();
		
		registration = new Registration(frame, holder);
		checking = new Check(frame, holder);
		managment = new Managment(frame, holder);
		
		
		holder.add(registration.getLbl(), registration.getPanel());

		holder.add(checking.getLbl(), checking.getPanel());

		holder.add(managment.getLbl(), managment.getPanel());
		
		setPreferredSize(new Dimension(700, 700));
		add(holder);
		
		
	}
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
}
