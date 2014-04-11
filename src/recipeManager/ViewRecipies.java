package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

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
		
		public JPanel setViewRecipiesPanelDimensions() {
			viewRecipiesPanel.setSize(new Dimension(480,670));
			viewRecipiesPanel.setMinimumSize(new Dimension(480,670));
			viewRecipiesPanel.setMaximumSize(new Dimension(480,670));
			viewRecipiesPanel.setPreferredSize(new Dimension(480,670));
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
