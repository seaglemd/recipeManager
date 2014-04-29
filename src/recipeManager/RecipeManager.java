package recipeManager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class RecipeManager {
	private JFrame frame;
	
	private int stage = 1;
	
	/*actual panel to add*/
	JPanel selectRecipe;
	JPanel viewRecipies;
	JPanel editIngredients;
	JPanel addRecipe;
	
	/*button images*/
	private JLabel closeLabel;
	private ImageIcon closeIcon;
	private ImageIcon closeIconO;
	
	private JLabel newRecipeLabel;
	private ImageIcon newRecipeIcon;
	private ImageIcon newRecipeIconO;	
	/*main color for the panels/frame*/
	private Color bgColor = new Color(255, 255, 255);
	
	/*classes which contain the panels for each and their names*/
	EditIngredients editIngredientsPanel;
	ViewRecipies viewRecipiesPanel;
	SelectRecipe selectRecipePanel;
	AddRecipe addRecipePanel;
		
	public RecipeManager() {
		createWindow();
	}
		
	public void createWindow() {
			 
		//Create and set up the window. 
		frame = new JFrame("Recipe Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*initialize classes for each section*/
		editIngredientsPanel = new EditIngredients();
		viewRecipiesPanel = new ViewRecipies();
		selectRecipePanel = new SelectRecipe();
		addRecipePanel = new AddRecipe();
		 
		/*display the main frame and set the size and bgcolor etc*/
		frame.setSize(820,700);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(bgColor);	       
		frame.setVisible(true);
		
	    /*get the returned panel from each class and place it into
	     * the panel to be placed on frame
	     */
		selectRecipe = selectRecipePanel.getSelectRecipePanel();	
		viewRecipies = viewRecipiesPanel.getViewRecipiesPanel();
		editIngredients = editIngredientsPanel.getEditIngredientsPanel();
		addRecipe = addRecipePanel.getAddRecipePanel();
		
		/*set the initial stage (should be 1)*/
		setPanelStage(stage);
	}
	
	private void setPanelStage(int stage) {
		
		
		if(stage == 1) {
		
			/*add main buttons to the top of the panel*/
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
			
			/*add recipe selection panel to the frame*/
			selectRecipe = selectRecipePanel.setSelectRecipePanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			
			/*add viewrecipies panel to the frame*/
			viewRecipies = viewRecipiesPanel.setViewRecipiesPanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(viewRecipies, c);
			/*refresh the panels and frame and place the layout*/
			frame.getContentPane().doLayout();
		}
		
		if(stage == 2) {
			/*fill out the top of the frame again for buttons like close etc*/
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
			 	
			/*adding the select recipe panel*/
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			

			/*adding the viewrecipies panel*/		
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(viewRecipies, c); 			       

			/*add the editingredients panel*/
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 2;
			frame.add(editIngredients, c);
			
			/*do the frame layout etc*/
			frame.getContentPane().doLayout();
		}
		
		if(stage == 3) {
			//add main buttons to the top of the panel
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
			
			//add recipe selection panel to the frame
			selectRecipe = selectRecipePanel.setSelectRecipePanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 1;
			frame.add(selectRecipe, c);			
			//add viewrecipies panel to the frame
		
			addRecipe = addRecipePanel.setAddRecipePanelDimensions();
			c.fill = GridBagConstraints.HORIZONTAL;		
			c.gridx = 1;
			c.gridy = 1;
			frame.add(addRecipe, c);
			//refresh the panels and frame and place the layout
			frame.getContentPane().doLayout();
		}
	
	}
	
			
	private void closeButton() {		
	/*adds listeners for the close button*/
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
	/*adds listeners for the newrecipe button*/
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
				stage = 3;
				frame.getContentPane().removeAll();
				frame.validate();
				frame.repaint();
				setPanelStage(stage);
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