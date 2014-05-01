package recipeManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ViewRecipies {
		
		private String ingredients;
		private JLabel instructions;
		private JLabel recipeImage;
		private JLabel recipeLabel;
		private JLabel comment;
		protected JLabel commentLabel;
		private JLabel comments;
		
		private JLabel nickRateLabel;
		protected JLabel nickLabel1;
		protected JLabel nickLabel2;
		protected JLabel nickLabel3;
		protected JLabel nickLabel4;
		protected JLabel nickLabel5;
	
		private ImageIcon nick;
		private ImageIcon nickO;
		
		private ImageIcon commentN;
		private ImageIcon commentO;
		
		private JTextField commentField;
		
		private Recipe viewableRecipe;
		private JPanel viewRecipiesPanel;
		private Color bgColor = new Color(255, 255, 255);
		
		public JPanel getViewRecipiesPanel() {
			
			viewRecipiesPanel = createRectPanel(600,670);
			viewRecipiesPanel.setBackground(bgColor);
			viewRecipiesPanel.setBorder(new TitledBorder("View Recipes"));
			return viewRecipiesPanel;
		}
		public void emptyPanel() {			
			if(viewRecipiesPanel.getComponentCount() > 0 ){
				viewRecipiesPanel.removeAll();
				viewRecipiesPanel.validate();
				viewRecipiesPanel.repaint();
			}
		}
		public void viewRecipe(Recipe viewRecipe) {
			ingredients = "";
			viewableRecipe = viewRecipe;
			comments = new JLabel();
			comments.setPreferredSize(new Dimension(480,200));
			comments.setHorizontalAlignment(JLabel.LEFT);
			comments.setHorizontalTextPosition(JLabel.LEFT);
			comments.setVerticalAlignment(JLabel.TOP);
			comments.setVerticalTextPosition(JLabel.TOP);
			fillComments();
			nick = new ImageIcon("src/nickRate.gif");
			nickO = new ImageIcon("src/nickRateO.gif");
			
			commentN = new ImageIcon("src/comment.gif");
			commentO = new ImageIcon("src/commentO.gif");
			
			commentLabel = new JLabel(commentN);
			
			comment = new JLabel("Comment: ");
			commentField = new JTextField();
			commentField.setColumns(30);
			
			
			nickRateLabel = new JLabel("Rate: ");
			nickLabel1 = new JLabel(nick);
			nickLabel2 = new JLabel(nick);
			nickLabel3 = new JLabel(nick);
			nickLabel4 = new JLabel(nick);
			nickLabel5 = new JLabel(nick);
			commentButtonListener();
			viewRecipiesPanel.setLayout(new BorderLayout());
			JPanel westAlignment = new JPanel(new BorderLayout());

			JPanel insidePanel = new JPanel(new GridBagLayout());
			JPanel insideInsidePanel = new JPanel(new FlowLayout());
			JPanel instructionPanel = new JPanel(new BorderLayout());
			JPanel alternateIngredientPanel = new JPanel(new BorderLayout());
			JPanel ratingPanel = new JPanel(new FlowLayout());			
			
			JPanel commentPanel = new JPanel(new FlowLayout());		
			commentPanel.setBackground(bgColor);
			JScrollPane commentSPanel = new JScrollPane(commentPanel);
			commentSPanel.setPreferredSize(new Dimension(530, 200));
			commentSPanel.setBackground(bgColor);
			
			ratingPanel.setPreferredSize(new Dimension(480, 80));
			ratingPanel.setBackground(bgColor);
			addNickListener();
			ratingPanel.add(nickRateLabel);
			ratingPanel.add(nickLabel1);
			ratingPanel.add(nickLabel2);
			ratingPanel.add(nickLabel3);
			ratingPanel.add(nickLabel4);
			ratingPanel.add(nickLabel5);
			ratingPanel.validate();
			ratingPanel.repaint();
			addNickListener();
			
			JLabel alternateIngredientInstructions = new JLabel();
			
			westAlignment.setBackground(bgColor);
			insidePanel.setBackground(bgColor);
			insideInsidePanel.setBackground(bgColor);
			instructionPanel.setBackground(bgColor);
			
			viewRecipiesPanel.add(westAlignment, BorderLayout.NORTH);
			westAlignment.add(insidePanel, BorderLayout.WEST);
			String scoreString;
			
			if(viewRecipe.getImage() != null) {
				recipeImage = new JLabel(viewRecipe.getImage());
				recipeImage.setSize(new Dimension(200,200));
				recipeImage.setPreferredSize(new Dimension(200,200));
				recipeImage.setMinimumSize(new Dimension(200,200));
			}
			else{
				recipeImage = new JLabel(new ImageIcon("src/noImage.gif"));
				recipeImage.setSize(new Dimension(200,200));
				recipeImage.setPreferredSize(new Dimension(200,200));
				recipeImage.setMinimumSize(new Dimension(200,200));
			}
			if(viewRecipe.getVotes().size() > 0)
			{
				ArrayList<Double> votes = viewRecipe.getVotes();
				
				scoreString = Double.toString(computeAverage(votes));
			}
			else {
				scoreString = "No rating yet!";
			}
				
			
			for(int i = 0; i < viewRecipe.getIngredientNumber(); i++) {
				ingredients += " " + (i+1) + ". " + viewRecipe.getIngredient(i) + " - " + viewRecipe.getAmount(i) + "<br>";
			}
			
			String recipeString = "<html><head></head><body><font color=\"red\"><h2>" + viewRecipe.getTitle() + "</h2></font> Category: "
					+ viewRecipe.getCategory() + "<br>PrepTime: " + viewRecipe.getPrepTime() + "<br>Rating: " + scoreString + "<br>Main Ingredient: " + viewRecipe.getMainIngredient() + "<br><br>Ingredients:<br>" + ingredients + "</body></html>";
					
			
			instructions = new JLabel("<html><head></head><body>Instructions: <br>" + viewRecipe.getInstructions() + "</body></html>");
			instructions.setMaximumSize(new Dimension(480,300));
			instructions.setPreferredSize(new Dimension(480,90));
			instructions.setVerticalTextPosition(JLabel.TOP);
			instructions.setVerticalAlignment(JLabel.TOP);
			recipeLabel = new JLabel(recipeString);
			alternateIngredientInstructions.setText("<html><body>Alternate Ingredient Instructions:<br> " + viewRecipe.getAlternateIngredients() + "<br></body></html>");
			alternateIngredientInstructions.setMaximumSize(new Dimension(480,300));
			alternateIngredientInstructions.setPreferredSize(new Dimension(480,60));
			alternateIngredientInstructions.setVerticalTextPosition(JLabel.TOP);
			alternateIngredientInstructions.setVerticalAlignment(JLabel.TOP);
			
			instructionPanel.add(instructions, BorderLayout.NORTH);
			//instructionPanel.setBackground(Color.cyan);
			alternateIngredientPanel.setBackground(Color.white);
			alternateIngredientPanel.add(alternateIngredientInstructions);
			commentPanel.add(comment);
			commentPanel.add(commentField);
			commentPanel.add(commentLabel);
			commentPanel.add(comments);
			commentPanel.setPreferredSize(new Dimension(480, 500));
			commentPanel.setMaximumSize(new Dimension(480,4000));
			commentPanel.validate();
			commentPanel.repaint();
			
			commentSPanel.validate();
			commentSPanel.repaint();
			
			
			instructionPanel.validate();
			instructionPanel.repaint();
			
			GridBagConstraints gc = new GridBagConstraints();	
			//gc.fill = GridBagConstraints.PAGE_START;
			gc.anchor = GridBagConstraints.WEST;
			//System.out.println(recipeString);
			gc.gridx = 0;
			gc.gridy = 0;			
			insidePanel.add(recipeImage, gc);
			
			gc.gridx = 1;
			insideInsidePanel.add(recipeLabel);		
			insideInsidePanel.validate();
			insideInsidePanel.repaint();
			insidePanel.add(insideInsidePanel,gc);
			
			gc.gridwidth = 2;
			gc.gridy = 1;
			gc.gridx = 0;
			gc.anchor = GridBagConstraints.NORTH;
			insidePanel.add(instructionPanel, gc);	
			
			gc.gridy = 2;
			insidePanel.add(alternateIngredientPanel, gc);
			
			gc.gridy = 3;
			insidePanel.add(ratingPanel, gc);
			
			gc.gridy = 4;
			insidePanel.add(commentSPanel, gc);
			
			westAlignment.validate();
			westAlignment.repaint();
			insidePanel.validate();
			insidePanel.repaint();
			viewRecipiesPanel.validate();
			viewRecipiesPanel.repaint();
		}
		
		public void fillComments() {
			String allComments = "<html><body>";
			for(int i = (viewableRecipe.getComment().size()-1);i >= 0; i--) {
				allComments += "Comment #" + i + "<br>" + viewableRecipe.getComment().get(i);
				allComments += "<br><br>";
			}
			allComments += "</body></html>";
			comments.setText(allComments);
		}
		
		private void commentButtonListener() {		
			/*adds listeners for the close button*/
					
				commentLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						commentLabel.setIcon(commentO);			
					}
				});
					
				commentLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
						commentLabel.setIcon(commentN);
					}
				});
					
				commentLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(!commentField.getText().isEmpty()) {
							viewableRecipe.setComment(commentField.getText());
							commentField.setText("");
							viewRecipiesPanel.repaint();
						}
					}
				});
			}
		
		public void addNickListener() {
			nickLabel1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					nickLabel1.setIcon(nickO);			
				}
			});
				
			nickLabel1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					nickLabel1.setIcon(nick);
				}
			});
			nickLabel2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					nickLabel1.setIcon(nickO);
					nickLabel2.setIcon(nickO);			
				}
			});
				
			nickLabel2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					nickLabel1.setIcon(nick);
					nickLabel2.setIcon(nick);
				}
			});
			nickLabel3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					nickLabel1.setIcon(nickO);
					nickLabel2.setIcon(nickO);
					nickLabel3.setIcon(nickO);			
				}
			});
				
			nickLabel3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {					
					nickLabel1.setIcon(nick);
					nickLabel2.setIcon(nick);
					nickLabel3.setIcon(nick);
				}
			});
			nickLabel4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					nickLabel1.setIcon(nickO);
					nickLabel2.setIcon(nickO);
					nickLabel3.setIcon(nickO);
					nickLabel4.setIcon(nickO);			
				}
			});
				
			nickLabel4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					nickLabel1.setIcon(nick);
					nickLabel2.setIcon(nick);
					nickLabel3.setIcon(nick);
					nickLabel4.setIcon(nick);
					
				}
			});
			nickLabel5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					nickLabel1.setIcon(nickO);
					nickLabel2.setIcon(nickO);
					nickLabel3.setIcon(nickO);
					nickLabel4.setIcon(nickO);
					nickLabel5.setIcon(nickO);			
				}
			});
				
			nickLabel5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					nickLabel1.setIcon(nick);
					nickLabel2.setIcon(nick);
					nickLabel3.setIcon(nick);
					nickLabel4.setIcon(nick);
					nickLabel5.setIcon(nick);
					
				}
			});
				
			nickLabel1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					viewableRecipe.setVotes(1.0);
				}
			});
			nickLabel2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					viewableRecipe.setVotes(2.0);
				}
			});
			nickLabel3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					viewableRecipe.setVotes(3.0);
				}
			});
			nickLabel4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					viewableRecipe.setVotes(4.0);
				}
			});
			nickLabel5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					viewableRecipe.setVotes(5.0);
				}
			});
		}
		///public void setVotes()
		
		
		public double computeAverage(ArrayList<Double> votes) {
			double average = 0;
			for(int i = 0; i < votes.size(); i++){
				average += votes.get(i);
			}
			average = average/votes.size();
			
			return average;
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
