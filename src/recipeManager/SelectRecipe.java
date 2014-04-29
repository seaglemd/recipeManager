package recipeManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		
		insidePanel.setBackground(bgColor);		
		insidePanel.setLayout(new FlowLayout());
		insidePanel.setPreferredSize(new Dimension(195,650));
		
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
		
		for(int i = 0; i < selectedRecipes.size(); i++) {
			recipeLabels.add(new JLabel("<html>" + selectedRecipes.get(i).getTitle() + "</html>"));
			recipeLabels.get(i).setOpaque(true);
			recipeLabels.get(i).setForeground(Color.BLACK);
			recipeLabels.get(i).setBackground(Color.BLACK);
			recipeLabels.get(i).setPreferredSize(new Dimension(185, 50));
			recipeLabels.get(i).setMaximumSize(new Dimension(185, 50));
		}
		for(int i = 0; i < recipeLabels.size(); i++) {						
			insidePanel.add(recipeLabels.get(i));
			
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
	
	public void recipeMouseover() {
		
	}
	
}
