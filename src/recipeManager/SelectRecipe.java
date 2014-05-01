package recipeManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import java.util.*;

public class SelectRecipe {
	
	private JPanel selectRecipePanel;
	private JPanel insidePanel;	
	private JPanel insideSearchPanel;
	
	private ImageIcon goIcon;
	private ImageIcon goIconO;
	
	protected JTextField searchCriteria;
	protected JLabel goButton;
	protected ArrayList<JLabel> currentLabels = new ArrayList<JLabel>();
	protected ArrayList<Recipe> currentRecipes = new ArrayList<Recipe>();
	private int gBRows;		
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private Color bgColor = new Color(255, 255, 255);
	
	
	public JPanel getSelectRecipePanel() {
		addGoButtonActionListener();
		searchCriteria = new JTextField();
		searchCriteria.setColumns(10);
		selectRecipePanel = new JPanel();
		insidePanel = new JPanel();
		insideSearchPanel = new JPanel();
		insideSearchPanel.setBackground(bgColor);
		insideSearchPanel.add(searchCriteria);
		insideSearchPanel.add(goButton);
		selectRecipePanel.setLayout(new FlowLayout());
		selectRecipePanel.setPreferredSize(new Dimension(200, 670));		
		
		insidePanel.setBackground(bgColor);		
		insidePanel.setLayout(new FlowLayout());
		insidePanel.setPreferredSize(new Dimension(190,650));
		
		selectRecipePanel.setBackground(bgColor);
		selectRecipePanel.setBorder(new TitledBorder("Meals"));
		selectRecipePanel.add(insideSearchPanel);
		selectRecipePanel.add(insidePanel);
		
		insidePanel.validate();		
		selectRecipePanel.validate();
		
		return selectRecipePanel;
		
	}
	//adds the selected recipes to the selection panel
	public void addSelectedRecipesToPanel(ArrayList<Recipe> selectedRecipes) {
		if(currentRecipes.size() > 0) {
			currentRecipes.clear();
			currentLabels.clear();
		}
		for(int i = 0; i < selectedRecipes.size(); i++) {
			currentRecipes.add(selectedRecipes.get(i));
		}
		
		for(int i = 0; i <currentRecipes.size();i++) {
			currentLabels.add(new JLabel());
		}
		
		for(int i = 0; i < currentRecipes.size(); i++) {
			currentLabels.get(i).setText("<html>" + currentRecipes.get(i).getTitle() + "</html>");
			currentLabels.get(i).setOpaque(true);			
			currentLabels.get(i).setPreferredSize(new Dimension(185, 48));
			currentLabels.get(i).setMaximumSize(new Dimension(185, 48));
		}
		if(insidePanel.getComponentCount() > 0) {
			insidePanel.removeAll();
			insidePanel.validate();
		}
		for(int i = 0; i < currentLabels.size(); i++) {						
			insidePanel.add(currentLabels.get(i));
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
	
	public void addGoButtonActionListener() {
		goIcon = new ImageIcon("src/go.gif");
		goIconO = new ImageIcon("src/goO.gif");
		goButton = new JLabel(goIcon);		
			
		goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				goButton.setIcon(goIconO);			
			}
		});
			
		goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				goButton.setIcon(goIcon);
			}
		});	

	}
	
}
