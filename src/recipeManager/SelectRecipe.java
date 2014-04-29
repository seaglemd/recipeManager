package recipeManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import java.util.*;

public class SelectRecipe {
	
	private JPanel selectRecipePanel;
	private JPanel insidePanel;
	private GridBagLayout sRPL = new GridBagLayout();
	private GridBagConstraints sRPLC = new GridBagConstraints();
	
	private int gBRows = 0;		
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private Color bgColor = new Color(255, 255, 255);
	private ArrayList<JLabel> recipeLabels = new ArrayList<JLabel>();
	
	public JPanel getSelectRecipePanel() {
		
		selectRecipePanel = new JPanel();
		insidePanel = new JPanel();
		selectRecipePanel.setLayout(sRPL);
		selectRecipePanel.setPreferredSize(new Dimension(200, 670));
		insidePanel.setLayout(gbl);		
		insidePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		sRPLC.anchor = GridBagConstraints.PAGE_START;
		sRPLC.fill = GridBagConstraints.NORTH;
		sRPLC.gridx = 0;
		sRPLC.gridy = 0;
		
		gbc.anchor = GridBagConstraints.PAGE_START;		
		gbc.fill = GridBagConstraints.FIRST_LINE_START;
		gbc.gridx = 0;
		gbc.gridy = gBRows;		
		
		selectRecipePanel.setBackground(bgColor);
		selectRecipePanel.setBorder(new TitledBorder("Meals"));
		selectRecipePanel.add(insidePanel, sRPLC);
		
		insidePanel.validate();		
		selectRecipePanel.validate();
		
		return selectRecipePanel;
		
	}
	//adds the selected recipes to the selection panel
	public void addSelectedRecipesToPanel(ArrayList<Recipe> selectedRecipes) {		
		
		for(int i = 0; i < selectedRecipes.size(); i++) {
			recipeLabels.add(new JLabel(selectedRecipes.get(i).getTitle()));
		}
		for(int i = 0; i < recipeLabels.size(); i++) {
			recipeLabels.get(i).setSize(new Dimension(80, 100));
			recipeLabels.get(i).setPreferredSize(new Dimension(100, 50));
			//recipeLabels.get(i).setBorder(BorderFactory.createLineBorder(Color.blue));			
			insidePanel.add(recipeLabels.get(i),gbc);
			gBRows++;
		}
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
