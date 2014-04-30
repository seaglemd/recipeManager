package recipeManager;

import java.util.ArrayList;

import javax.swing.*;

import java.io.IOException;
import java.io.Serializable;

public class Recipe implements Serializable
{

	private String title;
	private ArrayList<String> ingredients = new ArrayList<String>();
	private ArrayList<String> amount = new ArrayList<String>();
	private String instructions;
	private String category;
	private String mainIngredient;
	
	private ArrayList<String> comments = new ArrayList<String>();
	private ArrayList<String> votes = new ArrayList<String>();
	private ImageIcon image;
	
	
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
	
	public static void writeToFile(ArrayList<Recipe> recipeList) throws ClassNotFoundException {
		try
		{
			WriteOut.writeData("recipes", recipeList);
		}catch(IOException e)
		{
			
		}
		
		
	}
	
	public static ArrayList<Recipe> readFromFile() throws IOException, ClassNotFoundException {
		ArrayList<Recipe> tempRecipeList = new ArrayList<Recipe>();
		tempRecipeList = ReadIn.readData("recipes");
		
		return tempRecipeList;
	}
	
	public void setComments(String[][] setComments) {
		
	}

	
	public void setImage(ImageIcon[] setImage) {
		
	}
	
	public int getIngredientNumber(){
		return ingredients.size();
	}
}
