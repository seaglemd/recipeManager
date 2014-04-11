package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SelectRecipe {
	
	private JPanel selectRecipePanel;
	private Color bgColor = new Color(255, 255, 255);
	
	public JPanel getSelectRecipePanel() {
		
		selectRecipePanel = createRectPanel(200, 400);
		selectRecipePanel.setBackground(bgColor);
		selectRecipePanel.setBorder(new TitledBorder("Meals"));
		return selectRecipePanel;
		
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
