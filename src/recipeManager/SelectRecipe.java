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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import java.util.*;

public class SelectRecipe {
	
	private JPanel selectRecipePanel;
	private JPanel insidePanel;	
	protected ArrayList<JLabel> currentLabels = new ArrayList<JLabel>();
	private int gBRows;		
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	private Color bgColor = new Color(255, 255, 255);
	
	
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
		for(int i = 0; i <selectedRecipes.size();i++) {
			currentLabels.add(new JLabel());
		}
		
		for(int i = 0; i < currentLabels.size(); i++) {
			currentLabels.get(i).setText("<html>" + selectedRecipes.get(i).getTitle() + "</html>");
			currentLabels.get(i).setOpaque(true);			
			currentLabels.get(i).setPreferredSize(new Dimension(185, 50));
			currentLabels.get(i).setMaximumSize(new Dimension(185, 50));
		}
		for(int i = 0; i < currentLabels.size(); i++) {						
			insidePanel.add(currentLabels.get(i));
			recipeMouseover(i);
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
	
	public void recipeMouseover(final int i) {		
					
			currentLabels.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					currentLabels.get(i).setBackground(new Color(0, 153, 204));
					currentLabels.get(i).setForeground(Color.white);					
				}
			});
				
			currentLabels.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					currentLabels.get(i).setBackground(Color.white);
					currentLabels.get(i).setForeground(Color.black);
				}
			});
			currentLabels.get(i).addMouseListener(new MouseAdapter() {
				//@Override
				/*public void mouseClicked(MouseEvent e) {
					
				}*/
			});			
		}
				
			
		
		
	
	
}
