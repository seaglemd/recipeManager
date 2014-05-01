package recipeManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	
		private JPanel viewRecipiesPanel;
		private Color bgColor = new Color(255, 255, 255);
		
		public JPanel getViewRecipiesPanel() {
			
			viewRecipiesPanel = createRectPanel(600,670);
			viewRecipiesPanel.setBackground(bgColor);
			viewRecipiesPanel.setBorder(new TitledBorder("View Recipes"));
			return viewRecipiesPanel;
		}
		public void emptyPanel() {
			/* if(viewRecipiesPanel.getComponentCount() > 0) {
			viewRecipiesPanel.remove(title);
			viewRecipiesPanel.remove(category);
			viewRecipiesPanel.remove(mainIngredient);
			viewRecipiesPanel.remove(ingredientLabel);
			viewRecipiesPanel.remove(instructions);
			viewRecipiesPanel.remove(score);
			viewRecipiesPanel.remove(recipeImage);
			viewRecipiesPanel.validate();
			viewRecipiesPanel.repaint(); 
			}*/
			if(viewRecipiesPanel.getComponentCount() > 0 ){
				viewRecipiesPanel.removeAll();
				viewRecipiesPanel.validate();
				viewRecipiesPanel.repaint();
			}
			}
		public void viewRecipe(Recipe viewRecipe) {
			viewRecipiesPanel.setLayout(new BorderLayout());			
			JPanel insidePanel = new JPanel(new GridBagLayout());
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
				
				score = new JLabel(Double.toString(computeAverage(votes)));
			}
			else {
				score = new JLabel("<html>no score yet</html>");
			}
			
			GridBagConstraints gc = new GridBagConstraints();			
			
			title = new JLabel("<html>" + viewRecipe.getTitle() + "</html>");
			category = new JLabel("<html>" + viewRecipe.getCategory() + "</html");
			mainIngredient = new JLabel("<html>" + viewRecipe.getMainIngredient() + "</html>");
			ingredients = "<html>";
			for(int i = 0; i < viewRecipe.getIngredientNumber(); i++) {
				ingredients += " " + (i+1) + ". " + viewRecipe.getIngredient(i) + " - " + viewRecipe.getAmount(i);
			}
			ingredients += "</html>";
			ingredientLabel = new JLabel(ingredients);
			instructions = new JLabel("<html>" + viewRecipe.getInstructions() + "</html>");
			
			gc.fill = GridBagConstraints.PAGE_START;
			gc.anchor = GridBagConstraints.FIRST_LINE_START;
			
			gc.gridheight = 4;
			gc.gridx = 0;
			gc.gridy = 0;			
			insidePanel.add(recipeImage, gc);
			
			gc.gridheight = 1;
			gc.gridx = 1;			
			insidePanel.add(title, gc);
			insidePanel.add(category, gc);
			
			gc.gridx = 1;
			gc.gridy = 1;
			insidePanel.add(score, gc);
			
			gc.gridx = 1;
			gc.gridy = 2;
			insidePanel.add(mainIngredient, gc);
			
			gc.gridx = 1;
			gc.gridy = 3;
			insidePanel.add(ingredientLabel, gc);
			
			gc.gridwidth = 2;
			gc.gridx = 0;
			gc.gridy = 4;
			insidePanel.add(instructions, gc);
			
			viewRecipiesPanel.add(insidePanel, BorderLayout.NORTH);
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
