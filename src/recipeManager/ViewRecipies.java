package recipeManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ViewRecipies {
		
		private JLabel title;
		private JLabel category;
		private JLabel mainIngredient;
		private String ingredients;
		private JLabel ingredientLabel;
		private JLabel instructions;
		private JLabel score;
		private JLabel recipeImage;
		private JLabel recipeLabel;
	
		private JPanel viewRecipiesPanel;
		private Color bgColor = new Color(255, 255, 255);
		
		public JPanel getViewRecipiesPanel() {
			
			viewRecipiesPanel = createRectPanel(600,670);
			viewRecipiesPanel.setBackground(bgColor);
			viewRecipiesPanel.setBorder(new TitledBorder("View Recipes"));
			return viewRecipiesPanel;
		}
		public void emptyPanel() {			
			if(viewRecipiesPanel.getComponentCount() > 0 ){
				viewRecipiesPanel.removeAll();
				viewRecipiesPanel.validate();
				viewRecipiesPanel.repaint();
			}
			}
		public void viewRecipe(Recipe viewRecipe) {
			ingredients = "";
			viewRecipiesPanel.setLayout(new BorderLayout());
			JPanel westAlignment = new JPanel(new BorderLayout());
			//GridBagConstraints vRPC = new GridBagConstraints();
			//vRPC.anchor = GridBagConstraints.NORTH;
			//vRPC.fill = GridBagConstraints.HORIZONTAL;
			//vRPC.gridx = 0;
			//vRPC.gridy = 0;
			JPanel insidePanel = new JPanel(new GridBagLayout());
			JPanel insideInsidePanel = new JPanel(new FlowLayout());
			
			viewRecipiesPanel.add(westAlignment, BorderLayout.NORTH);
			westAlignment.add(insidePanel, BorderLayout.WEST);
			String scoreString;
			
			if(viewRecipe.getImage() != null) {
				recipeImage = new JLabel(viewRecipe.getImage());
			}
			else{
				recipeImage = new JLabel(new ImageIcon("src/noImage.gif"));
				recipeImage.setSize(new Dimension(200,200));
				recipeImage.setPreferredSize(new Dimension(200,200));
				recipeImage.setMinimumSize(new Dimension(200,200));
			}
			if(viewRecipe.getVotes().size() > 0)
			{
				ArrayList<Double> votes = viewRecipe.getVotes();
				
				scoreString = Double.toString(computeAverage(votes));
			}
			else {
				scoreString = "no score yet";
			}
			
					
			
			
			
			for(int i = 0; i < viewRecipe.getIngredientNumber(); i++) {
				ingredients += " " + (i+1) + ". " + viewRecipe.getIngredient(i) + " - " + viewRecipe.getAmount(i) + "<br>";
			}
			
			String recipeString = "<html><font color=red><h2>" + viewRecipe.getTitle() + "</h2></font> - "
					+ viewRecipe.getCategory() + "<br>" + scoreString + "<br>" + viewRecipe.getMainIngredient() + "<br>" + ingredients + "</html>";
			instructions = new JLabel("<html>" + viewRecipe.getInstructions() + "</html>");
			recipeLabel = new JLabel(recipeString);
			
			GridBagConstraints gc = new GridBagConstraints();	
			//gc.fill = GridBagConstraints.PAGE_START;
			gc.anchor = GridBagConstraints.WEST;
			//System.out.println(recipeString);
			gc.gridx = 0;
			gc.gridy = 0;			
			insidePanel.add(recipeImage, gc);
			
			gc.gridx = 1;
			insideInsidePanel.add(recipeLabel);		
			insideInsidePanel.validate();
			insideInsidePanel.repaint();
			insidePanel.add(insideInsidePanel,gc);
			
			//gc.gridx = 0;
			//gc.gridy = 1;
			//gc.gridwidth = 2;
			//insidePanel.add(instructions, gc);
			
			
			
			
			westAlignment.validate();
			westAlignment.repaint();
			insidePanel.validate();
			insidePanel.repaint();
			viewRecipiesPanel.validate();
			viewRecipiesPanel.repaint();
		}
		
		public double computeAverage(ArrayList<Double> votes) {
			double average = 0;
			for(int i = 0; i < votes.size(); i++){
				average += votes.get(i);
			}
			average = average/votes.size();
			
			return average;
		}
		public JPanel setViewRecipiesPanelDimensions() {
			viewRecipiesPanel.setSize(new Dimension(600,670));
			viewRecipiesPanel.setMinimumSize(new Dimension(600,670));
			viewRecipiesPanel.setMaximumSize(new Dimension(600,670));
			viewRecipiesPanel.setPreferredSize(new Dimension(600,670));
			return viewRecipiesPanel;
		}
		
		public JPanel createRectPanel (int x, int y) {
		
			JPanel tempPanel = new JPanel(new GridBagLayout());
			tempPanel.setMinimumSize(new Dimension(x,y));
			tempPanel.setMaximumSize(new Dimension(x,y));
			tempPanel.setPreferredSize(new Dimension(x,y));
	    
			return tempPanel;
			
		}

}
