package recipeManager;

import javax.swing.*;

public class Recipe {

	private String title;
	private String mainIngredient;
	private String[][][] ingredients;
	private String[][] alternativeIngredients;
	private String instructions;
	private String prepTime;
	private String category;
	private String[] subCategory;
	private String[][] comments;
	private Ranking ranking;
	private ImageIcon[] image;
	
	public Recipe(String newTitle, String newMainIngredient, String[][][] newIngredients, String[][] newAlternativeIngredients,
					String newInstructions, String newPrepTime, String newCategory, String[] newSubCategory, ImageIcon[] newImage) {
		
	}
	
	public void setTitle(String setTitle) {
		title = setTitle;		
	}
	
	public void setMainIngredient(String setMainIngredient) {
		mainIngredient = setMainIngredient;
	}
	
	public void setIngredients(String[][][] setIngredients) {
		
	}
	
	public void setAlternativeIngredients(String [][] setAlternativeIngredients) {
		
	}
	
	public void setInstructions(String setInstructions) {
		instructions = setInstructions;		
	}
	
	public void setPrepTime(String setPrepTime) {
		prepTime = setPrepTime;
	}
	
	public void setCategory(String[] setCategory) {
		
	}
	
	public void setSubCategory(String[] setSubCategory) {
		
	}
	
	public void setComments(String[][] setComments) {
		
	}
	
	public void setRanking(Ranking setRanking) {
		ranking = setRanking;
	}
	
	public void setImage(ImageIcon[] setImage) {
		
	}
}
