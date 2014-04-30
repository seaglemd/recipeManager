package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

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
	
		private JPanel viewRecipiesPanel;
		private Color bgColor = new Color(255, 255, 255);
		
		public JPanel getViewRecipiesPanel() {
			
			viewRecipiesPanel = createRectPanel(480,400);
			viewRecipiesPanel.setBackground(bgColor);
			viewRecipiesPanel.setBorder(new TitledBorder("View Recipes"));
			return viewRecipiesPanel;
		}
		public void emptyPanel() {
			if(viewRecipiesPanel.getComponentCount() > 0) {
			viewRecipiesPanel.remove(title);
			viewRecipiesPanel.remove(category);
			viewRecipiesPanel.remove(mainIngredient);
			viewRecipiesPanel.remove(ingredientLabel);
			viewRecipiesPanel.remove(instructions);
			viewRecipiesPanel.validate();
			viewRecipiesPanel.repaint();
			}
		}
		public void viewRecipe(Recipe viewRecipe) {
			title = new JLabel(viewRecipe.getTitle());
			category = new JLabel(viewRecipe.getCategory());
			mainIngredient = new JLabel(viewRecipe.getMainIngredient());
			ingredients = "";
			for(int i = 0; i < viewRecipe.getIngredientNumber(); i++) {
				ingredients += viewRecipe.getIngredient(i) + " " + viewRecipe.getAmount(i) + "\n";
			}
			ingredientLabel = new JLabel(ingredients);
			instructions = new JLabel(viewRecipe.getInstructions());
			
			viewRecipiesPanel.add(title);
			viewRecipiesPanel.add(category);
			viewRecipiesPanel.add(mainIngredient);
			viewRecipiesPanel.add(ingredientLabel);
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
