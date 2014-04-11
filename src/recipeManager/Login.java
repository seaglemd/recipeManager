package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Login {
	
	private JPanel loginPanel;
	private Color bgColor = new Color(255, 255, 255);
	
	protected JLabel goLabel;
	private ImageIcon goIcon;
	private ImageIcon goIconO;
	
	protected JLabel newUserLabel;
	private ImageIcon newUserIcon;
	private ImageIcon newUserIconO;
	
	private JLabel turkeyLabel;
	private ImageIcon turkeyIcon = new ImageIcon("src/turkey.gif");
	
	private JComboBox userList;

	private int currentStage = 0;
	
	private String[] users = {"Matt","Andy"};
	
	public JPanel getLoginPanel() {		
		
		loginPanel = createRectPanel(680, 670);
		loginPanel.setBackground(bgColor);
		loginPanel.setBorder(new TitledBorder("Login"));
		userList = new JComboBox(users);
		turkeyLabel = new JLabel(turkeyIcon);
		GridBagConstraints p = new GridBagConstraints();
		goButton();
		newUserButton();
		p.gridx = 0;
		p.gridy = 0;
		p.anchor = GridBagConstraints.CENTER;
		
		loginPanel.add(turkeyLabel);
		p.gridx = 0;
		p.gridy = 1;
		loginPanel.add(userList);
		p.gridx = 1;
		p.gridy = 1;
		loginPanel.add(goLabel, p);
		p.gridx = 1;
		p.gridy = 2;
		loginPanel.add(newUserLabel, p);	
		
		return loginPanel;
	}
	

	public int getStage() {
		return currentStage;
	}
	
	private void goButton() {
		goIcon = new ImageIcon("src/go.gif");
		goIconO = new ImageIcon("src/goO.gif");
		goLabel = new JLabel(goIcon);		
			
		goLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goLabel.setIcon(goIconO);			
			}
		});
			
		goLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				goLabel.setIcon(goIcon);
			}
		});		
		
	}
	
	private void newUserButton() {
		newUserIcon = new ImageIcon("src/newUser.gif");
		newUserIconO = new ImageIcon("src/newUserO.gif");
		newUserLabel = new JLabel(newUserIcon);		
			
		newUserLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newUserLabel.setIcon(newUserIconO);			
			}
		});
			
		newUserLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				newUserLabel.setIcon(newUserIcon);
			}
		});		
		
	}
	public JPanel createRectPanel (int x, int y) {
		
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(new GridBagLayout());
		tempPanel.setMinimumSize(new Dimension(x,y));
		tempPanel.setMaximumSize(new Dimension(x,y));
		tempPanel.setPreferredSize(new Dimension(x,y));
	    
		return tempPanel;
			
	}

}
