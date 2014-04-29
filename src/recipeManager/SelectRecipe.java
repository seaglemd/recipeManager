package recipeManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import java.util.*;

public class SelectRecipe {
	
	private JPanel selectRecipePanel;
	private JPanel insidePanel;	
	
	private int gBRows;		
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private Color bgColor = new Color(255, 255, 255);
	private ArrayList<JLabel> recipeLabels = new ArrayList<JLabel>();
	
	public JPanel getSelectRecipePanel() {
		
		selectRecipePanel = new JPanel();
		insidePanel = new JPanel();
		selectRecipePanel.setLayout(new BorderLayout());
		selectRecipePanel.setPreferredSize(new Dimension(200, 670));		
				
		insidePanel.setBorder(BorderFactory.createLineBorder(Color.blue));		
		
		selectRecipePanel.setBackground(bgColor);
		selectRecipePanel.setBorder(new TitledBorder("Meals"));
		selectRecipePanel.add(insidePanel, BorderLayout.PAGE_START);
		
		insidePanel.validate();		
		selectRecipePanel.validate();
		
		return selectRecipePanel;
		
	}
	//adds the selected recipes to the selection panel
	public void addSelectedRecipesToPanel(ArrayList<Recipe> selectedRecipes) {		
		gBRows = 0;
		insidePanel.setLayout(new GridLayout(selectedRecipes.size(),1));
		for(int i = 0; i < selectedRecipes.size(); i++) {
			recipeLabels.add(new JLabel(selectedRecipes.get(i).getTitle()));
		}
		for(int i = 0; i < recipeLabels.size(); i++) {		
			
			recipeLabels.get(i).setPreferredSize(new Dimension(100, 100));
			//recipeLabels.get(i).setBorder(BorderFactory.createLineBorder(Color.blue));			
			insidePanel.add(recipeLabels.get(i));
			gBRows++;
			gbc.gridy = gBRows;
		}
		//insidePanel.setPreferredSize(insidePanel.getPreferredSize());
		insidePanel.validate();
		selectRecipePanel.validate();
	}
	
	public JPanel setSelectRecipePanelDimensions() {
		selectRecipePanel.setSize(new Dimension(200, 670));
		selectRecipePanel.setMinimumSize(new Dimension(200, 670));
		selectRecipePanel.setMaximumSize(new Dimension(200, 670));
		selectRecipePanel.setPreferredSize(new Dimension(200, 670));
		return selectRecipePanel;
	}
}
