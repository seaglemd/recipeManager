package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.util.*;

public class SelectRecipe {
	
	private JPanel selectRecipePanel;
	private Color bgColor = new Color(255, 255, 255);
	private ArrayList<JLabel> recipeLabels = new ArrayList<JLabel>();
	
	public JPanel getSelectRecipePanel() {
		
		selectRecipePanel = createRectPanel(200, 400);
		selectRecipePanel.setBackground(bgColor);
		selectRecipePanel.setBorder(new TitledBorder("Meals"));
		return selectRecipePanel;
		
	}
	
	public void addSelectedRecipesToPanel(ArrayList<Recipe> selectedRecipes) {
		for(int i = 0; i < selectedRecipes.size(); i++) {
			recipeLabels.add(new JLabel(selectedRecipes.get(i).getTitle()));
		}
		for(int i = 0; i < recipeLabels.size(); i++) {
			recipeLabels.get(i).setSize(new Dimension(80, 100));
			recipeLabels.get(i).setPreferredSize(new Dimension(100, 50));
			recipeLabels.get(i).setBorder(BorderFactory.createLineBorder(Color.blue));
			selectRecipePanel.add(recipeLabels.get(i));
		}
		selectRecipePanel.validate();
	}
	
	public JPanel setSelectRecipePanelDimensions() {
		selectRecipePanel.setSize(new Dimension(200, 670));
		selectRecipePanel.setMinimumSize(new Dimension(200, 670));
		selectRecipePanel.setMaximumSize(new Dimension(200, 670));
		selectRecipePanel.setPreferredSize(new Dimension(200, 670));
		return selectRecipePanel;
	}
	
	public JPanel createRectPanel (int x, int y) {
		
		JPanel tempPanel = new JPanel(new GridBagLayout());
		tempPanel.setMinimumSize(new Dimension(x,y));
		tempPanel.setMaximumSize(new Dimension(x,y));
		tempPanel.setPreferredSize(new Dimension(x,y));
	    
		return tempPanel;
			
	}

}
