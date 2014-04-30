package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ViewRecipies {
	
		private JPanel viewRecipiesPanel;
		private Color bgColor = new Color(255, 255, 255);
		
		public JPanel getViewRecipiesPanel() {
			
			viewRecipiesPanel = createRectPanel(480,400);
			viewRecipiesPanel.setBackground(bgColor);
			viewRecipiesPanel.setBorder(new TitledBorder("View Recipes"));
			return viewRecipiesPanel;
		}
		
		public void viewRecipe(Recipe viewRecipe) {
			JLabel title = new JLabel(viewRecipe.getTitle());
			JLabel category = new JLabel(viewRecipe.getCategory());
			JLabel mainIngredient = new JLabel(viewRecipe.getMainIngredient());
			String ingredients = "";
			for(int i = 0; i < viewRecipe.getIngredientNumber(); i++) {
				ingredients += viewRecipe.getIngredient(i) + " " + viewRecipe.getAmount(i) + "\n";
			}
			JLabel ingredientLabel = new JLabel(ingredients);
			JLabel instructions = new JLabel(viewRecipe.getInstructions());
			
			viewRecipiesPanel.add(title);
			viewRecipiesPanel.add(category);
			viewRecipiesPanel.add(mainIngredient);
			viewRecipiesPanel.add(instructions);
			viewRecipiesPanel.validate();
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
