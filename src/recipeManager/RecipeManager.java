package recipeManager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class RecipeManager {
	private JFrame frame;
	
	private int stage = 0;
	
	JPanel selectRecipe;
	JPanel viewRecipies;
	JPanel editIngredients;
	JPanel login;
	
	private JLabel closeLabel;
	private ImageIcon closeIcon;
	private ImageIcon closeIconO;
	
	private JLabel newRecipeLabel;
	private ImageIcon newRecipeIcon;
	private ImageIcon newRecipeIconO;	
	
	private Color bgColor = new Color(255, 255, 255);
	
	EditIngredients editIngredientsPanel;
	ViewRecipies viewRecipiesPanel;
	SelectRecipe selectRecipePanel;
	Login loginPanel;
	
		
	public RecipeManager() {
		createWindow();
	}
		
	public void createWindow() {
			 
		//Create and set up the window. 
		frame = new JFrame("Recipe Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editIngredientsPanel = new EditIngredients();
		viewRecipiesPanel = new ViewRecipies();
		selectRecipePanel = new SelectRecipe();
		loginPanel = new Login();
		 
		//Display the window. 
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(bgColor);	       
		frame.setVisible(true);
		
	      
		selectRecipe = selectRecipePanel.getSelectRecipePanel();	
		viewRecipies = viewRecipiesPanel.getViewRecipiesPanel();
		editIngredients = editIngredientsPanel.getEditIngredientsPanel();
		login = loginPanel.getLoginPanel();
		
		setPanelStage(stage);
	}
	
	private void setPanelStage(int stage) {
		
		if(stage == 0) {

			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			closeButton();
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_END;
			frame.add(closeLabel, c);
			
			loginPanelListener();
			c.anchor = GridBagConstraints.CENTER;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(login, c);
			frame.validate();
			frame.getContentPane().doLayout();
			
		}
		
		if(stage == 1) {
		
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();			
			newRecipeButton();			       
			closeButton();
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			frame.add(newRecipeLabel, c);
			c.anchor = GridBagConstraints.FIRST_LINE_END;	
			frame.add(closeLabel, c);			       
			
			selectRecipe = selectRecipePanel.setSelectRecipePanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			
	
			viewRecipies = viewRecipiesPanel.setViewRecipiesPanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(viewRecipies, c);
			      
			frame.getContentPane().doLayout();
		}
		
		if(stage == 2) {
			
			frame.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();			
			newRecipeButton();			
			closeButton();
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 0;
			c.anchor = GridBagConstraints.FIRST_LINE_START;
			frame.add(newRecipeLabel, c);
			c.anchor = GridBagConstraints.FIRST_LINE_END;	       
			frame.add(closeLabel, c);
			//frame.validate();			       
			 	
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			

					
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(viewRecipies, c); 			       

				
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 2;
			frame.add(editIngredients, c);
			      
			frame.getContentPane().doLayout();
		}
	
	}
	
	private void loginPanelListener() {
		loginPanel.goLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stage = 1;
				frame.remove(login);
				frame.remove(closeLabel);
				setPanelStage(stage);
			}
		});
		
		loginPanel.newUserLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//newLoginPanelhere
				stage = 1;
				frame.remove(login);
				frame.remove(closeLabel);
				setPanelStage(stage);
			}
		});
	}
			
	private void closeButton() {		
	
		closeIcon = new ImageIcon("src/close.gif");
		closeIconO = new ImageIcon("src/closeO.gif");
		closeLabel = new JLabel(closeIcon);		
			
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeLabel.setIcon(closeIconO);			
			}
		});
			
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				closeLabel.setIcon(closeIcon);
			}
		});
			
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
	}
	
	private void newRecipeButton() {
		newRecipeIcon = new ImageIcon("src/newRecipe.gif");
		newRecipeIconO = new ImageIcon("src/newRecipeO.gif");
		newRecipeLabel = new JLabel(newRecipeIcon);		
			
		newRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				newRecipeLabel.setIcon(newRecipeIconO);			
			}
		});
			
		newRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				newRecipeLabel.setIcon(newRecipeIcon);
			}
		});
			
		newRecipeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		
	}	
		
	public JPanel createRectPanel (int x, int y) {
	
		JPanel tempPanel = new JPanel(new GridBagLayout());
		tempPanel.setMinimumSize(new Dimension(x,y));
		tempPanel.setMaximumSize(new Dimension(x,y));
		tempPanel.setPreferredSize(new Dimension(x,y));
	    
		return tempPanel;
			
	}
}