package recipeManager;

import java.util.ArrayList;

import javax.swing.*;

public class Recipe {

	private String title;
	private String[][] ingredients;
	private String[][] alternativeIngredients;
	private String instructions;
	private String prepTime;
	private String category;
	private String[] subCategory;
	private String[][] comments;
	private ArrayList votes = new ArrayList();
	private ImageIcon[] image;
	
	public Recipe(String newTitle, String[][] newIngredients, String[][] newAlternativeIngredients,
					String newInstructions, String newPrepTime, String newCategory, String[] newSubCategory, ImageIcon[] newImage) {
		
	}
	
	public void setTitle(String setTitle) {
		title = setTitle;		
	}
	
	public void setIngredients(String[][] setIngredients) {
		
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

	
	public void setImage(ImageIcon[] setImage) {
		
	}
}
