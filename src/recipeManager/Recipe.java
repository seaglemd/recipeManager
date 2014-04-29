package recipeManager;

import java.util.ArrayList;

import javax.swing.*;

public class Recipe {

	private String title;
	private ArrayList<String> ingredients = new ArrayList<String>();
	private ArrayList<String> amount = new ArrayList<String>();
	private String instructions;
	private String category;
	private String mainIngredient;

	private ArrayList<String> comments = new ArrayList<String>();
	private ArrayList<String> votes = new ArrayList<String>();
	private ImageIcon image;
	
	public Recipe()
	{
		
	}
	
	public void setTitle(String setTitle) {
		title = setTitle;		
	}
	public String getTitle() {
		return title;
	}
	
	public void setIngredients(String setIngredient) {
		ingredients.add(setIngredient);
	}
	public void setAmount(String setAmount) {
		amount.add(setAmount);
	}
	public String getIngredient(int i) {
		return ingredients.get(i);
	}
	
	public String getAmount(int i) {
		return amount.get(i);
	}
	
	public void setInstructions(String setInstructions) {
		instructions = setInstructions;		
	}
	public String getInstructions() {
		return instructions;
	}
	
	public void setCategory(String setCategory) {
		category = setCategory;
	}
	public String getCategory() {
		return category;
	}
	public void setMainIngredient(String setMainIngredient) {
		mainIngredient = setMainIngredient;
	}
	public String getMainIngredient() {
		return mainIngredient;
	}
	
	public void setComments(String[][] setComments) {
		
	}

	
	public void setImage(ImageIcon[] setImage) {
		
	}
}
