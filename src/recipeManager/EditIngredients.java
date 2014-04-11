package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class EditIngredients {
	//mhmmm
	//added code
	//the bestestcode that never worked
	private JPanel editIngredientsPanel;
	private Color bgColor = new Color(255, 255, 255);
	
	public JPanel getEditIngredientsPanel() {
		
		editIngredientsPanel = createRectPanel(680, 270);
		editIngredientsPanel.setBackground(bgColor);
		editIngredientsPanel.setBorder(new TitledBorder("Manage Ingredients"));
		return editIngredientsPanel;
		
	}
	public JPanel createRectPanel (int x, int y) {
		
		JPanel tempPanel = new JPanel(new GridBagLayout());
		tempPanel.setMinimumSize(new Dimension(x,y));
		tempPanel.setMaximumSize(new Dimension(x,y));
		tempPanel.setPreferredSize(new Dimension(x,y));
	    
		return tempPanel;
			
	}
}
